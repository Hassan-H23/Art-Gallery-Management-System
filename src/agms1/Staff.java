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
import org.apache.derby.iapi.sql.PreparedStatement;


/**
 *
 * 
 */
public class Staff  {
    int S_ID;
    int zipCode;
    int S_AGE;
    double Salary;
    String Position;
    String S_FName;
    String S_LName;
    String streetName;
  
    
  
    public Staff(int S_ID, String S_FName, String S_LName, String streetName, int zipCode, int S_AGE, String Position, double Salary ) {
        this.S_ID = S_ID;
        this.S_FName = S_FName;
        this.S_LName = S_LName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.S_AGE = S_AGE;
        this.Position = Position;
        this.Salary = Salary;
        //Insert into DB
String connectionURL= "jdbc:derby://localhost:1527/AGMS";
try {
Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
Statement st = conn.createStatement();
st.executeUpdate("INSERT INTO STAFF (S_ID, S_FNAME, S_LNAME, STREETNAME, ZIPCODE, S_AGE, POSITION, SALARY)" + " VALUES(" + S_ID  + ", '"  + S_FName + "', '" + S_LName + "', '" + streetName + "', " + zipCode + ", " + S_AGE + ", '" + Position+"', "+Salary+  ")");
st.close(); conn.close(); }
catch (SQLException ex) {System.out.println("Connect failed ! ");  System.out.println(ex.getCause()); System.out.println(ex.getErrorCode());}

    }

    }

    
    
    
    
    
    



    
    

