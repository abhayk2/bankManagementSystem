package bankmanagementsystem;
import java.sql.*;
public class Connections {

    Connection c ;
    Statement s;
    public Connections(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "Abhay@123");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
