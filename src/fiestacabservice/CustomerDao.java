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
public class CustomerDao {
    
    public CustomerDao(){//Constructor od the Dao class of Customer
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();//connecting to JDBC driver
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
        
    }
    
    public boolean Insert(Customer cust){//method for inserting a new Customer
        Connection dbcon;
        String mnum=cust.getmnum();
        String name=cust.getnm();
        String loc=cust.getloc();
        String type=cust.gettype();
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");//Connecting to the database
           PreparedStatement ps=dbcon.prepareStatement("insert into Customer values(?,?,?,?)");//query to access data
           ps.setString(1,mnum);
           ps.setString(2,name);
           ps.setString(3,loc);
           ps.setString(4,type);
           ps.executeUpdate();
           dbcon.close();
           return true;
       }catch(SQLException ex){
           System.out.println(ex);
           return false;
       }
        
    }
    
    public Customer SearchbytelNo(String TelNo){//Method for searching a customer by their Mobile Number
        Connection dbcon;
        Customer cust=new Customer();//Creating a default customer object
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");//Database Connection
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Customer WHERE Mobnumber='"+TelNo+"'");//Query to access data from the database
          while(rslt.next()){
              cust=new Customer(rslt.getString("Mobnumber"), rslt.getString("Cname"), rslt.getString("Clocation"), rslt.getString("type"));/*Taking data from the database to 
                                                                                                                                              a customer object*/
              
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return cust;
    }
    
    
    
    public boolean update(Customer cobj){//Mwthos in the controller class to update data in tables
        Connection dbcon;
        String mnum=cobj.getmnum();
        String name=cobj.getnm();
        String loc=cobj.getloc();
        String type=cobj.gettype();
        try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");//database connection
           PreparedStatement ps=dbcon.prepareStatement("update Customer set Cname=?, Clocation=?, type=? where mobnumber=?");//query for updating customer info
           
           ps.setString(1,name);
           ps.setString(2,loc);
           ps.setString(3,type);
           ps.setString(4,mnum);
           ps.executeUpdate();
           dbcon.close();
           return true;
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    
    public boolean delete(String mnum){
        Connection dbcon;
        try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");//database connection
           PreparedStatement ps=dbcon.prepareStatement("delete from Customer where mobnumber=?");//Query for deleting a customer from the customer table
           ps.setString(1,mnum);
           ps.executeUpdate();
           dbcon.close();
           return true;
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
}
