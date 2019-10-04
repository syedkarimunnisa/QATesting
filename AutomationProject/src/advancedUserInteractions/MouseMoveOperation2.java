package advancedUserInteractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseMoveOperation2 {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	@Test
	public void operation()
	{
		WebElement men=driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/span"));
		Actions action=new Actions(driver);
		Sleeper.sleepTightInSeconds(8);
		action.moveToElement(men).build().perform();
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.linkText("Formal Shoes")).click();
		Sleeper.sleepTightInSeconds(5);
		WebElement price=driver.findElement(By.cssSelector("div#container div._1zXsFA > div > div:nth-child(5)"));
		int loc=price.getLocation().y;
		//int xloc=price.getLocation().x; 
		//action.dragAndDropBy(price, 50, loc).build().perform();
	   //Sleeper.sleepTightInSeconds(5);

	   //price range slider
	  WebElement minslider=price.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div/div[1]/div/div/div/section[2]/div[3]/div[1]/div[1]/div[1]"));
	   //WebElement maxslider=driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div/div[1]/div/div/div/section[2]/div[3]/div[1]/div[2]"));

	   //int yloc=minslider.getLocation().y;
	   //int xloc=minslider.getLocation().x;
	   action.dragAndDropBy(minslider,50,50).release().perform();
	   Sleeper.sleepTightInSeconds(5);
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
