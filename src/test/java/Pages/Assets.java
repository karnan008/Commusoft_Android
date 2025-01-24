package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Assets extends Wrapper{
	
	public Assets(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void Click_Assets() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Assets']");
		click("//*[@text='Assets']");
	}
	
	public void Click_FabIcon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/addcustomer_asset']");
		click("//*[@resource-id='com.commusoft.v4:id/addcustomer_asset']");
	}
	
	public void Search_Asset(String assetname) //com.commusoft.v4:id/searchText
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", assetname);
	}
	
	public void Click_SystemBoiler() //System boiler
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='System boiler'])[2]");
		click("(//*[@text='System boiler'])[2]");
	}
	
	public void ScrollToCommissionedOn() //Commissioned on
	{
		FiveSec();
//		scroll(driver, "County");
		scroll(driver, "Commissioned on");
		FiveSec();
	}
	
	public void Click_TakePhoto()
	{
		
		ExplicitWait_ElementToBeClickable("//*[@text='TAKE PHOTO']");
		click("//*[@text='TAKE PHOTO']");
		
		
	}
	
	public void Select_TakePhoto_From_AlertPrompt() //Take photo
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Take photo']");
		click("//*[@text='Take photo']");
		

		ThreeSec();
		try 
		{
			if(driver.findElement(By.xpath("//*[@text='WHILE USING THE APP']")).isDisplayed()) 
			{
				click("//*[@text='WHILE USING THE APP']");
			}
			System.err.println("Try1");
			
			FiveSec();
			
			try 
			{
				if(driver.findElement(By.xpath("//*[@text='TAKE PHOTO']")).isDisplayed())
				{	
				   click("//*[@text='TAKE PHOTO']");
				   ExplicitWait_ElementToBeClickable("//*[@text='Take photo']");
				   click("//*[@text='Take photo']");
				}
				
				System.err.println("Try2");
				
			}catch(Exception e) 
			{
				System.out.println("Take Photo Button Is Not Displayed In That Page");
			}
			
			
			
		}catch(Exception e) 
		{
			System.out.println("Expected Element Is Not Appeared");
			
		}
	}
	public void Click_CenterButton_InCamera() //com.android.camera:id/shutter_button_horizontal
	{
		//com.google.android.GoogleCamera:id/shutter_button
		
		try 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
			click("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
			
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.google.android.GoogleCamera:id/shutter_button']");
			click("//*[@resource-id='com.google.android.GoogleCamera:id/shutter_button']");
		}
	}
	public void Click_Tick() //com.android.camera:id/done_button   com.google.android.GoogleCamera:id/shutter_button
	{
		
		
		try 
		{
			
				ExplicitWait_ElementToBeClickable("//*[@resource-id='com.android.camera:id/done_button']");
			    click("//*[@resource-id='com.android.camera:id/done_button']");
			    
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.google.android.GoogleCamera:id/shutter_button']");
		    click("//*[@resource-id='com.google.android.GoogleCamera:id/shutter_button']");
		}
	}
	//Scroll(driver, "Extinguisher Location")
	//Click_TakePhoto
	//Choose from camera roll
	public void Select_CameraRoll() //Choose from camera roll
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Choose from camera roll']");
		click("//*[@text='Choose from camera roll']");
	}
	
	public void Click_Gallery() //Gallery
	{
		
		
		try 
		{
//			if(driver.findElement(By.xpath("//*[@text='Gallery']")).isDisplayed())
				ExplicitWait_ElementToBeClickable("//*[@text='Gallery']");
			    click("//*[@text='Gallery']");
			
		}catch(Exception e) 
		{
			System.out.println("Gallery not appeared");
		}
	}
	
	public void Select_Pic_FromGallery() //com.miui.gallery:id/micro_thumb  com.commusoft.v4:id/save
	{
		
		try 
		{
//			if(driver.findElement(By.xpath("(//*[@resource-id='com.miui.gallery:id/micro_thumb'])[1]")).isDisplayed())
				ExplicitWait_ElementToBeClickable("(//*[@resource-id='com.miui.gallery:id/micro_thumb'])[1]");
			    click("(//*[@resource-id='com.miui.gallery:id/micro_thumb'])[1]");
			
		}catch(Exception e)//android.view.ViewGroup
		{
			ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.RelativeLayout'])[3]");
			click("(//*[@class='android.widget.RelativeLayout'])[3]");
			
			ExplicitWait_ElementToBeClickable("//*[contains(@content-desc,'Photo')]");//android.view.ViewGroup
			click("//*[contains(@content-desc,'Photo')]"); //(//*[@class='android.view.ViewGroup'])[1]

			
			
		}
		
	
		
		
		
	}
	//attached_Files.Click_Save();
	public void Verification_Assets(String assetname) 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Type: "+assetname+"']");
		MobileElement asset = driver.findElement(By.xpath("//*[@text='Type: "+assetname+"']"));
		Verify_AssertTrue(asset);
		
	}
	
	public void Fuel() 
	{
		ExplicitWait_PresenceOfEle("(//*[@resource-id='com.commusoft.v4:id/spinner'])[1]");
		click("(//*[@resource-id='com.commusoft.v4:id/spinner'])[1]");// Click dropdown
		ExplicitWait_PresenceOfEle("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");//Select item
	}
	public void Type() 
	{
		ExplicitWait_PresenceOfEle("(//*[@resource-id='com.commusoft.v4:id/spinner'])[2]");
		click("(//*[@resource-id='com.commusoft.v4:id/spinner'])[2]");// Click dropdown
		ExplicitWait_PresenceOfEle("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");//Select item
	}
	public void Make() 
	{
		ExplicitWait_PresenceOfEle("(//*[@resource-id='com.commusoft.v4:id/spinner'])[3]");// 
		click("(//*[@resource-id='com.commusoft.v4:id/spinner'])[3]");// Click dropdown 
		ExplicitWait_PresenceOfEle("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");//Select item
	}
	
	public void Model() throws InterruptedException 
	{
		ScrollDown24Contains("Add Model");
		ExplicitWait_PresenceOfEle("(//*[@resource-id='com.commusoft.v4:id/spinner'])[4]");
		click("(//*[@resource-id='com.commusoft.v4:id/spinner'])[4]");// Click dropdown
		ExplicitWait_PresenceOfEle("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");//Select item
	}
	public void Location() throws InterruptedException 
	{
		
		ScrollDown24Contains("Add Location");
		ExplicitWait_PresenceOfEle("(//*[@text='Tap to select'])[1]");
		click("(//*[@text='Tap to select'])[1]");// Click dropdown
		ExplicitWait_PresenceOfEle("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");//Select item
	}
	public void SerialNumber() throws InterruptedException 
	{
		TwoSec();
		ScrollDown24Contains("Serial Number");
		TwoSec();
		type("//*[@resource-id='com.commusoft.v4:id/simple_answer']", "Serial");
	}
	
	

}
