package com.cast.crm.objectrepositortutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(linkText="Opportunities")
	private WebElement opporunitilink;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOprtink() {
		return opporunitilink;
	}
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	@FindBy(linkText="Contacts")
	private WebElement conlink;
	@FindBy(linkText="Leads")
	private WebElement leadlink;
	@FindBy(linkText="Products")
	private WebElement productlink;
	@FindBy(linkText="compaign")
	private WebElement compaginlink;
	@FindBy(linkText="More")
	private WebElement Morelink;
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutImg;
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	public WebElement getSignOutImg() {
		return signOutImg;
	}
	public WebElement getSignOut() {
		return signOut;
	}
	public WebElement getCompaginlink() {
		return compaginlink;
	}
	public WebElement getMorelink() {
		return Morelink;
	}
	public WebElement getOrglink() {
		return orglink;
	}
	public WebElement getConlink() {
		return conlink;
	}
	public WebElement getLeadlink() {
		return leadlink;
	}
	public WebElement getProductlink() {
		return productlink;
	}
	public void naviagateTocampaginpag() {
		Actions a=new Actions(driver);
		a.moveToElement(Morelink).perform();
		compaginlink.click();
	}
	public void signoutApp() {
		Actions a1=new Actions(driver);
		a1.moveToElement(signOutImg).perform();
		signOut.click();
	}

}
