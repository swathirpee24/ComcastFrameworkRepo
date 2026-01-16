package com.cast.crm.objectrepositortutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewConPage {
	
	WebDriver driver;
	public CreatingNewConPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(name="lastname")
private WebElement lastNameEdt;

public WebElement getLastNameEdt() {
	return lastNameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

@FindBy(name="industry")
private WebElement industryDD;

@FindBy(xpath ="//
	
	
	

	
	
	
	}
	

}
