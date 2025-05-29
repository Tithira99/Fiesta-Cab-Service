/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiestacabservice;

/**
 *
 * @author Tithira
 */
import java.sql.*;
import java.util.ArrayList;
public class DriverDao {
    public DriverDao(){
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
    }
    
    
    public ArrayList<Driver> searchbysub(String sub){
        Connection dbcon;
        Driver drv=new Driver();
        ArrayList<Driver> Dlist=new ArrayList<Driver>();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Driver WHERE DSubsidiary='"+sub+"'");
          while(rslt.next()){
              drv=new Driver(rslt.getString("DriverID"), rslt.getString("Dname"), rslt.getString("Dsubsidiary"),rslt.getBoolean("assigned"));
              Dlist.add(drv);
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return Dlist;
        
    }
    
    
    public boolean insert(Driver drv){
        
        Connection dbcon;
        String did=drv.getdid();
        String name=drv.getname();
        String dsub=drv.getsubd();
        boolean asgn=drv.getasgn();
        
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("insert into Driver values(?,?,?,?)");
           ps.setString(1,did);
           ps.setString(2,name);
           ps.setString(3,dsub);
           ps.setBoolean(4,asgn);
          
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    
    public boolean delete(String Did){
        Connection dbcon;
        try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("delete from Driver where DriverID=?");
           ps.setString(1,Did);
           ps.executeUpdate();
           dbcon.close();
           return true;
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public Driver SearchDriverbyID(String did){
        Connection dbcon;
        Driver drv=new Driver();
       
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Driver WHERE DriverID='"+did+"'");
          while(rslt.next()){
             drv=new Driver(rslt.getString("DriverID"), rslt.getString("Dname"), rslt.getString("Dsubsidiary"),rslt.getBoolean("assigned"));
          }
          dbcon.close();
        }catch(SQLException ex){
            
            System.out.println(ex);
        }
        return drv;
        
    }
    
    public boolean UpdateD(Driver dr){
        
        Connection dbcon;
        String did=dr.getdid();
        String name=dr.getname();
        String subd=dr.getsubd();
        boolean asn=dr.getasgn();
        
        
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("Update  Driver set Dname=?,Dsubsidiary=?,Assigned=? WHERE DriverID=?");
           
           
           ps.setString(4, did);
           ps.setString(1,name);
           ps.setString(2,subd);
           ps.setBoolean(3,asn);
         
          
          
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
}
