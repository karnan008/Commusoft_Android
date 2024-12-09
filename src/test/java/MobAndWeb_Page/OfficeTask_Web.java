package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;

public class OfficeTask_Web extends Wrapper{
	
	public OfficeTask_Web(WebDriver sdriver) 
	{
		this.driverWeb = sdriver;
	}
	
	public void Click_OfficeTask() 
	{
		ExplicitWait_ElementToBeClickable2("(//span[text()='Office Task'])[1]");
		Webclick("(//span[text()='Office Task'])[1]");	
	} 

	public void Verify_Username(String username) 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("(//span[text()='Saravanan S'])[2]");
		WebElement user_name = driverWeb.findElement(By.xpath("(//span[text()='Saravanan S'])[2]"));
		Verify_AssertTrueWeb(user_name);
	}

	public void CompleteOfficeTask() 
	{
		ExplicitWait_ElementToBeClickable2("//a[text()='Complete']");
		Webclick("//a[text()='Complete']");	
	}
	
	
	
}
