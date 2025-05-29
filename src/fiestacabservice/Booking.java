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
public class Booking {
    
    String BookingID;
    String Btype;
    String location;
    String Destination;
    String Date;
    int nvehicles;
    String VType;
    String DatetobeDelivered;
    String DeliveredDate;
    String ReturnDate;
    boolean HireEnded;
    String CustMobileNum;
    String SupID;
    boolean VhAssigned;
    
            
    public Booking(){
        
    }
    
    
    public Booking(String bid){
        this.BookingID=bid;
    }
    
    
    
    public Booking(String bid, String btype,String loc, String Des, String Date1, int nv,  String vtype, String DatetoDeliver,boolean hend, String CMobNum,boolean vasgn){
        
        this.BookingID=bid;
        this.Btype=btype;
        this.location=loc;
        this.Destination=Des;
        this.Date=Date1;
        this.nvehicles=nv;
        this.VType=vtype;
        this.DatetobeDelivered=DatetoDeliver;
        this.HireEnded=hend;
        this.CustMobileNum=CMobNum;
        this.VhAssigned=vasgn;
        
    }
     
     
    public Booking(String bid, String btype,String loc, String Des, String Date1, int nv,  String vtype, String DatetoDeliver, String DelivrdD, String CMobNum, String Spid,boolean vasgn){
        
        this.BookingID=bid;
        this.Btype=btype;
        this.location=loc;
        this.Destination=Des;
        this.Date=Date1;
        this.nvehicles=nv;
        this.VType=vtype;
        this.DatetobeDelivered=DatetoDeliver;
        this.DeliveredDate=DelivrdD;
        this.CustMobileNum=CMobNum;
        this.SupID=Spid;
        this.VhAssigned=vasgn;
       
        
    }
    
    
    public Booking(String bid, String btype,String loc, String Des, String Date1, int nv,  String vtype, String DatetoDeliver, String DelivrdD, String RetrnD, boolean Hended, String CMobNum, String Spid, boolean vasgn){
        
        this.BookingID=bid;
        this.Btype=btype;
        this.location=loc;
        this.Destination=Des;
        this.Date=Date1;
        this.nvehicles=nv;
        this.VType=vtype;
        this.DatetobeDelivered=DatetoDeliver;
        this.DeliveredDate=DelivrdD;
        this.ReturnDate=RetrnD;
        this.HireEnded=Hended;
        this.CustMobileNum=CMobNum;
        this.SupID=Spid;
        this.VhAssigned=vasgn;
        
    }
    
    
    public void setbid(String bid){
        this.BookingID=bid;
    }
    
    
    public void setbtype(String btype){
        this.Btype=btype;
    }
    
    public void setloc(String loc){
        this.location=loc;
        
    }
    
    
    public void setDes(String Des){
        this.Destination=Des;
        
    }
    
    
    
    public void setDate1(String Date1){
        this.Date=Date1;
    }
    
    
    
    public void setnVh(int nVh){
        this.nvehicles=nVh;
    }
    
    
    
    public void setVtype(String vtype){
       this.VType=vtype;
       
    }
     
     
     
    public void setDatetoDeliver(String DatetoDeliver){
        
       this.DatetobeDelivered=DatetoDeliver;
        
    }
     
     
   
     
    public void setDelivrdD(String DelivrdD){
        this.DeliveredDate=DelivrdD;
       
    }
    public void setRetrnD(String RetrnD){
        
        
        this.ReturnDate=RetrnD;
       
    }
   
    public void setHended(boolean Hended){
        
        this.HireEnded=Hended;
        
    }
         
        
    public void setCMobNum(String CMobNum){
        
        this.CustMobileNum=CMobNum;
       
    }
    
     
   
      
    public void setSpid(String Spid){
        this.SupID=Spid;
    }
    
     public void setassigned(boolean vasgn){
        this.VhAssigned=vasgn;
    }
    
    public String getbid(){
        return this.BookingID;
    }
    
    public String getbtype(){
        return this.Btype;
    }
    
    public String getloc(){
        return this.location;
        
       
    }
    
    public String getDes(){
        return this.Destination;
        
       
    }
     
    public String getDate1(){
        return this.Date;
        
    }
      
    public int getnVh(){
        return this.nvehicles;
       
    }
       
    public String getvtype(){
       return this.VType;
       
    }
        
    public String getDatetoDeliver(){
         return this.DatetobeDelivered;
        
    }
         
   
          
    public String getDeliveredDate(){
        return this.DeliveredDate;
        
    }
           
    public String getreturnDate(){
       return this.ReturnDate;
        
    }
            
     public boolean getHended(){
        return this.HireEnded;
        
    }
             
             
    public String getCmob(){
        return this.CustMobileNum;
        
    }
              
               
    public String getsid(){
       return this.SupID;
    }
    
    public boolean getvasgn(){
       return this.VhAssigned;
    }
         
     
    
}
