package organization_Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

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

public class CreateOrganizationTest {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		 //step 1: get the java representaion object of physical file
		FileInputStream fis  = new FileInputStream("‪C:\\Users\\HP\\Desktop\\commondata.Propertiess");
		//step 2: using properties class load all the keys
		Properties pobj=new Properties();
		pobj.load(fis);
		//step 3: get the value based on key
		String URL = pobj.getProperty("url");
		String browser = pobj.getProperty("browser");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		//Scanner s=new Scanner(System.in);
		//System.out.println("enter browser");
		//String browser = s.next();
		FileInputStream fis1= new FileInputStream("./src/test/resources/organization.xlsx");
		//step 2:open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis1);
		//step 3:get control of sheet
		Sheet sh = wb.getSheet("Sheet1");
		//step 4: get control of 1st row
		Row row = sh.getRow(1);
		String orgname = row.getCell(2).toString();
		wb.close();
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

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify header message expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname))
		{
			System.out.println(orgname+"is created");
		}else {
			System.out.println(orgname+"is not created");
		}
			
		//verify organization name info
		String actname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actname.equals(orgname)) {
			System.out.println(orgname+"is created");
		}
		else {
		System.out.println(orgname+"is not  created");
		}
		Thread.sleep(2000);		//driver.switchTo().alert().accept();
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();


	}

}


}
