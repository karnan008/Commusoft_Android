package Pages;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Edit_WorkAddress extends Wrapper{
	
	public Edit_WorkAddress(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
//	customer.Side_Menu();
//	customer.Customer_search();
//	customer.TypeCustomerNameInSearchField(EditName,Surname);
//	MobileEnter();
//	add_Notes.Click_Cus(EditName, Surname);
//	add_Notes.Click_ChocolateMenuButton();
//	customer.WA();
	
	public void Click_WorkAddress_Cus(String editname,String surname) 
	{
		TwoSec();
		ExplicitWait_ElementToBeClickable("//*[@text='Mr & Mrs "+editname+" "+surname+"']");
		click("//*[@text='Mr & Mrs "+editname+" "+surname+"']");
	}
	
//	clickpoint(468,837);
//	edit_Customer.Click_EditButton();
//	edit_Customer.Edit_Name(EditName);
//	edit_Customer.Edit_Landline(EditLandline);
//	edit_Customer.Edit_Mobile(EditMob);
//	edit_Customer.Edit_Email(EditEmail);
//	edit_Customer.Edit_AddressLine1(EditAddress1);
//	FiveSec();
//	customer.Customer_Save();
//	edit_Customer.Verify_EditedEmail(EditEmail);
//	edit_Customer.Verify_EditedMobile(EditMob);
//	edit_Customer.Verify_EditedLandline(EditLandline);
//	edit_Customer.Verify_EditedAddress1(EditAddress1);
	
	public void WorkAddressBack() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageButton']");
		click("//*[@class='android.widget.ImageButton']");
	}
	
//	edit_Customer.Verify_EditedName(EditName, Surname);
//	WorkAddressBack
//	WorkAddressBack
//	customer.Customer_Back();
//	customer.Customer_Back();
	
	
	

}
