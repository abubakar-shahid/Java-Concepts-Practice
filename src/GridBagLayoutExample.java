import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JButton button1 = new JButton("Button 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(button1, constraints);

        JButton button2 = new JButton("Button 2");
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(button2, constraints);

        JButton button3 = new JButton("Button 3");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(button3, constraints);

        JButton button4 = new JButton("Button 4");
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(button4, constraints);

        JButton button5 = new JButton("Button 5");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(button5, constraints);

        //constraints.gridwidth = 2; // Span two columns

        //frame.getContentPane().add(panel);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
