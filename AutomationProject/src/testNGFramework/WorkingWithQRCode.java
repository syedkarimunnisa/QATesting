package testNGFramework;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class WorkingWithQRCode {
	ChromeDriver driver;
	@BeforeTest
	public void open()
	{
		driver=new ChromeDriver();
		driver.get("https://www.barcodesinc.com/generator/qr/");
	}
	@Test
	public void data() throws IOException, ReaderException
	{
		String imgurl=driver.findElement(By.xpath("/html/body/div[6]/div[1]/a/img")).getAttribute("src");
		URL url=new URL(imgurl);
		BufferedImage bimage=ImageIO.read(url);
		LuminanceSource lsource=new BufferedImageLuminanceSource(bimage);
		BinaryBitmap bmap=new BinaryBitmap(new HybridBinarizer(lsource));
		Result rs= new MultiFormatReader().decode(bmap);
		System.out.println("My QR Code Text is :" + "" +rs.getText());
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}


}
