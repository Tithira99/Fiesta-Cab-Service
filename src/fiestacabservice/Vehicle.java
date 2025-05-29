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
public class Vehicle {
    
    private String VRegNumber;
    private String Vmodel;
    private String VType;
    private String Subsidiary;
    private boolean Availability;
    private String DriverID;
    String SupID;
    
    public Vehicle(){
        
    }
    
    public Vehicle(String Vid){
        this.VRegNumber=Vid;
    }
    
    public Vehicle(String vid, String vModel, String vtype, String sdiary, boolean avbty,String did, String spid){
        this.VRegNumber=vid;
        this.Vmodel=vModel;
        this.VType=vtype;
        this.Subsidiary=sdiary;
        this.Availability=avbty;
        this.DriverID=did;
        this.SupID=spid;
    }
    
    public void setid(String vid){
        this.VRegNumber=vid;
    }
    
    public void setvModel(String vModel){
        this.Vmodel=vModel;
    }
    
    public void setvtype(String vtype){
        this.VType=vtype;
    }
    
    public void setsdiary(String sdiary){
        this.Subsidiary=sdiary;
    }
    
    public void setavbty(boolean avbty){
        this.Availability=avbty;
    }
    
    public void setdid(String did){
        this.DriverID=did;
    }
    
    public void setsid(String sid){
        this.SupID=sid;
    }
    public String getvid(){
        return this.VRegNumber;
    }
    
    public String getvModel(){
        return this.Vmodel;
    }
    
    public String getvtype(){
        return this.VType;
    }
    
    public String getsdiary(){
        return this.Subsidiary;
    }
    
    public boolean getavbty(){
        return this.Availability;
    }
    
    public String getdid(){
        return this.DriverID;
    }
    
    public String getsid(){
        return this.SupID;
    }
    
    
}
