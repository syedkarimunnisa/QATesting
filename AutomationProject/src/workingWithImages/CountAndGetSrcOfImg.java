package workingWithImages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountAndGetSrcOfImg {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	@Test
	public void images()
	{
	// WebElement dropdown=driver.findElement(By.id("themes"));
	 List<WebElement> nimages=driver.findElements(By.tagName("img"));
	 System.out.println("no of images:"+ nimages.size());
	 for(int i=0;i<nimages.size();i++)
	 {
		 System.out.println("src of images="+nimages.get(i).getAttribute("src"));
	 }
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}


}
