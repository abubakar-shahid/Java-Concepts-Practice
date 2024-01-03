package FinalFall2022Solution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q4 extends JFrame {
    private static final int CROSS_SIZE = 10;
    private int currentX = 200;
    private int currentY = 200;

    public Q4() {

        setTitle("Move Cross");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");

        northButton.addActionListener(this::moveCrossNorth);
        southButton.addActionListener(this::moveCrossSouth);
        eastButton.addActionListener(this::moveCrossEast);
        westButton.addActionListener(this::moveCrossWest);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(northButton);
        buttonPanel.add(southButton);
        buttonPanel.add(eastButton);
        buttonPanel.add(westButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void moveCrossNorth(ActionEvent e) {
        moveCross(0, -20);
    }

    private void moveCrossSouth(ActionEvent e) {
        moveCross(0, 20);
    }

    private void moveCrossEast(ActionEvent e) {
        moveCross(20, 0);
    }

    private void moveCrossWest(ActionEvent e) {
        moveCross(-20, 0);
    }

    private void moveCross(int dx, int dy) {
        // Draw a red line connecting the old and new locations
        Graphics g = getGraphics();
        g.setColor(Color.RED);
        g.drawLine(currentX, currentY, currentX + dx, currentY + dy);

        // Draw 'X' alphabet at the new location
        g.setColor(Color.BLACK);
        g.drawString("X", currentX + dx - CROSS_SIZE / 2, currentY + dy + CROSS_SIZE / 2);

        // Update the current position
        currentX += dx;
        currentY += dy;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Q4());
    }
}
