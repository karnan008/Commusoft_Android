package testcase;

import org.openqa.selenium.By;

import action.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Login extends BaseClass{
	
	AppiumDriver<MobileElement> driver;
	public Login(AppiumDriver<MobileElement> ldriver)
	{
		this.driver =ldriver;
	}
	
	
	
	
	public void main() {
		
		driver.findElement(By.id("com.commusoft.v4:id/id")).sendKeys("16410");
		driver.findElement(By.id("com.commusoft.v4:id/userName")).sendKeys("karna");
		driver.findElement(By.id("com.commusoft.v4:id/password")).sendKeys("demo123");
		driver.findElement(By.id("com.commusoft.v4:id/commusoftLogin")).click();
		
	}

}
