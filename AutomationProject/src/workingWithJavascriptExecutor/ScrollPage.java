package workingWithJavascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollPage {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://facebook.com");
		
	}
	@Test
	public void scroll() throws Exception
	{
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//js.executeScript("document.getElementById('ctl00_mainContent_view_date2').value='29/09'");		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
