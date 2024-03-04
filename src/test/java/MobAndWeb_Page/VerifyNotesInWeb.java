package MobAndWeb_Page;

import org.openqa.selenium.WebDriver;

import MainPack.WrapperForWeb;

public class VerifyNotesInWeb extends WrapperForWeb{
	
	public VerifyNotesInWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
//	editCustomerInWeb.SearchCustomer();
//	verifyCustomerOnWeb.ClickCustomer();
	
	public void CommunicationTab() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='Communications']");
	    Webclick("//span[text()='Communications']");	
	}
	
	
	public void VerifyNote(String note) 
	{
		WebTwoSec();
		ScrollWeb("//p[text()='"+note+"']");
		ExplicitWait_PresenceOfEle2("//p[text()='"+note+"']");
		AssertTrueWeb("//p[text()='"+note+"']");
	}
	
	public void VerifyPhoneCall(String noteforphonecall) 
	{
		WebTwoSec();
		ScrollWeb("//p[text()=' "+noteforphonecall+" ']");
		ExplicitWait_PresenceOfEle2("//p[text()=' "+noteforphonecall+" ']");
		AssertTrueWeb("//p[text()=' "+noteforphonecall+" ']");
	}
	
	public void VerifyEmail(String subjectforemail) 
	{
		WebTwoSec();
		ScrollWeb("//span[text()='"+subjectforemail+"']");
		ExplicitWait_PresenceOfEle2("//span[text()='"+subjectforemail+"']");
		AssertTrueWeb("//span[text()='"+subjectforemail+"']");
	}
	
	public void VerifySMS(String messageforsms) 
	{
		WebTwoSec();
		ScrollWeb("//p[text()='"+messageforsms+"']");
		ExplicitWait_PresenceOfEle2("//p[text()='"+messageforsms+"']");
		AssertTrueWeb("//p[text()='"+messageforsms+"']");
	}
	

}
