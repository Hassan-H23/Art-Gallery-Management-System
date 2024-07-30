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
 */
public class Admin {
    public static  ArrayList<Admin> AdminList = AdminList();
    int A_ID;
    String Name;
    String Password;

    public Admin(int A_ID, String Name, String Password) {
        this.A_ID = A_ID;
        this.Name = Name;
        this.Password = Password;
        
         try {
String connectionURL= "jdbc:derby://localhost:1527/AGMS";
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
st.executeUpdate("INSERT INTO ADMIN(AD_ID, AD_NAME, PASSWORD) VALUES (" + A_ID + ", '"+Name+"','" +Password+"')");
st.close(); conn.close();
}
catch (SQLException ex) {System.out.println("Connection to DB failed ! ");  System.out.println(ex.getCause()); System.out.println(ex.getErrorCode());}
        
        
    }

 

    public int getA_ID() {
        return A_ID;
    }

    public void setA_ID(int A_ID) {
        this.A_ID = A_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
public  static ArrayList<Admin> AdminList(){
  
   ArrayList<Admin> AdminList = new ArrayList<>();
        String connectionURL = "jdbc:derby://localhost:1527/AGMS";
        
        try{
     java.sql.Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
     String sql = " SELECT * FROM ADMIN";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     Admin a;
     while(rs.next()){
   //public Exibition(int Ex_ID, String Start_Date, String End_Date, String Location, String Time)
     a = new Admin(rs.getInt("AD_ID"), rs.getString("AD_NAME"), rs.getString("PASSWORD"));
     AdminList.add(a);
     }
        }
        catch(SQLException ex){
        
     ex.getCause();
        
        }
        
     return AdminList;
}    

       public static boolean A_login (String name, String pass)
    {
        Admin a = null;
        for (Admin x : AdminList)
        { 
            
            if (x.getName().equals(name) && x.getPassword().equals(pass))
                return true;
        }
        return false;
    }
    
    
    
}
