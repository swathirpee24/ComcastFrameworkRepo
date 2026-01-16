package testngprgrms;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cast.crm.objectrepositortutility.CreateContactInfoPage;
import com.cast.crm.objectrepositortutility.CreateContactPage;
import com.cast.crm.objectrepositortutility.CreatingNewConPage;
import com.cast.crm.objectrepositortutility.HomePage;
import com.cast.crm.objectrepositortutility.LoginPage;
import com.comcast.crm.generic.Fileutiliy.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactTest {
	
	


	

		public static void main(String[] args) throws InterruptedException, IOException {
			          FileUtility f=new FileUtility();
			        //fetch data from properties file using Fileutility
					String URL = f.getDataFromPropertiesFile("url");
					String browser =f.getDataFromPropertiesFile("browser");
					String USERNAME= f.getDataFromPropertiesFile("username");
			 		String PASSWORD =f.getDataFromPropertiesFile("password");
			 		JavaUtility j=new JavaUtility();
					//fetch data from excel
					 com.comcast.crm.generic.Fileutiliy.ExcelUtility e=new com.comcast.crm.generic.Fileutiliy.ExcelUtility();
					 String ln = e.getDataFromExcel("Sheet1",1,2)+j.getRandomNumber();
					 //launch browser
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
					 LoginPage lt=new LoginPage(driver);
					 lt.loginToapp(URL,USERNAME, PASSWORD);
					//click on organization
					 HomePage ht=new HomePage(driver);
					ht.getConlink().click();
					//click on create  org button
					CreateContactPage ccp=new CreateContactPage(driver);
					ccp.getCreateconbutton().click();
					CreatingNewConPage cnp=new CreatingNewConPage(driver);
					 cnp.getLastNameEdt().sendKeys(ln);
					 cnp.getSaveBtn().click();
					 //verification
					 CreateContactInfoPage cip=new CreateContactInfoPage(driver);
					String actln =  cip.getHeadnamevef().getText();
					if(actln.contains(ln))
					{
						System.out.println(ln+" is verifid");
					}else {
						System.out.println(ln+" is not  verifid");
					}
					String act = cip.getLastnamevef().getText();
					if(act.equals(ln))
					{
						System.out.println(ln+" is verifid");
					}else {
						System.out.println(ln+" is not  verifid");
					}
					Thread.sleep(2000);		//driver.switchTo().alert().accept();
					 ht.signoutApp();
					driver.quit();


		}

	}

	

}
