package MobAndWeb_Page;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AssetNewUIMob extends Wrapper{
	
	public AssetNewUIMob(AndroidDriver<MobileElement> sdriver) 
	{
	    this.driver = sdriver;	
	}
	
	public void Labs() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Labs']");
		click("//*[@text='Labs']");
	}
	
	public void EnableNewAssets() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Labs']");		
		
		
		String assetYesOrNo = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView")).getText();
		
		if(assetYesOrNo.equals("No"))
			click("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView");
		else
			System.out.println("Already the asset enabled");
		
		
	}
	
//	add_Notes.Click_Choc_MenuButton();
//	assets.Click_Assets();
//	add_Notes.Click_FabIcon_NewUI();

	public void Search_Asset() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.ImageView'])[2]");
		click("(//*[@class='android.widget.ImageView'])[2]");
	}

	public void Type_AssetType(String type) 
	{
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", type);
	}
	
	public void Select_Asset(String type) 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+type+"']");
		click("//*[@text='"+type+"']");
	}
	
	public void Fuel() 
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Fuel')]/following-sibling::*[1]");
		click("//*[contains(@text,'Fuel')]/following-sibling::*[1]");
	}
	
	public void Select_Fuel(String fuel) 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		click("//*[@class='android.widget.EditText']");
		clear("//*[@class='android.widget.EditText']");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", fuel);
		ExplicitWait_ElementToBeClickable("//*[@text='"+fuel+"']");
		click("(//*[@text='"+fuel+"'])[2]");
		
	}
	public void Make() 
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Make')]/following-sibling::*[1]");
		click("//*[contains(@text,'Make')]/following-sibling::*[1]");
	}
	public void Select_Make(String make) 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		click("//*[@class='android.widget.EditText']");
		clear("//*[@class='android.widget.EditText']");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", make);
		ExplicitWait_ElementToBeClickable("//*[@text='"+make+"']");
		click("(//*[@text='"+make+"'])[2]");
		
	}
	
	public void Model() 
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Model')]/following-sibling::*[1]");
		click("//*[contains(@text,'Model')]/following-sibling::*[1]");
	}
	public void Select_Model(String model) 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		click("//*[@class='android.widget.EditText']");
		clear("//*[@class='android.widget.EditText']");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", model);
		ExplicitWait_ElementToBeClickable("//*[@text='"+model+"']");
		click("(//*[@text='"+model+"'])[2]");
		
	}
	
	public void Location() 
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Location')]/following-sibling::*[1]");
		click("//*[contains(@text,'Location')]/following-sibling::*[1]");
	}
	public void Select_Location(String location) 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		click("//*[@class='android.widget.EditText']");
		clear("//*[@class='android.widget.EditText']");
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
		type("//*[@class='android.widget.EditText']", location);
		ExplicitWait_ElementToBeClickable("//*[@text='"+location+"']");
		click("(//*[@text='"+location+"'])[2]");
		
	}
//	attached_Files.Click_Save();
	
	//--------------Edit--------------------
	
	public void Click_CustomerAsset(String type) 
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'"+type+"')]");
		click("//*[contains(@text,'"+type+"')]");
	}
	
	public void Edit() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
		click("//*[@text='Edit']");
	}
	//Fuel
//	Select_Fuel
//	Make
//	Select_Make
//	Model
//	Select_Model
//	Location
//	Select_Location
//	attached_Files.Click_Save();
	
	//-------------------Delete -------------------------
	
	public void Swipe_Asset() 
	{
		TwoSec();
		Swipe(876, 521, 367, 521);
	}
//	reminder.Delete();
//	reminder.Delete();
	
	public void Verify_DeletedCustomerAsset() //*[@text='There are currently no assets saved against this property, click to add one']
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.TextView'])[1]");
		MobileElement Expected = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]"));
	
		Verify_AssertTrue(Expected);
		
	}
	
//	add_Notes.Click_FabIcon_NewUI();

//	public void Search_Asset() 
//	{
//		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.ImageView'])[2]");
//		click("(//*[@class='android.widget.ImageView'])[2]");
//	}
//
//	public void Type_AssetType(String type) 
//	{
//		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
//		type("//*[@class='android.widget.EditText']", type);
//	}
//	
//	public void Select_Asset(String type) 
//	{
//		ExplicitWait_ElementToBeClickable("//*[@text='"+type+"']");
//		click("//*[@text='"+type+"']");
//	}
//	
//	public void Fuel() 
//	{
//		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Fuel')]/following-sibling::*[1]");
//		click("//*[contains(@text,'Fuel')]/following-sibling::*[1]");
//	}
//	
//	public void Select_Fuel(String fuel) 
//	{
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		click("//*[@class='android.widget.EditText']");
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		type("//*[@class='android.widget.EditText']", fuel);
//		ExplicitWait_ElementToBeClickable("//*[@text='"+fuel+"']");
//		click("//*[@text='"+fuel+"']");
//		
//	}
//	public void Make() 
//	{
//		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Make')]/following-sibling::*[1]");
//		click("//*[contains(@text,'Make')]/following-sibling::*[1]");
//	}
//	public void Select_Make(String make) 
//	{
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		click("//*[@class='android.widget.EditText']");
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		type("//*[@class='android.widget.EditText']", make);
//		ExplicitWait_ElementToBeClickable("//*[@text='"+make+"']");
//		click("//*[@text='"+make+"']");
//		
//	}
//	
//	public void Model() 
//	{
//		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Model')]/following-sibling::*[1]");
//		click("//*[contains(@text,'Model')]/following-sibling::*[1]");
//	}
//	public void Select_Model(String model) 
//	{
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		click("//*[@class='android.widget.EditText']");
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		type("//*[@class='android.widget.EditText']", model);
//		ExplicitWait_ElementToBeClickable("//*[@text='"+model+"']");
//		click("//*[@text='"+model+"']");
//		
//	}
//	
//	public void Location() 
//	{
//		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Location')]/following-sibling::*[1]");
//		click("//*[contains(@text,'Location')]/following-sibling::*[1]");
//	}
//	public void Select_Location(String location) 
//	{
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		click("//*[@class='android.widget.EditText']");
//		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.EditText']");
//		type("//*[@class='android.widget.EditText']", location);
//		ExplicitWait_ElementToBeClickable("//*[@text='"+location+"']");
//		click("//*[@text='"+location+"']");
//		
//	}
//	attached_Files.Click_Save();
	
	public void Back_AssetNewUI() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageView'][1]");
		click("//*[@class='android.widget.ImageView'][1]");
	}
}
