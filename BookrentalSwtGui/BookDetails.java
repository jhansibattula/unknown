package BookrentalSwtGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDetails {

    private static Connection con = DbConnect1.getCon();
    private String authorName;
    private String title;
    private long ISBN;
    private int totalCount;


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthorName(String name) {
        this.authorName = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", totalCount=" + totalCount +
                '}';
    }

    public void addingBooks() {
        Shell shell = new Shell();

        try {

            String query = " insert into addbook values (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, this.getAuthorName());
            ps.setString(2, this.getTitle());
            ps.setLong(3, this.getISBN());
            ps.setInt(4, this.getTotalCount());
            int n = ps.executeUpdate();


            if (n == 1) {
                System.out.println("record inserted succesfully");
                MessageBox dialougue = new MessageBox(shell, SWT.OK);
                dialougue.setMessage("The Book Has Added To The Catalog ");
                dialougue.open();

            } else {
                System.out.println("record not inserted sucessfully");
                MessageBox dialougue = new MessageBox(shell, SWT.OK);
                dialougue.setMessage("The Book Has not Added To The Catalog ");
                dialougue.open();

            }
        } catch (Exception e) {
            MessageBox dialougue = new MessageBox(shell, SWT.OK);
            dialougue.setMessage("the book has already exist with same isbn & You are not allowed to add these books");
            int rc = dialougue.open();
            switch (rc) {
                case SWT.OK:
                    System.out.println("SWT.OK");
                    //new AddBook();
                    return;


            }


        }
        shell.open();


    }


}

