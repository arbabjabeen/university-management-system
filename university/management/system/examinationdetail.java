package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

import java.awt.event.*;

public class examinationdetail extends JFrame implements ActionListener {

    JTextField search;
    JButton submit, cancel;
    JTable table;

    examinationdetail() {
        setSize(1000, 500);
        setLocation(200, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);

        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String rollNo = search.getText().trim();

        if (rollNo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a roll number.");
            return;  
        }

        try {
            conn c = new conn();
            String query = "SELECT * FROM students WHERE rollno = '" + rollNo + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
              
                setVisible(false);
                new marks(rollNo);
            } else {
                JOptionPane.showMessageDialog(null, "No student found with roll number: " + rollNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error occurred.");
        }
    } else {
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new examinationdetail();
    }
}