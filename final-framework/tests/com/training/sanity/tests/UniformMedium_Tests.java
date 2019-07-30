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
import com.training.pom.UniformCategories_POM;
import com.training.pom.UniformPOM;
import com.training.pom.UniformProductReturns_POM;
import com.training.pom.UniformRecurringOrders_POM;
import com.training.pom.UniformOrder_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformMedium_Tests {


	private WebDriver driver; 
	private String baseUrl; 
	private UniformPOM uniformPOM; 
	private LoginPOM loginPOM;
	private UniformOrder_POM uniformorderPOM; 
	private UniformRecurringOrders_POM uniformrecurringorderPOM; 	
	private UniformProductReturns_POM uniformproductreturnPOM; 
	private UniformCategories_POM uniformcategoriesPOM; 
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
		uniformcategoriesPOM = new UniformCategories_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(priority=1, groups = { "mediumTestCases" })
	public void loginPassTest() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		System.out.println("Admin logged in in system");

		screenShot.captureScreenShot("First");
	}
	
	@Test(priority=2, groups = { "mediumTestCases" })
	public void editOrder() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.editOrder();
		System.out.println("Scenario to edit Order is comepleted");
		screenShot.captureScreenShot("EditOrder");
	}
	
	@Test(priority=3, groups={"mediumTestCases"})
	public void searchOrder() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.searchOrder();
		//appmeth.return_Order();
		System.out.println("Scenario to search Order with all Filter options is comepleted");
		screenShot.captureScreenShot("Search_OrderFilter");
	}
	
	@Test(priority=4, groups={"mediumTestCases"})
	public void  create_category_product_Order() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.create_categories();
		appmeth.create_products();
		System.out.println("Scenario to create category & add product on the created category is comepleted");
		screenShot.captureScreenShot("Create_category_product_Order");
	}
	
	
	
}
