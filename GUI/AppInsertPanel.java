package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Represents a prompt panel when inserting a new Contact
 */

public class AppInsertPanel{

    /**
     * The prompt panel
     */
    private JPanel panel;

    /**
     * Text Field for the name
     */
    private JTextField name;

    /**
     * Text Field for the street
     */
    private JTextField street;

    /**
     * Text Field for the city
     */
    private JTextField city;

    /**
     * Text Field for the state
     */
    private JTextField state;

    /**
     * Text Field for the zipcode
     */
    private JTextField zipcode;

    /**
     * Text Field for the phone number
     */
    private JTextField phoneNumber;

    /**
     * Constructs a new App Insert Panel
     */
    public AppInsertPanel(){
        panel = new JPanel(); // new panel
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // new Box Layout
        panel.setLayout(boxlayout);

        // Contact's name
        panel.add(new JLabel("Contact's Name:"));
        name = new JTextField(10);
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // a spacer

        // Contact's street
        panel.add(new JLabel("Contact's street:"));
        street = new JTextField(10);
        panel.add(street);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // a spacer

        // Contact's city
        panel.add(new JLabel("Contact's City:"));
        city = new JTextField(10);
        panel.add(city);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // a spacer

        // Contact's state
        panel.add(new JLabel("Contact's State:"));
        state = new JTextField(10);
        panel.add(state);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // a spacer

        // Contact's zipcode
        panel.add(new JLabel("Contact's Zipcode:"));
        zipcode = new JTextField(10);
        panel.add(zipcode);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // a spacer

        // Contact's phone number
        panel.add(new JLabel("Contact's Phone Number:"));
        phoneNumber = new JTextField(10);
        panel.add(phoneNumber);

    }

    /**
     * Returns the Contact's info as a string array
     * @return A String array represting the Contact's info
     */
    public String[] getinfo() {
        // Check whether the user cancels
        int num = JOptionPane.showConfirmDialog(null, panel, "Please Enter the Contact's information",
                JOptionPane.OK_CANCEL_OPTION);

        // If the user doesn't cancel
        if (num == JOptionPane.OK_OPTION) {
            String[] info = new String[10]; // Store the information
            info[0] = name.getText();
            info[1] = street.getText();
            info[2] = city.getText();
            info[3] = state.getText();
            info[4] = zipcode.getText();
            info[5] = phoneNumber.getText();
            return info; // Returns array of Strings
        } else {
            return null;
        }
    }
}