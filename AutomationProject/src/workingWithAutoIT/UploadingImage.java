package workingWithAutoIT;

import java.awt.AWTException;
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

public class UploadingImage {
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
	public void upload()throws IOException
	{
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.cssSelector("div#app label:nth-child(1) > div")).click();
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.xpath("//*[@id='device-info']/label")).click();
		Sleeper.sleepTightInSeconds(5);
		java.lang.Runtime.getRuntime().exec("D:\\karimun\\AutoIt3\\uploads\\uploadimg.exe");
		Sleeper.sleepTightInSeconds(5);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
