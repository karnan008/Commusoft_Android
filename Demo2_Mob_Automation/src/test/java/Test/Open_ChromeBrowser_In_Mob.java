package Test;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Open_ChromeBrowser_In_Mob {
	
	
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void Setup() 
	{
		
		try {

		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11 RP1A");//11 RP1A
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 Pro");//Redmi Note 8 Pro
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.UDID, "jrd6hmy5mzhihihu");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		
		
		capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Chrome");//Chrome '87.0.4280'  Chrome '107.0.5304'
		
		capabilities.setCapability("clearDeviceLogsOnStart", true);
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
//		capabilities.setCapability("appPackage", "com.android.deskclock");
//		capabilities.setCapability("appActivity", "com.android.deskclock.DeskClockTabActivity");

		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");//http://127.0.0.1:4723/wd/hub
		
		driver=new AppiumDriver<MobileElement>(url,capabilities);
		
		}catch(Exception e) 
		{
			
			System.out.println("Get Cause: "+e.getCause());
			System.out.println("Get Message: "+e.getMessage());
			
			e.printStackTrace();
		}
				
		
	}
	
//	@Test
//	public void Test() throws InterruptedException 
//	{
////		Thread.sleep(10000);
//		System.out.println("Test Case Has Been Completed ");
////		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Gallery\"]")).click();
//	}
	
	@AfterTest
	public void TearDown() 
	{
		
	}



}
