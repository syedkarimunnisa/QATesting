package advancedUserInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickOperation {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://icicibank.com");
	}
	@Test
	public void operation()
	{
		WebElement openfd=driver.findElement(By.cssSelector("div#main li:nth-child(1) > a > div > div.thumb-details > div"));
		Actions action=new Actions(driver);
		action.doubleClick(openfd).build().perform();
		Sleeper.sleepTightInSeconds(4);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
