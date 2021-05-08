package GUI;

import javax.swing.JFrame;
import java.io.IOException;

/**
 * Displays the Address Book
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class AppFrame extends JFrame {

    /**
     * The frame of the Contact Book App
     */
    private JFrame frame;

    /**
     * Constructs an interface of the Address Book
     * 
     * @throws IOException
     */
    public AppFrame() throws IOException {
        frame = new JFrame(); // New frame
    }

    /**
     * Displays a new JFrame with defined attributes
     */
    public void launch() {
        frame.setTitle("Contact Book");
        frame.setSize(600, 400); // Lenight x Width
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(new AppPanel()); // Add a new AppPanel
        frame.setVisible(true); // Display
    }

}
