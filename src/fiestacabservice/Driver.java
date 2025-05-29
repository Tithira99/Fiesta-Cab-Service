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
public class Driver {
    String DriverID;
    String DName;
    String Dsubsidiary;
    boolean assigned;
    
    public Driver(){
        
    }
    
    public Driver(String did){
        this.DriverID=did;
    }
    
    public Driver(String did,String name,String subd,boolean asgn){
        this.DriverID=did;
        this.DName=name;
        this.Dsubsidiary=subd;
        this.assigned=asgn;
    }
    
    
    public void setdid(String did){
        this.DriverID=did;
    }
    
    public void setdname(String name){
        this.DName=name;
    }
    
    public void setsub(String subd){
        this.Dsubsidiary=subd;
    }
    
     public void setasgn(boolean asgn){
        this.assigned=asgn;
    }
    
    public String getdid(){
        return this.DriverID;
    }
    
    public String getname(){
        return this.DName;
    }
    
    public String getsubd(){
        return this.Dsubsidiary;
    }
    
    public boolean getasgn(){
        return this.assigned;
    }
}
