package testNGFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewtoursRegisterByProperties {
	ChromeDriver driver;
	FileInputStream fis;
	Properties pr;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("http://www.newtours.demoaut.com/");
	}
	@Test
	public void usingproperty() throws IOException
	{
		Sleeper.sleepTightInSeconds(2);
		fis=new FileInputStream("D:\\karimun\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\AutomationProject\\newtoursRegister.properties");
		pr=new Properties();
		pr.load(fis);
		
		
		driver.findElement(By.linkText(pr.getProperty("rglink"))).click();
		driver.findElement(By.name(pr.getProperty("fname"))).sendKeys("Arshiya");
		driver.findElement(By.name(pr.getProperty("lname"))).sendKeys("Syed");
		driver.findElement(By.name(pr.getProperty("call"))).sendKeys("9703392525");
		driver.findElement(By.name(pr.getProperty("email"))).sendKeys("syed.karimunnisa@gmail.com");
		driver.findElement(By.name(pr.getProperty("address"))).sendKeys("Ameerpet");
		driver.findElement(By.name(pr.getProperty("city"))).sendKeys("Hyderabad");
		driver.findElement(By.name(pr.getProperty("state"))).sendKeys("Telengana");
		driver.findElement(By.name(pr.getProperty("pcode"))).sendKeys("500038");
		driver.findElement(By.name(pr.getProperty("country"))).sendKeys("India");
		driver.findElement(By.name(pr.getProperty("uname"))).sendKeys("arshiya786@gmail.com");
		driver.findElement(By.name(pr.getProperty("pass"))).sendKeys("Arshiya786*");
		driver.findElement(By.name(pr.getProperty("cpass"))).sendKeys("Arshiya786*");
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.name(pr.getProperty("submit"))).click();
		
		String expected="arshiya786@gmail.com";
		String actual=driver.findElement(By.xpath(pr.getProperty("rgsuccess"))).getText();
		if(actual.contains(expected)){
			System.out.println("Registration successfull");
			Sleeper.sleepTightInSeconds(3);
		}
		else
		{
			System.out.println("Registration not successfull");
			Sleeper.sleepTightInSeconds(3);
		}
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
