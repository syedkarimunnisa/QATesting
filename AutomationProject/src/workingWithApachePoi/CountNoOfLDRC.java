package workingWithApachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountNoOfLDRC {
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	FileOutputStream fos;
	ChromeDriver driver;
	
	@BeforeTest
	public void open()
	{
		
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void operation() throws IOException
	{
		Sleeper.sleepTightInSeconds(5);
		fis=new FileInputStream("C:\\Users\\Muktiar.s\\Desktop\\DataFile.xlsx");
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("Sheet3");
		
		List<WebElement> nlinks=driver.findElements(By.tagName("a"));
		//for(int i=0;i<nlinks.size();i++)
		Row r;
		r=ws.createRow(0);
		r.createCell(0).setCellValue("No of Links are:"+ " "+ nlinks);
		
		fos=new FileOutputStream("C:\\Users\\Muktiar.s\\Desktop\\DataFile.xlsx");
		wb.write(fos);
		wb.close();
	
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}



}
