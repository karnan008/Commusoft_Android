package Test;

import org.testng.annotations.Test;

import MainPack.BaseClass;
import MainPack.BaseClass_Pixel6A;
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
import Pages.Pre_Invoice;
import Pages.Rebook_Event;

//BaseClass_Pixel6A    BaseClass
public class Smoke extends BaseClass 
{

	
	 //BaseClass_Pixel6A   BaseClass

		@Test (priority = 0)//priority = 0
		public void Create_Customer() throws InterruptedException
		{
			Customer customer = new Customer(driver);
			customer.Side_Menu();
			customer.Private_Customer();
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
			customer.Customer_Fav();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
		}

		

		
		@Test(priority = 1)//enabled=false  priority = 1
		public void Edit_CustomerDetails() throws InterruptedException 
		{
			Edit_Customer edit_Customer = new Edit_Customer(driver);
			Customer customer = new Customer(driver);
			customer.Side_Menu();
			customer.Click_FavCus();
			TwoSec();
			edit_Customer.Click_Cus(Name,Surname);
//			FiveSec();
//			clickpoint(399,567);
			edit_Customer.Click_Cus_InCusDetailsScreen(Name, Surname);
			FiveSec();
			edit_Customer.Click_EditButton();
			edit_Customer.Edit_Name(EditName);
			edit_Customer.Edit_Landline(EditLandline);
			edit_Customer.Edit_Mobile(EditMob);
			edit_Customer.Edit_Email(EditEmail);
			edit_Customer.Edit_AddressLine1(EditAddress1);
			FiveSec();
			customer.Customer_Save();
			FiveSec();
			
			edit_Customer.Verify_EditedEmail(EditEmail);
			edit_Customer.Verify_EditedMobile(EditMob);
			edit_Customer.Verify_EditedLandline(EditLandline);
			edit_Customer.Verify_EditedAddress1(EditAddress1);
			customer.Customer_Back();
			TwoSec();
			edit_Customer.Verify_EditedName(EditName, Surname);
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			customer.Side_Menu();
			customer.Click_FavCus();
			edit_Customer.Verify_EditedNameinFavCusScreen(EditName, Surname);
			customer.Side_Menu();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		}
		
		@Test(priority = 2)//priority = 2
		public void Add_NotesForCustomer() throws InterruptedException 
		{

			AddNotes_ForWorkAddress addNotes_ForWorkAddress = new AddNotes_ForWorkAddress(driver);
			Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Edit_Customer edit_Customer = new Edit_Customer(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName,Surname);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			add_Notes.Click_NotesSection();
			add_Notes.Click_FabIcon();
			add_Notes.Click_Addnewnote();
			add_Notes.Enter_Title(NoteTitle);
			add_Notes.Enter_Note(Note);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);//For Refresh The Page
			add_Notes.Click_FabIcon();
			add_Notes.Click_Add_new_phone_call();
			add_Notes.Click_Calltype_Dropdown();
			add_Notes.Select_IncomingCall();
			add_Notes.Click_ContactName_Dropdown();
			add_Notes.Select_ContactName(EditName, Surname);
			add_Notes.Click_ContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.EnterNoteForPhoneCall(NoteForPhoneCall);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_Sendnewemail();
			add_Notes.Click_To();
			add_Notes.Select_Email();
			customer.Customer_Save();
			add_Notes.EnterSubject(SubjectForEmail);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_SendnewSMS();
			add_Notes.Click_SMSContactName_Dropdown();
			add_Notes.Select_ContactName(EditName, Surname);
			add_Notes.Click_ToContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.Enter_Message(MessageForSMS);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Verify_Note(NoteTitle);
			add_Notes.Verify_PhoneCall(NoteForPhoneCall);
			add_Notes.Verify_Email(SubjectForEmail);
			add_Notes.Verify_SMS(MessageForSMS);
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();


		
		}
		
		@Test(priority = 3)//priority = 3
		public void Add_AttachedFiles_ForCustomer() throws InterruptedException 
		{

			AttachedFiles_ForWorkAddresss attachedFiles_ForWorkAddresss = new AttachedFiles_ForWorkAddresss(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Attached_Files attached_Files = new Attached_Files(driver);
			Pages.Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName,Surname);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			attached_Files.Click_AttachedFiles();
			add_Notes.Click_FabIcon();
			attached_Files.Click_TakePhoto();
			attached_Files.Exception_Handling();
			attached_Files.Enter_Photo_Filename(PhotoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Photo();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_TakeVideo();
			attached_Files.Enter_Video_Filename(VideoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Video();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_ChooseFromCameraRoll();
			attached_Files.SelectFromCameraRoll();
			attached_Files.Click_RecordAudio();
			attached_Files.Exception_Handling();
			attached_Files.Enter_Audio_Filename(AudioFileName);    //comment 475,476,477,478,479, coz audio butto is not clickable (20-Dec-2022)
			attached_Files.Click_TickSymbolForAudio();
			attached_Files.RecordAudio();
//			attached_Files.Verify_AllAttachedFiles(); ---> Uncomment this linr once audio files is saved in attached files screen (19-Dec)
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();

		
		}
		@Test(priority = 4)//enabled=false  priority=4
		public void Assets_ForCustomer() throws InterruptedException 
		{
			Assets assets = new Assets(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Attached_Files attached_Files = new Attached_Files(driver);
			customer.Side_Menu();
			customer.Customer_search();
			add_Notes.TypeCustomerNameInSearchField(EditName, Surname);
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			assets.Click_Assets();
			assets.Click_FabIcon();
			assets.Search_Asset(AssetName);
			assets.Click_SystemBoiler();
			scroll(driver, "photoss");//photoss     Commissioned on
			assets.Click_TakePhoto();
			assets.Select_TakePhoto_From_AlertPrompt();
			assets.Click_CenterButton_InCamera();
			assets.Click_Tick();
			scroll(driver, "Extinguisher Location");
			assets.Click_TakePhoto();
			assets.Select_CameraRoll();
			assets.Click_Gallery();
			assets.Select_Pic_FromGallery();
			attached_Files.Click_Save();
			assets.Verification_Assets(AssetName);
			
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
		}
		@Test (priority=5)//priority = 10
		public void Add_Reminders_ForCustomer() throws InterruptedException
		{
			Thread.sleep(10000);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName, Surname);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			customer.Customer_More();
			customer.Reminders();
			
			customer.Reminderplus();
			customer.ServiceReminder();
			customer.Click_ServiceType_Dropdown();
			customer.SelectReminder();
			customer.ReminderDate();
			customer.Sendto(EditName, Surname);
			customer.Tick();
			
			customer.Reminderplus();
			customer.Click_Remainder();
			customer.Click_RemainderDate();
			customer.Select_Date();
			customer.Click_Done();
			customer.Enter_NotesForReminder(Note);
			customer.Select_User(UserName);//UserName
			customer.Click_Tick();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		}
		@Test (priority = 6)//priority = 11
		public void Add_WA() throws InterruptedException
		{
			Thread.sleep(10000);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName,Surname);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.WA();
			customer.WA_Add();
			customer.WA_Name(WorkAddressName);
			customer.WA_Surname(WorkAddressLastName);
			customer.Customer_Telephone("4547845154");
			customer.Customer_Mobile("45478315448");
			customer.Customer_email("Workaddress@gmail.com");
			customer.Scrollto_WA_Address();
			customer.WA_Address("Address");
			customer.Customer_Save();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();//468,837
		}

		@Test(priority = 7)//priority = 12
		public void Edit_WorkAddress() throws InterruptedException 
		{
			Pages.Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Edit_Customer edit_Customer = new Edit_Customer(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName,Surname);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.WA();
			edit_WorkAddress.Click_WorkAddress_Cus(WorkAddressName, WorkAddressLastName);
			clickpoint(468,837);
			edit_Customer.Click_EditButton();
			edit_Customer.Edit_Name(EditWorkAddressName);
			edit_Customer.Edit_Landline(EditLandline);
			edit_Customer.Edit_Mobile(EditMob);
			edit_Customer.Edit_Email(EditWorkAddressEmail);
			edit_Customer.Edit_AddressLine1(EditAddress1);
			FiveSec();
			customer.Customer_Save();
			edit_Customer.Verify_EditedEmail(EditWorkAddressEmail);
			edit_Customer.Verify_EditedMobile(EditMob);
			edit_Customer.Verify_EditedLandline(EditLandline);
			edit_Customer.Verify_EditedAddress1(EditAddress1);
			edit_WorkAddress.WorkAddressBack();
			edit_Customer.Verify_EditedName(EditWorkAddressName, WorkAddressLastName);
//			edit_WorkAddress.WorkAddressBack();
//			edit_WorkAddress.WorkAddressBack();
//			customer.Customer_Back();
//			customer.Customer_Back();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();

		}

		@Test(priority = 8)//priority = 13
		public void Add_Notes_ForWorkAddress() throws InterruptedException 
		{
			AddNotes_ForWorkAddress addNotes_ForWorkAddress = new AddNotes_ForWorkAddress(driver);
			Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Edit_Customer edit_Customer = new Edit_Customer(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName,Surname);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.WA();
			edit_WorkAddress.Click_WorkAddress_Cus(EditWorkAddressName, WorkAddressLastName);
			add_Notes.Click_Choc_MenuButton();
			add_Notes.Click_NotesSection();
			add_Notes.Click_FabIcon();
			add_Notes.Click_Addnewnote();
			add_Notes.Enter_Title(NoteTitle);
			add_Notes.Enter_Note(Note);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);//For Refresh The Page
			add_Notes.Click_FabIcon();
			add_Notes.Click_Add_new_phone_call();
			add_Notes.Click_Calltype_Dropdown();
			add_Notes.Select_IncomingCall();
			add_Notes.Click_ContactName_Dropdown();
			add_Notes.Select_ContactName(EditWorkAddressName, WorkAddressLastName);
			add_Notes.Click_ContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.EnterNoteForPhoneCall(NoteForPhoneCall);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_Sendnewemail();
			add_Notes.Click_To();
			add_Notes.Select_Email();
			customer.Customer_Save();
			add_Notes.EnterSubject(SubjectForEmail);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_SendnewSMS();
			add_Notes.Click_SMSContactName_Dropdown();
			add_Notes.Select_ContactName(EditWorkAddressName, WorkAddressLastName);
			add_Notes.Click_ToContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.Enter_Message(MessageForSMS);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Verify_Note(NoteTitle);
			add_Notes.Verify_PhoneCall(NoteForPhoneCall);
			add_Notes.Verify_Email(SubjectForEmail);
			add_Notes.Verify_SMS(MessageForSMS);
//			customer.Customer_Back();
//			customer.Customer_Back();
//			customer.Customer_Back();
//			customer.Customer_Back();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();


		}

		@Test(priority = 9)//priority = 14
		public void Attached_Files_ForWorkAddress() throws InterruptedException 
		{
			AttachedFiles_ForWorkAddresss attachedFiles_ForWorkAddresss = new AttachedFiles_ForWorkAddresss(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Attached_Files attached_Files = new Attached_Files(driver);
			Pages.Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName,Surname);
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.WA();
			edit_WorkAddress.Click_WorkAddress_Cus(EditWorkAddressName, WorkAddressLastName);
			add_Notes.Click_Choc_MenuButton();
			attached_Files.Click_AttachedFiles();
			add_Notes.Click_FabIcon();
			attached_Files.Click_TakePhoto();
			attached_Files.Exception_Handling();
			attached_Files.Enter_Photo_Filename(PhotoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Photo();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_TakeVideo();
			attached_Files.Enter_Video_Filename(VideoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Video();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_ChooseFromCameraRoll();
			attached_Files.SelectFromCameraRoll();
			attached_Files.Click_RecordAudio();
			attached_Files.Exception_Handling();
			attached_Files.Enter_Audio_Filename(AudioFileName);     // comment 715,716,717,718,719, coz audio butto is not clickable (20-Dec-2022)
			attached_Files.Click_TickSymbolForAudio();
			attached_Files.RecordAudio();
//			attached_Files.Verify_AllAttachedFiles(); Uncomment this line once audio files is saved in attached files screen (19-Dec)
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();

		}
		
		@Test(priority = 10)//priority = 15
		public void Add_Assets_ForWorkAddress() throws InterruptedException 
		{
			AttachedFiles_ForWorkAddresss attachedFiles_ForWorkAddresss = new AttachedFiles_ForWorkAddresss(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Attached_Files attached_Files = new Attached_Files(driver);
			Pages.Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			Assets assets = new Assets(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName,Surname);
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.WA();
			edit_WorkAddress.Click_WorkAddress_Cus(EditWorkAddressName, WorkAddressLastName);
			add_Notes.Click_Choc_MenuButton();
			assets.Click_Assets();
			assets.Click_FabIcon();
			assets.Search_Asset(AssetName);
			assets.Click_SystemBoiler();
			scroll(driver, "photoss");//photoss      Commissioned on
			assets.Click_TakePhoto();
			assets.Select_TakePhoto_From_AlertPrompt();
			assets.Click_CenterButton_InCamera();
			assets.Click_Tick();
			scroll(driver, "Extinguisher Location");
			assets.Click_TakePhoto();
			assets.Select_CameraRoll();
			assets.Click_Gallery();
			assets.Select_Pic_FromGallery();
			attached_Files.Click_Save();
			assets.Verification_Assets(AssetName);
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		}
		
		@Test(priority = 11)//priority=16
		public void Add_RemidersForWorkAddress() throws InterruptedException 
		{

			Thread.sleep(5000);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Pages.Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName, Surname);
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			customer.Customer_More();
			customer.WA();
			edit_WorkAddress.Click_WorkAddress_Cus(EditWorkAddressName, WorkAddressLastName);
			add_Notes.Click_Choc_MenuButton();
			customer.Reminders();
			
			customer.Reminderplus();
			customer.ServiceReminder();
			customer.Click_ServiceType_Dropdown();
			customer.SelectReminder();
			customer.ReminderDate();
			customer.Sendto(EditName, Surname);
			customer.Tick();
			
			customer.Reminderplus();
			customer.Click_Remainder();
			customer.Click_RemainderDate();
			customer.Select_Date();
			customer.Click_Done();
			customer.Enter_NotesForReminder(Note);
			customer.Select_User(UserName);
			customer.Click_Tick();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		
		}
		//--------------------><-----------------------
		
		@Test(priority = 12)//priority = 12
		public void Create_Estimate() throws InterruptedException 
		{

			Thread.sleep(10000);
			Customer customer = new Customer(driver);
			Estimate estimate = new Estimate(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Diary diary = new Diary(driver);
			customer.Side_Menu(); 
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName, Surname); 
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber); 
			add_Notes.Click_Choc_MenuButton();
			customer.Customer_Ongoing(); 
			customer.Customer_PlusBtn();
			estimate.Add_Estimate(); 
			estimate.Estimate_Description();
			estimate.Select_Estimate_Template();
			estimate.Book_Diary(); 
			estimate.Estimate_Save();

			scrolltothetop(500,500,500,2400);
			
			doubleclickpoint(183,323);//  ---> Change click point > Test Case - Create_Estimate> Method - clickpoint(), estimate.Book_Event();
			estimate.Book_Event(1019, 849, 79, 856,205,1050);
//			estimate.Click_EngineerDropdown();
//			ScrollToText(UserName);
//			estimate.Select_Engineer(UserName);
			estimate.Savebtn();
			scrolltothetop(500,500,500,2400);
			clickpoint(183,323);//  ---> Change click point > Test Case - Accept_Estimate> Method - clickpoint();
			diary.Store_EstimateNumber();

			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();

		
		}
		
		@Test(priority = 13) //priority = 13
		public void Add_Notes_Assets_Reminders_AtachedFiels_For_Estimate() throws InterruptedException 
		{

			
			Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			CompleteJobFromEstimate completeJobFromEstimate = new CompleteJobFromEstimate(driver);
		// Add Notes	
			customer.Side_Menu();
			customer.Customer_search();
			completeJobFromEstimate.Search_EstimateNumber();
			MobileEnter();
			completeJobFromEstimate.Click_Estimate(Surname);
			add_Notes.Click_Choc_MenuButton();
			
			
			add_Notes.Click_NotesSection();
			add_Notes.Click_FabIcon();
			add_Notes.Click_Addnewnote();
			add_Notes.Enter_Title(NoteTitle);
			add_Notes.Enter_Note(Note);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);//For Refresh The Page
			add_Notes.Click_FabIcon();
			add_Notes.Click_Add_new_phone_call();
			add_Notes.Click_Calltype_Dropdown();
			add_Notes.Select_IncomingCall();
			add_Notes.Click_ContactName_Dropdown();
			add_Notes.Select_ContactName(EditName,Surname);
			add_Notes.Click_ContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.EnterNoteForPhoneCall(NoteForPhoneCall);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_Sendnewemail();
			add_Notes.Click_To();
			add_Notes.Select_Email();
			customer.Customer_Save();
			add_Notes.EnterSubject(SubjectForEmail);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_SendnewSMS();
			add_Notes.Click_SMSContactName_Dropdown();
			add_Notes.Select_ContactName(EditName,Surname);
			add_Notes.Click_ToContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.Enter_Message(MessageForSMS);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Verify_Note(NoteTitle);
			add_Notes.Verify_PhoneCall(NoteForPhoneCall);
			add_Notes.Verify_Email(SubjectForEmail);
			add_Notes.Verify_SMS(MessageForSMS);
			
			
	   //  Add Assets
			Attached_Files attached_Files = new Attached_Files(driver);
//			
			Assets assets = new Assets(driver);
//			
			add_Notes.Click_Choc_MenuButton();
			
			assets.Click_Assets();
			assets.Click_FabIcon();
			assets.Search_Asset(AssetName);
			assets.Click_SystemBoiler();
			scroll(driver, "photoss");//photoss      Commissioned on
			assets.Click_TakePhoto();
			assets.Select_TakePhoto_From_AlertPrompt();
			assets.Click_CenterButton_InCamera();
			assets.Click_Tick();
			scroll(driver, "Extinguisher Location");
			assets.Click_TakePhoto();
			assets.Select_CameraRoll();
			assets.Click_Gallery();
			assets.Select_Pic_FromGallery();
			attached_Files.Click_Save();
			assets.Verification_Assets(AssetName);
			
		
		// Add Atached Files
			

			add_Notes.Click_Choc_MenuButton();
			
			attached_Files.Click_AttachedFiles();
			add_Notes.Click_FabIcon();
			attached_Files.Click_TakePhoto();
			attached_Files.Enter_Photo_Filename(PhotoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Photo();
			attached_Files.Exception_Handling();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_TakeVideo();
			attached_Files.Enter_Video_Filename(VideoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Video();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_ChooseFromCameraRoll();
			attached_Files.SelectFromCameraRoll();
			attached_Files.Click_RecordAudio();
			attached_Files.Exception_Handling();
			attached_Files.Enter_Audio_Filename(AudioFileName);     // comment 715,716,717,718,719, coz audio butto is not clickable (20-Dec-2022)
			attached_Files.Click_TickSymbolForAudio();
			attached_Files.RecordAudio();
//			attached_Files.Verify_AllAttachedFiles(); Uncomment this line once audio files is saved in attached files screen (19-Dec)
			
			
		// Add Reminders
			

			add_Notes.Click_Choc_MenuButton();
			customer.Reminders();
			
			customer.Reminderplus();
			
			customer.Click_RemainderDate();
			customer.Select_Date();
			customer.Click_Done();
			customer.Enter_NotesForReminder(Note);
			customer.Select_User(UserName);
			customer.Click_Tick();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
		
		
		
		}
		
		@Test(priority = 14)//priority = 14
		public void Accept_Estimate() throws InterruptedException 
		{

		
			Thread.sleep(10000);
			Estimate estimate = new Estimate(driver);
			Diary diary = new Diary(driver);
			Customer customer = new Customer(driver);
			CompleteJobFromEstimate completeJobFromEstimate = new CompleteJobFromEstimate(driver);
			
			
			scrolltothetop(500,500,500,2400);
			clickpoint(183,323);
			
			
			diary.Diary_Accept();
			diary.Diary_Travel();
			diary.Diary_Arrive();
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
			
			scrolltothetop(500,2200,500,650);
			Thread.sleep(4000);
			signature(361, 1743, 718, 1686);//Added By Saravanan
			estimate.Estimate_Acceptbtn();
			estimate.Estimate_Leave();
		
			ThreeSec();
			signature(234, 1255, 658, 1246);//simulator 

			estimate.Sign_save();
			ThreeSec();
			signature(266, 916, 731, 900);//simulator
			estimate.Sign_save();
			//estimate.Final_Diary(); ----> Comment this line for saravanan Automation
			estimate.Verify_Status();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
	//	
		}
		
		@Test(priority = 15)//priority = 15
		public void CompleteJob_From_Estimate() throws InterruptedException 
		{

			Thread.sleep(5000);
			Job job = new Job(driver);
			Diary diary = new Diary(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			CompleteJobFromEstimate completeJobFromEstimate = new CompleteJobFromEstimate(driver);
			Estimate estimate = new Estimate(driver);
			customer.Side_Menu(); 
			customer.Customer_search();
			completeJobFromEstimate.Search_EstimateNumber();
			MobileEnter();
//			ScrollTop24(Estimate);
			completeJobFromEstimate.Click_Estimate(Surname);
			completeJobFromEstimate.ViewJob();
			add_Notes.Click_Choc_MenuButton();
			completeJobFromEstimate.Click_Diaryhistory();
			completeJobFromEstimate.Click_Fabicon();
			completeJobFromEstimate.Click_ImageButton();
			scrolltothetop(500,500,500,2400);
			doubleclickpoint(171,564);//  ---> Change click point > Test Case - CompleteJob_From_Estimate> Method - clickpoint();
			estimate.Book_Event(1019, 849, 79, 856,224,751);
			estimate.Savebtn();
			clickpoint(171,564);
			
			
			diary.Diary_Accept();
			diary.Diary_Travel();
			diary.Diary_Arrive();
			job.Arrive_Question1();
			job.Sign_save();
			//signature(250, 1380, 550, 1220);
			signature(310, 1248, 700, 1200);//simulator
			job.Sign_save();
			job.Job_Report();
			job.Leave_Question();
			job.Sign_save();
			job.Job_Leave();
			job.Complete_Continue();
			//scrolltothetop(500,1800,500,400);
			scrolltothetop(500,500,500,2400);//simulator
			//signature(272, 1517, 600, 1373);
			signature(221, 1369, 788, 1258);//simulator
			job.Sign_save();
			//signature(300, 1016, 600, 920);
			signature(310, 868, 791, 941);//simulator
			job.Sign_save();
			job.Final_Invoice();
			job.Invoice_Description();
			ScrollDown24("Invoice category *");
			job.Invoice_Category();
			job.Invoice_Next();
			job.Breakdown_Value("100");
			job.ExceptionHandling_For_DataNotLoad_InInvoiceScreen();
			job.Invoice_Saves();
			job.Payment();
			job.Method_Value();
			job.Nominal_Value();
			job.Sign_save();
			job.Job_Status();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		
			
		}
		
		@Test(priority = 16)//priority = 16 
		public void Create_Job_Via_Customer_Ongoing() throws InterruptedException 
		{

			Thread.sleep(10000);
			Customer customer = new Customer(driver);
			Estimate estimate = new Estimate(driver);
			Diary diary = new Diary(driver);
			Job job = new Job(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName, Surname);
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.Customer_Ongoing();
			customer.Customer_PlusBtn();
			job.Add_New_Job();
			job.Click_Des();
			job.Job_Des();
//			scrolltothetop(500,1800,500,300);
			ScrollDown24("Book into diary after adding job");
			job.Book_Diary_Job();
			//		Savebtn();
			job.Click_Tick();
			//		swipe(driver, DIRECTION.LEFT);
			//scrolltothetop(500,400,500,1800);
			scrolltothetop(500,500,500,2400);//simulator
			//doubleclickpoint(500,700);
			doubleclickpoint(240,732);//---> Change click point > Test Case -Create_Job_Via_Customer_Ongoing> Method - clickpoint()
			estimate.Book_Event(1019, 849, 79, 856,285, 1220);
			estimate.Savebtn();
			scrolltothetop(500,500,500,2400);
			clickpoint(240,732);// Change click point > Test Case - CompleteJob_UntilPayment()
			job.Store_JobNumber();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
		
		}
		
		@Test(priority = 17)//priority = 17
		public void Add_Notes_Assets_Reminders_AtachedFiels_For_Job() throws InterruptedException 
		{

			Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			CompleteJobFromEstimate completeJobFromEstimate = new CompleteJobFromEstimate(driver);
			Job job = new Job(driver);
		// Add Notes	
			customer.Side_Menu();
			customer.Customer_search();
			job.Search_JobNumber();
			MobileEnter();
			
			job.Click_Job(Surname);
			add_Notes.Click_Choc_MenuButton();
			
			
			add_Notes.Click_NotesSection();
			add_Notes.Click_FabIcon();
			add_Notes.Click_Addnewnote();
			add_Notes.Enter_Title(NoteTitle);
			add_Notes.Enter_Note(Note);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);//For Refresh The Page
			add_Notes.Click_FabIcon();
			add_Notes.Click_Add_new_phone_call();
			add_Notes.Click_Calltype_Dropdown();
			add_Notes.Select_IncomingCall();
			add_Notes.Click_ContactName_Dropdown();
			add_Notes.Select_ContactName(EditName,Surname);
			add_Notes.Click_ContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.EnterNoteForPhoneCall(NoteForPhoneCall);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_Sendnewemail();
			add_Notes.Click_To();
			add_Notes.Select_Email();
			customer.Customer_Save();
			add_Notes.EnterSubject(SubjectForEmail);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Click_FabIcon();
			add_Notes.Click_SendnewSMS();
			add_Notes.Click_SMSContactName_Dropdown();
			add_Notes.Select_ContactName(EditName,Surname);
			add_Notes.Click_ToContactNumber_Dropdown();
			add_Notes.Select_ContactNumber();
			add_Notes.Enter_Message(MessageForSMS);
			customer.Customer_Save();
			add_Notes.Click_ExpandedFabIcon();
			scrolltothedown(500,1700,500,2165);
			add_Notes.Verify_Note(NoteTitle);
			add_Notes.Verify_PhoneCall(NoteForPhoneCall);
			add_Notes.Verify_Email(SubjectForEmail);
			add_Notes.Verify_SMS(MessageForSMS);
			
			
	   //  Add Assets
			Attached_Files attached_Files = new Attached_Files(driver);
			
			Assets assets = new Assets(driver);
			
			add_Notes.Click_Choc_MenuButton();
			
			assets.Click_Assets();
			assets.Click_FabIcon();
			assets.Search_Asset(AssetName);
			assets.Click_SystemBoiler();
			scroll(driver, "photoss");//photoss      Commissioned on
			assets.Click_TakePhoto();
			assets.Select_TakePhoto_From_AlertPrompt();
			assets.Click_CenterButton_InCamera();
			assets.Click_Tick();
			scroll(driver, "Extinguisher Location");
			assets.Click_TakePhoto();
			assets.Select_CameraRoll();
			assets.Click_Gallery();
			assets.Select_Pic_FromGallery();
			attached_Files.Click_Save();
			assets.Verification_Assets(AssetName);
			
		
		// Add Attached Files
			

			add_Notes.Click_Choc_MenuButton();
			
			attached_Files.Click_AttachedFiles();
			add_Notes.Click_FabIcon();
			attached_Files.Click_TakePhoto();
			attached_Files.Enter_Photo_Filename(PhotoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Photo();
			attached_Files.Exception_Handling();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_TakeVideo();
			attached_Files.Enter_Video_Filename(VideoFileName);
			attached_Files.Click_Save();
			attached_Files.Take_Video();
			attached_Files.Click_TickSymbol();
			attached_Files.Click_ChooseFromCameraRoll();
			attached_Files.SelectFromCameraRoll();
			attached_Files.Click_RecordAudio();
			attached_Files.Exception_Handling();
			attached_Files.Enter_Audio_Filename(AudioFileName);     // comment 715,716,717,718,719, coz audio butto is not clickable (20-Dec-2022)
			attached_Files.Click_TickSymbolForAudio();
			attached_Files.RecordAudio();
//			attached_Files.Verify_AllAttachedFiles(); Uncomment this line once audio files is saved in attached files screen (19-Dec)
			
			
		// Add Reminders
			

			add_Notes.Click_Choc_MenuButton();
			customer.Reminders();
			
			customer.Reminderplus();
			
			customer.Click_RemainderDate();
			customer.Select_Date();
			customer.Click_Done();
			customer.Enter_NotesForReminder(Note);
			customer.Select_User(UserName);
			customer.Click_Tick();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
		
		
		}
		
		@Test(priority = 18)//priority = 18
		public void Add_Certificate_ForJob() throws InterruptedException 
		{
			Edit_WorkAddress edit_WorkAddress = new Edit_WorkAddress(driver);
			Customer customer = new Customer(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			CompleteJobFromEstimate completeJobFromEstimate = new CompleteJobFromEstimate(driver);
			Job job = new Job(driver);
			Attached_Files attached_Files = new Attached_Files(driver);
		    Certificate certificate = new Certificate(driver);	
		    Assets assets = new Assets(driver);
			customer.Side_Menu();
			customer.Customer_search();
			job.Search_JobNumber();
			MobileEnter();
			
			job.Click_Job(Surname);
			add_Notes.Click_Choc_MenuButton();
			certificate.Click_Certificate();
			certificate.Click_Fab();
			certificate.Search_Certificate(TypeCertificate);
			certificate.Select_Certificate();
			certificate.Click_Next();
			certificate.Click_Next();
			certificate.Click_Next();
			certificate.Click_TAKEPHOTO();
			
			assets.Select_TakePhoto_From_AlertPrompt();
			assets.Click_CenterButton_InCamera();
			assets.Click_Tick();
			certificate.Click_TAKEPHOTO2();
			attached_Files.Click_ChooseFromCameraRoll();
			certificate.Select_Pic();
			certificate.Click_Next();
			certificate.Click_Next();
			certificate.Click_Next();
			certificate.Click_Next();
			certificate.Click_TAKEPHOTO();
			assets.Select_TakePhoto_From_AlertPrompt();
			assets.Click_CenterButton_InCamera();
			assets.Click_Tick();
			certificate.Click_TAKEPHOTO2();
			attached_Files.Click_ChooseFromCameraRoll();
			certificate.Select_Pic();
			certificate.Click_TAKEPHOTO3();
			attached_Files.Click_ChooseFromCameraRoll();
			certificate.Select_Pic();
			certificate.Click_Next();
			certificate.Click_TAKEPHOTO();
			assets.Select_TakePhoto_From_AlertPrompt();
			assets.Click_CenterButton_InCamera();
			assets.Click_Tick();
			certificate.Click_TAKEPHOTO2();
			attached_Files.Click_ChooseFromCameraRoll();
			certificate.Select_Pic();
			certificate.Click_Next();
			certificate.Click_Finish();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
		}
		
		
		@Test(priority = 19)//priority = 19
		public void CompleteJob_UntilPayment() throws InterruptedException 
		{

			Thread.sleep(10000);
			Job job = new Job(driver);
			Diary diary = new Diary(driver);
			Customer customer = new Customer(driver);
			scrolltothetop(500,500,500,2400);
			clickpoint(240,732);
			
			
			diary.Diary_Accept();
			diary.Diary_Travel();
			diary.Diary_Arrive();
			job.Arrive_Question();
			
			job.Click_Next();
			signature(304, 1263, 718, 1319);
			job.Click_Finish();
			
			job.FillInJobReport();
			job.Click_Finish();
			job.Job_LeaveFromDiary();
			job.Complete_Continue();
			//scrolltothetop(500,1800,500,400);
			scrolltothetop(500,500,500,2400);//simulator
			//signature(272, 1517, 600, 1373);
			signature(221, 1369, 788, 1258);//simulator
			job.Sign_save();
			//signature(300, 1016, 600, 920);
			signature(310, 868, 791, 941);//simulator
			job.Sign_save();
			job.Final_Invoice();
			job.Invoice_Description();
			job.Invoice_Category();
			job.Invoice_Next();
			job.Breakdown_Value("100");
			job.Invoice_Saves();
			job.Payment();
			job.Method_Value();
			job.Nominal_Value();
			job.Sign_save();
			job.Job_StatusFromDiary();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		
		}
		
		@Test(priority = 20)//
		public void Create_Estimate_For_RebookEvent() throws InterruptedException 
		{


			Thread.sleep(10000);
			Customer customer = new Customer(driver);
			Estimate estimate = new Estimate(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			Diary diary = new Diary(driver);
			customer.Side_Menu(); 
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName, Surname); 
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber); 
			add_Notes.Click_Choc_MenuButton();
			customer.Customer_Ongoing(); 
			customer.Customer_PlusBtn();
			estimate.Add_Estimate(); 
			estimate.Estimate_Description();
			estimate.Select_Estimate_Template();
			estimate.Book_Diary(); 
			estimate.Estimate_Save();

			scrolltothetop(500,500,500,2400);
			
			doubleclickpoint(177,875);//  ---> Change click point > Test Case - Create_Estimate_For_RebookEvent> Method - clickpoint();
			estimate.Book_Event(1019, 849, 79, 856,205,1050);
//			estimate.Click_EngineerDropdown();
//			ScrollToText(UserName);
//			estimate.Select_Engineer(UserName);
			estimate.Savebtn();
			scrolltothetop(500,500,500,2400);
			clickpoint(177,875);// Change click point > Test Case - Abort_Estimate()> Method - clickpoint()
			diary.Store_EstimateNumber();

			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
			
		}
		
		@Test(priority = 21)
		public void Abort_Estimate() throws InterruptedException 
		{
			Customer customer = new Customer(driver);
			Diary diary = new Diary(driver);
			Abort_Event abort_Event = new Abort_Event(driver);
			
			scrolltothetop(500,500,500,2400);
			clickpoint(177,875);
			diary.Diary_Accept();
			diary.Diary_Travel();
			abort_Event.Click_Abort();
			abort_Event.TypeFeedback();
			customer.Click_Tick();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
			
		}
		
		@Test(priority = 22)
		public void Rebook_Estimate() throws InterruptedException 
		{
			Rebook_Event rebook_Event = new Rebook_Event(driver);
			Estimate estimate = new Estimate(driver);
			rebook_Event.Click_Fabicon_InDiaryScreen();
			rebook_Event.Click_RebookEvent();
			rebook_Event.Search_Estimate();
			rebook_Event.Click_SearchButton();
			rebook_Event.Click_AbortedEstimate();
			scrolltothetop(500,500,500,2400);
			doubleclickpoint(180,1090);
			estimate.Book_Event(1019, 849, 79, 856,205,1050);
			rebook_Event.Type_EstimateDes();
			estimate.Savebtn();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		}
		
		@Test(priority = 23)
		public void Create_Job_ForRebook() throws InterruptedException 
		{


			Thread.sleep(10000);
			Customer customer = new Customer(driver);
			Estimate estimate = new Estimate(driver);
			Diary diary = new Diary(driver);
			Job job = new Job(driver);
			Add_Notes add_Notes = new Add_Notes(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.TypeCustomerNameInSearchField(EditName, Surname);
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.Customer_Ongoing();
			customer.Customer_PlusBtn();
			job.Add_New_Job();
			job.Click_Des();
			job.Job_Des();
//			scrolltothetop(500,1800,500,300);
			ScrollDown24("Book into diary after adding job");
			job.Book_Diary_Job();
			//		Savebtn();
			job.Click_Tick();
			//		swipe(driver, DIRECTION.LEFT);
			//scrolltothetop(500,400,500,1800);
			scrolltothetop(500,500,500,2400);//simulator
			//doubleclickpoint(500,700);
			doubleclickpoint(231,1239);//---> Change click point > Test Case -Create_Job_ForRebook> Method - clickpoint()
			estimate.Book_Event(1019, 849, 79, 856,285, 1220);
			estimate.Savebtn();
			scrolltothetop(500,500,500,2400);
			clickpoint(231,1239);// Change click point > Test Case - Abort_Job()> Method - clickpoint()
			job.Store_JobNumber();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
		
		
		}
		
		@Test(priority = 24)
		public void Abort_Job() throws InterruptedException 
		{
			Customer customer = new Customer(driver);
			Diary diary = new Diary(driver);
			Abort_Event abort_Event = new Abort_Event(driver);
			
			scrolltothetop(500,500,500,2400);
			clickpoint(231,1239);
			diary.Diary_Accept();
			diary.Diary_Travel();
			abort_Event.Click_Abort();
			abort_Event.TypeFeedback();
			customer.Click_Tick();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			
			
		}
		
		@Test(priority = 25)
		public void Rebook_Job() throws InterruptedException 
		{

			Rebook_Event rebook_Event = new Rebook_Event(driver);
			Estimate estimate = new Estimate(driver);
			rebook_Event.Click_Fabicon_InDiaryScreen();
			rebook_Event.Click_RebookEvent();
			rebook_Event.Search_JobNumber();
			rebook_Event.Click_SearchButton();
			rebook_Event.Click_AbortedJob();
			scrolltothetop(500,500,500,2400);
//			scrolltothedown(294, 735, 297, 532);
			ThreeSec();
			doubleclickpoint(196,1420);// Change click point > Test Case - Rebook_Job()> Method - ExceptionHandling_For_BookDiaryEvent()
			rebook_Event.ExceptionHandling_For_BookDiaryEvent(196,1420);
			estimate.Book_Event(1019, 849, 79, 856,205,1050);
			rebook_Event.Type_JobDes();
			estimate.Savebtn();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		
		}
		
//		WITHOUT DIARY EVENT
		
		@Test(priority = 26)
		public void Job_Pre_Invoice_Verification() throws InterruptedException 
		{

			Add_Notes add_Notes = new Add_Notes(driver);
			Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
		    Certificate certificate = new Certificate(driver);
		    Diary diary = new Diary(driver);
		    Job job = new Job(driver);
		    Customer customer = new Customer(driver);
			customer.Side_Menu();
			customer.Customer_search();
			customer.Customer_Searchtext(EditName, Surname);
//			customer.Pass_CustomerNumber(PassCustomerNumber);
			MobileEnter();
			add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
			add_Notes.Click_Choc_MenuButton();
			customer.Customer_Ongoing();
			customer.Customer_PlusBtn();
			job.Add_New_Job();
			job.Click_Des();
			job.Job_Des();
			job.Click_Tick();
			
			pre_Invoice.Click_FirstJob();
			add_Notes.Click_Choc_MenuButton();
			pre_Invoice.Click_Invoice();
			pre_Invoice.Click_Invoice_Fabicon();
			pre_Invoice.Type_InvoiceDes(Preinvoice);
			pre_Invoice.Click_InvoiceCategoryDropdown();
			pre_Invoice.Select_InvoiceCategory();
			certificate.Click_Next();
			job.Breakdown_Value("100");
			job.Invoice_Saves();
			pre_Invoice.Click_Exit();//back,chocmenu,ongoing,firstjob,
			diary.Click_Back();
			add_Notes.Click_Choc_MenuButton();
			customer.Customer_Ongoing();
			pre_Invoice.Click_FirstJob();
			pre_Invoice.Click_CompleteJob();
			
			
			job.Complete_Continue();
			ThreeSec();
			
			pre_Invoice.Click_FreeOfChargeJob();
			pre_Invoice.Click_JobStatus();
			pre_Invoice.Click_RaiseFinalInvoice();
			pre_Invoice.Type_InvoiceDes(Invoice);
			pre_Invoice.Click_InvoiceCategoryDropdown();
			pre_Invoice.Select_InvoiceCategory();
			certificate.Click_Next();
			job.Breakdown_Value("100");
			job.Invoice_Saves();
			pre_Invoice.Click_Exit();
			Click_NavigateUp_BackButton();
			Click_NavigateUp_BackButton();
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
		
		}
			
			@Test(priority = 27)
			public void Job_CompletedBy_BreakdownByCategory() throws InterruptedException 
			{
				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			    Certificate certificate = new Certificate(driver);
			    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Estimate estimate = new Estimate(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				
				pre_Invoice.Click_FirstJob();
				pre_Invoice.Click_CompleteJob();
				job.Complete_Continue();
				pre_Invoice.Click_RaiseFinalInvoice();
				pre_Invoice.Type_InvoiceDes(Invoice);
				pre_Invoice.Click_InvoiceCategoryDropdown();
				pre_Invoice.Select_InvoiceCategory();
				certificate.Click_Next();
				invoiceBreakdown.Click_InvoiceBreakdown_Dropdown();
				invoiceBreakdown.Select_BreakdownByCategory();
				invoiceBreakdown.Click_FabIcon_InInvoiceScreen();
				invoiceBreakdown.Click_CategoryDropdown();
				invoiceBreakdown.Select_Parts();
				invoiceBreakdown.Type_Total("500");
				estimate.Savebtn();
				job.Invoice_Saves();
				pre_Invoice.Click_Exit();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
				
			}
			
			@Test(priority = 28)
			public void Job_CompletedBy_FullBreakdown() throws InterruptedException 
			{
				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			    Certificate certificate = new Certificate(driver);
			    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Estimate estimate = new Estimate(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				
				pre_Invoice.Click_FirstJob();
				pre_Invoice.Click_CompleteJob();
				job.Complete_Continue();
				pre_Invoice.Click_RaiseFinalInvoice();
				pre_Invoice.Type_InvoiceDes(Invoice);
				pre_Invoice.Click_InvoiceCategoryDropdown();
				pre_Invoice.Select_InvoiceCategory();
				certificate.Click_Next();
				invoiceBreakdown.Click_InvoiceBreakdown_Dropdown();
				invoiceBreakdown.Select_FullBreakdown();
				invoiceBreakdown.Click_FabIcon_InInvoiceScreen();
				invoiceBreakdown.Type_BreakdownDes();
				invoiceBreakdown.Type_BreakdownQuantity();
				invoiceBreakdown.Type_UnitPrice();
				estimate.Savebtn();
				job.Invoice_Saves();
				pre_Invoice.Click_Exit();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
				
			}
			
			
			@Test(priority = 29)
			public void Job_CompletedBy_FullBreakdownByCategory() throws InterruptedException 
			{
				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			    Certificate certificate = new Certificate(driver);
			    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Estimate estimate = new Estimate(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				
				pre_Invoice.Click_FirstJob();
				pre_Invoice.Click_CompleteJob();
				job.Complete_Continue();
				pre_Invoice.Click_RaiseFinalInvoice();
				pre_Invoice.Type_InvoiceDes(Invoice);
				pre_Invoice.Click_InvoiceCategoryDropdown();
				pre_Invoice.Select_InvoiceCategory();
				certificate.Click_Next();
				invoiceBreakdown.Click_InvoiceBreakdown_Dropdown();
				invoiceBreakdown.Select_FullBreakdownByCategory();
				invoiceBreakdown.Click_FabIcon_InInvoiceScreen();
				invoiceBreakdown.Click_CategoryDropdown();
				invoiceBreakdown.Select_Parts();
				invoiceBreakdown.Click_SearchButton();
				invoiceBreakdown.Click_Searchforpricingitem();
				invoiceBreakdown.Select_PricingItem();
				invoiceBreakdown.Type_BreakdownQuantity();
				estimate.Savebtn();
				job.Invoice_Saves();
				pre_Invoice.Click_Exit();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
				
			}
			
			@Test(priority = 30)
			public void Job_CompletedBy_AdditionalInvoiceType() throws InterruptedException 
			{
				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			    Certificate certificate = new Certificate(driver);
			    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
			    InvoiceType invoiceType = new InvoiceType(driver);
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Estimate estimate = new Estimate(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				
				pre_Invoice.Click_FirstJob();
				pre_Invoice.Click_CompleteJob();
				job.Complete_Continue();
				pre_Invoice.Click_RaiseFinalInvoice();
				invoiceType.Click_InvoiceType_Dropdown();
				invoiceType.Click_Additional();
				
				pre_Invoice.Type_InvoiceDes(Invoice);
				pre_Invoice.Click_InvoiceCategoryDropdown();
				pre_Invoice.Select_InvoiceCategory();
				certificate.Click_Next();
				job.Breakdown_Value("100");
				job.Invoice_Saves();
				pre_Invoice.Click_Exit();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
			}
			
			@Test(priority = 31)
			public void Job_CompletedBy_InterimInvoiceType() throws InterruptedException 
			{
				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			    Certificate certificate = new Certificate(driver);
			    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
			    InvoiceType invoiceType = new InvoiceType(driver);
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Estimate estimate = new Estimate(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				
				pre_Invoice.Click_FirstJob();
				pre_Invoice.Click_CompleteJob();
				job.Complete_Continue();
				pre_Invoice.Click_RaiseFinalInvoice();
				invoiceType.Click_InvoiceType_Dropdown();
				invoiceType.Click_Interim();
				
				pre_Invoice.Type_InvoiceDes(Invoice);
				pre_Invoice.Click_InvoiceCategoryDropdown();
				pre_Invoice.Select_InvoiceCategory();
				certificate.Click_Next();
				job.Breakdown_Value("100");
				job.Invoice_Saves();
				pre_Invoice.Click_Exit();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
			}
			
			@Test(priority = 32)
			public void Job_CompletedBy_PrefinalInvoiceType() throws InterruptedException 
			{
				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			    Certificate certificate = new Certificate(driver);
			    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
			    InvoiceType invoiceType = new InvoiceType(driver);
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Estimate estimate = new Estimate(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				
				pre_Invoice.Click_FirstJob();
				pre_Invoice.Click_CompleteJob();
				job.Complete_Continue();
				pre_Invoice.Click_RaiseFinalInvoice();
				invoiceType.Click_InvoiceType_Dropdown();
				invoiceType.Click_PrefinalInvoice();
				
				pre_Invoice.Type_InvoiceDes(Invoice);
				pre_Invoice.Click_InvoiceCategoryDropdown();
				pre_Invoice.Select_InvoiceCategory();
				certificate.Click_Next();
				job.Breakdown_Value("100");
				job.Invoice_Saves();
				pre_Invoice.Click_Exit();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
			}
			
			@Test(priority = 33)
			public void Job_CompletedBy_FinalInvoiceType() throws InterruptedException 
			{
				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			    Certificate certificate = new Certificate(driver);
			    InvoiceBreakdown invoiceBreakdown = new InvoiceBreakdown(driver);
			    InvoiceType invoiceType = new InvoiceType(driver);
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Estimate estimate = new Estimate(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				
				pre_Invoice.Click_FirstJob();
				pre_Invoice.Click_CompleteJob();
				job.Complete_Continue();
				pre_Invoice.Click_RaiseFinalInvoice();
				invoiceType.Click_InvoiceType_Dropdown();
				invoiceType.Click_Final();
				
				pre_Invoice.Type_InvoiceDes(Invoice);
				pre_Invoice.Click_InvoiceCategoryDropdown();
				pre_Invoice.Select_InvoiceCategory();
				certificate.Click_Next();
				job.Breakdown_Value("100");
				job.Invoice_Saves();
				pre_Invoice.Click_Exit();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
			}
			
			@Test(priority = 34)
			public void AddPartsForJob() throws InterruptedException 
			{

				Add_Notes add_Notes = new Add_Notes(driver);
				Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
			   
			    Job job = new Job(driver);
			    Customer customer = new Customer(driver);
			    Parts parts = new Parts(driver);
				customer.Side_Menu();
				customer.Customer_search();
				customer.Customer_Searchtext(EditName, Surname);
//				customer.Pass_CustomerNumber(PassCustomerNumber);
				MobileEnter();
				add_Notes.Click_Cus(EditName, Surname,PassCustomerNumber);
				add_Notes.Click_Choc_MenuButton();
				customer.Customer_Ongoing();
				customer.Customer_PlusBtn();
				job.Add_New_Job();
				job.Click_Des();
				job.Job_Des();
				job.Click_Tick();
				pre_Invoice.Click_FirstJob();
				add_Notes.Click_Choc_MenuButton();
				parts.Click_Parts();
				parts.Click_FabIconInPartsScreen();
				parts.Type_PartName(PartName);
				parts.Click_Search();
				parts.Select_Quantity(PartName);
				parts.Click_Save();
				parts.Click_Save();
				parts.Click_Requested();
				parts.Click_FulfilPart();
				parts.Click_Save();
				parts.Type_SupplierName();
				parts.Select_Supplier();
				parts.Click_Part_In_PurchaseOrderScreen(PartName);
				parts.Select_NominalCode();
				parts.Click_Save();
				parts.Click_Save();
				parts.Verify_OnOrder_Status(PartName);
				SwitchToStockWarehouseApp();
				parts.DueOutPart(PartName);
				parts.WaitForCheckPartsInScreen(PartName);
				parts.CheckInPart();
				parts.Verify_CheckInPart();
				SwitchToV4App();
				scrolltothedown(517, 720, 517, 1815);
				parts.Verify_AvailableStatus();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_NavigateUp_BackButton();
				Click_MenuClosed_BackButton();
			
			}



}
