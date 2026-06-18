package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class teacherleave extends JFrame implements ActionListener {

    Choice cempId, ctime;
    ModernTextField tfdate;
    ModernButton submit, cancel;

    teacherleave() {
        setSize(500, 500);
        setLocation(400, 100);
        setLayout(null);
        getContentPane().setBackground(UIUtils.COLOR_BACKGROUND);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(UIUtils.FONT_HEADER);
        heading.setForeground(UIUtils.COLOR_TEXT_PRIMARY);
        add(heading);

        JLabel lblrollno = new JLabel("Search by Employee Id");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(UIUtils.FONT_BODY);
        add(lblrollno);

        cempId = new Choice();
        cempId.setBounds(60, 130, 200, 20);
        add(cempId);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from faculty");
            while (rs.next()) {
                cempId.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date (YYYY-MM-DD)");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(UIUtils.FONT_BODY);
        add(lbldate);

        tfdate = new ModernTextField();
        tfdate.setBounds(60, 210, 200, 30);
        add(tfdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(UIUtils.FONT_BODY);
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new ModernButton("Submit");
        submit.setBounds(60, 350, 100, 35);
        submit.addActionListener(this);
        add(submit);

        cancel = new ModernButton("Cancel");
        cancel.setBounds(200, 350, 100, 35);
        cancel.setBackground(UIUtils.COLOR_TEXT_SECONDARY);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String empId = cempId.getSelectedItem();
        String date = tfdate.getText().trim();
        String duration = ctime.getSelectedItem();

        // Basic validations
        if (empId == null || empId.equals("") || date.equals("") || duration.equals("")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
            return;
        }

        // Date format validation (YYYY-MM-DD)
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Date format must be YYYY-MM-DD");
            return;
        }

        // Date validity check with leap year handling
        try {
            String[] parts = date.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(null, "Month must be between 1 and 12");
                return;
            }

            int[] daysInMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};

            // Leap year check
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear && month == 2) {
                daysInMonth[2] = 29;
            }

            if (day < 1 || day > daysInMonth[month]) {
                JOptionPane.showMessageDialog(null, "Invalid day for the month " + month);
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid date entered");
            return;
        }

        try {
            conn c = new conn();

            // Duplicate leave check
            String checkQuery = "select * from teacherleave where empId='" + empId + "' and leave_date='" + date + "'";
            ResultSet rs = c.s.executeQuery(checkQuery);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Leave already applied for this date");
                return;
            }

            // Insert leave
            String query = "insert into teacherleave values('" + empId + "', '" + date + "', '" + duration + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Leave Confirmed");
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
        new teacherleave();
    }
}
