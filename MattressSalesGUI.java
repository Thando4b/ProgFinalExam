/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mattresssalesgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Thando
 */

public class MattressSalesGUI extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;
    private JTextArea txtMessage;

    public MattressSalesGUI() {
        setTitle("Mattress Sales");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Q2.4 - MENU
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Q2.2
        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        add(txtCustomerName);

        add(new JLabel("Selected Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        add(cmbProduct);

        add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        // Q2.3 - Button
        add(new JLabel(""));
        btnProcess = new JButton("Process");
        add(btnProcess);

        add(new JLabel("Message:"));
        txtMessage = new JTextArea();
        txtMessage.setEditable(false);
        add(new JScrollPane(txtMessage));

        // Button + Menu all call the SAME method
        btnProcess.addActionListener(e -> processSale());
        processItem.addActionListener(e -> processSale());

        // Q2.4 - Exit
        exitItem.addActionListener(e -> System.exit(0));

        // Q2.4 - Clear
        clearItem.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            txtMessage.setText("");
            cmbProduct.setSelectedIndex(0);
        });

        setVisible(true);
    }

    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Q2.5 - Use the class now, not manual maths
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String result = "Customer Name: " + customerName + "\n"
                    + "Product: " + productName + "\n"
                    + "VAT Amount: R" + vat + "\n"
                    + "Commission: R" + commission + "\n"
                    + "Total: R" + total;
            txtMessage.setText(result);

            FileWriter writer = new FileWriter("data.txt", true);
            writer.write(result + "\n------------------------\n");
            writer.close();

            JOptionPane.showMessageDialog(this, "Saved to data.txt");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file!");
        }
    }

    public static void main(String[] args) {
        new MattressSalesGUI();
    }
}
