
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class studentdetails extends JFrame implements ActionListener {
    Choice crollno;
    JTable stutable;
    JScrollPane jsp;
    JButton search, update, add, cancle, print;

    studentdetails() {
        setSize(900, 600);
        setLocation(300, 50);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // search heading
        JLabel heading = new JLabel("Search By Roll No");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        // dropdown...............................................................
        crollno = new Choice();
        crollno.setBounds(150, 20, 150, 20);
        add(crollno);
        // rollno
        // search............................................................................
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // scroll...................................................
        stutable = new JTable();
        jsp = new JScrollPane(stutable);
        jsp.setBounds(0, 100, 900, 500);
        add(jsp);

        // data added to table....................................................
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            stutable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // button
        // search.................................................................
        search = new JButton("Search");
        search.setBounds(50, 70, 100, 20);
        search.addActionListener(this);
        add(search);
        // button print.................................................................
        print = new JButton("Print");
        print.setBounds(200, 70, 100, 20);
        print.addActionListener(this);
        add(print);
        // button
        // cancle.................................................................
        cancle = new JButton("Cancle");
        cancle.setBounds(650, 70, 100, 20);
        cancle.addActionListener(this);
        add(cancle);
        // button
        // update.................................................................
        update = new JButton("Update");
        update.setBounds(500, 70, 100, 20);
        update.addActionListener(this);
        add(update);

        // button add.................................................................
        add = new JButton("Add");
        add.setBounds(350, 70, 100, 20);
        add.addActionListener(this);
        add(add);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select *from students where rollno = '" + crollno.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                stutable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            setVisible(false);
            new updatestudent();
        } else if (ae.getSource() == cancle) {
            setVisible(false);
        } else if (ae.getSource() == add) {
            setVisible(false);
            new addstudent();
        } else if (ae.getSource() == print) {
            try {
                stutable.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new studentdetails();
    }
}
