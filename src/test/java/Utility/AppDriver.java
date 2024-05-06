package Utility;

import io.appium.java_client.MobileElement;

public class AppDriver {
	
	private static ThreadLocal<MobileElement> driver = new ThreadLocal<MobileElement>();
	
	public static MobileElement getDriver()
	{
		return driver.get();
	}
	
	

//	public static void setDriver(AndroidDriver<MobileElement> driver2) {
//		driver.set(Driver);
//		
//	}
	

}
