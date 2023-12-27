import javax.swing.*;
import java.awt.*;

public class CardLayoutExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CardLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel cardPanel = new JPanel(new CardLayout());

            // Create cards
            JPanel card1 = new JPanel();
            card1.add(new JLabel("Card 1"));
            card1.setBackground(Color.RED);

            JPanel card2 = new JPanel();
            card2.add(new JLabel("Card 2"));
            card2.setBackground(Color.BLUE);

            // Add cards to the cardPanel
            cardPanel.add(card1, "Card1");
            cardPanel.add(card2, "Card2");

            // Create buttons to switch between cards
            JButton showCard1Button = new JButton("Show Card 1");
            JButton showCard2Button = new JButton("Show Card 2");

            showCard1Button.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "Card1");
            });

            showCard2Button.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "Card2");
            });

            // Create a panel to hold the buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(showCard1Button);
            buttonPanel.add(showCard2Button);

            // Add the cardPanel and buttonPanel to the frame
            frame.add(cardPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
