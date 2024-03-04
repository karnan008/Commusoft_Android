package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.DoubleClickAction;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EnableNewUI extends Wrapper{
	
	public EnableNewUI(AndroidDriver<MobileElement> adriver) 
	{
		this.driver=adriver;
	}

	public void OpenSideMenu() 
	{
		try 
		{
			ExplicitWait_ElementToBeClickable("//*[@content-desc='Menu opened']");
			click("//*[@content-desc='Menu opened']");
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/iv_image']");
			click("//*[@resource-id='com.commusoft.v4:id/iv_image']");
			ExplicitWait_ElementToBeClickable("//*[@text='Lab']");
			click("//*[@text='Lab']");
			ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Switch']");
			click("//*[@class='android.widget.Switch']");
			ExplicitWait_ElementToBeClickable("//*[@text='Yes']");
			click("//*[@text='Yes']");
			
			//Open Side Menu
			ExplicitWait_ElementToBeClickable("//*[@content-desc='Menu opened']");
			click("//*[@content-desc='Menu opened']");
		}
	}
	public void OldSettings() throws InterruptedException 
	{

		ScrollDown24("Settings");
		ExplicitWait_ElementToBeClickable("(//*[@text='Settings'])[2]");
//		FiveSec();
		click("(//*[@text='Settings'])[2]");
	}
	
	public void EnableNewSetting() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Switch']");
		click("//*[@class='android.widget.Switch']");
	}
	
	public void Confirm_Yes() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Yes']");
		click("//*[@text='Yes']");
	}
	
	public void Verify_HomeTab() 
	{
		ExplicitWait_PresenceOfEle("//*[@content-desc='Home']");
		MobileElement findElement = driver.findElement(By.xpath("//*[@content-desc='Home']"));
		Verify_AssertTrue(findElement);
	}
	
	public void Verify_DiaryTab() 
	{
		ExplicitWait_PresenceOfEle("//*[@content-desc='Diary']");
		MobileElement findElement = driver.findElement(By.xpath("//*[@content-desc='Diary']"));
		Verify_AssertTrue(findElement);
	}
	
	public void Verify_SearchTab() 
	{
		ExplicitWait_PresenceOfEle("//*[@content-desc='Search']");
		MobileElement findElement = driver.findElement(By.xpath("//*[@content-desc='Search']"));
		Verify_AssertTrue(findElement);
	}
	
	public void Verify_MyVanTab() 
	{
		ExplicitWait_PresenceOfEle("//*[@content-desc='My Van']");
		MobileElement findElement = driver.findElement(By.xpath("//*[@content-desc='My Van']"));
		Verify_AssertTrue(findElement);
	}
	
	
}
