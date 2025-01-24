package Utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import MainPack.BaseClassForWebAndMobile;
import MainPack.CommusoftDevBaseClass;
import Test.CommusoftDevTestClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;


public class MobEventListener extends BaseClassForWebAndMobile implements AppiumWebDriverEventListener{
	

	
	public void beforeNavigateTo(String url, AndroidDriver<MobileElement> driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, AndroidDriver<MobileElement> driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(MobileElement element, AndroidDriver<MobileElement> driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(MobileElement element, AndroidDriver<MobileElement> driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(MobileElement element, AndroidDriver<MobileElement> driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(MobileElement element, AndroidDriver<MobileElement> driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(AndroidDriver<MobileElement> driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(AndroidDriver<MobileElement> driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(AndroidDriver<MobileElement> driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(AndroidDriver<MobileElement> driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, AndroidDriver<MobileElement> driver) {
//		System.out.println("Exception occured: " + error);
//		
//		Screenshot screenshot = new Screenshot();
//		try {
//			screenshot.capture(driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void beforeFindBy(By by, MobileElement element, AndroidDriver<MobileElement> driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, MobileElement element, AndroidDriver<MobileElement> driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, AndroidDriver<MobileElement> driver) {
	}

	public void afterScript(String script, AndroidDriver<MobileElement> driver) {
	}

	public void beforeAlertAccept(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(MobileElement element, AndroidDriver<MobileElement> driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(MobileElement element, AndroidDriver<MobileElement> driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(MobileElement arg0, AndroidDriver<MobileElement> arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, AndroidDriver<MobileElement> arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(MobileElement arg0, AndroidDriver<MobileElement> arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, AndroidDriver<MobileElement> arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo1(String url, AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}



}
