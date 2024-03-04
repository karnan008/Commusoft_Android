package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.util.RetryAnalyzerCount;

import MainPack.Wrapper;
import Utility.RerunTestCase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class VerifyAcceptEstimateOnWeb extends Wrapper{

	public VerifyAcceptEstimateOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}

	public void SearchEstimate() 
	{
		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		estimatenumber = System.getProperty("estimatenumber");
		//		typeForWeb("//input[@type='search']", customernumber);
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.clear();
		num.sendKeys(estimatenumber);

		WebThreeSec();
		num.sendKeys(Keys.ENTER);
	}

	public void Select_Estimate() 
	{
		ExplicitWait_ElementToBeClickable2("//th[text()='Estimate no']/following::a[1]");
		Webclick("//th[text()='Estimate no']/following::a[1]");
	}

	public void verify_EstimateAcceptedStatus() 
	{
		ExplicitWait_PresenceOfEle2("//strong[text()='This estimate has been accepted on the mobile by ']");
		AssertTrueWeb("//strong[text()='This estimate has been accepted on the mobile by ']");
	}

	public void verify_JobCovertionStatus() 
	{
		ExplicitWait_PresenceOfEle2("//strong[text()='The customer has accepted this estimate and it has been turned into a job']");
		AssertTrueWeb("//strong[text()='The customer has accepted this estimate and it has been turned into a job']");
	}
	public void verify_LeftStatus() //i[text()='Left']
	{
		ExplicitWait_PresenceOfEle2("//i[text()='Left']");
		AssertTrueWeb("//i[text()='Left']");
	}
	public void Notification_Logo() 
	{
		WebThreeSec();
		ExplicitWait_PresenceOfEle2("//a[@id='drop3']");
		Webclick("//a[@id='drop3']");
	}
	
	public void DemoRemoveNotification() 
	{
		
		demoClickWeb("//span[text()='Mark all notifications as complete']");
		
		String pageSource = driverWeb.getPageSource();
		if(pageSource.contains("confirmationText"))
		{
			demoTypeWeb("//input[@formcontrolname='confirmationText']", "Confirm");
			
		   
//			demoClickWeb("//button[text()='Confirm']");
		}
	    else {
	    	System.err.println("Notification already cleared");
	    }
	
		
	}
	public void SeeAllNotification() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='See all notifications']");
		Webclick("//span[text()='See all notifications']");
		
	}
	

	public void verify_AcceptedNotification() 
	{
		ExplicitWait_PresenceOfEle2("//td[contains(text(),'Estimate accepted')]");
		AssertTrueWeb("//td[contains(text(),'Estimate accepted')]");
	}
	public void verify_RejectedNotification() 
	{
		
	}
	public void RemoveNotification() 
	{
		WebThreeSec();

		
		
		ExplicitWait_PresenceOfEle2("//span[text()='Mark all notifications as complete']");
		Webclick("//span[text()='Mark all notifications as complete']");
		
		String pageSource = driverWeb.getPageSource();
		if(pageSource.contains("confirmationText"))
		{
			ExplicitWait_PresenceOfEle2("//input[@formcontrolname='confirmationText']");
			typeForWeb("//input[@formcontrolname='confirmationText']", "Confirm");
		    WebTwoSec();
		    ExplicitWait_PresenceOfEle2("//button[text()='Confirm']");
		    Webclick("//button[text()='Confirm']");
		}
	    else {
	    	System.err.println("Notification already cleared");
	    }
		
	}


	public void NotificationFabIcon() 
	{
		WebOneSec();
		PageRefresh();
		ExplicitWait_PresenceOfEle2("(//span[@class='preview-file-link actions-toggle ss-plus'])[1]");
		Webclick("(//span[@class='preview-file-link actions-toggle ss-plus'])[1]");
	}
	public void View() 
	{
		WebOneSec();
		ExplicitWait_PresenceOfEle2("(//button[text()=' View '])[1]");
		Webclick("(//button[text()=' View '])[1]");
	}
	public void ViewJob() 
	{
		WebOneSec();
		ExplicitWait_PresenceOfEle2("//span[text()=' View job ']");
		Webclick("//span[text()=' View job ']");
	}
	
}
