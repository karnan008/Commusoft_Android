package testcase;

import org.testng.annotations.Test;

import action.BaseClass;
import pages.Customer;
import pages.Diary;
import pages.Estimate;
import pages.Job;

public class Job_Usecases extends BaseClass
{

	
	

	@Test(priority = 0)
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
	@Test (priority = 1)
	public void Create_Job1() throws InterruptedException
	{
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
		//scrolltothetop(500,400,500,1800);
		scrolltothetop(500,500,500,2400);//simulator
		//doubleclickpoint(500,700);
		doubleclickpoint(500, 950);//simulator
		estimate.Book_Event();
		estimate.Savebtn();
	}
	@Test (priority=2)
	public void Job1_Final_Invoice() throws InterruptedException
	{
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
	@Test (priority =3)
	public void Create_2Job() throws InterruptedException
	{
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
		scrolltothetop(500,500,500,2400);//simulator
		//scrolltothetop(500,400,500,1800);
		//doubleclickpoint(500,900);
		doubleclickpoint(500,1200);
		estimate.Book_Event();
		estimate.Savebtn();
	}
	@Test (priority=4)
	public void Job2_FOC() throws InterruptedException
	{
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
	@Test (priority = 5)
	public void Ongoing_Job_Invoice() throws InterruptedException
	{
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
	@Test (priority = 6)
	public void Ongoing_Job_FOC() throws InterruptedException
	{
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
	