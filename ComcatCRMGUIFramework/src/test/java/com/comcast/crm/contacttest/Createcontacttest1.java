package com.comcast.crm.contacttest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.cast.crm.objectrepositortutility.ContactPage;
import com.cast.crm.objectrepositortutility.CreatingNewConPage;
import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.LoginPage;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Createcontacttest1 extends BaseClass {

	@Test	 
		public void createcontacttest1() {
				
			//read test script data from excel file
			  String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

      //step2:navigate contact module
	HomePage hp = new HomePage(driver);
	hp.getContactlink().click();
	
	//step 3 : click on "create Contact" Button
	ContactPage cp = new ContactPage(driver);
	cp.getCreateNewOrgBtn().click();
	
	//step 4 : enter all the details & create new Contact
	CreateNewContactPage ccp = new CreateNewContactPage(driver);
	ccp.createcContact(lastName);
	
	 //verify Header phone Number info  Expected Result
	String actLastname =driver.findElement(By.id("dtlview_Last Name")).getText();
		        if(actLastname.equals(lastName)) {
		        	System.out.println(lastName  +  "information is verified ==PASS");
		        }
		        else {
		        	System.out.println(lastName   +  "information is not verified == FAIL");
		        }
		       @Test
		       public void  CreatecontactwithSupportDateTest1() {
		    	 //read test script data from excel file
		  		 String lastName=elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		  		 
		  			
		  			//step1: login to app
		  		 LoginPage lp = new LoginPage(driver);
		  		 lp.loginToapp(URL, USERNAME, PASSWORD);
		  			
		  			
		  				//step 2 : navigate contact module
		  		    HomePage hp = new HomePage(driver);
		  		    hp.getContactlink().click();
		  		    
		  		    //step3 : click on "create contact" Button
		  		    ContactPage cp = new ContactPage(driver);
		  		    cp.getCreateNewOrgBtn().click();
		  		    
		  			
		  			//step4: enter all the details & create new Organization 
		  			
		  			
		  			String startDate = jlib.getSystemDateYYYYDDMM();
		  			String endDate = jlib. getRequiredDateYYYYDDMM(30);
		  			
		  			CreatingNewConPage ccp = new CreatingNewConPage
		  					
		  					
		  					
		  					
		  					
		  					 (driver);
		  			ccp.creatingNewContactwithSupportDate(lastName, startDate, endDate);
		  			
		  			
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
		  	          @Test
		  	          public void CreateContactwithOrgTest1
)  throws Throwable {
		  	      		
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

		  	  				
		  	  				.creatingNewContactwithOrg(contactlastName, orgName);
		  	  			
		  	  			
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





}
}
