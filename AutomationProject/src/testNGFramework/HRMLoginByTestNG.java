package testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HRMLoginByTestNG {
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
	@Test(priority=0)
	public void login()
	{
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).clear();
		//driver.findElement(By.id(("txtPassword")).sendKeys("Admin123");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	@Test(priority=1)
	public void loginstatus()
	{
		String expected="Welcome Admin";
		String actual=driver.findElement(By.linkText("Welcome Admin")).getText();
		Assert.assertEquals(actual,expected);
	}
	@Test(priority=2)
	public void logout()
	{
		//driver.findElement(By.linkText("Welcome Admin")).click();
		driver.findElement(By.linkText("Welcome Admin")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
		
	}
	
	
}
