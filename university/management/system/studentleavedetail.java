
package university.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;

public class studentleavedetail extends JFrame implements ActionListener {
    Choice croll;
    JButton search, add, update, cancle, print;
    JTable table;
    JScrollPane jsp;

    studentleavedetail() {
        setSize(700, 500);
        setLocation(200, 50);
        setLayout(null);
        JLabel heading = new JLabel("Search By Roll No.");
        heading.setBounds(20, 20, 150, 20);
        heading.setFont(new Font("serif", Font.BOLD, 18));
        add(heading);
        getContentPane().setBackground(Color.WHITE);

        // table
        // scroll...................................................
        table = new JTable();
        jsp = new JScrollPane(table);
        jsp.setBounds(50, 100, 600, 350);
        add(jsp);
        // dropdown
        croll = new Choice();
        croll.setBounds(180, 20, 200, 20);
        add(croll);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select *from students");
            while (rs.next()) {
                croll.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // button
        // update...........................................................................
        update = new JButton("Update");
        update.setBounds(20, 60, 100, 20);
        update.addActionListener(this);
        add(update);
        // button
        // search...........................................................................
        search = new JButton("Search");
        search.setBounds(140, 60, 100, 20);
        search.addActionListener(this);
        add(search);
        // button print
        // ...........................................................................
        print = new JButton("Print");
        print.setBounds(260, 60, 100, 20);
        print.addActionListener(this);
        add(print);
        // button
        // cancle...........................................................................
        cancle = new JButton("Cancle");
        cancle.setBounds(500, 60, 100, 20);
        cancle.addActionListener(this);
        add(cancle);
        // button
        // add...........................................................................
        add = new JButton("Add");
        add.setBounds(380, 60, 100, 20);
        add.addActionListener(this);
        add(add);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select *from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                conn c = new conn();
                String query = "select *from studentleave where rollno='" + croll.getSelectedItem() + "'";
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == add) {
            setVisible(false);
            new studentleave();
        } else if (ae.getSource() == cancle) {
            setVisible(false);
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            // new studentupdate();
        }
    }

    public static void main(String args[]) {
        new studentleavedetail();
    }
}
