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

public class CountClickGetUrlNavigate {
	ChromeDriver driver;


	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.bing.com/");
	}
	@Test
	public void links()
	{
		List<WebElement> nlinks=driver.findElements(By.tagName("a"));
		System.out.println("total links:" + nlinks.size());
		for(int i=0;i<nlinks.size();i++)
		{
			if(nlinks.get(i).isDisplayed())
			{
				System.out.println("Names="+ nlinks.get(i).getText());
				nlinks.get(i).click();
				System.out.println("Url="+ driver.getCurrentUrl());
				driver.navigate().back();
				nlinks=driver.findElements(By.tagName("a"));
			}
		}	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
	
	
	
	
}