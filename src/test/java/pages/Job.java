package pages;

import org.openqa.selenium.By;

import action.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Job extends Wrapper{
	
	public Job (AndroidDriver<MobileElement> ldriver)
	{
		this.driver = ldriver;
	}
	public void Add_New_Job() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Add new job']");
		Thread.sleep(2000);
	}
	public void Click_Des() throws InterruptedException
	{
		Thread.sleep(3000);
		click("#com.commusoft.v4:id/spinnerdescriptionValue");
		Thread.sleep(2000);
	}
	public void Job_Des(String name) throws InterruptedException
	{
		click("//android.widget.TextView[@text='"+name+"']");
		Thread.sleep(2000);
	}
	public void Book_Diary_Job() throws InterruptedException
	{
		click("#com.commusoft.v4:id/bookdiaryeventView");
		Thread.sleep(2000);
	}
	public void Job_Final_Diary() throws InterruptedException
	{
		if((driver.findElement(By.id("com.commusoft.v4:id/diary_status_text"))).isDisplayed())
		{
			System.out.println("Job in Left status");
			Thread.sleep(1000);
		}
		click("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		Thread.sleep(3000);
	}
	public void Sign_save() throws InterruptedException
	{
		click("#com.commusoft.v4:id/save");
		Thread.sleep(2000);
	}
	public void Job_Leave() throws InterruptedException
	{
		click("#com.commusoft.v4:id/statusButton1");
		Thread.sleep(2000);
	}
	public void Arrive_Question() throws InterruptedException
	{
		Thread.sleep(3000);
		type("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText", "Answers");
		Thread.sleep(2000);
	}
	public void Job_Report() throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/filljobreporttext");
		Thread.sleep(2000);
	}
	public void Leave_Question() throws InterruptedException
	{
		Thread.sleep(2000);
		type("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText", "Answers for Leave Questions");
		Thread.sleep(2000);
	}
	public void Complete_Continue() throws InterruptedException
	{
		click("#com.commusoft.v4:id/isjobcompletedbox");
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/continueView");
		Thread.sleep(2000);
	}
	public void Final_Invoice() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Raise final invoice']");
		Thread.sleep(5000);
	}
	public void Invoice_Description() throws InterruptedException
	{
		Thread.sleep(3000);
		type("#com.commusoft.v4:id/descriptionValue", "Invoice Descrption");
		Thread.sleep(2000);
	}
	public void Invoice_Category() throws InterruptedException
	{
		click("#com.commusoft.v4:id/spinnerinvoicecategoryValue");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Invoice category1']");
		Thread.sleep(2000);
	}
	public void Invoice_Next() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Next']");
		Thread.sleep(2000);
	}
	public void Breakdown_Value(String value) throws InterruptedException
	{
		type("#com.commusoft.v4:id/subtotalValue", value);
		Thread.sleep(2000);
	}
	public void Invoice_Saves() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Save']");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Save invoice']");
		Thread.sleep(2000);
	}
	public void Payment() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Add payment']");
		Thread.sleep(4000);
	}
	public void Method_Value() throws InterruptedException
	{
		Thread.sleep(3000);
		click("#com.commusoft.v4:id/spinnermethodValue");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Cash']");
		Thread.sleep(2000);
	}
	public void Nominal_Value() throws InterruptedException
	{
		click("#com.commusoft.v4:id/spinnernominalaccountvalue");
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Cash']");
		Thread.sleep(2000);
	}
	public void Parts_Nominal_Value() throws InterruptedException
	{
		click("#com.commusoft.v4:id/spinnerNominalcodeView");
		Thread.sleep(3000);
		click("//android.widget.TextView[@text='Cash']");
		Thread.sleep(2000);
	}
	public void FOC() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Free of charge job']");
		Thread.sleep(2000);
	}
	public void FOC_Reason() throws InterruptedException
	{
		Thread.sleep(5000);
		click("#com.commusoft.v4:id/reasonspinner");
		Thread.sleep(10000);
		click("//android.widget.TextView[@text='Admin error']");
		Thread.sleep(2000);
	}
	public void FOC_Comment() throws InterruptedException
	{
		type("#com.commusoft.v4:id/moredetails", "FOC Reason");
		Thread.sleep(2000);
	}
	public void Click_1st_Job() throws InterruptedException
	{
		Thread.sleep(2000);
		click("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]");
		Thread.sleep(2000);
	}
	public void Ongoing_Job_Complete() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Complete job']");
		Thread.sleep(2000);
	}
	public void Parts_tab() throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='Parts']");
		Thread.sleep(2000);
	}
	public void Parts_Offline_Check() throws InterruptedException
	{
		
		String Online = "No records to display yet";
		String Offline ="Jobparts can't be managed while offline jobs. Need to sync job before access jobpart screens";
		Customer customer = new Customer(driver);
		Job job = new Job(driver);
		Thread.sleep(6000);
		String Off = gettext("#com.commusoft.v4:id/resultsmessage_view");
		Thread.sleep(3000);
		if(Off.matches(Offline))
		{
			customer.Wholeback3();
			customer.Menu_Close();
		}else
		{
			Thread.sleep(2000);
			customer.WA_Add();
			Thread.sleep(10000);
			type("#com.commusoft.v4:id/searchText", "P1");
			Thread.sleep(3000);
			dclick("#com.commusoft.v4:id/increase");
			Thread.sleep(3000);
			Savebtn();
			Savebtn();
			
			click("//android.widget.TextView[@text='Requested']");
			Thread.sleep(3000);
			click("//android.widget.TextView[@text='Fulfil part']");
			Thread.sleep(5000);
			Savebtn();
			click("#com.commusoft.v4:id/suppliernameValue");
			Thread.sleep(4000);
			click("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]");
			Thread.sleep(6000);
			click("#com.commusoft.v4:id/editIconView");
			Thread.sleep(14000);
			job.Parts_Nominal_Value();
			
			click("#com.commusoft.v4:id/spinnershippingDateIcon");
			Thread.sleep(2000);
			click("//android.widget.Button[@text='DONE']");
			Thread.sleep(2000);
			
			click("#com.commusoft.v4:id/spinnerShippingmethodView");
			Thread.sleep(4000);
			click("\\android.widget.TextView[@text='Delivery to office']");
			Thread.sleep(6000);
			Savebtn();
			Savebtn();
			Thread.sleep(6000);
			
			
			String u = "//android.widget.TextView[@text='On Order']";
			
			isdisplayed(u);
			customer.Wholeback3();
			customer.Menu_Close();
		}
	}

}
