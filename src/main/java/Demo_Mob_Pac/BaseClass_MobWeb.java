package Demo_Mob_Pac;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass_MobWeb {

	public  AndroidDriver<MobileElement> CAP() throws MalformedURLException {

		AndroidDriver<MobileElement>driver;

		DesiredCapabilities capabilities =new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "11");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft");
//		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);//http://127.0.0.1:4723/wd/hub
                                                                                                     //http://0.0.0.0:4723/wd/hub
		return driver;      

		
		//Should Start the appium
		//Should Start the Emulator Using The Emulator Name.
	}

}
