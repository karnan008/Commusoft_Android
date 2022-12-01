package Test;

import org.openqa.selenium.WebDriver;

public class ForScrollingClass {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	static void setWebDriver(WebDriver drive) 
	{
		driver=drive; 
	}

}
