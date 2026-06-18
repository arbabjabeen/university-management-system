package university.management.system;

import java.sql.*;

public class conn {

    public Connection c;
    public Statement s;

    public conn() { 
        try {
         
            Class.forName("com.mysql.cj.jdbc.Driver");

         
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "1234");
            s = c.createStatement();
        }
      catch(Exception e){
              e.printStackTrace();
              }
    }


}
