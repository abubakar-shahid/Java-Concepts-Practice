import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowFocusExample {
    private static int x = 1;
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Window Focus Example");
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Window is not in focus.");

        JButton addButton = new JButton("Add Label");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(new JLabel("I am Label " + x++));
                frame.revalidate();
                frame.repaint();
            }
        });

        frame.add(label);
        frame.add(addButton);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a WindowListener to handle focus events
        frame.addWindowListener(new WindowFocusHandler(label));

        frame.setVisible(true);
    }
}

class WindowFocusHandler extends WindowAdapter {
    private JLabel label;

    WindowFocusHandler(JLabel label) {
        this.label = label;
    }

    @Override
    public void windowActivated(WindowEvent e) {
        label.setText("Window is in focus.");
        System.out.println("in focus");
        e.getWindow().setBackground(Color.GREEN); // Change background color
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        label.setText("Window is not in focus.");
        System.out.println("NOT in focus");
        e.getWindow().setBackground(UIManager.getColor("control")); // Revert to default background color
    }
}
