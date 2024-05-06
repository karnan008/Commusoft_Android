package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Customer extends MainPack.Wrapper{

	public Customer(AndroidDriver<MobileElement> ldriver)
	{
		this.driver = ldriver;
	}
	
	public void Side_Menu() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Menu opened']");
		click("//*[@content-desc='Menu opened']");//android.widget.ImageButton
		//android.widget.ImageView[@content-desc=\"Gallery\"]

	}
	
	public void StoreCustomerNumber() 
	{
		ThreeSec();
		ExplicitWait_PresenceOfEle("//*[@text='Account No']/following-sibling::*[@resource-id='com.commusoft.v4:id/customer_account']");
		customernumber = driver.findElement(By.xpath("//*[@text='Account No']/following-sibling::*[@resource-id='com.commusoft.v4:id/customer_account']")).getText();
		System.setProperty("customernumber", customernumber);
		
		System.out.println("Cusotmer Number Is: "+customernumber);
	}
	public void Private_Customer()//New Private customer
	{
		
		
		try 
		{
			ExplicitWait_ElementToBeClickable("//*[@text='New Private Customer']");
			click("//*[@text='New Private Customer']"); 
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@text='New Private customer']");
			click("//*[@text='New Private customer']"); 
		}
	}
	public void Customer_title(String title) throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Title']/following-sibling::*[@class='android.widget.Spinner']");
		click("//*[@text='Title']/following-sibling::*[@class='android.widget.Spinner']");
		ExplicitWait_ElementToBeClickable("//*[@text='"+title+"']");
		click("//*[@text='"+title+"']");


		//	   click("//*[@text='Title']/following::*[@class='android.widget.Spinner']");
	}
	public void Customer_Name()
	{
		ExplicitWait_PresenceOfEle("#com.commusoft.v4:id/firstNameValue");
		type("#com.commusoft.v4:id/firstNameValue", "Appium");
	}
	public void Customer_Name(String name)
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/firstNameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/firstNameValue']",name );
	}
	public void Customer_SurName(String name)
	{
		type("//*[@resource-id='com.commusoft.v4:id/surnameValue']", name);
	}
	public void Customer_Telephone(String number)
	{
		type("//*[@resource-id='com.commusoft.v4:id/telephoneValue']", number);
	}
	public void Customer_Mobile(String number)
	{
		type("//*[@resource-id='com.commusoft.v4:id/mobileValue']", number);
	}
	public void Customer_email(String email)
	{
		type("//*[@resource-id='com.commusoft.v4:id/emailAddress']", email);
	}
	public void Scroll_Address1()
	{

	}
	public void Click_County() throws InterruptedException 
	{
		Thread.sleep(2000);
		click("(//*[@resource-id='android:id/text1'])[2]");

	}
	public void Customer_AddressLine1(String address)
	{
		type("//*[@resource-id='com.commusoft.v4:id/formaddressLine1']", address);
	}
	public void Customer_Save() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Save']");
		click("//*[@content-desc='Save']");//com.commusoft.v4:id/save
		Thread.sleep(4000);
	}
	public void Customer_Fav()
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/favoriteIcon']");
		click("//*[@resource-id='com.commusoft.v4:id/favoriteIcon']");
	}
	public void Customer_Back()//android.widget.ImageButton
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageButton']");
		click("//*[@class='android.widget.ImageButton']");
	}
	public void Customer_search() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/search_button']");
		click("//*[@resource-id='com.commusoft.v4:id/search_button']");
	}
	public void Customer_Searchtext(String editname,String surname)
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
//		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", editname+" "+surname);
 
		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", customernumber);
	
	}
	public void TypeCustomerNameInSearchField(String editname,String surname) throws InterruptedException 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
//		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", editname+" "+surname);
		
		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", customernumber);
		
	}
	
	public void Pass_CustomerNumber(String passcustomernumber) 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");
//		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", editname+" "+surname);
		
		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", passcustomernumber);
	}
	public void Store_CustomerNumber() 
	{
		
	}
	public void Customer_1select(String name) throws InterruptedException
	{
		Thread.sleep(5000);
		click("//android.widget.TextView[@text='"+name+"']");
	}
	public void Customer_Edit() throws InterruptedException
	{
		Thread.sleep(3000);
		click("#com.commusoft.v4:id/customerInformation");
		Thread.sleep(3000);
	}
	public void Menu_Close() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Menu closed']");
		click("//*[@content-desc='Menu closed']");
		Thread.sleep(2000);
	}
	public void Wholeback3() throws InterruptedException
	{
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		Thread.sleep(3000);
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		Thread.sleep(3000);
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		Thread.sleep(3000);
	}
	public void Wholeback2() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Navigate up']");
		click("//*[@content-desc='Navigate up']");
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Navigate up']");
		click("//*[@content-desc='Navigate up']");
		Thread.sleep(3000);
	}
	public void Edit_telephone() throws InterruptedException
	{
		clear("#com.commusoft.v4:id/telephoneValue");
		Thread.sleep(3000);
		type("#com.commusoft.v4:id/telephoneValue", "7777777777");
		Thread.sleep(3000);

	}
	public void Customer_edit1() throws InterruptedException
	{
		click("//*[@content-desc=\"Edit\"]");
		Thread.sleep(3000);

	}
	public void Customer_More() throws InterruptedException
	{
		Thread.sleep(3000);
		ExplicitWait_ElementToBeClickable("//*[@content-desc=\"Open\"]");
		click("//*[@content-desc=\"Open\"]");//more
		Thread.sleep(3000);
	}
	public void Customer_Ongoing() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='On going work']");
		click("//android.widget.TextView[@text='On going work']");//on going
	
	}
	public void Customer_PlusBtn() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
		click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");// com.commusoft.v4:id/fab_expand_menu_button
		// com.commusoft.v4:id/fab_expand_menu_button
		Thread.sleep(2000);
	}
	public void Reminders() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Reminders']");
		click("//android.widget.TextView[@text='Reminders']");
		Thread.sleep(2000);
	}
	public void Reminderplus() throws InterruptedException
	{
		
		try 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");//com.commusoft.v4:id/fab_expand_menu_button
			click("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");
			
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");//com.commusoft.v4:id/fab_expand_menu_button
			click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
		}
	
	}
	public void ServiceReminder() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Add new service reminder']");
		click("//android.widget.TextView[@text='Add new service reminder']");
		
	}
	public void Click_ServiceType_Dropdown() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='Tap To Select. . .'])[1]");
		click("(//*[@text='Tap To Select. . .'])[1]");
	}
	public void SelectReminder() throws InterruptedException
	{
		//		click("//android.widget.TextView[@text='AC service']");
		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.TextView'])[2]");
		click("(//*[@class='android.widget.TextView'])[2]");
		Thread.sleep(2000);
	}
	public void ReminderDate() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerDateLayout']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerDateLayout']");
//		click("#com.commusoft.v4:id/spinnerDateLayout");//com.commusoft.v4:id/spinnerDateLayout
		ExplicitWait_ElementToBeClickable("//android.widget.Button[@text='DONE']");
		click("//android.widget.Button[@text='DONE']");
		
	}
	public void Sendto(String title,String editname,String surname) throws InterruptedException
	{
		Thread.sleep(3000);
		//		click("#com.commusoft.v4:id/spinnersendToView");
		ExplicitWait_ElementToBeClickable("//*[@text='Send to *']/following-sibling::*[@class='android.widget.Spinner']");
		click("//*[@text='Send to *']/following-sibling::*[@class='android.widget.Spinner']");
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'"+title+" "+editname+" "+surname+"')]");

		click("//*[contains(@text,'"+title+" "+editname+" "+surname+"')]");
		Thread.sleep(4000);

		//		ExplicitWait_ElementToBeClickable("//*[@text='Mr & Mrs "+editname+" "+surname+"']");
		//		click("(//*[@text='Mr & Mrs "+editname+" "+surname+"'])[1]");
	}
	public void Tick() throws InterruptedException 
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Save']");
		click("//*[@content-desc='Save']");
	
	}
	public void WA() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Work addresses']");
		click("//*[@text='Work addresses']");
		Thread.sleep(2000);
	}
	public void WA_Add() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");
		click("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");
		Thread.sleep(2000);
	}
	public void WA_Name(String name) throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/firstNameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/firstNameValue']", name);
		Thread.sleep(2000);
	}
	public void WA_Surname(String lastname) throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/surnameValue']");//
		type("//*[@resource-id='com.commusoft.v4:id/surnameValue']", lastname);
		Thread.sleep(2000);
	}

	public void Scrollto_WA_Address() throws InterruptedException
	{
		Thread.sleep(2000);
		scrollToId(driver, "com.commusoft.v4:id/formaddressLine1");
		Thread.sleep(2000);
	}
	public void WA_Address(String add) throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/formaddressLine1']");
		type("//*[@resource-id='com.commusoft.v4:id/formaddressLine1']", add);//com.commusoft.v4:id/formaddressLine1
		Thread.sleep(2000);
	}
	public void Cus_Contact() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Contacts']");
		Thread.sleep(2000);
	}
	public void Choose_Contact() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Create new contact']");
		Thread.sleep(2000);
	}
	public void Contact_Surname() throws InterruptedException
	{
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/contactSurNameValue", "Contact name");
		Thread.sleep(2000);
	}
	public void Cus_notes() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Notes']");
		Thread.sleep(2000);
	}
	public void Notes_plus() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Add new note']");
		Thread.sleep(2000);
	}
	public void Notes_Title() throws InterruptedException
	{
		type("#com.commusoft.v4:id/titleEdittext", "NotesTitle");
		Thread.sleep(2000);
	}
	public void Notes_body() throws InterruptedException
	{
		type("#com.commusoft.v4:id/noteEditText", "Notesbody");
		Thread.sleep(2000);
	}

	public void Notes_phonecall() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Add new phone call']");
		Thread.sleep(2000);
	}
	public void Note_calltype() throws InterruptedException
	{
		click("#com.commusoft.v4:id/callTypeSpinner");
		Thread.sleep(2000);
	}
	public void Note_callchoose() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Incoming call']");
		Thread.sleep(2000);
	}
	public void Notes_contactname() throws InterruptedException
	{
		click("#com.commusoft.v4:id/contactNameSpinner");
		Thread.sleep(2000);
	}
	public void Notes_contactnamechoose(String name) throws InterruptedException
	{
		click("//android.widget.TextView[@text='"+name+"']");
		Thread.sleep(2000);
	}
	public void Phonecall() throws InterruptedException
	{
		click("#com.commusoft.v4:id/contactNumberSpinner");
		Thread.sleep(2000);
		click("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/noteEdittext", "Phone Call Notes");
		Thread.sleep(2000);
	}
	public void Notes_Email() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Send new email']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/to");
		Thread.sleep(6000);
		click("#com.commusoft.v4:id/user_checkbox");
		Thread.sleep(2000);

	}
	public void Note_Emailsubject(String sub) throws InterruptedException
	{
		type("#com.commusoft.v4:id/subject", sub);
		Thread.sleep(2000);
	}
	public void Notes_SMS(String name) throws InterruptedException
	{
		click("//android.widget.TextView[@text='Send new SMS']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/contactNameSpinner");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='"+name+"']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/contactNumberSpinner");
		Thread.sleep(2000);
		click("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/template", "Message body");
	}

	public void Click_FavCus() throws InterruptedException 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Favourite customers']");
		ScrollDown24("Favourite customers");
		click("//*[@text='Favourite customers']");

	}
	public void ScrollToFavouriteCustomer() throws InterruptedException, AWTException 
	{
		Thread.sleep(5000);
		//Mr & Mrs S Saravanan
		//County

		String pageSource = driver.getPageSource();
		System.out.println("Page Source Value Is: "+pageSource);
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Mr & Mrs S Saravanan\"))"));//My Van


		//		  String pageSource = driver.getPageSource();
		//		  System.out.println("Page Source Value Is: "+pageSource);
		//		  click("//*[@text='Mr & Mrs S Saravanan']");


		//		String pageSource = driver.getPageSource();
		//		System.out.println("Page Source Value Is: "+ pageSource);
		//		click("//*[@text='Parts to pick up']");


	}	

	//------------------> Add Remainder <------------------------

	public void Click_Remainder() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/addNewReminder']");
		click("//*[@resource-id='com.commusoft.v4:id/addNewReminder']");
	}

	public void Click_RemainderDate() //com.commusoft.v4:id/spinnerDateLayout
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerDateLayout']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerDateLayout']");
	}
	public void Select_Date() throws InterruptedException //com.android.datetimepicker.date.SimpleMonthAdapter$CalendarDay
	{                         //com.android.datetimepicker.date.SimpleMonthAdapter$CalendarDay
//
//		String SelectedDate = driver.findElement(By.xpath("//*[contains(@content-desc,'selected')]")).getText();
//		System.out.println("Selected Date Is: "+SelectedDate);
		try {
		ExplicitWait_ElementToBeClickable("//*[contains(@content-desc,'selected')]/following-sibling::*[@class='com.android.datetimepicker.date.SimpleMonthAdapter$CalendarDay']");
		driver.findElement(By.xpath("//*[contains(@content-desc,'selected')]/following-sibling::*[@class='com.android.datetimepicker.date.SimpleMonthAdapter$CalendarDay']")).click();
		}catch (Exception e) { 
			
//			scrolltothetop(551, 1585, 519, 1043);
			TwoSec();
//			ExplicitWait_ElementToBeClickable("(//*[@class='com.android.datetimepicker.date.SimpleMonthAdapter$CalendarDay])[1]");
//			click("(//*[@class='com.android.datetimepicker.date.SimpleMonthAdapter$CalendarDay])[1]");
			ExplicitWait_ElementToBeClickable("//com.android.datetimepicker.date.SimpleMonthAdapter.CalendarDay[contains(@content-desc,'01')]");
			click("//com.android.datetimepicker.date.SimpleMonthAdapter.CalendarDay[contains(@content-desc,'01')]");
		}

	}

	public void Click_Done() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='DONE']");
		click("//*[@text='DONE']");
	}

	public void Enter_NotesForReminder(String notesforreminder) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/noteEditText']");
		type("//*[@resource-id='com.commusoft.v4:id/noteEditText']", notesforreminder);
		
	}

	public void Select_User(String username) throws InterruptedException // Saravanan S
	{
		ScrollDown24(username);
		
		ThreeSec();
//		driver.findElement(By.xpath("//*[@text='"+username+"']/preceding-sibling::*[@resource-id='com.commusoft.v4:id/user_checkbox']")).click();
	
//		click("(//*[@text='"+username+"']/preceding-sibling::*[@class='android.widget.CheckBox'])[1]");//[@class='android.widget.CheckBox']
		
		
		
		List<MobileElement> names = driver.findElements(By.xpath("//*[@resource-id='com.commusoft.v4:id/name']"));
		
//		int NameSize = names.size();
//		System.out.println("Total Number Of Name Is: "+NameSize);
		
		for (MobileElement mobileElement : names) {
			
			String NameText = mobileElement.getText();
			System.out.println("Overall Name Is: "+NameText);
			String id = mobileElement.getId();
			System.out.println("User Name Id: "+id);
			
		}
		
		//BELOW CODE IS WORKING FINE
		driver.findElement(By.xpath("(//*[@class='android.widget.CheckBox'])[10]")).click();
		
		//INSTEAD USE BELOW CODE
		
//		click("//*[@text='"+username+"']/preceding-sibling::*[@class='android.widget.CheckBox'][1]");
		
//		String USER = driver.findElement(By.xpath("//*[@text='"+username+"']")).getText();
//		System.out.println("User Name Is: "+USER);
		
//		click("//*[@class='android.widget.CheckBox']");
	
	}
	
	public void Click_Tick() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
		click("//*[@resource-id='com.commusoft.v4:id/save']");
	}



	public void NavigateUpButtonTest() 
	{
//		MobileElement navigateup = driver.findElement(By.xpath("//*[@content-desc='Navigate up']"));
		boolean NavigateUpButton = driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).isDisplayed();
		System.out.println("Navigate Up Button Is Displayed Or Not: "+NavigateUpButton);
	}



	public void profile() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/mli_letter']");
		click("//*[@resource-id='com.commusoft.v4:id/mli_letter']");
	}


	public void GetUserName()  
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.TextView'])[1]");
		username = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]")).getText();
		System.setProperty("username", username);
		System.out.println("Current User name: "+username);
		TwoSec();
		click("//*[@class='android.widget.Button']");//click back button
		
	}



}
