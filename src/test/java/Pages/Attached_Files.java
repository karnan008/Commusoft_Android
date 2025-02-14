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
	
	public void Click_RecordVideo() //Take Photo
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Record video']");
		click("//*[@text='Record video']");
	}
	
	public void Click_ScanDocument() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Scan document']");
		click("//*[@text='Scan document']");
	}

	public void Capture_Document() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/cameraCaptureButton']");
		click("//*[@resource-id='com.commusoft.v4:id/cameraCaptureButton']");
	}
	public void ConfirmScan() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/confirmButton']");
		click("//*[@resource-id='com.commusoft.v4:id/confirmButton']");
	}
	
	public void Capture_SingleVideo() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/im_videocapture']");
		click("//*[@resource-id='com.commusoft.v4:id/im_videocapture']");
		FiveSec();
		click("//*[@resource-id='com.commusoft.v4:id/im_videocapture']");
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

	public void Capture_SingleImage() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.ImageView'])[2]");
		click("(//*[@class='android.widget.ImageView'])[2]");
	}
	
	public void Click_Save_OldUI() //com.commusoft.v4:id/save
	{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
			click("//*[@resource-id='com.commusoft.v4:id/save']");
	}
	
	public void Click_Save_NewUI() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Save']");
		click("//*[@text='Save']");
	}
	public void Upload_Save() 
	{
		ThreeSec();
		ExplicitWait_ElementToBeClickable("//*[@text='Save']");
		click("//*[@text='Save']");
	}

	public void Click_PhotoNext() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.TextView'])[6]");
		click("(//*[@class='android.widget.TextView'])[6]");
	}
	public void Click_VideoNext() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.TextView'])[2]");
		click("(//*[@class='android.widget.TextView'])[2]");
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
	
	public void Click_ChooseFromGallery() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Choose from gallery']");
		click("//*[@text='Choose from gallery']");
	}

	public void SelectFromCameraRoll() 
	{
		
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.ImageButton']");
		ActionClick("//*[@class='android.widget.ImageButton']");
//		click("//*[@class='android.widget.ImageButton']");
		FiveSec();
		ExplicitWait_ElementToBeClickable("(//*[@text='Images'])[2]");//Images
		ActionClick("(//*[@text='Images'])[2]");//Image
		TwoSec();
//		try 
//		{
//			ExplicitWait_PresenceOfEle("//*[@text='Images']");
//			if(driver.findElement(By.xpath("//*[@text='Images']")).isDisplayed())
//				ActionClick("//*[@text='Images']");
//		}catch(Exception e) 
//		{
//			System.out.println("Image text is not displayed");
//		}
//		TwoSec();
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
	
	public void SelectPicFromGallery() 
	{
//		ExplicitWait_PresenceOfEle("//*[@class='android.widget.ImageButton']");
//		ActionClick("//*[@class='android.widget.ImageButton']");
//		ExplicitWait_ElementToBeClickable("(//*[@text='Redmi Note 8 Pro'])[3]");//Images
//		click("(//*[@text='Redmi Note 8 Pro'])[3]");
//		ExplicitWait_ElementToBeClickable("//*[@text='Images']");//Images
//		ActionClick("//*[@text='Images']");
		ExplicitWait_PresenceOfEle("(//android.widget.LinearLayout[@resource-id=\"com.google.android.documentsui:id/item_root\"])[1]/android.widget.LinearLayout");
		click("(//android.widget.LinearLayout[@resource-id=\"com.google.android.documentsui:id/item_root\"])[1]/android.widget.LinearLayout");
	}

	public void Click_RecordAudio() 
	{
//		FiveSec();
		ExplicitWait_ElementToBeClickable("//*[@text='Record audio']");//Record audio
		click("//*[@text='Record audio']");
	}
	
	public void Capture_Audio() 
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='record audio']");
		click("//*[@content-desc='record audio']");
		FiveSec();	
		click("//*[@content-desc='record audio']");
	}
	
	public void Enter_AudioFileName(String audio_filename) 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", audio_filename);		
		
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
	
	public void verifyAllAttachedFilesOnMOb() 
	{
		OneSec();
		MobileElement file1 = driver.findElement(By.xpath("(//*[@class='android.view.View'])[4]"));
		Verify_AssertTrue(file1);
		MobileElement file2 = driver.findElement(By.xpath("(//*[@class='android.view.View'])[6]"));
		Verify_AssertTrue(file2);
		MobileElement file3 = driver.findElement(By.xpath("(//*[@class='android.view.View'])[8]"));
		Verify_AssertTrue(file3);
		MobileElement file4 = driver.findElement(By.xpath("(//*[@class='android.view.View'])[10]"));
		Verify_AssertTrue(file4);
		MobileElement file5 = driver.findElement(By.xpath("(//*[@class='android.view.View'])[13]"));
		Verify_AssertTrue(file5);
	}

	public void AttachedFiles_Back() //*[@text='Attached files']
	{
		ThreeSec();
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageView'][1]");
//		click("//*[@class='android.widget.ImageView'][1]");
		ExplicitWait_ElementToBeClickable("//*[@text='Attached files']");
		click("//*[@text='Attached files']");
	}


	public void Rename_File(String job_image)//JobImage
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'B')]");
		click("//*[contains(@text,'B')]");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		clear("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", job_image);
	}
	
	public void Attachments_ViewAll() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='Attachments']/following-sibling::*[contains(@text,'View all')])[1]");
		click("(//*[@text='Attachments']/following-sibling::*[contains(@text,'View all')])[1]");
	}

	public void Today_Status_Verification() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Today']");
		MobileElement today = driver.findElement(By.xpath("//*[@text='Today']"));
		Verify_AssertTrue(today);
	}
	
	public void Files_Verifications(String filename) 
	{
		ExplicitWait_PresenceOfEle("//*[contains(@text,'"+filename+"')]");
		MobileElement file = driver.findElement(By.xpath("//*[contains(@text,'"+filename+"')]"));
		Verify_AssertTrue(file);
	}
}

