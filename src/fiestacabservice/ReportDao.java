/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiestacabservice;

import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tithira
 */
public class ReportDao {
    public ReportDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(Exception ex){
            System.out.println("Error loading Driver: "+ex.toString());
        }
        
    }
    
   

    public void pickReport() throws JRException{
        Connection dbcon;
         
        try{
        dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
        JasperDesign jdesign = JRXmlLoader.load("D:\\Sem 3 Notes\\Software Engineering\\FiestaCabService\\src\\fiestacabservice\\report1.jrxml");
        String sql="SELECT b.BOOKINGID,b.Btype, b.Location, b.Destination, b.Date,b.nVehicles, b.DTOBEDELIVERED, b.ReturnDate, b.CMobNumber, b.Supervisor,v.REGNUMBER,v.VMODEL,v.SUPID,d.DRIVERID,d.DNAME  FROM Booking b,AssignVehicle av, Vehicle v, Driver d WHERE b.BookingID=av.bkid AND av.VREGNUMBER=v.REGNUMBER AND v.DID=d.DRIVERID AND BType='Pick'";
        JRDesignQuery updatedqry=new JRDesignQuery();
        updatedqry.setText(sql);
        
        jdesign.setQuery(updatedqry);
        JasperReport jreport= JasperCompileManager.compileReport(jdesign);
        
        JasperPrint print=JasperFillManager.fillReport(jreport, null, dbcon);
        
        JasperViewer.viewReport(print);
        }catch(SQLException ex){
            System.out.println(ex);
            
        }catch(JRException ex){
            
        }
     
    }
    
    public void mostvehicleB() throws JRException{
        Connection dbcon;
         
        try{
        dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
        JasperDesign jdesign = JRXmlLoader.load("D:\\Sem 3 Notes\\Software Engineering\\FiestaCabService\\src\\fiestacabservice\\report3.jrxml");
        String sql="SELECT b.LOCATION,SUM(b.NVEHICLES) AS NumberofVehicles FROM Booking b GROUP BY (b.LOCATION) ORDER BY NumberofVehicles FETCH FIRST 5 ROWS ONLY";
        JRDesignQuery updatedqry=new JRDesignQuery();
        updatedqry.setText(sql);
        
        jdesign.setQuery(updatedqry);
        JasperReport jreport= JasperCompileManager.compileReport(jdesign);
        
        JasperPrint print=JasperFillManager.fillReport(jreport, null, dbcon);
        
        JasperViewer.viewReport(print);
        }catch(SQLException ex){
            System.out.println(ex);
            
        }catch(JRException ex){
            
        }
     
    }
    
    public void BookingHistory(String telNo) throws JRException{
        Connection dbcon;
         
        try{
        dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/FiestaCabDB;create=true","TithiraSE","tithirase");
        JasperDesign jdesign = JRXmlLoader.load("D:\\Sem 3 Notes\\Software Engineering\\FiestaCabService\\src\\fiestacabservice\\report4.jrxml");
        String sql="SELECT b.BookingID, b.Btype, b.destination, b.nVehicles, b.vhtype, v.regnumber, d.DriverID, d.Dname  FROM Booking b, AssignVehicle a, Vehicle v, Driver d WHERE b.BOOKINGID=a.BKID AND a.VREGNUMBER=v.REGNUMBER AND v.DID=d.DRIVERID AND b.CMobNumber='"+telNo+"'";
        JRDesignQuery updatedqry=new JRDesignQuery();
        updatedqry.setText(sql);
        
        jdesign.setQuery(updatedqry);
        JasperReport jreport= JasperCompileManager.compileReport(jdesign);
        
        JasperPrint print=JasperFillManager.fillReport(jreport, null, dbcon);
        
        JasperViewer.viewReport(print,false);
        
        }catch(SQLException ex){
            System.out.println(ex);
            
        }catch(JRException ex){
            
        }
     
    }
    
    
}
