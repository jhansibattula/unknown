package CreditcardDetails;

import java.sql.PreparedStatement;

public class Connection {

    private static java.sql.Connection con= DbConnect.getCon();
    private static String cardholder ;
    private static long creditordebit ;
    private static int securitycode ;
    private static String address ;
    private static String address2 ;
    private static int zipcode ;
    private static String city ;
    private static String state;
    private static int expirydate;

    public static String getCardholder() {
        return cardholder;
    }

    public static int getExpirydate() {
        return expirydate;
    }

    public static void setExpirydate(int expirydate) {
        Connection.expirydate = expirydate;
    }

    public static void setCardholder(String cardholder) {
        Connection.cardholder = cardholder;
    }

    public static long getCreditordebit() {
        return creditordebit;
    }

    public static void setCreditordebit(long creditordebit) {
        Connection.creditordebit = creditordebit;
    }

    public static int getSecuritycode() {
        return securitycode;
    }

    public static void setSecuritycode(int securitycode) {
        Connection.securitycode = securitycode;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Connection.address = address;
    }

    public static String getAddress2() {
        return address2;
    }

    public static void setAddress2(String address2) {
        Connection.address2 = address2;
    }

    public static int getZipcode() {
        return zipcode;
    }

    public static void setZipcode(int zipcode) {
        Connection.zipcode = zipcode;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        Connection.city = city;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        Connection.state = state;
    }


    public  void savingbooks(){

        try{

            String query = " insert into details values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,this.getCardholder());
            ps.setLong(2,this.getCreditordebit());
            ps.setInt(3,this.getExpirydate());
            ps.setString(4,this.getAddress());
            ps.setString(5,this.getAddress2());
            ps.setInt(6,this.getZipcode());
            ps.setString(7,getCity());
            ps.setString(8,getState());
            ps.setInt(9,getSecuritycode());
            int n = ps.executeUpdate();
            if(n==1){
                System.out.println("record inserted succesfully");
            }
            else {
                System.out.println("record not inserted sucessfully");
            }
        }catch(Exception e){
            System.out.println();
        }

    }


    public  void setasdefault(){

        this.setCardholder("jhansitrimind");
        this.setCreditordebit(1234567890);
        this.setExpirydate(20/20);
        this.setAddress("hyd");
        this.setAddress2("mbnr");
        this.setZipcode(123);
        this.setCity("hyd");
        this.setState("telangana");
        this.setSecuritycode(1234);


        try{

            String query = " insert into details values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,this.getCardholder());
            ps.setLong(2,this.getCreditordebit());
            ps.setInt(3,this.getExpirydate());
            ps.setString(4,this.getAddress());
            ps.setString(5,this.getAddress2());
            ps.setInt(6,this.getZipcode());
            ps.setString(7,this.getCity());
            ps.setString(8,this.getState());
            ps.setInt(9,this.getSecuritycode());
            int n = ps.executeUpdate();
            if(n==1){
                System.out.println("record inserted succesfully");
            }
            else {
                System.out.println("record not inserted sucessfully");
            }
        }catch(Exception e){
            System.out.println();
        }

        }
    }



