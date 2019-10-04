package workingWithMultipleWindows;

//import java.awt.List;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc1CitiBank {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/");
		
	}
	@Test
	public void operation()
	{
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.linkText("Credit Cards")).click();
		driver.findElement(By.xpath("//*[@id='CreditSubMenu']/div/div[1]/div[1]/div/div[2]/div[2]/ul/li[1]/a")).click();
		String parent=driver.getWindowHandle();
		Set<String> pops=driver.getWindowHandles();
		Iterator<String> it=pops.iterator();
		while(it.hasNext())
		{
			String popuphandle=it.next().toString();
			if(!popuphandle.contains(parent))
			{
				driver.switchTo().window(popuphandle);
				Sleeper.sleepTightInSeconds(3);
				driver.findElement(By.xpath("//*[@id='tabs-wrapper']/div[2]/div[2]/a")).click();
				List<WebElement> links=driver.findElements(By.tagName("a"));
				System.out.println("no of links are:"+ links.size());
				//driver.close();
			}
		}
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
