package MobAndWeb_Page;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class NewUI_EditCustomerOnMob extends Wrapper{
	
	public NewUI_EditCustomerOnMob(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}

	public void Click_Customer() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+customernumber+"']");
		click("//*[@text='"+customernumber+"']");
	}
	public void Click_workaddress() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+workaddressnumber+"']");
		click("//*[@text='"+workaddressnumber+"']");
	}
	
	
	public void Click_EditButton() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='edit'])[2]");
		click("(//*[@text='edit'])[2]");
	}
	public void Edit_Name(String editname)
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/firstNameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/firstNameValue']", editname);
	}
	public void Edit_Landline(String editlandline) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/telephoneValue']");
		type("//*[@resource-id='com.commusoft.v4:id/telephoneValue']",editlandline);

	}
	public void Edit_Mobile(String editmob) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/mobileValue']");
		type("//*[@resource-id='com.commusoft.v4:id/mobileValue']", editmob);//com.commusoft.v4:id/mobileValue
	}
	public void Edit_Email(String editemail) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/emailAddress']");
		type("//*[@resource-id='com.commusoft.v4:id/emailAddress']", editemail);//com.commusoft.v4:id/emailAddress
	}
	public void Edit_AddressLine1(String editaddress1) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/formaddressLine1']");
		type("//*[@resource-id='com.commusoft.v4:id/formaddressLine1']", editaddress1);//com.commusoft.v4:id/formaddressLine1
	}

	//customer.Customer_Save();

	public void Verify_EditedEmail(String editemail)
	{
		ExplicitWait_PresenceOfEle("//*[@text='"+editemail+"']");
		MobileElement editedemail = driver.findElement(By.xpath("//*[@text='"+editemail+"']"));
		Assert.assertTrue(editedemail.isDisplayed());
//		System.out.println("Edited Email Is: "+ editedemail.getText());
//		System.err.println("Customer edited name in mob: "+"//*[@text='"+editemail+"']");


	}
	public void Verify_EditedMobile(String editmob)
	{
		ThreeSec();
		ExplicitWait_PresenceOfEle("//*[@text='+44 "+editmob+"']");
		MobileElement editedmob = driver.findElement(By.xpath("//*[@text='+44 "+editmob+"']"));
		Assert.assertTrue(editedmob.isDisplayed());
//		System.out.println("Edited Mobile Is: "+ editedmob.getText());


	}
	public void Verify_EditedLandline(String editlandline)
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@text='+44 "+editlandline+"']");
		MobileElement editedlandline = driver.findElement(By.xpath("//*[@text='+44 "+editlandline+"']"));
		Assert.assertTrue(editedlandline.isDisplayed());
//		System.out.println("Edited Landline Is: "+ editedlandline.getText());


	}

	public void Verify_EditedAddress1(String editaddress1)
	{
		ExplicitWait_PresenceOfEle("//*[@text='"+editaddress1+"']");
		MobileElement editedaddress1 = driver.findElement(By.xpath("//*[@text='"+editaddress1+"']"));
		Assert.assertTrue(editedaddress1.isDisplayed());
//		System.out.println("Edited Addressline1 Is: "+ editedaddress1.getText());
//		System.err.println("Customer edited name in mob: "+"//*[@text='"+editaddress1+"']");


	}
	//customer.Customer_Back();
	public void Verify_EditedName(String title,String editname,String surname)
	{                                        
		ExplicitWait_PresenceOfEle("//*[@text='"+title+" "+editname+" "+surname+"']");
		MobileElement editedname = driver.findElement(By.xpath("//*[@text='"+title+" "+editname+" "+surname+"']"));
		Assert.assertTrue(editedname.isDisplayed());
//		System.out.println("Edited Name Is: "+ editedname.getText());
//		System.err.println("Customer edited name in mob: "+"//*[@text='Mr & Mrs "+editname+" "+surname+"']");


	}
	
	public void Click_NavBackbutton() 
	{
		ExplicitWait_PresenceOfEle("//*[@content-desc='Navigate up']");
		click("//*[@content-desc='Navigate up']");
	}
	
	
	
	
}
