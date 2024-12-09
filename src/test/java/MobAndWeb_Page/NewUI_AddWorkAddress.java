package MobAndWeb_Page;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NewUI_AddWorkAddress extends Wrapper{
	
	public NewUI_AddWorkAddress(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}

	public void OpenMenu() throws InterruptedException 
	{
		
		ExplicitWait_PresenceOfEle("//*[@content-desc='Open']");
		click("//*[@content-desc='Open']");
	}
	
//	customer.WA();
//	customer.WA_Add();
//	customer.WA_Name(WorkAddressName);
//	customer.WA_Surname(WorkAddressLastName);
//	customer.Customer_Telephone("4547845154");
//	customer.Customer_Mobile("45478315448");
//	customer.Customer_email("Workaddress@gmail.com");
//	customer.Scrollto_WA_Address();
//	customer.WA_Address("Address");
//	customer.Customer_Save();
	
	public void Click_WorkAddress() throws InterruptedException 
	{
//		Thread.sleep(30000);
		ExplicitWait_PresenceOfEle("//*[starts-with(@text,'Mr & Mrs')]");
		click("//*[starts-with(@text,'Mr & Mrs')]");
	}
	
	public void Store_WorkAddressNumber() 
	{
		ThreeSec();
		ExplicitWait_PresenceOfEle("//*[@text='Account No']/following-sibling::*[@resource-id='com.commusoft.v4:id/workaddress_account']");
		workaddressnumber = driver.findElement(By.xpath("//*[@text='Account No']/following-sibling::*[@resource-id='com.commusoft.v4:id/workaddress_account']")).getText();
		System.setProperty("workaddressnumber", workaddressnumber);
		
		System.out.println("Workaddress Number Is: "+workaddressnumber);
	}
}
