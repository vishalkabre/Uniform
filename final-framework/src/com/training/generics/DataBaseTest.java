package com.training.generics;

import org.testng.annotations.Test;

import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;	

public class DataBaseTest {
	
	public void databaseDetails() {
		try {
			Thread.sleep(4000);
			// step1 load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniform","root","root");
			// step3 create the statement object
			Statement stmt = con.createStatement();
			// step4 execute query
			System. out.println("Retrieve the values from Product tables");
			ResultSet rs = stmt.executeQuery(("select * from uniform_order"));
			// While Loop to iterate through all data and print results		
			while (rs.next()){
		        		String userName = rs.getString(1);								        
                        String passWord = rs.getString(2);					                               
                        System. out.println(userName+"  "+passWord);		
                }	
			Thread.sleep(4000);
			// closing DB Connection		
  			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			// closing DB Connection		
		}
	}	
}