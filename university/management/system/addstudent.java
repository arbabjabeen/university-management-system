package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class addstudent extends JFrame implements ActionListener {
    JComboBox cbcourse, cbbranch;
    ModernTextField tfname, tffathername, tfaddress, tfphone, tfemail, tfclassx, tfclassxii, tfcnic, tfdob;
    JLabel tfroll;
    ModernButton submit, cancle;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    addstudent() {
        setSize(800, 550);
        setLocation(200, 100);
        setLayout(null);
        getContentPane().setBackground(UIUtils.COLOR_BACKGROUND);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(250, 30, 400, 40);
        heading.setFont(UIUtils.FONT_HEADER);
        heading.setForeground(UIUtils.COLOR_TEXT_PRIMARY);
        add(heading);

        // --- Row 1 ---
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 100, 100, 30);
        lblname.setFont(UIUtils.FONT_BODY);
        add(lblname);

        tfname = new ModernTextField();
        tfname.setBounds(200, 100, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 100, 150, 30);
        lblfname.setFont(UIUtils.FONT_BODY);
        add(lblfname);

        tffathername = new ModernTextField();
        tffathername.setBounds(600, 100, 150, 30);
        add(tffathername);

        // --- Row 2 ---
        JLabel lblroll = new JLabel("Roll No");
        lblroll.setBounds(50, 150, 100, 30);
        lblroll.setFont(UIUtils.FONT_BODY);
        add(lblroll);

        tfroll = new JLabel("1533" + first4);
        tfroll.setBounds(200, 150, 150, 30);
        tfroll.setFont(UIUtils.FONT_SUBHEADER);
        add(tfroll);

        JLabel lbldob = new JLabel("Date Of Birth (Y-M-D)");
        lbldob.setBounds(400, 150, 150, 30);
        lbldob.setFont(UIUtils.FONT_BODY);
        add(lbldob);

        tfdob = new ModernTextField();
        tfdob.setBounds(600, 150, 150, 30);
        // Placeholder-ish text handled by user knowing format
        add(tfdob);

        // --- Row 3 ---
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 200, 100, 30);
        lbladdress.setFont(UIUtils.FONT_BODY);
        add(lbladdress);

        tfaddress = new ModernTextField();
        tfaddress.setBounds(200, 200, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone no");
        lblphone.setBounds(400, 200, 150, 30);
        lblphone.setFont(UIUtils.FONT_BODY);
        add(lblphone);

        tfphone = new ModernTextField();
        tfphone.setBounds(600, 200, 150, 30);
        add(tfphone);

        // --- Row 4 ---
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 250, 100, 30);
        lblemail.setFont(UIUtils.FONT_BODY);
        add(lblemail);

        tfemail = new ModernTextField();
        tfemail.setBounds(200, 250, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class XI (%)");
        lblx.setBounds(400, 250, 150, 30);
        lblx.setFont(UIUtils.FONT_BODY);
        add(lblx);

        tfclassx = new ModernTextField();
        tfclassx.setBounds(600, 250, 150, 30);
        add(tfclassx);

        // --- Row 5 ---
        JLabel lblxii = new JLabel("Class XII(%)");
        lblxii.setBounds(50, 300, 150, 30);
        lblxii.setFont(UIUtils.FONT_BODY);
        add(lblxii);

        tfclassxii = new ModernTextField();
        tfclassxii.setBounds(200, 300, 150, 30);
        add(tfclassxii);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 300, 150, 30);
        lblbranch.setFont(UIUtils.FONT_BODY);
        add(lblbranch);

        String branches[] = { "Computer Science", "Mechanical", "Electronics", "Civil", "IT" };
        cbbranch = new JComboBox(branches);
        cbbranch.setBounds(600, 300, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        // --- Row 6 ---
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 350, 100, 30);
        lblcourse.setFont(UIUtils.FONT_BODY);
        add(lblcourse);

        String courses[] = { "Bsc", "BA", "MBA", "MSc", "BSC", "Mcom", "MA", "B.Tech", "BBA", "BCA", "MBA", "BSSE",
                "BSCS" };
        cbcourse = new JComboBox(courses);
        cbcourse.setBounds(200, 350, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblcnic = new JLabel("CNIC Number");
        lblcnic.setBounds(400, 350, 150, 30);
        lblcnic.setFont(UIUtils.FONT_BODY);
        add(lblcnic);

        tfcnic = new ModernTextField();
        tfcnic.setBounds(600, 350, 150, 30);
        add(tfcnic);

        // --- Buttons ---
        submit = new ModernButton("Submit");
        submit.setBounds(250, 450, 150, 35);
        submit.addActionListener(this);
        add(submit);

        cancle = new ModernButton("Cancel");
        cancle.setBounds(450, 450, 150, 35);
        cancle.setBackground(UIUtils.COLOR_TEXT_SECONDARY);
        cancle.addActionListener(this);
        add(cancle);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    

    if (ae.getSource() == submit) {

        String name = tfname.getText().trim();
        String fathername = tffathername.getText().trim();
        String rollno = tfroll.getText();
        String cnic = tfcnic.getText().trim();
        String branch = (String) cbbranch.getSelectedItem();
        String course = (String) cbcourse.getSelectedItem();
        String phone = tfphone.getText().trim();
        String email = tfemail.getText().trim();
        String dob = tfdob.getText().trim();
        String classx = tfclassx.getText().trim();
        String classxii = tfclassxii.getText().trim();
        String address = tfaddress.getText().trim();

        // ---------- BASIC VALIDATIONS ----------

        if (name.equals("") || fathername.equals("") || dob.equals("") || address.equals("")
                || phone.equals("") || email.equals("") || classx.equals("")
                || classxii.equals("") || cnic.equals("")) {

            JOptionPane.showMessageDialog(null, "All fields are required");
            return;
        }

        // Phone validation
        if (!phone.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(null, "Phone number must be 11 digits");
            return;
        }

        // CNIC validation
        if (!cnic.matches("\\d{13}")) {
            JOptionPane.showMessageDialog(null, "CNIC must be 13 digits");
            return;
        }

        // Email validation
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(null, "Invalid email format");
            return;
        }

        // Marks validation
        try {
            int x = Integer.parseInt(classx);
            int xii = Integer.parseInt(classxii);

            if (x < 0 || x > 100 || xii < 0 || xii > 100) {
                JOptionPane.showMessageDialog(null, "Marks must be between 0 and 100");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Marks must be numeric");
            return;
        }

        // ---------- DATABASE INSERT ----------
        try {
            conn c = new conn();
            String query = "insert into students values('" + name + "','" + fathername + "','" + rollno + "','"
                    + dob + "','" + email + "','" + phone + "','" + classx + "','" + classxii + "','" + cnic + "','"
                    + course + "','" + branch + "','" + address + "')";

            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Student details added successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error");
        }

    }
    else if (ae.getSource() == cancle) {
        setVisible(false);
    }
}
   
        
    

    public static void main(String args[]) {
        new addstudent();
    }
}
