package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class project extends JFrame implements ActionListener{
    project(){
     JMenuItem exi,abouts;   
     
        setSize(1280,680);
//        image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
Image i2=i1.getImage().getScaledInstance(1250,620,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
add(image);
//menubar
JMenuBar mb=new JMenuBar();
//info...............................................................
JMenu newinformation=new JMenu("New Information");
mb.add(newinformation);
newinformation.setForeground(Color.BLUE);
//information items
JMenuItem facultyinfo=new JMenuItem("New Faculty Information");
facultyinfo.setBackground(Color.WHITE);
facultyinfo.addActionListener(this);
newinformation.add(facultyinfo);

JMenuItem studentinfo=new JMenuItem("New student Information");
studentinfo.setBackground(Color.WHITE);
studentinfo.addActionListener(this);
newinformation.add(studentinfo);

setJMenuBar(mb);

//details ...............................................................
JMenu details=new JMenu("View Details");
mb.add(details);
details.setForeground(Color.RED);
//details items
JMenuItem facultydetails=new JMenuItem("View Faculty Information");
facultydetails.setBackground(Color.WHITE);
facultydetails.addActionListener(this);
details.add(facultydetails);

JMenuItem studentdetails=new JMenuItem("View student Information");
studentdetails.setBackground(Color.WHITE);
studentdetails.addActionListener(this);
details.add(studentdetails);

//leave...............................................................
JMenu leave=new JMenu("Apply Leave");
mb.add(leave);
leave.setForeground(Color.BLUE);
//leave items
JMenuItem facultyleave=new JMenuItem("Faculty Leave");
facultyleave.setBackground(Color.WHITE);
facultyleave.addActionListener(this);
leave.add(facultyleave);

JMenuItem studentleave=new JMenuItem("Student Leave");
studentleave.setBackground(Color.WHITE);
studentleave.addActionListener(this);
leave.add(studentleave);


//leave details ...............................................................
JMenu viewleave=new JMenu("View Leave Details");
mb.add(viewleave);
viewleave.setForeground(Color.RED);
//leave details items
JMenuItem viewfacultyleave=new JMenuItem("Faculty Leave Details");
viewfacultyleave.setBackground(Color.WHITE);
viewfacultyleave.addActionListener(this);
viewleave.add(viewfacultyleave);

JMenuItem viewstudentleave=new JMenuItem("View student Leave Details");
viewstudentleave.setBackground(Color.WHITE);
viewstudentleave.addActionListener(this);
viewleave.add(viewstudentleave);


//examination ...............................................................
JMenu exams=new JMenu("Examination");
mb.add(exams);
exams.setForeground(Color.BLUE);
//examinayion items
JMenuItem examinationdetails=new JMenuItem("Examination Results");
examinationdetails.setBackground(Color.WHITE);
examinationdetails.addActionListener(this);
exams.add(examinationdetails);

JMenuItem entermarks=new JMenuItem("Enter Marks");
entermarks.setBackground(Color.WHITE);
entermarks.addActionListener(this);
exams.add(entermarks);

//update..........................................................................
JMenu updateinfo=new JMenu("Update Info ");
mb.add(updateinfo);
updateinfo.setForeground(Color.RED);
//details items
JMenuItem updatefacultyinfo=new JMenuItem("Update Faculty Info");
updatefacultyinfo.setBackground(Color.WHITE);
updatefacultyinfo.addActionListener(this);
updateinfo.add(updatefacultyinfo);

JMenuItem updatestudentinfo=new JMenuItem("Update Student Info");
updatestudentinfo.setBackground(Color.WHITE);
updatestudentinfo.addActionListener(this);
updateinfo.add(updatestudentinfo);

//fees..........................................................................
JMenu fees=new JMenu("Fee Details ");
mb.add(fees);
fees.setForeground(Color.BLUE);
//fees items
JMenuItem feestructure=new JMenuItem("Fee Structure");
feestructure.setBackground(Color.WHITE);
feestructure.addActionListener(this);
fees.add(feestructure);

JMenuItem feeform=new JMenuItem("Student Fee Form ");
feeform.setBackground(Color.WHITE);
feeform.addActionListener(this);
fees.add(feeform);

//utility..........................................................................
JMenu Utility=new JMenu("Utility");
mb.add(Utility);
Utility.setForeground(Color.RED);
//utility items
JMenuItem notepad=new JMenuItem("Note Pad");
notepad.setBackground(Color.WHITE);
notepad.addActionListener(this);
Utility.add(notepad);

JMenuItem calculator=new JMenuItem("Calculator");
calculator.setBackground(Color.WHITE);
calculator.addActionListener(this);
Utility.add(calculator);
//about..........................................................................
JMenu about=new JMenu("About");
mb.add(about);
about.setForeground(Color.BLUE);
//exit items
abouts=new JMenuItem("About Us");
abouts.setBackground(Color.WHITE);
abouts.addActionListener(this);
about.add(abouts);
//exit..........................................................................
JMenu exit=new JMenu("Exit");
mb.add(exit);
exit.setForeground(Color.RED);
//exit items
exi=new JMenuItem("Exit");
exi.setBackground(Color.WHITE);
exi.addActionListener(this);
exit.add(exi);



setJMenuBar(mb);
   setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }
      else if(msg.equals("Calculator")){
        try {
           Runtime.getRuntime().exec("calc.exe");
        } 
        catch (Exception e) {
        }
    }
      else if(msg.equals("Note Pad")){
          try{
              Runtime.getRuntime().exec("notepad.exe");
          }
          catch(Exception e){
              
          }
      }
      else if(msg.equals("New Faculty Information")){
          new addfaculty();
      }
         else if(msg.equals("New student Information")){
          new addstudent();
      }
         else if(msg.equals("View Faculty Information")){
             new teacherdetails();
         }
         else if(msg.equals("View student Information")){
             new studentdetails();
         }
         else if(msg.equals("Student Leave")){
             new studentleave();
         }
           else if(msg.equals("Faculty Leave")){
             new teacherleave();
         }
           else if(msg.equals("Faculty Leave Details")){
              new teacherleavedetails();
         }
             else if(msg.equals("View student Leave Details")){
             new studentleavedetail();
         }
             else if(msg.equals("Update Faculty Info")){
                 new updateteacher();
             }
        
             else if(msg.equals("Update Student Info")){
                 new updatestudent();
             }
             else if(msg.equals("Enter Marks")){
                 new entermarks();
             }
             else if(msg.equals("Examination Results")){
                 new examinationdetail();
             }
             else if(msg.equals("Student Fee Form ")){
                 new studentfeeform();
             }
         else if(msg.equals("Fee Structure")){
                 new feestructure();
             }
           else if(msg.equals("About Us")){
                 new about();
             }
    }
    public static void main(String args[]){
        new project();
    }
}



