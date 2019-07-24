package BookrentalSwtGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrintSearch2 {


    private Table table;

    public void open2(final String s, final Display display) {
        final String bookname = s;
        //Display display = Display.getDefault();
        final Shell shell = new Shell();
        shell.setLayout(new GridLayout(1, false));
        shell.setSize(700, 700);
        shell.setText("your book details are");
        {
            table = new Table(shell, SWT.VIRTUAL);
            table.setHeaderVisible(true);
            table.setLinesVisible(true);
            table.setItemCount(1);
            //table.getItems();
            //table.setVisible(true);


            table.addListener(SWT.SetData, new Listener() {
                public void handleEvent(Event event) {

                    try {
                        Connection con = DbConnect1.getCon();
                        PreparedStatement ps = con.prepareStatement("select * from addbook  where bookname =?");
                        ps.setString(1, bookname);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            TableItem item = new TableItem(table, SWT.NONE);
                            item.setText(new String[]
                                    {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
                        }


                    } catch (Exception e) {
                        System.out.println("can not connected to database...");
                    }
                }
            });
            table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            {
                TableColumn c1 = new TableColumn(table, SWT.NONE);
                c1.setWidth(100);
                c1.setText("Author Name");

            }
            {
                TableColumn c2 = new TableColumn(table, SWT.NONE);
                c2.setWidth(100);
                c2.setText("Book Title");
            }
            {
                TableColumn c3 = new TableColumn(table, SWT.NONE);
                c3.setWidth(100);
                c3.setText("Isbn");


            }
            {
                TableColumn c5 = new TableColumn(table, SWT.NONE);
                c5.setWidth(100);
                c5.setText("total Books");
            }
        }

        Button button1 = new Button(shell, SWT.PUSH);
        button1.setBounds(350, 600, 200, 20);
        button1.setText("Delete");

        button1.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button1 was clicked");
                try {
                    //shell.dispose();
                    DeleteBook2 deleteBook2;
                    deleteBook2 = new DeleteBook2();
                    deleteBook2.DeleteBook2(bookname,display);

                } catch (Exception a) {
                }
                MessageBox messageBox = new MessageBox(shell, SWT.OK);
                messageBox.setMessage("The Book has deleted from the catalog");
                int rc =messageBox.open();
                switch (rc) {
                    case SWT.OK:
                        System.out.println("SWT.OK");
                }
                //shell.dispose();
            }
        });

        Button button3 = new Button(shell, SWT.PUSH);
        button3.setBounds(500, 600, 200, 20);
        button3.setText("Back");

        button3.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button3 (go to home)was clicked");
                try {
                    shell.dispose();
                   // new SearchbyBookName(display);
                } catch (Exception a) {
                }
                shell.dispose();
            }
        });
        shell.open();
        /*shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();*/
    }

    }







