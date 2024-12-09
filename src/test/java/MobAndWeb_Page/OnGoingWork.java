package MobAndWeb_Page;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OnGoingWork extends Wrapper{
	
	public OnGoingWork(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver = sdriver;
	}
	
	public void CustomerOnGoing() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='On going work']");
		click("//*[@text='On going work']");
	}
	
	public void FabIcon_OnGoing() 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageButton'])[2]");
		click("(//*[@class='android.widget.ImageButton'])[2]");
	}

	public void AddNewJob() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Add new job']");
		click("//*[@text='Add new job']");
	}
	
//	job.JobDescription();
//	job.SaveJob();
	
	public void Click_FirstJob() 
	{
		FourSec();
		ExplicitWait_PresenceOfEle("//*[contains(@text,'Job No:')]");
		click("//*[contains(@text,'Job No:')]");
	}
//	job.StoreJobNumber_CustomerOnGoing();
	
	public void Select_Job() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/typenoValue']");
		jobnumber = System.getProperty("jobnumber");
		MobileElement num = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/typenoValue']"));
		click("//*[@text='"+jobnumber+"']");
	}
}
