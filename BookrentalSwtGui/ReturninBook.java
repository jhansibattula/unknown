package BookrentalSwtGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReturninBook {

    private   long isbn;
    private  int noofbooks;


    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getNoofbooks() {
        return noofbooks;
    }

    public void setNoofbooks(int noofbooks) {
        this.noofbooks = noofbooks;
    }

    public void returningBook(final Display display) {

        Display d = Display.getDefault();
        final Shell shell = new Shell();
        shell.setSize(600, 600);
        shell.setText("Search A Book");


        Label label1 = new Label(shell, SWT.BORDER);
        label1.setText("Enter ISBN Number");
        label1.setSize(180, 60);
        label1.setLocation(10, 30);

        final Text text = new Text(shell, SWT.BORDER);
        text.setText("");
        text.setBounds(250, 30, 180, 60);
        text.setTextLimit(20);

        Label label2 = new Label(shell, SWT.BORDER);
        label2.setText("Enter noof books");
        label2.setSize(180, 60);
        label2.setLocation(10, 150);

        final Text text2 = new Text(shell, SWT.BORDER);
        text2.setText("");
        text2.setBounds(250, 150, 180, 60);
        text2.setTextLimit(20);

        Button button = new Button(shell, SWT.PUSH);
        button.setText("Return");
        button.setBounds(30, 300, 180, 60);



        text.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent verifyEvent) {

                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT ||
                        verifyEvent.keyCode == SWT.ARROW_RIGHT ||
                        verifyEvent.keyCode == SWT.DEL ||
                        verifyEvent.keyCode == SWT.CTRL
                ){
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);


                        if ( ! allow ) {
                            MessageBox dialougue = new MessageBox(shell, SWT.OK);
                            dialougue.setMessage("please enter the digits");
                            dialougue.open();
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }

            }
        });


        text2.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent verifyEvent) {

                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT ||
                        verifyEvent.keyCode == SWT.ARROW_RIGHT ||
                        verifyEvent.keyCode == SWT.DEL ||
                        verifyEvent.keyCode == SWT.CTRL
                ){
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);


                        if ( ! allow ) {
                            MessageBox dialougue = new MessageBox(shell, SWT.OK);
                            dialougue.setMessage("please enter the digits");
                            dialougue.open();
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }

            }
        });

        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button3 was clicked");
                try {
                    Long isbn = Long.parseLong(text.getText());
                    int noofbooks =Integer.parseInt(text2.getText());
                    updateRentBooks2(isbn,noofbooks);
                    updateTotalBooks2(isbn,noofbooks);


                    MessageBox dialougue = new MessageBox(shell, SWT.OK);
                    dialougue.setMessage("The book has returned succssecfully");
                    dialougue.open();
                    shell.dispose();


                } catch (Exception a) {
                }

            }
        });
        shell.open();
        /*while (!shell.isDisposed()) {
            if (d.readAndDispatch()) {
                d.sleep();
            }
        }
        d.dispose();*/

    }

    public void updateTotalBooks2(long isbn, int noofbooks) {
        try {

            Connection con = DbConnect1.getCon();
            PreparedStatement ps = con.prepareStatement("update addbook set totalbooks= totalbooks+? WHERE IsbnNo =?");
            ps.setInt(1,noofbooks);
            ps.setLong(2,isbn);
            int n = ps.executeUpdate();
            if (n == 1) {
                System.out.println(" total books data updataed");
            } else {
                System.out.println("total books data not updated");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateRentBooks2(Long isbn,int noofbooks){

        try {

            Connection con = DbConnect1.getCon();
            PreparedStatement ps = con.prepareStatement("update borrowerlist set noofbooks= noofbooks- ? WHERE isbn =?");
            ps.setInt(1,noofbooks);
            ps.setLong(2,isbn);
            int n= ps.executeUpdate();
            if(n==1) {
                System.out.println(" rent books data updataed");
            }
            else {
                System.out.println(" rent books data not updated");
            }
            if(getNoofbooks()==0){
                deleteborrower();
            }


        } catch (Exception e) {
            System.out.println("database not connected");
        }
    }





    public void deleteborrower(){

        try {

            Connection con = DbConnect1.getCon();
            PreparedStatement ps = con.prepareStatement("delete from bookr.borrowerlist where noofbooks=0");
           // ps.setInt(1,noofbooks);
            //s.setLong(2,isbn);
            int n= ps.executeUpdate();
            if(n==1) {
                System.out.println(" rent books data updataed");
            }
            else {
                System.out.println(" rent books data not updated");
            }
        } catch (Exception e) {
            System.out.println("database not connected");
        }
    }


}
