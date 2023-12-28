import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowFocusExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Focus Example");
        JLabel label = new JLabel("Window is not in focus.");

        frame.add(label);
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
