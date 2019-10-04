package workingWithBootstrap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SiginOperation {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
	}
	@Test
	public void operation()
	{
	 driver.findElement(By.linkText("Sign In")).click();
	 Sleeper.sleepTightInSeconds(3);
	 driver.switchTo().frame(0);
	 driver.findElement(By.linkText("Log In")).click();
	 Sleeper.sleepTightInSeconds(3);
	 driver.findElement(By.id("authUsername")).sendKeys("syed.karimunnisa@gmail.com");
	 driver.findElement(By.id("authPassword")).sendKeys("panda@2525");
	 driver.findElement(By.id("authExistingUserSignInBtn")).click();	 
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
