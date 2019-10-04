package advancedUserInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragOperationOnSlider {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
	}
	@Test
	public void operation()
	{
		driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.id("slider"));
		Actions action=new Actions(driver);
		Sleeper.sleepTightInSeconds(3);
		int loc=slider.getLocation().x;
		WebElement drag=driver.findElement(By.id("slider"));
		action.dragAndDrop(slider, drag);
		
		//action(slider,drag,drag).build().perform();
		Sleeper.sleepTightInSeconds(5);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
