package BookrentalSwtGui;

import org.eclipse.swt.widgets.Display;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BorrowerDetails {
    private static Connection con = DbConnect1.getCon();
    private Long isbn;
    private String firstname;
    private String lastname;
    private String email;
    private int noofbooks;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BorrowerDetails{" +
                "isbn=" + isbn +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", noofRentbooks=" + noofbooks +
                '}';
    }

    public int getNoofRentbooks() {
        return noofbooks;
    }

    public void setNoofRentbooks(int noofRentbooks) {
        this.noofbooks = noofRentbooks;
    }


    public void addingBorrower(Display display) {

        try {


            String query = " insert into borrowerlist values(? ,?, ? ,?,? )";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setLong(1, this.getIsbn());
            ps.setString(2, this.getFirstname());
            ps.setString(3, this.getLastname());
            ps.setString(4, this.getEmail());
            ps.setInt(5, this.getNoofRentbooks());
            int n = ps.executeUpdate();
            if (n == 1) {
                System.out.println("record inserted succesfully");
            } else {
                System.out.println("record not inserted sucessfully");
            }
        } catch (Exception e) {
            System.out.println();
        }

    }
}






