package testcase;

import org.testng.annotations.Test;

import action.BaseClass;
import pages.Customer;
import pages.Estimate;
import pages.Job;

public class Ongoing extends BaseClass{
	
	@Test (priority = 0)
	public void Create_Customer() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Side_Menu();
		customer.Private_Customer();
		customer.Customer_title(Title);
		customer.Customer_Name(FirstName);
		customer.Customer_SurName(LastName);
		customer.Customer_Telephone("8248724397");
		customer.Customer_Mobile("8248724397");
		customer.Customer_email("karnan@commusoft.com");
		customer.Customer_AddressLine1("Address line 1");
		customer.Customer_Save();
		customer.Customer_Fav();
		customer.Customer_Back();	
	}
	@Test(priority = 1)
	public void Customer_Edit() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_Edit();
		customer.Customer_edit1();
		customer.Edit_telephone();
		customer.Customer_Save();
		customer.Wholeback3();
		customer.Menu_Close();
	}
	@Test (priority = 2)
	public void Add_Service_Reminder() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Reminders();
		customer.Reminderplus();
		customer.ServiceReminder();
		customer.SelectReminder();
		customer.ReminderDate();
		customer.Sendto(TitleCustomerName);
		customer.Savebtn();
		customer.Wholeback2();
		customer.Menu_Close();
	}
	@Test (priority = 3)
	public void Add_WA() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.WA();
		customer.WA_Add();
		customer.WA_Name(WAName);
		customer.WA_Surname(LastName);
		customer.Scrollto_WA_Address();
		customer.WA_Address("Address");
		customer.Customer_Save();
		customer.Wholeback2();
		customer.Menu_Close();
	}
	@Test (priority = 4)
	public void Add_Contact() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Cus_Contact();
		customer.Customer_PlusBtn();
		customer.Choose_Contact();
		customer.Contact_Surname();
		customer.Customer_Save();
		customer.Wholeback2();
		customer.Menu_Close();
	}
	@Test (priority = 5)
	public void Customer_Notes() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Cus_notes();
		customer.Customer_PlusBtn();
		customer.Notes_plus();
		customer.Notes_Title();
		customer.Notes_body();
		customer.Customer_Save();
		
		customer.Notes_phonecall();
		customer.Note_calltype();
		customer.Note_callchoose();
		customer.Notes_contactname();
		customer.Notes_contactnamechoose(TitleCustomerName);
		customer.Phonecall();
		customer.Customer_Save();
		
		customer.Notes_Email();
		customer.Customer_Save();
		customer.Note_Emailsubject("Email Subject");
		customer.Customer_Save();
		
		customer.Notes_SMS(TitleCustomerName);
		customer.Customer_Save();
		customer.Wholeback2();
		customer.Menu_Close();
	}
	@Test (priority = 6)
	public void Ongoing_Estimate_Accept() throws InterruptedException
	{
		Thread.sleep(10000);
		Customer customer = new Customer(driver);
		Estimate estimate = new Estimate(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Customer_Ongoing();
		customer.Customer_PlusBtn();
		estimate.Add_Estimate();
		estimate.Estimate_Description();
		estimate.Estimate_Description_Template(EstimateDescription);
		estimate.Estimate_Save();
		estimate.Ongoing_EstimateNo();
		customer.Customer_More();
		estimate.Ongoing_Estimate();
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
		scrolltothetop(500,2200,500,650);//simulator
		signature(220, 2100, 700, 1890);//simulator
		estimate.Estimate_Acceptbtn();
		customer.Wholeback2();
		customer.Menu_Close();
	}
	
	@Test (priority = 7)
	public void Ongoing_Estimate_Reject() throws InterruptedException
	{
		Thread.sleep(12000);
		Customer customer = new Customer(driver);
		Estimate estimate = new Estimate(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Customer_Ongoing();
		customer.Customer_PlusBtn();
		estimate.Add_Estimate();
		estimate.Estimate_Description();
		estimate.Estimate_Description_Template(EstimateDescription);
		estimate.Estimate_Save();
		estimate.Ongoing_EstimateNo();
		customer.Customer_More();
		estimate.Ongoing_Estimate();
		estimate.FillinEstimate_Price();
		estimate.Price_NoBreakdown();
		estimate.Price_NoBreakdownselect(Breakdown);
		estimate.Breakdown_value("100");
		estimate.save();
		estimate.Invoice_Schedule();
		estimate.save();
		estimate.AcceptReject();
		estimate.Estimate_Checkbox();
		estimate.Estimate_Reject();
		estimate.YES();
		estimate.Reject_Reason_Dropdown();
		estimate.Reject_Reason();
		estimate.Reject_Additional_Comments();
		estimate.Estimate_Rejectbtn();
		customer.Wholeback2();
		customer.Menu_Close();
	}
	@Test (priority = 8)
	public void Ongoing_Job_Invoice() throws InterruptedException
	{
		Thread.sleep(10000);
		Customer customer = new Customer(driver);
		Job job = new Job(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Customer_Ongoing();
		customer.Customer_PlusBtn();
		job.Add_New_Job();
		job.Click_Des();
		job.Job_Des(JobDescription);
		Savebtn();
		job.Click_1st_Job();
		job.Ongoing_Job_Complete();
		job.Complete_Continue();
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
		customer.Wholeback3();
		customer.Menu_Close();
	}
	@Test (priority = 9)
	public void Ongoing_Job_FOC() throws InterruptedException
	{
		Thread.sleep(10000);
		Customer customer = new Customer(driver);
		Job job = new Job(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Customer_Ongoing();
		customer.Customer_PlusBtn();
		job.Add_New_Job();
		job.Click_Des();
		job.Job_Des(JobDescription);
		Savebtn();
		job.Click_1st_Job();
		job.Ongoing_Job_Complete();
		job.Complete_Continue();
		job.FOC();
		job.FOC_Reason();
		job.FOC_Comment();
		job.Sign_save();
		customer.Wholeback3();
		customer.Menu_Close();
	}

}
