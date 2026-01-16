package com.cast.crm.objectrepositortutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage {
	WebDriver driver;
	public CreateContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className ="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameInfo;
	
	@FindBy(id = dtlview_Support Start Date")
	private WebElement 
	
	public WebElement getHeadermsg() {
		return headerMsg;
		}
	public WebElement getCreateOrgWithConBtn() {
		return CreateOrgWithConBtn;
	}
	
	public WebElement getLastNameInfo() {
		return lastNameInfo;
		
	
		
	}
	
	
	
	
	

}
