package MobAndWeb_Page;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import MainPack.WrapperForWeb;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Invoice extends Wrapper{
	
	public Invoice(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void InvoiceType() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicetypeValue']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicetypeValue']");
	}
	
	public void Select_PrefinalInvoice() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Pre-final invoice']");
		click("//*[@text='Pre-final invoice']");
	}
	
	public void Verify_Prefinal() //*[@text='Prefinal']
	{
		
		ExplicitWait_VisibilityOfEle("//*[@text='Prefinal']");
		MobileElement ele = driver.findElement(By.xpath("//*[@text='Prefinal']"));
		Verify_AssertTrue(ele);
	}
	public void Verify_ConvertedFinalInvoice() //*[@text='Prefinal']
	{
		ExplicitWait_PresenceOfEle("//*[@text='Final']");
		MobileElement ele = driver.findElement(By.xpath("//*[@text='Final']"));
		Verify_AssertTrue(ele);
	}
	

}
