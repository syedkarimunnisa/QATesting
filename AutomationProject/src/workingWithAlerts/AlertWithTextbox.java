package workingWithAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertWithTextbox {

	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html/");
	}
	@Test
	public void alert()
	{
	 driver.findElement(By.linkText("Alert with Textbox ")).click();
	 driver.findElement(By.xpath("//*[@id='Textbox']/button")).click();
	 driver.switchTo().alert().sendKeys("Arshu");
	 driver.switchTo().alert().accept();
	String actual=driver.findElement(By.id("demo1")).getText();
	String expected="Arshu";
	if(actual.contains(expected))
	{
		System.out.println("Alert working successfull");
	}
	else
	{
		System.out.println("Alert not working properly");
	}
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
