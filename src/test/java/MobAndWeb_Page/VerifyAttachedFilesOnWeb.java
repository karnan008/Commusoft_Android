package MobAndWeb_Page;

import org.openqa.selenium.WebDriver;

import MainPack.WrapperForWeb;

public class VerifyAttachedFilesOnWeb extends WrapperForWeb{
	
	public VerifyAttachedFilesOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}

//	editCustomerInWeb.SearchCustomer();
//	verifyCustomerOnWeb.ClickCustomer();
	
	public void FilesTab() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='Files']");
	    Webclick("//span[text()='Files']");	
	}
	
	public void VerifyPhotoFile(String photofilename) //td[text()='pic']
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//td[text()='"+photofilename+"']");
		AssertTrueWeb("//td[text()='"+photofilename+"']");
	}
	
	public void VerifyVideoFile(String videofilename) 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//td[text()='"+videofilename+"']");
		AssertTrueWeb("//td[text()='"+videofilename+"']");
	}
	
	
	
}
