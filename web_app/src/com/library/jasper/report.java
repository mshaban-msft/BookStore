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
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "admin");
	         
	            FileInputStream inputFile = new FileInputStream("/mnt/DE3E99B43E9985E5/projects and models/Library/src/report/Users_report.jrxml");
	            JasperDesign jd= JRXmlLoader.load(inputFile);
	            JasperReport jr=JasperCompileManager.compileReport(jd);
	            JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
	            File f= new File("/mnt/DE3E99B43E9985E5/projects and models/Library/src/report/rep.pdf");
	            f.createNewFile();
	            
	            OutputStream os = new FileOutputStream(f);
	        
	            JasperExportManager.exportReportToPdfStream(jp, os);
	            System.out.println("report printed");
	            con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }


		public static void main(String[] args) {
			new report().createReport();
	    }

	}
