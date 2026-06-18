package university.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UIUtils {

    // --- Modern Sapphire Theme ---

    // Primary Brand Colors
    public static final Color COLOR_PRIMARY = new Color(15, 82, 186); // Sapphire Blue
    public static final Color COLOR_PRIMARY_DARK = new Color(10, 58, 130);
    public static final Color COLOR_ACCENT = new Color(0, 168, 232); // Bright Cyan/Blue for highlights

    // Backgrounds & Surfaces
    public static final Color COLOR_BACKGROUND = new Color(240, 242, 245); // Light Gray Blue tint
    public static final Color COLOR_SURFACE = new Color(255, 255, 255); // Pure White
    public static final Color COLOR_SIDEBAR = new Color(20, 30, 48); // Dark Navy for Sidebar

    // Text
    public static final Color COLOR_TEXT_PRIMARY = new Color(33, 37, 41);
    public static final Color COLOR_TEXT_SECONDARY = new Color(108, 117, 125);
    public static final Color COLOR_TEXT_INVERTED = new Color(255, 255, 255);

    // States
    public static final Color COLOR_SUCCESS = new Color(25, 135, 84);
    public static final Color COLOR_DANGER = new Color(220, 53, 69);
    public static final Color COLOR_OUTLINE = new Color(222, 226, 230);

    // Fonts (Segoe UI is standard on Windows, fallback to SansSerif)
    public static final Font FONT_HEADER_LARGE = new Font("Segoe UI", Font.BOLD, 32);
    public static final Font FONT_HEADER = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font FONT_SUBHEADER = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font FONT_BODY = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_BODY_BOLD = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font FONT_SMALL = new Font("Segoe UI", Font.PLAIN, 12);

    // Dimensions
    public static final int ROUNDNESS = 12;
    public static final int BUTTON_HEIGHT = 40;
    public static final int INPUT_HEIGHT = 40;

    // Factory Methods for Consistency

    public static JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    public static JPanel createCard() {
        JPanel card = new JPanel();
        card.setBackground(COLOR_SURFACE);
        card.setBorder(BorderFactory.createLineBorder(COLOR_OUTLINE, 1));
        return card;
    }

    public static void setFlatLook(JComponent comp) {
        comp.setBackground(COLOR_SURFACE);
        comp.setFont(FONT_BODY);
    }
}
