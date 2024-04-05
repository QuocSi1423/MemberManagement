package GUI.components;

import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {

    private int cornerRadius = 5;

    public CustomTextField() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0xE0E0E0));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // Draw the rounded rectangle border
        g2.setColor(getBackground());
        g2.fillRoundRect(1, 1, getWidth() - 3, getHeight() - 3, cornerRadius, cornerRadius);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint the border
    }

    @Override
    public Insets getInsets() {
        // Add padding to the text field
        return new Insets(4, 10, 4, 10);
    }
}
