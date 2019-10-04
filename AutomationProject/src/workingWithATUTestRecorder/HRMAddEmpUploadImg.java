package workingWithATUTestRecorder;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class HRMAddEmpUploadImg {
	ChromeDriver driver;
	@BeforeTest
	public void open()throws ATUTestRecorderException
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		ATUTestRecorder recorder=new ATUTestRecorder("C:\\Users\\Muktiar.s\\Desktop\\video","HRM login",false);
		recorder.start();

	}
	@Test
	public void login()
	{
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	@Test
	public void status()
	{
		String expected="Welcome Admin";
		String actual=driver.findElement(By.linkText("Welcome Admin")).getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void addEmp() throws AWTException, InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.xpath("//*[@id='photofile']")).click();
		
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_C);
		rb.keyPress(KeyEvent.VK_B);
		rb.keyPress(KeyEvent.VK_PERIOD);
		rb.keyPress(KeyEvent.VK_J);
		rb.keyPress(KeyEvent.VK_P);
		rb.keyPress(KeyEvent.VK_G);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	
	@Test
	public void logout()
	{
		driver.findElement(By.linkText("Welcome Admin")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
