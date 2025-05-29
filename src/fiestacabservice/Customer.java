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
public class Customer {
    
    private String MobileNum;//Customer Mobile Number
    private String Name;//Customer Name
    private String location;//Customer Location
    private String type;//Personal or Business
    
    
    public Customer(){//default constructor
        
    }
    
    public Customer(String num){//Constructor with one parameter
        this.MobileNum=num;
    }
    
    public Customer(String num,String name, String loc, String tp){//Constructor with all parameters
        this.MobileNum=num;
        this.Name=name;
        this.location=loc;
        this.type=tp;
        
    }
    
    public void setNum(String mnum){//setter for Customer Mobile number
        this.MobileNum=mnum;
    }
    
    public void setName(String nm){//setter for Customer Name
        this.Name=nm;
    }
     
    public void setloc(String loc){//setter for Customer location
        this.location=loc;
    }
    
    public void settp(String tp){//setter for Customer Type(Personal or business)
        this.type=tp;
    }
    
    public String getmnum(){//getter of the Customer Mobile Number 
        return this.MobileNum;
        
    }
    public String getnm(){//getter of the Customer name
        return this.Name;
        
    }
    public String getloc(){//getter of the Customer location
        return this.location;
        
    }
    public String gettype(){// getter of the Customer Type
        return this.type;
        
    }
      
}
