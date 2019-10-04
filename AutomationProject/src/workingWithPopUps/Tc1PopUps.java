package workingWithPopUps;

//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc1PopUps {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("http://popuptest.com/");
		
	}
	@Test
	public void popups()
	{
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.linkText("Multi-PopUp Test")).click();
		String parent=driver.getWindowHandle();
		Set<String> pops=driver.getWindowHandles();
		Iterator<String> it=pops.iterator();
		while(it.hasNext())
		{
			String popuphandle=it.next().toString();
			if(popuphandle.contains(parent))
			{
				driver.switchTo().window(popuphandle);
				Sleeper.sleepTightInSeconds(5);
	
			}
		}
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
