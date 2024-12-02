package MobAndWeb_Page;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Reminder_Mob extends Wrapper{
	
	private String reminder_Notes = "Reminder notes";
	private String edit_ReminderNotes = "Edit Reminder Notes";
	

	public Reminder_Mob(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver = sdriver;
	}

	
	
	public void Select_ReminderDate() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@content-desc='Trailing icon'])[1]");
		click("(//*[@content-desc='Trailing icon'])[1]");
		ExplicitWait_ElementToBeClickable("//*[@text='OK']");
		click("//*[@text='OK']");
	}

	public void Reminder_Note() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Note *']/following-sibling::*[@text='Tap to fill']");
		click("//*[@text='Note *']/following-sibling::*[@text='Tap to fill']");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", reminder_Notes);
		ExplicitWait_ElementToBeClickable("//*[@text='Done']");
		click("//*[@text='Done']");
	}

	public void SelectUser(String userName)// UserName
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='User *']/following-sibling::*)[1]");
		click("(//*[@text='User *']/following-sibling::*)[1]");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		click("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", userName);
		ExplicitWait_ElementToBeClickable("(//*[@text='"+userName+"'])[2]");
		click("(//*[@text='"+userName+"'])[2]");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Button']");
		click("//*[@class='android.widget.Button']");
	}

	public void Click_ReminderNotes()
	{
		OneSec();
		ExplicitWait_ElementToBeClickable("//*[@text='"+reminder_Notes+"']");
		click("//*[@text='"+reminder_Notes+"']");
	}

	public void Click_Edit() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
		click("//*[@text='Edit']");
	}

	public void EditDate() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@content-desc='Trailing icon'])[1]");
		click("(//*[@content-desc='Trailing icon'])[1]");
		LocalDate currentDate = LocalDate.now();
		String currentDay = String.valueOf(currentDate.getDayOfMonth());
		System.out.println("Current date is: " + currentDay);
		ExplicitWait_ElementToBeClickable("(//*[contains(@content-desc,'"+currentDay+"')]/following-sibling::*)[last()]");
		click("(//*[contains(@content-desc,'"+currentDay+"')]/following-sibling::*)[last()]");
		ExplicitWait_ElementToBeClickable("//*[@text='OK']");
		click("//*[@text='OK']");
	}
	
	public void EditNotes() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='Note *']/following-sibling::*)[1]");
		click("(//*[@text='Note *']/following-sibling::*)[1]");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", edit_ReminderNotes);
		ExplicitWait_ElementToBeClickable("//*[@text='Done']");
		click("//*[@text='Done']");
	}
	
	public void Swipe_ReminderNotes()
	{
		TwoSec();
		Swipe(800, 500, 300, 500);
	}
	
	public void Delete() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Delete']");
		click("//*[@text='Delete']");
	}

	public void ReminderBack() 
	{
		OneSec();
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageView'][1]");
		click("//*[@class='android.widget.ImageView'][1]");
	}

}
