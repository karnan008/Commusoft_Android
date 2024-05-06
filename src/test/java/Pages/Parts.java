package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;

import com.google.common.collect.ImmutableMap;

import MainPack.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Parts extends Wrapper{
	
	public Parts(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}

	
	public void Click_Parts() 
	{
		TwoSec();
		ExplicitWait_ElementToBeClickable("//*[@text='Parts']");
		click("//*[@text='Parts']");
	}
	public void Click_FabIconInPartsScreen() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/add']");
		click("//*[@resource-id='com.commusoft.v4:id/add']");
	}
	public void Type_PartName(String partname) //Search by part name or manufacturer no
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", partname);
	}
	
	public void Click_Search() //com.commusoft.v4:id/searchPartbutton
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/searchPartbutton']");
		click("//*[@resource-id='com.commusoft.v4:id/searchPartbutton']");
	}
	
	public void Select_Quantity(String partname) //NewPart3012
	{
//		ExplicitWait_ElementToBeClickable("//*[@text='"+partname+"']/following-sibling::*[@resource-id='com.commusoft.v4:id/increase']");
//		click("//*[@text='"+partname+"']/following-sibling::*[@resource-id='com.commusoft.v4:id/increase']");
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='com.commusoft.v4:id/increase'])[1]");
		click("(//*[@resource-id='com.commusoft.v4:id/increase'])[1]");
	}
	
	public void Click_Save() //com.commusoft.v4:id/save
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/save']");
		click("//*[@resource-id='com.commusoft.v4:id/save']");
	}
	
//	public void Click_BackButton() 
//	{
//		ExplicitWait_ElementToBeClickable("//*[@content-desc='Navigate up']");
//		click("//*[@content-desc='Navigate up']");
//	}
	
	public void Click_Requested() 
	{
		TwoSec();
//		ExplicitWait_ElementToBeClickable("//*[@text='"+partname+"']/following-sibling::*[@text='Requested']");
//		click("//*[@text='"+partname+"']/following-sibling::*[@text='Requested']");
//		ExplicitWait_ElementToBeClickable("//*[@text='Requested']");
//		click("//*[@text='Requested']");
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/ll_listitem']");
		click("//*[@resource-id='com.commusoft.v4:id/ll_listitem']");//com.commusoft.v4:id/ll_listitem
	}
	
	public void Click_FulfilPart() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Fulfil part']");
		click("//*[@text='Fulfil part']");
	}
//	Click_Save
	public void Type_SupplierName() 
	{
		TwoSec();
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/suppliernameValue']");
		click("//*[@resource-id='com.commusoft.v4:id/suppliernameValue']");
	}
	public void Select_Supplier() //com.commusoft.v4:id/listviews
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='com.commusoft.v4:id/listviews'])[1]");
		click("(//*[@resource-id='com.commusoft.v4:id/listviews'])[1]");
	}
	public void Click_Part_In_PurchaseOrderScreen(String partname) 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+partname+"']");
		click("//*[@text='"+partname+"']");
	}
	
	public void Select_NominalCode() //Tap To Select. . .
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Tap To Select. . .']");
		click("//*[@text='Tap To Select. . .']");//android:id/text1
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
	}
//	Click_Save
//	Click_Save
	public void Verify_OnOrder_Status(String partname) 
	{
//		ExplicitWait_PresenceOfEle("//*[@text='"+partname+"']/following-sibling::*[@text='On Order']");
//		MobileElement OnOrderStatus = driver.findElement(By.xpath("//*[@text='"+partname+"']/following-sibling::*[@text='On Order']"));
		ExplicitWait_PresenceOfEle("//*[@text='On Order']");
		MobileElement OnOrderStatus = driver.findElement(By.xpath("//*[@text='On Order']"));
		Verify_AssertTrue(OnOrderStatus);
	}
	public void DueOutPart(String partname) throws InterruptedException 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Due in']");
		ScrollDown24LastText(partname);
		ExplicitWait_ElementToBeClickable("(//*[@text='"+partname+"'])[last()]");
		click("(//*[@text='"+partname+"'])[last()]");
		
		
//		ExplicitWait_PresenceOfEle("//*[@text='Due in']");
//		ScrollDown24("(//*[@text='NewPart3012'])[last()]");
//		ExplicitWait_ElementToBeClickable("(//*[@text='NewPart3012'])[last()]");
//		click("(//*[@text='NewPart3012'])[last()]");
		
	}//NewPart3012
	
	public void WaitForCheckPartsInScreen(String partname) 
	{
		ExplicitWait_PresenceOfEle("//*[@text='"+partname+"']");
	}
	public void CheckInPart() //Check in
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Check in']");
		click("//*[@text='Check in']");
	}
	public void Verify_CheckInPart() //Marking as available�
	{
		ExplicitWait_PresenceOfEle("//*[@text='Marking as available�']");
		MobileElement CheckInStatus = driver.findElement(By.xpath("//*[@text='Marking as available�']"));
		Verify_AssertTrue(CheckInStatus);
		System.out.println("Status Text Is: "+CheckInStatus.getText());
		click("//*[@text='Close']");
	}
	public void Verify_AvailableStatus() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Available']");
		MobileElement AvailableStatus = driver.findElement(By.xpath("//*[@text='Available']"));
		Verify_AssertTrue(AvailableStatus);
	}
	//---------------------------------------------
	public void NewUI_Search() 
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Search']");
		click("//*[@content-desc='Search']");
	}
	public void Search_CustomerNumber(String passcustomernumber) 
	{
		ExplicitWait_PresenceOfEle("//*[@class='android.view.View']");
		type("//*[@class='android.view.View']", passcustomernumber);
		TwoSec();
		click("//*[@class='android.widget.ImageView']");
	}
	
	public void Select_Customer() 
	{
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Mr &')]");
		click("//*[contains(@text,'Mr &')]");
	}
//	add_Notes.Click_Choc_MenuButton();
//	customer.Customer_Ongoing();
//	customer.Customer_PlusBtn();
//	job.Add_New_Job();
//	job.Click_Des();
//	job.Job_Des();
//	job.Click_Tick();
//	pre_Invoice.Click_FirstJob();
	
	public void Time() 
	{
//		String time = driver.getDeviceTime();
//		System.out.println("Current Time Is: "+time);
		
//		Date newDate  = new Date(System.currentTimeMillis());
//
//		String date = newDate.toString();
//		System.out.println("Current Time Is: "+date);
		
		SimpleDateFormat format= new SimpleDateFormat("HH:mm",Locale.getDefault());

		String myDate = format.format(new Date());
		System.out.println("Current Time Is: "+myDate);

	}
	
	
	public void V4AppSwitchDemo() 
	{
		ThreeSec();
		
		switchToApp(driver, "warehouse.commusoft.com.commusoftwarehouse");
		
	}
	//--------------------------------------------------------------------------------------
	
	private static void switchToApp(AndroidDriver<MobileElement> driver, String appPackage) {
        // Get the current app package and activity
        String currentPackage = driver.getCurrentPackage();
        String currentActivity = driver.currentActivity();
        System.out.println("Current package: "+currentPackage);
        System.out.println("Current Activity: "+currentActivity);
        // Use adb commands to start the new app
        String command = "adb shell am start -n " + appPackage + "/.MainActivity";
        driver.executeScript("mobile: shell", "command", command);

        
        // Wait for the new app to launch
        // You may need to adjust the wait time based on your app's launch time
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Switch back to the original app after performing actions in the second app
        switchToApp(driver, currentPackage, currentActivity);
    }

    private static void switchToApp(AppiumDriver  driver, String appPackage, String appActivity) {
        // Use adb commands to start the original app
        String command = "adb shell am start -n " + appPackage + "/" + appActivity;
        driver.executeScript("mobile: shell", "command", command);

        // Wait for the original app to come to the foreground
        // You may need to adjust the wait time based on your app's launch time
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	
}
