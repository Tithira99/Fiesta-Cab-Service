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
public class Subsidiary {
    String Sname;
    String Manager;
    
    public Subsidiary(){
    
    }
    
    public Subsidiary(String name){
        this.Sname=name;
        
    }
    public Subsidiary(String name, String Mger){
        this.Sname=name;
        this.Manager=Mger;
    }
    
    public void setsname(String name){
        this.Sname=name;
    }
    
    public void setMger(String Mger){
        this.Manager=Mger;
    }
    
    public String getname(){
        return this.Sname;
    }
    
    public String getMger(){
        return this.Manager;
    }
}
