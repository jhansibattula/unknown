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

public class CombiningTables {

        private Table table;

        public void CombineTab(){
            Display display = new Display();

           // Display display=Display.getDefault();
            final Shell shell = new Shell();
            shell.setLayout(new GridLayout(1,false));
            shell.setSize(700,700);
            shell.setText(" all borrower details");
            {
                table =new Table(shell, SWT.VIRTUAL);
                table.setHeaderVisible(true);
                table.setItemCount(1);
                table.setLinesVisible(true);
                table.getItems();
                table.setVisible(true);

                table.addListener(SWT.SetData, new Listener() {
                    public void handleEvent(Event event) {

                        try{
                            Connection con=DbConnect1.getCon();
                            PreparedStatement ps=con.prepareStatement("select * from  addbook left join  borrowerlist on borrowerlist.isbn = addbook.isbn where noofbooks<totalbooks ");
                            ResultSet rs=ps.executeQuery();
                            while(rs.next()){
                                TableItem item=new TableItem(table,SWT.NONE);
                                item.setText(new String[]
                                        {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
                            }

                        }catch(Exception e){
                            System.out.println("can not connected to database...");
                        }
                    }
                });
                table.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));

                {

                    TableColumn c1=new TableColumn(table,SWT.NONE);
                    c1.setWidth(100);
                    c1.setText(" Authorname");
                }
                {

                    TableColumn c2=new TableColumn(table,SWT.NONE);
                    c2.setWidth(100);
                    c2.setText(" booktitle");
                }
                {

                    TableColumn c3=new TableColumn(table,SWT.NONE);
                    c3.setWidth(100);
                    c3.setText(" Isbn");
                }
                {

                    TableColumn c4=new TableColumn(table,SWT.NONE);
                    c4.setWidth(100);
                    c4.setText(" Total Boks");
                }


                {
                    TableColumn c5=new TableColumn(table,SWT.NONE);
                    c5.setWidth(100);
                    c5.setText("First Name");
                }
                {
                    TableColumn c6=new TableColumn(table,SWT.NONE);
                    c6.setWidth(100);
                    c6.setText("Last Name");
                }
                {
                    TableColumn c7=new TableColumn(table,SWT.NONE);
                    c7.setWidth(100);
                    c7.setText("Email Id");
                }
                {
                    TableColumn c8=new TableColumn(table,SWT.NONE);
                    c8.setWidth(100);
                    c8.setText("rentbooks");
                }
                {
                    TableColumn c1=new TableColumn(table,SWT.NONE);
                    c1.setWidth(100);
                    c1.setText(" ISBN");
                }
                {
                    TableColumn c1=new TableColumn(table,SWT.NONE);
                    c1.setWidth(100);
                    c1.setText(" remaining Stock");
                }



            }
           Button b=new Button(shell,SWT.PUSH);
            b.setText("Goto Home");
            b.setBounds(500,600,100,30);

            Button proceed=new Button(shell,SWT.PUSH);
            proceed.setText(" proceed");
            proceed.setBounds(1200,600,100,30);



            b.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    new BookRentalHome();
                    // shell.dispose();

                } });
             proceed.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {


                }
            });
            shell.open();
            shell.layout();
            while(!shell.isDisposed()){
                if(!display.readAndDispatch()){
                    display.sleep();
                }
            }
            display.dispose();
        }


    public static void main(String[] args) {
        CombiningTables combiningTables = new CombiningTables();
        combiningTables.CombineTab();
    }
    }


