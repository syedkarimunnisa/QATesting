package workingWithDatePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WithoutCalender {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		
	}
	@Test
	public void calen() throws Exception
	{
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).sendKeys("09/25/2019");
	}
	@AfterTest
	public void close()
	{
	driver.close();
	}
	
	}
