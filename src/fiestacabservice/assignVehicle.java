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
public class assignVehicle {
    String BkingID;
    String Vhid;
    
    
    public assignVehicle(){
        
    }
    
    public assignVehicle(String bid, String vid){
        this.BkingID=bid;
        this.Vhid=vid;
    }
    
    public void setbid(String bid){
        this.BkingID=bid;
        
    }
    
    public void setvid(String vid){
        this.Vhid=vid;
        
    }
    
    public String getbid(){
        return this.BkingID;
        
    }
    
    public String getvid(){
        return this.Vhid;
        
    }
}

