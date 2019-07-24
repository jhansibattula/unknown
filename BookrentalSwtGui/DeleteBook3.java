package BookrentalSwtGui;


import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.eclipse.swt.widgets.Display;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBook3 {
   // public void DleteBook3(int i) {

    public DeleteBook3(Long i, Display display){
        try{
            Connection con= DbConnect1.getCon();
            PreparedStatement ps=con.prepareStatement("delete from addbook where isbn=?");
            ps.setLong(1,i);
            ps.executeUpdate();
            System.out.println("data deleted from database");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    }





