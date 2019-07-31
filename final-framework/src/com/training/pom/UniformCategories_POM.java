package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.generics.ApplicationMethods;
import com.trianing.waits.WaitTypes;

public class UniformCategories_POM {
	private WebDriver driver; 
	
	public UniformCategories_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[@id='catalog']/a/i") 
	private WebElement catalog; 
	
	@FindBy(xpath="//*[@id='catalog']/ul/li[1]/a") 
	private WebElement categories_link; 
	
	@FindBy(xpath="//*[@id='content']/div[1]/div/div/a[1]") 
	private WebElement add_link; 
	
	@FindBy(id="input-name1")
	private WebElement categoryname;
	
	@FindBy(xpath="//*[@id='language1']/div[2]/div/div/div[3]/div[2]") 
	private WebElement categorydescription; 

	@FindBy(id="input-meta-title1")
	private WebElement meta_tag;
	
	@FindBy(id="input-meta-description1")
	private WebElement meta_tag_description;

	@FindBy(xpath="//*[@id='content']/div[1]/div/div/button/i") 
	private WebElement add_button; 
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]") 
	private WebElement message; 
	
	@FindBy(xpath="//*[@id='catalog']/ul/li[2]/a") 
	private WebElement products_link; 
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[2]/a") 
	private WebElement products_datatab_link; 
	
	@FindBy(id="input-model")
	private WebElement input_model;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[3]/a") 
	private WebElement products_linktab_link; 
	
	@FindBy(xpath="//*[@id='input-category']") 
	private WebElement products_selectcategory_link; 
	
	@FindBy(xpath="//*[@id='tab-links']/div[2]/div/ul/li[2]") 
	private WebElement products_selectcategoryname_link; 
	
	public void create_categories(){
		try {
			Thread.sleep(4000);
			
			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.catalog, 40);
			this.catalog.click(); 
			waitElement.waitForElement(this.categories_link, 40);
			this.categories_link.click(); 
			waitElement.waitForElement(this.add_link, 40);
			this.add_link.click();
			
			waitElement.waitForElement(this.categoryname, 40);
			this.categoryname.sendKeys("Sports Uniform");

			waitElement.waitForElement(this.categorydescription, 40);
			this.categorydescription.sendKeys("Uniform for Sports");
			
			waitElement.waitForElement(this.meta_tag, 40);
			this.meta_tag.sendKeys("Sports Uniform");

			waitElement.waitForElement(this.meta_tag_description, 40);
			this.meta_tag_description.sendKeys("Uniform for Sports");

			waitElement.waitForElement(this.add_button, 40);
			this.add_button.click();

			Thread.sleep(4000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
		
	public void create_products(){
		try {
			Thread.sleep(4000);
			ApplicationMethods obj = new ApplicationMethods(driver);

			WaitTypes waitElement = new WaitTypes(driver);
			waitElement.waitForElement(this.catalog, 40);
			this.catalog.click(); 
			waitElement.waitForElement(this.products_link, 40);
			this.products_link.click(); 
			waitElement.waitForElement(this.add_link, 40);
			this.add_link.click();
			
			waitElement.waitForElement(this.categoryname, 40);
			this.categoryname.sendKeys("Sports Wear");

			waitElement.waitForElement(this.categorydescription, 40);
			this.categorydescription.sendKeys("Sports wear description");
			
			waitElement.waitForElement(this.meta_tag, 40);
			this.meta_tag.sendKeys("Sports wear (8-10)");

			waitElement.waitForElement(this.products_datatab_link, 40);
			this.products_datatab_link.click();
			
			waitElement.waitForElement(this.input_model, 40);
			this.input_model.sendKeys("SPU-03");
			
			waitElement.waitForElement(this.products_linktab_link, 40);
			this.products_linktab_link.click();
			
			waitElement.waitForElement(this.products_selectcategory_link, 40);
			this.products_selectcategory_link.click();
			
			
			waitElement.waitForElement(this.products_selectcategoryname_link, 40);
			this.products_selectcategoryname_link.click();
			waitElement.waitForElement(this.add_button, 40);
			this.add_button.click();

			if(obj.checkSingleEntry("//*[@id='content']/div[2]/div[1]", "xpath")){
				WebElement element  = null;
				element=obj.getElement("//*[@id='content']/div[2]/div[1]","xpath");
				
				System.out.println(""+element.getText().substring(0, 37)+"");
			}else{
				System.out.println("Category is not created");
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
