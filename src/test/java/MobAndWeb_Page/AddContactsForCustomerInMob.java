package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AddContactsForCustomerInMob extends Wrapper{
	
	public AddContactsForCustomerInMob(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
//	add_Notes.Click_Choc_MenuButton();
	public void Contacts() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Contacts']");
		click("//*[@text='Contacts']");
	}
//	add_Notes.Click_FabIcon();
	public void NewContact()
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Create new contact']");
		click("//*[@text='Create new contact']");
	}
	public void Contact_Title(String title) //*[@text='Title']/following-sibling::*[1]
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Title']/following-sibling::*[1]");
		click("//*[@text='Title']/following-sibling::*[1]");
		ExplicitWait_ElementToBeClickable("//*[@text='"+title+"']");
		click("//*[@text='"+title+"']");//Mr & Mrs
	}
	public void ContactSurname(String contact) 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/contactSurNameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/contactSurNameValue']", contact);
	}
//	attached_Files.Click_Save();
	
	public void VerifyContact(String contact) 
	{
		
		ExplicitWait_PresenceOfEle("//*[contains(@text,'"+contact+"')]");
		MobileElement contacttext = driver.findElement(By.xpath("//*[contains(@text,'"+contact+"')]"));
		Verify_AssertTrue(contacttext);
	}

	public void Lastname(String contact) 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.EditText'])[3]");
		type("(//*[@class='android.widget.EditText'])[3]", contact);//CustomerContact
	}
	public void ContactBack() 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[3]");
		click("(//*[@class='android.widget.ImageView'])[3]");
	}
//----------------------------------------------------------><------------------------------------------------------------	
	
	public AddContactsForCustomerInMob(WebDriver wdriver) 
	{
		this.driverWeb=wdriver;
	}
	
	public void Web_Contacts() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Contacts']");
		Webclick("//span[text()='Contacts']");
	}
	
	public void AddNewContacts() 
	{
		ExplicitWait_PresenceOfEle2("//a[text()='Add new contact']");
		Webclick("//a[text()='Add new contact']");
	}
	
	public void Surname(String surname_contact) 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='contact_surname']");
		typeForWeb("//input[@id='contact_surname']", surname_contact);
	}
	
	public void AddContact() 
	{
		TwoSec();
		ScrollWeb("//span[text()='Add contact']");
		ExplicitWait_PresenceOfEle2("//span[text()='Add contact']");
		Webclick("//span[text()='Add contact']");
	}
	
	public void Verify_AddedContacts_InListScreen(String surname_contact) 
	{
		
		ExplicitWait_PresenceOfEle2("//td[contains(text(),'"+surname_contact+"')]");
		AssertTrueWeb("//td[contains(text(),'"+surname_contact+"')]");
	}
	
	
}
