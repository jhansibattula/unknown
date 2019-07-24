package BookrentalSwtGui;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

import javax.swing.plaf.nimbus.State;


public  class SearchBook {
    //public void  bookSearch() {

    public  SearchBook(final Display display) {


     //Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setSize(500, 500);

        Label lable = new Label(shell, SWT.BORDER);
        lable.setText("Select Any One Option ");
        lable.setBounds(100, 20, 300, 50);
        lable.setBackground(new Color(display, 200, 111, 50));

        Button button1 = new Button(shell, SWT.CHECK);
        button1.setText("Search Book By Author Name");
        button1.setBounds(100, 150, 300, 150);

        Button button2 = new Button(shell, SWT.CHECK);
        button2.setBounds(100, 300, 300, 150);
        button2.setText("Search Book By Book Name");

        Button button3 = new Button(shell, SWT.CHECK);
        button3.setText(" Search Book By Isbn");
        button3.setBounds(100, 450, 300, 150);

        button1.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button1 was clicked");
                try {
                  shell.dispose();

                    new SearchByAuthorname(display);
                } catch (Exception ex) {

                }

            }
        });

        button2.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button2 was clicked");
                try {
                    shell.dispose();
                   new SearchbyBookName(display);
                } catch (Exception ex) {

                }
            }
        });

        button3.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button3 was clicked");
                try {
                    shell.dispose();
                    new SearchBookByIsbn(display);
                } catch (Exception ex) {

                }
            }
        });


        shell.open();
        /*while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();*/

    }
    }

