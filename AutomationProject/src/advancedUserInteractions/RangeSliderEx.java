package advancedUserInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RangeSliderEx {
	ChromeDriver driver;
	@BeforeTest
	public void testSlider()
	{
		driver=new ChromeDriver();
		driver.get("https://rangeslider.js.org/");
		slide(driver,500);
	}
	@Test
	public void slide(ChromeDriver driver,int value)
	{
		//driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.id("js-rangeslider-0"));
		WebElement sliderhandle=driver.findElement(By.xpath("//*[@id='js-rangeslider-0']/div[2]"));
		int width=slider.getSize().getWidth();
		int x=(int)Float.parseFloat(sliderhandle.getCssValue("left").replace("px",""));
		System.out.println(width);
		float min=10;
		float max=1000;
		float offsetX=width/(max-min)*value;
		System.out.println(offsetX);
		
		Actions action=new Actions(driver);
		action.dragAndDropBy(sliderhandle,-x,10).dragAndDropBy(sliderhandle, (int)offsetX,10).perform();
	}
	
}