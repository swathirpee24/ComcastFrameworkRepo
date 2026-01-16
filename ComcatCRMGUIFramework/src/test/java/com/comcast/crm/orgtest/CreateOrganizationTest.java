package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.cast.crm.objectrepositortutility.LoginPage;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationTest {
	public static void main(String[] args) throws Throwable {
		/* Create Onject */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		//read common data from json file
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL= fLib.getDataFromPropertiesFile("URL");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		
				
		
		//read testScript data from Excel file
		String orgname= eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		 
		
		
		WebDriver driver = null;
		
				
				if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver ();
}else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver ();
}else if(BROWSER.equals("edge")) {
	driver = new EdgeDriver();
}else {
	driver = new ChromeDriver();
	
	
	// Step 1 : login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	
	
}
				  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				
				driver.findElement(By.id("submitButton")).click();
				driver.quit();
				
				//Step 2 : navigate to Organization module
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 3 : click on organization button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				//Step 4 : enter all the details & create new Organization
				driver.findElement(By.name("accountname")).sendKeys("orgName");
				driver.findElement(By.id("phone")).sendKeys(phoneNumber);
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
			/*	//verify header msg expected result
				String headerInfo = driver.findElement(By.xpath("span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(orgName)) {
					System.out.println(orgName + "header verified==PASS");
				}else {
					System.out.println(orgName + "header is verified==FAIL"); 
				}
				
				//verify header orgName info expected result  
				String headerInfo = driver.findElement(By.id("dtliew_Organization Name")).getText();
				if(headerInfo.contains(orgName)) {
					System.out.println(orgName + "information ise created==PASS");
				}else {
					System.out.println(orgName + "information is not created==FAIL");
				} */
				
				//verify header phonenumber info expected result  
				String headerInfo = driver.findElement(By.id("dtliew_Organization phone")).getText();
				if(actphoneNumber.contains(phoneNumber)) {
					System.out.println(phoneNumber + "information ise created==PASS");
				}else {
					System.out.println(phoneNumber+ "information is not created==FAIL"); 
				
				
				
				
				//step 5 : logout
					
					
					
					 
				
	


}
		
		
		
		
		
	}


