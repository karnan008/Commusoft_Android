package Pages;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PickUpParts extends Wrapper{
	
	public PickUpParts(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void Settings() throws InterruptedException 
	{
		TwoSec();
		ScrollDown24("Settings");
		click("(//*[@text='Settings'])[2]");
	}
	
	public void Enable_NewLayout() 
	{
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.Switch']");
		click("//*[@class='android.widget.Switch']");
	}
	public void Select_Yes_ForEnableNewLayout() //Yes
	{
		ExplicitWait_PresenceOfEle("//*[@text='Yes']");
		click("//*[@text='Yes']");
	}
	
	public void SearchTab() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/nav_search']");
		click("//*[@resource-id='com.commusoft.v4:id/nav_search']");
		
	}
	
	
	
	
	
	
	
	public void Click_Customer() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Properties']/following-sibling::*[@class='android.view.View'][1]");
		click("//*[@text='Properties']/following-sibling::*[@class='android.view.View'][1]");
	}
	
	
	public void DiaryTab() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/nav_diary']");
		click("//*[@resource-id='com.commusoft.v4:id/nav_diary']");
		
	}
	public void FabIcon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
		click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
	}
	public void CreateNewJobInNewUi() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/createNormalJob']");
	    click("//*[@resource-id='com.commusoft.v4:id/createNormalJob']");
	}
	public void SelectStartTime() //
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/start_time']");
		click("//*[@resource-id='com.commusoft.v4:id/start_time']");//com.commusoft.v4:id/start_time
		ExplicitWait_ElementToBeClickable("//*[@text='PM']");
		click("//*[@text='PM']");//PM
		ExplicitWait_ElementToBeClickable("//*[@text='OK']");
	    click("//*[@text='OK']");//OK
	
	}
	public void SelectEndTime() //
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/end_time']");
		click("//*[@resource-id='com.commusoft.v4:id/end_time']");//com.commusoft.v4:id/start_time
		ExplicitWait_ElementToBeClickable("//*[@text='PM']");
		click("//*[@text='PM']");//PM
		ExplicitWait_ElementToBeClickable("//*[@text='OK']");
	    click("//*[@text='OK']");//OK
	
	}
	public void Search_CustomerNumber() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", customernumber);
	}
	public void Pass_CustomerNumberInNewUi(String passcustomernumber) 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
//		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", editname+" "+surname);
//		click("//*[@resource-id='com.commusoft.v4:id/searchText']");
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", passcustomernumber);
	}
	
	public void Click_SearchButton() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/searchButtonView']");
		click("//*[@resource-id='com.commusoft.v4:id/searchButtonView']");
	}
	
//	add_Notes.Click_Cus(EditName, Surname);

	public void Select_EventDes() throws InterruptedException //com.commusoft.v4:id/spinnerdescriptionValue
	{
		ScrollDown24("Additional Information");
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerdescriptionValue']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerdescriptionValue']");
		
	}
//	job.Job_Des();
//	job.Click_Tick();
	
	
}
