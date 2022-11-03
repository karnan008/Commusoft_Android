package testcase;

import org.testng.annotations.Test;

import action.BaseClass;
import pages.Customer;
import pages.Diary;
import pages.Estimate;

public class Estimate_Usecases extends BaseClass {

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
		swipe(driver, DIRECTION.LEFT);
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
		swipe(driver, DIRECTION.LEFT);
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
	public void Ongoing_Estimate_Accept() throws InterruptedException
	{
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
		Ongoing_EstimateNo();
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
	
	@Test (priority = 6)
	public void Ongoing_Estimate_Reject() throws InterruptedException
	{
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
		Ongoing_EstimateNo();
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
	
	
}
