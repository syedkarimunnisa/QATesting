package workingWithLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountVisibleAndHiddenLinks {
	ChromeDriver driver;
	//@BeforeTest                                                                                          t
	@BeforeTest
	public void open()
	{
		//pi=new ProfilesIni();
		//fp=pi.getProfile("onlineQA");
		driver=new ChromeDriver();
		driver.get("https://www.bing.com/");
	}
	@Test
	public void links()
	{
		List<WebElement> nlinks=driver.findElements(By.tagName("a"));
		System.out.println("Total links:" + nlinks.size());
		int count=0;
		for(int i=0;i<nlinks.size();i++)
		{
			if(nlinks.get(i).isDisplayed())
			{
				count++;
			}
		}
		System.out.println("Visible links: "+ count);
		System.out.println("Hidden links: "+ (nlinks.size()-count));
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
