package workingWithTestNGListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(workingWithTestNGListeners.TestNGListener.class)
public class HRMLoginByUsingListener {
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;

	@BeforeTest
	public void open()
	{
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		driver=new FirefoxDriver(fp);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void login()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
