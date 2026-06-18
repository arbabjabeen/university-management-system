package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    ModernButton btnLogin, btnCancel;
    ModernTextField tfUsername;
    JPasswordField tfPassword;

    Login() {
        setTitle("University Management System - Login");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());

        // --- Left Panel (Art/Brand) ---
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(UIUtils.COLOR_PRIMARY);
        leftPanel.setPreferredSize(new Dimension(350, 500));
        leftPanel.setLayout(new BorderLayout());

        // Brand Content
        JPanel brandContent = new JPanel();
        brandContent.setOpaque(false);
        brandContent.setLayout(new BoxLayout(brandContent, BoxLayout.Y_AXIS));

        JLabel logoText = new JLabel("UMS");
        logoText.setFont(new Font("Segoe UI", Font.BOLD, 48));
        logoText.setForeground(new Color(255, 255, 255, 40)); // Watermark style
        logoText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel brandName = new JLabel("<html><center>UNIVERSITY<br>MANAGEMENT</center></html>");
        brandName.setFont(UIUtils.FONT_HEADER);
        brandName.setForeground(Color.WHITE);
        brandName.setAlignmentX(Component.CENTER_ALIGNMENT);

        brandContent.add(Box.createVerticalGlue());
        brandContent.add(logoText);
        brandContent.add(Box.createRigidArea(new Dimension(0, 20)));
        brandContent.add(brandName);
        brandContent.add(Box.createVerticalGlue());

        leftPanel.add(brandContent, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        // --- Right Panel (Form) ---
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(UIUtils.COLOR_BACKGROUND); // Better contrast for white text fields
        rightPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;

        // Header
        JLabel lblHeader = new JLabel("Welcome Back");
        lblHeader.setFont(UIUtils.FONT_HEADER_LARGE);
        lblHeader.setForeground(UIUtils.COLOR_TEXT_PRIMARY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(lblHeader, gbc);

        JLabel lblSub = new JLabel("Login to your account");
        lblSub.setFont(UIUtils.FONT_BODY);
        lblSub.setForeground(UIUtils.COLOR_TEXT_SECONDARY);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        rightPanel.add(lblSub, gbc);

        // Form
        // User
        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(UIUtils.FONT_BODY_BOLD); // Fixed Font Reference
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 5, 10);
        rightPanel.add(lblUser, gbc);

        tfUsername = new ModernTextField();
        gbc.gridy = 3;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 10, 10, 10);
        rightPanel.add(tfUsername, gbc);

        // Pass
        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(UIUtils.FONT_BODY_BOLD);
        gbc.gridy = 4;
        gbc.ipady = 0;
        gbc.insets = new Insets(10, 10, 5, 10);
        rightPanel.add(lblPass, gbc);

        tfPassword = new JPasswordField();
        tfPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(UIUtils.COLOR_OUTLINE),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        tfPassword.setFont(UIUtils.FONT_BODY);
        gbc.gridy = 5;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 10, 20, 10);
        rightPanel.add(tfPassword, gbc);

        // Buttons
        btnLogin = new ModernButton("Login");
        btnLogin.addActionListener(this);
        gbc.gridy = 6;
        gbc.gridwidth = 1; // Split buttons
        gbc.weightx = 0.5;
        gbc.ipady = 10;
        rightPanel.add(btnLogin, gbc);

        btnCancel = new ModernButton("Exit");
        btnCancel.setBackground(UIUtils.COLOR_TEXT_SECONDARY); // Grey for cancel
        btnCancel.addActionListener(this);
        gbc.gridx = 1;
        rightPanel.add(btnCancel, gbc);

        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLogin) {
            String username = tfUsername.getText();
            String password = new String(tfPassword.getPassword());

            // Use PreparedStatement to prevent injection
            String query = "SELECT * FROM login WHERE username=? AND password=?";
            try {
                conn c = new conn();
                // Ensure the connection is valid
                if (c.c == null) {
                    JOptionPane.showMessageDialog(null, "Database Connection Failed!\nCheck if MySQL is running.");
                    return;
                }

                PreparedStatement ps = c.c.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    setVisible(false);
                    new project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

                // Close resources
                rs.close();
                ps.close();
                // c.c is usually left open in this design pattern, or closed if singleton

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (ae.getSource() == btnCancel) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
