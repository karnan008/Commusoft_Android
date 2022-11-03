package action;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utility.AppDriver;

public class Wrapper 
{

	public AndroidDriver<MobileElement> driver;
	
	
//	public Wrapper()
//	{
//		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
//	}

	public void type(String xpath, String value)
	{
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
	}

	public void click(String option)
	{
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
	public void MobileEnter() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
		Thread.sleep(12000);
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
	public void scrolltothetop(int x, int y, int x1, int y1) throws InterruptedException
	{
		Thread.sleep(3000);
		(new TouchAction(driver)).press(PointOption.point(x,y))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(x1,y1)).release().perform();
		Thread.sleep(2000);
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
		Thread.sleep(1000);
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
	
	
	
	
	
	









	@FindBy(xpath="//android.widget.TextView[@text='Book event']")
	public WebElement Book_Event;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Menu opened\"]")
	public MobileElement Menu;


}
