package SocketProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public Server(int port) {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            Scanner sin = new Scanner(System.in);
            String line = "", str2 = "";

            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println("Client says: " + line);

                } catch (IOException i) {
                    System.out.println(i);
                }
                System.out.println("Enter message for clinet");
                str2 = sin.next();
                out.writeUTF(str2);
                out.flush();
            }

            System.out.println("Closing connection");

            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}
