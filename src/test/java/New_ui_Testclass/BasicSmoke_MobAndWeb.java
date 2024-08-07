package New_ui_Testclass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import MainPack.BaseClass;
import MainPack.BaseClassForWebAndMobile;
import MainPack.TabletBaseClassForWebAndMobile;
import MobAndWeb_Page.AddContactsForCustomerInMob;
import MobAndWeb_Page.EditCustomerInWebAndVerifyInMob;
import MobAndWeb_Page.EditWorkAddressOnMob;
import MobAndWeb_Page.EstimateAccept;
import MobAndWeb_Page.EstimateReject;
import MobAndWeb_Page.Job;
import MobAndWeb_Page.NewUI_AddWorkAddress;
import MobAndWeb_Page.NewUI_EditCustomerOnMob;
import MobAndWeb_Page.Newui_CreateCustomerOnMob;
import MobAndWeb_Page.VerifyAcceptEstimateOnWeb;
import MobAndWeb_Page.VerifyAttachedFilesOnWeb;
import MobAndWeb_Page.VerifyCompletedJobAndInvoice;
import MobAndWeb_Page.VerifyContactsOnWeb;
import MobAndWeb_Page.VerifyCustomerOnWeb;
import MobAndWeb_Page.VerifyEditedCustomerOnWeb;
import MobAndWeb_Page.VerifyEditedWorkAddressOnWeb;
import MobAndWeb_Page.VerifyNotesInWeb;
import MobAndWeb_Page.VerifyRejectedEstimateInWeb;
import MobAndWeb_Page.VerifyRemindersOnWeb;
import MobAndWeb_Page.VerifyWorkaddressOnWeb;
import Pages.AddNotes_ForWorkAddress;
import Pages.Add_Notes;
import Pages.Assets;
import Pages.AttachedFiles_ForWorkAddresss;
import Pages.Attached_Files;
import Pages.Certificate;
import Pages.Customer;
import Pages.Edit_Customer;
import Pages.Edit_WorkAddress;
import Pages.Estimate;
import Pages.NewUI_Notes;
import Utility.ExcelReader;
import Utility.RerunTestCase;




public class BasicSmoke_MobAndWeb extends BaseClassForWebAndMobile{//1, TabletBaseClassForWebAndMobile

	
	//Once its executed, do manually invoice, additional work for job, parts
	 public BasicSmoke_MobAndWeb() {
	        super(); // Ensure the constructor of the base class is called
	    }
	
	@BeforeSuite(alwaysRun = true)
	public void CurrentClassName() 
	{
		BasicSmoke_MobAndWeb basicSmoke_MobAndWeb = new BasicSmoke_MobAndWeb();
		simpleName = basicSmoke_MobAndWeb.getClass().getSimpleName();
		System.out.println("Current class name is: "+simpleName);
		Running_UserName = System.getProperty("user.name");
        System.out.println("Current running user name: " + Running_UserName);
	}
	@Test(priority=0, retryAnalyzer = RerunTestCase.class)
	public void CreateCustomerAndVerifyInWeb() throws InterruptedException, IOException 
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
		verifyCustomerOnWeb.VerifyCustomerNumber();
		verifyCustomerOnWeb.VerifyName(Title,Name,Surname);
		
	}
	@Test(priority=1, retryAnalyzer = RerunTestCase.class)
	public void EditCustomerAndVerifyInWeb() throws InterruptedException 
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
	
	@Test(priority=2, retryAnalyzer = RerunTestCase.class)//priority=2
	public void CustomerEditInWebAndVerifyInMob() 
	{
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		NewUI_EditCustomerOnMob newUI_EditCustomerOnMob = new NewUI_EditCustomerOnMob(driver);
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
//		verifyCustomerOnWeb.EnableNewUI();
		editCustomerInWeb.editButton();
		editCustomerInWeb.editName(WebName);
		editCustomerInWeb.editAddress(WebAddress);
		editCustomerInWeb.editEmail(WebEmail);
		editCustomerInWeb.ScrollToSave();
		editCustomerInWeb.SaveChanges();
		editCustomerInWeb.VerifyWebName(Title,WebName, Surname);
		editCustomerInWeb.VerifyWebAddress(WebAddress);
		editCustomerInWeb.VerifyWebEmail(WebEmail);
		newUI_EditCustomerOnMob.Verify_EditedName(Title,WebName, Surname);
		newUI_EditCustomerOnMob.Click_Customer();
		newUI_EditCustomerOnMob.Verify_EditedAddress1(WebAddress);
		newUI_EditCustomerOnMob.Verify_EditedEmail(WebEmail);
		newUI_EditCustomerOnMob.Click_NavBackbutton();
	}
	
	@Test(priority=3, retryAnalyzer = RerunTestCase.class)
	public void AddCommunicationsForCustomer_InMobile() throws InterruptedException 
	{
		AddNotes_ForWorkAddress addNotes_ForWorkAddress = new AddNotes_ForWorkAddress(driver);
		Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
		Customer customer = new Customer(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Edit_Customer edit_Customer = new Edit_Customer(driver);
		NewUI_EditCustomerOnMob newUI_EditCustomerOnMob = new NewUI_EditCustomerOnMob(driver);
		NewUI_Notes newUI_Notes = new NewUI_Notes(driver);
		
		
		add_Notes.Click_Choc_MenuButton();
		add_Notes.Click_NotesSection();
		newUI_Notes.FabIcon();
		add_Notes.Click_Addnewnote();
		newUI_Notes.Title(NoteTitle);
		newUI_Notes.Enter_Note(Note);
		newUI_Notes.Save();
		newUI_Notes.Verify_AddedNote();
//		newUI_Notes.FabIcon();
//		newUI_Notes.NewPhoneCall();
//		newUI_Notes.Call_Type();
//		newUI_Notes.ContactNameSearch();
//		newUI_Notes.PhoneNote(NoteForPhoneCall);
//		newUI_Notes.Save();
//		newUI_Notes.Verify_PhoneCall();
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
	
	@Test(priority=4, retryAnalyzer = RerunTestCase.class)
	public void VerifyCustomerNotesInWeb() 
	{
		VerifyNotesInWeb verifyNotesInWeb = new VerifyNotesInWeb(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		verifyNotesInWeb.CommunicationTab();
		verifyNotesInWeb.VerifyNote(NoteTitle);
//		verifyNotesInWeb.VerifyPhoneCall(NoteForPhoneCall);// Comment this line bcoz of unable to add call from mobile
		verifyNotesInWeb.VerifyEmail(SubjectForEmail);
		verifyNotesInWeb.VerifySMS(MessageForSMS);
		
		
	}
	
//	@Test(priority=5, retryAnalyzer = RerunTestCase.class)
//	public void Add_AttachedFiles_ForCustomer_InMobile() throws InterruptedException 
//	{
//
//		AttachedFiles_ForWorkAddresss attachedFiles_ForWorkAddresss = new AttachedFiles_ForWorkAddresss(driver);
//		Customer customer = new Customer(driver);
//		Add_Notes add_Notes = new Add_Notes(driver);
//		Attached_Files attached_Files = new Attached_Files(driver);
//		Pages.Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
//	
//		add_Notes.Click_Choc_MenuButton();
//		attached_Files.Click_AttachedFiles();
//		add_Notes.Click_FabIcon();
//		attached_Files.Click_TakePhoto();
//		attached_Files.Exception_Handling();
//		attached_Files.Enter_Photo_Filename(PhotoFileName);
//		attached_Files.Click_Save();
//		attached_Files.Take_Photo();
//		attached_Files.Click_TickSymbol();
//		attached_Files.Click_TakeVideo();
//		attached_Files.Enter_Video_Filename(VideoFileName);
//		attached_Files.Click_Save();
//		attached_Files.Take_Video();
//		attached_Files.Click_TickSymbol();
////		attached_Files.Click_ChooseFromCameraRoll();
////		attached_Files.SelectFromCameraRoll();
//		attached_Files.Click_RecordAudio();
//		attached_Files.Exception_Handling();
//		attached_Files.Enter_Audio_Filename(AudioFileName);    //comment 475,476,477,478,479, coz audio butto is not clickable (20-Dec-2022)
//		attached_Files.Click_TickSymbolForAudio();
//		attached_Files.RecordAudio();
//
//
//	
//	}
	
//	@Test(priority=6, retryAnalyzer = RerunTestCase.class)
//	public void VerifyCustomerFilesInWeb() 
//	{
//		VerifyAttachedFilesOnWeb verifyAttachedFilesOnWeb = new VerifyAttachedFilesOnWeb(driverWeb);
//		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
//		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
//		editCustomerInWeb.SearchCustomer();
//		verifyCustomerOnWeb.ClickCustomer();
//		verifyAttachedFilesOnWeb.FilesTab();
//		verifyAttachedFilesOnWeb.VerifyPhotoFile(PhotoFileName);
//		verifyAttachedFilesOnWeb.VerifyVideoFile(VideoFileName);
//	
//	}
	
	
	@Test(priority=7, retryAnalyzer = RerunTestCase.class)
	public void Assets_ForCustomer() throws InterruptedException 
	{
		Assets assets = new Assets(driver);
		Customer customer = new Customer(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Attached_Files attached_Files = new Attached_Files(driver);

		add_Notes.Click_Choc_MenuButton();
		assets.Click_Assets();
		assets.Click_FabIcon();
		assets.Search_Asset(AssetName);
		assets.Click_SystemBoiler();
		assets.Fuel();
		assets.Type();
		assets.Make();
		assets.Model();
		assets.Location();
		assets.SerialNumber();

		attached_Files.Click_Save();
		assets.Verification_Assets(AssetName);
		
//		Click_NavigateUp_BackButton();
//		Click_MenuClosed_BackButton();
		
	}
	
	
//	@Test(priority=8, retryAnalyzer = RerunTestCase.class)
//	public void Add_Reminders_ForCustomer_InMobile() throws InterruptedException
//	{
//		Thread.sleep(10000);
//		Customer customer = new Customer(driver);
//		Add_Notes add_Notes = new Add_Notes(driver);
//	
//		customer.Customer_More();
//		customer.Reminders();
//		
//		customer.Reminderplus();
//		customer.ServiceReminder();
//		customer.Click_ServiceType_Dropdown();
//		customer.SelectReminder();
//		customer.ReminderDate();                   
//		customer.Sendto(Title,WebName, Surname);
//		customer.Tick();
//		
////		customer.Reminderplus();
////		customer.Click_Remainder();
////		customer.Click_RemainderDate();
////		customer.Select_Date();                     Service reminder is removed, coz in web they removed it, So commented these lines on 27/11/2023
////		customer.Click_Done();
////		customer.Enter_NotesForReminder(Note);
////		customer.Select_User(UserName);//UserName
////		customer.Click_Tick();
//		
//	}
	
//	@Test(priority=9, retryAnalyzer = RerunTestCase.class)
//	public void VerifyCustomerRemindersOnWeb() 
//	{
//		VerifyRemindersOnWeb verifyRemindersOnWeb = new VerifyRemindersOnWeb(driverWeb);
//		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
//		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
//		editCustomerInWeb.SearchCustomer();
//		verifyCustomerOnWeb.ClickCustomer();
//		verifyRemindersOnWeb.ReminderTab();
//		verifyRemindersOnWeb.VerifyServiceReminder(Title, WebName, Surname);
//	
//	}
	
	@Test(priority=10, retryAnalyzer = RerunTestCase.class)
	public void AddCustomerContactsInMob() throws InterruptedException 
	{
		AddContactsForCustomerInMob addContactsForCustomerInMob = new AddContactsForCustomerInMob(driver);
		Attached_Files attached_Files = new Attached_Files(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		NewUI_Notes newUI_Notes = new NewUI_Notes(driver);
		add_Notes.Click_Choc_MenuButton();
		addContactsForCustomerInMob.Contacts();
		newUI_Notes.FabIcon();
		addContactsForCustomerInMob.NewContact();
		addContactsForCustomerInMob.Contact_Title(Title);
		addContactsForCustomerInMob.Lastname(CustomerContact);
		newUI_Notes.Save();
		addContactsForCustomerInMob.VerifyContact(CustomerContact);
		addContactsForCustomerInMob.ContactBack();
	
	}
	
	@Test(priority=11, retryAnalyzer = RerunTestCase.class)
	public void VerifyCustomerContactOnWeb() 
	{
		VerifyContactsOnWeb verifyContactsOnWeb = new VerifyContactsOnWeb(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		verifyContactsOnWeb.ContactsTab();
		verifyContactsOnWeb.VerifyContact(Title,CustomerContact);
	}
	
	@Test(priority=12, retryAnalyzer = RerunTestCase.class)
	public void AddWorkaddressAndVerifyInWeb() throws InterruptedException 
	{
		NewUI_AddWorkAddress newUI_AddWorkAddress = new NewUI_AddWorkAddress(driver);
		Customer customer = new Customer(driver);
       VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		VerifyWorkaddressOnWeb verifyWorkaddressOnWeb = new VerifyWorkaddressOnWeb(driverWeb);
		newUI_AddWorkAddress.OpenMenu();
		customer.WA();
		customer.WA_Add();
		customer.Customer_title(Title);
		customer.WA_Name(WorkAddressName);
		customer.WA_Surname(WorkAddressLastName);
		customer.Customer_Telephone("4547845154");
		customer.Customer_Mobile("45478315448");
		customer.Customer_email("Workaddress@gmail.com");
		customer.Scrollto_WA_Address();
		customer.WA_Address("Address");
		customer.Customer_Save();
		newUI_AddWorkAddress.Click_WorkAddress();
		newUI_AddWorkAddress.Store_WorkAddressNumber();
		verifyWorkaddressOnWeb.SearchWorkAddress();
		verifyWorkaddressOnWeb.Click_WorkAddress();
//		verifyCustomerOnWeb.EnableNewUI();
		verifyWorkaddressOnWeb.VerifyCustomerNumber();
	}
	
	@Test(priority=13, retryAnalyzer = RerunTestCase.class)
	public void EditWorkAddressAndVerifyinWeb() throws InterruptedException 
	{
		EditWorkAddressOnMob editWorkAddressOnMob = new EditWorkAddressOnMob(driver);
		Customer customer = new Customer(driver);
		VerifyEditedCustomerOnWeb verifyEditedCustomerOnWeb = new VerifyEditedCustomerOnWeb(driverWeb);
		VerifyEditedWorkAddressOnWeb verifyEditedWorkAddressOnWeb = new VerifyEditedWorkAddressOnWeb(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		VerifyWorkaddressOnWeb verifyWorkaddressOnWeb = new VerifyWorkaddressOnWeb(driverWeb);
//		TenSec();
		editWorkAddressOnMob.Click_WorkAddress();
		editWorkAddressOnMob.Click_EditButton();
		editWorkAddressOnMob.Edit_WorkAddressName(EditWorkAddressName);
		editWorkAddressOnMob.Edit_WorkAddressEmail(EditWorkAddressEmail);
		customer.Customer_Save();
		editWorkAddressOnMob.Verify_EditedEmail(EditWorkAddressEmail);
		customer.Customer_Back();
		editWorkAddressOnMob.Verify_EditedName(Title, EditWorkAddressName, WorkAddressLastName);
		
		verifyWorkaddressOnWeb.SearchWorkAddress();
		verifyCustomerOnWeb.ClickCustomer();
//		verifyCustomerOnWeb.EnableNewUI();
		verifyEditedWorkAddressOnWeb.VerifyWorkAddressNumber();
		verifyEditedCustomerOnWeb.Verify_EditedName(Title,EditWorkAddressName, WorkAddressLastName);
		verifyEditedCustomerOnWeb.Verify_EditedEmail(EditWorkAddressEmail);
	
	}
	
	@Test(priority=14, retryAnalyzer = RerunTestCase.class)
	public void WorkAddressEditInWebAndVerifyInMob() 
	{
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		NewUI_EditCustomerOnMob newUI_EditCustomerOnMob = new NewUI_EditCustomerOnMob(driver);
		VerifyWorkaddressOnWeb verifyWorkaddressOnWeb = new VerifyWorkaddressOnWeb(driverWeb);
		VerifyEditedCustomerOnWeb verifyEditedCustomerOnWeb = new VerifyEditedCustomerOnWeb(driverWeb);
		verifyWorkaddressOnWeb.SearchWorkAddress();
		verifyCustomerOnWeb.ClickCustomer();
//		verifyCustomerOnWeb.EnableNewUI();
		editCustomerInWeb.editButton();
		editCustomerInWeb.editName(WebWoraddressName);
		editCustomerInWeb.editEmail(WebWorkAddressEmail);
		editCustomerInWeb.ScrollToSave();
		editCustomerInWeb.SaveChanges();
		editCustomerInWeb.VerifyWebName(Title, WebWoraddressName, WorkAddressLastName);
		editCustomerInWeb.VerifyWebEmail(WebWorkAddressEmail);
		verifyEditedCustomerOnWeb.Verify_EditedName(Title, WebWoraddressName, WorkAddressLastName);
		newUI_EditCustomerOnMob.Click_workaddress();
		newUI_EditCustomerOnMob.Verify_EditedEmail(WebWorkAddressEmail);
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
	}
	
	@Test(priority=15, retryAnalyzer = RerunTestCase.class)
	public void EstimateAcceptWithPrice_InMobile() throws InterruptedException, IOException 
	{
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Estimate estimate = new Estimate(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		estimate2.Click_Estimate();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		estimate2.EstimateDescription();
		estimate2.SaveEstimate();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		estimate2.StoreEstimateNumber();
		estimate2.Diary_Travel();
		estimate2.Diary_Arrive();
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
	
	
	@Test(priority=16, retryAnalyzer = RerunTestCase.class)
	public void Verify_AcceptedEstimate_OnWeb() 
	{
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyAcceptEstimateOnWeb.verify_EstimateAcceptedStatus();
		verifyAcceptEstimateOnWeb.verify_JobCovertionStatus();
	}
	
	@Test(priority=17, retryAnalyzer = RerunTestCase.class)
	public void Reject_Estimate_InMobile() throws InterruptedException, IOException 
	{
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Estimate estimate = new Estimate(driver);
		EstimateReject estimateReject = new EstimateReject(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		estimate2.Click_Estimate();
		estimate2.starttime();
		estimateReject.SelectStartTime();
		estimate2.EndTime();
		estimateReject.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		estimate2.EstimateDescription();
		estimate2.SaveEstimate();
		estimate2.EstimateTravel();
		estimate2.StoreEstimateNumber();
		estimateReject.Reject();
		estimateReject.Reject_FeedbackReason();
		estimate.save();
		
		
	}

	@Test(priority=18, retryAnalyzer = RerunTestCase.class)
	public void Verify_RejectedEstimateInWeb() throws InterruptedException, IOException 
	{
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyRejectedEstimateInWeb.verify_RejectStatus();
	
	}
	
	@Test(priority=19, retryAnalyzer = RerunTestCase.class)
	public void Abort_Estimate_InMobile() throws InterruptedException, IOException 
	{
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Estimate estimate = new Estimate(driver);
		EstimateReject estimateReject = new EstimateReject(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		estimate2.Click_Estimate();
		estimate2.starttime();
		estimateReject.SelectStartTime();
		estimate2.EndTime();
		estimateReject.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		estimate2.EstimateDescription();
		estimate2.SaveEstimate();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		estimate2.StoreEstimateNumber();
		estimateReject.Abort();
		estimateReject.Abort_FeedbackReason();
		estimate.save();
	}
	
	@Test(priority=20, retryAnalyzer = RerunTestCase.class)
	public void Verify_AbortedEstimateInWeb() throws InterruptedException, IOException 
	{
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyRejectedEstimateInWeb.verify_AbortedStatus();
	
	}
	
	@Test(priority=21, retryAnalyzer = RerunTestCase.class)
	public void CompleteJobWithInvoiceAndPayment_InMobile() throws InterruptedException, IOException 
	{
		Job job = new Job(driver);
		Pages.Job job2 = new Pages.Job(driver);
		EstimateAccept estimate2 = new EstimateAccept(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		job.Click_Job();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		job.JobDescription();
		job.SaveJob();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		job.StoreJobNumber();
		estimate2.Diary_Travel();
		estimate2.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
        job.Next();
		
		signature(172, 1696, 655, 1683);//simulator
		job.Finish();
		job2.Job_Report();
		job2.LeaveQuestion2(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(246, 1677, 772, 1712);
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
	
	@Test(priority=22, retryAnalyzer = RerunTestCase.class)
	public void Verify_CompletedJobWithFinalInvoice_OnWeb() 
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
	
	@Test(priority=23, retryAnalyzer = RerunTestCase.class)
	public void Reject_Job_InMobile() throws InterruptedException, IOException 
	{
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Job job = new Job(driver);
		EstimateReject estimateReject = new EstimateReject(driver);
		Estimate estimate = new Estimate(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		job.Click_Job();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		job.JobDescription();
		job.SaveJob();
		estimate2.EstimateTravel();
		job.StoreJobNumber();
		estimateReject.Reject();
		estimateReject.Reject_FeedbackReason();
		estimate.save();
	}
	
	@Test(priority=24, retryAnalyzer = RerunTestCase.class)
	public void Verify_RejectedJobInWeb() throws InterruptedException 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
		verifyRejectedEstimateInWeb.verify_RejectStatus();
		
	}
	
	@Test(priority=25, retryAnalyzer = RerunTestCase.class)
	public void Abort_Job_InMobile() throws InterruptedException, IOException
	{
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Job job = new Job(driver);
		EstimateReject estimateReject = new EstimateReject(driver);
		Estimate estimate = new Estimate(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		job.Click_Job();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		job.JobDescription();
		job.SaveJob();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		job.StoreJobNumber();
		estimateReject.Abort();
		estimateReject.Abort_FeedbackReason();
		estimate.save();
	}
	
	@Test(priority=26, retryAnalyzer = RerunTestCase.class)
	public void Verify_AbortedJobInWeb() throws InterruptedException 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
        verifyRejectedEstimateInWeb.verify_AbortedStatus();
	}
	
	@Test(priority=27, retryAnalyzer = RerunTestCase.class)
	public void GenerateCertificateForJob_And_VerifyInMobile() throws InterruptedException, IOException 
	{
		Job job = new Job(driver);
		Pages.Job job2 = new Pages.Job(driver);
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Certificate certificate = new Certificate(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		job.Click_Job();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		job.JobDescription();
		job.SaveJob();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		job.StoreJobNumber();
		estimate2.Diary_Travel();
		estimate2.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
        job.Next();
		
		signature(172, 1696, 655, 1683);//simulator
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
		signature(246, 1677, 772, 1712);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
	}
	
	
	@Test(priority=28, retryAnalyzer = RerunTestCase.class)
	public void Verify_CompletedCertificateInWeb() 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
	    Certificate certificate = new Certificate(driverWeb);
        verifyCompletedJobAndInvoice.SearchJob();
        verifyCompletedJobAndInvoice.Select_Job();
        certificate.web_Certificate();
        certificate.verify_WebCertificate();
       
	}
	
	
	@Test(priority=29, retryAnalyzer = RerunTestCase.class)
	public void EmailCertificateFromMobileAndVerifyOnTheGmailApp() throws InterruptedException, IOException 
	{

		Job job = new Job(driver);
		Pages.Job job2 = new Pages.Job(driver);
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Certificate certificate = new Certificate(driver);
		Customer customer = new Customer(driver);
		estimate2.Diary();
		estimate2.Fabicon();
		job.Click_Job();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		estimate2.SearchCustomer();
		estimate2.SelectCustomer();
		job.JobDescription();
		job.SaveJob();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		job.StoreJobNumber();
		estimate2.Diary_Travel();
		estimate2.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();
		
		signature(172, 1696, 655, 1683);//simulator
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
		signature(246, 1677, 772, 1712);
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
		certificate.Verify_CertificateOnGmailApp(AllFieldsCertificate);
		TwoSec();
		SwitchToV4();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();

		
	
	}
	
	
	@Test (enabled=false)
	public void Demo() throws AWTException, InterruptedException, IOException 
	{
		AddNotes_ForWorkAddress addNotes_ForWorkAddress = new AddNotes_ForWorkAddress(driver);
		Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
		Customer customer = new Customer(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Edit_Customer edit_Customer = new Edit_Customer(driver);
		NewUI_EditCustomerOnMob newUI_EditCustomerOnMob = new NewUI_EditCustomerOnMob(driver);
		NewUI_Notes newUI_Notes = new NewUI_Notes(driver);
		
		
		newUI_Notes.FabIcon();
		newUI_Notes.NewPhoneCall();
		newUI_Notes.Call_Type();
//		newUI_Notes.ContactNameSearch();
//		newUI_Notes.PhoneNote(NoteForPhoneCall);
//		newUI_Notes.Save();
//		newUI_Notes.Verify_PhoneCall();
//		newUI_Notes.FabIcon();
//		add_Notes.Click_Sendnewemail();
//		newUI_Notes.Search_To();
//		newUI_Notes.Subject(SubjectForEmail);
//		newUI_Notes.ComposeEmail(ComposeEmail);
//		newUI_Notes.sendEmail();
//		newUI_Notes.Verify_Email();
//		newUI_Notes.FabIcon();
//		add_Notes.Click_SendnewSMS();
//		newUI_Notes.SelectContactName();
//		newUI_Notes.ComposeSMS(MessageForSMS);
//		newUI_Notes.sendSMS();
//		newUI_Notes.Verify_SMS();
//		newUI_Notes.Communication_Back();
		
	}
	
	
	
	
}
