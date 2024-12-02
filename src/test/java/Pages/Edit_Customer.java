package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Edit_Customer extends Wrapper{

	public Edit_Customer(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}

	public void Click_Cus(String name,String surname) throws InterruptedException   
	{
		
			ScrollDown24LastText("Mr & Mrs "+name+" "+surname);
			ExplicitWait_ElementToBeClickable("(//*[@text='Mr & Mrs "+name+" "+surname+"'])[last()]");//"(//*[@text='Mr & Mrs "+name+" "+surname+"'])[last()]"
			click("(//*[@text='Mr & Mrs "+name+" "+surname+"'])[last()]");
			ExplicitWait_PresenceOfEle("(//*[@text='Mr & Mrs "+name+" "+surname+"'])[last()]");
			
		
	}
	// click point: 399,567
	public void Click_Cus_InCusDetailsScreen(String name,String surname) 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Mr & Mrs "+name+" "+surname+"']");
		
		try 
		{
			if(driver.findElement(By.xpath("//*[@text='Mr & Mrs "+name+" "+surname+"']")).isDisplayed()) 
			{
				click("//*[@text='Mr & Mrs "+name+" "+surname+"']");
			}
		}catch(Exception e) 
		{
			click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");//Click menu button 
			ExplicitWait_ElementToBeClickable("//*[@text='Details']");
            click("//*[@text='Details']");
            ExplicitWait_ElementToBeClickable("//*[@text='Mr & Mrs "+name+" "+surname+"']");
            click("//*[@text='Mr & Mrs "+name+" "+surname+"']");
		}
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


	}
	//customer.Customer_Back();
	public void Verify_EditedName(String editname,String surname)
	{                                        
		ExplicitWait_PresenceOfEle("//*[@text='Mr & Mrs "+editname+" "+surname+"']");
		MobileElement editedname = driver.findElement(By.xpath("//*[@text='Mr & Mrs "+editname+" "+surname+"']"));
		Assert.assertTrue(editedname.isDisplayed());
//		System.out.println("Edited Name Is: "+ editedname.getText());


	}
	//customer.Customer_Back();
	//customer.Side_Menu();
	//customer.Click_FavCus();
	public void Verify_EditedNameinFavCusScreen(String editname,String surname) 
	{

		ExplicitWait_PresenceOfEle("(//*[@text='Mr & Mrs "+editname+" "+surname+"'])[last()]");

		MobileElement editedname = driver.findElement(By.xpath("(//*[@text='Mr & Mrs "+editname+" "+surname+"'])[last()]"));

		Assert.assertTrue(editedname.isDisplayed());
//		System.out.println("Edited Name In Favourite Customer Screen Is: "+ editedname.getText());


	}
	public void Click_ViewDiary() throws InterruptedException 
	{
		ScrollTop24("View Diary");
		ExplicitWait_PresenceOfEle("//*[@text='View Diary']");
		click("//*[@text='View Diary']");
	}





}
