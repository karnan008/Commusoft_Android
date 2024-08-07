package New_ui_Testclass;




import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainPack.BaseClassForWebAndMobile;
import MobAndWeb_Page.AddContactsForCustomerInMob;
import MobAndWeb_Page.CustomerWeb;
import MobAndWeb_Page.EditCustomerInWebAndVerifyInMob;
import MobAndWeb_Page.EstimateAccept;
import MobAndWeb_Page.EstimateReject;
import MobAndWeb_Page.Invoice_Web;
import MobAndWeb_Page.Job;
import MobAndWeb_Page.NewUI_EditCustomerOnMob;
import MobAndWeb_Page.Newui_CreateCustomerOnMob;
import MobAndWeb_Page.NotesAndCommunication;
import MobAndWeb_Page.Settings;
import MobAndWeb_Page.VerifyAcceptEstimateOnWeb;
import MobAndWeb_Page.VerifyCompletedJobAndInvoice;
import MobAndWeb_Page.VerifyCustomerOnWeb;
import MobAndWeb_Page.VerifyEditedCustomerOnWeb;
import MobAndWeb_Page.VerifyNotesInWeb;
import MobAndWeb_Page.VerifyRejectedEstimateInWeb;
import MobAndWeb_Page.Web_Estimate;
import MobAndWeb_Page.Web_Job;
import Pages.Add_Notes;
import Pages.Certificate;
import Pages.Customer;
import Pages.Estimate;
import Pages.InvoiceBreakdown;
import Pages.NewUI_Notes;
import Pages.Pre_Invoice;
import Utility.ExcelReader;
import Utility.RerunTestCase;
import io.appium.java_client.MobileElement;


@Listeners(Commusoft_WebAndMobile.class)
public class Commusoft_WebAndMobile extends BaseClassForWebAndMobile {
	
	
	
	//(Note: Ensure that the mobile user must be an Engineer with invoicing role)
	//Verify the reset on web settings (Test case: 34 and 39)
	//Verify that the Demo method is enabled in this class by searching 'Demo'
	//Verify that the clashing events shouldn't happens in the mobile.
	//Ensure that all the apps should not opened in mobile
	//Ensure to open the runnable app and kill it.
	//Ensure to eanble the @Listeners class, if any of the test case failed, it will rerun the failed case after execution
	@BeforeSuite(alwaysRun = true)
	public void CurrentClassName() 
	{
		Commusoft_WebAndMobile commusoft_WebAndMobile = new Commusoft_WebAndMobile();
		simpleName = commusoft_WebAndMobile.getClass().getSimpleName();
		System.err.println("Current class name is: "+simpleName);
		Running_UserName = System.getProperty("user.name");
        System.out.println("Current running user name: " + Running_UserName);
	}
	@Test(priority = 1, retryAnalyzer = RerunTestCase.class)
	public void Add_CustomerInWeb() throws InterruptedException, IOException
	{
		CustomerWeb customerWeb = new CustomerWeb(driverWeb);
		customerWeb.Private_Customer();
		customerWeb.Customer_title();
		customerWeb.Customer_Name(WebName);
		customerWeb.Customer_SurName(Surname);
		customerWeb.Customer_Mobile(EditMob);
		customerWeb.Customer_email(CustomerEmail);
		customerWeb.Customer_AddressLine1(Address);
		customerWeb.Customer_Save();
//		verifyCustomerOnWeb.EnableNewUI();
		customerWeb.StoreAccountNumber();
		customerWeb.StoreCustomerName(WebName, Surname);
		customerWeb.StoreEmail(CustomerEmail);
	}

	@Test(priority = 2, retryAnalyzer = RerunTestCase.class)
	public void VerifyWebCustomerInMobile() throws AWTException, InterruptedException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
	
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		newui_CreateCustomerOnMob.VerifyWebCustomerName();
		newui_CreateCustomerOnMob.VerifyWebCustomerEmail();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		
		
	
	}
	@Test(priority = 3, retryAnalyzer = RerunTestCase.class)
	public void EditCustomerInWeb() throws InterruptedException 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		CustomerWeb customerWeb = new CustomerWeb(driverWeb);
		verifyCustomerOnWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		customerWeb.EditWebCustomer(EditWebCustomerName);
		customerWeb.Customer_Save();
		customerWeb.StoreCustomerName(EditWebCustomerName, Surname);
	}
	
	@Test(priority = 4, retryAnalyzer = RerunTestCase.class)
	public void VerifyWebEditedCustomerInMobile() throws AWTException, InterruptedException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		newui_CreateCustomerOnMob.VerifyWebCustomerName();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
	}
	
	@Test(priority=5, retryAnalyzer = RerunTestCase.class)
	public void CommunicationForWebCustomer() 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		NotesAndCommunication notesAndCommunication = new NotesAndCommunication(driverWeb);
		verifyCustomerOnWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		notesAndCommunication.communicationtab();
		notesAndCommunication.AddRecord();
		notesAndCommunication.AddNewNote();
		notesAndCommunication.NoteTitle(NoteTitle);
		notesAndCommunication.Notes(Note);
		notesAndCommunication.ShareOnMobile();
		notesAndCommunication.Save();
		notesAndCommunication.AddRecord();
		notesAndCommunication.Call();
		notesAndCommunication.Call_To(EditMob);
		notesAndCommunication.Save();
		notesAndCommunication.AddRecord();
		notesAndCommunication.SendNewEmail();
		notesAndCommunication.email_To();
		notesAndCommunication.SelectEmail();
		notesAndCommunication.email_Subject(WebEmailSub);
		notesAndCommunication.Send();
		notesAndCommunication.AddRecord();
		notesAndCommunication.SendNewSMS();
		notesAndCommunication.sms_To(EditMob);
		notesAndCommunication.sms_UseTemplate();
		notesAndCommunication.sms_SelectTemplate();
		notesAndCommunication.Send();
	}
	@Test(priority=6, retryAnalyzer = RerunTestCase.class)
	public void Verify_Customer_Communication_InMobile() throws AWTException, InterruptedException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		NewUI_Notes newUI_Notes = new NewUI_Notes(driver);
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		add_Notes.Click_NotesSection();
		newUI_Notes.Verify_AddedNote();
		newUI_Notes.Verify_PhoneCall();
		newUI_Notes.Verify_Email();
		newUI_Notes.Verify_SMS();
		newUI_Notes.Communication_Back();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
	}
	
	@Test(priority=7, retryAnalyzer = RerunTestCase.class)
	public void ContactsForWebCustomer() 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		AddContactsForCustomerInMob addContactsForCustomerInweb = new AddContactsForCustomerInMob(driverWeb);

		verifyCustomerOnWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		addContactsForCustomerInweb.Web_Contacts();
		addContactsForCustomerInweb.AddNewContacts();
		addContactsForCustomerInweb.Surname(WebContact);
		addContactsForCustomerInweb.AddContact();
		addContactsForCustomerInweb.Verify_AddedContacts_InListScreen(WebContact);
		
	}
	
	@Test(priority=8, retryAnalyzer = RerunTestCase.class)
	public void Verify_CustomerContactsInMobile() throws AWTException, InterruptedException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		AddContactsForCustomerInMob addContactsForCustomerInMob = new AddContactsForCustomerInMob(driver);
		
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		addContactsForCustomerInMob.Contacts();
		addContactsForCustomerInMob.VerifyContact(WebContact);
		addContactsForCustomerInMob.ContactBack();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		
		
		
	}
	
	@Test(priority=9, retryAnalyzer = RerunTestCase.class)
	public void CreateCustomerInMob_AndVerifyInWeb() throws InterruptedException 
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
//		verifyCustomerOnWeb.EnableNewUI();
		verifyCustomerOnWeb.VerifyCustomerNumber();
		verifyCustomerOnWeb.VerifyName(Title,Name,Surname);
		
	}
	
	@Test(priority=10, retryAnalyzer = RerunTestCase.class)
	public void EditCustomerInMob_AndVerifyInWeb() throws InterruptedException 
	{
		NewUI_EditCustomerOnMob newUI_EditCustomerOnMob = new NewUI_EditCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		VerifyEditedCustomerOnWeb verifyEditedCustomerOnWeb = new VerifyEditedCustomerOnWeb(driverWeb);
	    VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		newUI_EditCustomerOnMob.Click_Customer();
		newUI_EditCustomerOnMob.Click_EditButton();
		newUI_EditCustomerOnMob.Edit_Name(EditName);
		newUI_EditCustomerOnMob.Edit_Landline(EditLandline);
		newUI_EditCustomerOnMob.Edit_Mobile(EditMob);
		newUI_EditCustomerOnMob.Edit_Email(EditEmail);
		newUI_EditCustomerOnMob.Edit_AddressLine1(EditAddress1);
		customer.Customer_Save();
		newUI_EditCustomerOnMob.Verify_EditedEmail(EditEmail);
		newUI_EditCustomerOnMob.Verify_EditedMobile(EditMob);
		newUI_EditCustomerOnMob.Verify_EditedLandline(EditLandline);
		newUI_EditCustomerOnMob.Verify_EditedAddress1(EditAddress1);
		customer.Customer_Back();
		newUI_EditCustomerOnMob.Verify_EditedName(Title, EditName, Surname);
		verifyEditedCustomerOnWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
//		verifyCustomerOnWeb.EnableNewUI();
		verifyCustomerOnWeb.VerifyCustomerNumber();
		verifyEditedCustomerOnWeb.Verify_EditedName(Title,EditName, Surname);
		verifyEditedCustomerOnWeb.Verify_EditedAddress(EditAddress1);
		verifyEditedCustomerOnWeb.Verify_EditedEmail(EditEmail);
		
	}
	
	
	@Test(priority=11, retryAnalyzer = RerunTestCase.class)
	public void AddCommunicationForCustomerInMobile() throws InterruptedException, AWTException 
	{


		
		Add_Notes add_Notes = new Add_Notes(driver);
		
		NewUI_Notes newUI_Notes = new NewUI_Notes(driver);
		
		add_Notes.Click_Choc_MenuButton();
		add_Notes.Click_NotesSection();
		newUI_Notes.FabIcon();
		add_Notes.Click_Addnewnote();
		newUI_Notes.Title(NoteTitle);
		newUI_Notes.Enter_Note(Note);
		newUI_Notes.Save();
		newUI_Notes.Verify_AddedNote();
		newUI_Notes.FabIcon();
		newUI_Notes.NewPhoneCall();
		newUI_Notes.Call_Type();
		newUI_Notes.ContactNameSearch();
		newUI_Notes.PhoneNote(NoteForPhoneCall);
		newUI_Notes.Save();
		newUI_Notes.Verify_PhoneCall();
		newUI_Notes.FabIcon();
		add_Notes.Click_Sendnewemail();
		newUI_Notes.Search_To();
		newUI_Notes.Subject(SubjectForEmail);
		newUI_Notes.ComposeEmail(ComposeEmail);
		newUI_Notes.sendEmail();
		newUI_Notes.Verify_Email();
		newUI_Notes.FabIcon();
		add_Notes.Click_SendnewSMS();
		newUI_Notes.SelectContactName();
		newUI_Notes.ComposeSMS(MessageForSMS);
		newUI_Notes.sendSMS();
		newUI_Notes.Verify_SMS();
		newUI_Notes.Communication_Back();
		
		
	}
	
	@Test(priority=12, retryAnalyzer = RerunTestCase.class)
	public void VerifyMobileCustomerCommunicationInWeb() 
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
	
	@Test(priority=13, retryAnalyzer = RerunTestCase.class)
	public void CreateEstimateDiaryEventInWeb_ForAccept() 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Estimate.AddNewEstimate();
		web_Estimate.Select_EstimateTemplate();
		ScrollWeb("//span[text()='Add estimate']");
		web_Estimate.SelectDiaryEvent();
		web_Estimate.Save_Estimate();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Estimate.StoreEstimateNumber();
		
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.RemoveNotification();
		
		
	}
	
	@Test(priority=14, retryAnalyzer = RerunTestCase.class)
	public void Complete_Estimate_DiaryEvent_WithPrice_InMobile() throws AWTException, InterruptedException, IOException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Estimate estimate = new Estimate(driver);
	    
//		newui_CreateCustomerOnMob.Search_Tab();
//		estimateAccept.SearchEstimateByNumber();
//		estimateAccept.SelectEstimate();
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		estimateAccept.StoreEstimateNumber();
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		estimate.Diary_FillinEstimate();
		estimate.FillinEstimate_Price();
		estimate.Price_NoBreakdown();
		estimate.Price_NoBreakdownselect(Breakdown);
		estimate.Breakdown_value("100");
		estimate.save();
		estimate.Invoice_Schedule();
		estimate.save();
		estimate.AcceptReject();
		estimate.Estimate_Checkbox();
		estimate.Estimate_Accept();
		estimate.YES();
		
		ScrollDown24("ACCEPT");
		Thread.sleep(4000);
		Estimatesignature(361, 1743, 718, 1686);//Added By Saravanan
		estimate.Estimate_Acceptbtn();
		estimate.Estimate_Leave();
	
		ThreeSec();
		signature(234, 1255, 658, 1246);//simulator 
	
		estimate.Sign_save();
		ThreeSec();
		Estimatesignature(266, 916, 731, 900);//simulator
		estimate.Sign_save();
		estimate.Verify_Status();
	    estimate.Verify_JobConvertionStatus();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
	}
	@Test(priority=15, retryAnalyzer = RerunTestCase.class)
	public void AcceptedEstimate_StatusAndNotification_Verification_InWeb() 
	{
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyAcceptEstimateOnWeb.verify_EstimateAcceptedStatus();
		verifyAcceptEstimateOnWeb.verify_JobCovertionStatus();
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.verify_AcceptedNotification();
		verifyAcceptEstimateOnWeb.RemoveNotification();
	}
	
	@Test(priority=16, retryAnalyzer = RerunTestCase.class)
	public void CreateEstimateDiaryEventInWeb_ForReject() 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Estimate.AddNewEstimate();
		web_Estimate.Select_EstimateTemplate();
		ScrollWeb("//span[text()='Add estimate']");
		web_Estimate.SelectDiaryEvent();
		web_Estimate.Save_Estimate();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Estimate.StoreEstimateNumber();
		
	}
	
	@Test(priority=17, retryAnalyzer = RerunTestCase.class)
	public void Reject_Estimate_DiaryEvent_InMob() throws AWTException, InterruptedException, IOException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Estimate estimate = new Estimate(driver);
	    EstimateAccept estimate2 = new EstimateAccept(driver);
		EstimateReject estimateReject = new EstimateReject(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		estimateAccept.SearchEstimateByNumber();
//		estimateAccept.SelectEstimate();
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
		estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimate2.StoreEstimateNumber();
		estimateReject.Reject();
		estimateReject.Reject_FeedbackReason();
		estimate.save();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
	}
	@Test(priority=18, retryAnalyzer = RerunTestCase.class)
	public void RejectedEstimate_Status_Verification_InWeb() throws InterruptedException, IOException 
	{
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyRejectedEstimateInWeb.verify_RejectStatus();
	
	}

	@Test(priority=19, retryAnalyzer = RerunTestCase.class)
	public void CreateEstimateDiaryEventInWeb_ForAbort() 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Estimate.AddNewEstimate();
		web_Estimate.Select_EstimateTemplate();
		ScrollWeb("//span[text()='Add estimate']");
		web_Estimate.SelectDiaryEvent();
		web_Estimate.Save_Estimate();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Estimate.StoreEstimateNumber();
		
	}
	
	@Test(priority=20, retryAnalyzer = RerunTestCase.class)
	public void Abort_Estimate_DiaryEvent_InMob() throws AWTException, InterruptedException, IOException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Estimate estimate = new Estimate(driver);
	    EstimateAccept estimate2 = new EstimateAccept(driver);
		EstimateReject estimateReject = new EstimateReject(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		estimateAccept.SearchEstimateByNumber();
//		estimateAccept.SelectEstimate();
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
		estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimate2.Diary_Accept();
		estimate2.StoreEstimateNumber();
		estimateReject.Abort();
		estimateReject.Abort_FeedbackReason();
		estimate.save();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
	}
	
	@Test(priority=21, retryAnalyzer = RerunTestCase.class)
	public void AbortedEstimate_Status_Verification_InWeb() throws InterruptedException, IOException 
	{
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyRejectedEstimateInWeb.verify_AbortedStatus();
	
	}
	
	@Test(priority = 22, retryAnalyzer = RerunTestCase.class)
	public void Create_EstimateWithoutSurveyTemplate_InWeb() 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		Settings settings = new Settings(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		settings.Log_Out();
		settings.OwnerLogin();
		settings.Setting();
		settings.Estimates();
		settings.Estimate_survey_template();
		settings.No_leave_template();
		settings.Log_Out();
		settings.OfficestaffLogin();
		
		
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Estimate.AddNewEstimate();
		web_Estimate.Select_EstimateTemplate2();
		ScrollWeb("//span[text()='Add estimate']");
		web_Estimate.SelectDiaryEvent();
		web_Estimate.Save_Estimate();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Estimate.StoreEstimateNumber();
		
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.RemoveNotification();
	}
	
	
	@Test(priority = 23, retryAnalyzer = RerunTestCase.class)
	public void Complete_Estimate_without_price_and_QA_InMob() throws AWTException, InterruptedException, IOException 
	{

		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Estimate estimate = new Estimate(driver);
	    Settings settings = new Settings(driverWeb);
//		newui_CreateCustomerOnMob.Search_Tab();
//		estimateAccept.SearchEstimateByNumber();
//		estimateAccept.SelectEstimate();
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		estimateAccept.StoreEstimateNumber();
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		estimate.Estimate_Leave();
	
		ThreeSec();
		Estimatesignature(234, 1255, 658, 1246);//simulator 
	
		estimate.Sign_save();
		ThreeSec();
		signature(266, 916, 731, 900);//simulator
		estimate.Sign_save();
		estimate.Verify_Status();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
		Logout();
		Owner_Login();
		settings.Setting();
		settings.Estimates();
		settings.Estimate_survey_template();
		settings.Yes_leave_template();
		Logout();
		Officestaff_Login();
		
	
	}
	
	@Test(priority=24, retryAnalyzer = RerunTestCase.class)
	public void Verify_StatusOf_Estimate_Without_Price_And_QA_InWeb() 
	{
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyAcceptEstimateOnWeb.verify_LeftStatus();
	}
	
	@Test(priority=25, retryAnalyzer = RerunTestCase.class)
	public void CreateJobDiaryEventInWeb_UsingNewQuestionTemplate() throws InterruptedException 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
		
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.RemoveNotification();
	}
	
	@Test(priority=26, retryAnalyzer = RerunTestCase.class)//Crashes happen
	public void Complete_Job_With_Nobreakdown_FinalInvoiceAndPaymentOnMobile_UsingNewQuestionTemplate() throws AWTException, InterruptedException, IOException 
	{
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Job job = new Job(driver);
	    Pages.Job job2 = new Pages.Job(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		
		
		
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.Final_Invoice();
		job2.Invoice_Description();
		ScrollDown24Contains("Invoice category");
		job2.Invoice_Category();
		job2.Invoice_Next();
		job2.Breakdown_Value("100");
		job2.ExceptionHandling_For_DataNotLoad_InInvoiceScreen();
		job2.Invoice_Saves();
		job2.Payment();
		job2.SelectOtherOptionAndMethod_Value();
		job2.Nominal_Value();
		job2.Payment_Save();
		job2.Job_Status();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
		
	}
	
	@Test(priority=27, retryAnalyzer = RerunTestCase.class)
	public void Verify_CompletedJob_WithNoBreakdown_FinalInvoice_AndPaymentOnWeb_UsingNewQuestionTemplate() 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.VerifyJobstatus();
		verifyCompletedJobAndInvoice.VerifyInvoice();
		verifyCompletedJobAndInvoice.Invoice_Tab();
		verifyCompletedJobAndInvoice.Verify_Invoice_Final_Status();
		verifyCompletedJobAndInvoice.Verify_Invoice_Payment_Status();
		
	}
	
	@Test(priority=28, retryAnalyzer = RerunTestCase.class)
	public void CreateJobDiaryEventInWeb_UsingOldSetup_WithQuestionAndSignature() throws InterruptedException 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		Settings settings = new Settings(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		settings.Log_Out();
		settings.OwnerLogin();
		settings.Setting();
		settings.job();
		settings.job_arrive_question_template();
		settings.yes_ArriveQuestion();
		settings.Back_Setting();
		settings.job();
		settings.job_report_template();
		settings.yes_LeaveQuestion();
		settings.Back_Setting();
		settings.job();
		settings.job_arrive_signature_setting();
		settings.yes_ArriveSignature();
		settings.ArriveSignatureMessage();
	    settings.Save_SignatureSetup();
		settings.Back_Setting();
		settings.job();
		settings.job_report_signature_setting();
		settings.yes_LeaveSignature();
		settings.LeaveSignatureMessage();
	    settings.Save_SignatureSetup();
		settings.Log_Out();
		settings.OfficestaffLogin();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job2(AutomationOldQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
		
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.RemoveNotification();
	}
	
	
	@Test(priority=29, retryAnalyzer = RerunTestCase.class)
	public void Complete_Job_With_BreakdownByCategory_FinalInvoiceAndPaymentOnMobile_UsingOldSetup_Including_QuestionAndSignature() throws InterruptedException, AWTException, IOException 
	{
	    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
	    Pages.Job job = new Pages.Job(driver);
	    Estimate estimate = new Estimate(driver);
	    Job job3 = new Job(driver);
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
//	    newui_CreateCustomerOnMob.Search_Tab();
//	    job3.SearchJobByNumber();
//		job3.SelectJob(AutomationOldQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job3.StoreJobNumber();
	    
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		
//		job.Arrive_Question1(ArriveAnswer);
		job.Sign_save();
		
		signature(284, 1414, 805, 1468);
		job.Sign_save();
		job.Job_Report();
//		job.LeaveQuestion2(LeaveAnswer);
		job.Sign_save();
		job.Job_Leave();
		job.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job.Sign_save();
		signature(310, 868, 791, 941);
		job.Sign_save();
		job.Final_Invoice();
		job.Invoice_Description();
		ScrollDown24Contains("Invoice category");
		job.Invoice_Category();
		job.Invoice_Next();
		invoiceBreakdown.Click_InvoiceBreakdown_Dropdown();
		invoiceBreakdown.Select_BreakdownByCategory();
		invoiceBreakdown.Click_FabIcon_InInvoiceScreen();
		invoiceBreakdown.Click_CategoryDropdown();
		invoiceBreakdown.Select_Parts();
		invoiceBreakdown.Type_Total("500");
		estimate.Savebtn();
		job.Invoice_Saves();
		job.Payment();
		job.SelectOtherOptionAndMethod_Value();
		job.Nominal_Value();
		job.Payment_Save();
		job.Job_Status();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
	}
	@Test(priority=30, retryAnalyzer = RerunTestCase.class)
	public void Verify_CompletedJob_WithBreakdownByCategory_FinalInvoice_AndPaymentOnWeb_UsingOldSetup_Including_QuestionAndSignature() 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.VerifyJobstatus();
		verifyCompletedJobAndInvoice.VerifyInvoice();
		verifyCompletedJobAndInvoice.Invoice_Tab();
		verifyCompletedJobAndInvoice.Verify_Invoice_Final_Status();
		verifyCompletedJobAndInvoice.Verify_Invoice_Payment_Status();
		
	}
	
	@Test(priority=31, retryAnalyzer = RerunTestCase.class)
	public void CreateJobDiaryEventInWeb_UsingOldSetup_WithoutQuestionAndSignature() throws InterruptedException 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		Settings settings = new Settings(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		settings.Log_Out();
		settings.OwnerLogin();
		settings.Setting();
		settings.job();
		settings.job_arrive_question_template();
		settings.no_ArriveQuestion();
		settings.Back_Setting();
		settings.job();
		settings.job_report_template();
		settings.no_LeaveQuestion();
		settings.Back_Setting();
		settings.job();
		settings.job_arrive_signature_setting();
		settings.no_ArriveSignature();
	    settings.Save_SignatureSetup();
		settings.Back_Setting();
		settings.job();
		settings.job_report_signature_setting();
		settings.no_LeaveSignature();
	    settings.Save_SignatureSetup();
		settings.Log_Out();
		settings.OfficestaffLogin();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job2(AutomationOldQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
		
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.RemoveNotification();
	}
	@Test(priority=32, retryAnalyzer = RerunTestCase.class)
	public void Complete_Job_With_FullBreakdown_FinalInvoiceAndPaymentOnMobile_UsingOldSetup_WithoutQuestionAndSignature() throws InterruptedException, AWTException, IOException 
	{
	    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
	    Pages.Job job = new Pages.Job(driver);
	    Estimate estimate = new Estimate(driver);
	    Job job3 = new Job(driver);
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
//	    newui_CreateCustomerOnMob.Search_Tab();
//	    job3.SearchJobByNumber();
//		job3.SelectJob(AutomationOldQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job3.StoreJobNumber();
	    
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		
		job.Job_Report();
		job.Job_Leave();
		job.Complete_Continue();
		signature(310, 868, 791, 941);
		job.Sign_save();
		job.Final_Invoice();
		job.Invoice_Description();
		ScrollDown24Contains("Invoice category");
		job.Invoice_Category();
		job.Invoice_Next();
		invoiceBreakdown.Click_InvoiceBreakdown_Dropdown();
		invoiceBreakdown.Select_FullBreakdown();
		invoiceBreakdown.Click_FabIcon_InInvoiceScreen();
		invoiceBreakdown.Type_BreakdownDes();
		invoiceBreakdown.Type_BreakdownQuantity();
		invoiceBreakdown.Type_UnitPrice();
		estimate.Savebtn();
		job.Invoice_Saves();
		job.Payment();
		job.SelectOtherOptionAndMethod_Value();
		job.Nominal_Value();
		job.Payment_Save();
		job.Job_Status();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
	}
	
	@Test(priority=33, retryAnalyzer = RerunTestCase.class)
	public void Verify_CompletedJob_WithFullBreakdown_FinalInvoiceAndPaymentOnWeb_UsingOldSetup_WithoutQuestionAndSignature() 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.VerifyJobstatus();
		verifyCompletedJobAndInvoice.VerifyInvoice();
		verifyCompletedJobAndInvoice.Invoice_Tab();
		verifyCompletedJobAndInvoice.Verify_Invoice_Final_Status();
		verifyCompletedJobAndInvoice.Verify_Invoice_Payment_Status();
		
	}
	
	@Test(priority=34, retryAnalyzer = RerunTestCase.class)
	public void Reset_OldQuestionSetup() throws InterruptedException 
	{

		Settings settings = new Settings(driverWeb);
		
		settings.Log_Out();
		settings.OwnerLogin();
		settings.Setting();
		settings.job();
		settings.job_arrive_question_template();
		settings.yes_ArriveQuestion();
		settings.Back_Setting();
		settings.job();
		settings.job_report_template();
		settings.yes_LeaveQuestion();
		settings.Back_Setting();
		settings.job();
		settings.job_arrive_signature_setting();
		settings.yes_ArriveSignature();
		settings.ArriveSignatureMessage();
		settings.Save_SignatureSetup();
		settings.Back_Setting();
		settings.job();
		settings.job_report_signature_setting();
		settings.yes_LeaveSignature();
		settings.LeaveSignatureMessage();
		settings.Save_SignatureSetup();
		settings.Log_Out();
		settings.OfficestaffLogin();
		
	
	}
	
	@Test(priority=35, retryAnalyzer = RerunTestCase.class) // Ticket no: QA-302  
	public void CreatePrefinalInvoiceOnMobile_Verify_PrefinalInvoiceOnWebAndMobile_Then_VerifyFinalInvoiceOnBothPlatform_AfterJobCompletion() throws AWTException, InterruptedException, IOException
	{ 
		//Create job in web
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
//		verifyAcceptEstimateOnWeb.Notification_Logo();
//		verifyAcceptEstimateOnWeb.SeeAllNotification();
//		verifyAcceptEstimateOnWeb.RemoveNotification();
		
		
		//Create prefinal invoice and verify in mobile and web(Full breakdown by category)
		EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Estimate estimate = new Estimate(driver);
	    Certificate certificate = new Certificate(driver);
	    Job job = new Job(driver);
	    Pages.Job job2 = new Pages.Job(driver);
	    Add_Notes add_Notes = new Add_Notes(driver);
		Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
		MobAndWeb_Page.Invoice invoice2 = new MobAndWeb_Page.Invoice(driver);
		InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
		estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		add_Notes.Click_Choc_MenuButton();
		pre_Invoice.Click_Invoice();
		pre_Invoice.Click_Invoice_Fabicon();
		invoice2.InvoiceType();
		invoice2.Select_PrefinalInvoice();
		pre_Invoice.Type_InvoiceDes(Preinvoice);
		pre_Invoice.Click_InvoiceCategoryDropdown();
		pre_Invoice.Select_InvoiceCategory();
		certificate.Next_InputType(CertificateInput);
		invoiceBreakdown.Click_InvoiceBreakdown_Dropdown();
		invoiceBreakdown.Select_FullBreakdownByCategory();
		invoiceBreakdown.Click_FabIcon_InInvoiceScreen();
		invoiceBreakdown.Click_CategoryDropdown();
		invoiceBreakdown.Select_Parts();
		invoiceBreakdown.Click_SearchButton();
		invoiceBreakdown.Click_Searchforpricingitem();
		invoiceBreakdown.Select_PricingItem();
		invoiceBreakdown.Type_BreakdownQuantity();
		job2.Click_Tick();
		job2.Invoice_Saves();
		pre_Invoice.Click_Exit();
		invoice2.Verify_Prefinal();
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.Invoice_Tab();
		verifyCompletedJobAndInvoice.Verify_Invoice_PrefinalStatus();
		
		
		//Complete job and verify final converted final invoice in mobile
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.Final_Invoice();
		job2.Job_Status();
		add_Notes.Click_Choc_MenuButton();
		pre_Invoice.Click_Invoice();
		invoice2.Verify_ConvertedFinalInvoice();
		
		
		//Verify final invoice in web
		verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.VerifyJobstatus();
		verifyCompletedJobAndInvoice.VerifyInvoice();
		verifyCompletedJobAndInvoice.Invoice_Tab();
		verifyCompletedJobAndInvoice.Verify_Invoice_Final_Status();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
	}
	
	@Test(priority=36, retryAnalyzer = RerunTestCase.class)//QA-326
	public void AddJobInWebAndCreateCertificateInMobileThenVerifyOnBothPlatform() throws AWTException, InterruptedException, IOException 
	{
		 
		//Create job in web
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
//		verifyAcceptEstimateOnWeb.Notification_Logo();
//		verifyAcceptEstimateOnWeb.SeeAllNotification();
//		verifyAcceptEstimateOnWeb.RemoveNotification();
		
		EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Certificate certificate = new Certificate(driver);
	    Job job = new Job(driver);
	    Pages.Job job2 = new Pages.Job(driver);
	    Add_Notes add_Notes = new Add_Notes(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		add_Notes.Click_Choc_MenuButton();
		
		certificate.Click_Certificate();
		certificate.Click_Fab();
		certificate.Search_Certificate(AllFieldsCertificate);
		certificate.Select_Certificate();
		certificate.Next_InputType(CertificateInput);
		certificate.Click_Finish();
		certificate.verify_CertificateNumber();
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();
		
		
		
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
	    Certificate certificate_Web = new Certificate(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
        certificate_Web.web_Certificate();
        certificate_Web.verify_WebCertificate();
		
		
	
	}
	
	@Test(priority=37, retryAnalyzer = RerunTestCase.class)// QA-319
	public void EditCertificateInWebAndVerifyModifiedCertificateOnMobile_FinallyEmailCertificateThenVerifyInMobileGmail() throws AWTException, InterruptedException, IOException 
	{           

		 
		//Create job in web
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
//		verifyAcceptEstimateOnWeb.Notification_Logo();
//		verifyAcceptEstimateOnWeb.SeeAllNotification();
//		verifyAcceptEstimateOnWeb.RemoveNotification();
		
		
		EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Certificate certificate = new Certificate(driver);
	    Job job = new Job(driver);
	    Pages.Job job2 = new Pages.Job(driver);
	    Add_Notes add_Notes = new Add_Notes(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		add_Notes.Click_Choc_MenuButton();
		
		certificate.Click_Certificate();
		certificate.Click_Fab();
		certificate.Search_Certificate(AutomationCertificate);
		
		
		
		
		certificate.Select_Certificate();
		certificate.Next_InputType(CertificateInput);
		certificate.Click_Finish();
		certificate.verify_CertificateNumber();
		
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
	    Certificate certificate_Web = new Certificate(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
        certificate_Web.web_Certificate();
		
        certificate_Web.CertificateFabIcon_Web();
        certificate_Web.EditForm();
        certificate_Web.SaveAndContinue(EditCertificateInput);
//        certificate_Web.SaveAndComplete(); ---> This method is not need, bcoz the previous method replaced that element
        estimateAccept.Click_Choc_MenuButton();
        certificate.Diary_Details();
        estimateAccept.Click_Choc_MenuButton();
    	certificate.Click_Certificate();
    	certificate.Click_CompletedCertificate();
        certificate.ViewOrPrint();
        certificate.DrivePDFViewer();
        certificate.Verify_ModifiedInputInPDF(EditCertificateInput);
        certificate.PDF_Back();
		
        
        job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();
		certificate.Click_CompletedCertificate();
		certificate.Email();
		certificate.To();
		certificate.CheckBox();
		job2.Sign_save();
		job2.Sign_save();
		ThreeSec();
		SwitchToGmailApp();
		certificate.Verify_CertificateOnGmailApp(AutomationCertificate);
		TwoSec();
		SwitchToV4();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
        
	
	}
	
	@Test(priority=38, retryAnalyzer = RerunTestCase.class)//QA-320
	public void CreateJobInWeb_WithoutCompletionOnMob_AndVerifyStatusOnWeb() throws AWTException, InterruptedException, IOException 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
		
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Job job = new Job(driver);
	    Pages.Job job2 = new Pages.Job(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		
		
		
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		
		
		
		
		
		job2.No_Complete();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		
		job2.Job_Status();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
		
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.Verify_NotCompletedStatus();
	}
	
	@Test(priority=39, retryAnalyzer = RerunTestCase.class)//QA-321  , retryAnalyzer = RerunTestCase.class
	public void CreateJobWithDefaultPrefinalInvoice_AndVerifyItOnMobileAndCompleteJob_FinallyVerifyConvertedFinalInvoiceOnBothMobileAndWeb() throws AWTException, InterruptedException, IOException 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Settings settings = new Settings(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		settings.Log_Out();
		settings.OwnerLogin();
		settings.Setting();
		settings.job();
		settings.JobDescriptionTemplate();
		settings.Search_JobTemplateOnSettings(AutomationNewQuestionTemplate);
		settings.Configure();
		settings.PricingItems();
		settings.Type_PriceItem(AutomationPricingItem);
		settings.NumberOfMinutesIncluded();
		settings.PrefinalInvoiceSave();
		settings.Click_AutomaticallyInvoice();
		settings.Delete_AutomaticInvoiceRule_Prerequisite();
		settings.AddInvoiceRule();
		settings.Select_CustomerType();
		settings.Select_Rule();
		settings.description(PrefinalTest);
		settings.InvoiceBreakdown();
		settings.InvoiceCategory();
		settings.UserGroup();
		settings.Email();
		settings.DefaultNominalValue(Others);
		settings.PrefinalInvoiceSave();
		settings.CloseTemplate();
		
		settings.Log_Out();
		settings.OfficestaffLogin();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
		
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Job job = new Job(driver);
	    Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
	    Pages.Job job2 = new Pages.Job(driver);
	    Certificate certificate = new Certificate(driver);
	    MobAndWeb_Page.Invoice invoice2 = new MobAndWeb_Page.Invoice(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		
		
		
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		estimateAccept.Click_Choc_MenuButton();
		pre_Invoice.Click_Invoice();
		pre_Invoice.VerifyPrefinalInvoice();
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();
		estimateAccept.Click_Choc_MenuButton();
		certificate.Diary_Details();
		estimateAccept.Click_Choc_MenuButton();
		pre_Invoice.Click_Invoice();
		invoice2.Verify_ConvertedFinalInvoice();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.Invoice_Tab();
		verifyCompletedJobAndInvoice.Verify_Invoice_Final_Status();
		
		//Reset Job Description (prefinal remove)
		
		settings.Log_Out();
		settings.OwnerLogin();
		settings.Setting();
		settings.job();
		settings.JobDescriptionTemplate();
		settings.Search_JobTemplateOnSettings(AutomationNewQuestionTemplate);
		settings.Configure();
		settings.PricingItems();
		settings.DeletePricingItem();
		settings.Yes();
		settings.PrefinalInvoiceSave();
		settings.Click_AutomaticallyInvoice();
		settings.DeleteRule();
		settings.TypeDelete();
		settings.DeleteConfirm();
        settings.CloseTemplate();
		settings.Log_Out();
		settings.OfficestaffLogin();  
	}
	
	@Test(priority=40, retryAnalyzer = RerunTestCase.class) //Ticket no: QA-323
	public void SelectCompletedJobFromWebNotificationAndCreateFinalInvoiceForJobInWeb_ThenCompleteInvoiceFromMobile_FinallyVerifyOnBothMobileAndWeb() throws InterruptedException, AWTException, IOException 
	{

		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
		
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.RemoveNotification();
	
	
	
	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
	    Job job = new Job(driver);
	    Pages.Job job2 = new Pages.Job(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		
		
		
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();
		verifyAcceptEstimateOnWeb.Notification_Logo();
		verifyAcceptEstimateOnWeb.SeeAllNotification();
		verifyAcceptEstimateOnWeb.NotificationFabIcon();
		verifyAcceptEstimateOnWeb.View();
		verifyAcceptEstimateOnWeb.ViewJob();
		Invoice_Web s_Invoice = new Invoice_Web(driverWeb);
		s_Invoice.Click_InvoiceTab();
		s_Invoice.Click_AddNewInvoice();
		s_Invoice.Select_InvoiceType(Finalinvoice);
		s_Invoice.Enter_InvoiceDes();
		s_Invoice.Select_InvoiceCategory();
		s_Invoice.Select_NoBreakDown();
		s_Invoice.Enter_SubTotal(Subtotal100);
		s_Invoice.SaveInvoice();
		
		Add_Notes add_Notes = new Add_Notes(driver);
		Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
		add_Notes.Click_Choc_MenuButton();
		pre_Invoice.Click_Invoice();
		pre_Invoice.Click_Final();
		pre_Invoice.ViewOrEditInvoice();
		pre_Invoice.Click_PaymentsTabOnMobile();
		pre_Invoice.Payment_FabIcon();
		job2.SelectOtherOptionAndMethod_Value();
		job2.Nominal_Value();
		job2.Payment_Save();
		Click_NavigateUp_BackButton();
		
		
		
	
	
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyCompletedJobAndInvoice.VerifyJobstatus();
		verifyCompletedJobAndInvoice.VerifyInvoice();
		verifyCompletedJobAndInvoice.Invoice_Tab();
		verifyCompletedJobAndInvoice.Verify_Invoice_Final_Status();
		verifyCompletedJobAndInvoice.Verify_Invoice_Payment_Status();
		
		
	}
		
		
	@Test(priority=41, retryAnalyzer = RerunTestCase.class)//QA-325    
	public void VerifyArriveAndLeaveAnswersOnBothMobileAndWeb() throws InterruptedException, AWTException, IOException 
	{
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Customer customer = new Customer(driver);
		Web_Estimate web_Estimate = new Web_Estimate(driverWeb);
		Web_Job web_Job = new Web_Job(driverWeb);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		newui_CreateCustomerOnMob.Home();
		customer.profile();
		customer.GetUserName();
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		web_Job.AddNewJob();
		web_Job.job_Description();
		web_Job.Select_Job(AutomationNewQuestionTemplate);
		web_Job.DiaryEventCheckbox();
		web_Job.SaveJob();
		web_Estimate.Today();
		web_Estimate.SelectUser();
		web_Estimate.SelectSlotInMonthlyView();
		web_Estimate.Save_Diary();
		web_Job.StoreJobNumber();
		
	
	
	
	    EstimateAccept estimateAccept = new EstimateAccept(driver);
	    Job job = new Job(driver);
	    Pages.Job job2 = new Pages.Job(driver);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.Diary_History();
//		estimateAccept.Estimate_Select();
//		estimateAccept.GOTOEVENT();
	    estimateAccept.Diary();
	    estimateAccept.EstimateTravel();
		estimateAccept.Diary_Accept();
		job.StoreJobNumber();
		
		
		
		estimateAccept.Diary_Travel();
		estimateAccept.Diary_Arrive();
		
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		signature(310, 1248, 700, 1200);//simulator
		job.Finish();
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(284, 1414, 805, 1468);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();
		estimateAccept.Click_Choc_MenuButton();
		job2.DiaryHistory();
		job2.SelectDiaryHistory();
		job2.Verify_ArriveQuestions(ArriveAnswer);		
//		job2.Close();
		job2.Verify_LeaveQuestions(LeaveAnswer);
//		job2.Close();
//		job2.CloseDiaryHistory();
		job2.ViewDiaryHistory_Back();
		job2.DiaryHistoryBack();
		Click_NavigateUp_BackButton();
		
		
		
	
	
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
        verifyCompletedJobAndInvoice.View();
        verifyCompletedJobAndInvoice.FeedBack();
        verifyCompletedJobAndInvoice.Verify_ArriveAnswer(ArriveAnswer);
        verifyCompletedJobAndInvoice.Verify_LeaveAnswer(LeaveAnswer);
        verifyCompletedJobAndInvoice.FeedBackClose();
       
        
	}
//	
//	@Test(priority=42, retryAnalyzer = RerunTestCase.class) //QA-309
//	public void AddOfficeTaskFromMobileAndCompleteOnWebByOtherUser_FinallyVerifyTheOfficeTaskStatusOnMobile() throws InterruptedException, AWTException 
//	{
//		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
//		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
//		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
//		Web_Job web_Job = new Web_Job(driverWeb);
//		Click_NavigateUp_BackButton();
//		Click_MenuClosed_BackButton();
//		editCustomerInWeb.SearchCustomer();
//		verifyCustomerOnWeb.ClickCustomer();
//		web_Job.AddNewJob();
//		web_Job.job_Description();
//		web_Job.Select_Job(AutomationNewQuestionTemplate);
//		web_Job.SaveJob();
//		web_Job.StoreJobNumber();
//	    EstimateAccept estimateAccept = new EstimateAccept(driver);	
//	    Job job = new Job(driver);
//	    Pages.Job job2 = new Pages.Job(driver);
//	    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
//	    VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
//		newui_CreateCustomerOnMob.Search_Tab();
//		job.SearchJobByNumber();
//		job.SelectJob(AutomationNewQuestionTemplate);
//		estimateAccept.Click_Choc_MenuButton();
//		estimateAccept.OfficeTask();
//		invoiceBreakdown.Click_FabIcon_InInvoiceScreen();
//		estimateAccept.TypeAndSelectUsername();
//		job2.Sign_save();
//		verifyCompletedJobAndInvoice.WebOfficeTaskMenu();
//		verifyCompletedJobAndInvoice.SearchTask();
//		verifyCompletedJobAndInvoice.MarkAsCompleted();
//		estimateAccept.Verify_CompletedStatusOnMobile();
//		Click_NavigateUp_BackButton();
//		newui_CreateCustomerOnMob.Home();
//		Refresh();
//	
//	}
//	
//	Commented

	

	
	
}
