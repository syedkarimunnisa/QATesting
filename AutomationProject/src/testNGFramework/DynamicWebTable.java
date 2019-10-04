package testNGFramework;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicWebTable {
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
		WebElement table=driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table"));
		List<WebElement> nrows=table.findElements(By.tagName("tr"));
		for(int i=0;i<nrows.size();i++)
		{
			List<WebElement> ncols=nrows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<ncols.size();j++)
			{
				System.out.print(ncols.get(j).getText()+ "   ");
			}
			System.out.println();
		}
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
