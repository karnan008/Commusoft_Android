package testcase;

import org.testng.annotations.Test;
import action.BaseClass;
import pages.Customer;
import pages.Diary;
import pages.Estimate;
import pages.Job;
//Pixel 3XL with API 30
public class Smoke_Test extends BaseClass{
	
//	public Customer getcustomer(String test) {
//		
//		if("iOS".equals(test)) {
//			return new Customer();
//		}
//	}
	
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
	
	@Test (priority=1)
	public void Create_Estimate1() throws InterruptedException
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
		estimate.Book_Diary();
		estimate.Estimate_Save();
//		swipe(driver, DIRECTION.LEFT);
//		swipe(driver, DIRECTION.LEFT);
//		swipe(driver, DIRECTION.LEFT);
//		swipe(driver, DIRECTION.LEFT);
//		swipe(driver, DIRECTION.LEFT);
//		swipe(driver, DIRECTION.LEFT);
		//scrolltothetop(500,400,500,1800);
		scrolltothetop(500,500,500,2400);//simulator
		//doubleclickpoint(500,400);
		doubleclickpoint(500,510);//simulator
		estimate.Book_Event();
		estimate.Savebtn();
		
		
	}
	@Test (priority = 2)
	public void Estimate1_Accept_On_Diary() throws InterruptedException
	{
		Thread.sleep(10000);
		Estimate estimate = new Estimate(driver);
		Diary diary = new Diary(driver);
		//clickpoint(500, 400);
		clickpoint(500, 510);//simulator
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
		//scrolltothetop(500,1800,500,400);
		scrolltothetop(500,2200,500,650);//simulator
		//signature(150, 1700, 600, 1600);
		signature(220, 2100, 700, 1890);//simulator
		estimate.Estimate_Acceptbtn();
		estimate.Estimate_Leave();
		//signature(200, 1300, 500, 900);
		signature(300, 1700, 900, 1400);//simulator
		estimate.Sign_save();
		//signature(250, 1000, 650, 850);
		signature(300, 1250, 920, 980);//simulator
		estimate.Sign_save();
		estimate.Final_Diary();
	}
	@Test (priority=3)
	public void Create_Estimate2() throws InterruptedException
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
		estimate.Book_Diary();
		estimate.Estimate_Save();
//		swipe(driver, DIRECTION.LEFT);
		//scrolltothetop(500,400,500,1800);
		scrolltothetop(500,500,500,2400);//simulator
		//doubleclickpoint(500,550);
		doubleclickpoint(600,700);//simulator
		estimate.Book_Event();
		estimate.Savebtn();
	}
	@Test (priority = 4)
	public void Estimate2_Reject_On_Diary() throws InterruptedException
	{
		Thread.sleep(10000);
		Estimate estimate = new Estimate(driver);
		Diary diary = new Diary(driver);
		clickpoint(600, 700);
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
		estimate.Estimate_Reject();
		estimate.YES();
		estimate.Reject_Reason_Dropdown();
		estimate.Reject_Reason();
		estimate.Reject_Additional_Comments();
		estimate.Estimate_Rejectbtn();
		estimate.Estimate_Leave();
		//signature(200, 1300, 500, 900);
		signature(300, 1700, 900, 1400);//simulator
		estimate.Sign_save();
		//signature(250, 1000, 650, 850);
		signature(300, 1250, 920, 980);//simulator
		estimate.Sign_save();
		estimate.Final_Diary();
	}
	@Test (priority = 5)
	public void Create_Job1() throws InterruptedException
	{
		Thread.sleep(10000);
		Customer customer = new Customer(driver);
		Estimate estimate = new Estimate(driver);
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
		scrolltothetop(500,1800,500,300);
		job.Book_Diary_Job();
		Savebtn();
//		swipe(driver, DIRECTION.LEFT);
		//scrolltothetop(500,400,500,1800);
		scrolltothetop(500,500,500,2400);//simulator
		//doubleclickpoint(500,700);
		doubleclickpoint(500, 950);//simulator
		estimate.Book_Event();
		estimate.Savebtn();
	}
	@Test (priority=6)
	public void Job1_Final_Invoice() throws InterruptedException
	{
		Thread.sleep(10000);
		Job job = new Job(driver);
		Diary diary = new Diary(driver);
		//clickpoint(500, 700);
		clickpoint(500, 950);//simulator
		diary.Diary_Accept();
		diary.Diary_Travel();
		diary.Diary_Arrive();
		job.Arrive_Question();
		job.Sign_save();
		//signature(250, 1380, 550, 1220);
		signature(300, 1500, 1000, 1400);//simulator
		job.Sign_save();
		job.Job_Report();
		job.Leave_Question();
		job.Sign_save();
		job.Job_Leave();
		job.Complete_Continue();
		//scrolltothetop(500,1800,500,400);
		scrolltothetop(500,500,500,2400);//simulator
		//signature(272, 1517, 600, 1373);
		signature(272, 1800, 800, 1870);//simulator
		job.Sign_save();
		//signature(300, 1016, 600, 920);
		signature(300, 1200, 800, 920);//simulator
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
		job.Job_Final_Diary();
	}
	@Test (priority =7)
	public void Create_2Job() throws InterruptedException
	{
		Thread.sleep(10000);
		Customer customer = new Customer(driver);
		Estimate estimate = new Estimate(driver);
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
		scrolltothetop(500,1800,500,400);
		job.Book_Diary_Job();
		Savebtn();
//		swipe(driver, DIRECTION.LEFT);
		scrolltothetop(500,500,500,2400);//simulator
		//scrolltothetop(500,400,500,1800);
		//doubleclickpoint(500,900);
		doubleclickpoint(500,1200);
		estimate.Book_Event();
		estimate.Savebtn();
	}
	@Test (priority=8)
	public void Job2_FOC() throws InterruptedException
	{
		Thread.sleep(10000);
		Job job = new Job(driver);
		Diary diary = new Diary(driver);
		//clickpoint(350, 2021);
		clickpoint(500, 1200);//simulator
		diary.Diary_Accept();
		diary.Diary_Travel();
		diary.Diary_Arrive();
		job.Arrive_Question();
		job.Sign_save();
		//signature(250, 1380, 550, 1220);
		signature(300, 1500, 1000, 1400);//simulator
		job.Sign_save();
		job.Job_Report();
		job.Leave_Question();
		job.Sign_save();
		job.Job_Leave();
		job.Complete_Continue();
		scrolltothetop(500,1800,500,400);
		//signature(272, 1517, 600, 1373);
		signature(272, 1800, 800, 1870);//simulator
		job.Sign_save();
		//signature(300, 1016, 600, 920);
		signature(300, 1200, 800, 920);//simulator
		job.Sign_save();
		job.FOC();
		job.FOC_Reason();
		job.FOC_Comment();
		job.Sign_save();
		job.Job_Final_Diary();
	}
	@Test (priority = 9)
	public void Customer_Edit() throws InterruptedException
	{
		Thread.sleep(10000);
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
	@Test (priority = 10)
	public void Add_Service_Reminder() throws InterruptedException
	{
		Thread.sleep(10000);
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
	@Test (priority = 11)
	public void Add_WA() throws InterruptedException
	{
		Thread.sleep(10000);
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
	@Test (priority = 12)
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
	
	@Test (priority = 13)
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
	@Test (priority = 14)
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
	@Test (priority = 15)
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
	@Test (priority = 16)
	public void Add_Parts() throws InterruptedException
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
		customer.Customer_More();
		job.Parts_tab();
		job.Parts_Offline_Check();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
