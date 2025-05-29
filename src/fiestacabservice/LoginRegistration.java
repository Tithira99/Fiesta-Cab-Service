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
public class LoginRegistration {
    private String username;
    private String password;
    private String Role;
    
    public LoginRegistration(){
        
    }
    
    public LoginRegistration(String un, String role){
        this.username=un;
        this.Role=role;
    }
    
     public LoginRegistration(String un,String pd,  String role){
        this.username=un;
        this.password=pd;
        this.Role=role;
    }
     
     public String getun (){
         return this.username;
     }
     public String getpd (){
         return this.password;
     }
     public String getrole (){
         return this.Role;
     }
     
     public void setun(String un){
         this.username=un;
     }
     
      public void setpd(String pd){
         this.password=pd;
     }
      
       public void setrole(String role){
         this.Role=role;
           
     }
       
}
