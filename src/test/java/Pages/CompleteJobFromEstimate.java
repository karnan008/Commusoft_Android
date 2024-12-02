package Pages;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class CompleteJobFromEstimate extends Wrapper{
	
	public CompleteJobFromEstimate(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
//	
////	customer.Side_Menu(); 
////	customer.Customer_search();
//	
	public void Search_EstimateNumber() 
	{

		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
	
		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", estimatenumber);
		TwoSec();
		
	}
	public void PassEstimateNumber(String passestimatenumber) 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
		
		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", passestimatenumber);
		TwoSec();
	}
////	MobileEnter();
//	
////	ScrollTop24(Estimate);
//	
	public void Click_Estimate(String sur) //android.widget.LinearLayout
	{

//		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
//		click("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
////		
		
		
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/descriptionValue']/following-sibling::*[@text='"+sur+"']");
		click("//*[@resource-id='com.commusoft.v4:id/descriptionValue']/following-sibling::*[@text='"+sur+"']");

	}
	public void ViewJob() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Click here to view job']");
		click("//*[@text='Click here to view job']");
	}
//	
////	add_Notes.Click_Choc_MenuButton();
//	
	public void Click_Diaryhistory() //Diary history
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
		click("//*[@text='Diary history']");
	}
	public void Click_Fabicon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
		click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
	}
	public void Click_ImageButton() //com.commusoft.v4:id/addnewjobdiaryevent
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/addnewjobdiaryevent']");
		click("//*[@resource-id='com.commusoft.v4:id/addnewjobdiaryevent']");
	}
//	scrolltothetop(500,500,500,2400);
//	doubleclickpoint(171,564);
//	estimate.Book_Event(1019, 849, 79, 856,260,890);
//	estimate.Savebtn();
//	clickpoint(171,564);
	
	


}
