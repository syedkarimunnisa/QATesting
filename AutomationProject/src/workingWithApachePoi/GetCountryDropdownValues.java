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
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCountryDropdownValues {
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("http://www.newtours.demoaut.com/");
		Sleeper.sleepTightInSeconds(4);
	}
	@Test
	public void data() throws IOException
	{
		fis=new FileInputStream("C:\\Users\\Muktiar.s\\Desktop\\DataFile.xlsx");	
		wb=new XSSFWorkbook(fis);
		wb.getSheet("sheet1");
		driver.findElement(By.linkText("REGISTER")).click();
		Sleeper.sleepTightInSeconds(2);
		WebElement dropdown=driver.findElement(By.name("country"));
		List<WebElement> values=dropdown.findElements(By.tagName("option"));
		for(int i=0;i<values.size();i++)
		{
			Row r;	
			r=ws.createRow(i);
			r.createCell(0).setCellValue(values.get(i).getText());
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Muktiar.s\\Desktop\\DataFile.xlsx");
		wb.write(fos);
		wb.close();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}