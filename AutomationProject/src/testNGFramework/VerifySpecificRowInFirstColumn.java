package testNGFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifySpecificRowInFirstColumn {
	ProfilesIni pi;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open()
	{
		pi=new ProfilesIni();
		fp=pi.getProfile("onlineQA");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.timeanddate.com/worldclock/");
	}
	@Test
	public void tables()
	{
		String part1="/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String part2="]/td[1]";
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			String data=driver.findElement(By.xpath(part1+i+part2)).getText();
			//System.out.println(data);
			String expected="Bangkok";
			
			//Assert.assertEquals(data, expected, "pass");
			if(data.equals(expected))
				System.out.println(data+"  "+"pass");
				
			//else
				//System.out.println(data+"fail");
		}
	
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
