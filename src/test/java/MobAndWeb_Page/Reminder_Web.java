package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;

public class Reminder_Web extends Wrapper{
	
	public Reminder_Web(WebDriver sdriver) 
	{
		this.driverWeb = sdriver;
	}

	public void Click_Reminder() 
	{
		ExplicitWait_ElementToBeClickable2("(//span[text()='Reminders'])[1]");
		Webclick("(//span[text()='Reminders'])[1]");	
	}
	
	public void Verify_Reminder(String user_name) //td[text()='Saravanan S']
	{
		ExplicitWait_PresenceOfEle2("//td[text()='"+user_name+"']");
		System.out.println("User name is: "+user_name);
		WebElement reminderWeb = driverWeb.findElement(By.xpath("//td[text()='"+user_name+"']"));
		Verify_AssertTrueWeb(reminderWeb);
	}
}
