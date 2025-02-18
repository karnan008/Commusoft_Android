package MobAndWeb_Page;

import java.awt.AWTException;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
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

		ExplicitWait_PresenceOfEle("//*[@text='Job number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']");
		jobnumber = driver.findElement(By.xpath("//*[@text='Job number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']")).getText();
		System.setProperty("jobnumber", jobnumber);


		System.out.println("Job Number Is: "+jobnumber);
	}

	public void StoreJobNumber_CustomerOnGoing() 
	{

		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/jobnumber']");
		jobnumber = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/jobnumber']")).getText();
		System.setProperty("jobnumber", jobnumber);


		System.out.println("Job Number Is: "+jobnumber);
	}

	//	estimate2.Diary_Travel();
	//	estimate2.Diary_Arrive();
	//	job2.Arrive_Question1();

	public void Next() //Next
	{

		try 
		{


			ExplicitWait_ElementToBeClickable("//*[@text='Next']");
			click("//*[@text='Next']");
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
			click("//*[@resource-id='com.commusoft.v4:id/save']");
		}
	}
	//	//signature(250, 1380, 550, 1220);
	//	signature(310, 1248, 700, 1200);//simulator
	public void Finish() throws InterruptedException
	{

		try 
		{

//			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
//			click("//*[@resource-id='com.commusoft.v4:id/save']");
			ExplicitWait_ElementToBeClickable("//*[@text='Save']");
			click("//*[@text='Save']");
			
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/toolbar_next']");
			click("//*[@resource-id='com.commusoft.v4:id/toolbar_next']");
		}

		//		Thread.sleep(2000);
	}

	public void SearchJobByNumber() throws AWTException, InterruptedException 
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
		Thread.sleep(2000);
		TouchAction touchAction = new TouchAction(driver);
		MobileElement element = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[1]"));
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();



	}

	public void SearchJobByNumberDemo() 
	{
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		MobileElement num = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
		num.sendKeys("8699");

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


	public void Job_DiaryName(String abort) 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
		type("//*[@resource-id='com.commusoft.v4:id/descriptionValue']", abort);
	}

	public void NoAccess() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='No access']");
		click("//*[@text='No access']");
	}

	public void NoAccess_FeedBack() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/feedback']");
		type("//*[@resource-id='com.commusoft.v4:id/feedback']", "No access to the customer");
	}
	public void Abort_Or_Complete_Job() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Job Number']");
		String pageSource = driver.getPageSource();

		if(pageSource.contains("//*[@text='Abort job']")) {
			ExplicitWait_ElementToBeClickable("//*[@text='Abort job']");
			click("//*[@text='Abort job']");
			ExplicitWait_ElementToBeClickable("//*[@text='Tap To Select. . .']");
			click("//*[@text='Tap To Select. . .']");
			ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
			click("(//*[@resource-id='android:id/text1'])[2]");
			ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
			click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
			ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageButton']");
			click("//*[@class='android.widget.ImageButton']");
		}
		else if(pageSource.contains("//*[contains(@text,'Tap on the green bar for further actions')]"))	{
			click("//*[contains(@text,'Tap on the green bar for further actions')]");
			ExplicitWait_ElementToBeClickable("//*[@text='Free of charge job']");
			click("//*[@text='Free of charge job']");
			ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Spinner']");
			click("//*[@class='android.widget.Spinner']");
			ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
			click("(//*[@resource-id='android:id/text1'])[2]");
			ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
			click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");

		}
	}

	public void JobAssets()
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Job assets']");
		click("//*[@text='Job assets']");
	}

	public void CompleteJob()
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Complete job']");
		click("//*[@text='Complete job']");
	}

}
