package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Diary extends Wrapper {
	
	
	
	
	public Diary(AndroidDriver<MobileElement> ldriver)
	{
		this.driver = ldriver;
	}
	public void Stat_Time(String time) throws InterruptedException
	{
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/start_time", time);
	}
	public void End_Time(String time) throws InterruptedException
	{
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/end_time", time);
	}
	public void Store_EstimateNumber() 
	{
		 estimatenumber = driver.findElement(By.xpath("//*[@text='Estimate number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']")).getText();
	    System.out.println("Estimate Number Is: "+estimatenumber);
	
//		return estimatenumber;
	  
		
		
	}
	
	public void Click_Back() 
	{
		ExplicitWait_ElementToBeClickable("//android.widget.ImageButton[@content-desc='Navigate up']");
		click("//android.widget.ImageButton[@content-desc='Navigate up']");
	}
	public void Diary_Accept() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Accept']");
		click("//*[@text='Accept']");//click accept
//		Thread.sleep(2000);
	}
	public void Diary_Travel() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Travel']");
		click("//*[@text='Travel']");//click trvel com.commusoft.v4:id/statusButton1
		Thread.sleep(2000);
	}
	public void Diary_Arrive() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Arrive']");
		click("//*[@text='Arrive']");//click arrive
		Thread.sleep(2000);
	}
	

	
	
//	customer.Side_Menu(); 
//	customer.Customer_search();
	
	public void Search_EstimateNumber() 
	{

		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", estimatenumber);
		
	
	}
//	MobileEnter();
	
//	ScrollTop24(Estimate);
	
	public void Click_Estimate() //android.widget.LinearLayout
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Estimate']/following-sibling::*[@class='android.widget.LinearLayout']");
		click("//*[@text='Estimate']/following-sibling::*[@class='android.widget.LinearLayout']");
	}
	public void ViewJob() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Click here to view job']");
		click("//*[@text='Click here to view job']");
	}
	
//	add_Notes.Click_Choc_MenuButton();
	
	public void Click_Diaryhistory() //Diary history
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
		click("//*[@text='Diary history']");
	}
	public void Click_Fabicon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='com.commusoft.v4:id/fab_expand_menu_button']");
		click("//*[@text='com.commusoft.v4:id/fab_expand_menu_button']");
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
