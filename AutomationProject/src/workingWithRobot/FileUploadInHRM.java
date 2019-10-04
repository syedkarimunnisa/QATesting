package workingWithRobot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class FileUploadInHRM {
ChromeDriver driver;

@BeforeTest
public void open()
{
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com");
	
}

@Test
public void loginOp()
{
	driver.findElement(By.id("txtUsername")).sendKeys("admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();	
}
/*
@Test
public void loginStatus()
{
	String expected="Welcome Admin";
	String actual=driver.findElement(By.linkText("Welcome Admin")).getText();
	Assert.assertEquals(expected, actual);
}*/
@Test
public void upload() throws AWTException, InterruptedException
{
	Sleeper.sleepTightInSeconds(5);
	/*JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.getElementById('menu_pim_viewPimModule').click()");
	js.executeScript("document.getElementById('menu_pim_addEmployee').click()");
	js.executeScript("document.getElementByID('photofile').click()");
	*/
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	driver.findElement(By.linkText("Add Employee")).click();
	driver.findElement(By.xpath("//*[@id='photofile']")).click();
	Thread.sleep(2000);
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_A);
	rb.keyPress(KeyEvent.VK_B);
	rb.keyPress(KeyEvent.VK_PERIOD);
	rb.keyPress(KeyEvent.VK_J);
	rb.keyPress(KeyEvent.VK_P);
	rb.keyPress(KeyEvent.VK_G);
	
	Thread.sleep(5000);
	
	rb.keyPress(KeyEvent.VK_ENTER);

	/*StringSelection imgpath=new StringSelection("C:\\Users\\Muktiar.s\\Desktop\\AB.jpg");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgpath, null);
	
	rb.setAutoDelay(2000);
	
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyRelease(KeyEvent.VK_V);
	
	rb.setAutoDelay(2000);
	
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
*/

}
/*
@Test
public void logout()
{
	driver.findElement(By.linkText("Welcome Admin")).click();
	driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
}*/

@AfterTest
public void close()
{
	driver.close();
}
}
