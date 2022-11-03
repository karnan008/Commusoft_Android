package pages;

import org.openqa.selenium.By;

import action.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Estimate extends Wrapper {
	
	public Estimate(AndroidDriver<MobileElement> ldriver) 
	{
		this.driver = ldriver;
	}
	public void Add_Estimate() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Add new estimate']");//add new estimate
	}
	public void Estimate_Description() throws InterruptedException
	{
		Thread.sleep(3000);
		click("#com.commusoft.v4:id/templatespinnerView");//estimate description
	}
	public void Estimate_Description_Template(String Des) throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='"+Des+"']");
	}
	public void Today() throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/action_today");
		Thread.sleep(2000);
	}
	public void Book_Diary()
	{
		click("//android.widget.CheckBox[@text='Book into diary after adding estimate']");//click book diary
	}
	public void Estimate_Save() throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/save");
		Thread.sleep(12000);
	}
	public void Book_Event() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Book event']");
	}
	public void Savebtn() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@content-desc=\"Save\"]");
		Thread.sleep(2000);
	}
	public void Diary_FillinEstimate() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Fill in estimate']");//click fill in estimate
		Thread.sleep(2000);
	}
	public void FillinEstimate_Price() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Price']");
		Thread.sleep(2000);
	}
	public void Price_NoBreakdown() throws InterruptedException
	{
		Thread.sleep(4000);
		click("#com.commusoft.v4:id/spinner_pricingbreakdown");
		Thread.sleep(2000);
	}
	public void Price_NoBreakdownselect(String breakdown) throws InterruptedException
	{
		click("//android.widget.CheckedTextView[@text='"+breakdown+"']");
		Thread.sleep(2000);
	}
	public void Breakdown_value() throws InterruptedException
	{
		type("#com.commusoft.v4:id/totalValue", "100");
		Thread.sleep(2000);
	}
	public void Breakdown_value(String value) throws InterruptedException
	{
		type("#com.commusoft.v4:id/totalValue", value);
		Thread.sleep(2000);
	}
	public void save() throws InterruptedException
	{
		click("//android.widget.TextView[@content-desc=\"Save\"]");
		Thread.sleep(2000);
	}
	public void Invoice_Schedule() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Invoice Schedule']");
		Thread.sleep(2000);
	}
	public void AcceptReject() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Accept/Reject']");
		Thread.sleep(2000);
	}
	public void Estimate_Checkbox() throws InterruptedException
	{
		click("#com.commusoft.v4:id/estimateOptionCheckboxView");
		Thread.sleep(2000);
	}
	public void Estimate_Accept() throws InterruptedException
	{
		click("//android.widget.TextView[@text='ACCEPT']");
		Thread.sleep(2000);
	}
	public void Estimate_AcceptORReject(String status) throws InterruptedException
	{
		click("//android.widget.TextView[@text='"+status+"']");
		Thread.sleep(2000);
	}
	public void Estimate_Reject() throws InterruptedException
	{
		click("//android.widget.TextView[@text='REJECT']");
		Thread.sleep(2000);
	}
	public void YES() throws InterruptedException
	{
		click("//android.widget.Button[@text='YES']");
		Thread.sleep(2000);
	}
	public void Estimate_Acceptbtn() throws InterruptedException
	{
		click("//android.widget.Button[@text='ACCEPT']");
		Thread.sleep(4000);
	}
	public void Estimate_Rejectbtn() throws InterruptedException
	{
		click("//android.widget.Button[@text='REJECT']");
		Thread.sleep(4000);
	}
	public void Estimate_Leave() throws InterruptedException
	{
		click("#com.commusoft.v4:id/statusButton1");
		Thread.sleep(2000);
	}
	public void Sign_save() throws InterruptedException
	{
		click("#com.commusoft.v4:id/save");
		Thread.sleep(2000);
	}
	public void Final_Diary() throws InterruptedException
	{
		if((driver.findElement(By.id("com.commusoft.v4:id/statusView"))).isDisplayed())
		{
			System.out.println("Estimate in Left status");
			Thread.sleep(1000);
		}
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		Thread.sleep(3000);
	}
	public void Reject_Reason_Dropdown() throws InterruptedException
	{
		click("#com.commusoft.v4:id/rejectreasonSpinnerView");
		Thread.sleep(2000);
	}
	public void Reject_Reason() throws InterruptedException
	{
		click("//android.widget.TextView[@text='No longer needed']");
		Thread.sleep(2000);
	}
	public void Reject_Additional_Comments() throws InterruptedException
	{
		type("#com.commusoft.v4:id/rejectadditionalcommentValue", "Reject Reason Comments");
		Thread.sleep(2000);
	}
	public void Ongoing_Estimate() throws InterruptedException
	{
		Thread.sleep(3000);
		click("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]");
		Thread.sleep(2000);
	}
//	public void Ongoing_EstimateNo() throws InterruptedException
//	{
//		String EstimateNo = gettext("#com.commusoft.v4:id/typenoValue");
//		Thread.sleep(3000);
//		click("//android.widget.TextView[@text='"+EstimateNo+"']");
//	}
	
	
	

}
