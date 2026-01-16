package com.cast.crm.objectrepositortutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	public class contactsPage {
		WebDriver  driver;
		public void ContactsPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements (driver, this);
			
		}
		
		@FindBy(xpath ="\"//img[contains(@title,'Create Contact...')]")
		private WebElement createNewcontactBtn;
		
		@FindBy(name=""search_")
		private WebElement searchDD;
		
		public WebElement getCreateNewcontactBtn() {
			return createNewcontactBtn;
	
		}
		@FindBy(name =  ""  )
		private WebElement  searchtext;
		
		
		
	}

}
