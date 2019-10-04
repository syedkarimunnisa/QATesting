package workingWithRobot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadWallpapers {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		//driver.get("http://www.hdnicewallpapers.com/Wallpaper-Download/Cute-Baby/Cute-Pink-Baby-Girl-HD-Wallpaper/");
		driver.get("http://www.hdnicewallpapers.com/Wallpaper-Download/Alia-Bhatt/Bollywood-Actress-Alia-Bhatt");
	}
	@Test
	public void windowElement()throws AWTException,InterruptedException
	{
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.id("CLICKIMG")).click();
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
	
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
