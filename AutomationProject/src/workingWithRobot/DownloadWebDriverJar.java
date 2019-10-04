package workingWithRobot;

import java.awt.AWTException;
import java.awt.Robot;
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

public class DownloadWebDriverJar {
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;

	@BeforeTest
	public void open()
	{
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.seleniumhq.org/download/");
		//driver.get("http://demo.automationtesting.in/FileDownload.html");
		
	}
	@Test
	public void windowElement()throws AWTException,InterruptedException
	{
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.linkText("3.141.59")).click();
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/a/span")).click();
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/a/span")).click();
		Sleeper.sleepTightInSeconds(3);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
	
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
