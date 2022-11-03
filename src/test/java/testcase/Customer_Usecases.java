package testcase;

import org.testng.annotations.Test;

import action.BaseClass;
import pages.Customer;

public class Customer_Usecases extends BaseClass{

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
	
}
