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
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[8]/a[2]") 
	private WebElement editpage; 
	
	@FindBy(id="button-customer")
	private WebElement continue_button; 
	
	@FindBy(xpath="//*[@id='cart']/tr/td[6]/button") 
	private WebElement remove_button; 
	
	@FindBy(id="input-product")
	private WebElement inputproduct;
	
	@FindBy(id="button-product-add")
	private WebElement buttonproductadd;
	
	@FindBy(id="input-quantity")
	private WebElement inputquantity;
	
	@FindBy(xpath="//*[@id='tab-product']/fieldset/div[1]/div/ul/li[1]")
	private WebElement productadd;
	
	@FindBy(id="button-cart")
	private WebElement button_cart;
	
	@FindBy(id="button-payment-address")
	private WebElement button_address;
	
	@FindBy(id="button-shipping-address")
	private WebElement buttonshippingaddress;
	
	@FindBy(id="input-shipping-method")
	private WebElement inputshippingmethod; 
	
	@FindBy(id="button-save")
	private WebElement button_save; 

	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement alertmessage; 
	
	@FindBy(id="input-order-id")
	private WebElement input_OrderId; 
	
	@FindBy(xpath="//*[@id='button-filter']/i")
	private WebElement filterbutton; 
	
	@FindBy(xpath="//*[@id='input-order-status']")
	private WebElement orderStatus; 
	
	@FindBy(id="input-customer")
	private WebElement input_customer; 
	
	@FindBy(id="input-date-added")
	private WebElement input_date_added; 
	
	@FindBy(id="input-date-modified")
	private WebElement input_date_modified; 
		
	public String create_xpath(){
		String firstorder = null;
		if(this.orderID.getText() != null){
			firstorder = "//*[@id='button-delete" + this.orderID.getText() + "']";
		}
		return firstorder;
	}
	
	public String edit_xpath(){
		String firstorder = null;
		if(this.orderID.getText() != null){
			firstorder = "http://uniform.upskills.in/admin/index.php?route=sale/order/edit'";
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
	
	public void edit_Order() {
		try {
			Thread.sleep(4000); 
			
			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.cart, 40);
			this.cart.click(); 
			waitElement.waitForElement(this.Orders_link, 40);
			this.Orders_link.click(); 
			waitElement.waitForElement(this.editpage, 40);
			this.editpage.click(); 
			ApplicationMethods obj = new ApplicationMethods(driver);
			
			waitElement.waitForElement(this.continue_button, 40);
			obj.scrollIntoView(this.continue_button);
			
			Thread.sleep(1000);
			
			if(this.continue_button.isEnabled()){
				
			//	this.continue_button.click(); 
				
				if(obj.checkSingleEntry("//*[@id='content']/div[2]/div[1]", "xpath")){
					waitElement.waitForElement(this.continue_button, 40);
					
					obj.scrollIntoView(this.continue_button);
					this.continue_button.click();
				}	
				
				else{
					if(this.continue_button.isDisplayed()){
					waitElement.waitForElement(this.continue_button, 40);
					
					obj.scrollIntoView(this.continue_button);
					this.continue_button.click(); 
					}
				}
				
			}
			Thread.sleep(1000);
			
			waitElement.waitForElement(this.remove_button, 40);
			obj.scrollIntoView(this.remove_button);
			if(this.remove_button.isDisplayed()){
				this.remove_button.click();
				//System.out.println("removed");
			}
			waitElement.waitForElement(this.inputproduct, 40);
			this.inputproduct.clear();
			this.inputproduct.sendKeys("Re");			
			waitElement.waitForElement(this.productadd, 40);
			obj.scrollIntoView(this.productadd);
			this.productadd.click();
			
			this.inputquantity.clear();
			this.inputquantity.sendKeys("1");
			waitElement.waitForElement(this.buttonproductadd, 40);
			obj.scrollIntoView(this.buttonproductadd);
			this.buttonproductadd.click();
			Thread.sleep(4000); 
			
			waitElement.waitForElement(this.button_cart, 40);
			obj.scrollIntoView(this.button_cart);
			this.button_cart.click();

			waitElement.waitForElement(this.button_address, 40);
			obj.scrollIntoView(this.button_address);
			this.button_address.click();
			
			waitElement.waitForElement(this.buttonshippingaddress, 40);
			obj.scrollIntoView(this.buttonshippingaddress);
			this.buttonshippingaddress.click();
			waitElement.waitForElement(this.inputshippingmethod, 40);
			obj.scrollIntoView(this.inputshippingmethod);
			Select ShippingMethod = new Select(this.inputshippingmethod);
			ShippingMethod.selectByValue("free.free");
			waitElement.waitForElement(this.button_save, 40);
			obj.scrollIntoView(this.button_save);
			this.button_save.click();
			
		} catch (InterruptedException e) {
			System.out.println("Scenario to edit Order is having exception error.");
			e.printStackTrace();
		}
	}
	
	
	public void search_Order() {
		
		try {
			Thread.sleep(4000);
			
			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.cart, 40);
			this.cart.click(); 
			waitElement.waitForElement(this.Orders_link, 40);
			this.Orders_link.click(); 
			
			waitElement.waitForElement(this.input_OrderId, 40);
			this.input_OrderId.sendKeys("345");
			
			waitElement.waitForElement(this.filterbutton, 40);
			this.filterbutton.click(); 
			this.input_OrderId.clear();
			System.out.println("Search functionality with a valid Order ID is completed");
			
			waitElement.waitForElement(this.orderStatus, 40);
			Select orderStatusDrpdwn = new Select(this.orderStatus);
			orderStatusDrpdwn.selectByVisibleText("Pending"); 
			waitElement.waitForElement(this.filterbutton, 40);
			
			this.filterbutton.click(); 

			System.out.println("Search functionality with a Order ID status is completed");

			orderStatusDrpdwn.selectByVisibleText(""); 
			waitElement.waitForElement(this.filterbutton, 40);
			
			this.filterbutton.click(); 
			
			
			waitElement.waitForElement(this.input_customer, 40);
			this.input_customer.sendKeys("Mohith");
			
			waitElement.waitForElement(this.filterbutton, 40);
			this.filterbutton.click(); 
			
			System.out.println("Search functionality with a customer field is completed"); 
			this.input_customer.clear();
			waitElement.waitForElement(this.input_date_added, 40);
			this.input_date_added.sendKeys("2019-07-05");
			
			waitElement.waitForElement(this.filterbutton, 40);
			this.filterbutton.click(); 
			
			System.out.println("Search functionality with a input_date_added field is completed"); 
			this.input_date_added.clear();
			waitElement.waitForElement(this.input_date_modified, 40);
			this.input_date_modified.sendKeys("2019-07-05");
			
			waitElement.waitForElement(this.filterbutton, 40);
			this.filterbutton.click(); 
			
			System.out.println("Search functionality with a input_date_modified field is completed"); 
			this.input_date_modified.clear();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
