/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agms1;

import static agms1.Customer.CustomerList;
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
public class Exibition {
        public static  ArrayList<Exibition> ExibitionList = ExibitionList();
    int Ex_ID;
    String Start_Date;
    String End_Date;
    String Location;
    String Time;

    public Exibition(int Ex_ID, String Start_Date, String End_Date, String Location, String Time) {
        this.Ex_ID = Ex_ID;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
        this.Location = Location;
        this.Time = Time;
        
            
    String connectionURL= "jdbc:derby://localhost:1527/AGMS";
    try{
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
st.executeUpdate("INSERT INTO EXHIBITION(E_ID, STARTDATE, ENDDATE, LOCATION, TIME) VALUES (" + Ex_ID + ", '"+Start_Date+"','" +End_Date+"','"+Location+"','"+Time+"')");
st.close(); conn.close();
}
catch (SQLException ex) {System.out.println("Connection to DB failed ! ");  System.out.println(ex.getCause()); System.out.println(ex.getErrorCode());}
    
    
    }
    
    
    
    public  static ArrayList<Exibition> ExibitionList(){
  
   ArrayList<Exibition> ExibitionList = new ArrayList<>();
        String connectionURL = "jdbc:derby://localhost:1527/AGMS";
        
        try{
     java.sql.Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
     String sql = " SELECT * FROM EXHIBITION";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     Exibition  ex;
     while(rs.next()){
   //public Exibition(int Ex_ID, String Start_Date, String End_Date, String Location, String Time)
     ex = new Exibition(rs.getInt("E_ID"), rs.getString("STARTDATE"), rs.getString("ENDDATE"), rs.getString("LOCATION"), rs.getString("TIME"));
     ExibitionList.add(ex);
     }
        }
        catch(SQLException ex){
        
     ex.getCause();
        
        }
        
     return ExibitionList;
}

   

    public int getEx_ID() {
        return Ex_ID;
    }

    public void setEx_ID(int Ex_ID) {
        this.Ex_ID = Ex_ID;
    }

    public String getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(String Start_Date) {
        this.Start_Date = Start_Date;
    }

    public String getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(String End_Date) {
        this.End_Date = End_Date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    public static void addExibition(int Ex_ID, String Start_Date, String End_Date, String Location, String Time){
    
    
    Exibition e = new Exibition( Ex_ID,  Start_Date,  End_Date,  Location,  Time);
    
    }
    

}
