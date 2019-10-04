package testNGFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HRMLoginByProperties {
	ChromeDriver driver;
	FileInputStream fis;
	Properties pr;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}
	@Test
	public void usingproperty() throws IOException
	{
		Sleeper.sleepTightInSeconds(2);
		fis=new FileInputStream("D:\\karimun\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\AutomationProject\\OrangeHRM.properties");
		pr=new Properties();
		pr.load(fis);
		driver.findElement(By.id(pr.getProperty("user"))).clear();
		driver.findElement(By.id(pr.getProperty("user"))).sendKeys("admin");
		driver.findElement(By.id(pr.getProperty("pass"))).clear();
		driver.findElement(By.id(pr.getProperty("pass"))).sendKeys("admin123");
		driver.findElement(By.id(pr.getProperty("login"))).click();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
