package university.management.system;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class ModernTextField extends JTextField {

    public ModernTextField() {
        setFont(UIUtils.FONT_BODY);
        setForeground(UIUtils.COLOR_TEXT_PRIMARY);
        setBackground(UIUtils.COLOR_SURFACE);
        setCaretColor(UIUtils.COLOR_PRIMARY);
        setOpaque(false); // We paint our own background
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Inner padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint border
        if (isFocusOwner()) {
            g2.setColor(UIUtils.COLOR_PRIMARY);
            g2.setStroke(new BasicStroke(2));
        } else {
            g2.setColor(UIUtils.COLOR_OUTLINE);
            g2.setStroke(new BasicStroke(1));
        }
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
    }
}
