package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.WrapperForWeb;

public class VerifyRemindersOnWeb extends WrapperForWeb{
	
	public VerifyRemindersOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
//	editCustomerInWeb.SearchCustomer();
//	verifyCustomerOnWeb.ClickCustomer();
	
	public void ReminderTab() 
	{
		ExplicitWait_ElementToBeClickable2("//p[text()='Service reminders ']/span");
	    Webclick("//p[text()='Service reminders ']/span");	
	}
	
	public void VerifyServiceReminder()  
	{
		WebFiveSec();
		ExplicitWait_PresenceOfEle2("//button[text()=' Edit ']");		
		WebElement reminder = driverWeb.findElement(By.xpath("//button[text()=' Edit ']"));
		Verify_AssertTrueWeb(reminder);
		
	}

}
