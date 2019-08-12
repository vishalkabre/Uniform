package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import  java.sql.Connection;		
import  java.sql.Statement;
import java.util.Properties;
import  java.sql.ResultSet;		
import  java.sql.DriverManager;	

public class DataBaseTest {
	
	private String dbUrl; 
	private String dbuser; 
	private String dbpassword; 

	private static Properties properties; 

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/db.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp(){

		dbUrl = properties.getProperty("url");
		dbuser = properties.getProperty("username");
		dbpassword = properties.getProperty("password");

	}
	
	
	
	@Test
	public void databaseDetails() {
		try {
			// step1 load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			// step2 create the connection object
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniform","root","root");
			Connection con = DriverManager.getConnection(dbUrl,dbuser,dbpassword);
			// step3 create the statement object
			Statement stmt = con.createStatement();
			// step4 execute query
			ResultSet rs = stmt.executeQuery(("select * from login"));
			// While Loop to iterate through all data and print results		
			while (rs.next()){
		        		String userName = rs.getString(1);								        
                        String passWord = rs.getString(2);					                               
                        System. out.println(userName+"  "+passWord);		
                }	
			// closing DB Connection		
  			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			// closing DB Connection		
		}
	}	
}