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
		ExplicitWait_ElementToBeClickable("//*[@text='Take Photo']");
		click("//*[@text='Take Photo']");
	}
	
	public void Enter_Photo_Filename(String photofilename) //com.commusoft.v4:id/filenameValue
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/filenameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/filenameValue']", photofilename);
	}
	
	public void Click_Save() //com.commusoft.v4:id/save
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
		click("//*[@resource-id='com.commusoft.v4:id/save']")
;	}
	
	public void Take_Photo() //com.android.camera:id/shutter_button_horizontal 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
		click("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
	}
	
	public void Click_TickSymbol() //com.android.camera:id/done_button
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.android.camera:id/done_button']");
		click("//*[@resource-id='com.android.camera:id/done_button']");
	}
	public void Click_TakeVideo() //Take Photo
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Take Video']");
		click("//*[@text='Take Video']");
	}
	
	public void Enter_Video_Filename(String videofilename) //com.commusoft.v4:id/filenameValue
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/filenameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/filenameValue']", videofilename);
	}
	
	//Click_Save
	
	public void Take_Video() //com.android.camera:id/shutter_button_horizontal 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
		click("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
		FiveSec();
		click("//*[@resource-id='com.android.camera:id/shutter_button_horizontal']");
	}
	//Click_TickSymbol
	
	public void Click_ChooseFromCameraRoll() //Choose from Camera Roll   android.widget.LinearLayout
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Choose from Camera Roll']");
		click("//*[@text='Choose from Camera Roll']");//SELECT
	
	}
	
	public void SelectFromCameraRoll() 
	{
		ExplicitWait_PresenceOfEle("(//*[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]");
		click("(//*[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]");
		ExplicitWait_PresenceOfEle("//*[@text='SELECT']");
		click("//*[@text='SELECT']");
	}
	
	public void Click_RecordAudio() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Record audio']");
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
