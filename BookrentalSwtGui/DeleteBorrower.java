package BookrentalSwtGui;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBorrower {


    public DeleteBorrower(String i) {
        try {
            Connection con = DbConnect1.getCon();
            PreparedStatement ps = con.prepareStatement("delete from borrowerlist where firstname=?");
            ps.setString(1, i);
            ps.executeUpdate();
            System.out.println("data deleted from database");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}

