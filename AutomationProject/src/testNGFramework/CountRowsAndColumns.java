package testNGFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountRowsAndColumns {
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
		List<WebElement> value=driver.findElements(By.tagName("tr"));
		System.out.println("no of rows="+ "  "+value.size());
		value=driver.findElements(By.tagName("td"));
		System.out.println("no of columns=" + " "+value.size() );
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}


}

