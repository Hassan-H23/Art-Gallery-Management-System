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
public class Artist {

 public  static ArrayList<Artist> ArtistList = ArtistList();
    int A_ID;
    int zipCode;
    int A_AGE;
    String A_FName;
    String A_LName;
    String streetName;
    String Style;
    int Artwork_ID;

    public Artist(int A_ID, int zipCode, int A_AGE, String A_FName, String A_LName, String streetName, String Style, int Artwork_ID) {
        this.A_ID = A_ID;
        this.zipCode = zipCode;
        this.A_AGE = A_AGE;
        this.A_FName = A_FName;
        this.A_LName = A_LName;
        this.streetName = streetName;
        this.Style = Style;
        this.Artwork_ID = Artwork_ID;
       
//Insert into DB
        try {
String connectionURL= "jdbc:derby://localhost:1527/AGMS";
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
st.executeUpdate("INSERT INTO ARTIST(A_ID, A_FNAME, A_LNAME, STREETNAME, ZIPCODE, STYLE, ARTWORK_ID, A_AGE) VALUES (" + A_ID + ", '"+A_FName+"','" +A_LName+"','"+streetName+"',"+zipCode+",'"+Style+"',"+Artwork_ID+"," +A_AGE+")");
st.close(); conn.close();
}
catch (SQLException ex) {System.out.println("Connection to DB failed ! ");  System.out.println(ex.getCause()); System.out.println(ex.getErrorCode());}
    
   
        
        
    }
    
  public  static ArrayList<Artist> ArtistList(){
  
   ArrayList<Artist> ArtistList = new ArrayList<>();
        String connectionURL = "jdbc:derby://localhost:1527/AGMS";
        
        try{
     java.sql.Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
     String sql = " SELECT * FROM ARTIST";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     Artist artist;
     while(rs.next()){
   //  Artist(int A_ID, int zipCode, int A_AGE, String A_FName, String A_LName, String streetName, String Style, int Artwork_ID)
     artist = new Artist(rs.getInt("A_ID"), rs.getInt("ZIPCODE"), rs.getInt("A_AGE"), rs.getString("A_FNAME"), rs.getString("A_LNAME"), rs.getString("STREETNAME"), rs.getString("STYLE"), rs.getInt("ARTWORK_ID"));
     ArtistList.add(artist);
     }
        }
        catch(SQLException ex){
        
     ex.getCause();
        
        }
        
     return ArtistList;
}
//Accassors & Muttattors


    public int getA_ID() {
        return A_ID;
    }

    public void setA_ID(int A_ID) {
        this.A_ID = A_ID;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getA_AGE() {
        return A_AGE;
    }

    public void setA_AGE(int A_AGE) {
        this.A_AGE = A_AGE;
    }

    public String getA_FName() {
        return A_FName;
    }

    public void setA_FName(String A_FName) {
        this.A_FName = A_FName;
    }

    public String getA_LName() {
        return A_LName;
    }

    public void setA_LName(String A_LName) {
        this.A_LName = A_LName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String Style) {
        this.Style = Style;
    }

    public int getArtwork_ID() {
        return Artwork_ID;
    }

    public void setArtwork_ID(int Artwork_ID) {
        this.Artwork_ID = Artwork_ID;
    }
    
    public static void addArtist(int A_ID, int zipCode, int A_AGE, String A_FName, String A_LName, String streetName, String Style, int Artwork_ID){
    Artist a = new Artist(A_ID,zipCode,A_AGE,A_FName,A_LName,streetName,Style,Artwork_ID);
    }
  
  
  
  
  
  
  
  
};