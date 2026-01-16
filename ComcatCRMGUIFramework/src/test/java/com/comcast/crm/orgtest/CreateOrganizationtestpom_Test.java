package com.comcast.crm.orgtest;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.objectrepositortutility.CreatingNewOrganizationPage;
import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.LoginPage;
import com.cast.crm.objectrepositortutility.OrganizationInfoPage;
import com.cast.crm.objectrepositortutility.OrganizationsPage;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationtestpom_Test {

	

	
		public static void main(String[] args) throws Throwable {
			/* Create Onject */
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			
			//read common data from json file
			
			String BROWSER = fLib.getDataFromPropertiesFile("browser");
			String URL= fLib.getDataFromPropertiesFile("url");
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
		driver.get(http:"//49.249.28.218:8888/");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(USERNAME, PASSWORD);         //upto this line pom 1stprgrm script
		
		/* lp.getusernameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click(); */
		
		//step 2 : naviagate to Organization module
	HomePage hp  = new HomePage(driver);
		hp.getOrgLink().click();
		
		//step 3 : click on  "create Organization" Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCraeteNewOrgBtn().click();
		
		//step 4 : enter all the details & create new Organnization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);
		
		//step 5 : verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeadermsg().getText();
		
		if(actOrgName.contains(orgname)) {
			System.out.println(orgname + "name is verified==PASS");
		}else {
			System.out.println(orgname + "name is not verified==FAIL");

			
		}
		
		
		//step 5 : logout
	hp.logout();
		driver.quit();
		
		
		
	}
}
}
