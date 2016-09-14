package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DDFdemo {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
	}
	
	@Test
	public void testFb() throws IOException{
		String[][] data = ReadExcel.getData("TestData", "Data");
		
		for (int i = 1; i<data.length; i++) {
			//Adding a comment to see in the central repo
		
			String user = data[i][0];
			String pass = data[i][1];
		
			driver.findElement(By.id("email")).sendKeys(user);
			driver.findElement(By.id("pass")).sendKeys(pass);
			driver.findElement(By.id("loginbutton")).click();
			
			driver.navigate().back();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
