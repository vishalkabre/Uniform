package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.generics.ApplicationMethods;
import com.trianing.waits.WaitTypes;

public class UniformProductReturns_POM {
	private WebDriver driver; 
	
	public UniformProductReturns_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']/..")
	private WebElement cart; 

	@FindBy(xpath="//*[@id='sale']/ul/li[3]/a")
	private WebElement retrunOrders_link; 
		
	@FindBy(xpath="//*[@id='button-filter']/i")
	private WebElement filterbutton; 

	@FindBy(id="input-return-id")
	private WebElement orderReturn_ID; 
	
	
	public void return_Order() {
		try {
			Thread.sleep(4000); 
			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.cart, 40);
			this.cart.click(); 
			waitElement.waitForElement(this.retrunOrders_link, 40);
			this.retrunOrders_link.click(); 		

			
			
			waitElement.waitForElement(this.orderReturn_ID, 40);
			this.orderReturn_ID.sendKeys("211");
			
			waitElement.waitForElement(this.filterbutton, 40);
			this.filterbutton.click(); 
		} catch (InterruptedException e) {
			System.out.println("Scenario to return Order is having exception error."); 
			e.printStackTrace();
		}
		
	}
	
}
