package CreditcardDetails;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;












import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.*;

import java.sql.PreparedStatement;
import static CreditcardDetails.Connection.*;

public class Creditcard {
    //Creditcard() {
    Creditcard() {

        final Connection c = new Connection();
        Display display = new Display();
        final Shell shell = new Shell();
        shell.setSize(1000, 1000);


        Button b1 = new Button(shell, SWT.NONE);
        b1.setBounds(30, 30, 300, 60);
        b1.setText("show all credit cards(f11)");


        Label label1 = new Label(shell, SWT.BORDER);
        label1.setBounds(30, 100, 200, 40);
        label1.setText("Card Holder *");

        final Text text1 = new Text(shell, SWT.BORDER);
        text1.setBounds(30, 150, 600, 40);
        text1.setText("");

        Label label2 = new Label(shell, SWT.BORDER);
        label2.setBounds(30, 200, 200, 40);
        label2.setText("Credit or Debit Card");


        final Text text2 = new Text(shell, SWT.BORDER);
        text2.setBounds(30, 250, 200, 40);
        text2.setText("");
        text2.setTextLimit(16);


        Label label3 = new Label(shell, SWT.BORDER);
        label3.setBounds(30, 300, 200, 40);
        label3.setText("Expiration Date *");

        Combo combo1 = new Combo(shell, SWT.DROP_DOWN);
        combo1.setItems(new String[]{"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "navamber", "desember"});
        combo1.setBounds(30, 350, 50, 40);
        combo1.select(0);

        Combo combo2 = new Combo(shell, SWT.DROP_DOWN);
        combo2.setItems(new String[]{"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"});
        combo2.setBounds(100, 350, 50, 40);
        combo2.select(7);


        Label label9 = new Label(shell, SWT.BORDER);
        label9.setBounds(600, 320, 200, 40);
        label9.setText(" security code *");


        final Text text9 = new Text(shell, SWT.BORDER);
        text9.setBounds(600, 380, 200, 40);
        text9.setText("");
        text9.setEchoChar('*');

        Label label4 = new Label(shell, SWT.BORDER);
        label4.setBounds(30, 400, 100, 30);
        label4.setText("Address *");

        final Text text4 = new Text(shell, SWT.BORDER);
        text4.setBounds(200, 400, 100, 30);
        text4.setText("");


        Label label5 = new Label(shell, SWT.BORDER);
        label5.setBounds(30, 450, 100, 30);
        label5.setText("Address 2");


        final Text text5 = new Text(shell, SWT.BORDER);
        text5.setBounds(200, 450, 100, 30);
        text5.setText("");


        Label label6 = new Label(shell, SWT.BORDER);
        label6.setBounds(30, 500, 100, 30);
        label6.setText("Zip Code *");

        final Text text6 = new Text(shell, SWT.BORDER);
        text6.setBounds(200, 500, 100, 30);
        text6.setText("");


        Label label7 = new Label(shell, SWT.BORDER);
        label7.setBounds(30, 550, 100, 30);
        label7.setText("City");


        final Text text7 = new Text(shell, SWT.BORDER);
        text7.setBounds(200, 550, 100, 30);
        text7.setText("");


        Label label8 = new Label(shell, SWT.BORDER);
        label8.setBounds(30, 600, 100, 30);
        label8.setText("State");

        final Text text8 = new Text(shell, SWT.BORDER);
        text8.setBounds(200, 600, 100, 30);
        text8.setText("");

        Button b2 = new Button(shell, SWT.CHECK);
        b2.setBounds(30, 700, 150, 40);
        b2.setText("Set As Default");


        final Button b3 = new Button(shell, SWT.PUSH);
        b3.setBounds(30, 800, 100, 40);
        //b3.setText("SAVE(F10)");
        b3.setText("&Save\tF10/");
        //b3.setAccelerator(SWT.F10);


        Button b4 = new Button(shell, SWT.BORDER);
        b4.setText("CANCEL(F9)");
        b4.setBounds(170, 800, 100, 40);

        text9.addVerifyListener(new VerifyListener() {

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
                if (verifyEvent.text.charAt(0) == 5) {
                    text9.setTextLimit(3);
                } else if (verifyEvent.text.charAt(0) != 5) {
                    text9.setTextLimit(4);

                }
            }
        });
                /*text2.addListener(SWT.Traverse, new Listener() {
                    public void handleEvent(Event event) {
                        switch (event.detail) {
                            case SWT.TRAVERSE_ESCAPE:
                                event.detail = SWT.TRAVERSE_NONE;
                                event.doit = false;
                                break;
                        }
                    }
                });*/


       /* b3.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {*/
        class Open implements SelectionListener {
            public void widgetSelected(SelectionEvent event) {

                String s1 = text1.getText();
                setCardholder(s1);

                String s2 = text2.getText();
                long i = Long.parseLong(s2);
                setCreditordebit(i);

                String s4 = text4.getText();
                setAddress(s4);

                String s5 = text5.getText();
                setAddress2(s5);

                String s6 = text6.getText();
                int j = Integer.parseInt(s6);
                setZipcode(j);

                String s7 = text7.getText();
                setCity(s7);

                String s8 = text8.getText();
                setState(s8);

                String s9 = text9.getText();
                int k = Integer.parseInt(s9);
                setSecuritycode(k);

                c.savingbooks();
                System.out.println("entered details are" + s1 + "\n" + s2 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8 + "\n" + s9);

                if ((s1 == "") || (s2 == "") || (s4 == "") || (s6 == "") || (s9 == "")) {
                    MessageBox dialougue = new MessageBox(shell, SWT.OK);
                    dialougue.setMessage("mandatory feilds are missing please enter the reuired data");
                    dialougue.open();

                    System.out.println("enter the required details");
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {

            }
        };

        b3.addSelectionListener(new Open());
               /* b4.addSelectionListener(new SelectionAdapter() {
                    public void ButtonSelected(SelectionEvent e) {



                        text2.setText("");
                        text4.setText("");
                        text5.setText("");
                        text6.setText("");
                        text7.setText("");
                        text8.setText("");
                        text9.setText("");
                    }

                    });


                b2.addSelectionListener(new SelectionAdapter() {
                    public void ButtonSelected(SelectionEvent e) {

                        
                        c.setasdefault();
                        MessageBox dialougue = new MessageBox(shell, SWT.OK);
                        dialougue.setMessage("your details are filled");
                        dialougue.open();



                        final ControlEditor editor = new ControlEditor(shell);
                        editor.grabHorizontal = true;
                        editor.grabVertical = true;


                            }

                });*/
       /* TraverseListener traverseListener1 = new TraverseListener() {
            public void keyTraversed(TraverseEvent e) {
                if (e.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
                    e.doit = false;
                }
                if (e.detail==SWT.TRAVERSE_ESCAPE){

                }
            }

        };


        TraverseListener traverseListener2 = new TraverseListener() {
            public void keyTraversed(TraverseEvent e) {
                if (e.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
                    e.doit = false;
                }
            }

        };
        text1.addTraverseListener(traverseListener1);
        text2.addTraverseListener(traverseListener1);
        text1.addTraverseListener(traverseListener2);*/


        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();

    }

   /* public void setAccelerator (int accelerator) {
        checkWidget ();
        if (this.accelerator == accelerator) return;
        this.accelerator = accelerator;
        parent.destroyAccelerators ();
    }*/

    public static void main(String[] args) {
        new Creditcard();

    }

}




