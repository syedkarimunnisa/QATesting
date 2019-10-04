package workingWithDatePicker;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class WithCalender {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
	}
	@Test
	public void calen() throws Exception
	{
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('ctl00_mainContent_view_date1').value='25/09'");
		js.executeScript("document.getElementById('ctl00_mainContent_view_date2').value='29/09'");		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}


}
