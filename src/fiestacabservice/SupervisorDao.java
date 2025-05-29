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
public class SupervisorDao {
    
    public SupervisorDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
    }
    
    
    public boolean insert(Supervisor spv){
        Connection dbcon;
        String id=spv.getid();
        String name=spv.getname();
        String subd=spv.getsbd();
        
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("insert into Supervisor values(?,?,?)");
           ps.setString(1,id);
           ps.setString(2,name);
           ps.setString(3, subd);
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public ArrayList<Supervisor> SearchSupbysub(String sub){
        Connection dbcon;
        Supervisor sup=new Supervisor();
        ArrayList<Supervisor> slist=new ArrayList<Supervisor>();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Supervisor WHERE subsidiary='"+sub+"'");
          while(rslt.next()){
              sup=new Supervisor(rslt.getString("sid"), rslt.getString("sname"), rslt.getString("subsidiary"));
              slist.add(sup);
          }
          dbcon.close();
        }catch(SQLException ex){
            
            System.out.println(ex);
        }
        return slist;
        
    }
     
     
     public Supervisor SearchSupervisorbyID(String sid){
        Connection dbcon;
        Supervisor sp=new Supervisor();
       
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Supervisor WHERE sid='"+sid+"'");
          while(rslt.next()){
             sp=new Supervisor(rslt.getString("sid"), rslt.getString("sname"), rslt.getString("subsidiary"));
          }
          dbcon.close();
        }catch(SQLException ex){
            
            System.out.println(ex);
        }
        return sp;
        
    }
    
     public boolean delete(String sid){
        Connection dbcon;
        try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("delete from Supervisor where sid=?");
           ps.setString(1,sid);
           ps.executeUpdate();
           dbcon.close();
           return true;
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
     
    public boolean updates(Supervisor sobj){
        Connection dbcon;
        String id=sobj.getid();
        String name=sobj.getname();
        String subd=sobj.getsbd();
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("Update Supervisor set sname=?, subsidiary=? where sid=?");
           ps.setString(3,id);
           ps.setString(1,name);
           ps.setString(2,subd);
           
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
     }
    
    
}
