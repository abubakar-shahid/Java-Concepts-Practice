/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author anosha khan
 */
public class Serial implements Serializable {
    private static final long serialVersionUID = 1L;
    static int i = 0;
    int id;
    transient String pass;
    String name;

    Serial(int i, String p, String n) {
        i = i + 10;
        id = i;
        name = n;
        pass = p;
        System.out.println("Constructor called");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serial ss = new Serial(12, "1234", "ali");
        Serial s1 = new Serial(12, "22", "343");
        try {
            FileOutputStream fout = new FileOutputStream("F.txt");
            ObjectOutputStream o = new ObjectOutputStream(fout);
            o.writeObject(ss);
            o.flush();
            o.close();
            System.out.println("success");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileInputStream fin = new FileInputStream("F.txt");
        ObjectInputStream oi = new ObjectInputStream(fin);
        Serial a = (Serial) oi.readObject();
        System.out.println(a.id + " " + a.name + " " + a.pass + " " + a.i);
    }

}
