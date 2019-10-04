package workingWithLog4j;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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

public class UploadingImgUsingSikuli {
	private static Logger log=Logger.getLogger(UploadingImgUsingSikuli.class);
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;

	@BeforeTest
	public void open()
	{
		DOMConfigurator.configure("log4j.xml");
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		log.info("Tc execution started");
		driver=new FirefoxDriver(fp);
		log.info("browser opened sucessfully");
		driver.get("https://www.photobox.co.uk/upload");
		log.info("open page successfull");
	}
	
	@Test
	public void upload()throws IOException, FindFailed
	{
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.cssSelector("div#app label:nth-child(1) > div")).click();
		
		Sleeper.sleepTightInSeconds(3);
		log.info("click on computer sucessfull");
		driver.findElement(By.xpath("//*[@id='device-info']/label")).click();
		
		Sleeper.sleepTightInSeconds(5);
		log.info("click on upload img successfull");
		//java.lang.Runtime.getRuntime().exec("D:\\karimun\\AutoIt3\\uploads\\uploadimg.exe");
		
		
		Pattern filename=new Pattern("D:\\karimun\\sikulidown-uplod-operations\\fileuploadsikuli.PNG");
		Pattern openbutton=new Pattern("D:\\karimun\\sikulidown-uplod-operations\\buttonsikuli.PNG");
		Screen sc=new Screen();
		sc.type(filename,"C:\\Users\\Muktiar.s\\Desktop\\cb.jpg");
		sc.click(openbutton);
		log.info("upload also completed");
		//Sleeper.sleepTightInSeconds(3);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
