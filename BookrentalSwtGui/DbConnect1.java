package BookrentalSwtGui;

import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnect1 {

        public  static Connection con;
        static {
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookr","root","root");

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        static Connection getCon(){
            return con;
        }

}
