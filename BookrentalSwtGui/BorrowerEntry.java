package BookrentalSwtGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BorrowerEntry extends BorrowerDetails {

    //Display d = Display.getDefault();

    public void dataEntryc(final Display display) {
        final Shell shell = new Shell();
        shell.setSize(500, 500);
        shell.setText("Enter The Below Details");

        Label label1 = new Label(shell, SWT.BORDER);
        label1.setText("isbn");
        label1.setSize(150, 30);
        label1.setLocation(10, 380);

        Label label2 = new Label(shell, SWT.BORDER);
        label2.setText("First Name");
        label2.setSize(150, 30);
        label2.setLocation(10, 100);

        Label label3 = new Label(shell, SWT.BORDER);
        label3.setText("Last Name");
        label3.setSize(150, 30);
        label3.setLocation(10, 170);


        Label label5 = new Label(shell, SWT.BORDER);
        label5.setText("Email");
        label5.setSize(150, 30);
        label5.setLocation(10, 240);

        Label label6 = new Label(shell, SWT.BORDER);
        label6.setText("noOfBooks");
        label6.setSize(150, 30);
        label6.setLocation(10, 310);


        final Text text1 = new Text(shell, SWT.BORDER);
        text1.setText("");
        text1.setBounds(250, 380, 180, 30);
        text1.setTextLimit(20);

        final Text text2 = new Text(shell, SWT.BORDER);
        text2.setText("");
        text2.setBounds(250, 100, 180, 30);
        text2.setTextLimit(20);

        final Text text3 = new Text(shell, SWT.BORDER);
        text3.setText("");
        text3.setBounds(250, 170, 180, 30);
        text3.setTextLimit(20);

        final Text text5 = new Text(shell, SWT.BORDER);
        text5.setText("");
        text5.setBounds(250, 240, 180, 30);
        text5.setTextLimit(20);


        final Text text6 = new Text(shell, SWT.BORDER);
        text6.setText("");
        text6.setBounds(250, 310, 180, 30);
        text6.setTextLimit(20);

        Button button1 = new Button(shell, SWT.PUSH);
        button1.setText("Rent Now");
        button1.setLocation(180, 600);
        button1.setSize(350, 80);

        text1.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent verifyEvent) {

                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT ||
                        verifyEvent.keyCode == SWT.ARROW_RIGHT ||
                        verifyEvent.keyCode == SWT.DEL ||
                        verifyEvent.keyCode == SWT.CTRL
                ) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);


                        if (!allow) {
                            MessageBox dialougue = new MessageBox(shell, SWT.OK);
                            dialougue.setMessage("please enter the Alphabets");
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
                ) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isAlphabetic(c) || Character.isWhitespace(c);


                        if (!allow) {
                            MessageBox dialougue = new MessageBox(shell, SWT.OK);
                            dialougue.setMessage("please enter the Alphabets");
                            dialougue.open();
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }

            }
        });
        text3.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent verifyEvent) {

                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT ||
                        verifyEvent.keyCode == SWT.ARROW_RIGHT ||
                        verifyEvent.keyCode == SWT.DEL ||
                        verifyEvent.keyCode == SWT.CTRL
                ) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isAlphabetic(c) || Character.isWhitespace(c);


                        if (!allow) {
                            MessageBox dialougue = new MessageBox(shell, SWT.OK);
                            dialougue.setMessage("please enter the Alphabets");
                            dialougue.open();
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }

            }
        });
        text5.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent verifyEvent) {

                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT ||
                        verifyEvent.keyCode == SWT.ARROW_RIGHT ||
                        verifyEvent.keyCode == SWT.DEL ||
                        verifyEvent.keyCode == SWT.CTRL

                ) {
                    verifyEvent.doit = true;
                }


            }

        });
        text6.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent verifyEvent) {

                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                } else if (verifyEvent.keyCode == SWT.ARROW_LEFT ||
                        verifyEvent.keyCode == SWT.ARROW_RIGHT ||
                        verifyEvent.keyCode == SWT.DEL ||
                        verifyEvent.keyCode == SWT.CTRL
                ) {
                    verifyEvent.doit = true;
                } else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++) {
                        char c = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(c) || Character.isWhitespace(c);


                        if (!allow) {
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

        button1.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String s1 = text1.getText();
                if ((s1 == "")) {
                    MessageBox messageBox = new MessageBox(shell, SWT.OK);
                    messageBox.setMessage("please fill all the details");
                    int rc = messageBox.open();
                    switch (rc) {
                        case SWT.OK:
                            System.out.println("SWT.OK");
                            return;

                    }
                }

                Long i = Long.parseLong(s1);
                setIsbn(i);


                String s2 = text2.getText();
                setFirstname(s2);


                String s3 = text3.getText();
                setLastname(s3);

                String s5 = text5.getText();
                setEmail(s5);

                String s6 = text6.getText();
                if ((s6 == "")) {
                    MessageBox messageBox = new MessageBox(shell, SWT.OK);
                    messageBox.setMessage("please fill all the details");
                    int rc = messageBox.open();
                    switch (rc) {
                        case SWT.OK:
                            System.out.println("SWT.OK");
                            return;

                    }
                }
                int j = Integer.parseInt(s6);
                setNoofRentbooks(j);
                if ((s1 == "") || (s2 == "") || (s3 == "") || (s5 == "")) {
                    MessageBox messageBox = new MessageBox(shell, SWT.OK);
                    messageBox.setMessage("please fill all details");
                    int rc = messageBox.open();
                    switch (rc) {
                        case SWT.OK:
                            System.out.println("SWT.OK");
                            return;

                    }
                }
                boolean status = EmailVerification.email_Valid(text5.getText());
                if (status) {
                    /*MessageBox dialougue = new MessageBox(shell, SWT.OK);
                    dialougue.setMessage("email verified");
                    dialougue.open();
                    shell.dispose();*/


                } else {

                    MessageBox dialougue = new MessageBox(shell, SWT.OK);
                    dialougue.setMessage("enter the valid email");
                    dialougue.open();
                    //shell.dispose();
                    return;

                }
                  //BorrowerDetails =
                BorrowerDetails borrowerDetails= new BorrowerDetails();
                      borrowerDetails.addingBorrower(display);
                   /* MessageBox dialougue = new MessageBox(shell, SWT.OK);
                    dialougue.setMessage("The customer Details  Are Added");
                    dialougue.open();
                    shell.dispose();*/
                   updateTotalBooks();
                   updateRentBooks();

            }
        });

        //shell.dispose();
        shell.open();
        /*while (!shell.isDisposed()) {
            if (!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();*/
    }

    public void updateTotalBooks() {
        try {

            Connection con = DbConnect1.getCon();
            PreparedStatement ps = con.prepareStatement("update addbook set totalbooks= totalbooks- ? WHERE IsbnNo =?");
            ps.setInt(1, getNoofRentbooks());
            ps.setLong(2, getIsbn());
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

    public void updateRentBooks(){

        try {

            Connection con = DbConnect1.getCon();
            PreparedStatement ps = con.prepareStatement("update borrowerlist set noofbooks= noofbooks+ ? WHERE isbn =?");
            ps.setInt(1,getNoofRentbooks());
            ps.setLong(2,getIsbn());
            int n= ps.executeUpdate();
            if(n==1) {
                System.out.println(" rent books data updataed");
            }
            else {
                System.out.println(" rent books data not updated");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
