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
import java.util.*;
public class BookingDao {
    
    public BookingDao(){
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
    }
    
    
    public boolean insert(Booking bobj){
       
        Connection dbcon;
        String bid=bobj.getbid();
        String btype=bobj.getbtype();
        String loc=bobj.getloc();
        String Des=bobj.getDes();
        String Date1=bobj.getDate1();
        int nVh=bobj.getnVh();
        String Vtype=bobj.getvtype();
        String DatetoDeliver=bobj.getDatetoDeliver();
        String DeliveredDate=bobj.getDeliveredDate();
        String ReturnDate=bobj.getreturnDate();
        boolean HireEnded=bobj.getHended();
        String CmNum=bobj.getCmob();
        String supid=bobj.getsid();
        boolean vasgn=bobj.getvasgn();
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("insert into Booking values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1,bid);
           ps.setString(2,btype);
           ps.setString(3,loc);
           ps.setString(4,Des);
           ps.setString(5,Date1);
           ps.setInt(6,nVh);
           ps.setString(7,Vtype);
           ps.setString(8,DatetoDeliver);
           ps.setString(9,DeliveredDate);
           ps.setString(10,ReturnDate);
           ps.setBoolean(11,HireEnded);
           ps.setString(12,CmNum);
           ps.setString(13,supid);
           ps.setBoolean(14,vasgn);
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    
    String id;
    public String getnewid(){
        Connection dbcon;
      
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select COUNT(BookingID)+1 FROM Booking");
          while(rslt.next()){
              id=(rslt.getString(1));
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return id;
    }
    
    
    public ArrayList<Customer> SearchBookbyCustomer(String TelNo){
       Connection dbcon;
        Customer cust=new Customer();
        ArrayList<Customer> CustList=new ArrayList<Customer>();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Booking WHERE CMobnumber='"+TelNo+"'");
          while(rslt.next()){
              cust=new Customer(rslt.getString("CMobnumber"), rslt.getString("Cname"), rslt.getString("Clocation"), rslt.getString("type"));
              CustList.add(cust);
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return CustList;
    }
    
    
    public Booking getCustBooknotEnded(String TelNo){
       Connection dbcon;
        Booking bk=new Booking();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Booking WHERE CMobnumber='"+TelNo+"' AND HireEnded="+false+"");
          while(rslt.next()){
              bk=new Booking(rslt.getString("BookingID"), rslt.getString("Btype"), rslt.getString("location"),rslt.getString("Destination"), rslt.getString("Date"), rslt.getInt("nVehicles"),rslt.getString("Vhtype"), rslt.getString("DtobeDelivered"), rslt.getBoolean("HireEnded"), rslt.getString("CmobNumber"), rslt.getBoolean("VehicleAssigned"));
              
          }
          dbcon.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return bk;
    }
    
    
    public ArrayList<Booking> searchbbysub(String sub){
        Connection dbcon;
        Booking bk=new Booking();
        ArrayList<Booking> blist=new ArrayList<Booking>();
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Booking WHERE location='"+sub+"'");
          while(rslt.next()){
              bk=new Booking(rslt.getString("BookingID"), rslt.getString("Btype"),rslt.getString("location"), rslt.getString("Destination"), rslt.getString("Date"), rslt.getInt("nVehicles"),rslt.getString("Vhtype"), rslt.getString("DtobeDelivered"),rslt.getString("DeliveredDate"),rslt.getString("ReturnDate"), rslt.getBoolean("HireEnded"), rslt.getString("CmobNumber"), rslt.getString("Supervisor"), rslt.getBoolean("VehicleAssigned"));
              blist.add(bk);
          }
          dbcon.close();
        }catch(SQLException ex){
            
            System.out.println(ex);
        }
        return blist;
        
    }
    
    
    public boolean update(Booking bobj){
        Connection dbcon;
        String bid=bobj.getbid();
        String btype=bobj.getbtype();
        String loc=bobj.getloc();
        String Des=bobj.getDes();
        String Date1=bobj.getDate1();
        int nVh=bobj.getnVh();
        String Vtype=bobj.getvtype();
        String DatetoDeliver=bobj.getDatetoDeliver();
        String DeliveredDate=bobj.getDeliveredDate();
        String ReturnDate=bobj.getreturnDate();
        boolean HireEnded=bobj.getHended();
        String CmNum=bobj.getCmob();
        String supid=bobj.getsid();
        boolean vasgn=bobj.getvasgn();
       try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
           PreparedStatement ps=dbcon.prepareStatement("Update Booking Set Btype=?,Location=?,Destination=?,Date=?,nVehicles=?,VhType=?,DtobeDelivered=?,DeliveredDate=?,ReturnDate=?,HireEnded=?,CMobNumber=?,Supervisor=?,VehicleAssigned=? WHERE BookingID=?");
          
           ps.setString(1,btype);
           ps.setString(2,loc);
           ps.setString(3,Des);
           ps.setString(4,Date1);
           ps.setInt(5,nVh);
           ps.setString(6,Vtype);
           ps.setString(7,DatetoDeliver);
           ps.setString(8,DeliveredDate);
           ps.setString(9,ReturnDate);
           ps.setBoolean(10,HireEnded);
           ps.setString(11,CmNum);
           ps.setString(12,supid);
           ps.setBoolean(13,vasgn);
           ps.setString(14,bid);
           
           ps.executeUpdate();
           dbcon.close();
           return true;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    
    public Booking SearchBookingbyID(String bid){
        Connection dbcon;
        Booking bk=new Booking();
       
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Booking WHERE BookingID='"+bid+"'");
          while(rslt.next()){
              bk=new Booking(rslt.getString("BookingID"), rslt.getString("Btype"),rslt.getString("location"), rslt.getString("Destination"), rslt.getString("Date"), rslt.getInt("nVehicles"),rslt.getString("Vhtype"), rslt.getString("DtobeDelivered"),rslt.getString("DeliveredDate"),rslt.getString("ReturnDate"), rslt.getBoolean("HireEnded"), rslt.getString("CmobNumber"), rslt.getString("Supervisor"), rslt.getBoolean("VehicleAssigned"));
          
          }
          dbcon.close();
        }catch(SQLException ex){
            
            System.out.println(ex);
        }
        return bk;
        
    }
    
   public ArrayList<Booking> searchbbysupID(String SupID){//Method for searching Bookings by Supplier ID
        Connection dbcon;
        Booking bk=new Booking();//Creating a Booking Object
        ArrayList<Booking> blist=new ArrayList<Booking>();//Creating an Array List of the type Booking
        try{
          dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");//Database connection
          Statement stmt=dbcon.createStatement();
          ResultSet rslt=stmt.executeQuery("select * FROM Booking WHERE Supervisor='"+SupID+"'");//Query to filter Bookings according to the given ID
          while(rslt.next()){//creating Booking objects with the Searched results and passing it to the Array List
              bk=new Booking(rslt.getString("BookingID"), rslt.getString("Btype"),rslt.getString("location"), rslt.getString("Destination"), rslt.getString("Date"), rslt.getInt("nVehicles"),rslt.getString("Vhtype"), rslt.getString("DtobeDelivered"),rslt.getString("DeliveredDate"),rslt.getString("ReturnDate"), rslt.getBoolean("HireEnded"), rslt.getString("CmobNumber"), rslt.getString("Supervisor"), rslt.getBoolean("VehicleAssigned"));
              blist.add(bk);
          }
          dbcon.close();//Closing the database connection
        }catch(SQLException ex){
          
            System.out.println(ex);//passing the error to the console, if an error is occured(SQL Exceptions)
        }
        return blist;//returning the ArrayList
        
    }
}
