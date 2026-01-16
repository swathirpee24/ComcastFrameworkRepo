package com.cast.crm.objectrepositortutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver;
	public OrganizationsPage(WebDriver driver ) {
		this.driver = driver;
    	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	
//	public WebDriver getDriver() {
	//	return driver;
	//}

	
	

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	@FindBy(xpath = "img[@alt='Create Organization...']")
	private WebElement craeteNewOrgBtn;

	public WebElement getCraeteNewOrgBtn() {
		return craeteNewOrgBtn;
	}
	
	
	

}
