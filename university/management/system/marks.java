
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class marks extends JFrame implements ActionListener {
    
    String rollno;
    JButton cancel;
 marks(String rollno) {
    this.rollno = rollno;

    setSize(500, 500);
    setLocation(500, 100);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);

    if (rollno == null || rollno.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Roll number is empty.");
        dispose();  // Close window since no valid input
        return;
    }

    // Example constraint: roll number must be 8 digits numeric
    if (!rollno.matches("\\d{8}")) {
        JOptionPane.showMessageDialog(null, "Roll number must be exactly 8 digits.");
        dispose();
        return;
    }

    // UI components code (headings, labels, etc.)
    JLabel heading = new JLabel("COMSATS University");
    heading.setBounds(100, 10, 500, 25);
    heading.setFont(new Font("Tahoma", Font.BOLD, 20));
    add(heading);

    JLabel subheading = new JLabel("Result of Examination 2025");
    subheading.setBounds(100, 50, 500, 20);
    subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
    add(subheading);

    JLabel lblrollno = new JLabel("Roll Number: " + rollno);
    lblrollno.setBounds(60, 100, 500, 20);
    lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add(lblrollno);

    JLabel lblsemester = new JLabel();
    lblsemester.setBounds(60, 130, 500, 20);
    lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add(lblsemester);

    JLabel[] subjectLabels = new JLabel[5];
    for (int i = 0; i < 5; i++) {
        subjectLabels[i] = new JLabel();
        subjectLabels[i].setBounds(60, 180 + i * 30, 400, 20);
        subjectLabels[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(subjectLabels[i]);
    }

    try {
        conn c = new conn();

        PreparedStatement psSub = c.c.prepareStatement("SELECT * FROM subject WHERE rollno = ?");
        psSub.setString(1, rollno);
        ResultSet rsSub = psSub.executeQuery();

        PreparedStatement psMark = c.c.prepareStatement("SELECT * FROM marks WHERE rollno = ?");
        psMark.setString(1, rollno);
        ResultSet rsMark = psMark.executeQuery();

        boolean subjectFound = rsSub.next();
        boolean marksFound = rsMark.next();

        if (!subjectFound && !marksFound) {
            JOptionPane.showMessageDialog(null, "No results found for roll number: " + rollno);
            dispose();
            return;
        }

        if (subjectFound) {
            subjectLabels[0].setText("Subject 1: " + rsSub.getString("subject1"));
            subjectLabels[1].setText("Subject 2: " + rsSub.getString("subject2"));
            subjectLabels[2].setText("Subject 3: " + rsSub.getString("subject3"));
            subjectLabels[3].setText("Subject 4: " + rsSub.getString("subject4"));
            subjectLabels[4].setText("Subject 5: " + rsSub.getString("subject5"));
        } else {
            for (JLabel lbl : subjectLabels) {
                lbl.setText("Subject: Not available");
            }
        }

        if (marksFound) {
            subjectLabels[0].setText(subjectLabels[0].getText() + "  ---  Marks: " + rsMark.getString("mark1"));
            subjectLabels[1].setText(subjectLabels[1].getText() + "  ---  Marks: " + rsMark.getString("mark2"));
            subjectLabels[2].setText(subjectLabels[2].getText() + "  ---  Marks: " + rsMark.getString("mark3"));
            subjectLabels[3].setText(subjectLabels[3].getText() + "  ---  Marks: " + rsMark.getString("mark4"));
            subjectLabels[4].setText(subjectLabels[4].getText() + "  ---  Marks: " + rsMark.getString("mark5"));

            lblsemester.setText("Semester: " + rsMark.getString("semester"));
        } else {
            lblsemester.setText("Semester: Not available");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error occurred.");
        dispose();
        return;
    }

    cancel = new JButton("Back");
    cancel.setBounds(270, 400, 120, 25);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(cancel);

    setVisible(true);
}

    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new marks("");
    }
}


