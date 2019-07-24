package BookrentalSwtGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

import static BookrentalSwtGui.SearchBook.*;


public class BookRentalHome   {

    public static void main(String[] args) {


        final Display display = new Display();
        final Shell shell = new Shell();
        shell.setSize(700, 700);
        //shell.setImage(new Image(display, "this PCDownloads"));

        Button b = new Button(shell, SWT.NONE);
        b.setBounds(200, 0, 400, 70);
        b.setText("WELCOME TO THE BOOK RENTAL");


        Button btnAddingBooks = new Button(shell, SWT.NONE);
        btnAddingBooks.setBounds(250, 600, 200, 50);
        btnAddingBooks.setText("Add Book");


        Button searchbookbutton = new Button(shell, SWT.NONE);
        searchbookbutton.setBounds(250, 100, 200, 50);
        searchbookbutton.setText("Search Book");


        Button b3 = new Button(shell, SWT.NONE);
        b3.setBounds(250, 200, 200, 50);
        b3.setText("Delete Book");


        Button b4 = new Button(shell, SWT.NONE);
        b4.setBounds(250, 300, 200, 50);
        b4.setText("Rent Book");


        Button b5 = new Button(shell, SWT.NONE);
        b5.setBounds(250, 400, 200, 50);
        b5.setText("Return Book");


        Button b6 = new Button(shell, SWT.NONE);
        b6.setBounds(250, 500, 200, 50);
        b6.setText("Borrow List");


        btnAddingBooks.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button1 was clicked");
                try {
                    //shell.dispose();
                    AddBook g = new AddBook();
                    g.add(display);

                } catch (Exception a) {
                }
            }
        });


        searchbookbutton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button2 was clicked");

                try {
                   // shell.dispose();
                    new SearchBook(display);
                } catch (Exception a) {
                    System.out.println("connection failed");
                }
            }
        });

       b3.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button3 was clicked");
                try {

                  // shell.dispose();
                  new SearchBook(display);

                } catch (Exception a) {
                }
            }

        });


        b4.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button4 was clicked");
                try {
                    //shell.dispose();
                    new SearchBook(display);
                    /*BorrowerEntry borrowerEntry= new BorrowerEntry();
                    borrowerEntry.dataEntryc();*/
                   //new SearchBookByIsbn();

                } catch (Exception a) {
                }
            }
        });


        b5.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button5 was clicked");
                try {


                   // shell.dispose();

                    new SearchBorrower(display);

                } catch (Exception a) {
                }

            }
        });


        b6.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource() + "Button6 was clicked");
                try {

                   PrintBorrowerList f = new PrintBorrowerList();
                   f.open(display);

                } catch (Exception a) {
                }
            }
        });
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        //display.dispose();

    }

    }



