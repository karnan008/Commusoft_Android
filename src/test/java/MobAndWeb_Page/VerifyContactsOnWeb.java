package MobAndWeb_Page;

import org.openqa.selenium.WebDriver;

import MainPack.WrapperForWeb;

public class VerifyContactsOnWeb extends WrapperForWeb{
	
	public VerifyContactsOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
//	editCustomerInWeb.SearchCustomer();
//	verifyCustomerOnWeb.ClickCustomer();
	public void ContactsTab() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='Contacts']");
	    Webclick("//span[text()='Contacts']");
	}
	
	public void VerifyContact(String title, String customercontact) //td[text()='Mr & Mrs Contact1']
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//td[text()='"+title+" "+customercontact+"']");
		AssertTrueWeb("//td[text()='"+title+" "+customercontact+"']");
	}
	
	

}
