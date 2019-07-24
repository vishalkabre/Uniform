package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.generics.ApplicationMethods;
import com.trianing.waits.WaitTypes;

public class UniformRecurringOrders_POM {
	private WebDriver driver; 
	
	public UniformRecurringOrders_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']/..")
	private WebElement cart; 
			
	@FindBy(xpath="//*[@id='sale']/ul/li[2]/a")
	private WebElement RecurringOrders_link; 
		
	@FindBy(xpath="//*[@id='input-status']")
	private WebElement orderStatus; 
	
	@FindBy(xpath="//*[@id='button-filter']/i")
	private WebElement filterbutton; 

	
	public void recurring_Order() {
		try {
			Thread.sleep(4000); // 1000 means 1 second 
			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.cart, 40);
			this.cart.click(); 
			waitElement.waitForElement(this.RecurringOrders_link, 40);
			this.RecurringOrders_link.click(); 		
			
			
			waitElement.waitForElement(this.orderStatus, 40);
			Select orderStatusDrpdwn = new Select(this.orderStatus);
			orderStatusDrpdwn.selectByVisibleText("Active"); 
			
			waitElement.waitForElement(this.filterbutton, 40);

			this.filterbutton.click(); 

		} catch (InterruptedException e) {
			System.out.println("Scenario to recurring Order Filtered is having exception error.");
			e.printStackTrace();
		}
		
	}
	
	

	
}
