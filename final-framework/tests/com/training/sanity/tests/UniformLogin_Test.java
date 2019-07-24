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
import com.training.pom.UniformProductReturns_POM;
import com.training.pom.UniformRecurringOrders_POM;
import com.training.pom.UniformOrder_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformLogin_Test {


	private WebDriver driver; 
	private String baseUrl; 
	private UniformPOM uniformPOM; 
	private LoginPOM loginPOM;
	private UniformOrder_POM uniformorderPOM; 
	private UniformRecurringOrders_POM uniformrecurringorderPOM; 	
	private UniformProductReturns_POM uniformproductreturnPOM; 
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
		loginPOM = new LoginPOM(driver);
		uniformorderPOM = new UniformOrder_POM(driver);
		uniformrecurringorderPOM = new UniformRecurringOrders_POM(driver);
		uniformproductreturnPOM = new UniformProductReturns_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(priority=1, groups = { "simpleTestCases" })
	public void loginPassTest() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		System.out.println("Admin logged in in system");

		screenShot.captureScreenShot("First");
	}
	
	@Test(priority=2, groups = { "simpleTestCases" })
	public void deleteOrder() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.deleteOrder();
		System.out.println("Scenario to delete Order is comepleted");
		screenShot.captureScreenShot("DeleteOrder");
	}
	
	@Test(priority=3, groups={"simpleTestCases"})
	public void recurring_OrderFilter() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.recurring_OrderFilter();
		//appmeth.return_Order();
		System.out.println("Scenario to recurring Order Filtered is comepleted");
		screenShot.captureScreenShot("Recurring_OrderFilter");
	}
	
	@Test(priority=4, groups={"simpleTestCases"})
	public void return_Order() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.return_Order();
		System.out.println("Scenario to return Order is comepleted");
		screenShot.captureScreenShot("Return_Order");
	}
	
	
	
}
