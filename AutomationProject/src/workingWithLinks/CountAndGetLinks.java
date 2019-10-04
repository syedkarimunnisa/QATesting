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

public class CountAndGetLinks {
	ChromeDriver driver;
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
		WebElement header=driver.findElement(By.id("sc_hdu"));
		List<WebElement> hlinks=header.findElements(By.tagName("a"));
		System.out.println("No of Header links are:"+ hlinks.size());
		System.out.println("Names of Header links are:");
		for(int i=0;i<hlinks.size();i++)
		{
			System.out.print(hlinks.get(i).getText()+"   ");
		}
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
