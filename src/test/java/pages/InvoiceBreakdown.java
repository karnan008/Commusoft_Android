package Pages;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InvoiceBreakdown extends Wrapper{
	
	public InvoiceBreakdown(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void Click_InvoiceBreakdown_Dropdown() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinner_invoicebreakdown']");
		click("//*[@resource-id='com.commusoft.v4:id/spinner_invoicebreakdown']");
	}
	
	public void Select_BreakdownByCategory() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Breakdown by Category']");
		click("//*[@text='Breakdown by Category']");
	}
	public void Select_FullBreakdown() //Full Breakdown
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Full Breakdown']");
		click("//*[@text='Full Breakdown']");
	}
	
	public void Type_BreakdownDes() //com.commusoft.v4:id/itemdescriptionValue
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/itemdescriptionValue']");
		type("//*[@resource-id='com.commusoft.v4:id/itemdescriptionValue']", "BreakdownDes");
	}
	public void Type_BreakdownQuantity() //com.commusoft.v4:id/quantityValue
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/quantityValue']");
		type("//*[@resource-id='com.commusoft.v4:id/quantityValue']", "1");
	}
	public void Click_FabIcon_InInvoiceScreen() //com.commusoft.v4:id/add
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/add']");
		click("//*[@resource-id='com.commusoft.v4:id/add']");
	}
	public void Type_UnitPrice() //com.commusoft.v4:id/UnitpriceValue
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/UnitpriceValue']");
		type("//*[@resource-id='com.commusoft.v4:id/UnitpriceValue']", "20");
	}
	
	public void Click_CategoryDropdown() //com.commusoft.v4:id/spinnerCategoryView
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerCategoryView']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerCategoryView']");
	}
	public void Select_Parts() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Parts']");
		click("//*[@text='Parts']");
	}
	public void Type_Total(String total) 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/UnitpriceValue']");
		type("//*[@resource-id='com.commusoft.v4:id/UnitpriceValue']", total);
	}
	
//	estimate.Savebtn();
	
//	job.Invoice_Saves();
	
//	pre_Invoice.Click_Exit();
	
	public void Select_FullBreakdownByCategory() //Full Breakdown by Category
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Full Breakdown by Category']");
		click("//*[@text='Full Breakdown by Category']");
	}
	
	public void Click_SearchButton() //com.commusoft.v4:id/searchpricingitemButtonView
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/searchpricingitemButtonView']");
		click("//*[@resource-id='com.commusoft.v4:id/searchpricingitemButtonView']");
	}
	public void Click_Searchforpricingitem() //Search for pricing item
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Search for pricing item']");
		click("//*[@text='Search for pricing item']");
	}
	public void Select_PricingItem() //com.commusoft.v4:id/partdescriptionView
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='com.commusoft.v4:id/partdescriptionView'])[1]");
		click("(//*[@resource-id='com.commusoft.v4:id/partdescriptionView'])[1]");
	}
	

}
