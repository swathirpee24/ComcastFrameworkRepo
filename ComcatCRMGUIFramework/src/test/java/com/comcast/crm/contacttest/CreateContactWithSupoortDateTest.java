package com.comcast.crm.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupoortDateTest {
	
	
		public static void main(String[] args) throws Throwable {
		
		//Create Object
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		
		// common data from properties file						
		  String BROWSER=flib.getDataFromPropertiesFile("browser");
		  String URL=flib.getDataFromPropertiesFile("url");
		  String USERNAME=flib.getDataFromPropertiesFile("username");
		  String PASSWORD=flib.getDataFromPropertiesFile("password");
		  
							
		//generate the random number 
			Random random = new Random();
			int randomInt = random.nextInt(1000);
			
			
		//read test script data from excel file
		 String lastName=elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		 
			 WebDriver driver=null;
			
			if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}
			//step1: login 
			driver.get(URL);
			driver.manage().window().maximize();
			wlib.waitForPageLoad(driver);	
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step2:navigate organization module
		    driver.findElement(By.linkText("Contacts")).click();
		    
		    //step3:click on "create organization" Button
			driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
			
			//step4: enter all the details & create new Organization 
			
			
			String startDate = jlib.getSystemDateYYYYDDMM();
			String endDate = jlib. getRequiredDateYYYYDDMM(30);
			
		
			
				driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.name("support_start_date")).clear();
			driver.findElement(By.name("support_start_date")).sendKeys(startDate);

			driver.findElement(By.name("support_end_date")).clear();
			driver.findElement(By.name("support_end_date")).sendKeys(endDate);  
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			String actStartDate =driver.findElement(By.id("dtlview_Support Start Date")).getText();
	        if(actStartDate.equals(startDate)) {
	        	System.out.println(startDate  +  "information is verified ==PASS");
	        }
	        else {
	        	System.out.println(startDate   +  "information is not verified == FAIL");
	        }
	        //verify   
	        String actEndDate =driver.findElement(By.id("dtlview_Support End Date")).getText();
	        if(actEndDate.equals(endDate)) {
	        	System.out.println(endDate  +  "information is verified ==PASS");
	        }
	        else {
	        	System.out.println(endDate   +  "information is not verified == FAIL");
	        }
	          driver.quit();


	}
	}

}
