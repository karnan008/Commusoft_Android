package MobAndWeb_Page;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Newui_CreateCustomerOnMob extends Wrapper{

	public Newui_CreateCustomerOnMob(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}

	public void Search_Tab() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Search']");
		click("//*[@text='Search']"); 
	}
	public void Home() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Home']");
		click("//*[@text='Home']"); 
	}
	public void FabIcon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Button']");
		click("//*[@class='android.widget.Button']");
	}

	public void AddProperty() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='Add Property']/following-sibling::*[@class='android.view.View'])[1]");
		click("(//*[@text='Add Property']/following-sibling::*[@class='android.view.View'])[1]");
	}

	public void Typeofproperty() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/propertyspinner']");
		click("//*[@resource-id='com.commusoft.v4:id/propertyspinner']");
	}
	public void Click_Customer() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Customer']");
		click("//*[@text='Customer']");
	}
	public void TypeofCustomer() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/customertypespinnerView']");
		click("//*[@resource-id='com.commusoft.v4:id/customertypespinnerView']");
	}
	public void Click_PrivateCustomer() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Private Customer']");
		click("//*[@text='Private Customer']");
	}

	//	customer.Customer_title(Title);
	//	customer.Customer_Name(Name);
	//	customer.Customer_SurName(Surname);
	//	customer.Customer_Telephone("8248724397");
	//	customer.Customer_Mobile("8248724397");
	//	customer.Customer_email("ssaravanan@commusoft.com");
	//	customer.Customer_AddressLine1("Address line 1");
	//	customer.Customer_Save();
	//	ThreeSec();
	//	customer.StoreCustomerNumber();

	public void SearchTab() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Search']");
		click("//*[@text='Search']");
	}

	public void SearchCustomerByNumber() throws AWTException, InterruptedException 
	{
		
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		clear("//*[@class='android.widget.EditText']");
		customernumber = System.getProperty("customernumber");
		MobileElement num = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
		num.sendKeys(customernumber);
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[1]");
		click("(//*[@class='android.widget.ImageView'])[1]");

	}
	public void PassCustomerNumber(String passcustomernumber) throws InterruptedException 
	{
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
//		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", editname+" "+surname);
		
		type("//*[@class='android.widget.EditText']", passcustomernumber);
		Thread.sleep(2000);
		click("(//*[@class='android.widget.ImageView'])[1]");
	}

	public void SelectCustomer() 
	{
//		ExplicitWait_ElementToBeClickable("(//*[@text='Properties']/following-sibling::*[@class='android.view.View'])[1]");
//		click("(//*[@text='Properties']/following-sibling::*[@class='android.view.View'])[1]");
		
		ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[4]");
		click("(//*[@class='android.view.View'])[4]");
	}

	public void VerifyWebCustomerName() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/customer_name']");
		String webcustomername = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/customer_name']")).getText();
		webcustomer=System.getProperty("webcustomer");
		assertEquals(webcustomername, webcustomer);


	}
	public void VerifyWebCustomerEmail() 
	{

		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/customer_name']");
		click("//*[@resource-id='com.commusoft.v4:id/customer_name']");

		try 
		{

			ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/contact_mail']");
			String email = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/contact_mail']")).getText();
			webemail=System.getProperty("webemail");
			assertEquals(email, webemail);

		}catch(Exception e) 
		{
			ThreeSec();
			ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/customer_name']");
			click("//*[@resource-id='com.commusoft.v4:id/customer_name']");
			ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/contact_mail']");
			String email = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/contact_mail']")).getText();
			webemail=System.getProperty("webemail");
			assertEquals(email, webemail);
		}


	}



}
