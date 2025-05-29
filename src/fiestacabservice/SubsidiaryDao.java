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
public class SubsidiaryDao {
    
    
    public SubsidiaryDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
        
    }
    
    public boolean insert(Subsidiary sb){
        
        Connection dbcon;
        String sname=sb.getname();
        String mger=sb.getMger();
       
        
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("insert into Subsidiary values(?,?)");
           ps.setString(1,sname);
           ps.setString(2,mger);
          
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public ArrayList<Subsidiary> Searchallsubsidiary(){
        Connection dbcon;
        ArrayList<Subsidiary> subarray=new ArrayList<Subsidiary>();
        Subsidiary subs;
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Subsidiary");
          while(rslt.next()){
              subs=new Subsidiary(rslt.getString("subname"), rslt.getString("Manager"));
              subarray.add(subs);
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
       return subarray;
    }
    
    public boolean delete(String subd){
        Connection dbcon;
        try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("delete from Subsidiary where subname=?");
           ps.setString(1,subd);
           ps.executeUpdate();
           dbcon.close();
           return true;
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }

}
    