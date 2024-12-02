package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import MainPack.Wrapper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.android.AndroidDriver;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class AddCustomer_NewUI extends Wrapper{
	
	public AddCustomer_NewUI(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}

	
	public void SearchTab() 
	{
        ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/nav_search']");
        click("//*[@resource-id='com.commusoft.v4:id/nav_search']");
	}
	
	public void Click_FabIcon() 
	{
	   ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Button']");
	   click("//*[@class='android.widget.Button']");
	}
	public void Click_AddProperty() 
	{
		FiveSec();
		ExplicitWait_ElementToBeClickable("//*[@text='Add Property']/following-sibling::*[@class='android.view.View'][1]");
		click("//*[@text='Add Property']/following-sibling::*[@class='android.view.View'][1]");
	}
	public void Click_PropertyDropdown() //com.commusoft.v4:id/propertyspinner
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/propertyspinner']");
		click("//*[@resource-id='com.commusoft.v4:id/propertyspinner']");
	}
	public void Select_Customer() //Customer
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Customer']");
		click("//*[@text='Customer']");
	}
	public void Click_CustomerDropdown() //com.commusoft.v4:id/customertypespinnerView
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/customertypespinnerView']");
		click("//*[@resource-id='com.commusoft.v4:id/customertypespinnerView']");
	}
	public void Select_PrivateCustomer() //Private Customer
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
//	Click_NavigateUp_BackButton();
//	Click_MenuClosed_BackButton();
	public void HomeTab() //Home
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Home']");
		click("//*[@text='Home']");
	}
//	-----------------------------------------------------------------------------------------------
	
//	EDIT CUSTOMER
	

	public void Click_AccountNumber() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Account No']");
		click("//*[@text='Account No']");
	}
	
	public void Type_Search() 
	{
		ThreeSec();
		click("(//*[@class='android.view.View'])[1]");
		ThreeSec();
		driver.findElement(By.xpath("(//*[@class='android.view.View'])[1]")).clear();
		ThreeSec();
		type("(//*[@class='android.view.View'])[1]", "2133");
		
	}
	
	public void Demo() 
	{
		ThreeSec();
		
//		click("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.widget.Button");
        
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		MobileElement disabledElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText/android.view.View/android.view.View"));
//		jsExecutor.executeScript("arguments[0].removeAttribute('disabled');", disabledElement);
//		disabledElement.click();
//		disabledElement.sendKeys("2133");
		
//		MobileElement search= driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().class(\"android.view.View\")"));
		MobileElement Search = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText/android.view.View/android.view.View"));//3,4,5,6,7
//		search1.sendKeys("2666");
//		search1.click();
		
		ThreeSec();
		Search.clear();
		ThreeSec();
		Search.click();
		ThreeSec();
		Search.sendKeys("2666");
		
		
//		TouchAction touchAction = new TouchAction(driver);
//
//		// Create LongPressOptions with the desired duration and the target element
//		LongPressOptions longPressOptions = LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(Search));
//
//		// Perform the long press action
//		touchAction.longPress(longPressOptions).release().perform();
		
	}
	
}
