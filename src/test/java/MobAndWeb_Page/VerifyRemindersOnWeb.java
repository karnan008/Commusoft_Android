package MobAndWeb_Page;

import org.openqa.selenium.WebDriver;

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
		ExplicitWait_ElementToBeClickable2("//span[text()='View']");
	    Webclick("//span[text()='View']");	
	}
	
	public void VerifyServiceReminder(String title, String webname,String editsurname)  {
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//td[text()='"+title+" "+webname+" "+editsurname+"']");
		AssertTrueWeb("//td[text()='"+title+" "+webname+" "+editsurname+"']");
	}

}
