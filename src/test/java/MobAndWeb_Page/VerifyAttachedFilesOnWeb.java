package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.WrapperForWeb;
import io.appium.java_client.MobileElement;

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
	
	public void VerifyFilesOnWeb() 
	{
		ExplicitWait_PresenceOfEle2("(//tbody/tr[@class='odd'])[1]");
	
		
		WebElement file1 = driverWeb.findElement(By.xpath("(//tbody/tr[@class='odd'])[1]"));
		Verify_AssertTrueWeb(file1);
		WebElement file2 = driverWeb.findElement(By.xpath("(//tbody/tr[@class='even'])[1]"));
		Verify_AssertTrueWeb(file2);
		WebElement file3 = driverWeb.findElement(By.xpath("(//tbody/tr[@class='odd'])[2]"));
		Verify_AssertTrueWeb(file3);
		WebElement file4 = driverWeb.findElement(By.xpath("(//tbody/tr[@class='even'])[2]"));
		Verify_AssertTrueWeb(file4);
		WebElement file5 = driverWeb.findElement(By.xpath("(//tbody/tr[@class='odd'])[3]"));
		Verify_AssertTrueWeb(file5);
	}
	
	
}
