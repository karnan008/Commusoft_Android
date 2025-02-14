package MobAndWeb_Page;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EstimateReject extends Wrapper{
	
	public EstimateReject(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
//	estimate2.Diary();
//	estimate2.Fabicon();
//	estimate2.Click_Estimate();
//	estimate2.starttime();
	
	public void SelectStartTime() throws InterruptedException 
	{
//		ExplicitWait_PresenceOfEle("//*[@text='CANCEL']");
//		clickpoint(275, 1189);//hour
////		ThreeSec();
//		ExplicitWait_PresenceOfEle("//*[@text='9']");
//		clickpoint(804,1185);//minutes
////		TwoSec();
//		click("//*[@text='OK']");
		
	}
//	estimate2.EndTime();
	
	public void SelectEndTime() throws InterruptedException 
	{
//		ExplicitWait_PresenceOfEle("//*[@text='CANCEL']");
//		clickpoint(275, 1189);//hour
////		ThreeSec();
//		ExplicitWait_PresenceOfEle("//*[@text='9']");
//		clickpoint(534,1445);//minutes
////		TwoSec();
//		click("//*[@text='OK']");
	}
//	estimate2.SearchCustomer();
//	estimate2.SelectCustomer();
//	estimate2.EstimateDescription();
//	estimate2.SaveEstimate();
//	estimate2.EstimateTravel();
	
	public void Reject() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/statustexttwo']");
		click("//*[@resource-id='com.commusoft.v4:id/statustexttwo']");
	}
	
	public void Abort() 
	{

		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/statustexttwo']");
		click("//*[@resource-id='com.commusoft.v4:id/statustexttwo']");
	
	}
	
	public void Reject_FeedbackReason() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/feedback']");
		type("//*[@resource-id='com.commusoft.v4:id/feedback']", "Reject Estimate Automation");
	}
	
	public void Abort_FeedbackReason() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/feedback']");
		type("//*[@resource-id='com.commusoft.v4:id/feedback']", "Abort Estimate Automation");
	}
	
//	estimate.save();

}
