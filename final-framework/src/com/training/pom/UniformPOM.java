package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.generics.ApplicationMethods;
import com.trianing.waits.WaitTypes;

public class UniformPOM {
	private WebDriver driver; 
	
	public UniformPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//i[@class='fa fa-key']/..")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']/..")
	private WebElement cart; 
	
	@FindBy(xpath="//*[@id='button-menu']/i")
	private WebElement MenuBar; 
	
	
	@FindBy(xpath="//*[@id='sale']/ul/li[1]/a")
	private WebElement Orders_link; 
	
	@FindBy(xpath="//*[@id='sale']/ul/li[2]/a")
	private WebElement RecurringOrders_link; 
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[1]/input[1]")
	private WebElement selectOrder; 
	
	@FindBy(xpath="//*[@id='sale']/ul/li[3]/a")
	private WebElement retrunOrders_link; 
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[2]") 
	private WebElement orderID; 
	
	@FindBy(xpath="//*[@id='input-status']")
	private WebElement orderStatus; 
	
	@FindBy(xpath="//*[@id='button-filter']/i")
	private WebElement filterbutton; 

	@FindBy(id="input-return-id")
	private WebElement orderReturn_ID; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 		
	}
	
	public String create_xpath(){
		String firstorder = null;
		if(this.orderID.getText() != null){
			firstorder = "//*[@id='button-delete" + this.orderID.getText() + "']";
			System.out.println(firstorder);
		}
		return firstorder;
	}
	
	public void cart_Order() {
		WaitTypes waitElement = new WaitTypes(driver);
		waitElement.waitForElement(this.cart, 40);
		this.cart.click(); 
		waitElement.waitForElement(this.Orders_link, 40);
		this.Orders_link.click(); 
		ApplicationMethods obj = new ApplicationMethods(driver);
		WebElement selectordertodelete = obj.getElement("//*[@id='form-order']/div/table/tbody/tr[1]/td[1]/input[1]","xpath");
		waitElement.waitForElement(selectordertodelete, 40);
		// this.selectOrder.click();		
		String OrdertoDeletePath = create_xpath();
		WebElement ordertodelete = obj.getElement(OrdertoDeletePath,"xpath");
		waitElement.waitForElement(ordertodelete, 40);
		
		ordertodelete.click();
		obj.acceptalert();
		
	}
	
	public void recurring_Order() {
		try {
			Thread.sleep(4000); // 1000 means 1 second 
			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.cart, 40);
			this.cart.click(); 
			waitElement.waitForElement(this.RecurringOrders_link, 40);
			this.RecurringOrders_link.click(); 		
			System.out.println("RecurringOrders_link click");
			
			
			waitElement.waitForElement(this.orderStatus, 40);
			Select orderStatusDrpdwn = new Select(this.orderStatus);
			orderStatusDrpdwn.selectByVisibleText("Active"); 
			
			System.out.println("orderStatus selected as Active");
			
			waitElement.waitForElement(this.filterbutton, 40);
			System.out.println("filterbutton wait is completed");
			this.filterbutton.click(); 
			System.out.println("filterbutton click");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void return_Order() {
		WaitTypes waitElement = new WaitTypes(driver);
		waitElement.waitForElement(this.cart, 40);
		this.cart.click(); 
		waitElement.waitForElement(this.retrunOrders_link, 40);
		this.retrunOrders_link.click(); 		
		System.out.println("retrunOrders_link click");
		
		
		waitElement.waitForElement(this.orderReturn_ID, 40);
		this.orderReturn_ID.sendKeys("229");
		
		waitElement.waitForElement(this.filterbutton, 40);
		System.out.println("filterbutton wait is completed");
		this.filterbutton.click(); 
		System.out.println("filterbutton click");
		
	}
	
}
