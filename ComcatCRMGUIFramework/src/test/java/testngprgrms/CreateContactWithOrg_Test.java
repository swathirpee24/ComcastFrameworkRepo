package testngprgrms;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.objectrepositortutility.CreateContactInfoPage;
import com.cast.crm.objectrepositortutility.CreateContactPage;
import com.cast.crm.objectrepositortutility.CreatingNewOrganizationPage;
import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.LoginPage;
import com.cast.crm.objectrepositortutility.OrganizationInfoPage;
import com.cast.crm.objectrepositortutility.OrganizationsPage;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrg_Test {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility f=new FileUtility();
        //fetch data from properties file using Fileutility
		String URL = f.getDataFromPropertiesFile("url");
		String browser =f.getDataFromPropertiesFile("browser");
		String USERNAME= f.getDataFromPropertiesFile("username");
 		String PASSWORD =f.getDataFromPropertiesFile("password");
 		JavaUtility j=new JavaUtility();
 		WebDriverUtility w=new WebDriverUtility();
		//fetch data from excel
		 ExcelUtility e=new ExcelUtility();
		 String orgname = e.getDataFromExcel("Sheet1",7,2)+j.getRandomNumber();
		 String cnName = e.getDataFromExcel("Sheet1",7,3)+j.getRandomNumber();
		 WebDriver driver = null;
		 if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		// login
		 w.waitForPageToLoad(driver);
		driver.get(URL);
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToapp(URL,USERNAME, PASSWORD);
		// click on organization
		 HomePage hp=new HomePage(driver);
		 hp.getOrglink().click();
		// click on create org button
		 OrganizationsPage cpt=new OrganizationsPage(driver);
		 cpt.getCraeteNewOrgBtn().click();
		 CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
	      cop.createOrg(orgname, cnName);
		 // verify organization name info
		 OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String actname =  oif.getOgnameverf().getText();
		if (actname.equals(orgname)) {
			System.out.println(orgname + "is created");
		} else {
			System.out.println(orgname + "is not  created");
		}
		 hp.getConlink().click();
		// click on create contact button
		 CreateContactPage ccp=new CreateContactPage(driver);
		 ccp.getCreateconbutton().click();
		 //enter all details
		 CreateNewConPage cnp=new CreateNewConPage(driver);
		 cnp.getConLastnameEdt().sendKeys(cnName);
		String parent=driver.getWindowHandle();
		 cnp.getSubOrgButton().click();
		// switch to child window
		 w.switchToNewBrowserchildtaburl(driver,"module=Accounts");
		 cnp.searchOrg(orgname);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().window(parent);
		cnp.getSaveBtn().click();
		CreateContactInfoPage cip=new CreateContactInfoPage(driver);
		String actln = cip.getHeadnamevef() .getText();
		if (actln.contains(cnName)) {
			System.out.println(cnName + " is verifid");
		} else {
			System.out.println(cnName + " is not  verifid");
		}
		String act =  cip.getLastnamevef().getText();
		if (act.equals(cnName)) {
			System.out.println(cnName + " is verifid");
		} else {
			System.out.println(cnName + " is not  verifid");
		}
		Thread.sleep(2000); // driver.switchTo().alert().accept();
		 hp.signoutApp();
		driver.quit();

	}

}


}
