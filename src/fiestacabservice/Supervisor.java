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
public class Supervisor {
    String SupervisorID;
    String Sname;
    String Subsidiary;
  
    public Supervisor(){
        
    }
    
    public Supervisor(String id, String name,String sbd ){
        this.SupervisorID=id;
        this.Sname=name;
        this.Subsidiary=sbd;
        
    }
    public void setid(String sid){
        this.SupervisorID=sid;
        
    }
    
    public void setname(String name){
        this.Sname=name;
    }
    public void setsbd(String sbd){
        this.Subsidiary=sbd;
    }
    
    public String getid(){
        return this.SupervisorID;
    }
    
    public String getname(){
        return this.Sname;
    }
    
    public String getsbd(){
        return this.Subsidiary;
    }
}
