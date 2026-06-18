
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class entermarks extends JFrame implements ActionListener{
    Choice crollno;
    JComboBox semester;
    JTextField sub1,mar1,sub2,mar2,sub3,mar3,sub4,mar4,sub5,mar5;
    JButton submit,cancle;
    entermarks(){
        
        
        setSize(950,550);
        setLocation(200,100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
//        image..................................................
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
Image i2=i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(500,20,400,400);
add(image);
//heading
JLabel heading=new JLabel("Enter Marks of Student");
heading.setBounds(20,20,400,40);
heading.setFont(new Font("tahoma",Font.BOLD,30));
add(heading);

JLabel roll=new JLabel("Select Roll No");
roll.setBounds(50,100,150,20);
add(roll);    
// dropdown...............................................................       
        crollno=new Choice();
        crollno.setBounds(200,100,150,20);
        add(crollno);
// rollno search............................................................................
        try{
            conn c=new conn();
            ResultSet rs= c.s.executeQuery("select * from students");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }
//        semester
JLabel sem=new JLabel("Select Semester");
sem.setBounds(50,140,150,20);
add(sem);
String semesters[]={"1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester"};
        semester=new JComboBox(semesters);
        semester.setBounds(200,140,150,20);
                add(semester);
//labels
JLabel sub=new JLabel("Enter Subject");
sub.setBounds(100,180,150,20);
add(sub);

JLabel mar=new JLabel("Enter Marks");
mar.setBounds(300,180,150,20);
add(mar);

//        TextFields
        sub1=new JTextField();
        sub1.setBounds(50,200,200,30);
        add(sub1);
        
        sub2=new JTextField();
        sub2.setBounds(50,250,200,30);
        add(sub2);
        
        sub3=new JTextField();
        sub3.setBounds(50,300,200,30);
        add(sub3);
        
        sub4=new JTextField();
        sub4.setBounds(50,350,200,30);
        add(sub4);
        
        sub5=new JTextField();
        sub5.setBounds(50,400,200,30);
        add(sub5);
        
        mar1=new JTextField();
        mar1.setBounds(260,200,200,30);
        add(mar1);
        
        mar2=new JTextField();
        mar2.setBounds(260,250,200,30);
        add(mar2);
        
        mar3=new JTextField();
        mar3.setBounds(260,300,200,30);
        add(mar3);
        
        mar4=new JTextField();
        mar4.setBounds(260,350,200,30);
        add(mar4);
        
        mar5=new JTextField();
        mar5.setBounds(260,400,200,30);
        add(mar5);
//        button submit
submit=new JButton("Submit");
submit.setBounds(80,450,120,20);
submit.setForeground(Color.WHITE);
submit.setBackground(Color.BLACK);
submit.addActionListener(this);
add(submit);

//button cancle
cancle=new JButton("Cancle");
cancle.setBounds(310,450,120,20);
cancle.setForeground(Color.WHITE);
cancle.setBackground(Color.BLACK);
add(cancle);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    setVisible(true);
        
        
     
       
}
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        // Get values
        String marks1 = mar1.getText().trim();
        String marks2 = mar2.getText().trim();
        String marks3 = mar3.getText().trim();
        String marks4 = mar4.getText().trim();
        String marks5 = mar5.getText().trim();

        String subject1 = sub1.getText().trim();
        String subject2 = sub2.getText().trim();
        String subject3 = sub3.getText().trim();
        String subject4 = sub4.getText().trim();
        String subject5 = sub5.getText().trim();

        String semesterSelected = (String) semester.getSelectedItem();
        String rollno = crollno.getSelectedItem();

        // 1. Check if any subject or marks field is empty
        if (subject1.isEmpty() || subject2.isEmpty() || subject3.isEmpty() || subject4.isEmpty() || subject5.isEmpty() ||
            marks1.isEmpty() || marks2.isEmpty() || marks3.isEmpty() || marks4.isEmpty() || marks5.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All subject and marks fields must be filled");
            return;
        }

        // 2. Validate marks are numbers and between 0-100
        try {
            int m1 = Integer.parseInt(marks1);
            int m2 = Integer.parseInt(marks2);
            int m3 = Integer.parseInt(marks3);
            int m4 = Integer.parseInt(marks4);
            int m5 = Integer.parseInt(marks5);

            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100 || m4 < 0 || m4 > 100 || m5 < 0 || m5 > 100) {
                JOptionPane.showMessageDialog(null, "Marks must be between 0 and 100");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Marks must be valid numbers");
            return;
        }

        try {
            conn c = new conn();
            String duplicateCheck = "select * from marks where rollno='" + rollno + "' and semester='" + semesterSelected + "'";
            ResultSet rs = c.s.executeQuery(duplicateCheck);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Marks for this student and semester already exist");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error during duplicate check");
            return;
        }

        // 4. If all validations pass, insert data
        try {
            conn c = new conn();
            String query1 = "insert into subject values ('" + semesterSelected + "','" + rollno + "','" + subject1 + "','" + subject2 + "','" + subject3 + "','" + subject4 + "','" + subject5 + "')";
            String query2 = "insert into marks values ('" + semesterSelected + "','" + rollno + "','" + marks1 + "','" + marks2 + "','" + marks3 + "','" + marks4 + "','" + marks5 + "')";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error while inserting marks");
        }
    } else {
        setVisible(false);
    }
}

    public static void main(String args[]){
        new entermarks();
    }
}
