package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ApplicationMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformLogin_Test {


	private WebDriver driver; 
	private String baseUrl; 
	private UniformPOM uniformPOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		uniformPOM = new UniformPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		//driver.quit();
	}
	
	@Test
	public void loginPassTest() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		System.out.println("Admin logged in in system");
	//	appmeth.deleteOrder();
		//System.out.println("Order is deleted");
		appmeth.recurring_OrderFilter();
		//appmeth.return_Order();
		System.out.println("recurring_Order Filtered");
		screenShot.captureScreenShot("First");
	}
	
	
}
