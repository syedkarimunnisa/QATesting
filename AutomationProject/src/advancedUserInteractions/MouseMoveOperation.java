package advancedUserInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseMoveOperation {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
	}
	@Test
	public void operation()
	{
		WebElement aboutus=driver.findElement(By.cssSelector("div#bs-example-navbar-collapse-1 li:nth-child(10) > a"));
		Actions action=new Actions(driver);
		Sleeper.sleepTightInSeconds(3);
		action.moveToElement(aboutus).build().perform();
		Sleeper.sleepTightInSeconds(3);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}




}
