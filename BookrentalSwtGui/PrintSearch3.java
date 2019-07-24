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

public class PrintSearch3 {

         private  Table  table;

        public void open(final Long i, final Display display) {

            final Shell shell = new Shell();
            shell.setSize(1000,1000);
            //shell.dispose();
            final Long isbn = i;
           // Display display = Display.getDefault();
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
                            PreparedStatement ps = con.prepareStatement("select * from addbook  where IsbnNo=?");
                            ps.setLong(1, i);
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
                    TableColumn c4 = new TableColumn(table, SWT.NONE);
                    c4.setWidth(100);
                    c4.setText("totalbooks");
                }
            }

            Button button1 = new Button(shell, SWT.PUSH);
            button1.setBounds(350,300,1000,1000);
            button1.setText("Delete");


            Button button2 = new Button(shell, SWT.PUSH);
            button2.setBounds(350,300,1000,1000);
            button2.setText("Rent");

            Button button3 = new Button(shell, SWT.PUSH);
            button3.setBounds(350,300,1000,1000);
            button3.setText("Goto Home");




            button1.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected (SelectionEvent e){
                    System.out.println(e.getSource() + "Button1 was clicked");
                    try {
                        shell.dispose();
                        new DeleteBook3(i,display);

                        MessageBox dialougue = new MessageBox(shell, SWT.OK);
                        dialougue.setMessage("The Book Has Deleted From The Catalog");
                        int rc =dialougue.open();
                        switch (rc) {
                            case SWT.OK:
                                System.out.println("SWT.OK");
                                return;

                        }

                    } catch (Exception a) {
                    }

                }
            });


            button2.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected (SelectionEvent e){
                    System.out.println(e.getSource() + "Button1 was clicked");
                    try {
                        shell.dispose();
                        BorrowerEntry borrowerEntry= new BorrowerEntry();
                        borrowerEntry.dataEntryc(display);

                        MessageBox dialougue = new MessageBox(shell, SWT.OK);
                        dialougue.setMessage("The Book Has rented From The Catalog");
                        int rc =dialougue.open();
                        switch (rc) {
                            case SWT.OK:
                                System.out.println("SWT.OK");
                                return;

                        }

                    } catch (Exception a) {
                    }

                }
            });
            button3.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    System.out.println(e.getSource());
                    try {
                        shell.dispose();
                        //new BookRentalHome();
                       // shell.isDisposed();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
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





