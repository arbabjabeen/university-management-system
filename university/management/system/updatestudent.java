package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updatestudent extends JFrame implements ActionListener {

    ModernTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelrollno;
    ModernButton submit, cancel;
    Choice crollno;

    updatestudent() {
        setSize(900, 600);
        setLocation(200, 50);
        setLayout(null);
        getContentPane().setBackground(UIUtils.COLOR_BACKGROUND);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(UIUtils.FONT_HEADER_LARGE);
        heading.setForeground(UIUtils.COLOR_TEXT_PRIMARY);
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(UIUtils.FONT_BODY);
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Fields (Initially Empty or populated) ---
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(UIUtils.FONT_BODY);
        add(labelname);

        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(UIUtils.FONT_BODY);
        add(labelfname);

        JLabel lblroll = new JLabel("Roll Number");
        lblroll.setBounds(50, 200, 200, 30);
        lblroll.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblroll);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(UIUtils.FONT_BODY);
        add(labelrollno);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(UIUtils.FONT_BODY_BOLD);
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(UIUtils.FONT_BODY);
        add(labeldob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(UIUtils.FONT_BODY_BOLD);
        add(lbladdress);

        tfaddress = new ModernTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblphone);

        tfphone = new ModernTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblemail);

        tfemail = new ModernTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class XI (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblx);

        JLabel labelx = new JLabel();
        labelx.setBounds(600, 300, 150, 30);
        labelx.setFont(UIUtils.FONT_BODY);
        add(labelx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(200, 350, 150, 30);
        labelxii.setFont(UIUtils.FONT_BODY);
        add(labelxii);

        JLabel lblcnic = new JLabel("CNIC Number");
        lblcnic.setBounds(400, 350, 200, 30);
        lblcnic.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblcnic);

        JLabel labelcnic = new JLabel();
        labelcnic.setBounds(600, 350, 150, 30);
        labelcnic.setFont(UIUtils.FONT_BODY);
        add(labelcnic);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblcourse);

        tfcourse = new ModernTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblbranch);

        tfbranch = new ModernTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        add(tfbranch);

        // --- Load Action ---
        try {
            conn c = new conn();
            String query = "select * from students where rollno='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fathername"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("classx"));
                labelxii.setText(rs.getString("classxii"));
                labelcnic.setText(rs.getString("cnic"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from students where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fathername"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("classx"));
                        labelxii.setText(rs.getString("classxii"));
                        labelcnic.setText(rs.getString("cnic"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new ModernButton("Update");
        submit.setBounds(250, 500, 150, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new ModernButton("Cancel");
        cancel.setBounds(450, 500, 150, 40);
        cancel.setBackground(UIUtils.COLOR_TEXT_SECONDARY);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == submit) {

        String rollno = labelrollno.getText().trim();
        String address = tfaddress.getText().trim();
        String phone = tfphone.getText().trim();
        String email = tfemail.getText().trim();
        String course = tfcourse.getText().trim();
        String branch = tfbranch.getText().trim();

        // -------- BASIC VALIDATION --------

        if (rollno.equals("") || address.equals("") || phone.equals("")
                || email.equals("") || course.equals("") || branch.equals("")) {

            JOptionPane.showMessageDialog(null, "All fields are required");
            return;
        }

        // Phone validation
        if (!phone.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(null, "Phone number must be 11 digits");
            return;
        }

        // Email validation
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(null, "Invalid email format");
            return;
        }

        // -------- UPDATE QUERY --------
        try {
            String query = "update students set address='" + address + "', phone='" + phone + "', email='" + email
                    + "', course='" + course + "', branch='" + branch + "' where rollno='" + rollno + "'";

            conn c = new conn();
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error");
        }

    } else {
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new updatestudent();
    }
}
