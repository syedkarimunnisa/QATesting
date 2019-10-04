package workingWithAutoIT;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

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
	//ChromeDriver driver;
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open()
	{
		//driver=new ChromeDriver();
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.seleniumhq.org/download/");
	}
	@Test
	public void windowElement()throws IOException
	{
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.linkText("3.141.59")).click();
		Sleeper.sleepTightInSeconds(8);
		java.lang.Runtime.getRuntime().exec("D:\\karimun\\AutoIt3\\downloads\\seleniumwebdriver1.exe");
		Sleeper.sleepTightInSeconds(8);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
