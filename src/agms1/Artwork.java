/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agms1;

import static agms1.Artist.ArtistList;
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

public class Artwork {
     public  static ArrayList<Artwork> ArtList = ArtList();
    int Art_ID;
    double Price;
    String DOP;
    String Type;
    String Art_Name;

    public Artwork(int Art_ID, double Price, String DOP, String Type,String Art_Name) {
        this.Art_ID = Art_ID;
        this.Price = Price;
        this.DOP = DOP;
        this.Type = Type;
        this.Art_Name = Art_Name;
        
          try {
String connectionURL= "jdbc:derby://localhost:1527/AGMS";
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
st.executeUpdate("INSERT INTO ARTWORK (ART_ID, PRICE, DOP, TYPE, ART_NAME) VALUES(" + Art_ID +"," + Price + ",'" + DOP + "','" + Type+"','"+Art_Name+"')");
st.close(); conn.close();
}
catch (SQLException ex) {System.out.println("Connection to DB failed ! ");  System.out.println(ex.getCause()); System.out.println(ex.getErrorCode());}
    }
    
    public  static ArrayList<Artwork> ArtList(){
  
   ArrayList<Artwork> ArtList = new ArrayList<>();
        String connectionURL = "jdbc:derby://localhost:1527/AGMS";
        
        try{
     java.sql.Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
     String sql = " SELECT * FROM ARTWORK";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     Artwork art;
     while(rs.next()){
   //  Artist(int A_ID, int zipCode, int A_AGE, String A_FName, String A_LName, String streetName, String Style, int Artwork_ID)
     art = new Artwork(rs.getInt("ART_ID"), rs.getDouble("PRICE"), rs.getString("DOP"), rs.getString("TYPE"), rs.getString("ART_NAME"));
     ArtList.add(art);
     } 
        }
        catch(SQLException ex){
        
     ex.getCause();
        
        }
        
     return ArtList;
}

    public static ArrayList<Artwork> getArtList() {
        return ArtList;
    }

    public static void setArtList(ArrayList<Artwork> ArtList) {
        Artwork.ArtList = ArtList;
    }

    public int getArt_ID() {
        return Art_ID;
    }

    public void setArt_ID(int Art_ID) {
        this.Art_ID = Art_ID;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getDOP() {
        return DOP;
    }

    public void setDOP(String DOP) {
        this.DOP = DOP;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getArt_Name() {
        return Art_Name;
    }

    public void setArt_Name(String Art_Name) {
        this.Art_Name = Art_Name;
    }

 
    
    
    
    
    
    
    
}
