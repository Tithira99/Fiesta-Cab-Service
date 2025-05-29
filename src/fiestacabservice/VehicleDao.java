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
public class VehicleDao {
    
    public VehicleDao(){
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
    }
    
    
    public boolean insert(Vehicle vh){
        
        Connection dbcon;
        String vid=vh.getvid();
        String vmodel=vh.getvModel();
        String vtype=vh.getvtype();
        String subsidiary=vh.getsdiary();
        boolean avbty=vh.getavbty();
        String did=vh.getdid();
        String sid=vh.getsid();
        
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("insert into Vehicle values(?,?,?,?,?,?,?)");
           ps.setString(1,vid);
           ps.setString(2,vmodel);
           ps.setString(3,vtype);
           ps.setString(4,subsidiary);
           ps.setBoolean(5, avbty);
           ps.setString(6,did);
            ps.setString(7,sid);
          
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    
    public ArrayList<Vehicle> searchvehiclebydriver(String did){
       Connection dbcon;
       Vehicle vh;
       ArrayList<Vehicle> varray=new ArrayList<Vehicle>();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Vehicle WHERE did='"+did+"'");
          while(rslt.next()){
              vh=new Vehicle(rslt.getString("RegNumber"), rslt.getString("Vmodel"), rslt.getString("Vtype"),rslt.getString("subsidiary"),rslt.getBoolean("availability"),rslt.getString("did"), rslt.getString("supid"));
              varray.add(vh);
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return varray;
        
    }
    
    public ArrayList<Vehicle> searchvhbysub(String sub){
        Connection dbcon;
        Vehicle vh=new Vehicle();
        ArrayList<Vehicle> vlist=new ArrayList<Vehicle>();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Vehicle WHERE subsidiary='"+sub+"'");
          while(rslt.next()){
              vh=new Vehicle(rslt.getString("RegNumber"), rslt.getString("Vmodel"),rslt.getString("Vtype"), rslt.getString("Subsidiary"), rslt.getBoolean("Availability"), rslt.getString("Did"),rslt.getString("supid"));
              vlist.add(vh);
          }
          dbcon.close();
        }catch(SQLException ex){
            
            System.out.println(ex);
        }
        return vlist;
        
    }
    
     public Vehicle searchVehiclebyID(String vid){
       Connection dbcon;
       Vehicle vh=new Vehicle();
       
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Vehicle WHERE RegNumber='"+vid+"'");
          while(rslt.next()){
              vh=new Vehicle(rslt.getString("RegNumber"), rslt.getString("Vmodel"), rslt.getString("Vtype"),rslt.getString("subsidiary"),rslt.getBoolean("availability"),rslt.getString("did"), rslt.getString("supid"));
            
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return vh;
        
    }
    
    public boolean Update(Vehicle vh){
        
        Connection dbcon;
        String vid=vh.getvid();
        String vmodel=vh.getvModel();
        String vtype=vh.getvtype();
        String subsidiary=vh.getsdiary();
        boolean avbty=vh.getavbty();
        String did=vh.getdid();
        String sid=vh.getsid();
        
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("Update  Vehicle set Vmodel=?,Vtype=?,subsidiary=?,availability=?,did=?, supid=? WHERE RegNumber=?");
        
           ps.setString(1,vmodel);
           ps.setString(2,vtype);
           ps.setString(3,subsidiary);
           ps.setBoolean(4, avbty);
           ps.setString(5,did);
           ps.setString(6,sid);
           ps.setString(7,vid);
          
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
}
