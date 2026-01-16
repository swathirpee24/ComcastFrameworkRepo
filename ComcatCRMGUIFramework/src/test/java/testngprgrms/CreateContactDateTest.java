package testngprgrms;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.objectrepositortutility.CreateContactInfoPage;
import com.cast.crm.objectrepositortutility.CreateContactPage;
import com.cast.crm.objectrepositortutility.CreatingNewConPage;
import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.LoginPage;
import com.comcast.crm.generic.Fileutiliy.ExcelUtility;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactDateTest {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		 FileUtility f=new FileUtility();
	        //fetch data from properties file using Fileutility
			String URL = f.getDataFromPropertiesFile("url");
			String browser =f.getDataFromPropertiesFile("browser");
			String USERNAME= f.getDataFromPropertiesFile("username");
	 		String PASSWORD =f.getDataFromPropertiesFile("password");
	 		JavaUtility j=new JavaUtility();
			//fetch data from excel
			 ExcelUtility e=new ExcelUtility();
			 String ln = e.getDataFromExcel("Sheet1",4,2)+j.getRandomNumber();
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
		 
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToapp(URL,USERNAME, PASSWORD);
		//click on organization
		 HomePage hp=new HomePage(driver);
		hp.getConlink().click();
		//click on create  org button
		CreateContactPage ccp=new CreateContactPage(driver);
		 ccp.getCreateconbutton().click();
		 String startDate = j.getSystemDateYYYYDDMM();
		 String endDate = j.getRequiredDateYYYYDDMM(15);
		 //enter values and click on save
		 CreatingNewConPage cnp=new CreateNewConPage(driver);
		 cnp.createConWithDate(ln, startDate, endDate);
		 //verification
		 CreateContactInfoPage cip=new CreateContactInfoPage(driver);
		 String actstartdate =  cip.getStartDateverf().getText();
		if(actstartdate.equals(startDate))
		{
			System.out.println(startDate+" is verifid");
		}else {
			System.out.println(startDate+" is not  verifid");
		}
		String actenddate =  cip.getEndDateverf().getText();
		if(actenddate.equals(endDate))
		{
			System.out.println(endDate+" is verifid");
		}else {
			System.out.println(endDate+" is not  verifid");
		}
		Thread.sleep(2000);		//driver.switchTo().alert().accept();
		 hp.signoutApp();
		driver.quit();

	}

}



