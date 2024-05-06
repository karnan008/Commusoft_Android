package Pages;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Attached_Files extends Wrapper{

	public Attached_Files(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}

	//	Add_Notes add_Notes = new Add_Notes(driver);
	//	Customer customer = new Customer(driver);
	//	customer.Side_Menu();
	//	customer.Customer_search();
	//	add_Notes.TypeCustomerNameInSearchField(EditName, Surname);
	//	add_Notes.Click_Cus(EditName, Surname);
	//	add_Notes.Click_ChocolateMenuButton();

	public void Click_AttachedFiles() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Attached files']");
		click("//*[@text='Attached files']");
	}
	//	add_Notes.Click_FabIcon();

	public void Click_TakePhoto() //Take Photo
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Take photo']");
		click("//*[@text='Take photo']");
	}

	public void Exception_Handling() 
	{
		TwoSec();
		try 
		{

			if(driver.findElement(By.xpath("//*[@text='WHILE USING THE APP']")).isDisplayed()) 
				click("//*[@text='WHILE USING THE APP']");

		}catch(Exception e) 
		{
			System.out.println("Permission screen is not dipslayed");
		}
	}

	public void Enter_Photo_Filename(String photofilename) //com.commusoft.v4:id/filenameValue
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/filenameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/filenameValue']", photofilename);
	}

	public void Click_Save() //com.commusoft.v4:id/save
	{

		//		try 
		//		{
		//			if(driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/save']")).isDisplayed()) 
		//				ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
		//			    click("//*[@resource-id='com.commusoft.v4:id/save']");
		//			
		//		}catch(Exception e) 
		//		{
		//			System.out.println("Save Button Is Not Appeared");
		//		}
		;	
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
		click("//*[@resource-id='com.commusoft.v4:id/save']");

	}

	public void Take_Photo() //com.google.android.GoogleCamera:id/shutter_button
	{
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

	public void Click_TickSymbol() //com.android.camera:id/done_button  com.google.android.GoogleCamera:id/shutter_button
	{
		//com.google.android.GoogleCamera:id/shutter_button

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
	public void Click_TakeVideo() //Take Photo
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Record video']");
		click("//*[@text='Record video']");
	}

	public void Enter_Video_Filename(String videofilename) //com.commusoft.v4:id/filenameValue
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/filenameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/filenameValue']", videofilename);
	}

	//Click_Save

	public void Take_Video() //com.android.camera:id/shutter_button_horizontal 
	{
		OneSec();

		try 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
			click("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
			FiveSec();
			click("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");

		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.google.android.GoogleCamera:id/shutter_button']");
			click("//*[@resource-id='com.google.android.GoogleCamera:id/shutter_button']");
			FiveSec();
			click("//*[@resource-id='com.google.android.GoogleCamera:id/shutter_button']");
		}
	}
	//Click_TickSymbol

	public void Click_ChooseFromCameraRoll() //Choose from Camera Roll   android.widget.LinearLayout
	{
		try 
		{
			ExplicitWait_ElementToBeClickable("//*[@text='Choose from Camera Roll']");
			click("//*[@text='Choose from Camera Roll']");//SELECT
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@text='Choose from camera roll']");
			click("//*[@text='Choose from camera roll']");//SELECT
		}
		
		

	}

	public void SelectFromCameraRoll() 
	{
		
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.ImageButton']");
		ActionClick("//*[@class='android.widget.ImageButton']");
		FiveSec();
		ExplicitWait_PresenceOfEle("//*[@text='Images']");//Images
		ActionClick("//*[@text='Images']");//Image
		TwoSec();
		try 
		{
			ExplicitWait_PresenceOfEle("//*[@text='Images']");
			if(driver.findElement(By.xpath("//*[@text='Images']")).isDisplayed())
				ActionClick("//*[@text='Images']");
		}catch(Exception e) 
		{
			System.out.println("Image text is not displayed");
		}
		TwoSec();
		try 
		{
			ExplicitWait_PresenceOfEle("//*[@text='Camera']");
			if(driver.findElement(By.xpath("//*[@text='Camera']")).isDisplayed())
				ActionClick("//*[@text='Camera']");
		}catch(Exception e) 
		{
			System.out.println("Camera text is not displayed");
		}
		
		TwoSec();
		ExplicitWait_PresenceOfEle("(//*[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]");
		ActionClick("(//*[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]");
		TwoSec();
		try {
			ExplicitWait_PresenceOfEle("//*[@text='SELECT']");
			if(driver.findElement(By.xpath("//*[@text='SELECT']")).isDisplayed())
				ActionClick("//*[@text='SELECT']");
		
		}catch(Exception e) 
		{
			System.out.println("Select Button Is Not Displayed");
		}
	}

	public void Click_RecordAudio() 
	{
//		FiveSec();
		ExplicitWait_ElementToBeClickable("//*[@text='Record audio']");//Record audio
		click("//*[@text='Record audio']");
	}

	public void Enter_Audio_Filename(String audiofilename) //com.commusoft.v4:id/filenameValue
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/filenameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/filenameValue']", audiofilename);
	}
	public void Click_TickSymbolForAudio() //com.commusoft.v4:id/save
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
		click("//*[@resource-id='com.commusoft.v4:id/save']");
	}
	//Click_TickSymbol
	public void RecordAudio() //com.commusoft.v4:id/btnRecord   com.commusoft.v4:id/btnRecord
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/btnRecord']");
		click("//*[@resource-id='com.commusoft.v4:id/btnRecord']");
		FiveSec();
		click("//*[@resource-id='com.commusoft.v4:id/btnRecord']");   //android.widget.RelativeLayout

	}
	public void Verify_AllAttachedFiles() //android.widget.RelativeLayout
	{
		MobileElement ele1 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[1]"));
		MobileElement ele2 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[2]"));
		MobileElement ele3 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[3]"));
		MobileElement ele4 = driver.findElement(By.xpath("(//*[@class='android.widget.RelativeLayout'])[4]"));
		Verify_AssertTrue(ele1);
		System.out.println("Photo File Is Saved");
		Verify_AssertTrue(ele2);
		System.out.println("Video File Is Saved");
		Verify_AssertTrue(ele3);
		System.out.println("Import File Is Saved");
		Verify_AssertTrue(ele4);
		System.out.println("Audio File Is Saved");

	}




}
