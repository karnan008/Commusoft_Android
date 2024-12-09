package Pages;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InvoiceType extends Wrapper{
	
	public InvoiceType(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void Click_InvoiceType_Dropdown() //com.commusoft.v4:id/spinnerinvoicetypeValue
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicetypeValue']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicetypeValue']");
	}
	public void Click_Additional() //Additional
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Additional']");
		click("//*[@text='Additional']");
	}
	public void Click_Interim() //interim
	{
		ExplicitWait_ElementToBeClickable("//*[@text='interim']");
		click("//*[@text='interim']");
	}
	public void Click_PrefinalInvoice() //Pre-final invoice
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Pre-final invoice']");
		click("//*[@text='Pre-final invoice']");
	}
	public void Click_Final()//Final 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Final']");
		click("//*[@text='Final']");
	}
	
	

}
