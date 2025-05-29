/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiestacabservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tithira
 */
public class VasignDao {
    
    
    public VasignDao(){
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
    }
    
    public boolean insert(assignVehicle avob){
        Connection dbcon;
        String bid=avob.getbid();
        String vid=avob.getvid();
        
        
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("insert into AssignVehicle values(?,?)");
           ps.setString(1,bid);
           ps.setString(2,vid);
          
          
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
            
     public ArrayList<assignVehicle> SearchAV(String bid){
        Connection dbcon;
        assignVehicle va=new assignVehicle();
        ArrayList<assignVehicle> arv=new ArrayList<assignVehicle>();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM AsignVehicle WHERE BookingID='"+bid+"'");
          while(rslt.next()){
              va=new assignVehicle(rslt.getString("BookingID"), rslt.getString("VregNumber"));
              arv.add(va);
          }
          dbcon.close();
        }catch(SQLException ex){
            
            System.out.println(ex);
        }
        return arv;
        
    }       
}
