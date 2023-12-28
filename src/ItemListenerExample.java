import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ItemListener Example");

        JCheckBox checkBox = new JCheckBox("Enable Feature");

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Feature enabled");
                } else {
                    System.out.println("Feature disabled");
                }
            }
        });

        frame.getContentPane().add(checkBox);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
