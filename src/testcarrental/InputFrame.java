package testcarrental;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class InputFrame extends JFrame {

    private CarRental rental;

    private JTextField nameField;
    private JTextField mobileField;
    private JTextField idField;
    private JTextField plateField;
    private JTextField daysField;

    private JButton addReservationButton;
    private JButton cancelReservationButton;
    private JButton searchReservationButton;
    private JButton viewAvailableButton;
    private JButton viewEconomyButton;
    private JButton viewAllReservationsButton;
    private JButton saveButton;
    private JButton clearButton;
    private JButton backButton;

    // Constructor to initialize the frame with the CarRental controller
    public InputFrame(CarRental rental) {
        this.rental = rental;
        initComponents();
    }

    // Initializes all GUI components, layouts, and registers action listeners
    private void initComponents() {
        setTitle("Customer Frame - Car Rental");
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 8, 8));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Reservation Information"));

        nameField = new JTextField(15);
        mobileField = new JTextField(15);
        idField = new JTextField(15);
        plateField = new JTextField(15);
        daysField = new JTextField(15);

        inputPanel.add(new JLabel("Customer Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Customer Mobile:"));
        inputPanel.add(mobileField);
        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Car Plate Number:"));
        inputPanel.add(plateField);
        inputPanel.add(new JLabel("Rental Days:"));
        inputPanel.add(daysField);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Operations"));

        addReservationButton = new JButton("Add Reservation");
        cancelReservationButton = new JButton("Cancel Reservation");
        searchReservationButton = new JButton("Search Reservation");
        viewAvailableButton = new JButton("View Available Cars");
        viewEconomyButton = new JButton("View Economy Cars (Recursive)");
        viewAllReservationsButton = new JButton("View All Reservations");
        saveButton = new JButton("Save Data");
        clearButton = new JButton("Clear Fields");
        backButton = new JButton("Back");

        buttonPanel.add(addReservationButton);
        buttonPanel.add(cancelReservationButton);
        buttonPanel.add(searchReservationButton);
        buttonPanel.add(viewAvailableButton);
        buttonPanel.add(viewEconomyButton);
        buttonPanel.add(viewAllReservationsButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReservationButtonActionPerformed(evt);
            }
        });

        cancelReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservationButtonActionPerformed(evt);
            }
        });

        searchReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReservationButtonActionPerformed(evt);
            }
        });

        viewAvailableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAvailableButtonActionPerformed(evt);
            }
        });

        viewEconomyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEconomyButtonActionPerformed(evt);
            }
        });

        viewAllReservationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllReservationsButtonActionPerformed(evt);
            }
        });

        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        setSize(560, 430); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    // Validates inputs, checks for existing reservations, and adds a new reservation
    private void addReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String name = nameField.getText().trim();
            String mobile = mobileField.getText().trim();
            String id = idField.getText().trim();
            String plate = plateField.getText().trim();

            if (name.equals("") || mobile.equals("") || id.equals("")
                    || plate.equals("") || daysField.getText().trim().equals("")) {
                new ResultFrame("Please fill all reservation fields.").setVisible(true);
                return;
            }

            checkMobile(mobile);
            checkID(id);

            if (rental.hasReservation(id)) {
                new ResultFrame("This customer already has a reservation.").setVisible(true);
                return;
            }

            int days = Integer.parseInt(daysField.getText().trim());
            Car c = rental.searchCar(plate);

            Reservation r = new Reservation(name, mobile, id);
            r.AssignCar(c, days);

            if (rental.addReservation(r)) {
                new ResultFrame("Reservation added successfully.\n\n" + r.toString()).setVisible(true);
                clearFields();
            } else {
                r.ReturnCar();
                new ResultFrame("Cannot add reservation. Reservation list may be full.").setVisible(true);
            }

        } catch (InvalidMobileNo ex) {
            new ResultFrame(ex.getMessage()).setVisible(true);
        } catch (InvalidIDNo ex) {
            new ResultFrame(ex.getMessage()).setVisible(true);
        } catch (NumberFormatException ex) {
            new ResultFrame("Number of days must be a valid number.").setVisible(true);
        } catch (ReservationException ex) {
            new ResultFrame(ex.getMessage()).setVisible(true);
        }
    }

    // Cancels an existing reservation matching the provided customer ID and car plate
    private void cancelReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = idField.getText().trim();
            String plate = plateField.getText().trim();

            if (id.equals("") || plate.equals("")) {
                new ResultFrame("Please enter ID and plate number to cancel the reservation.").setVisible(true);
                return;
            }

            checkID(id);

            if (rental.cancelReservation(id, plate)) {
                new ResultFrame("Reservation cancelled successfully.").setVisible(true);
                clearFields();
            } else {
                new ResultFrame("Reservation was not found.").setVisible(true);
            }
        } catch (InvalidIDNo ex) {
            new ResultFrame(ex.getMessage()).setVisible(true);
        }
    }

    // Searches for a reservation details using the customer ID and car plate
    private void searchReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = idField.getText().trim();
            String plate = plateField.getText().trim();

            if (id.equals("") || plate.equals("")) {
                new ResultFrame("Please enter ID and plate number to search for the reservation.").setVisible(true);
                return;
            }

            checkID(id);

            Reservation r = rental.searchReservation(id, plate);

            if (r == null) {
                new ResultFrame("Reservation was not found.").setVisible(true);
            } else {
                new ResultFrame(r.toString()).setVisible(true);
            }
        } catch (InvalidIDNo ex) {
            new ResultFrame(ex.getMessage()).setVisible(true);
        }
    }

    // Displays all available cars in a result frame
    private void viewAvailableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ResultFrame(rental.viewAvailableCars()).setVisible(true);
    }

    // Displays economy cars recursively using a customized helper method
    private void viewEconomyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ResultFrame(rental.getEconomyRecursiveText()).setVisible(true);
    }

    // Lists all active reservations stored in the system
    private void viewAllReservationsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ResultFrame(rental.getAllReservations()).setVisible(true);
    }

    // Saves all current data of cars and reservations to binary files
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            rental.saveAllInfo();
            new ResultFrame("Data saved successfully.").setVisible(true);
        } catch (IOException ex) {
            new ResultFrame("Error while saving data:\n" + ex.getMessage()).setVisible(true);
        }
    }

    // Clears input text fields to prepare for next operation
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
    }

    // Navigates back to the main FaceFrame screen
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new FaceFrame(rental).setVisible(true);
        setVisible(false);
    }

    // Helper method to validate the mobile number format (numeric, starts with '05', exactly 10 digits)
    private void checkMobile(String mobile) throws InvalidMobileNo {
        try {
            Long.parseLong(mobile);
        } catch (NumberFormatException ex) {
            throw new InvalidMobileNo("Mobile must contain numbers only.");
        }

        if (mobile.length() != 10 || !mobile.startsWith("05")) {
            throw new InvalidMobileNo("Mobile must start with 05 and contain 10 digits.");
        }
    }

    // Helper method to validate the customer ID format (numeric, exactly 10 digits)
    private void checkID(String id) throws InvalidIDNo {
        try {
            Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new InvalidIDNo("ID must contain numbers only.");
        }

        if (id.length() != 10) {
            throw new InvalidIDNo("ID must contain 10 digits.");
        }
    }

    // Helper method to clear all text fields
    private void clearFields() {
        nameField.setText("");
        mobileField.setText("");
        idField.setText("");
        plateField.setText("");
        daysField.setText("");
    }
}

