/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agms1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * 
 */
public class Customer {
    public static  ArrayList<Customer> CustomerList = CustomerList();
     int C_ID;
    int zipCode;
    int C_AGE;
    String C_FName;
    String C_LName;
    String streetName;
    int Reservation_ID;
    int ArtWork_ID;
    
    

    public Customer(int C_ID, int zipCode, int C_AGE, String C_FName, String C_LName, String streetName, int Reservation_ID, int ArtWork_ID) {
        this.C_ID = C_ID;
        this.zipCode = zipCode;
        this.C_AGE = C_AGE;
        this.C_FName = C_FName;
        this.C_LName = C_LName;
        this.streetName = streetName;
        this.Reservation_ID = Reservation_ID;
        this.ArtWork_ID = ArtWork_ID;
        //Insert into DB
        try {
String connectionURL= "jdbc:derby://localhost:1527/AGMS";
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
st.executeUpdate("INSERT INTO CUSTOMER(C_ID, C_FNAME, C_LNAME, STREETNAME, ZIPCODE, C_AGE, RESERVATION_NUM, ARTWORK_ID) VALUES (" + C_ID + ", '"+C_FName+"','" +C_LName+"','"+streetName+"',"+zipCode+","+C_AGE+","+Reservation_ID+","+ArtWork_ID+")");
st.close(); conn.close();
}
catch (SQLException ex) {System.out.println("Connection to DB failed ! ");  System.out.println(ex.getCause()); System.out.println(ex.getErrorCode());}
    
   
        
    }
 
    public  static ArrayList<Customer> CustomerList(){
  
   ArrayList<Customer> CustomerList = new ArrayList<>();
        String connectionURL = "jdbc:derby://localhost:1527/AGMS";
        
        try{
     java.sql.Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
     String sql = " SELECT * FROM CUSTOMER";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     Customer  cust;
     while(rs.next()){
   //  int C_ID, int zipCode, int C_AGE, String C_FName, String C_LName, String streetName, int Reservation_ID, int ArtWork_ID
     cust = new Customer(rs.getInt("C_ID"), rs.getInt("ZIPCODE"), rs.getInt("C_AGE"), rs.getString("C_FNAME"), rs.getString("C_LNAME"), rs.getString("STREETNAME"), rs.getInt("RESERVATION_NUM"), rs.getInt("ARTWORK_ID"));
     CustomerList.add(cust);
     }
        }
        catch(SQLException ex){
        
     ex.getCause();
        
        }
        
     return CustomerList;
}

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int C_ID) {
        this.C_ID = C_ID;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getC_AGE() {
        return C_AGE;
    }

    public void setC_AGE(int C_AGE) {
        this.C_AGE = C_AGE;
    }

    public String getC_FName() {
        return C_FName;
    }

    public void setC_FName(String C_FName) {
        this.C_FName = C_FName;
    }

    public String getC_LName() {
        return C_LName;
    }

    public void setC_LName(String C_LName) {
        this.C_LName = C_LName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getReservation_ID() {
        return Reservation_ID;
    }

    public void setReservation_ID(int Reservation_ID) {
        this.Reservation_ID = Reservation_ID;
    }

    public int getArtWork_ID() {
        return ArtWork_ID;
    }

    public void setArtWork_ID(int ArtWork_ID) {
        this.ArtWork_ID = ArtWork_ID;
    }
    

    
    
    
}

        