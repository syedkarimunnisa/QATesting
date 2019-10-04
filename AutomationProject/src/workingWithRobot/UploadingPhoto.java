package workingWithRobot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadingPhoto {
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;

	@BeforeTest
	public void open()
	{
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.photobox.co.uk/upload");
		
	}
	@Test
	public void upload()throws AWTException,InterruptedException
	{
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.cssSelector("div#app label:nth-child(1) > div")).click();
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.xpath("//*[@id='device-info']/label")).click();
		
		Robot rb=new Robot();
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyPress(KeyEvent.VK_B);
		rb.keyPress(KeyEvent.VK_PERIOD);
		rb.keyPress(KeyEvent.VK_J);
		rb.keyPress(KeyEvent.VK_P);
		rb.keyPress(KeyEvent.VK_G);
		
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Sleeper.sleepTightInSeconds(2);
	
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
