package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v109.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationWithPhoneNumberTest {
	
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
	 String orgName = elib.getDataFromExcel("org", 4, 3) + jlib.getRandomNumber();
	 String phoneNumber   = elib.getDataFromExcel("org", 4, 3);

		
		
		WebDriver driver=null;
		
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}

		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}

		else if(browser.equals("edge"))
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
		driver.findElement(By.name("accountname")).sendKeys(orgname+new Random().nextInt(2000   ));
		driver.findElement(By.name("ship_street")).sendKeys("rajajinagar");
		driver.findElement(By.id("phone")).sendKeys(phoneNumber);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String phone = driver.findElement(By.id("dtlview_Phone")).getText();
		if(phone.equals(phoneNumber))
		{
			System.out.println(phoneNumber+" is verifid");
		}else {
			System.out.println(phoneNumber+" is not  verifid");
		}
		Thread.sleep(2000);		//driver.switchTo().alert().accept();
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}

}
