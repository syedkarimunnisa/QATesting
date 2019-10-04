package workingWithCookies;

import java.util.Set;

import org.openqa.selenium.Cookie;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountNoOFCookies {

	ChromeDriver driver;

	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.mirror.co.uk");
	}
	@Test
	public void operation()
	{
		Set<Cookie> mycookies=driver.manage().getCookies();
		System.out.println("noof cookies"+ mycookies.size());
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
