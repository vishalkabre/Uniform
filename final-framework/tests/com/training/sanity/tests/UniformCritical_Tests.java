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

public class UniformCritical_Tests {


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
	//	driver.quit();
	}
	
	@Test(priority=1, groups = { "Critical" },enabled=false)
	public void loginPassTest() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		System.out.println("Admin logged in in system");

		screenShot.captureScreenShot("First");
	}
	
	@Test(priority=2, groups = { "Critical" },enabled=false)
	public void editOrder() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.editOrder();
		appmeth.db_Order();
		System.out.println("Scenario to edit Order and retrieve the values from Product tables is comepleted");
		screenShot.captureScreenShot("EditOrder");
	}
	
	@Test(priority=3, groups={"Critical"})
	public void editmultiple_Order() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.editmultiple_Order();
		System.out.println("Scenario to edit multiple Order is comepleted");
		screenShot.captureScreenShot("editmultiple_Order");
	}
	
	@Test(priority=4, groups={"Critical"},enabled=false)
	public void  create_multiple_category_product() {
		ApplicationMethods appmeth = new ApplicationMethods(driver);
		appmeth.login();
		appmeth.create_multiplecategories();
		appmeth.create_multipleproducts();
		System.out.println("Scenario to create multiple category and add product on the created category is comepleted");
		screenShot.captureScreenShot("Create_category_product_Order");
	}
	
	
	
}
