package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class addfaculty extends JFrame implements ActionListener {

    JComboBox cbexperience,cbqualification;
    ModernTextField tfname, tffathername, tfaddress, tfphone, tfemail, tfcnic;
    
    JDateChooser dcdob,dchire;
    JLabel tfempId;
  ModernTextField  tfsalary ;
    ModernButton submit, cancle;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    addfaculty() {
        setSize(800, 550);
        setLocation(200, 100);
        setLayout(null);
        getContentPane().setBackground(UIUtils.COLOR_BACKGROUND);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(250, 30, 400, 40);
        heading.setFont(UIUtils.FONT_HEADER);
        heading.setForeground(UIUtils.COLOR_TEXT_PRIMARY);
        add(heading);
//name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 100, 100, 30);
        lblname.setFont(UIUtils.FONT_BODY);
        add(lblname);

        tfname = new ModernTextField();
        tfname.setBounds(200, 100, 150, 30);
        add(tfname);
//father
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 100, 150, 30);
        lblfname.setFont(UIUtils.FONT_BODY);
        add(lblfname);

        tffathername = new ModernTextField();
        tffathername.setBounds(600, 100, 150, 30);
        add(tffathername);
//id
        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 150, 100, 30);
        lblempId.setFont(UIUtils.FONT_BODY);
        add(lblempId);

        tfempId = new JLabel("101" + first4);
        tfempId.setBounds(200, 150, 150, 30);
        tfempId.setFont(UIUtils.FONT_SUBHEADER);
        add(tfempId);
//dob
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400, 150, 150, 30);
        lbldob.setFont(UIUtils.FONT_BODY);
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 150, 150, 30);
        add(dcdob);
//address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 200, 100, 30);
        lbladdress.setFont(UIUtils.FONT_BODY);
        add(lbladdress);

        tfaddress = new ModernTextField();
        tfaddress.setBounds(200, 200, 150, 30);
        add(tfaddress);
//phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 200, 150, 30);
        lblphone.setFont(UIUtils.FONT_BODY);
        add(lblphone);

        tfphone = new ModernTextField();
        tfphone.setBounds(600, 200, 150, 30);
        add(tfphone);
//email
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 250, 100, 30);
        lblemail.setFont(UIUtils.FONT_BODY);
        add(lblemail);

        tfemail = new ModernTextField();
        tfemail.setBounds(200, 250, 150, 30);
        add(tfemail);
//qualification
        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(400, 250, 150, 30);
        qualification.setFont(UIUtils.FONT_BODY);
        add(qualification);
        
        String qualify[] = { "Bsc", "BA", "MBA", "MSc", "BSC", "Mcom", "MA", "B.Tech", "BBA", "BCA", "MBA", "BSSE", "BSCS" };
         cbqualification=new JComboBox(qualify);
        cbqualification.setBounds(600, 250, 150, 30);
        add(cbqualification);
//hiredate

   
    
        
       JLabel lblhire = new JLabel("Date Of Birth");
        lblhire.setBounds(50, 300, 100, 30);
        lblhire.setFont(UIUtils.FONT_BODY);
        add(lblhire);

        dchire = new JDateChooser();
        dchire.setBounds(200, 300, 150, 30);
        add(dchire);

        JLabel lblcnic = new JLabel("CNIC Number");
        lblcnic.setBounds(400, 300, 150, 30);
        lblcnic.setFont(UIUtils.FONT_BODY);
        add(lblcnic);

        tfcnic = new ModernTextField();
        tfcnic.setBounds(600, 300, 150, 30);
        add(tfcnic);

        JLabel lblcourse = new JLabel("Experience");
        lblcourse.setBounds(50, 350, 100, 30);
        lblcourse.setFont(UIUtils.FONT_BODY);
        add(lblcourse);

        String experience[] = {"1","2","3","4","5","5+"};
        cbexperience = new JComboBox(experience);
        cbexperience.setBounds(200, 350, 150, 30);
        cbexperience.setBackground(Color.WHITE);
        add(cbexperience);
//salary...................................

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(400, 350, 150, 30);
        lblsalary.setFont(UIUtils.FONT_BODY);
        add(lblsalary);
        
        tfsalary=new ModernTextField();
          tfsalary.setBounds(600, 350, 150, 30);
        tfsalary.setBackground(Color.WHITE);
        add(tfsalary);
        

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
        String fname = tffathername.getText().trim();
        String empid = tfempId.getText();

        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String hiredate = ((JTextField) dchire.getDateEditor().getUiComponent()).getText();

        String address = tfaddress.getText().trim();
        String phone = tfphone.getText().trim();
        String email = tfemail.getText().trim();
        String qualification = (String) cbqualification.getSelectedItem();
        String cnic = tfcnic.getText().trim();
        String experience = (String) cbexperience.getSelectedItem();
        String salary = tfsalary.getText().trim();

        // ---------- BASIC VALIDATIONS ----------

        if (name.equals("") || fname.equals("") || dob.equals("") || hiredate.equals("")
                || address.equals("") || phone.equals("")
                || email.equals("") || cnic.equals("") || salary.equals("")) {

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

        // ---------- DATABASE INSERT ----------
        try {
            String query = "insert into faculty values('" + name + "', '" + fname + "', '" + empid + "', '" + cnic
                    + "', '" + salary + "', '" + qualification + "', '" + phone + "', '" + email + "', '" + dob + "', '"
                    + experience + "', '" + hiredate + "', '" + address + "')";

            conn c = new conn();
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
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
        new addfaculty();
    }
}
