package workingWithSikulis;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
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
		
	}
	@Test
	public void windowElement()throws FindFailed
	{
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.linkText("3.141.59")).click();
		Sleeper.sleepTightInSeconds(3);
		Screen sc=new Screen();
		Pattern pt1=new Pattern("‪C:\\Users\\Muktiar.s\\Desktop\\download.JPG");
		Pattern pt=new Pattern("C:\\Users\\Muktiar.s\\Desktop\\savedownload.JPG");
		Sleeper.sleepTightInSeconds(3);
		//sc.wait(pt);
		sc.click(pt1);
		sc.click(pt);

		Sleeper.sleepTightInSeconds(5);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
