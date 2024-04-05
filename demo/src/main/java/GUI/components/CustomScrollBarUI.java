package GUI.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomScrollBarUI extends BasicScrollBarUI {

    // Width of the scrollbar
    private final int scrollBarWidth = 5;

    // Define the track color
    private final Color trackColor = new Color(255, 255, 255);

    // Define the thumb color
    private final Color thumbColor = new Color(0, 102, 255); // #0066FF

    // Define the thumb hover color
    private final Color thumbHoverColor = new Color(150, 150, 150);

    // Define the thumb pressed color
    private final Color thumbPressedColor = new Color(200, 200, 200);

    // Create a rounded rectangle shape for the thumb
    private Shape thumbShape;

    // Override method to create a custom scrollbar
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(trackColor);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create the thumb shape
        thumbShape = new RoundRectangle2D.Float(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);

        // Paint the thumb
        if (isThumbRollover()) {
            g2.setColor(thumbHoverColor);
        } else if (isDragging) {
            g2.setColor(thumbPressedColor);
        } else {
            g2.setColor(thumbColor);
        }
        g2.fill(thumbShape);
        g2.dispose();
    }

    // Override method to return custom scrollbar width
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(scrollBarWidth, super.getPreferredSize(c).height);
    }

    // Helper method to create a button with zero size
    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }
}
