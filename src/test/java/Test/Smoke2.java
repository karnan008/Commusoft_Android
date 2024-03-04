package Test;

import org.testng.annotations.Test;

import MainPack.BaseClass;
import MainPack.BaseClassForWebAndMobile;
import MainPack.TabletBaseClassForWebAndMobile;
import MobAndWeb_Page.EditCustomerInWebAndVerifyInMob;
import MobAndWeb_Page.NewUI_EditCustomerOnMob;
import MobAndWeb_Page.Newui_CreateCustomerOnMob;
import MobAndWeb_Page.VerifyCustomerOnWeb;
import MobAndWeb_Page.VerifyNotesInWeb;
import Pages.Abort_Event;
import Pages.AddNotes_ForWorkAddress;
import Pages.Add_Notes;
import Pages.Assets;
import Pages.AttachedFiles_ForWorkAddresss;
import Pages.Attached_Files;
import Pages.Certificate;
import Pages.CompleteJobFromEstimate;
import Pages.Customer;
import Pages.Diary;
import Pages.Edit_Customer;
import Pages.Edit_WorkAddress;
import Pages.Estimate;
import Pages.InvoiceBreakdown;
import Pages.InvoiceType;
import Pages.Job;
import Pages.Parts;
import Pages.PickUpParts;
import Pages.Pre_Invoice;
import Pages.Rebook_Event;
import Pages.Web_Settings;

public class Smoke2 extends BaseClassForWebAndMobile
{
	@Test(priority=0)
	public void CreateCustomerAndVerifyInWeb() throws InterruptedException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
	    Customer customer = new Customer(driver);
	    VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.FabIcon();
		newui_CreateCustomerOnMob.AddProperty();
		newui_CreateCustomerOnMob.Typeofproperty();
		newui_CreateCustomerOnMob.Click_Customer();
		newui_CreateCustomerOnMob.TypeofCustomer();
		newui_CreateCustomerOnMob.Click_PrivateCustomer();
		customer.Customer_title(Title);
		customer.Customer_Name(Name);
		customer.Customer_SurName(Surname);
		customer.Customer_Telephone("8248724397");
		customer.Customer_Mobile("8248724397");
		customer.Customer_email("ssaravanan@commusoft.com");
		customer.Customer_AddressLine1("Address line 1");
		customer.Customer_Save();
		ThreeSec();
		customer.StoreCustomerNumber();
		verifyCustomerOnWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		verifyCustomerOnWeb.EnableNewUI();
		verifyCustomerOnWeb.VerifyCustomerNumber();
		verifyCustomerOnWeb.VerifyName(Title,Name,Surname);
		
	}
	
	@Test(priority=3)
	public void AddNotesForCustomer() throws InterruptedException 
	{


		AddNotes_ForWorkAddress addNotes_ForWorkAddress = new AddNotes_ForWorkAddress(driver);
		Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
		Customer customer = new Customer(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Edit_Customer edit_Customer = new Edit_Customer(driver);
		NewUI_EditCustomerOnMob newUI_EditCustomerOnMob = new NewUI_EditCustomerOnMob(driver);
		
		add_Notes.Click_Choc_MenuButton();
		add_Notes.Click_NotesSection();
		add_Notes.Click_FabIcon();
		add_Notes.Click_Addnewnote();
		add_Notes.Enter_Title(NoteTitle);
		add_Notes.Enter_Note(Note);
		customer.Customer_Save();
		add_Notes.Click_ExpandedFabIcon();
		scrolltothedown(405,738,392,1816);//For Refresh The Page
		add_Notes.Click_FabIcon();
		add_Notes.Click_Add_new_phone_call();
		add_Notes.Click_Calltype_Dropdown();
		add_Notes.Select_IncomingCall();
		add_Notes.Click_ContactName_Dropdown();
		add_Notes.Select_ContactName(WebName, Surname);
		add_Notes.Click_ContactNumber_Dropdown();
		add_Notes.Select_ContactNumber();
		add_Notes.EnterNoteForPhoneCall(NoteForPhoneCall);
		customer.Customer_Save();
		add_Notes.Click_ExpandedFabIcon();
		scrolltothedown(405,738,392,1816);
		add_Notes.Click_FabIcon();
		add_Notes.Click_Sendnewemail();
		add_Notes.Click_To();
		add_Notes.Select_Email();
		customer.Customer_Save();
		add_Notes.EnterSubject(SubjectForEmail);
		customer.Customer_Save();
		add_Notes.Click_ExpandedFabIcon();
		scrolltothedown(405,738,392,1816);
		add_Notes.Click_FabIcon();
		add_Notes.Click_SendnewSMS();
		add_Notes.Click_SMSContactName_Dropdown();
		add_Notes.Select_ContactName(WebName, Surname);
		add_Notes.Click_ToContactNumber_Dropdown();
		add_Notes.Select_ContactNumber();
		add_Notes.Enter_Message(MessageForSMS);
		customer.Customer_Save();
		add_Notes.Click_ExpandedFabIcon();
		scrolltothedown(405,738,392,1816);
		add_Notes.Verify_Note(NoteTitle);
		add_Notes.Verify_PhoneCall(NoteForPhoneCall);
		add_Notes.Verify_Email(SubjectForEmail);
		add_Notes.Verify_SMS(MessageForSMS);
	}
	
	@Test(priority=4)
	public void VerifyCustomerNotesInWeb() 
	{
		VerifyNotesInWeb verifyNotesInWeb = new VerifyNotesInWeb(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		verifyNotesInWeb.CommunicationTab();
		verifyNotesInWeb.VerifyNote(NoteTitle);
		verifyNotesInWeb.VerifyPhoneCall(NoteForPhoneCall);
		verifyNotesInWeb.VerifyEmail(SubjectForEmail);
		verifyNotesInWeb.VerifySMS(MessageForSMS);
		
		
	}

	

}
