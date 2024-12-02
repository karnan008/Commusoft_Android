package MobAndWeb_Page;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DiaryHistory extends Wrapper{
	
	public DiaryHistory(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver = sdriver;
	}
	
	
	public void Diaryhistory() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
		click("//*[@text='Diary history']");
	}
	
//	add_Notes.Click_FabIcon_NewUI(); 
	
	public void SelectTime_Diary_DailyView() throws InterruptedException 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Daily']");
		
		clickpoint(500, 1000);
		
		OneSec();
		String pageSource = driver.getPageSource();
		if(pageSource.contains("Book event"))
			System.out.println("Book event displayed");
		else
			clickpoint(500, 1000);
	}
	
	public void BookEvent() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Book event']");
		click("//*[@text='Book event']");
	}
//	estimate2.starttime();
//	estimate2.SelectStartTime();
//	estimate2.EndTime();
//	estimate2.SelectEndTime();
//	job.SaveJob();
	
	public void Change_Daily_To_List() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Daily']");
		click("//*[@text='Daily']");
		ExplicitWait_PresenceOfEle("//*[@text='List']");
		click("//*[@text='List']");
	}
//	estimate2.EstimateTravel();
//	estimateReject.Reject();
//	estimateReject.Reject_FeedbackReason();
//	estimate.save();
//	Click_NavigateUp_BackButton();
//	Click_MenuClosed_BackButton();
	
	public void Select_Diary(String cancel) 
	{
		ExplicitWait_PresenceOfEle("//*[@text='"+cancel+"']");
		click("//*[@text='"+cancel+"']");
	}
	
	public void Cancel() 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.Button'])[1]");
		click("(//*[@class='android.widget.Button'])[1]");
	}
	
	public void CancelReason() 
	{
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", "Cancelled");
	}
	
	public void Back_DiaryHistory() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
		click("//*[@text='Diary history']");
	}
	
	public void Appointments_ViewAll() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='Appointment history']/following-sibling::*[contains(@text,'View all')])[1]");
		click("(//*[@text='Appointment history']/following-sibling::*[contains(@text,'View all')])[1]");
	}
	
	public void Verify_Rejected() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
		MobileElement reject = driver.findElement(By.xpath("//*[@text='Rejected']"));
		Verify_AssertTrue(reject);
	}
	public void Verify_Aborted() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
		MobileElement aborted = driver.findElement(By.xpath("//*[@text='Aborted']"));
		Verify_AssertTrue(aborted);
	}
	
	public void Verify_Cancelled() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
		MobileElement cancel = driver.findElement(By.xpath("//*[@text='Cancelled']"));
		Verify_AssertTrue(cancel);
	}
	
	public void Verify_NoAccess() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
		MobileElement noaccess = driver.findElement(By.xpath("//*[@text='No Access']"));
		Verify_AssertTrue(noaccess);
	}
	
	public void Verify_Left() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
		MobileElement left = driver.findElement(By.xpath("//*[@text='Left']"));
		Verify_AssertTrue(left);
	}
	
	
	//newui_CreateCustomerOnMob.Search_Tab();
//	editCustomerInWeb.SearchCustomer();
//	add_Notes.Click_Choc_MenuButton();
//	onGoingWork.CustomerOnGoing();
//	onGoingWork.Click_FirstJob();
	public void Remove_EngineerEvents() 
	{
		
	}
	
}
