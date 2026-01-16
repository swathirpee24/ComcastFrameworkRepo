package com.comcast.crm.contacttest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithorgTest {
		public static void main(String[] args) throws Throwable {
		
			//Create Object
			FileUtility flib = new FileUtility();
			ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			
			//read common data from json file
													
		  String BROWSER=flib.getDataFromPropertiesFile("browser");
		  String URL=flib.getDataFromPropertiesFile("url");
		  String USERNAME=flib.getDataFromPropertiesFile("username");
		  String PASSWORD=flib.getDataFromPropertiesFile("password");
							
		
		//read test script data from excel file
		 String contactlastName=elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
		 String orgName =elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		
			 
			//lauching the browser
			 WebDriver driver=null;
			
			if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}
			//step1: login 
			wLib.waitForPageToLoad(driver);	
			driver.get(URL);
			driver.manage().window().maximize();
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step2:navigate organization module
		    driver.findElement(By.linkText("Organizations")).click();
		    
		    //step3:click on "create organization" Button
			driver.findElement(By.xpath("//img[contains(@title,'Create Organization...')]")).click();
			
			//step4: enter all the details & create new Organization 
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.name("ship_street")).sendKeys("malleshwaram5");
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			//verify Header msg
			String headerinfo =driver.findElement(By.xpath("//span[@class= 'dvHeaderText']")).getText();
	        if(headerinfo.contains(orgName)) {
	        	System.out.println(orgName + "is created ==PASS");
	        }
	        else {
	        	System.out.println(orgName + "is not created == FAIL");
	}
	        
	        //step 5: navigate to contact module
	       driver.findElement(By.linkText("Contacts")).click();
		    
		    //step6:click on "create organization" Button
			driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
			//step7: enter all the details & create new Organization 
			driver.findElement(By.name("lastname")).sendKeys(contactlastName);
		   driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			//driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]"));
			
		/*	//switch to child window
		   Set<String> set = driver.getWindowHandles();
		   Iterator<String> it = set.iterator();
		   
		   while(it.hasNext()) {
			   String windowID = it.next();
			   driver.switchTo().window(windowID);
			   
			   String actUrl = driver.getCurrentUrl();
			   if(actUrl.contains("module=Accounts")) {
				   break;
			   }
			   
			   
			   } */
		   
		wLib.switchToTabOnURL(driver, "module=Accounts");
		  
			//to search the orgname in search textfield
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text() ='"+ orgName + "']")).click();//used dynamic xpath
	/*		
		//switch to Parent window	
			 Set<String> set1 = driver.getWindowHandles();
			   Iterator<String> it1 = set1.iterator();
			   
			   while(it1.hasNext()) {
				   String windowID = it1.next();
				   driver.switchTo().window(windowID);
				   
				   String actUrl = driver.getCurrentUrl();
				   if(actUrl.contains("Contacts&action")) {
					   break;
				   } */
			wLib.switchToTabOnURL(driver, "Contacts&action");
			
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
	       //verify Header msg Expected Result
				headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		        if(headerinfo.contains(contactlastName)) {
		        	System.out.println(contactlastName + "is created ==PASS");
		        }
		        else {
		        	System.out.println(contactlastName + "is not created == FAIL");
		        }
		   // verify the Header Orgname info Expected result	
		 String  actorgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	     if(actorgName.trim().equals(orgName)) {
	  	   System.out.println(orgName + "is created ==PASS");
	      }
	      else {
	      	System.out.println(orgName + "is not created == FAIL");
	      }
	        driver.quit();
		}
	}

}
