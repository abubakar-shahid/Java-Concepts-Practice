import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawLineExample extends JFrame {
    private Point startPoint;
    private Point endPoint;

    public DrawLineExample() {
        setTitle("Draw Line Example");

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (startPoint != null && endPoint != null) {
                    g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                }
            }
        };

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (startPoint == null) {
                    startPoint = e.getPoint();
                } else if (endPoint == null) {
                    endPoint = e.getPoint();
                    drawingPanel.repaint();  // Trigger repaint to draw the line
                }
            }
        });

        getContentPane().add(drawingPanel);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DrawLineExample().setVisible(true);
        });
    }
}
