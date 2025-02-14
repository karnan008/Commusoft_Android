package New_ui_Testclass;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainPack.BaseClassForWebAndMobile;
import MobAndWeb_Page.AddContactsForCustomerInMob;
import MobAndWeb_Page.AssetNewUIMob;
import MobAndWeb_Page.CustomFormNewUIMob;
import MobAndWeb_Page.DiaryHistory;
import MobAndWeb_Page.EditCustomerInWebAndVerifyInMob;
import MobAndWeb_Page.EditWorkAddressOnMob;
import MobAndWeb_Page.EstimateAccept;
import MobAndWeb_Page.EstimateReject;
import MobAndWeb_Page.Job;
import MobAndWeb_Page.NewUIElements;
import MobAndWeb_Page.NewUI_AddWorkAddress;
import MobAndWeb_Page.NewUI_EditCustomerOnMob;
import MobAndWeb_Page.Newui_CreateCustomerOnMob;
import MobAndWeb_Page.OfficeTask_Mob;
import MobAndWeb_Page.OfficeTask_Web;
import MobAndWeb_Page.OnGoingWork;
import MobAndWeb_Page.PropertyHistory;
import MobAndWeb_Page.Reminder_Mob;
import MobAndWeb_Page.Reminder_Web;
import MobAndWeb_Page.RemoveEngineerEvents;
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
import Pages.Add_Notes;
import Pages.Assets;
import Pages.Attached_Files;
import Pages.Certificate;
import Pages.Customer;
import Pages.Estimate;
import Pages.NewUI_Notes;
import Utility.RerunTestCase;



@Listeners(BasicSmoke_MobAndWeb.class)
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
	
	@AfterMethod(alwaysRun = true)
	public void handleAppCrash() throws MalformedURLException {
	    CloseTheAppWhenItWasCrashed();
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

	@Test(priority=5, retryAnalyzer = RerunTestCase.class)
	public void Add_AttachedFiles_ForCustomer_InMobile() throws InterruptedException 
	{
		
		Add_Notes add_Notes = new Add_Notes(driver);
		Attached_Files attached_Files = new Attached_Files(driver);

		add_Notes.Click_Choc_MenuButton();
		attached_Files.Click_AttachedFiles();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_TakePhoto();
		attached_Files.Exception_Handling();
		attached_Files.Capture_SingleImage();
		attached_Files.Click_PhotoNext();
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_RecordVideo();
		attached_Files.Exception_Handling();
		attached_Files.Capture_SingleVideo();
		attached_Files.Click_VideoNext();
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_ScanDocument();    
		attached_Files.Capture_Document();
		attached_Files.ConfirmScan();                
		attached_Files.ConfirmScan();
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_RecordAudio();
		attached_Files.Capture_Audio();
		attached_Files.Click_Save_NewUI();
		attached_Files.Enter_AudioFileName(Cus_Audio);
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_ChooseFromGallery();
		attached_Files.SelectPicFromGallery();
		attached_Files.Upload_Save();
		attached_Files.verifyAllAttachedFilesOnMOb();
		attached_Files.AttachedFiles_Back();

	}

	@Test(priority=6, retryAnalyzer = RerunTestCase.class)
	public void VerifyCustomerFilesInWeb() 
	{
		VerifyAttachedFilesOnWeb verifyAttachedFilesOnWeb = new VerifyAttachedFilesOnWeb(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);       
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		verifyAttachedFilesOnWeb.FilesTab();
		verifyAttachedFilesOnWeb.VerifyFilesOnWeb();

	}


	@Test(priority=7, retryAnalyzer = RerunTestCase.class)
	public void Assets_ForCustomer() throws InterruptedException 
	{
		
		
		Assets assets = new Assets(driver);
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

		attached_Files.Click_Save_OldUI();
		assets.Verification_Assets(AssetName);

		//		Click_NavigateUp_BackButton();
		//		Click_MenuClosed_BackButton();

	}


	@Test(priority=8, retryAnalyzer = RerunTestCase.class)
	public void Add_Reminders_ForCustomer_InMobile() throws InterruptedException
	{

		
		Customer customer = new Customer(driver);

		customer.Customer_More();
		customer.Reminders();

		customer.Reminderplus();
		customer.ServiceReminder();
		customer.Click_ServiceType_Dropdown();
		customer.SelectReminder();
		customer.ReminderDate();                   
		customer.Sendto(Title,WebName, Surname);
		customer.Tick();
	}

	@Test(priority=9, retryAnalyzer = RerunTestCase.class)
	public void VerifyCustomerRemindersOnWeb() 
	{
		VerifyRemindersOnWeb verifyRemindersOnWeb = new VerifyRemindersOnWeb(driverWeb);
		VerifyCustomerOnWeb verifyCustomerOnWeb = new VerifyCustomerOnWeb(driverWeb);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		editCustomerInWeb.SearchCustomer();
		verifyCustomerOnWeb.ClickCustomer();
		verifyRemindersOnWeb.ReminderTab();
		verifyRemindersOnWeb.VerifyServiceReminder();

	}

	@Test(priority=10, retryAnalyzer = RerunTestCase.class)
	public void AddCustomerContactsInMob() throws InterruptedException 
	{
		
		AddContactsForCustomerInMob addContactsForCustomerInMob = new AddContactsForCustomerInMob(driver);
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
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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
	public void Customer_PropertyHistory_EstimateAcceptedStatusCheck() throws AWTException, InterruptedException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		PropertyHistory propertyHistoiry= new PropertyHistory(driver);
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		propertyHistoiry.History();
		propertyHistoiry.Verify_Estimate_Accepted_Status();
		propertyHistoiry.Back_PropertyHistory();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();

	}

	@Test(priority=18, retryAnalyzer = RerunTestCase.class)
	public void RejectEstimatePriceInMob() throws InterruptedException, IOException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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
		estimate.Estimate_PriceReject();
		estimate.YES();
		estimate.Reject_Reasons();

		estimate.Estimate_Leave();

		ThreeSec();
		signature(234, 1255, 658, 1246);//simulator 

		estimate.Sign_save();
		ThreeSec();
		Estimatesignature(266, 916, 731, 900);//simulator
		estimate.Sign_save();
		
	}

	@Test(priority=19, retryAnalyzer = RerunTestCase.class)
	public void Customer_PropertyHistory_EstimateRejectedStatusCheck() throws AWTException, InterruptedException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		PropertyHistory propertyHistoiry= new PropertyHistory(driver);
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		propertyHistoiry.History();
		propertyHistoiry.Verify_Estimate_Rejected_Status();
		propertyHistoiry.Back_PropertyHistory();
		
	}

	@Test(priority=20, retryAnalyzer = RerunTestCase.class)
	public void Reject_EstimateDiaryEvent_InMobile() throws InterruptedException, IOException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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

	@Test(priority=21, retryAnalyzer = RerunTestCase.class)
	public void Verify_RejectedEstimateDiaryEventInWeb() throws InterruptedException, IOException 
	{
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyRejectedEstimateInWeb.verify_RejectStatus();

	}

	@Test(priority=22, retryAnalyzer = RerunTestCase.class)
	public void Abort_Estimate_InMobile() throws InterruptedException, IOException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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

	@Test(priority=23, retryAnalyzer = RerunTestCase.class)
	public void Verify_AbortedEstimateInWeb() throws InterruptedException, IOException 
	{
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		VerifyAcceptEstimateOnWeb verifyAcceptEstimateOnWeb = new VerifyAcceptEstimateOnWeb(driverWeb);
		verifyAcceptEstimateOnWeb.SearchEstimate();
		verifyAcceptEstimateOnWeb.Select_Estimate();
		verifyRejectedEstimateInWeb.verify_AbortedStatus();

	}
	
	@Test(priority=24, retryAnalyzer = RerunTestCase.class)
	public void A_RemoveEngineerDiaryEvent() throws InterruptedException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
		RemoveEngineerEvents removeEngineerEvents = new RemoveEngineerEvents(driver);
		//Remove all the diary events		
		removeEngineerEvents.RemoveEvent();
		
	}
	
	@Test(priority=24, retryAnalyzer = RerunTestCase.class)//priority=40, retryAnalyzer = RerunTestCase.class
	public void JobAppointment_StatusVerification_PropertyHistory() throws AWTException, InterruptedException, IOException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		OnGoingWork onGoingWork = new OnGoingWork(driver);
		Job job = new Job(driver);
		DiaryHistory diaryHistory = new DiaryHistory(driver);
		EstimateReject estimateReject = new EstimateReject(driver);
		Estimate estimate = new Estimate(driver);
		EditCustomerInWebAndVerifyInMob editCustomerInWeb = new EditCustomerInWebAndVerifyInMob(driverWeb);
		Pages.Job job2 = new Pages.Job(driver);
		

		
		// Reject
		newui_CreateCustomerOnMob.Home();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		onGoingWork.CustomerOnGoing();
		onGoingWork.FabIcon_OnGoing();
		onGoingWork.AddNewJob();
		job.JobDescription();
		job.SaveJob();
		onGoingWork.Click_FirstJob();
		job.StoreJobNumber_CustomerOnGoing();
		add_Notes.Click_Choc_MenuButton();
		diaryHistory.Diaryhistory();
		add_Notes.Click_FabIcon_NewUI(); 
		diaryHistory.SelectTime_Diary_DailyView();
		diaryHistory.BookEvent();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		job.SaveJob();
		diaryHistory.Change_Daily_To_List();
		estimate2.EstimateTravel();
		estimateReject.Reject();
		estimateReject.Reject_FeedbackReason();
		estimate.save();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();		


		// Abort
		newui_CreateCustomerOnMob.Home();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		onGoingWork.CustomerOnGoing();
		onGoingWork.Select_Job();
		add_Notes.Click_Choc_MenuButton();
		diaryHistory.Diaryhistory();
		add_Notes.Click_FabIcon_NewUI(); 
		diaryHistory.SelectTime_Diary_DailyView();
		diaryHistory.BookEvent();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		job.Job_DiaryName(Abort);
		job.SaveJob();
		diaryHistory.Change_Daily_To_List();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		estimateReject.Abort();
		estimateReject.Abort_FeedbackReason();
		estimate.save();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();

		//Cancel
		Reminder_Mob reminder = new Reminder_Mob(driver);
		Attached_Files attached_Files = new Attached_Files(driver);
		newui_CreateCustomerOnMob.Home();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		onGoingWork.CustomerOnGoing();
		onGoingWork.Select_Job();
		add_Notes.Click_Choc_MenuButton();
		diaryHistory.Diaryhistory();
		add_Notes.Click_FabIcon_NewUI(); 
		diaryHistory.SelectTime_Diary_DailyView();
		diaryHistory.BookEvent();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		job.Job_DiaryName(Cancel);
		job.SaveJob();
		diaryHistory.Change_Daily_To_List();
		estimate2.EstimateTravel();
		add_Notes.Click_Choc_MenuButton();
		diaryHistory.Diaryhistory();
		diaryHistory.Select_Diary(Cancel);
		reminder.Click_Edit();
		diaryHistory.Cancel();
		diaryHistory.CancelReason();
		attached_Files.Click_Save_NewUI();
		diaryHistory.Back_DiaryHistory();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();


		//No access
		newui_CreateCustomerOnMob.Home();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		onGoingWork.CustomerOnGoing();
		onGoingWork.Select_Job();
		add_Notes.Click_Choc_MenuButton();
		diaryHistory.Diaryhistory();
		add_Notes.Click_FabIcon_NewUI(); 
		diaryHistory.SelectTime_Diary_DailyView();
		diaryHistory.BookEvent();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		job.Job_DiaryName(NoAccess);
		job.SaveJob();
		diaryHistory.Change_Daily_To_List();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		estimate2.Diary_Travel();
		job.NoAccess();
		job.NoAccess_FeedBack();
		estimate.save();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();


		//Left
		newui_CreateCustomerOnMob.Home();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		onGoingWork.CustomerOnGoing();
		onGoingWork.Select_Job();
		add_Notes.Click_Choc_MenuButton();
		diaryHistory.Diaryhistory();
		add_Notes.Click_FabIcon_NewUI(); 
		diaryHistory.SelectTime_Diary_DailyView();
		diaryHistory.BookEvent();
		estimate2.starttime();
		estimate2.SelectStartTime();
		estimate2.EndTime();
		estimate2.SelectEndTime();
		job.Job_DiaryName(Left);
		job.SaveJob();
		diaryHistory.Change_Daily_To_List();
		estimate2.EstimateTravel();
		estimate2.Diary_Accept();
		job.StoreJobNumber();
		estimate2.Diary_Travel();
		estimate2.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();

		signature(172, 1242, 655, 1000);//simulator
		job.Finish();

		job2.Job_Report();
		job2.Arrive_Question1(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(246, 1677, 772, 1712);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.FreeOfCharge();
		job2.FreeOfCharge_Reason();
		job2.Sign_save();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();

		//Appointment status verification in Property history screen
		PropertyHistory propertyHistoiry= new PropertyHistory(driver);
		newui_CreateCustomerOnMob.Home();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		propertyHistoiry.History();
		propertyHistoiry.Click_Job_PropertHistoryList();
		ScrollDown24("Installed parts");
		diaryHistory.Appointments_ViewAll();
		diaryHistory.Verify_Rejected();
		diaryHistory.Verify_Aborted();
		diaryHistory.Verify_Cancelled();
		diaryHistory.Verify_NoAccess();
		diaryHistory.Verify_Left();
		diaryHistory.Back_DiaryHistory();
		propertyHistoiry.Job_Back_PropertHistory();
		propertyHistoiry.Back_PropertyHistory();
		

	}

	@Test(priority=25, retryAnalyzer = RerunTestCase.class)
	public void CompleteJobWithInvoiceAndPayment_InMobile() throws InterruptedException, IOException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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

		signature(163, 1183, 672, 1114);//simulator
		job.Finish();
		job2.Job_Report();
		job2.Arrive_Question1(LeaveAnswer);
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
		

	}

	@Test(priority=26, retryAnalyzer = RerunTestCase.class)
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

	@Test(priority=27, retryAnalyzer = RerunTestCase.class)
	public void Customer_PropertyHistory_JobInvoicedStatusCheck() throws AWTException, InterruptedException 
	{

		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		PropertyHistory propertyHistoiry= new PropertyHistory(driver);
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		propertyHistoiry.History();
		propertyHistoiry.Verify_Job_Invoiced_Status();
		propertyHistoiry.Back_PropertyHistory();
		

	}

	@Test(priority=28, retryAnalyzer = RerunTestCase.class)
	public void Reject_JobDiaryEvent_InMobile() throws InterruptedException, IOException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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

	@Test(priority=29, retryAnalyzer = RerunTestCase.class)
	public void Verify_RejectedJobDiaryEvent_InWeb() throws InterruptedException 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		verifyCompletedJobAndInvoice.SearchJob();
		verifyCompletedJobAndInvoice.Select_Job();
		verifyRejectedEstimateInWeb.verify_RejectStatus();

	}

	@Test(priority=30, retryAnalyzer = RerunTestCase.class)
	public void Abort_Job_DiaryEvent_InMobile() throws InterruptedException, IOException
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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

	@Test(priority=31, retryAnalyzer = RerunTestCase.class)
	public void Verify_AbortedJob_DiaryEvent_InWeb() throws InterruptedException 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		VerifyRejectedEstimateInWeb verifyRejectedEstimateInWeb = new VerifyRejectedEstimateInWeb(driverWeb);
		verifyCompletedJobAndInvoice.SearchJob();
		verifyCompletedJobAndInvoice.Select_Job();
		verifyRejectedEstimateInWeb.verify_AbortedStatus();
	}

	@Test(priority=32, retryAnalyzer = RerunTestCase.class)
	public void GenerateCertificateForJob_And_VerifyInMobile() throws InterruptedException, IOException 
	{
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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

		signature(172, 1242, 655, 1000);//simulator
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
		job2.Arrive_Question1(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(246, 1677, 772, 1712);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();
		
	}


	@Test(priority=33, retryAnalyzer = RerunTestCase.class)
	public void Verify_CompletedCertificateInWeb() 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		Certificate certificate = new Certificate(driverWeb);
		verifyCompletedJobAndInvoice.SearchJob();
		verifyCompletedJobAndInvoice.Select_Job();
		certificate.web_Certificate();
		certificate.verify_WebCertificate();

	}


	@Test(priority=34, retryAnalyzer = RerunTestCase.class)
	public void EmailCertificateFromMobileAndVerifyOnTheGmailApp() throws InterruptedException, IOException 
	{

		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
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

		signature(172, 1242, 655, 1000);//simulator
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
		job2.Arrive_Question1(LeaveAnswer);
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
		



	}


	@Test(priority=35, retryAnalyzer = RerunTestCase.class)
	public void Add_Edit_Delete_ReminderForJob() throws InterruptedException, IOException 
	{
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		Job job = new Job(driver);
		Pages.Job job2 = new Pages.Job(driver);
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Customer customer = new Customer(driver);
		Attached_Files attached_Files = new Attached_Files(driver);
		Reminder_Mob reminder = new Reminder_Mob(driver);
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

		add_Notes.Click_Choc_MenuButton();
		customer.Reminders();
		add_Notes.Click_FabIcon_NewUI();
		reminder.Select_ReminderDate();
		reminder.Reminder_Note();
		reminder.SelectUser(UserName);
		attached_Files.Click_Save_NewUI();
		reminder.Swipe_ReminderNotes();
		reminder.Delete();
		reminder.Delete();
		add_Notes.Click_FabIcon_NewUI();
		reminder.Select_ReminderDate();
		reminder.Reminder_Note();
		reminder.SelectUser(UserName);
		attached_Files.Click_Save_NewUI();
		reminder.Click_ReminderNotes();
		reminder.Click_Edit();
		reminder.EditDate();
		reminder.EditNotes();
		attached_Files.Click_Save_NewUI();
		reminder.ReminderBack();

		estimate2.Diary_Accept();
		job.StoreJobNumber();
		estimate2.Diary_Travel();
		estimate2.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();

		signature(172, 1242, 655, 1000);//simulator
		job.Finish();
		job2.Job_Report();
		job2.Arrive_Question1(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(246, 1677, 772, 1712);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.DoNothing();

		
	}

	@Test(priority=36, retryAnalyzer = RerunTestCase.class)
	public void Verify_JobReminder_OnWeb() 
	{
		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		Reminder_Web reminder_Web = new Reminder_Web(driverWeb);
		verifyCompletedJobAndInvoice.SearchJob();
		verifyCompletedJobAndInvoice.Select_Job();
		reminder_Web.Click_Reminder();
		reminder_Web.Verify_Reminder(UserName);

	}

	@Test(priority=37, retryAnalyzer = RerunTestCase.class)
	public void Add_Edit_Delete_Complete_OfficeTask_VerifyBothMobAndWeb() throws InterruptedException, IOException 
	{
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		Job job = new Job(driver);
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Attached_Files attached_Files = new Attached_Files(driver);
		Reminder_Mob reminder = new Reminder_Mob(driver);
		OfficeTask_Mob officeTask_Mob = new OfficeTask_Mob(driver);
		OfficeTask_Web officeTask_Web = new OfficeTask_Web(driverWeb);
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

		add_Notes.Click_Choc_MenuButton();
		officeTask_Mob.OfficeTask();
		add_Notes.Click_FabIcon_NewUI();
		officeTask_Mob.AssignTo();
		officeTask_Mob.Select_AssignTo(UserName);
		officeTask_Mob.Description();
		attached_Files.Click_Save_NewUI();
		officeTask_Mob.Verify_IncompleteTask();
		officeTask_Mob.Swipe_OfficeTask();
		reminder.Delete();
		reminder.Delete();
		add_Notes.Click_FabIcon_NewUI();
		officeTask_Mob.AssignTo();
		officeTask_Mob.Select_AssignTo(UserName);
		officeTask_Mob.Description();
		attached_Files.Click_Save_NewUI();
		officeTask_Mob.Verify_User(UserName);
		officeTask_Mob.Click_OfficeTask(UserName);
		reminder.Click_Edit();
		officeTask_Mob.Edit_Des();
		attached_Files.Click_Save_NewUI();

		VerifyCompletedJobAndInvoice verifyCompletedJobAndInvoice = new VerifyCompletedJobAndInvoice(driverWeb);
		verifyCompletedJobAndInvoice.SearchJob();
		verifyCompletedJobAndInvoice.Select_Job();

		officeTask_Web.Click_OfficeTask();
		officeTask_Web.Verify_Username(UserName);
		officeTask_Web.CompleteOfficeTask();

		officeTask_Mob.Verify_Completed_OfficeTask();
		officeTask_Mob.OfficeTaskBack();
		
	}

	@Test(priority=38, retryAnalyzer = RerunTestCase.class)
	public void Job_FreeOfCharge_VerifyStatusOnThePropertHistoryList() throws InterruptedException, IOException, AWTException 
	{
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
		Job job = new Job(driver);
		Pages.Job job2 = new Pages.Job(driver);
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
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

		signature(172, 1242, 655, 1000);//simulator
		job.Finish();

		job2.Job_Report();
		job2.Arrive_Question1(LeaveAnswer);
		job.Finish();
		job2.Job_Leave();
		job2.Complete_Continue();
		signature(246, 1677, 772, 1712);
		job2.Sign_save();
		signature(310, 868, 791, 941);
		job2.Sign_save();
		job2.FreeOfCharge();
		job2.FreeOfCharge_Reason();
		job2.Sign_save();
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();

		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		PropertyHistory propertyHistoiry= new PropertyHistory(driver);
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		propertyHistoiry.History();
		propertyHistoiry.Verify_Job_FreeOfCharge_Status();
		propertyHistoiry.Back_PropertyHistory();
		
	}

	@Test(priority=39, retryAnalyzer = RerunTestCase.class)
	public void PropertyHistory_SectionVerification() throws InterruptedException, AWTException 
	{
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
		EstimateAccept estimate2 = new EstimateAccept(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		estimate2.Diary();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		PropertyHistory propertyHistoiry= new PropertyHistory(driver);
		propertyHistoiry.History();
		propertyHistoiry.Select_Job_PropertyHistory();
		propertyHistoiry.CustomerInformation_Section();
		propertyHistoiry.JobDetails_Section();
		propertyHistoiry.OtherJobDetails_Section();
		ScrollDown24("Appointment history");		
		propertyHistoiry.AppointmentHistory_Section();
		ScrollDown24("Attachments");
		propertyHistoiry.InstalledParts_Section();
		propertyHistoiry.Invoices_Section();
		propertyHistoiry.Attachments_Section();
		ScrollDown24("Purchase orders");
		propertyHistoiry.Certificates_Section();
		propertyHistoiry.AdditionalWorks_Section();
		propertyHistoiry.PurchaseOrders_Section();
		propertyHistoiry.Job_Back_PropertHistory();
		propertyHistoiry.Back_PropertyHistory();
		

	}

	@Test(priority=40, retryAnalyzer = RerunTestCase.class)
	public void Job_PropetyHistory_AllSection_View_Verification() throws InterruptedException, IOException 
	{
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();

		//Diary travel
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


		//Job Attached files
		Add_Notes add_Notes = new Add_Notes(driver);
		Attached_Files attached_Files = new Attached_Files(driver);
		add_Notes.Click_Choc_MenuButton();
		attached_Files.Click_AttachedFiles();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_TakePhoto();
		attached_Files.Exception_Handling();
		attached_Files.Capture_SingleImage();
		attached_Files.Click_PhotoNext();
		attached_Files.Rename_File(JobImage);
		attached_Files.Click_Save_NewUI();
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_RecordVideo();
		attached_Files.Exception_Handling();
		attached_Files.Capture_SingleVideo();
		attached_Files.Click_VideoNext();
		attached_Files.Rename_File(JobVideo);
		attached_Files.Click_Save_NewUI();
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_ScanDocument();
		attached_Files.Capture_Document();
		attached_Files.ConfirmScan();                                
		attached_Files.ConfirmScan();
		attached_Files.Rename_File(JobDocument);
		attached_Files.Click_Save_NewUI();
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_RecordAudio();
		attached_Files.Capture_Audio();
		attached_Files.Click_Save_NewUI();
		attached_Files.Enter_AudioFileName(JobAudio);
		attached_Files.Click_Save_NewUI();
		add_Notes.Click_FabIcon_NewUI();
		attached_Files.Click_ChooseFromGallery();
		attached_Files.SelectPicFromGallery();
		attached_Files.Rename_File(JobUploadedImage);
		attached_Files.Click_Save_NewUI();
		attached_Files.Upload_Save();
		attached_Files.AttachedFiles_Back();


		//Diary Complete
		estimate2.Diary_Accept();
		job.StoreJobNumber();
		estimate2.Diary_Travel();
		estimate2.Diary_Arrive();
		job2.Arrive_Question1(ArriveAnswer);
		job.Next();		
		signature(172, 1242, 655, 1000);//simulator
		job.Finish();
		job2.Job_Report();
		job2.Arrive_Question1(LeaveAnswer);
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

		//Verify Files on the property history details screen
		add_Notes.Click_Choc_MenuButton();
		PropertyHistory propertyHistoiry= new PropertyHistory(driver);
		propertyHistoiry.PropertyHistory();
		propertyHistoiry.Click_Job_PropertHistoryList();
		ScrollDown24("Attachments");
		attached_Files.Attachments_ViewAll();
		attached_Files.Today_Status_Verification();
		attached_Files.Files_Verifications(JobImage);
		attached_Files.Files_Verifications(JobVideo);
		attached_Files.Files_Verifications(JobDocument); 
		attached_Files.Files_Verifications(JobAudio);
		attached_Files.Files_Verifications(JobUploadedImage);
		attached_Files.AttachedFiles_Back();
		propertyHistoiry.Job_Back_PropertHistory();
		propertyHistoiry.Back_PropertyHistory();   
		


	}

	

	@Test(priority=41, retryAnalyzer = RerunTestCase.class)
	public void Add_Edit_Delete_CustomerAssetNewUI() throws AWTException, InterruptedException, IOException 
	{
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
		Add_Notes add_Notes = new Add_Notes(driver);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Assets assets = new Assets(driver);
		AssetNewUIMob assetNewUIMob = new AssetNewUIMob(driver);
		Customer customer = new Customer(driver);
		Attached_Files attached_Files = new Attached_Files(driver);
		Reminder_Mob reminder = new Reminder_Mob(driver);

		newui_CreateCustomerOnMob.Home();
		customer.profile();
		assetNewUIMob.Labs();
		assetNewUIMob.EnableNewAssets();
		attached_Files.Click_Save_NewUI();
		customer.Back_Profile();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		//Add
		assets.Click_Assets();
		add_Notes.Click_FabIcon_NewUI();
		assetNewUIMob.SearchNewUI();
		assetNewUIMob.TypeNewUI(Asset_Type);
		assetNewUIMob.Select_Asset(Asset_Type);
		assetNewUIMob.Fuel();
		assetNewUIMob.Select_Fuel(Fuel1);
		assetNewUIMob.Make();
		assetNewUIMob.Select_Make(Make1);
		assetNewUIMob.Model();
		assetNewUIMob.Select_Model(Model1);
		assetNewUIMob.Location();
		assetNewUIMob.Select_Location(Location1);
		attached_Files.Click_Save_NewUI();
		//Edit
		assetNewUIMob.Click_CustomerAsset(Asset_Type);
		assetNewUIMob.Edit();
		assetNewUIMob.Fuel();
		assetNewUIMob.Select_Fuel(Fuel2);
		assetNewUIMob.Make();
		assetNewUIMob.Select_Make(Make2);
		assetNewUIMob.Model();
		assetNewUIMob.Select_Model(Model2);
		assetNewUIMob.Location();
		assetNewUIMob.Select_Location(Location2);
		attached_Files.Click_Save_NewUI();
		//Delete
		assetNewUIMob.Swipe_Asset();
		reminder.Delete();
		reminder.Delete();
		assetNewUIMob.Verify_DeletedCustomerAsset();
		//Add
		add_Notes.Click_FabIcon_NewUI();
		assetNewUIMob.SearchNewUI();
		assetNewUIMob.TypeNewUI(Asset_Type);
		assetNewUIMob.Select_Asset(Asset_Type);
		assetNewUIMob.Fuel();
		assetNewUIMob.Select_Fuel(Fuel1);
		assetNewUIMob.Make();
		assetNewUIMob.Select_Make(Make1);
		assetNewUIMob.Model();
		assetNewUIMob.Select_Model(Model1);
		assetNewUIMob.Location();
		assetNewUIMob.Select_Location(Location1);
		attached_Files.Click_Save_NewUI();
		assetNewUIMob.Back_AssetNewUI();
		
	}
	
	@Test(priority=42, retryAnalyzer = RerunTestCase.class)
	public void Add_Draft_Delete_Clone_CustomFormNewUI() throws AWTException, InterruptedException, IOException 
	{
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();

		Add_Notes add_Notes = new Add_Notes(driver);
		Newui_CreateCustomerOnMob newui_CreateCustomerOnMob = new Newui_CreateCustomerOnMob(driver);
		Assets assets = new Assets(driver);
		AssetNewUIMob assetNewUIMob = new AssetNewUIMob(driver);
		Customer customer = new Customer(driver);
		Attached_Files attached_Files = new Attached_Files(driver);
		Reminder_Mob reminder = new Reminder_Mob(driver);
		CustomFormNewUIMob customFormNewUIMob = new CustomFormNewUIMob(driver);
		OnGoingWork onGoingWork = new OnGoingWork(driver);
		Job job = new Job(driver);
		Certificate certificate = new Certificate(driver);
		NewUIElements newUIElements = new NewUIElements(driver);

		newui_CreateCustomerOnMob.Home();
		customer.profile();
		assetNewUIMob.Labs();
		customFormNewUIMob.EnableNewCustomForms();
		attached_Files.Click_Save_NewUI();
		customer.Back_Profile();
		newui_CreateCustomerOnMob.Home();
		newui_CreateCustomerOnMob.Search_Tab();
		newui_CreateCustomerOnMob.SearchCustomerByNumber();
		newui_CreateCustomerOnMob.SelectCustomer();
		add_Notes.Click_Choc_MenuButton();
		onGoingWork.CustomerOnGoing();
		onGoingWork.FabIcon_OnGoing();
		onGoingWork.AddNewJob();
		job.JobDescription();
		job.SaveJob();
		onGoingWork.Click_FirstJob();
		job.StoreJobNumber_CustomerOnGoing();
		add_Notes.Click_Choc_MenuButton();
		certificate.Click_Certificate();
		//Draft
		add_Notes.Click_FabIcon_NewUI();
		assetNewUIMob.SearchNewUI();
		assetNewUIMob.TypeNewUI(AllFieldsCertificate);
		assetNewUIMob.Select_Asset(AllFieldsCertificate);
		customFormNewUIMob.Click_Next();
		customFormNewUIMob.BackForDraft();
		
		//Delete
		customFormNewUIMob.WaitForCertificate();
		assetNewUIMob.Swipe_Asset();
		reminder.Delete();
		reminder.Delete();
		customFormNewUIMob.Verify_DeletedCustomForm();
		
		//Add
		add_Notes.Click_FabIcon_NewUI();
		assetNewUIMob.SearchNewUI();
		assetNewUIMob.TypeNewUI(AllFieldsCertificate);
		assetNewUIMob.Select_Asset(AllFieldsCertificate);
		customFormNewUIMob.Next_InputType(CertificateInput);
		attached_Files.Click_Save_NewUI();
		customFormNewUIMob.Close_NotSync_BottomSheet();
		customFormNewUIMob.Verify_CertificateNumber();
		
		//Clone
		customFormNewUIMob.Click_FirstCertificate();
		customFormNewUIMob.Clone();
		customFormNewUIMob.Verify_ClonedCertificate();
		newUIElements.BackArrowButton();
		
		
		Click_NavigateUp_BackButton();
		Click_MenuClosed_BackButton();
		
	
	}

	@Test (enabled=false)
	public void Demo() throws AWTException, InterruptedException, IOException 
	{}
	
	
	

}

