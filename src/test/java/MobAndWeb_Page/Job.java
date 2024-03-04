package MobAndWeb_Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.google.common.collect.ImmutableMap;

import MainPack.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Job extends Wrapper{
	
	public Job(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
//	estimate2.Diary();
//	estimate2.Fabicon();
	
	public void Click_Job() throws InterruptedException 
	{
		ThreeSec();
		clickpoint(943, 1534);
	}
	
//	estimate2.starttime();
//	estimate2.SelectStartTime();
//	estimate2.EndTime();
//	estimate2.SelectEndTime();
//	estimate2.SearchCustomer();
//	estimate2.SelectCustomer();
	
	public void JobDescription() 
	{                                                 
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/spinnerdescriptionValue']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerdescriptionValue']");
		ExplicitWait_PresenceOfEle("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
		
	}
	
	public void SaveJob() 
	{
		ThreeSec();
		click("//*[@resource-id='com.commusoft.v4:id/save']");
	}
//	estimate2.EstimateTravel();
//	estimate2.Diary_Accept();
	public void StoreJobNumber() 
	{
		                                                                                       
		ExplicitWait_PresenceOfEle("//*[@text='Job Number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']");
		jobnumber = driver.findElement(By.xpath("//*[@text='Job Number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']")).getText();
		System.setProperty("jobnumber", jobnumber);
		

		System.out.println("Job Number Is: "+jobnumber);
	}
	
//	estimate2.Diary_Travel();
//	estimate2.Diary_Arrive();
//	job2.Arrive_Question1();

	public void Next() //Next
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Next']");
		click("//*[@text='Next']");
	}
//	//signature(250, 1380, 550, 1220);
//	signature(310, 1248, 700, 1200);//simulator
	public void Finish() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/toolbar_next']");
		click("//*[@resource-id='com.commusoft.v4:id/toolbar_next']");
//		Thread.sleep(2000);
	}

	public void SearchJobByNumber() throws AWTException 
	{
//		FiveSec();

//		ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[7]");
//		click("(//*[@class='android.view.View'])[7]");
//		TwoSec();
//
//		Robot robot = new Robot();
//
//		jobnumber = System.getProperty("jobnumber");
//		String inputString = jobnumber;
//
//		char[] characters = inputString.toCharArray();
//
//		for (char c : characters) {
//			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
//			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
//				// Handle undefined key codes
//			} else {
//				robot.keyPress(keyCode);
//				robot.keyRelease(keyCode);
//			}
//		}
//
//		        
//
//		click("(//*[@class='android.widget.ImageView'])[1]"); 
		
		
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		jobnumber = System.getProperty("jobnumber");
		MobileElement num = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
		num.sendKeys(jobnumber);
		TouchAction touchAction = new TouchAction(driver);
		MobileElement element = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[1]"));
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();

		
	
	}
	
	
	
	public void SelectJob(String automationNewQuestionTemplate) 
	{
		
		
//		try 
//		{
//			ExplicitWait_ElementToBeClickable("//*[@text='Jobs']/following-sibling::*[1]");
//			click("//*[@text='Jobs']/following-sibling::*[1]");
//		}catch(Exception e) 
//		{
//			ExplicitWait_ElementToBeClickable("//*[@text='Jobs']/preceding-sibling::*[1]");
//			click("//*[@text='Jobs']/preceding-sibling::*[1]");
//		}
		
		ExplicitWait_ElementToBeClickable("//*[@text='"+automationNewQuestionTemplate+"']");
		
		click("//*[@text='"+automationNewQuestionTemplate+"']");
	}
	
	
}
