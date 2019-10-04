package workingWithDropDowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValueActiveOrInactive {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
	}
	@Test
	public void links()
	{
	 WebElement dropdown=driver.findElement(By.id("themes"));
	 List<WebElement> values=dropdown.findElements(By.tagName("option"));
	 for(int i=0;i<values.size();i++)
	 {
		 String text=values.get(i).getText();
		 values.get(i).click();
		 if(values.get(i).isDisplayed())
		 {
			 System.out.println(text+ " " + "active");
		 }
		 else
		 {
			 System.out.println(text+ " "+ "Inactive");
		 }
	 }
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}










}
