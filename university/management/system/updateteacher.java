package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateteacher extends JFrame implements ActionListener {

    ModernTextField tfsalary, tfaddress, tfphone, tfemail;
    
    JLabel labelempId,labelhire,labelqualification;
    ModernButton submit, cancel;
    Choice cEmpId;
    JComboBox cbexperience;

    updateteacher() {
        setSize(900, 600);
        setLocation(200, 50);
        setLayout(null);
        getContentPane().setBackground(UIUtils.COLOR_BACKGROUND);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(UIUtils.FONT_HEADER_LARGE);
        heading.setForeground(UIUtils.COLOR_TEXT_PRIMARY);
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Employee Id");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(UIUtils.FONT_BODY);
        add(lblrollnumber);

        cEmpId = new Choice();
        cEmpId.setBounds(250, 100, 200, 20);
        add(cEmpId);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from faculty");
            while (rs.next()) {
                cEmpId.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(UIUtils.FONT_BODY);
        add(labelname);
//father name
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(UIUtils.FONT_BODY);
        add(labelfname);
//empid
        JLabel lblroll = new JLabel("Employee Id");
        lblroll.setBounds(50, 200, 200, 30);
        lblroll.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblroll);

        labelempId = new JLabel();
        labelempId.setBounds(200, 200, 200, 30);
        labelempId.setFont(UIUtils.FONT_BODY);
        add(labelempId);
//dob
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(UIUtils.FONT_BODY_BOLD);
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(UIUtils.FONT_BODY);
        add(labeldob);
//address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(UIUtils.FONT_BODY_BOLD);
        add(lbladdress);

        tfaddress = new ModernTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
//phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblphone);

        tfphone = new ModernTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
//email
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblemail);

        tfemail = new ModernTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
//experience

 JLabel lblexperience = new JLabel("Experience");
        lblexperience.setBounds( 400, 300, 200, 30);
        lblexperience.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblexperience);
        
        String experience[] = {"1","2","3","4","5","5+"};
         cbexperience = new JComboBox(experience);
        cbexperience.setBounds(600, 300, 150, 30 );
        cbexperience.setFont(UIUtils.FONT_BODY);
        add(cbexperience);

       
//hiredate
        JLabel lblhiredate = new JLabel("Hire date");
        lblhiredate.setBounds(50, 350, 200, 30);
        lblhiredate.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblhiredate);

     labelhire = new JLabel();
        labelhire.setBounds(200, 350, 150, 30);
        labelhire.setFont(UIUtils.FONT_BODY);
        add(labelhire);
//cnic
        JLabel lblcnic = new JLabel("CNIC Number");
        lblcnic.setBounds(400, 350, 200, 30);
        lblcnic.setFont(UIUtils.FONT_BODY_BOLD);
        add(lblcnic);

        JLabel labelcnic = new JLabel();
        labelcnic.setBounds(600, 350, 150, 30);
        labelcnic.setFont(UIUtils.FONT_BODY);
        add(labelcnic);
        
     
//    qualification 

             JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(50, 400, 200, 30);
        qualification.setFont(UIUtils.FONT_BODY_BOLD);
        add(qualification);
        
    labelqualification=new JLabel();
    labelqualification.setBounds(200, 400, 150, 30);
            labelqualification.setFont(UIUtils.FONT_BODY);

        add(labelqualification);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 400, 200, 30);
        salary.setFont(UIUtils.FONT_BODY_BOLD);
        add(salary);

        tfsalary = new ModernTextField();
        tfsalary.setBounds(600, 400, 150, 30);
        add(tfsalary);

        try {
            conn c = new conn();
            String query = "select * from faculty where rollno='" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fathername"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                 cbexperience.setSelectedItem(rs.getString("experience"));
                        labelhire.setText(rs.getString("hiredate"));
                labelcnic.setText(rs.getString("cnic"));
                labelempId.setText(rs.getString("rollno"));
                labelqualification.setText(rs.getString("qualification"));
                tfsalary.setText(rs.getString("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from faculty where rollno='" + cEmpId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fathername"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        cbexperience.setSelectedItem(rs.getString("experience"));
                        labelhire.setText(rs.getString("hiredate"));
                        labelcnic.setText(rs.getString("cnic"));
                        labelempId.setText(rs.getString("rollno"));
                        labelqualification.setText(rs.getString("qualification"));
                        tfsalary.setText(rs.getString("salary"));
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

        String empId = labelempId.getText().trim();
        String address = tfaddress.getText().trim();
        String phone = tfphone.getText().trim();
        String email = tfemail.getText().trim();
        String salary = tfsalary.getText().trim();
        String experience = (String) cbexperience.getSelectedItem();

        // -------- BASIC VALIDATIONS --------

        if (empId.equals("") || address.equals("") || phone.equals("")
                || email.equals("") || salary.equals("")) {

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

        // Salary validation
        try {
            double sal = Double.parseDouble(salary);
            if (sal <= 0) {
                JOptionPane.showMessageDialog(null, "Salary must be greater than 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Salary must be numeric");
            return;
        }

        // -------- UPDATE QUERY --------
        try {
            String query = "update faculty set address='" + address + "', phone='" + phone + "', email='" + email
                    + "', experience='" + experience + "', salary='" + salary
                    + "' where rollno='" + empId + "'";

            conn c = new conn();
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
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
        new updateteacher();
    }
}
