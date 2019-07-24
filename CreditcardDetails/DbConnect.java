package CreditcardDetails;

import java.sql.Connection;
import java.sql.DriverManager;


    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnect {

        public  static java.sql.Connection con;
        static {
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/savedetails","root","root");

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        static Connection getCon(){
            return con;
        }

    }


