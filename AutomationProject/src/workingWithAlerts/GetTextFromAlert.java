package workingWithAlerts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetTextFromAlert {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.tsrtconline.in/oprs-web/guest/home.do?h=1/");
	}
	@Test
	public void alert()
	{
	 driver.findElement(By.id("searchBtn")).click();
	 String text=driver.switchTo().alert().getText();
	 System.out.println(text);
	 Sleeper.sleepTightInSeconds(5);
	 driver.switchTo().alert().accept();
	
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
