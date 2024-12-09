package Pages;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Rebook_Event extends Wrapper{
	
	public Rebook_Event(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void Click_Fabicon_InDiaryScreen() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
		click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
	}
	
	public void Click_RebookEvent() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Rebook event']");
		click("//*[@text='Rebook event']");
	}
	public void Search_Estimate() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", estimatenumber);
		TwoSec();
	}
	public void Click_SearchButton() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/searchButtonView']");
		click("//*[@resource-id='com.commusoft.v4:id/searchButtonView']");
		
		
	}

	
	public void Click_AbortedEstimate() throws InterruptedException 
	{
		ScrollDown24("Estimate"+" "+estimatenumber);
		ExplicitWait_ElementToBeClickable("//*[@text='Estimate "+estimatenumber+"']");
		click("//*[@text='Estimate "+estimatenumber+"']");

	}
//	scrolltothetop(500,500,500,2400);
//	doubleclickpoint(252,1465);
//	estimate.Book_Event(1019, 849, 79, 856,205,1050);
//	estimate.Savebtn();
	
	public void Type_EstimateDes() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
		type("//*[@resource-id='com.commusoft.v4:id/descriptionValue']", "Rebook Estimate");
	}
	
	public void Search_JobNumber() 
	{
        ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", jobnumber);
		TwoSec();
	}
	
	public void PassJobNumber(String JobnUmber) 
	{
        ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", JobnUmber);
		TwoSec();
	}
	
	public void Click_AbortedJob() throws InterruptedException 
	{

		ScrollDown24("Job"+" "+jobnumber);
		ExplicitWait_ElementToBeClickable("//*[@text='Job "+jobnumber+"']");
		click("//*[@text='Job "+jobnumber+"']");

	
	}
	public void Dummy(String jadf) throws InterruptedException 
	{

		ScrollDown24("Job"+" "+jadf);
		ExplicitWait_ElementToBeClickable("//*[@text='Job "+jadf+"']");
		click("//*[@text='Job "+jadf+"']");

	
	}
	
	public void Type_JobDes() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
		type("//*[@resource-id='com.commusoft.v4:id/descriptionValue']", "Rebook Job");
	}
	
	public void ExceptionHandling_For_BookDiaryEvent(int x, int y) throws InterruptedException 
	{
		try 
		{
			if(driver.findElement(By.xpath("//*[@text='Book event']")).isDisplayed())
				System.out.println("Book Event Is Displayed");
			
		}catch(Exception e) 
		{
			clickpoint(x, y);
			
		}
	}
	
	

}
