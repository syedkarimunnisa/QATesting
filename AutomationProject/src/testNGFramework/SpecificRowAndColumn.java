package testNGFramework;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpecificRowAndColumn {
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open()
	{
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.timeanddate.com/worldclock/");
	}
	@Test
	public void tables()
	{
		//List<WebElement> value=driver.findElements(By.tagName("tr"));
		String data1=driver.findElement(By.linkText("Chicago")).getText();
		System.out.println(data1);
		String data2=driver.findElement(By.linkText("Kuwait City")).getText();
		System.out.println(data2);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}


}
