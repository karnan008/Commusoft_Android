package MainPack;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.descriptive.moment.SemiVariance.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.google.common.collect.ImmutableMap;


import Utility.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Wrapper extends WrapperForWeb
{
	public AndroidDriver<MobileElement> driver;
	public String udid;
	public static  String estimatenumber;
	public static String jobnumber;
	public static String customernumber;
	public static String workaddressnumber;
	public static String EventDes;
	public static String Red;
	public static String Green;
	public static String Blue;
//	public static MobileElement ColorOfEstimates;
	public static String name;
	public static String accountnumweb;
	public static String webcustomer;
	public static String webemail;
	public static String username;
	public static String randomAlphabetic;
	
	
	 public String CustomerName;
	 public String AccountNumber;
	 public String WAName;
	 public String WAAccountNumber;
	 public static String arrive_Answer;
	 public static String leave_Answer;
	 
	
	public final Logger log4j = LogManager.getLogger(BaseClassForWebAndMobile.class);
   
	


	//	public Wrapper()
	//	{
	//		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	//	}

	public void type(String xpath, String value)
	{
		
		//----------------------------> NORMAL TYPE <--------------------------------
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				driver.findElement(By.name(xpath)).sendKeys(value);

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(value); 
			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				driver.findElement(By.className(xpath)).sendKeys(value);
			}
			else
			{
				driver.findElement(By.xpath(xpath)).sendKeys(value);
			}
		}
		
		//------------------------------------------> RETRY TYPE BY USING WHILE LOOP <--------------------------
//        String elementLocator =xpath;
//
//        retryType(driver, elementLocator, 3, 1000, value);
		//------------------------------------------> RETRY TYPE BY USING DO-WHILE LOOP <---------------------
//        int attempt = 1;
//        String message = null;
//
//        do {
//        	
//            try {
//                MobileElement enter = driver.findElement(By.xpath(xpath));
//                try {
//                    Thread.sleep(1000);
//                    }catch(Exception e) 
//                    {
//                    	
//                    }
//                enter.sendKeys(value);
//                
//            } catch (Exception e) {
//                
//                System.err.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
////                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
//                message = e.getMessage();
//
//                
//                attempt++;
//            }
//            
//        } while (message !=null && message.contains("no such element"));
		
	}
    private static MobileElement retryType(AndroidDriver driver, String xpath, int maxAttempts, long intervalMillis,String sendKeys) {
        int attempts = 0;
        MobileElement element = null;

        while (attempts < maxAttempts) {
            try {
                // Find the element
                element = (MobileElement) driver.findElement(By.xpath(xpath));

                // Click the element
                element.sendKeys(sendKeys);

                // If the click is successful, break out of the loop
                break;
            } catch (Exception e) {
                // Print any exception (for debugging purposes)
            	System.err.println("Attempt " + attempts + ": Exception caught - " + e.getMessage());

                // Increment the attempts counter
                attempts++;
                // Wait for the specified interval before retrying
                try {
                    Thread.sleep(intervalMillis);
                } catch (InterruptedException ignored) {
                }
            }
        }

        return element;
    }
	public void click(String option)
	{
		//----------------------------> NORMAL CLICK <--------------------------------
		{
			if(option.contains("$"))
			{
				option = option.replace("$", "");
				driver.findElement(By.name(option)).click();

			}
			else if(option.contains("#"))
			{
				option = option.replace("#", "");
				driver.findElement(By.id(option)).click(); 
			}
			else if(option.contains("~"))
			{
				option = option.replace("~", "");
				driver.findElement(By.className(option)).click();
			}
			else
			{
				//option = option.replace("//", "");
				driver.findElement(By.xpath(option)).click();
			}
		}
		
		//------------------------------------------> RETRY CLICK BY USING WHILE LOOP <--------------------------
//        String elementLocator =option;
//
//        retryClick(driver, elementLocator, 3, 1000);
		
		//------------------------------------------> RETRY CLICK BY USING DO-WHILE LOOP <---------------------
//        int attempt = 1;
//        String message = null;
//
//        do {
//        	
//            try {
//                MobileElement button = driver.findElement(By.xpath(option));
//                try {
//                    Thread.sleep(1000);
//                    }catch(Exception e) 
//                    {
//                    	
//                    }
//                button.click();
//                
//            } catch (Exception e) {
//                
//                System.out.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
////                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
//                message = e.getMessage();
//
//                
//                attempt++;
//            }
//            
//        } while (message !=null && message.contains("no such element"));
	}
	// Retry click function
    private static MobileElement retryClick(AndroidDriver driver, String xpath, int maxAttempts, long intervalMillis) {
        int attempts = 0;
        MobileElement element = null;

        while (attempts < maxAttempts) {
            try {
                // Find the element
                element = (MobileElement) driver.findElement(By.xpath(xpath));

                // Click the element
                element.click();

                // If the click is successful, break out of the loop
                break;
            } catch (Exception e) {
                // Print any exception (for debugging purposes)
            	 System.err.println("Attempt " + attempts + ": Exception caught - " + e.getMessage());

                // Increment the attempts counter
                attempts++;
                // Wait for the specified interval before retrying
                try {
                    Thread.sleep(intervalMillis);
                } catch (InterruptedException ignored) {
                }
            }
        }

        return element;
    }

	public void clear(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				driver.findElement(By.name(xpath)).clear();

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).clear(); 
			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				driver.findElement(By.className(xpath)).clear();
			}
			else
			{
				driver.findElement(By.xpath(xpath)).clear();
			}
		}
	}
	public void selectdropdownvalue(String xpath, String value) throws InterruptedException
	{
		if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			Select sc = new Select(driver.findElement(By.id(xpath)));
			sc.selectByValue(value);
		}else
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				Select sc = new Select(driver.findElement(By.name(xpath)));
				sc.selectByValue(value);
			}else
			{
				Select fcc = new Select(driver.findElement(By.xpath(xpath)));
				fcc.selectByValue(value);
			}

		Thread.sleep(3000);
	}

	public String gettext(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				return driver.findElement(By.name(xpath)).getText();


			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				return driver.findElement(By.id(xpath)).getText(); 

			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				return driver.findElement(By.className(xpath)).getText();

			}
			else
			{

				// xpath = xpath.replace("//", "");
				return driver.findElement(By.xpath(xpath)).getText();

			}
		}
	}

















	public void isdisplayed(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				driver.findElement(By.name(xpath)).isDisplayed();


			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isDisplayed(); 

			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				driver.findElement(By.className(xpath)).isDisplayed();

			}
			else
			{

				// xpath = xpath.replace("//", "");
				driver.findElement(By.xpath(xpath)).isDisplayed();

			}
		}
	}
	public void isenabled(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				driver.findElement(By.name(xpath)).isEnabled();


			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isEnabled(); 

			}
			else if(xpath.contains("."))
			{
				xpath = xpath.replace(".", "");
				driver.findElement(By.className(xpath)).isEnabled();

			}
			else
			{
				// xpath = xpath.replace("//", "");
				driver.findElement(By.xpath(xpath)).isEnabled();

			}
		}
	}
	public void typeenter(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				driver.findElement(By.name(xpath)).sendKeys(Keys.ENTER);

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(Keys.ENTER); 

			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				driver.findElement(By.className(xpath)).sendKeys(Keys.ENTER);

			}
			else
			{
				//xpath = xpath.replace("//", "");
				driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
			}
		}
	}
	public void scrollTo(String text)
	{                
		driver.findElementByCssSelector("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");


	}

	public MobileElement scroll(AppiumDriver<MobileElement> driver, String text) {
		return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
				".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
	}
	public void scrollToId(AndroidDriver<MobileElement> driver, String id) {
		MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().resourceIdMatches(\"" + id + "\"));");
	}
	public void MobileEnter(String xpath) throws InterruptedException
	{
		TouchAction touchAction = new TouchAction(driver);
		MobileElement element = driver.findElement(By.xpath(xpath));
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
	}

	public void ScrollBy(String visibleText)
	{
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text("+visibleText+"))"));//My Van

	}

	public void SCROLLTOTEXT(String xpath) 
	{
		RemoteWebElement element = (RemoteWebElement)driver. findElement(By.xpath(xpath));
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID);
		scrollObject.put("toVisible", "not an empty string");
		driver.executeScript("mobile:scroll", scrollObject);
	}

	public void dclick(String xpath)
	{
		if(xpath.contains("$"))
		{
			xpath = xpath.replace("$", "");
			Actions actions = new Actions(driver);
			MobileElement elementLocator = driver.findElement(By.name(xpath));
			actions.doubleClick(elementLocator).perform();

		}
		else if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			Actions actions = new Actions(driver);
			MobileElement elementLocator = driver.findElement(By.id(xpath));
			actions.doubleClick(elementLocator).perform(); 
		}
		else if(xpath.contains("~"))
		{
			xpath = xpath.replace("~", "");
			Actions actions = new Actions(driver);
			MobileElement elementLocator = driver.findElement(By.className(xpath));
			actions.doubleClick(elementLocator).perform();
		}
		else
		{
			//xpath = xpath.replace("//", "");
			Actions actions = new Actions(driver);
			MobileElement elementLocator = driver.findElement(By.xpath(xpath));
			actions.doubleClick(elementLocator).perform();
		}
	}
	public void scrollDown()
	{
		Dimension dimension = driver.manage().window().getSize();
		int scrollStart = (int)(dimension.getHeight()*0.5);
		int scrollEnd = (int)(dimension.getHeight()*0.9);

		new TouchAction((PerformsTouchActions) AppDriver.getDriver())
		.press(PointOption.point(0,scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0,scrollEnd))
		.release().perform();
	}
//	public void scrolltothetop(int x, int y, int x1, int y1) throws InterruptedException
//	{
//		Thread.sleep(3000);
//		(new TouchAction(driver)).press(PointOption.point(x,y))
//		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//		.moveTo(PointOption.point(x1,y1)).release().perform();
//		Thread.sleep(2000);
//	}
	public void scrolltothedown(int x, int y, int x1, int y1) throws InterruptedException
	{
		Thread.sleep(3000);
		(new TouchAction(driver)).press(PointOption.point(x,y))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(x1,y1)).release().perform();
		Thread.sleep(2000);
	}


//	public void scrolltotheright(int x, int y, int x1, int y1) throws InterruptedException
//	{
//		Thread.sleep(3000);
//		(new TouchAction(driver)).press(PointOption.point(x,y))
//		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//		.moveTo(PointOption.point(x1,y1)).release().perform();
//		Thread.sleep(2000);
//	}

	public void ScrollToText(String text) 
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new    UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains("+text+").instance(0))");
	}
	public void clickpoint(int Horizontal, int Vertical) throws InterruptedException
	{
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(2000);

	}
	public void doubleclickpoint(int Horizontal, int Vertical) throws InterruptedException
	{
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(PointOption.point(Horizontal,Vertical)).perform();
		Thread.sleep(2000);
	}
	public enum DIRECTION {
		DOWN, UP, LEFT, RIGHT;
	}
	public void swipe(AndroidDriver<MobileElement> driver, DIRECTION direction) throws InterruptedException {
		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();

		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;

		switch (direction) {
		case RIGHT:
			startY = (int) (size.height / 2);
			startX = (int) (size.width * 0.90);
			endX = (int) (size.width * 0.05);
			(new TouchAction(driver)).press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();

			break;

		case LEFT:
			startY = (int) (size.height / 2);
			startX = (int) (size.width * 0.10);
			endX = (int) (size.width * 0.90);
			(new TouchAction(driver))
			.press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();

			break;

		case UP:
			endY = (int) (size.height * 0.70);
			startY = (int) (size.height * 0.30);
			startX = (size.width / 2);
			(new TouchAction(driver))
			.press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();

			break;


		case DOWN:
			startY = (int) (size.height * 0.70);
			endY = (int) (size.height * 0.30);
			startX = (size.width / 2);
			(new TouchAction(driver))
			.press(PointOption.point(startX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
			.moveTo(PointOption.point(endX,startY))
			.release()
			.perform();


			break;

		}
	}
	public void Savebtn() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@content-desc=\"Save\"]");
		Thread.sleep(2000);
	}

	public void signature(int startX, int startY, int endX, int endY) throws InterruptedException
	{

		ScrollDown24("Sign here");
		OneSec();
		
		new TouchAction((AppiumDriver<MobileElement>)(driver))
		.press(new PointOption<>().withCoordinates(startX, startY))//startX, startY - 200, 1300
		.moveTo(new PointOption<>().withCoordinates(endX, endY))//endX, endY - 500, 900
		.moveTo(new PointOption<>().withCoordinates(endX+50, endY+50))
		.release()
		.perform();
		Thread.sleep(2000);
	}
	public void Estimatesignature(int startX, int startY, int endX, int endY) throws InterruptedException
	{

		
		OneSec();
		
		new TouchAction((AppiumDriver<MobileElement>)(driver))
		.press(new PointOption<>().withCoordinates(startX, startY))//startX, startY - 200, 1300
		.moveTo(new PointOption<>().withCoordinates(endX, endY))//endX, endY - 500, 900
		.moveTo(new PointOption<>().withCoordinates(endX+50, endY+50))
		.release()
		.perform();
		Thread.sleep(2000);
	}
	public void Ongoing_EstimateNo() throws InterruptedException
	{
		String EstimateNo = gettext("#com.commusoft.v4:id/typenoValue");
		Thread.sleep(3000);
		click("//android.widget.TextView[@text='"+EstimateNo+"']");
	}

	public void Imp40() 
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}


	public void TwoSec() 
	{

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void OneSec() 
	{

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ThreeSec() 
	{

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void FourSec() 
	{

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void FiveSec() 
	{

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EightSec() 
	{

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void TenSec() 
	{

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ExplicitWait_PresenceOfEle(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public void ExplicitWait_VisibilityOfEle(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

	}

	public void ExplicitWait_ElementToBeClickable(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void Verify_AssertTrue(MobileElement ele) 
	{
		Assert.assertTrue(ele.isDisplayed());
	}
	
	public void Verify_AssertEquals(String currentString, String ActualString) 
	{
		String Expected = driver.findElement(By.xpath(currentString)).getText();
		String Actual= ActualString;
		assertEquals(Actual, Expected);
		
	}
	
	

	public void S1(String exacttext) 
	{
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
						".scrollIntoView(new UiSelector().text('"+exacttext+"'))"));
	}
	public void S2() 
	{

		try {
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
		} catch (InvalidSelectorException e) {
			// ignore
		}


	}


	
	public void DemoWrapper4(String ExactText) throws InterruptedException 
	{
//		MobileElement text = driver.findElement(By.xpath("//*[@text='"+ExactText+"']"));

		while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=true) 
		{
			//			System.err.println("Exact Text Is Not Presented In That Page");
			scrolltothedown(294, 735, 297, 532);
//			ele.isDisplayed();


		}

		System.err.println("Test Case Passed");
	}

	public void DemoWrapper2(String ExactText) throws InterruptedException 
	{

		do 
		{
			scrolltothedown(294, 735, 297, 532);
//			String GetText = driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText();

			try {
				if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()) 
				{
//					scrolltothedown(294, 735, 297, 532);
					System.out.println("Case Pass1");
				}

			}catch(Exception e) 
			{

				do 
				{
					scrolltothedown(294, 735, 297, 532);
					
					try 
					{
						if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
							System.out.println("Case Pass2");
							
					}catch(Exception e1) 
					{
						e1.printStackTrace();
					}
					
				}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
			}
			
			System.out.println("Outside of the catch block");



		}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText().equals(ExactText)


		System.err.println("Outside of the do block");
	}
	public void ScrollDown24(String ExactText) throws InterruptedException 
	{


		do 
		{
			scrolltothedown(294, 735, 297, 532);
//			String GetText = driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText();

			try {
				if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()) 
				{
//					scrolltothedown(294, 735, 297, 532);
					System.out.println("Case Pass1");
				}

			}catch(Exception e) 
			{

				do 
				{
					scrolltothedown(294, 735, 297, 532);
					
					try 
					{
						if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
							System.out.println("Case Pass2");
							
					}catch(Exception e1) 
					{

						do 
						{
							scrolltothedown(294, 735, 297, 532);
							
							try 
							{
								if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
									System.out.println("Case Pass3");
									
							}catch(Exception e2) 
							{

								do 
								{
									scrolltothedown(294, 735, 297, 532);
									
									try 
									{
										if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
											System.out.println("Case Pass4");
											
									}catch(Exception e3) 
									{

										do 
										{
											scrolltothedown(294, 735, 297, 532);
											
											try 
											{
												if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
													System.out.println("Case Pass5");
													
											}catch(Exception e4) 
											{

												do 
												{
													scrolltothedown(294, 735, 297, 532);
													
													try 
													{
														if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
															System.out.println("Case Pass6");
															
													}catch(Exception e5) 
													{

														do 
														{
															scrolltothedown(294, 735, 297, 532);
															
															try 
															{
																if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																	System.out.println("Case Pass7");
																	
															}catch(Exception e6) 
															{

																do 
																{
																	scrolltothedown(294, 735, 297, 532);
																	
																	try 
																	{
																		if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																			System.out.println("Case Pass8");
																			
																	}catch(Exception e7) 
																	{

																		do 
																		{
																			scrolltothedown(294, 735, 297, 532);
																			
																			try 
																			{
																				if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																					System.out.println("Case Pass9");
																					
																			}catch(Exception e8) 
																			{

																				do 
																				{
																					scrolltothedown(294, 735, 297, 532);
																					
																					try 
																					{
																						if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																							System.out.println("Case Pass10");
																							
																					}catch(Exception e9) 
																					{


																						do 
																						{
																							scrolltothedown(294, 735, 297, 532);
																							
																							try 
																							{
																								if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																									System.out.println("Case Pass11");
																									
																							}catch(Exception e10) 
																							{


																								do 
																								{
																									scrolltothedown(294, 735, 297, 532);
																									
																									try 
																									{
																										if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																											System.out.println("Case Pass12");
																											
																									}catch(Exception e11) 
																									{


																										do 
																										{
																											scrolltothedown(294, 735, 297, 532);
																											
																											try 
																											{
																												if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																													System.out.println("Case Pass13");
																													
																											}catch(Exception e12) 
																											{


																												do 
																												{
																													scrolltothedown(294, 735, 297, 532);
																													
																													try 
																													{
																														if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																															System.out.println("Case Pass14");
																															
																													}catch(Exception e13) 
																													{


																														do 
																														{
																															scrolltothedown(294, 735, 297, 532);
																															
																															try 
																															{
																																if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																	System.out.println("Case Pass15");
																																	
																															}catch(Exception e14) 
																															{


																																do 
																																{
																																	scrolltothedown(294, 735, 297, 532);
																																	
																																	try 
																																	{
																																		if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																			System.out.println("Case Pass16");
																																			
																																	}catch(Exception e15) 
																																	{


																																		do 
																																		{
																																			scrolltothedown(294, 735, 297, 532);
																																			
																																			try 
																																			{
																																				if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																					System.out.println("Case Pass17");
																																					
																																			}catch(Exception e16) 
																																			{


																																				do 
																																				{
																																					scrolltothedown(294, 735, 297, 532);
																																					
																																					try 
																																					{
																																						if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																							System.out.println("Case Pass18");
																																							
																																					}catch(Exception e17) 
																																					{


																																						do 
																																						{
																																							scrolltothedown(294, 735, 297, 532);
																																							
																																							try 
																																							{
																																								if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																									System.out.println("Case Pass19");
																																									
																																							}catch(Exception e18) 
																																							{


																																								do 
																																								{
																																									scrolltothedown(294, 735, 297, 532);
																																									
																																									try 
																																									{
																																										if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																											System.out.println("Case Pass20");
																																											
																																									}catch(Exception e19) 
																																									{


																																										do 
																																										{
																																											scrolltothedown(294, 735, 297, 532);
																																											
																																											try 
																																											{
																																												if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																													System.out.println("Case Pass21");
																																													
																																											}catch(Exception e20) 
																																											{


																																												do 
																																												{
																																													scrolltothedown(294, 735, 297, 532);
																																													
																																													try 
																																													{
																																														if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																															System.out.println("Case Pass22");
																																															
																																													}catch(Exception e21) 
																																													{
																																														e1.printStackTrace();
																																													}
																																													
																																												}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																											
																																											}
																																											
																																										}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																									
																																									}
																																									
																																								}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																							
																																							}
																																							
																																						}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																					
																																					}
																																					
																																				}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																			
																																			}
																																			
																																		}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																	
																																	}
																																	
																																}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																															
																															}
																															
																														}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																													
																													}
																													
																												}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																											
																											}
																											
																										}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																									
																									}
																									
																								}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																							
																							}
																							
																						}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																					
																					}
																					
																				}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																			}
																			
																		}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																	}
																	
																}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
															}
															
														}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
													}
													
												}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
											}
											
										}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
									}
									
								}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
							}
							
						}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
					}
					
				}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
			}
			
			System.out.println("Outside of the catch block");



		}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText().equals(ExactText)


		System.err.println("Outside of the do block");
	
	}
	public void ScrollDown24Contains(String ContainsExactText) throws InterruptedException 
	{


		do 
		{
			scrolltothedown(294, 735, 297, 532);
//			String GetText = driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText();

			try {
				if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()) 
				{
//					scrolltothedown(294, 735, 297, 532);
					System.out.println("Case Pass1");
				}

			}catch(Exception e) 
			{

				do 
				{
					scrolltothedown(294, 735, 297, 532);
					
					try 
					{
						if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
							System.out.println("Case Pass2");
							
					}catch(Exception e1) 
					{

						do 
						{
							scrolltothedown(294, 735, 297, 532);
							
							try 
							{
								if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
									System.out.println("Case Pass3");
									
							}catch(Exception e2) 
							{

								do 
								{
									scrolltothedown(294, 735, 297, 532);
									
									try 
									{
										if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
											System.out.println("Case Pass4");
											
									}catch(Exception e3) 
									{

										do 
										{
											scrolltothedown(294, 735, 297, 532);
											
											try 
											{
												if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
													System.out.println("Case Pass5");
													
											}catch(Exception e4) 
											{

												do 
												{
													scrolltothedown(294, 735, 297, 532);
													
													try 
													{
														if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
															System.out.println("Case Pass6");
															
													}catch(Exception e5) 
													{

														do 
														{
															scrolltothedown(294, 735, 297, 532);
															
															try 
															{
																if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
																	System.out.println("Case Pass7");
																	
															}catch(Exception e6) 
															{

																do 
																{
																	scrolltothedown(294, 735, 297, 532);
																	
																	try 
																	{
																		if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
																			System.out.println("Case Pass8");
																			
																	}catch(Exception e7) 
																	{

																		do 
																		{
																			scrolltothedown(294, 735, 297, 532);
																			
																			try 
																			{
																				if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
																					System.out.println("Case Pass9");
																					
																			}catch(Exception e8) 
																			{

																				do 
																				{
																					scrolltothedown(294, 735, 297, 532);
																					
																					try 
																					{
																						if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed()!=false)
																							System.out.println("Case Pass10");
																							
																					}catch(Exception e9) 
																					{


																						do 
																						{
																							scrolltothedown(294, 735, 297, 532);
																							
																							try 
																							{
																								if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																									System.out.println("Case Pass11");
																									
																							}catch(Exception e10) 
																							{


																								do 
																								{
																									scrolltothedown(294, 735, 297, 532);
																									
																									try 
																									{
																										if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																											System.out.println("Case Pass12");
																											
																									}catch(Exception e11) 
																									{


																										do 
																										{
																											scrolltothedown(294, 735, 297, 532);
																											
																											try 
																											{
																												if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																													System.out.println("Case Pass13");
																													
																											}catch(Exception e12) 
																											{


																												do 
																												{
																													scrolltothedown(294, 735, 297, 532);
																													
																													try 
																													{
																														if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																															System.out.println("Case Pass14");
																															
																													}catch(Exception e13) 
																													{


																														do 
																														{
																															scrolltothedown(294, 735, 297, 532);
																															
																															try 
																															{
																																if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																	System.out.println("Case Pass15");
																																	
																															}catch(Exception e14) 
																															{


																																do 
																																{
																																	scrolltothedown(294, 735, 297, 532);
																																	
																																	try 
																																	{
																																		if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																			System.out.println("Case Pass16");
																																			
																																	}catch(Exception e15) 
																																	{


																																		do 
																																		{
																																			scrolltothedown(294, 735, 297, 532);
																																			
																																			try 
																																			{
																																				if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																					System.out.println("Case Pass17");
																																					
																																			}catch(Exception e16) 
																																			{


																																				do 
																																				{
																																					scrolltothedown(294, 735, 297, 532);
																																					
																																					try 
																																					{
																																						if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																							System.out.println("Case Pass18");
																																							
																																					}catch(Exception e17) 
																																					{


																																						do 
																																						{
																																							scrolltothedown(294, 735, 297, 532);
																																							
																																							try 
																																							{
																																								if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																									System.out.println("Case Pass19");
																																									
																																							}catch(Exception e18) 
																																							{


																																								do 
																																								{
																																									scrolltothedown(294, 735, 297, 532);
																																									
																																									try 
																																									{
																																										if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																											System.out.println("Case Pass20");
																																											
																																									}catch(Exception e19) 
																																									{


																																										do 
																																										{
																																											scrolltothedown(294, 735, 297, 532);
																																											
																																											try 
																																											{
																																												if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																													System.out.println("Case Pass21");
																																													
																																											}catch(Exception e20) 
																																											{


																																												do 
																																												{
																																													scrolltothedown(294, 735, 297, 532);
																																													
																																													try 
																																													{
																																														if(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed())
																																															System.out.println("Case Pass22");
																																															
																																													}catch(Exception e21) 
																																													{
																																														e1.printStackTrace();
																																													}
																																													
																																												}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																											
																																											}
																																											
																																										}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																									
																																									}
																																									
																																								}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																							
																																							}
																																							
																																						}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																					
																																					}
																																					
																																				}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																			
																																			}
																																			
																																		}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																	
																																	}
																																	
																																}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																															
																															}
																															
																														}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																													
																													}
																													
																												}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																											
																											}
																											
																										}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																									
																									}
																									
																								}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																							
																							}
																							
																						}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																					
																					}
																					
																				}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																			}
																			
																		}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																	}
																	
																}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
															}
															
														}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
													}
													
												}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
											}
											
										}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
									}
									
								}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
							}
							
						}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
					}
					
				}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
			}
			
			System.out.println("Outside of the catch block");



		}while(driver.findElement(By.xpath("//*[contains(@text,'"+ContainsExactText+"')]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText().equals(ExactText)


		System.err.println("Outside of the do block");
	
	}
	
	public void ScrollDown24LastText(String ExactLastText) throws InterruptedException 
	{



		do 
		{
			scrolltothedown(294, 735, 297, 532);
//			String GetText = driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText();

			try {
				if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()) 
				{
//					scrolltothedown(294, 735, 297, 532);
					System.out.println("Case Pass1");
				}

			}catch(Exception e) 
			{

				do 
				{
					scrolltothedown(294, 735, 297, 532);
					
					try 
					{
						if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
							System.out.println("Case Pass2");
							
					}catch(Exception e1) 
					{

						do 
						{
							scrolltothedown(294, 735, 297, 532);
							
							try 
							{
								if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
									System.out.println("Case Pass3");
									
							}catch(Exception e2) 
							{

								do 
								{
									scrolltothedown(294, 735, 297, 532);
									
									try 
									{
										if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
											System.out.println("Case Pass4");
											
									}catch(Exception e3) 
									{

										do 
										{
											scrolltothedown(294, 735, 297, 532);
											
											try 
											{
												if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
													System.out.println("Case Pass5");
													
											}catch(Exception e4) 
											{

												do 
												{
													scrolltothedown(294, 735, 297, 532);
													
													try 
													{
														if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
															System.out.println("Case Pass6");
															
													}catch(Exception e5) 
													{

														do 
														{
															scrolltothedown(294, 735, 297, 532);
															
															try 
															{
																if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
																	System.out.println("Case Pass7");
																	
															}catch(Exception e6) 
															{

																do 
																{
																	scrolltothedown(294, 735, 297, 532);
																	
																	try 
																	{
																		if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
																			System.out.println("Case Pass8");
																			
																	}catch(Exception e7) 
																	{

																		do 
																		{
																			scrolltothedown(294, 735, 297, 532);
																			
																			try 
																			{
																				if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
																					System.out.println("Case Pass9");
																					
																			}catch(Exception e8) 
																			{

																				do 
																				{
																					scrolltothedown(294, 735, 297, 532);
																					
																					try 
																					{
																						if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed()!=false)
																							System.out.println("Case Pass10");
																							
																					}catch(Exception e9) 
																					{


																						do 
																						{
																							scrolltothedown(294, 735, 297, 532);
																							
																							try 
																							{
																								if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																									System.out.println("Case Pass11");
																									
																							}catch(Exception e10) 
																							{


																								do 
																								{
																									scrolltothedown(294, 735, 297, 532);
																									
																									try 
																									{
																										if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																											System.out.println("Case Pass12");
																											
																									}catch(Exception e11) 
																									{


																										do 
																										{
																											scrolltothedown(294, 735, 297, 532);
																											
																											try 
																											{
																												if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																													System.out.println("Case Pass13");
																													
																											}catch(Exception e12) 
																											{


																												do 
																												{
																													scrolltothedown(294, 735, 297, 532);
																													
																													try 
																													{
																														if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																															System.out.println("Case Pass14");
																															
																													}catch(Exception e13) 
																													{


																														do 
																														{
																															scrolltothedown(294, 735, 297, 532);
																															
																															try 
																															{
																																if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																	System.out.println("Case Pass15");
																																	
																															}catch(Exception e14) 
																															{


																																do 
																																{
																																	scrolltothedown(294, 735, 297, 532);
																																	
																																	try 
																																	{
																																		if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																			System.out.println("Case Pass16");
																																			
																																	}catch(Exception e15) 
																																	{


																																		do 
																																		{
																																			scrolltothedown(294, 735, 297, 532);
																																			
																																			try 
																																			{
																																				if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																					System.out.println("Case Pass17");
																																					
																																			}catch(Exception e16) 
																																			{


																																				do 
																																				{
																																					scrolltothedown(294, 735, 297, 532);
																																					
																																					try 
																																					{
																																						if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																							System.out.println("Case Pass18");
																																							
																																					}catch(Exception e17) 
																																					{


																																						do 
																																						{
																																							scrolltothedown(294, 735, 297, 532);
																																							
																																							try 
																																							{
																																								if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																									System.out.println("Case Pass19");
																																									
																																							}catch(Exception e18) 
																																							{


																																								do 
																																								{
																																									scrolltothedown(294, 735, 297, 532);
																																									
																																									try 
																																									{
																																										if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																											System.out.println("Case Pass20");
																																											
																																									}catch(Exception e19) 
																																									{


																																										do 
																																										{
																																											scrolltothedown(294, 735, 297, 532);
																																											
																																											try 
																																											{
																																												if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																													System.out.println("Case Pass21");
																																													
																																											}catch(Exception e20) 
																																											{


																																												do 
																																												{
																																													scrolltothedown(294, 735, 297, 532);
																																													
																																													try 
																																													{
																																														if(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed())
																																															System.out.println("Case Pass22");
																																															
																																													}catch(Exception e21) 
																																													{
																																														e1.printStackTrace();
																																													}
																																													
																																												}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																											
																																											}
																																											
																																										}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																									
																																									}
																																									
																																								}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																							
																																							}
																																							
																																						}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																					
																																					}
																																					
																																				}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																			
																																			}
																																			
																																		}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																	
																																	}
																																	
																																}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																															
																															}
																															
																														}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																													
																													}
																													
																												}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																											
																											}
																											
																										}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																									
																									}
																									
																								}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																							
																							}
																							
																						}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																					
																					}
																					
																				}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																			}
																			
																		}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																	}
																	
																}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
															}
															
														}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
													}
													
												}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
											}
											
										}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
									}
									
								}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
							}
							
						}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
					}
					
				}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
			}
			
			System.out.println("Outside of the catch block");



		}while(driver.findElement(By.xpath("(//*[@text='"+ExactLastText+"'])[last()]")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText().equals(ExactText)


		System.err.println("Outside of the do block");
	
	
	}
	
	public void ScrollTop24(String ExactText) throws InterruptedException 
	{


		
		do 
		{
			scrolltothedown(297, 532, 294, 735);//294, 735, 297, 532
//			String GetText = driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText();

			try {
				if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()) 
				{
//					scrolltothedown(294, 735, 297, 532);
					System.out.println("Case Pass1");
				}

			}catch(Exception e) 
			{

				do 
				{
					scrolltothedown(297, 532, 294, 735);
					
					try 
					{
						if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
							System.out.println("Case Pass2");
							
					}catch(Exception e1) 
					{

						do 
						{
							scrolltothedown(297, 532, 294, 735);
							
							try 
							{
								if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
									System.out.println("Case Pass3");
									
							}catch(Exception e2) 
							{

								do 
								{
									scrolltothedown(297, 532, 294, 735);
									
									try 
									{
										if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
											System.out.println("Case Pass4");
											
									}catch(Exception e3) 
									{

										do 
										{
											scrolltothedown(297, 532, 294, 735);
											
											try 
											{
												if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
													System.out.println("Case Pass5");
													
											}catch(Exception e4) 
											{

												do 
												{
													scrolltothedown(297, 532, 294, 735);
													
													try 
													{
														if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
															System.out.println("Case Pass6");
															
													}catch(Exception e5) 
													{

														do 
														{
															scrolltothedown(297, 532, 294, 735);
															
															try 
															{
																if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																	System.out.println("Case Pass7");
																	
															}catch(Exception e6) 
															{

																do 
																{
																	scrolltothedown(297, 532, 294, 735);
																	
																	try 
																	{
																		if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																			System.out.println("Case Pass8");
																			
																	}catch(Exception e7) 
																	{

																		do 
																		{
																			scrolltothedown(297, 532, 294, 735);
																			
																			try 
																			{
																				if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																					System.out.println("Case Pass9");
																					
																			}catch(Exception e8) 
																			{

																				do 
																				{
																					scrolltothedown(297, 532, 294, 735);
																					
																					try 
																					{
																						if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed()!=false)
																							System.out.println("Case Pass10");
																							
																					}catch(Exception e9) 
																					{


																						do 
																						{
																							scrolltothedown(297, 532, 294, 735);
																							
																							try 
																							{
																								if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																									System.out.println("Case Pass11");
																									
																							}catch(Exception e10) 
																							{


																								do 
																								{
																									scrolltothedown(297, 532, 294, 735);
																									
																									try 
																									{
																										if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																											System.out.println("Case Pass12");
																											
																									}catch(Exception e11) 
																									{


																										do 
																										{
																											scrolltothedown(297, 532, 294, 735);
																											
																											try 
																											{
																												if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																													System.out.println("Case Pass13");
																													
																											}catch(Exception e12) 
																											{


																												do 
																												{
																													scrolltothedown(297, 532, 294, 735);
																													
																													try 
																													{
																														if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																															System.out.println("Case Pass14");
																															
																													}catch(Exception e13) 
																													{


																														do 
																														{
																															scrolltothedown(297, 532, 294, 735);
																															
																															try 
																															{
																																if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																	System.out.println("Case Pass15");
																																	
																															}catch(Exception e14) 
																															{


																																do 
																																{
																																	scrolltothedown(297, 532, 294, 735);
																																	
																																	try 
																																	{
																																		if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																			System.out.println("Case Pass16");
																																			
																																	}catch(Exception e15) 
																																	{


																																		do 
																																		{
																																			scrolltothedown(297, 532, 294, 735);
																																			
																																			try 
																																			{
																																				if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																					System.out.println("Case Pass17");
																																					
																																			}catch(Exception e16) 
																																			{


																																				do 
																																				{
																																					scrolltothedown(297, 532, 294, 735);
																																					
																																					try 
																																					{
																																						if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																							System.out.println("Case Pass18");
																																							
																																					}catch(Exception e17) 
																																					{


																																						do 
																																						{
																																							scrolltothedown(297, 532, 294, 735);
																																							
																																							try 
																																							{
																																								if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																									System.out.println("Case Pass19");
																																									
																																							}catch(Exception e18) 
																																							{


																																								do 
																																								{
																																									scrolltothedown(297, 532, 294, 735);
																																									
																																									try 
																																									{
																																										if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																											System.out.println("Case Pass20");
																																											
																																									}catch(Exception e19) 
																																									{


																																										do 
																																										{
																																											scrolltothedown(297, 532, 294, 735);
																																											
																																											try 
																																											{
																																												if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																													System.out.println("Case Pass21");
																																													
																																											}catch(Exception e20) 
																																											{


																																												do 
																																												{
																																													scrolltothedown(297, 532, 294, 735);
																																													
																																													try 
																																													{
																																														if(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed())
																																															System.out.println("Case Pass22");
																																															
																																													}catch(Exception e21) 
																																													{
																																														e1.printStackTrace();
																																													}
																																													
																																												}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																											
																																											}
																																											
																																										}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																									
																																									}
																																									
																																								}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																							
																																							}
																																							
																																						}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																					
																																					}
																																					
																																				}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																			
																																			}
																																			
																																		}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																																	
																																	}
																																	
																																}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																															
																															}
																															
																														}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																													
																													}
																													
																												}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																											
																											}
																											
																										}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																									
																									}
																									
																								}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																							
																							}
																							
																						}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																					
																					}
																					
																				}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																			}
																			
																		}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
																	}
																	
																}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
															}
															
														}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
													}
													
												}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
											}
											
										}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
									}
									
								}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
							}
							
						}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
					}
					
				}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true
			}
			
			System.out.println("Outside of the catch block");



		}while(driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).isDisplayed() != true);//driver.findElement(By.xpath("//*[@text='"+ExactText+"']")).getText().equals(ExactText)


		System.err.println("Outside of the do block");
	
	
	}
	

	public void SwitchToStockRoom() throws MalformedURLException 
	{

		DesiredCapabilities caps2 = new DesiredCapabilities();
		caps2.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps2.setCapability(MobileCapabilityType.VERSION, "9");
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Star_Android");
		caps2.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		//caps.setCapability(MobileCapabilityType.UDID, "ZF62248MWJ"); 
		caps2.setCapability(MobileCapabilityType.UDID, udid);//jrd6hmy5mzhihihu  192.168.100.93:5555
		//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps2.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		caps2.setCapability(MobileCapabilityType.NO_RESET, true);
		caps2.setCapability("automationName", "UiAutomator2");//UiAutomator2  espresso
		caps2.setCapability(MobileCapabilityType.APPLICATION_NAME, "Stock room");
		caps2.setCapability("clearDeviceLogsOnStart", true);
		caps2.setCapability("appPackage", "warehouse.commusoft.com.commusoftwarehouse");
		caps2.setCapability("appActivity", "warehouse.commusoft.com.commusoftwarehouse.V2.MainActivityV2");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps2);
	
	}
	
	public void SwitchToV4() throws MalformedURLException 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.VERSION, "9");
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Star_Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		//caps.setCapability(MobileCapabilityType.UDID, "ZF62248MWJ"); 
		caps.setCapability(MobileCapabilityType.UDID, udid);//jrd6hmy5mzhihihu  192.168.100.93:5555
		//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability("automationName", "UiAutomator2");//UiAutomator2  espresso
		caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft");
		caps.setCapability("clearDeviceLogsOnStart", true);
		caps.setCapability("appPackage", "com.commusoft.v4"); //-----> Live pointed 
		
//		caps.setCapability("appPackage", "com.commusoft.v4.couchdb"); //-------> Stage build
//		caps.setCapability("appPackage", "com.commusoft.v4.dev");//--------> Dev build
		caps.setCapability("appActivity", "com.commusoft.v4.Setup.Activities.SplashScreen");// appActivity  com.commusoft.v4.Setup.Activities.SplashScreen
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}
	
	public void SwitchToGmailApp() throws MalformedURLException 
	{
		DesiredCapabilities caps2 = new DesiredCapabilities();
		caps2.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps2.setCapability(MobileCapabilityType.VERSION, "9");
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Star_Android");
		caps2.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		//caps.setCapability(MobileCapabilityType.UDID, "ZF62248MWJ"); 
		caps2.setCapability(MobileCapabilityType.UDID, udid);//jrd6hmy5mzhihihu  192.168.100.93:5555
		//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps2.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		caps2.setCapability(MobileCapabilityType.NO_RESET, true);
		caps2.setCapability("automationName", "UiAutomator2");//UiAutomator2  espresso
		caps2.setCapability(MobileCapabilityType.APPLICATION_NAME, "Stock room");
		caps2.setCapability("clearDeviceLogsOnStart", true);
		caps2.setCapability("appPackage", "com.google.android.gm");
		caps2.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps2);
	}
	
	
	public void SwitchToStockWarehouseApp() 
	{
		ThreeSec();
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","warehouse.commusoft.com.commusoftwarehouse/warehouse.commusoft.com.commusoftwarehouse.V2.MainActivityV2"));
		                                                                        

	}
	public void SwitchToV4App() 
	{
		ThreeSec();
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","com.commusoft.v4/com.commusoft.v4.Setup.Activities.SplashScreen"));
	}

	public void SwitchToMail() 
	{

		ThreeSec();
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","com.google.android.gm/com.google.android.gm.ConversationListActivityGmail"));
	
	}
	
	
	public void Click_MenuClosed_BackButton() 
	{
//		FourSec();
		OneSec();
		try 
		{
			if(driver.findElement(By.xpath("//*[@content-desc='Menu closed']")).isDisplayed())
				ActionClick("//*[@content-desc='Menu closed']");
			
		}catch(Exception e) 
		{
			System.out.println("Menu Closed Button Is Not Displayed");
		}
	}

	public void Click_NavigateUp_BackButton() 
	{
//		FiveSec();
		OneSec();
		try 
		{
			if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed()) 
			{
				ActionClick("//*[@content-desc='Navigate up']");
				


				
				boolean navigateup1 = driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed();
				do 
				{
//					ThreeSec();
					ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
					driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).click();
					
					try 
					{
						
						if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
							ActionClick("//*[@content-desc='Navigate up']");
						
					}catch(Exception e13) 
					{
						do 
						{
//							TwoSec();
							ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
							ActionClick("//*[@content-desc='Navigate up']");
							try 
							{
								if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
									ActionClick("//*[@content-desc='Navigate up']");
							}catch(Exception e1) 
							{

								do 
								{
//									TwoSec();
									ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
									ActionClick("//*[@content-desc='Navigate up']");
									try 
									{
										if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
											ActionClick("//*[@content-desc='Navigate up']");
									}catch(Exception e2) 
									{
										do 
										{
//											TwoSec();
											ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
											ActionClick("//*[@content-desc='Navigate up']");
											try 
											{
												if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
													ActionClick("//*[@content-desc='Navigate up']");
											}catch(Exception e3) 
											{

												do 
												{
//													TwoSec();
													ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
													ActionClick("//*[@content-desc='Navigate up']");
													try 
													{
														if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
															ActionClick("//*[@content-desc='Navigate up']");
													}catch(Exception e4) 
													{
														do 
														{
//															TwoSec();
															ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
															ActionClick("//*[@content-desc='Navigate up']");
															try 
															{
																if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
																	ActionClick("//*[@content-desc='Navigate up']");
															}catch(Exception e5) 
															{

																do 
																{
//																	TwoSec();
																	ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
																	ActionClick("//*[@content-desc='Navigate up']");
																	try 
																	{
																		if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
																			ActionClick("//*[@content-desc='Navigate up']");
																	}catch(Exception e6) 
																	{
																		do 
																		{
//																			TwoSec();
																			ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
																			ActionClick("//*[@content-desc='Navigate up']");
																			try 
																			{
																				if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
																					ActionClick("//*[@content-desc='Navigate up']");
																			}catch(Exception e7) 
																			{

																				do 
																				{
//																					TwoSec();
																					ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
																					ActionClick("//*[@content-desc='Navigate up']");
																					try 
																					{
																						if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
																							ActionClick("//*[@content-desc='Navigate up']");
																					}catch(Exception e8) 
																					{
																						do 
																						{
//																							TwoSec();
																							ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
																							ActionClick("//*[@content-desc='Navigate up']");
																							try 
																							{
																								if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
																									ActionClick("//*[@content-desc='Navigate up']");
																							}catch(Exception e9) 
																							{

																								do 
																								{
//																									TwoSec();
																									ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
																									ActionClick("//*[@content-desc='Navigate up']");
																									try 
																									{
																										if(driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed())
																											ActionClick("//*[@content-desc='Navigate up']");
																									}catch(Exception e10) 
																									{
																										
																									}
																									
																								}while(navigateup1!=true);
																							
																							}
																							
																						}while(navigateup1!=true);
																					}
																					
																				}while(navigateup1!=true);
																			
																			}
																			
																		}while(navigateup1!=true);
																	}
																	
																}while(navigateup1!=true);
															
															}
															
														}while(navigateup1!=true);
													}
													
												}while(navigateup1!=true);
											
											}
											
										}while(navigateup1!=true);
									}
									
								}while(navigateup1!=true);
							
							}
							
						}while(navigateup1!=true);
					}
					
				}while(navigateup1!=true);//!(navigateup.equals(navigateup1)) , navigateup1=true
				
			
				
			
			
				
			}
				
			
		}catch(Exception e) 
		{
			
			System.out.println("Now the navigate up button is not displayed");
		}
	}

	
	public void ActionClick(String xpath) 
	{
		Actions actions = new Actions(driver);
		MobileElement findElement = driver.findElement(By.xpath(xpath));
		actions.moveToElement(findElement).click(findElement).build().perform();
	}
	
	public void DoubleClick(String xpath) 
	{
		Actions actions = new Actions(driver);
		MobileElement findElement = driver.findElement(By.xpath(xpath));
		actions.doubleClick(findElement).build().perform();
	}

	public void JavaScriptClick(String xpath) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		MobileElement findElement = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].click",findElement);
	}
	
	public void Navigate_Home() 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
	}

	public void OpenChrome(String url) 
	{
		WebDriverManager.chromedriver().setup();
//		 chromeDriver = new ChromeDriver();
//		chromeDriver.get(url);
//		chromeDriver.manage().window().maximize();
//		chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
//		Set<String> contextNames = driver.getContextHandles();
//		for (String contextName : contextNames) {
//		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
//		}
////		driver.context(contextNames.toArray()[1]);
//		driver.context("NATIVE_APP");
	}
	
//	public void WebScroll(String xpath) 
//	{
//		JavascriptExecutor js=(JavascriptExecutor)driverWeb;
//		WebElement findElement = driver.findElement(By.xpath(xpath));
//		js.executeScript("arguments[0].scrollIntoView()",findElement);
//	}
	@FindBy(xpath="//android.widget.TextView[@text='Book event']")
	public WebElement Book_Event;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Menu opened\"]")
	public MobileElement Menu;

	//------------------------------------------------------------------------------------------------------
	
	
   

}

