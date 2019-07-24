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

public class PrintBorrower {




        private Table table;

        public void openBorrower(final String i, final Display display) {
            final String firstname = i;
           // Display display = Display.getDefault();
            final Shell shell = new Shell();
            shell.setLayout(new GridLayout(1, false));
            shell.setSize(700, 700);
            shell.setText("your Customer details are are");
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
                            PreparedStatement ps = con.prepareStatement("select * from borrowerlist  where firstname=?");
                            ps.setString(1, firstname);
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                TableItem item = new TableItem(table, SWT.NONE);
                                item.setText(new String[]
                                        {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)});
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
                    c1.setText(" First Name");


                }
                {
                    TableColumn c2 = new TableColumn(table, SWT.NONE);
                    c2.setWidth(100);
                    c2.setText(" Last Name");
                }
                {
                    TableColumn c3 = new TableColumn(table, SWT.NONE);
                    c3.setWidth(100);
                    c3.setText(" Email");


                }
                {
                    TableColumn c5 = new TableColumn(table, SWT.NONE);
                    c5.setWidth(100);
                    c5.setText("NoOfBooks");
                }

                {
                    TableColumn c6 = new TableColumn(table, SWT.NONE);
                    c6.setWidth(100);
                    c6.setText("Isbn");
                }



            }

            Button button1 = new Button(shell, SWT.PUSH);
            button1.setBounds(350,600,200,20);
            button1.setText("Return");

            button1.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected (SelectionEvent e){
                    System.out.println(e.getSource() + "Button1 was clicked");
                    try {


                        ReturninBook returninBook = new ReturninBook();
                        returninBook.returningBook(display);

                       // new DeleteBorrower(i);


                    } catch (Exception a) {
                    }

                     shell.dispose();
                }
            });

            Button button3 =new Button(shell,SWT.PUSH);
            button3.setBounds(500,600,200,20);
            button3.setText("Goto Home");

            button3.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    System.out.println(e.getSource()+"Button3 (go to home)was clicked");
                    try{
                        //new BookRentalHome();
                       // shell.dispose();
                        new BookRentalHome();
                        System.out.println("no");
                        shell.dispose();

                    }catch(Exception a){}
                    // shell.dispose();
                }
            });
            shell.open();
           /* shell.layout();
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
            display.dispose();*/
        }

    }








