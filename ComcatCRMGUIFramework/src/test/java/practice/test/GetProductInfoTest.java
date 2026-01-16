package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class GetProductInfoTest {
	@Test(dataProvider="getdata")
	public void getProductInfoTest(String brand name , String Product name);
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Driver.get("https://www.amazon.in/");
	
	
	//SearchProduct
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone",Keys.ENTER);
	
	//Capture Product Info
	
	
	
	
	

}
}





