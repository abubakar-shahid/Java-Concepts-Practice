import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingShapesExample extends JFrame {
    private int shapeType = 0; // 0: Line, 1: Rectangle, 2: Circle

    public DrawingShapesExample() {
        setTitle("Drawing Shapes Example");

        JButton lineButton = new JButton("Line");
        JButton rectButton = new JButton("Rectangle");
        JButton circleButton = new JButton("Circle");

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeType = 0;
                repaint();
            }
        });

        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeType = 1;
                repaint();
            }
        });

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeType = 2;
                repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(lineButton);
        buttonPanel.add(rectButton);
        buttonPanel.add(circleButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        switch (shapeType) {
            case 0:
                drawLine(g, 100, 100, 200, 200);
                break;
            case 1:
                drawRectangle(g, 100, 100, 150, 100);
                break;
            case 2:
                drawCircle(g, 200, 200, 50);
                break;
        }
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    private void drawRectangle(Graphics g, int x, int y, int width, int height) {
        g.drawRect(x, y, width, height);
    }

    private void drawCircle(Graphics g, int centerX, int centerY, int radius) {
        int diameter = radius * 2;
        g.drawOval(centerX - radius, centerY - radius, diameter, diameter);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DrawingShapesExample().setVisible(true);
        });
    }
}
