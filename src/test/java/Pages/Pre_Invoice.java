package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Pre_Invoice extends Wrapper{
	
	public Pre_Invoice(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}
	
	public void Click_Invoice() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Invoices']");
		click("//*[@text='Invoices']");
	}
	
	public void Click_Invoice_Fabicon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']"); 
		click("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");
	}
	
	public void Type_InvoiceDes(String preinvoice) 
	{

		TwoSec();
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
		type("//*[@resource-id='com.commusoft.v4:id/descriptionValue']", preinvoice);
	
	}
	public void Click_InvoiceCategoryDropdown() //com.commusoft.v4:id/itemdescriptionValue
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicecategoryValue']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicecategoryValue']");
	}
	public void Select_InvoiceCategory() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
	}
//	certificate.Click_Next();
//	job.Breakdown_Value("100");
//	job.Invoice_Saves();
	
	public void Click_Exit() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Exit']");
		click("//*[@text='Exit']");
	}
	
	public void Click_FreeOfChargeJob() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Free of charge job']");
		click("//*[@text='Free of charge job']");
	}
	
	public void Click_JobStatus() //com.commusoft.v4:id/leavestatuslayout  com.commusoft.v4:id/statusmessageView
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/statusmessageView']");
		click("//*[@resource-id='com.commusoft.v4:id/statusmessageView']");
	}
	
	public void Click_RaiseFinalInvoice() //Raise final invoice
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Raise final invoice']");
		click("//*[@text='Raise final invoice']");
	}
	
	public void Click_FirstJob() //com.commusoft.v4:id/typenoValue
	{
		FiveSec();
		ThreeSec();
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='com.commusoft.v4:id/typenoValue'])[1]");
		click("(//*[@resource-id='com.commusoft.v4:id/typenoValue'])[1]");
	}
	
	public void Click_CompleteJob() 
	{
		
		ExplicitWait_ElementToBeClickable("//*[@text='Complete job']");
		click("//*[@text='Complete job']");
	}
	
	public void VerifyPrefinalInvoice() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Prefinal']");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Prefinal']")).isDisplayed());
	}

	public void Click_Final() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Final']");
		click("//*[@text='Final']");
	}
	public void ViewOrEditInvoice() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='View/Edit invoice']");
		click("//*[@text='View/Edit invoice']");
	}
	public void Click_PaymentsTabOnMobile() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='PAYMENTS']");
		click("//*[@text='PAYMENTS']");
	}
	public void Payment_FabIcon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");
		click("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");
	}
	public void Method() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/methodtextview']/following-sibling::*[1]");
		click("//*[@resource-id='com.commusoft.v4:id/methodtextview']/following-sibling::*[1]");
		ExplicitWait_ElementToBeClickable("//*[@resource-id='android:id/text1'][2]");
		click("//*[@resource-id='android:id/text1'][2]");
	}
	
	public void NominalAccount() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/nominaltextview']/following-sibling::*[1]");
		click("//*[@resource-id='com.commusoft.v4:id/nominaltextview']/following-sibling::*[1]");
		ExplicitWait_ElementToBeClickable("//*[@resource-id='android:id/text1'][2]");
		click("//*[@resource-id='android:id/text1'][2]");
	}
//	job2.Sign_save();
	
}
