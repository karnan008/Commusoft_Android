package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.testng.Assert;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EditWorkAddressOnMob extends Wrapper{
	
	public EditWorkAddressOnMob(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void Click_WorkAddress() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+workaddressnumber+"']");
		click("//*[@text='"+workaddressnumber+"']");
	}

	public void Click_EditButton() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='edit'])[2]");
		click("(//*[@text='edit'])[2]");
	}
	public void Edit_WorkAddressName(String editworkaddressname) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/firstNameValue']");
		type("//*[@resource-id='com.commusoft.v4:id/firstNameValue']", editworkaddressname);
	}
	public void Edit_WorkAddressEmail(String editworkaddressemail) 
	{
		ExplicitWait_VisibilityOfEle("//*[@resource-id='com.commusoft.v4:id/emailAddress']");
		type("//*[@resource-id='com.commusoft.v4:id/emailAddress']", editworkaddressemail);//com.commusoft.v4:id/emailAddress
	}
	//customer.Customer_Save();
	public void Verify_EditedEmail(String editworkaddressemail)
	{
		ExplicitWait_PresenceOfEle("//*[@text='"+editworkaddressemail+"']");
		MobileElement editedemail = driver.findElement(By.xpath("//*[@text='"+editworkaddressemail+"']"));
		Assert.assertTrue(editedemail.isDisplayed());
//		System.out.println("Edited Email Is: "+ editedemail.getText());
//		System.err.println("Customer edited name in mob: "+"//*[@text='"+editemail+"']");


	}
	//customer.Customer_Back();
	
	public void Verify_EditedName(String title,String editworkaddressname,String surname)
	{                                        
		ExplicitWait_PresenceOfEle("//*[@text='"+title+" "+editworkaddressname+" "+surname+"']");
		MobileElement editedname = driver.findElement(By.xpath("//*[@text='"+title+" "+editworkaddressname+" "+surname+"']"));
		Assert.assertTrue(editedname.isDisplayed());
//		System.out.println("Edited Name Is: "+ editedname.getText());
//		System.err.println("Customer edited name in mob: "+"//*[@text='Mr & Mrs "+editname+" "+surname+"']");


	}
	
	
	
	
	
	
	
	
}
