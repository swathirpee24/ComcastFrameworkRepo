package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.OrganizationsPage;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactwithOrgTest1 {
	
	public static void main(String[] args) throws Throwable {
		
			//read test script data from excel file
	 String contactlastName=elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
	 String orgName =elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
	
		
		//step2:navigate organization module
	   // driver.findElement(By.linkText("Organizations")).click();
	 HomePage hp = new HomePage(driver);
	 hp.getOrgLink().click();
	    
	    //step3:click on "create organization" Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCraeteNewOrgBtn().click();
	 
	 //step4: enter all the details & create new Organization 
	 CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	 cnp.createOrg(orgName);
	 
	// verify the Header Orgname info Expected result	
		 String  actorgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	     if(actorgName.trim().equals(orgName)) {
	  	   System.out.println(orgName + "is created ==PASS");
	      }
	      else {
	      	System.out.println(orgName + "is not created == FAIL");
	      }
	      
	     
	   //step 2 : navigate contact module
		    HomePage hp = new HomePage(driver);
		    hp.getContactlink().click();
		    
		    //step3 : click on "create contact" Button
		    ContactPage cp = new ContactPage(driver);
		    cp.getCreateNewOrgBtn().click();
		    
			
			//step4: enter all the details & create new Organization 
			
			
				CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
			ccp.creatingNewContactwithOrg(contactlastName, orgName);
			
			
		  //verify   Header phone Number info Expected Result
	        

	   // verify the Header Orgname info Expected result	
	 String  actorgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	 
     if(actorgName.trim().equals(orgName)) {
  	   System.out.println(orgName + "is created ==PASS");
      }
      else {
      	System.out.println(orgName + "is not created == FAIL");
      }
       
	}


}



