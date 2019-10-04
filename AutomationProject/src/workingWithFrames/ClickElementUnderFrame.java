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

public class ClickElementUnderFrame {
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
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("/html/body/p[5]/b/a/font"));
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
