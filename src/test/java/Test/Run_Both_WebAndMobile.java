package Test;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import MainPack.BaseClass;
import MobAndWeb_Page.EstimateAccept;
import Pages.Add_Notes;
import Pages.Customer;
import Pages.EnableNewUI;
import Pages.Job;
import Pages.Parts;
import Pages.Pre_Invoice;
import Pages.Web_Settings;

public class Run_Both_WebAndMobile extends BaseClass{
	
	
	@Test(priority = 1)
	public void EnablePicklistOnInWeb() throws InterruptedException 
	{
		Web_Settings web_Settings = new Web_Settings(driverWeb);
		EnableNewUI enableNewUI = new EnableNewUI(driver);
//		enableNewUI.OpenSideMenu();
		web_Settings.LoginInWeb();
		web_Settings.WebSettings();
		web_Settings.SystemSettings();
		web_Settings.SetUpPartCollectionWorkflow_Setting();
		web_Settings.Enable_PicklistOn();
		web_Settings.Save_Picklist();
		
	}
	
	@Test(enabled=false)
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
	public void PickupPartsFromStomRoom() throws InterruptedException 
	{
		Parts parts = new Parts(driver);
		Add_Notes add_Notes = new Add_Notes(driver);
		Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
	    Job job = new Job(driver);
	    Customer customer = new Customer(driver);
	    
	   
	    parts.NewUI_Search();
	    parts.Search_CustomerNumber(PassCustomerNumber);
	    parts.Select_Customer();
	    add_Notes.Click_Choc_MenuButton();
		customer.Customer_Ongoing();
		customer.Customer_PlusBtn();
		job.Add_New_Job();
		job.Click_Des();
		job.Job_Des();
		job.Click_Tick();
		pre_Invoice.Click_FirstJob();
		
		
	}
	
	@Test(priority = 2)
	public void AddPartsForJob() throws InterruptedException, IOException 
	{

		Add_Notes add_Notes = new Add_Notes(driver);
		Pre_Invoice pre_Invoice = new Pre_Invoice(driver);
		EstimateAccept estimate2 = new EstimateAccept(driver);
	    
	    MobAndWeb_Page.Job job2 = new MobAndWeb_Page.Job(driver);
	    Customer customer = new Customer(driver);
	    Parts parts = new Parts(driver);
	    EnableNewUI enableNewUI = new EnableNewUI(driver);
	    estimate2.Diary();
//		estimate2.Fabicon();
//		job2.Click_Job();
//		estimate2.starttime();
//		estimate2.SelectStartTime();
//		estimate2.EndTime();
//		estimate2.SelectEndTime();
//		estimate2.PassCustomer();
//		estimate2.SelectCustomer();
//		job2.JobDescription();
//		job2.SaveJob();
//		estimate2.EstimateTravel();
//		estimate2.Diary_Accept();
//		job2.StoreJobNumber();
//		add_Notes.Click_Choc_MenuButton();
//		parts.Click_Parts();
//		parts.Click_FabIconInPartsScreen();
//		parts.Type_PartName(PartName);
//		parts.Click_Search();
//		parts.Select_Quantity(PartName);
//		parts.Click_Save();
//		parts.Click_Save();
//		parts.Click_Requested();
//		parts.Click_FulfilPart();
//		parts.Click_Save();
//		parts.Type_SupplierName();
//		parts.Select_Supplier();
//		parts.Click_Part_In_PurchaseOrderScreen(PartName);
//		parts.Select_NominalCode();
//		parts.Click_Save();
//		parts.Click_Save();
//		parts.Verify_OnOrder_Status(PartName);
//		parts.V4AppSwitchDemo();
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
