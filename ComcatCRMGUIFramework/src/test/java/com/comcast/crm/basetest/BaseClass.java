package com.comcast.crm.basetest;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.LoginPage;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	
}
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	
	WebDriver driver=null;
	
	@BeforeSuite
	public void configBS() {
		System.out.println("===connect to DB, Report config===");
		dbLib.getDbconnection();
	

	@BeforeClass
	public void configBC() {
		System.out.println("===Launch the BROWSER===");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		
		 
			if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("==login==");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
        String PASSWORD = flib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("===logout===");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("===close the BROWSER===");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("===close DB, Report backUP===");
		dbLib.closeDbconnection();

	}
	
}
