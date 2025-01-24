package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

import MainPack.Wrapper;

;

public class NewUI_Notes extends Wrapper{
	
	
	public NewUI_Notes(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void FabIcon() 
	{
		FiveSec();
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Button']");
		click("//*[@class='android.widget.Button']");
	}
	
//	add_Notes.Click_Addnewnote();
	public void Title(String notetitle) 
	{
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", notetitle);
	}
	
	public void Enter_Note(String note) 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.TextView'])[3]");
		click("(//*[@class='android.widget.TextView'])[3]");
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", note);
		ExplicitWait_PresenceOfEle("//*[@text='Done']");
		click("//*[@text='Done']");
	}
	public void Save() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Save']");
		click("//*[@text='Save']");
	}
	
	public void Verify_AddedNote() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Note']");
		MobileElement note = driver.findElement(By.xpath("//*[@text='Note']"));
		Verify_AssertTrue(note);
		System.out.println("Notes verified");
	}
	
//	FabIcon
	
	public void NewPhoneCall() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Add new phone call']");
		click("//*[@text='Add new phone call']");
	}
	
	public void Call_Type() throws InterruptedException 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.EditText'])[1]");
		click("(//*[@class='android.widget.EditText'])[1]");
//		ExplicitWait_PresenceOfEle("//*[@text='Inbound call']");
//		click("//*[@text='Inbound call']");    -------> Comment this two lines bcoz of the element is not there 
		
		 ThreeSec();
		// Coordinates of the button
//		 int x = 228;  // Replace with actual x-coordinate
//	        int y = 840;  // Replace with actual y-coordinate
//	        
////	        Actions actions = new Actions(driver);
////	        actions.moveToElement(null, x, y).click().perform();
//	        
//	        
////	        // Perform tap action using TouchAction
//	        TouchAction touchAction = new TouchAction(driver);
//	        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y))).perform();

	        
	        clickpoint(217, 697);

	}
	
	public void Call_TypeDemo() throws InterruptedException 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.EditText'])[1]");
		click("(//*[@class='android.widget.EditText'])[1]");
		clickpoint(228, 840);
	}
 
	public void ContactNameSearch() 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[1]");
		click("(//*[@class='android.widget.ImageView'])[1]");
		ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[last()-1]");
		click("(//*[@class='android.view.View'])[last()-1]");
	}
	
	public void PhoneNote(String noteforphonecall) 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@text='Tap to fill']");
		click("//*[@text='Tap to fill']");
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", noteforphonecall);
		ExplicitWait_PresenceOfEle("//*[@text='Done']");
		click("//*[@text='Done']");
	}
	
//	Save
	public void Verify_PhoneCall() 
	{
		ExplicitWait_PresenceOfEle("//*[contains(@text,'call')]");
		MobileElement inboundcall = driver.findElement(By.xpath("//*[contains(@text,'call')]"));
		Verify_AssertTrue(inboundcall);
		System.out.println("Phonecall verified");
	}
	
//	FabIcon
//	add_Notes.Click_Sendnewemail();
	
	public void Search_To() 
	{
		ExplicitWait_PresenceOfEle("//*[@content-desc='email_search_icon']");//(//*[@class='android.view.View'])[last()-1]
		click("//*[@content-desc='email_search_icon']");//(//*[@class='android.view.View'])[last()-1]
		ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[last()-1]");
		click("(//*[@class='android.view.View'])[last()-1]");
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.Button']");
		click("//*[@class='android.widget.Button']");
	}
	public void Subject(String subjectforemail) 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.EditText'])[3]");
		type("(//*[@class='android.widget.EditText'])[3]", subjectforemail);
	}
	
	public void ComposeEmail(String composeemail) 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.TextView'])[last()-1]");
		click("(//*[@class='android.widget.TextView'])[last()-1]");
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", composeemail);
		ExplicitWait_PresenceOfEle("//*[@text='Done']");
		click("//*[@text='Done']");
	}
	
	public void sendEmail() 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[5]");
		click("(//*[@class='android.widget.ImageView'])[5]");
	}
	
	public void Verify_Email() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Email']");
		MobileElement email = driver.findElement(By.xpath("//*[@text='Email']"));
		Verify_AssertTrue(email);
		System.out.println("Email verified");
	}
//			FabIcon
//	add_Notes.Click_SendnewSMS();
	
	public void SelectContactName() 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[1]");
		click("(//*[@class='android.widget.ImageView'])[1]");
		ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[last()]");
		click("(//*[@class='android.view.View'])[last()]");
	}
	public void ComposeSMS(String messageforSMS) 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.TextView'])[4]");
		click("(//*[@class='android.widget.TextView'])[4]");
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", messageforSMS);
		ExplicitWait_PresenceOfEle("//*[@text='Done']");
		click("//*[@text='Done']");
	}
	
	public void sendSMS() 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[5]");
		click("(//*[@class='android.widget.ImageView'])[5]");
		TwoSec();
	}
	
	public void Verify_SMS() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='SMS']");
		MobileElement sms = driver.findElement(By.xpath("//*[@text='SMS']"));
		Verify_AssertTrue(sms);
		System.out.println("SMS verified");
	}
	public void Communication_Back() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageView'][1]");
		click("//*[@class='android.widget.ImageView'][1]");
	}

}
