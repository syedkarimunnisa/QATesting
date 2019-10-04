package advancedUserInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropOperation {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
	}
	@Test
	public void operation()
	{
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions action=new Actions(driver);
		Sleeper.sleepTightInSeconds(3);
		action.dragAndDrop(drag, drop).build().perform();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
