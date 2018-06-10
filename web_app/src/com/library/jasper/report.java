package com.library.jasper ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


public class report {



	    Connection con;
	    Statement stmt;
	    ResultSet rs;

	    public void createReport() {
	        try {
	            
	           // String query="select e.Ssn as EMPLOYEE_ID, e.BDATE as EMPLOYEE_BDATE, e.dno as EMPLOYEE_DESIGNATION,e.ENAME as EMPLOYEE_EMPNAME, e.SALARY as EMPLOYEE_SALARY from EMPLOYEE as e";
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "admin");
	         //   stmt=con.createStatement();
	         //   rs=stmt.executeQuery(query);
	         //   rs.absolute(3);
//	            if(rs.next())
//	            	System.out.println(rs.getInt(1));
//	            else return ;
	          
	           // JRResultSetDataSource rsdt=new JRResultSetDataSource(rs);
	            
	            FileInputStream inputFile = new FileInputStream("C:/Users/Saed Hamdy/workspace/book_2/src/report/Users_report.jrxml");
	            JasperDesign jd= JRXmlLoader.load(inputFile);
	            JasperReport jr=JasperCompileManager.compileReport(jd);
	            JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
	            File f= new File("C:/Users/Saed Hamdy/workspace/book_2/src/report/rep.pdf");
	            f.createNewFile();
	            
	            OutputStream os = new FileOutputStream(f);
	            
	            JasperExportManager.exportReportToPdfStream(jp, os);
//	            
//	            JasperPrint jp;
//	            jp = JasperFillManager.fillReport("C:/Users/Saed Hamdy/workspace/book_2/src/report/report1.jrxml", new HashMap(), rsdt);
//	            JasperViewer jv = new JasperViewer(jp);
//	            jv.setVisible(true);
	            System.out.println("report printed");
	            con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }


		public static void main(String[] args) {
	    	
//	    	try{
//	    		String query="SELECT * FROM book;";
//	    		//Class.forName("something.jdbc.driver.YourFubarDriver");
//	            Class.forName("com.mysql.jdbc.Driver");
//	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore2", "root", "admin");
//	            Statement stmt=con.createStatement();
//	            ResultSet rs=stmt.executeQuery(query);
//	            rs.absolute(10);
//	            if(rs.next())
//	            	System.out.println(rs.getInt(1));
//	            
//	    	}catch(Exception e){
//	    		System.out.println(e.getMessage());
//	    	}
	        new report().createReport();
	    }

	}
