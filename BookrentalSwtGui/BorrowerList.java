package BookrentalSwtGui;

import java.sql.Connection;

public class BorrowerList {

    private static Connection con= DbConnect1.getCon();
        private String bookName;
        private String firstName;
        private String lastName;
        private String email;
        private int nunOfDaysLoan;
        private String date ;



        public BorrowerList(String bookName, String firstName, String lastName, String email, int nunOfDaysLoan) {
            this.bookName = bookName;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.nunOfDaysLoan = nunOfDaysLoan;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public int getNunOfDaysLoan() {
            return nunOfDaysLoan;
        }

        public void setNunOfDaysLoan(int nunOfDaysLoan) {
            this.nunOfDaysLoan = nunOfDaysLoan;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        @Override
        public String toString() {
            return "BorrowerFile{" +
                    "bookName='" + bookName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", nunOfDaysLoan=" + nunOfDaysLoan +
                    ", date='" + date + '\'' +
                    '}';
        }

}




