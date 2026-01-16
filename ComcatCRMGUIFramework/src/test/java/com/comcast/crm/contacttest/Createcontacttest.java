package com.comcast.crm.contacttest;

import java.time.Duration;
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

public class Createcontacttest {
	 
	//public class Create_contact_Test {
		public static void main(String[] args)  {
			
			//Create Object
			FileUtility flib = new FileUtility();
			ExcelUtility elib = new ExcelUtility();
			WebDriverUtility wlib = new WebDriverUtility();
			JavaUtility jlib = new JavaUtility();
					
			 String URL=flib.getDataFromPropertiesFile("url");
		  String BROWSER=flib.getDataFromPropertiesFile("browser");
		  String USERNAME=flib.getDataFromPropertiesFile("username");
		  String PASSWORD=flib.getDataFromPropertiesFile("password");
					JavaUtility j = new JavaUtility();
					
					
		 // public int getRandomNumber() {
				//Random random = new Random();
				//int randomInt = random.nextInt(1000);
				//read test script data from excel file
					
					//fetch data from excel
					ExcelUtility e = new ExcelUtility();
		  String lastName=elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		  //Launch browser
					 WebDriver driver=null;
			
			if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}
			//step1: login 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			Login_Test lt 
			driver.manage().window().maximize();
			wlib.waitForPageToLoad(driver);	
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step2:navigate organization module
		    driver.findElement(By.linkText("Contacts")).click();
		    
		    //step3:click on "create organization" Button
			driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
			//step4: enter all the details & create new Organization 
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			String actLastname =driver.findElement(By.id("dtlview_Last Name")).getText();
	        if(actLastname.equals(lastName)) {
	        	System.out.println(lastName  +  "information is verified ==PASS");
	        }
	        else {
	        	System.out.println(lastName   +  "information is not verified == FAIL");
	        }
	       	         driver.quit();


	}
	}
}