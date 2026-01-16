package com.comcast.crm.contacttest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.objectrepositortutility.CreateContactPage;
import com.cast.crm.objectrepositortutility.CreatingNewConPage;
import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.LoginPage;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatecontactwithSupportDateTest1 {
	
public static void main(String[] args) throws Throwable {
		
		
		//read test script data from excel file
		 String lastName=elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		 
			
			//step1: login to app
		 LoginPage lp = new LoginPage(driver);
		 lp.loginToapp(URL, USERNAME, PASSWORD);
			
			
				//step 2 : navigate contact module
		    HomePage hp = new HomePage(driver);
		    hp.getContactlink().click();
		    
		    //step3 : click on "create contact" Button
		    CreateContactPage cp = new CreateContactPage(driver);
		    cp.getCreateNewOrgBtn().click();
		    
			
			//step4: enter all the details & create new Organization 
			
		    CreatingNewConPage ccp = new CreatingNewConPage(driver);
			ccp.creatingNewContactwithSupportDate(lastName, startDate, endDate);
			
			String startDate = j.getSystemDateYYYYDDMM();
			String endDate = j.getRequiredDateYYYYDDMM(30);
			
			
			
		  //verify   Header phone Number info Expected Result
	        String actEndDate =driver.findElement(By.id("dtlview_Support Start Date")).getText();
	        if(actEndDate.equals(startDate)) {
	        	System.out.println(startDate  +  "information is verified ==PASS");
	        }
	        else {
	        	System.out.println(startDate   +  "information is not verified == FAIL");
	        }
	        
	        String actEndDate =driver.findElement(By.id("dtlview_Support End Date")).getText();
	        if(actEndDate.equals(endDate)) {
	        	System.out.println(endDate  +  "information is verified ==PASS");
	        }
	        else {
	        	System.out.println(endDate   +  "information is not verified == FAIL");
	        }
	          //step 5 : logout
	        driver.quit();


	}
	

}



