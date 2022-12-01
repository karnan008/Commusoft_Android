package MainPack;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class WrapperClass {

	public AndroidDriver<MobileElement> driver;

	public String Username="Saravanan";
	public String Surname="Customer0811";
	public String Addressline1="Ramapuram";


	public void ThreeSec() 
	{

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void FiveSec()  
	{

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void TenSec() 
	{

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AcceptAlert() 
	{

		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

	public void Click1(String xpath) 
	{
		if(xpath.contains("$")) 
		{
			xpath = xpath.replace("$","");
			driver.findElement(By.xpath(xpath)).click();
		}else if(xpath.contains("#")) 
		{
			xpath= xpath.replace("#", "");
			driver.findElement(By.xpath(xpath)).click();;
		}else if(xpath.contains("~")) 
		{
			xpath=xpath.replace("~", "");
			driver.findElement(By.xpath(xpath)).click();;
		}
	}
	public void Click2(String xpath) 
	{
		driver.findElement(By.xpath(xpath)).click();
	}

	public void Type1(String XpathForType,String Value) 
	{
		if(XpathForType.contains("$")) 
		{
			XpathForType=XpathForType.replace("$", "");
			driver.findElement(By.xpath(XpathForType)).sendKeys(Value);
		}else if(XpathForType.contains("#")) 
		{
			XpathForType=XpathForType.replace("#", "");
			driver.findElement(By.xpath(XpathForType)).sendKeys(Value);
		}else if(XpathForType.contains("~")) 
		{
			XpathForType=XpathForType.replace("~", "");
			driver.findElement(By.xpath(XpathForType)).sendKeys(Value);
		}
	}

	public void Type2(String xpath, String Value) 
	{
		driver.findElement(By.xpath(xpath)).sendKeys(Value);
	} 

	public void WaitForVisibility(MobileElement ele) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}
	
	public void TakeScreenShot(WebDriver driver) 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//		String currentDir=System.getProperty("user.dir");
		//		File des=new File(currentDir+"./Screenshot/"+System.currentTimeMillis()+".png");
		File des=new File("./ScreenShots/"+System.currentTimeMillis()+".png");

		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void HitEnter() throws InterruptedException
	{
		
		driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
		
	}


}
