package Test;

import org.testng.annotations.Test;

import MainPack.CommusoftDevBaseClass;
import Pages.Create_NewCustomer;
import Pages.LoginPageForCommusoftDev;



public class CommusoftDevTestClass extends CommusoftDevBaseClass{
	
	
	@Test(enabled=false)
	public void LoginTest() throws InterruptedException 
	{
		LoginPageForCommusoftDev log_dev=new LoginPageForCommusoftDev(driver);
		
		log_dev.EnterId();
		log_dev.Enter_Username();
		log_dev.Enter_Password();
		log_dev.Click_SigninButton();
		log_dev.AcceptPermission();
		log_dev.Click_NextButton1();
		log_dev.Click_NextButton2();
		log_dev.Click_Yes();
//		log_dev.LoadingPage();
//		log_dev.Username_Verification();
		
		
	}
	@Test(priority=1)
	public void CustomerTest() throws InterruptedException 
	{
		Create_NewCustomer create_NewCustomer = new Create_NewCustomer(driver);
		create_NewCustomer.ClickMenu();
		create_NewCustomer.Click_NewPrivateCustomer();
		create_NewCustomer.Enter_Surname();
		create_NewCustomer.Enter_Addressline1();
		create_NewCustomer.Click_Tick();
		create_NewCustomer.Click_Backbutton();
		create_NewCustomer.ClickMenu();
		create_NewCustomer.Click_Search();
		create_NewCustomer.Enter_Customer();
		
		
		
	}
	

}
