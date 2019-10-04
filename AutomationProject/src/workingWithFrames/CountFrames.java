package workingWithFrames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountFrames {
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open()
	{
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		driver=new FirefoxDriver(fp);
		driver.get("http://www.angelfire.com/super/badwebs/");
	}
	@Test
	public void frames()
	{
		List<WebElement> nframes=driver.findElements(By.tagName("frame"));
		System.out.println("No of frames="+nframes.size());
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}




}
