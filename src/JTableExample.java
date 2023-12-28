import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableExample extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public JTableExample() {
        setTitle("JTable Example");

        // Create the table model with column names and data
        String[] columnNames = {"Name", "Age", "Country"};
        Object[][] data = {{"John", 25, "USA"}, {"Alice", 30, "Canada"}, {"Bob", 22, "UK"}};
        tableModel = new DefaultTableModel(data, columnNames);

        // Create the JTable using the table model
        table = new JTable(tableModel);

        // Set up row selection listener
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String name = (String) tableModel.getValueAt(selectedRow, 0);
                        int age = (int) tableModel.getValueAt(selectedRow, 1);
                        String country = (String) tableModel.getValueAt(selectedRow, 2);
                        System.out.println("Selected Row: " + name + ", " + age + ", " + country);
                    }
                }
            }
        });

        // Create buttons for adding and deleting rows
        JButton addButton = new JButton("Add Row");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] newRow = {"New Person", 0, "New Country"};
                tableModel.addRow(newRow);
            }
        });

        JButton deleteButton = new JButton("Delete Row");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // Set up the layout of the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JTableExample().setVisible(true);
        });
    }
}
