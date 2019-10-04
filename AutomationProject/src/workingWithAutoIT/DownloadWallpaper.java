package workingWithAutoIT;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadWallpaper {
	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("http://www.hdnicewallpapers.com/Wallpaper-Download/Cute-Baby/Cute-Pink-Baby-Girl-HD-Wallpaper/");
		
	}
	@Test
	public void windowElement()throws IOException
	{
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.id("CLICKIMG")).click();
		Sleeper.sleepTightInSeconds(3);
		java.lang.Runtime.getRuntime().exec("D:\\downloadfile.exe");		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
