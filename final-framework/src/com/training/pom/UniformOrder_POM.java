package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.generics.ApplicationMethods;
import com.trianing.waits.WaitTypes;

public class UniformOrder_POM {
	private WebDriver driver; 
	
	public UniformOrder_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']/..")
	private WebElement cart; 
	
	@FindBy(xpath="//*[@id='button-menu']/i")
	private WebElement MenuBar; 
	
	
	@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
	private WebElement Orders_link; 
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[1]/input[1]")
	private WebElement selectOrder; 
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[2]") 
	private WebElement orderID; 
	

	
	public String create_xpath(){
		String firstorder = null;
		if(this.orderID.getText() != null){
			firstorder = "//*[@id='button-delete" + this.orderID.getText() + "']";
		}
		return firstorder;
	}
	
	public void cart_Order() {
		try {
			Thread.sleep(4000); 
			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.cart, 40);
			this.cart.click(); 
			waitElement.waitForElement(this.Orders_link, 40);
			this.Orders_link.click(); 
			ApplicationMethods obj = new ApplicationMethods(driver);
			WebElement selectordertodelete = obj.getElement("//*[@id='form-order']/div/table/tbody/tr[1]/td[1]/input[1]","xpath");
			waitElement.waitForElement(selectordertodelete, 40);
					
			String OrdertoDeletePath = create_xpath();
			WebElement ordertodelete = obj.getElement(OrdertoDeletePath,"xpath");
			waitElement.waitForElement(ordertodelete, 40);
			
			ordertodelete.click();
			obj.acceptalert();
		} catch (InterruptedException e) {
			System.out.println("Scenario to delete Order is having exception error.");
			e.printStackTrace();
		}
		
	}
	

	
}
