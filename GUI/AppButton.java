package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 * Represents and defines the common attributes between the Contact Book buttons
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class AppButton extends JButton {

    /**
     * Constructs a new AppButton
     * 
     * @param text String text represents the text of the button
     */
    public AppButton(String text) {
        Color c = new Color(242, 221, 208);
        setAlignmentX(CENTER_ALIGNMENT);
        setText(text);
        setFocusable(false);
        setBackground(c);
        setPreferredSize(new Dimension(115, 30));
    }
}
