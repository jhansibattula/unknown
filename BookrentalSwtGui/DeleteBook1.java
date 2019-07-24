package BookrentalSwtGui;

import org.eclipse.swt.widgets.Display;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBook1 {

   // public DeleteBook1() {


   public void DleteBook1(String s, Display display) {


            try{
                Connection con= DbConnect1.getCon();
                PreparedStatement ps=con.prepareStatement("delete from addbook where authorname=?");
                ps.setString(1,s);
                ps.executeUpdate();
                System.out.println("data deleted from database");

            }catch(Exception e){
                System.out.println(e.getMessage());
            }


        }



    }





