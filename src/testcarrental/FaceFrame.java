package testcarrental;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FaceFrame extends JFrame {

    private CarRental rental;

    private JButton customerButton;
    private JButton readButton;
    private JButton exitButton;

    public FaceFrame(CarRental rental) {
        this.rental = rental;
        initComponents();
    }

    private void initComponents() {
        setTitle("KSU Car Rental");
        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("KSU Car Rental System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 8, 8));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        customerButton = new JButton("Customer ");
        readButton = new JButton("Read Saved Data");
        exitButton = new JButton("Exit");

        buttonPanel.add(customerButton);
        buttonPanel.add(readButton);
        buttonPanel.add(exitButton);

        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });

        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        setSize(380, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new InputFrame(rental).setVisible(true);
        setVisible(false);
    }

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            rental.readAllData();
            new ResultFrame("Data loaded successfully.").setVisible(true);
        } catch (IOException ex) {
            new ResultFrame("Error while reading data:\n" + ex.getMessage()).setVisible(true);
        } catch (ClassNotFoundException ex) {
            new ResultFrame("Error while reading saved objects. Class not found.").setVisible(true);
        }
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
}
