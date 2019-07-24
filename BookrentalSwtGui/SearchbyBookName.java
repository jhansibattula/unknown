package BookrentalSwtGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

public class SearchbyBookName {

        public SearchbyBookName(final Display display) {

            //Display d = Display.getDefault();
            final Shell shell = new Shell();
            shell.setSize(600, 600);
            shell.setText("Search A Book");

            Label label1 = new Label(shell, SWT.BORDER);
            label1.setText("Enter  Book Name");
            label1.setSize(180, 60);
            label1.setLocation(10, 30);


            final Text text = new Text(shell, SWT.BORDER);
            text.setText("");
            text.setBounds(250, 30, 180, 60);
            text.setTextLimit(20);

            Button button = new Button(shell, SWT.PUSH);
            button.setText("Search");
            button.setBounds(200, 100, 180, 60);

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
                        allow = Character.isAlphabetic(c) || Character.isWhitespace(c);


                        if ( ! allow ) {
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
        button.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    System.out.println(e.getSource() + "Button3 was clicked");
                    try {
                        //shell.dispose();
                        String bookname = text.getText();
                        PrintSearch2 J = new PrintSearch2();
                        J.open2(bookname,display);

                    } catch (Exception a) {
                    }
                    shell.dispose();
                }
            });
            shell.open();
           /* while (!shell.isDisposed()) {
                if (d.readAndDispatch()) {
                    d.sleep();
                }
            }*/
           // d.dispose();

        }
    }


