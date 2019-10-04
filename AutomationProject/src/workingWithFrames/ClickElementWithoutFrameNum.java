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

public class ClickElementWithoutFrameNum {
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
		//driver.switchTo().frame(1);
		//driver.findElement(By.xpath("/html/body/p[5]/b/a/font"));
		List<WebElement> nframes=driver.findElements(By.tagName("frame"));
		for(int i=0;i<nframes.size();i++)
		{
			driver.switchTo().frame(i);
			try{
			driver.findElement(By.xpath("/html/body/p[5]/b/a/font")).click();
			break;
			}
			catch(Exception x)
			{
				driver.switchTo().defaultContent();
			}
		}
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
