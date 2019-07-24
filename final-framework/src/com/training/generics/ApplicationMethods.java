package com.training.generics;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.pom.LoginPOM;
import com.training.pom.UniformPOM;
import com.training.pom.UniformProductReturns_POM;
import com.training.pom.UniformRecurringOrders_POM;
import com.training.pom.UniformOrder_POM;

public class ApplicationMethods {
	WebDriver driver ; 
	private UniformPOM uniformPOM; 
	private LoginPOM loginPOM;
	private UniformOrder_POM uniformorderPOM; 
	private UniformRecurringOrders_POM uniformrecurringorderPOM; 
	private UniformProductReturns_POM uniformproductreturnPOM; 


	public ApplicationMethods(WebDriver driver){
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type){
		WebElement element  = null;
		type = type.toLowerCase();
		
		if(type.equals("id")){
			element  =  driver.findElement(By.id(locator));
		} else if(type.equals("css")){
			element = driver.findElement(By.cssSelector(locator));
		}else if (type.equals("name")){
			element  = driver.findElement(By.name(locator));
		}else if(type.equals("xpath")){
			element = driver.findElement(By.xpath(locator));
		}
		if(checkSingleEntry(locator, type)){
			//System.out.println("Element Found and Returned");
			return element;
		}	
		System.out.println("Sorry Element not found, so not returned...");
		return null;


	}

	
	// shall give if it has multiple entries as a list in DOM 
	
	public List<WebElement> getElementsAsList(String locator, String type){
		type = type.toLowerCase();
		if(type.equals("id")){
			return driver.findElements(By.id(locator));
		}else if(type.equals("name")){
			return driver.findElements(By.name(locator));
		}else if(type.equals("xpath")){
			return driver.findElements(By.xpath(locator));
		}else if(type.equals("class")){
			return driver.findElements(By.className(locator));
		}// other TODO 
		return null;
	}
	
	// return true if element exists 
	// this method works for us when we have more than 1 element 
	// to be found for 
	public boolean isElementFound(String locator, String type){
		return getElementsAsList(locator, type).size()>0;
	}
	
	// this method gives true only where there is an single entry 
	// in the DOM 
	public boolean checkSingleEntry(String locator, String type){
		return getElementsAsList(locator, type).size() ==1;
	}

	public void acceptalert(){
		Alert alerts = driver.switchTo().alert();
		alerts.accept();
	}
	
	public void login(){
		loginPOM = new LoginPOM(driver); 
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 		
	}
	
	public void deleteOrder(){
		uniformorderPOM = new UniformOrder_POM(driver);
		uniformorderPOM.cart_Order();

	}
	
	public void recurring_OrderFilter(){
		uniformrecurringorderPOM = new UniformRecurringOrders_POM(driver); 
		uniformrecurringorderPOM.recurring_Order();

	}
	
	public void return_Order(){
		uniformproductreturnPOM = new UniformProductReturns_POM(driver); 
		uniformproductreturnPOM.return_Order();

	}
}
