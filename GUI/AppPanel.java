package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import src.Address;
import src.AddressBook;
import src.Contact;
import src.TreeIterator;

/**
 * Displays all the components of the AddressBook Processes action event
 * triggered by a button
 * 
 * @author Adam Khoukhi
 * @version 1.0
 *
 */

public class AppPanel extends JPanel implements ActionListener {

    /**
     * Backbone of the GUI App, represents the AddressBook of the GUI
     */
    private AddressBook addressbook;

    /**
     * Displays Information on the screen
     */
    private JLabel label;

    /**
     * The save button
     */
    private AppButton save;

    /**
     * The size button
     */
    private AppButton size;

    /**
     * The search button
     */
    private AppButton search;

    /**
     * The removeAll button
     */
    private AppButton removeAll;

    /**
     * The insert button
     */
    private AppButton insert;

    /**
     * The remove button
     */
    private AppButton remove;

    /**
     * The contain button
     */
    private AppButton contain;

    /**
     * Constructs a new App Panel
     */
    public AppPanel() {
        // new AddressBook
        this.setAddressbook(new AddressBook());

        // Layout of main panel
        setBounds(0, 0, 600, 400);
        setBackground(new Color(140, 74, 43));
        setLayout(new BorderLayout());

        // Creating instances of AppButtons
        save = new AppButton("Save");
        size = new AppButton("Size");
        search = new AppButton("Search");
        removeAll = new AppButton("Clear");
        insert = new AppButton("Insert");
        remove = new AppButton("Remove");
        contain = new AppButton("Contain");

        // ActionListener
        save.addActionListener(this);
        size.addActionListener(this);
        search.addActionListener(this);
        removeAll.addActionListener(this);
        insert.addActionListener(this);
        remove.addActionListener(this);
        contain.addActionListener(this);

        // Buttons Panel
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // new JPanel for the buttons
        buttons.setBackground(new Color(227, 184, 157));
        buttons.setPreferredSize(new Dimension(115, 400));
        BoxLayout boxlayout = new BoxLayout(buttons, BoxLayout.Y_AXIS); // new Box Layout
        buttons.setLayout(boxlayout); // sets the layout of the panel
        buttons.add(Box.createRigidArea(new Dimension(0, 20)));
        buttons.add(save);
        buttons.add(Box.createRigidArea(new Dimension(0, 5)));
        buttons.add(size);
        buttons.add(Box.createRigidArea(new Dimension(0, 5)));
        buttons.add(search);
        buttons.add(Box.createRigidArea(new Dimension(0, 5)));
        buttons.add(removeAll);
        buttons.add(Box.createRigidArea(new Dimension(0, 5)));
        buttons.add(insert);
        buttons.add(Box.createRigidArea(new Dimension(0, 5)));
        buttons.add(remove);
        buttons.add(Box.createRigidArea(new Dimension(0, 5)));
        buttons.add(contain);
        buttons.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(buttons, BorderLayout.EAST);

        // Output panel
        label = new JLabel();
        label.setText("Welcome!");
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(227, 184, 157));
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        this.add(label);
    }

    /**
     * Returns a reference of the AddressBook
     * 
     * @return A reference to the AddressBook
     */
    public AddressBook getAddressbook() {
        return addressbook;
    }

    /**
     * Sets the AddressBook to the given parameter
     * 
     * @param addressbook A reference to an AddressBook
     */
    public void setAddressbook(AddressBook addressbook) {
        this.addressbook = addressbook;
    }

    /**
     * Invoked when an action occurs.
     * 
     * @param e A reference to an action event object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == contain) {
            String name = JOptionPane.showInputDialog(null, "Input the Contact's name:", "Check Contact", 1);
            boolean val = addressbook.contains(name);
            if (val == true) {
                label.setText(name + " is in the Contacts!");
            } else {
                label.setText(name + " isn't in the Contacts!");
            }

        } else if (e.getSource() == size) {
            String currSize = String.valueOf(addressbook.size());
            label.setText(currSize);

        } else if (e.getSource() == search) {
            String name = JOptionPane.showInputDialog(null, "Input the Contact's name:", "Search Contact", 1);
            Contact tempContact = addressbook.get(name);
            String template = "<html>%s<br>%s<br>%s</html>";
            String text = String.format(template, tempContact.getName(), tempContact.getAddress(),
                    tempContact.getPhone());
            label.setText(text);

        } else if (e.getSource() == removeAll) {
            addressbook.makeEmpty();
            if (addressbook.isEmpty()) {
                label.setText("<html>Mail Book<br>is cleared :)</html>");
            } else {
                label.setText("<html>Oops :(<br>Something went wrong</html>");
            }

        } else if (e.getSource() == insert) {
            int curr = addressbook.size();
            AppInsertPanel insertpanel = new AppInsertPanel();
            String[] info = insertpanel.getinfo();
            String name = info[0];
            Address address = new Address(info[1], info[2], info[3], info[4]);
            Contact contact = new Contact(name, address, info[5]);
            addressbook.insert(contact); // Add the contact to the Address book
            if (curr < addressbook.size()) {
                label.setText(info[0] + " was added :)");
            } else {
                label.setText("<html>Oops :(<br>Something went wrong</html>");
            }

        } else if (e.getSource() == remove) {
            int curr = addressbook.size();
            String name = JOptionPane.showInputDialog(null, "Input the Contact's name:", "Remove Contact", 0);
            addressbook.remove(name);
            if (curr > addressbook.size()) {
                label.setText(name + " was removed :)");
            } else {
                label.setText("<html>Oops :(<br>Something went wrong</html>");
            }
        } else {
            TreeIterator<Contact> iterator = addressbook.getTree().iterator();
            iterator.setInorder();
            String name = JOptionPane.showInputDialog(null, "Enter file name", "Save As", 1);
            File file = new File(name + ".txt");
            FileWriter fr;
            try {
                fr = new FileWriter(file, false);
                BufferedWriter br = new BufferedWriter(fr);
                int i = 1;
                while (iterator.hasNext()) {
                    Contact temp = iterator.next();
                    br.write("Contact #" + i + "\n");
                    br.write(temp.getName() + "\n");
                    br.write(temp.getAddress() + "\n");
                    br.write(temp.getPhone() + "\n\n");
                    i++;
                }
                br.close();
                fr.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
