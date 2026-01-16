package com.cast.crm.objectrepositortutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver ) {
		this.driver = driver;
    	PageFactory.initElements(driver, this);	
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="ship_street")
	private WebElement TextBoxEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDB;
	

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getTextBxEdt() {
		return TextBoxEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public void createOrg1(String orgname , String text ) {
		orgNameEdt.sendKeys(orgname);
		TextBoxEdt.sendKeys(text);
		saveBtn.click();
	}
		
	public void createOrg(String orgname , String industry) {
		orgNameEdt.sendKeys(orgname);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	
		
	}
	
	

}
