
package BookrentalSwtGui;

import java.sql.Connection;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnect3 {


   // public static void main(String[] args) {

        private static Connection con= DbConnect1.getCon();
        private String authorName;
        private String title;
        private int ISBN;
        private int totalCount;

        private int isbn;
        private String firstname;
        private String lastname;
        private String email;
        private int rentdays;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DbConnect3.con = con;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
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

    public int getRentdays() {
        return rentdays;
    }

    public void setRentdays(int rentdays) {
        this.rentdays = rentdays;
    }

    @Override
    public String toString() {
        return "DbConnect3{" +
                "authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", totalCount=" + totalCount +
                ", isbn=" + isbn +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", rentdays=" + rentdays +
                '}';
    }
}
