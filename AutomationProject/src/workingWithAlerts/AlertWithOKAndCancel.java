package workingWithAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertWithOKAndCancel {

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
	 driver.findElement(By.linkText("Alert with OK & Cancel")).click();
	 driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
	 String data=driver.switchTo().alert().getText();
	 driver.switchTo().alert().dismiss();
	String actual=driver.findElement(By.id("demo")).getText();
	String expected="cancel";
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
