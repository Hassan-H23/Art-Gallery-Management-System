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
public class Orders {
    public static ArrayList<Orders> OrdersList = OrderList(); 
    int O_ID;
    String Prefered_Art;
    double Price;
    int Art_ID;
    String C_Name ;

    
    
    public Orders(int O_ID, String Prefered_Art, double Price, int Art_ID, String C_Name) {
        this.O_ID = O_ID;
        this.Prefered_Art = Prefered_Art;
        this.Price = Price;
        this.Art_ID = Art_ID;
        this.C_Name = C_Name;
        
                //Insert into DB
String connectionURL= "jdbc:derby://localhost:1527/AGMS";
try {
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
st.executeUpdate("INSERT INTO ORDERS (O_ID, PREFERED_ART, PRICE, ART_ID, C_NAME)" + " VALUES(" + O_ID  + ", '"  + Prefered_Art + "', " + Price + "," + Art_ID + ",'" + C_Name+ "')");
st.close(); conn.close(); }
catch (SQLException ex) {System.out.println("Connect failed ! ");  System.out.println(ex.getCause()); System.out.println(ex.getErrorCode());}
}
    
 public  static ArrayList<Orders> OrderList(){
  
   ArrayList<Orders> ArtistList = new ArrayList<>();
        String connectionURL = "jdbc:derby://localhost:1527/AGMS";
        
        try{
     java.sql.Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
     String sql = " SELECT * FROM ORDERS";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     Orders order;
     while(rs.next()){
     order = new Orders(rs.getInt("O_ID"), rs.getString("PREFERED_ART"), rs.getDouble("PRICE"), rs.getInt("ART_ID"), rs.getString("C_NAME"));
     ArtistList.add(order);
     }
        }
        catch(SQLException ex){
        
     ex.getCause();
        
        }
        
     return ArtistList;
}

    public int getO_ID() {
        return O_ID;
    }

    public void setO_ID(int O_ID) {
        this.O_ID = O_ID;
    }

    public String getPrefered_Art() {
        return Prefered_Art;
    }

    public void setPrefered_Art(String Prefered_Art) {
        this.Prefered_Art = Prefered_Art;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getArt_ID() {
        return Art_ID;
    }

    public void setArt_ID(int Art_ID) {
        this.Art_ID = Art_ID;
    }

    public String getC_Name() {
        return C_Name;
    }


    
    
    
    
    
    
    
}
