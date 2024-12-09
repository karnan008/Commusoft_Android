package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OfficeTask_Mob extends Wrapper{
	
	public OfficeTask_Mob(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void OfficeTask() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Office task']");
		click("//android.widget.TextView[@text='Office task']");
		Thread.sleep(2000);
	}
	
	public void AssignTo() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@content-desc='Trailing icon'])[1]");
		click("(//*[@content-desc='Trailing icon'])[1]");
	}
	
	public void Select_AssignTo(String userName) 
	{
		
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		click("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", userName);
		ExplicitWait_ElementToBeClickable("(//*[@text='"+userName+"'])[2]");
		click("(//*[@text='"+userName+"'])[2]");
	}
	
	public void Description() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Description *']/following-sibling::*[@class='android.widget.EditText']");
		click("//*[@text='Description *']/following-sibling::*[@class='android.widget.EditText']");
		type("//*[@text='Description *']/following-sibling::*[@class='android.widget.EditText']", "Office notes");
	}
	
//	attached_Files.Click_Save();
	
	public void Verify_IncompleteTask() 
	{
		ExplicitWait_PresenceOfEle("//*[contains(@text,'Incomplete tasks')]");
		MobileElement incompleteTask = driver.findElement(By.xpath("//*[contains(@text,'Incomplete tasks')]"));
		Verify_AssertTrue(incompleteTask);
	}

	public void Swipe_OfficeTask()
	{
		TwoSec();
		Swipe(800, 500, 300, 500);
	}
	
	public void Verify_User(String userName) 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+userName+"']");
		MobileElement username = driver.findElement(By.xpath("//*[@text='"+userName+"']"));
		Verify_AssertTrue(username);
	
	}
	
	public void Click_OfficeTask(String userName) 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+userName+"']");
		click("//*[@text='"+userName+"']");
	}
//	reminder.Click_Edit();
	public void Edit_Des() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Description *']/following-sibling::*[@class='android.widget.EditText']");
		click("//*[@text='Description *']/following-sibling::*[@class='android.widget.EditText']");
		type("//*[@text='Description *']/following-sibling::*[@class='android.widget.EditText']", "Edit Office notes");
	
	}
	
	//attached_Files.Click_Save();
	

	public void Verify_Completed_OfficeTask() 
	{
		ExplicitWait_PresenceOfEle("//*[contains(@text,'Completed tasks')]");
		MobileElement completeStatus = driver.findElement(By.xpath("//*[contains(@text,'Completed tasks')]"));
		Verify_AssertTrueWeb(completeStatus);
	}
	
	public void OfficeTaskBack() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageView'][1]");
		click("//*[@class='android.widget.ImageView'][1]");
	}
	
	
}
