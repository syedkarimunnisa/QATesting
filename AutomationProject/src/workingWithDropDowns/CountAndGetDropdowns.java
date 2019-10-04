package workingWithDropDowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountAndGetDropdowns {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
	}
	@Test
	public void dropdowns()
	{
	// WebElement dropdown=driver.findElement(By.id("themes"));
	 List<WebElement> ndropdowns=driver.findElements(By.tagName("select"));
	 System.out.println("no of dropdowns:"+ ndropdowns.size());
	 for(int i=0;i<ndropdowns.size();i++)
	 {
		 System.out.println("names="+ ndropdowns.get(i).getAttribute("name"));
	 }
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}


}
