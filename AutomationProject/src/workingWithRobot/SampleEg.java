package workingWithRobot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleEg {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
	driver=new ChromeDriver();
	driver.get("https://www.calendarlabs.com/excel-calendar/"); // sample url	
   }
	@Test
	public void operation() throws InterruptedException, AWTException
	{
	driver.findElement(By.xpath(".//a[@href=contains(text(),'yearly-calendar.xls')]")).click();	
    Robot robot = new Robot();  // Robot class throws AWT Exception	
    Thread.sleep(2000); // Thread.sleep throws InterruptedException	
    robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button	
    
    Thread.sleep(2000);  // sleep has only been used to showcase each event separately	
    robot.keyPress(KeyEvent.VK_TAB);	
    Thread.sleep(2000);	
    robot.keyPress(KeyEvent.VK_TAB);	
    Thread.sleep(2000);	
    robot.keyPress(KeyEvent.VK_TAB);	
    Thread.sleep(2000);	
    robot.keyPress(KeyEvent.VK_ENTER);	
// press enter key of keyboard to perform above selected action	
	}	
	@AfterTest
	public void close()
	{
		driver.close();
	}	
}
