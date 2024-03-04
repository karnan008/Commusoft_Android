package Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.CommusoftDevBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;

public class ActivityCapture extends CommusoftDevBaseClass implements AppiumWebDriverEventListener{

	public void beforeAlertAccept(AndroidDriver<MobileElement> driver) {


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
	public void beforeNavigateTo1(String url, WebDriver driver) {

		System.out.println("Before navigating to: '" + url + "'");

	}
	public void afterNavigateTo1(String url,WebDriver driver) {

		System.out.println("Navigated to:'" + url + "'");

	}
	public void beforeNavigateBack1(WebDriver driver) {

		System.out.println("Navigating back to previous page");

	}
	public void afterNavigateBack1(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}
	public void beforeNavigateForward1(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}
	public void afterNavigateForward1(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}
	public void beforeNavigateRefresh(AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}
	public void afterNavigateRefresh(AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, MobileElement element, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}
	public void afterFindBy(By by, MobileElement element, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void beforeClickOn(MobileElement arg0, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub


//		Date strDate = new Date();
//
//		Calendar cal = Calendar.getInstance();
//
//		String sDate = new SimpleDateFormat("MMddyyyy").format(cal.getTime());
//
//		String screenShotName="123"+sDate+RandomStringUtils.random(6, true, false)+".png";
//
//		String screenShotPath;
//
//		try {
//
//			screenShotPath = CaptureScreenshot.capture(driver,screenShotName,StartFramework.logger);
//
//			//StartFramework.logger.log(Status.PASS, "Snapshot below: " +StartFramework.logger.addScreenCaptureFromPath(screenShotPath));
//
//			StartFramework.child.info("Clicking on element->"+arg0, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
//
//			//StartFramework.logger.info("Screenshot").addScreenCaptureFromPath(screenShotPath);
//
//		} catch (IOException e) {
//
//			// TODO Auto-generated catch block
//
//			e.printStackTrace();
//
//			StartFramework.child.log(Status.PASS, "Getting an Exception"+e);
//
//		}

	}

	public void afterClickOn(MobileElement element, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf1(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");

	}

	public void afterChangeValueOf1(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Element value changed to: " + element.toString());

	}

	public void beforeScript(String script, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void afterScript(String script, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void onException1(Throwable error, WebDriver driver) {

		System.out.println("Exception occured: " + error);
		
		CommusoftDevBaseClass Com_DevBase = new CommusoftDevBaseClass();
//		Com_DevBase.TakeScreenShot(driver);

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

		// TODO Auto-generated method stub

	}

	public void beforeGetText(MobileElement element, AndroidDriver<MobileElement> driver) {

		// TODO Auto-generated method stub

	}

	public void afterGetText(MobileElement element, AndroidDriver<MobileElement> driver, String text) {

		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(MobileElement arg0, AndroidDriver<MobileElement> arg1) {

		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(MobileElement arg0, AndroidDriver<MobileElement> arg1) {

		// TODO Auto-generated method stub

	}
	public void beforeAlertAccept1(AndroidDriver<MobileElement> driver) {
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
	public void beforeFindBy1(By by, WebElement element,WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
		
	}
	public void afterFindBy1(By by, WebElement element,WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		
	}
	public void beforeClickOn1(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
		
	}
	public void afterClickOn1(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
		
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
}
