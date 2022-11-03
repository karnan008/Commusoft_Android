package testcase;

import org.testng.annotations.Test;

import action.BaseClass;
import pages.Customer;

public class Shiva_demo extends BaseClass{
	
	@Test (priority = 0)
	public void Demo() throws InterruptedException 
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

}
