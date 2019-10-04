package advancedUserInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RightClickOperation {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	@Test
	public void operation()
	{
		WebElement gmail=driver.findElement(By.linkText("Gmail"));
		Actions action=new Actions(driver);
		action.contextClick(gmail).build().perform();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}





}
