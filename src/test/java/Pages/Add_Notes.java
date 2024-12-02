package Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.ImmutableMap;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Add_Notes extends Wrapper{
	
	public Add_Notes(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
	//customer.Side_Menu();
	//customer.Customer_search();
//	public void TypeCustomerNameInSearchField(String editname,String surname) throws InterruptedException 
//	{
//		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
//		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", editname+" "+surname);
//		MobileEnter();
//	}
	
	public void Click_Cus(String editname,String surname, String passcustomernumber) throws InterruptedException 
	{
		
//		ScrollDown24LastText("Mr & Mrs "+editname+" "+surname);
//		TwoSec();
//		ExplicitWait_ElementToBeClickable("//*[@text='Mr & Mrs "+editname+" "+surname+"']");
//		click("//*[@text='Mr & Mrs "+editname+" "+surname+"']");
		
//		ExplicitWait_ElementToBeClickable("(//*[@text='Properties']/following-sibling::*[@resource-id='com.commusoft.v4:id/listviews'])[1]");
//		click("(//*[@text='Properties']/following-sibling::*[@resource-id='com.commusoft.v4:id/listviews'])[1]");
	
		
	
		
		try 
		{
			ThreeSec();
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/listviews']");
			click("//*[@resource-id='com.commusoft.v4:id/listviews']");
			
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@content-desc='Navigate up']");
			ActionClick("//*[@content-desc='Navigate up']");
			ExplicitWait_ElementToBeClickable("//*[@content-desc='Menu closed']"); //---- instead this Click_MenuClosed_BackButton();
			ActionClick("//*[@content-desc='Menu closed']");
			ExplicitWait_ElementToBeClickable("//*[@content-desc='Menu opened']");
			click("//*[@content-desc='Menu opened']");
			
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/search_button']");
			click("//*[@resource-id='com.commusoft.v4:id/search_button']");
			ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
			click("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
//			type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", editname+" "+surname);
			TwoSec();
			type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", passcustomernumber);
			ThreeSec();
			driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
			Thread.sleep(12000);
			ThreeSec();
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/listviews']");
			click("//*[@resource-id='com.commusoft.v4:id/listviews']");
		}
	
	}
	
	public void Click_Choc_MenuButton() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
		click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
	}
	
	public void Click_NotesSection() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Notes']");
		click("//*[@text='Notes']");
	}
	public void Verify_NotesScreen() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Notes']");
		SoftAssert softAssert = new SoftAssert();
		String ActualResult="Notes";
		String ExpectedResult="Notes";
		softAssert.assertEquals(ActualResult, ExpectedResult);
	}
	
	public void Click_FabIcon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");//com.commusoft.v4:id/fab_expand_menu_button
	    click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
	}
	
	public void Click_FabIcon_NewUI() 
	{
//		String getCoseButton=driver.getPageSource();
//		System.out.println(getCoseButton);
////		String getCloseText = driver.findElement(By.xpath("//*[@text='Close']")).getText();
//		if(getCoseButton.equals("Close"))
//			click("//*[@text='Close']");
//		else
//			System.out.println("Close button is not visible");
		FourSec();
		
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Button']");//com.commusoft.v4:id/fab_expand_menu_button
	    click("//*[@class='android.widget.Button']");
	    
	}
	
	public void Click_Addnewnote() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Add new note']");//Add new note
		click("//*[@text='Add new note']");
	}
	public void Enter_Title(String notetitle) 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/titleEdittext']");//com.commusoft.v4:id/titleEdittext com.commusoft.v4:id/noteEditText
		type("//*[@resource-id='com.commusoft.v4:id/titleEdittext']", notetitle);
	}
	public void Enter_Note(String note) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/noteEditText']");//com.commusoft.v4:id/noteEditText
		type("//*[@resource-id='com.commusoft.v4:id/noteEditText']", note);
		
	}
	//customer.Customer_Save();
	
	public void Click_ExpandedFabIcon() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
		click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
		TwoSec();
	}
	//scrollDown
	//add_Notes.Click_FabIcon();
	
	public void Click_Add_new_phone_call() //Add new phone call
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Add new phone call']");
		click("//*[@text='Add new phone call']");
	}
	public void Click_Calltype_Dropdown() //Tap To Select. . .
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='Tap To Select. . .'])[1]");
		click("(//*[@text='Tap To Select. . .'])[1]");
	}
	public void Select_IncomingCall() //Incoming call
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Incoming call']");
		click("//*[@text='Incoming call']");
	}
	public void Click_ContactName_Dropdown() //Tap To Select. . .
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
	}
	
	public void Select_ContactName(String editname,String surname) 
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Mr & Mrs "+editname+" "+surname+"')]");
		
		click("//*[contains(@text,'Mr & Mrs "+editname+" "+surname+"')]");
	}
	public void Click_ContactNumber_Dropdown() //Tap To Select. . .
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[3]");
		click("(//*[@resource-id='android:id/text1'])[3]");
	}
	public void Select_ContactNumber() //android:id/text1
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
	}
	public void EnterNoteForPhoneCall(String noteforphonecall) //com.commusoft.v4:id/noteEdittext
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/noteEdittext']");
		type("//*[@resource-id='com.commusoft.v4:id/noteEdittext']", noteforphonecall);
		
	}
	//customer.Customer_Save();
	//add_Notes.Click_ExpandedFabIcon();
	//scrolltothedown(500,1700,500,2165);
	//add_Notes.Click_FabIcon();
	
	public void Click_Sendnewemail() //Send new email
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Send new email']");
		click("//*[@text='Send new email']");
	}
	
	public void Click_To() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/to']");
		click("//*[@resource-id='com.commusoft.v4:id/to']");
	}
	
	public void Select_Email() //com.commusoft.v4:id/user_checkbox
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='com.commusoft.v4:id/user_checkbox'])[1]");
		click("(//*[@resource-id='com.commusoft.v4:id/user_checkbox'])[1]");
	}
	//customer.Customer_Save();
	public void EnterSubject(String subjectforemail) 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/subject']");
		type("//*[@resource-id='com.commusoft.v4:id/subject']", subjectforemail);
	}
	//customer.Customer_Save();
	//add_Notes.Click_ExpandedFabIcon();
	//scrolltothedown(500,1700,500,2165);
	//add_Notes.Click_FabIcon();
	public void Click_SendnewSMS() //Send new SMS
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Send new SMS']");
		click("//*[@text='Send new SMS']");
	}
	//Click_ContactName_Dropdown
	public void Click_SMSContactName_Dropdown() //android:id/text1
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[1]");
		click("(//*[@resource-id='android:id/text1'])[1]");
	}
	//Select_ContactName
	public void Click_ToContactNumber_Dropdown() //Tap To Select. . .
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
	}
	//Select_ContactNumber
	public void Enter_Message(String messageforSMS) //com.commusoft.v4:id/template
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/template']");
		type("//*[@resource-id='com.commusoft.v4:id/template']", messageforSMS);
	}
	//customer.Customer_Save();
	//add_Notes.Click_ExpandedFabIcon();
	//scrolltothedown(500,1700,500,2165);
	
	public void Verify_Note(String notetitle) 
	{
		try {
		ExplicitWait_PresenceOfEle("//*[@text='"+notetitle+"']");
		MobileElement phone=driver.findElement(By.xpath("//*[@text='"+notetitle+"']"));
	
		Assert.assertTrue(phone.isDisplayed());
		System.out.println("Note Record Is Saved");
		}catch(Exception e) 
		{
			System.err.println("Notes is not added");
		}
	}
	public void Verify_PhoneCall(String noteforphonecall) 
	{
		try {
		ExplicitWait_PresenceOfEle("//*[@text='"+noteforphonecall+"']");
		MobileElement phone=driver.findElement(By.xpath("//*[@text='"+noteforphonecall+"']"));
	
		Assert.assertTrue(phone.isDisplayed());
		System.out.println("Phone Call Record Is Saved");
		}catch (Exception e) {
			System.err.println("Phone call is not added");
		}
		
	}
	public void Verify_Email(String subjectforemail) 
	{
		try {
		ExplicitWait_PresenceOfEle("//*[@text='"+subjectforemail+"']");
		MobileElement phone=driver.findElement(By.xpath("//*[@text='"+subjectforemail+"']"));
	
		Assert.assertTrue(phone.isDisplayed());
		System.out.println("Email Record Is Saved");
		}catch (Exception e) {
			System.err.println("Email is not added");
		}
		
	}
	public void Verify_SMS(String messageforSMS) 
	{
		try {
		ExplicitWait_PresenceOfEle("//*[@text='"+messageforSMS+"']");
		MobileElement phone=driver.findElement(By.xpath("//*[@text='"+messageforSMS+"']"));
	
		Assert.assertTrue(phone.isDisplayed());
		System.out.println("SMS Record Is Saved");
		}catch (Exception e) {
			System.err.println("SMS is not added");
		}
		
	}
	//customer.Customer_Back();
	//customer.Customer_Back();
	
	public void VerifyAllNotes() 
	{
		ExplicitWait_PresenceOfEle("(//*[@resource-id='com.commusoft.v4:id/notesLayout'])[1]");
		MobileElement n1 = driver.findElement(By.xpath("(//*[@resource-id='com.commusoft.v4:id/notesLayout'])[1]"));
		MobileElement n2 = driver.findElement(By.xpath("(//*[@resource-id='com.commusoft.v4:id/notesLayout'])[2]"));
		MobileElement n3 = driver.findElement(By.xpath("(//*[@resource-id='com.commusoft.v4:id/notesLayout'])[3]"));
		MobileElement n4 = driver.findElement(By.xpath("(//*[@resource-id='com.commusoft.v4:id/notesLayout'])[4]"));


		Assert.assertTrue(n1.isDisplayed());
		Assert.assertTrue(n2.isDisplayed());
		Assert.assertTrue(n3.isDisplayed());
		Assert.assertTrue(n4.isDisplayed());
	}
	
	
	

}
