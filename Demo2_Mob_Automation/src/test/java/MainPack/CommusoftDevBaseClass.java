package MainPack;

import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utility.ActivityCapture;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;

import io.appium.java_client.remote.MobileCapabilityType;

public class CommusoftDevBaseClass extends WrapperClass{


	public ActivityCapture AC;
	public EventFiringWebDriverFactory EFDF;

	@BeforeTest

	public void Setup() 
	{

		try {


			//AppiumWebDriverEventListener

			DesiredCapabilities capabilities= new DesiredCapabilities();

			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11 RP1A");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 Pro");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability(MobileCapabilityType.UDID, "jrd6hmy5mzhihihu");
			//		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft dev");
			capabilities.setCapability("appPackage", "com.commusoft.v4.dev");
			capabilities.setCapability("appActivity", "com.commusoft.v4.Setup.Activities.SplashScreen");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

			URL url=new URL("http://0.0.0.0:4723/wd/hub");

			driver=new AndroidDriver<MobileElement>(url,capabilities);

			driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new ActivityCapture());// For Activity Capture


		


		}catch(Exception e) 
		{
			System.out.println("Cause Of Error: "+e.getCause());
			System.out.println("Error Message: "+e.getMessage());
			e.printStackTrace();
		}

	}



	@AfterTest
	public void TearDown() 
	{
		//		driver.close();
	}

}
