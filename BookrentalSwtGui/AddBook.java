package BookrentalSwtGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;
    import java.awt.print.Book;
import java.sql.DriverManager;

public class AddBook extends BookDetails {

    //Display d =Display.getDefault();

    public void add(Display display) {
        final Shell shell = new Shell();
        shell.setSize(500, 500);
        shell.setText("Enter The Below Details");

        Label label1 = new Label(shell, SWT.BORDER);
        label1.setText("Author Name");
        label1.setSize(150, 30);
        label1.setLocation(10, 30);

        Label label2 = new Label(shell, SWT.BORDER);
        label2.setText("Book Title");
        label2.setSize(150, 30);
        label2.setLocation(10, 100);

        Label label3 = new Label(shell, SWT.BORDER);
        label3.setText("Isbn");
        label3.setSize(150, 30);
        label3.setLocation(10, 170);


        Label label5 = new Label(shell, SWT.BORDER);
        label5.setText("Total Books");
        label5.setSize(150, 30);
        label5.setLocation(10, 240);


        final Text text1 = new Text(shell, SWT.BORDER);
        text1.setText("");
        text1.setBounds(250, 30, 180, 30);
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

        Button button1 = new Button(shell, SWT.PUSH);
        button1.setText("Add To Cataog");
        button1.setLocation(180, 350);
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
                        allow = Character.isAlphabetic(c) || Character.isWhitespace(c);


                        if (!allow) {
                            MessageBox dialougue = new MessageBox(shell, SWT.OK);
                            dialougue.setMessage("please enter the Alphabets");
                            dialougue.open();
                            break;
                        }
                    }
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
                setAuthorName(s1);

                String s2 = text2.getText();
                setTitle(s2);

                String s3 = text3.getText();
                if ((s3 == "")) {
                    MessageBox messageBox = new MessageBox(shell, SWT.OK);
                    messageBox.setMessage("please fill the all details ");
                    int rc = messageBox.open();
                    switch (rc) {
                        case SWT.OK:
                            System.out.println("SWT.OK");
                            return;

                    }
                }
                // int i = Integer.parseInt(s3);
                Long i = Long.parseLong(s3);
                setISBN(i);

                String s4 = text5.getText();
                if ((s4 == "")) {
                    MessageBox messageBox = new MessageBox(shell, SWT.OK);
                    messageBox.setMessage("please fill the all details");
                    int rc = messageBox.open();
                    switch (rc) {
                        case SWT.OK:
                            System.out.println("SWT.OK");
                            return;

                    }
                }

                int j = Integer.parseInt(s4);
                setTotalCount(j);

                if ((s1 == "") || (s2 == "")) {
                    MessageBox messageBox = new MessageBox(shell, SWT.OK);
                    messageBox.setMessage(" please fill the all data");
                    int rc = messageBox.open();
                    switch (rc) {
                        case SWT.OK:
                            System.out.println("SWT.OK");
                            return;

                    }
                }
                addingBooks();
                System.out.println(s1 + s2 + s3 + s4);
                shell.dispose();


            }
        });



            shell.open();
           /* while (!shell.isDisposed()) {
                if (!display.readAndDispatch())
                    display.sleep();
            }
            display.dispose();*/
        }
    }


