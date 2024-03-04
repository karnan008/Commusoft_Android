package Pages;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Abort_Event extends Wrapper{
	
	public Abort_Event(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}
	
	
	public void Click_Abort() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Abort']");
		click("//*[@text='Abort']");
	}
	
	public void TypeFeedback() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/feedback']");
		type("//*[@resource-id='com.commusoft.v4:id/feedback']", "Abort Event");
	}
//	customer.Click_Tick();

}
