package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Settings extends Wrapper{
	
	public Web_Settings(WebDriver wdriver) 
	{
		this.driverWeb=wdriver;
		
	}

	
	
	public void LoginInWeb() 
	{
//		TenSec();
//		EightSec();
//		ConnectWeb();
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
		Webclick("//input[@id='logintype_clientid']");
//		TwoSec();
		typeForWeb("//input[@id='logintype_clientid']", "16410");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
		typeForWeb("//input[@id='logintype_username']", "Saravanan");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
		typeForWeb("//input[@id='logintype_password']", "Demo1234!");
		ExplicitWait_ElementToBeClickable2("//span[text()='Log in']");
		Webclick("//span[text()='Log in']");
	}
	public void WebSettings() 
	{
		ExplicitWait_ElementToBeClickable2("//a[@class='dropdown-toggle ss-settings']");
		Webclick("//a[@class='dropdown-toggle ss-settings']");
	}
	public void SystemSettings() 
	{
		ExplicitWait_ElementToBeClickable2("//a[text()='System settings']");
		Webclick("//a[text()='System settings']");
	}
	public void SetUpPartCollectionWorkflow_Setting() 
	{
		ExplicitWait_ElementToBeClickable2("//a[text()='Set up part collection workflow']");
		Webclick("//a[text()='Set up part collection workflow']");
	}
	
	public void Enable_PicklistOn() 
	{
		ExplicitWait_ElementToBeClickable2("(//input[@type='radio'])[1]");
		Webclick("(//input[@type='radio'])[1]");
		boolean enabled = driverWeb.findElement(By.xpath("(//input[@type='radio'])[1]")).isEnabled();
		System.out.println("Pick List Is On Or Not: "+enabled);
	}
	
	public void Save_Picklist() 
	{
		ExplicitWait_ElementToBeClickable2("//button[@type='submit']");
		Webclick("//button[@type='submit']");
	}
	
}
