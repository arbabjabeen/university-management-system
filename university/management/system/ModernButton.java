package university.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ModernButton extends JButton {

    public ModernButton(String text) {
        super(text);

        // Default style
        setFont(UIUtils.FONT_BODY_BOLD);
        setForeground(Color.WHITE);
        setBackground(UIUtils.COLOR_PRIMARY);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false); // Important for custom painting
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(UIUtils.COLOR_PRIMARY.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(UIUtils.COLOR_PRIMARY);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

        // Paint text (handled by super, but we need to ensure it's drawn after
        // background)
        super.paintComponent(g);
    }
}
