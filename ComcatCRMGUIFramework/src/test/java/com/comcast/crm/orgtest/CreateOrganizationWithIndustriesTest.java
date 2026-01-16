package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationWithIndustriesTest {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Create Object
				FileUtility flib = new FileUtility();
				ExcelUtility elib = new ExcelUtility();
				WebDriverUtility wlib = new WebDriverUtility();
				JavaUtility jlib = new JavaUtility();
						
	//read common data from JSon file
				
		 String BROWSER=flib.getDataFromPropertiesFile("browser");
		  String URL=flib.getDataFromPropertiesFile("url");
		  String USERNAME=flib.getDataFromPropertiesFile("username");
		  String PASSWORD=flib.getDataFromPropertiesFile("password");
		  
		//generate the random number 
			Random random = new Random();
			int randomInt = random.nextInt(1000);
			
			//read test script data from excel file
			 String orgName = elib.getDataFromExcel("contact", 4, 3) + jlib.getRandomNumber();
			 String industry   = elib.getDataFromExcel("contact", 4, 3) + jlib.getRandomNumber();
			 String type = elib.getDataFromExcel("org", 4, 4)+randomInt);
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}

		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}

		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		//login
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on organization
		driver.findElement(By.linkText("Organizations")).click();
		//click on create  org button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+new Random().nextInt(2000   ));
		driver.findElement(By.name("ship_street")).sendKeys("rajajinagar");
		WebElement ele = driver.findElement(By.name("industry"));
		Select s=new Select(ele);
		s.selectByVisibleText(industry);
		WebElement ele1 = driver.findElement(By.name("accounttype"));
         Select s1=new Select(ele1);
         s1.selectByVisibleText(type);
         
         
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify header message expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgName))
		{
			System.out.println(orgName+"is created");
		}else {
			System.out.println(orgName+"is not created");
		}
			
		//verify organization name info
		String actname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actname.equals(orgName)) {
			System.out.println(orgName+"is created");
		}
		else {
		System.out.println(orgName+"is not  created");
		}
		
         //verify industry
         Thread.sleep(2000);
         String actindus = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
         if(actindus.equals(industry))
         {
        	 System.out.println(industry+" is created");
         }else {
        	 System.out.println(industry+" is not created");
         }
         String actitype = driver.findElement(By.id("dtlview_Type")).getText();
         if(actitype.contains(type))
         {
        	 System.out.println(industry+" is verified");
         }else {
        	 System.out.println(industry+" is not verified");
         }
		Thread.sleep(2000);		//driver.switchTo().alert().accept();
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();


	}

}

}
