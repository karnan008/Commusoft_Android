package Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import MainPack.WrapperClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class LoginPageForCommusoftDev extends WrapperClass{
	
	
	
	public LoginPageForCommusoftDev(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void EnterId() throws InterruptedException 
	{
		ThreeSec();
		driver.findElement(By.id("com.commusoft.v4.dev:id/id")).sendKeys("19259");
		
		
	}
	
	public void Enter_Username() throws InterruptedException 
	{
		ThreeSec();
		driver.findElement(By.id("com.commusoft.v4.dev:id/userName")).sendKeys("Saravanan");
		
	}
	
	public void Enter_Password() throws InterruptedException 
	{
		ThreeSec();
		MobileElement ele=driver.findElement(By.id("com.commusoft.v4.dev:id/password"));
		ele.sendKeys("demo123");
		
		
	}
	public void Click_SigninButton() throws InterruptedException 
	{
		ThreeSec();
		driver.findElement(By.id("com.commusoft.v4.dev:id/commusoftLogin")).click();
		
		
	}
	
	public void AcceptPermission() throws InterruptedException 
	{
	
	
//		MobileElement findElement = driver.findElement(By.xpath("//*[@text='Request for permission']"));
//		WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Request for permission']")));
		TenSec();

		MobileElement YesButton = driver.findElement(By.xpath("//*[@text='Yes']"));
//		WebDriverWait wait=new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.visibilityOf(YesButton));
//		WaitForVisibility(YesButton);
		YesButton.click();
	}
	public void Click_NextButton1() throws InterruptedException 
	{
		ThreeSec();
//		driver.findElement(By.xpath("//*[@text='Next']")).click();
		Click2("//*[@text='Next']");
	}
	public void Click_NextButton2() throws InterruptedException 
	{
		ThreeSec();
//		driver.findElement(By.xpath("//*[@text='Next']")).click();
		Click2("//*[@text='Next']");
	}
	public void Click_Yes() throws InterruptedException 
	{
		ThreeSec();
//		driver.findElement(By.xpath("//*[@text='YES, USE NEW LAYOUT']")).click();
		Click2("//*[@text='YES, USE NEW LAYOUT']");
		ThreeSec();
	}
	
	public void LoadingPage() throws InterruptedException 
	{
		boolean Percentage = driver.findElement(By.xpath("//*[@text='100 %']")).isDisplayed();
//		WaitForVisibility(Percentage);
		TenSec();
		FiveSec();
		Assert.assertTrue(Percentage);
		System.out.println("Percentage Value Is: "+Percentage);
	}
	

	public void Username_Verification() throws InterruptedException 
	{
//		Thread.sleep(10000);
//		WebDriverWait wait=new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//#[@text='Hi Saravanan']"))));
	
//		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//#[@text='Hi Saravanan']"))));
		
//		MobileElement userName = driver.findElement(By.xpath("//#[@text='Hi Saravanan']"));
//		WaitForVisibility(userName);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		boolean username = driver.findElement(By.xpath("//#[@text='Hi Saravanan']")).isDisplayed();
		
		Assert.assertTrue(username);
		System.out.println("Username Is: "+username);
		
	
		
	}
}
