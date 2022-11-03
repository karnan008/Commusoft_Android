package pages;

import action.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Customer extends Wrapper{
	
	public Customer(AndroidDriver<MobileElement> ldriver)
	{
		this.driver = ldriver;
	}
	public void Side_Menu() throws InterruptedException
	{
		Thread.sleep(4000);
		click("//android.widget.ImageButton[@content-desc=\"Menu opened\"]");
		Thread.sleep(2000);
	}
	public void Private_Customer()
	{
		click("//android.widget.TextView[@text='New Private Customer']");
	}
	public void Customer_title(String title) throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/spinnerTitle");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='"+title+"']");
	}
	public void Customer_Name()
	{
		type("#com.commusoft.v4:id/firstNameValue", "Appium");
	}
	public void Customer_Name(String name)
	{
		type("#com.commusoft.v4:id/firstNameValue",name );
	}
	public void Customer_SurName(String name)
	{
		type("#com.commusoft.v4:id/surnameValue", name);
	}
	public void Customer_Telephone(String number)
	{
		type("#com.commusoft.v4:id/telephoneValue", number);
	}
	public void Customer_Mobile(String number)
	{
		type("#com.commusoft.v4:id/mobileValue", number);
	}
	public void Customer_email(String email)
	{
		type("#com.commusoft.v4:id/emailAddress", email);
	}
	public void Scroll_Address1()
	{
		
	}
	public void Customer_AddressLine1(String address)
	{
		type("#com.commusoft.v4:id/formaddressLine1", address);
	}
	public void Customer_Save() throws InterruptedException
	{
		click("//android.widget.TextView[@content-desc=\"Save\"]");
		Thread.sleep(4000);
	}
	public void Customer_Fav()
	{
		click("#com.commusoft.v4:id/favoriteIcon");
	}
	public void Customer_Back()
	{
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	}
	public void Customer_search() throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/search_button");
	}
	public void Customer_Searchtext(String name)
	{
		type("#com.commusoft.v4:id/search_src_text", name);
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
		Thread.sleep(2000);
		click("//android.widget.ImageButton[@content-desc=\"Menu closed\"]");
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
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		Thread.sleep(3000);
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
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
		click("//android.widget.TextView[@content-desc=\"Edit\"]");
		Thread.sleep(3000);
		
	}
	public void Customer_More() throws InterruptedException
	{
		Thread.sleep(3000);
		click("//android.widget.TextView[@content-desc=\"Open\"]");//more
		Thread.sleep(3000);
	}
	public void Customer_Ongoing() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='On going work']");//on going
		Thread.sleep(2000);
	}
	public void Customer_PlusBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/fab_expand_menu_button");//+ button
		Thread.sleep(2000);
	}
	public void Reminders() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Reminders']");
		Thread.sleep(2000);
	}
	public void Reminderplus() throws InterruptedException
	{
		click("#com.commusoft.v4:id/fab_expand_menu_button");
		Thread.sleep(2000);
	}
	public void ServiceReminder() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Add new service reminder']");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/spinnerserviceTypeView");
		Thread.sleep(2000);
	}
	public void SelectReminder() throws InterruptedException
	{
		click("//android.widget.TextView[@text='AC service']");
		Thread.sleep(2000);
	}
	public void ReminderDate() throws InterruptedException
	{
		click("#com.commusoft.v4:id/spinnerDateLayout");
		Thread.sleep(2000);
		click("//android.widget.Button[@text='DONE']");
		Thread.sleep(5000);
	}
	public void Sendto(String titleCustomername) throws InterruptedException
	{
		Thread.sleep(3000);
		click("#com.commusoft.v4:id/spinnersendToView");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='"+titleCustomername+" - Email']");
		Thread.sleep(4000);
	}
	public void WA() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Work addresses']");
		Thread.sleep(2000);
	}
	public void WA_Add() throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/add");
		Thread.sleep(2000);
	}
	public void WA_Name(String name) throws InterruptedException
	{
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/firstNameValue", name);
		Thread.sleep(2000);
	}
	public void WA_Surname(String lastname) throws InterruptedException
	{
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/surnameValue", lastname);
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
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/formaddressLine1", add);
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
}
