import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

class Expense {
    int id;
    String title;
    String category;
    double amount;
    String date;

    Expense(int id, String title, String category,
            double amount, String date) {

        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
}

public class ExpenseTrackerGUI extends JFrame {

    ArrayList<Expense> expenses = new ArrayList<>();

    JTextField idField, titleField, categoryField,
            amountField, dateField;

    DefaultTableModel model;
    JTable table;

    JLabel totalLabel;

    public ExpenseTrackerGUI() {

        setTitle("Expense Tracker");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // MAIN PANEL
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // INPUT PANEL
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 10, 10));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        inputPanel.add(categoryField);

        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Date:"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        JButton addButton = new JButton("Add Expense");
        JButton deleteButton = new JButton("Delete Expense");

        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        panel.add(inputPanel, BorderLayout.NORTH);

        // TABLE
        String[] columns = {
                "ID", "Title", "Category",
                "Amount", "Date"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        // BOTTOM PANEL
        JPanel bottomPanel = new JPanel();

        JButton totalButton = new JButton("Show Total");
        JButton analyticsButton = new JButton("Category Analytics");

        totalLabel = new JLabel("Total Expense: 0");

        bottomPanel.add(totalButton);
        bottomPanel.add(analyticsButton);
        bottomPanel.add(totalLabel);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);

        // ADD BUTTON ACTION
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int id = Integer.parseInt(idField.getText());
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    double amount =
                            Double.parseDouble(amountField.getText());
                    String date = dateField.getText();

                    Expense expense = new Expense(
                            id, title, category, amount, date
                    );

                    expenses.add(expense);

                    model.addRow(new Object[]{
                            id, title, category, amount, date
                    });

                    clearFields();

                    JOptionPane.showMessageDialog(
                            null,
                            "Expense Added Successfully!"
                    );

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Input!"
                    );
                }
            }
        });

        // DELETE BUTTON ACTION
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();

                if(selectedRow != -1) {

                    expenses.remove(selectedRow);
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(
                            null,
                            "Expense Deleted!"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Select a row first!"
                    );
                }
            }
        });

        // TOTAL BUTTON ACTION
        totalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                double total = 0;

                for(Expense ex : expenses) {
                    total += ex.amount;
                }

                totalLabel.setText(
                        "Total Expense: " + total
                );
            }
        });

        // ANALYTICS BUTTON ACTION
        analyticsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                HashMap<String, Double> map =
                        new HashMap<>();

                for(Expense ex : expenses) {

                    map.put(
                            ex.category,
                            map.getOrDefault(
                                    ex.category,
                                    0.0
                            ) + ex.amount
                    );
                }

                StringBuilder result =
                        new StringBuilder();

                for(String key : map.keySet()) {

                    result.append(key)
                            .append(" : ")
                            .append(map.get(key))
                            .append("\n");
                }

                JOptionPane.showMessageDialog(
                        null,
                        result.toString(),
                        "Category Analytics",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    // CLEAR INPUT FIELDS
    public void clearFields() {

        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        amountField.setText("");
        dateField.setText("");
    }

    // MAIN METHOD
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new ExpenseTrackerGUI().setVisible(true);
            }
        });
    }
}
