package Test;

import org.testng.annotations.Test;

import MainPack.BaseClass;
import Pages.AddCustomer_NewUI;
import Pages.Customer;
import Pages.Edit_Customer;
import Pages.EnableNewUI;

public class V4App_NewUISmoke extends BaseClass{

	@Test(enabled = false)
	public void V4App_EnableNewUI() throws InterruptedException 
	{
		EnableNewUI enableNewUI = new EnableNewUI(driver);
		enableNewUI.OpenSideMenu();
		enableNewUI.OldSettings();
		enableNewUI.EnableNewSetting();
		enableNewUI.Confirm_Yes();
		enableNewUI.Verify_HomeTab();
		enableNewUI.Verify_DiaryTab();
		enableNewUI.Verify_SearchTab();
		enableNewUI.Verify_MyVanTab();
		
	}
	@Test(priority = 1)
	public void AddCustomer_NewUi() throws InterruptedException 
	{
		AddCustomer_NewUI addCustomer_NewUI = new AddCustomer_NewUI(driver);
		Customer customer = new Customer(driver);
		addCustomer_NewUI.SearchTab();
		addCustomer_NewUI.Click_FabIcon();
		addCustomer_NewUI.Click_AddProperty();
		addCustomer_NewUI.Click_PropertyDropdown();
		addCustomer_NewUI.Select_Customer();
		addCustomer_NewUI.Click_CustomerDropdown();
		addCustomer_NewUI.Select_PrivateCustomer();
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
//		Click_NavigateUp_BackButton();
//		addCustomer_NewUI.HomeTab();
		
		
		
	}
	@Test(priority = 2)
	public void EditCustomer_NewUi() throws InterruptedException 
	{
		AddCustomer_NewUI addCustomer_NewUI = new AddCustomer_NewUI(driver);
		Edit_Customer edit_Customer = new Edit_Customer(driver);
		Customer customer = new Customer(driver);
		addCustomer_NewUI.Click_AccountNumber();
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
		addCustomer_NewUI.HomeTab();
	}

	
	@Test(priority = 2)
	public void Demo() throws InterruptedException 
	{
		AddCustomer_NewUI addCustomer_NewUI = new AddCustomer_NewUI(driver);
		Customer customer = new Customer(driver);
		addCustomer_NewUI.SearchTab();
		addCustomer_NewUI.Demo();
//		addCustomer_NewUI.Type_Search();
		
	
	}
	
}
