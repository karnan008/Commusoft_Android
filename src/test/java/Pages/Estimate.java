package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Estimate extends Wrapper {
	
	public Estimate(AndroidDriver<MobileElement> ldriver) 
	{
		this.driver = ldriver;
	}
	public void Add_Estimate() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Add new estimate']");
		click("//android.widget.TextView[@text='Add new estimate']");//add new estimate
	}
	public void Estimate_Description() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/templatespinnerView']");
		click("//*[@resource-id='com.commusoft.v4:id/templatespinnerView']");//estimate description  com.commusoft.v4:id/templatespinnerView
	}
	public void Estimate_Description_Template(String Des) throws InterruptedException
	{
		Thread.sleep(2000);
		click("//android.widget.TextView[@text='"+Des+"']");
		
	
		
	}
	
    public void Select_Estimate_Template() 
    {
    	ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
    }
	public void Today() throws InterruptedException
	{
		Thread.sleep(2000);
		click("#com.commusoft.v4:id/action_today");
		Thread.sleep(2000);
	}
	public void Book_Diary()
	{
		ExplicitWait_PresenceOfEle("//android.widget.CheckBox[@text='Book into diary after adding estimate']");
		click("//android.widget.CheckBox[@text='Book into diary after adding estimate']");//click book diary
	}
	public void Estimate_Save() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Save'] ");
		click("//*[@content-desc='Save'] ");//#com.commusoft.v4:id/save
		
	}
	public void Book_Event(int SX1,int SY1,int SX2,int SY2,int DCX1,int DCY1 ) throws InterruptedException
	{
		Thread.sleep(2000);
//		click("//*[@text='Book event']");
		
		
		try 
		{
			if(driver.findElement(By.xpath("//*[@text='Book event']")).isDisplayed())
				click("//*[@text='Book event']");
			
		}catch(Exception e) 
		{
			Thread.sleep(2000);
			click("//*[@content-desc='Navigate up']");
//			Thread.sleep(2000);
//			click("//*[@content-desc='Navigate up']");
			Thread.sleep(2000);
//			scrolltotheright(SX1, SY1, SX2, SY2);//1019, 849, 79, 856
			Thread.sleep(3000);
			doubleclickpoint(DCX1,DCY1);//450,880
			Thread.sleep(2000);
			click("//*[@text='Book event']");
		}
		
//		if(driver.findElement(By.xpath("//*[@text='Book event']")).isDisplayed()) 
//		{
//			click("//*[@text='Book event']");
//		}else 
//		{
//			Thread.sleep(2000);
//			click("//*[@content-desc='Navigate up']");
//			Thread.sleep(2000);
//			scrolltotheright(SX1, SY1, SX2, SY2);//1019, 849, 79, 856
//			Thread.sleep(3000);
//			doubleclickpoint(DCX1,DCY1);//450,880
//			Thread.sleep(2000);
//			click("//*[@text='Book event']");
//			
//		}
//		
//		try 
//		{
//			try 
//			{
//				if(driver.findElement(By.xpath("//*[@text='Book event']")).isDisplayed()) 
//					click("//*[@text='Book event']");
//				
//			}catch(Exception e1) 
//			{
//				Thread.sleep(2000);
//				click("//*[@content-desc='Navigate up']");
//				Thread.sleep(2000);
//				scrolltotheright(SX1, SY1, SX2, SY2);//1019, 849, 79, 856
//				Thread.sleep(3000);
//				doubleclickpoint(DCX1,DCY1);//450,880
//				Thread.sleep(2000);
//				click("//*[@text='Book event']");
//			}
//			
//		}catch(Exception e) 
//		{
//			
//		}
		
//		MobileElement ele=driver.findElement(By.xpath("//*[@text='Book event']"));
//		
//		try 
//		{
//			if(isElementDisplayed(ele))
//			{
//				click("//*[@text='Book event']");
//			}else 
//			{
//				Thread.sleep(2000);
//				click("//*[@content-desc='Navigate up']");
//				Thread.sleep(2000);
//				scrolltotheright(SX1, SY1, SX2, SY2);//1019, 849, 79, 856
//				Thread.sleep(3000);
//				doubleclickpoint(DCX1,DCY1);//450,880
//				Thread.sleep(2000);
//				click("//*[@text='Book event']");
//			}
//			
//		}catch(Exception e) 
//		{
//			System.out.println("Exception error");
//		}
		
	}
	
	public void Click_EngineerDropdown() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/engineerNameSpinner']");
		click("//*[@resource-id='com.commusoft.v4:id/engineerNameSpinner']");

	}
	public void Select_Engineer(String username) 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+username+"']");
		click("//*[@text='"+username+"']");
	}
	
	public boolean isElementDisplayed(MobileElement ele) {
	    boolean elementDisplayed = false;

	    try {
	        ele.isDisplayed();
	        elementDisplayed = true;
	    } catch(Exception e) {
	        elementDisplayed = false;
	    }

	    return elementDisplayed;

	}
	
	public void Savebtn() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Save'] "); //android.widget.TextView[@text='Save']
		click("//*[@content-desc='Save'] ");
		
	}
	public void Diary_FillinEstimate() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Fill in estimate']");
		click("//android.widget.TextView[@text='Fill in estimate']");//click fill in estimate
//		Thread.sleep(2000);
	}
	public void FillinEstimate_Price() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Price']");
		click("//android.widget.TextView[@text='Price']");
//		Thread.sleep(2000);
	}
	public void Price_NoBreakdown() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinner_pricingbreakdown']");
		click("//*[@resource-id='com.commusoft.v4:id/spinner_pricingbreakdown']");
		
	}
	public void Price_NoBreakdownselect(String breakdown) throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.CheckedTextView[@text='"+breakdown+"']");
		click("//android.widget.CheckedTextView[@text='"+breakdown+"']");
//		Thread.sleep(2000);
	}
	public void Breakdown_value() throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id=com.commusoft.v4:id/totalValue']");
		type("//*[@resource-id=com.commusoft.v4:id/totalValue']", "100");
//		Thread.sleep(2000);
	}
	public void Breakdown_value(String value) throws InterruptedException
	{
		type("#com.commusoft.v4:id/totalValue", value);
//		Thread.sleep(2000);
	}
	public void save() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Save'] ");
		click("//*[@content-desc='Save'] ");
//		Thread.sleep(2000);
	}
	public void Invoice_Schedule() throws InterruptedException
	{
		TwoSec();
		ExplicitWait_ElementToBeClickable("//*[@text='Invoice Schedule']");
		click("//*[@text='Invoice Schedule']");
//		Thread.sleep(2000);
	}
	public void AcceptReject() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Accept/Reject']");
		click("//android.widget.TextView[@text='Accept/Reject']");
		
	}
	public void Estimate_Checkbox() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/estimateOptionCheckboxView']");
		click("//*[@resource-id='com.commusoft.v4:id/estimateOptionCheckboxView']");
		
	}
	public void Estimate_Accept() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='ACCEPT']");
		click("//*[@text='ACCEPT']");
		
	}
	public void Estimate_PriceReject() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='REJECT']");
		click("//*[@text='REJECT']");
	}
	public void Reject_Reasons() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='android:id/text1']");
		click("//*[@resource-id='android:id/text1']");
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
		ExplicitWait_ElementToBeClickable("//*[@text='REJECT']");
		click("//*[@text='REJECT']");
	}
	
	public void Estimate_AcceptORReject(String status) throws InterruptedException
	{
		click("//android.widget.TextView[@text='"+status+"']");
//		Thread.sleep(2000);
	}
	public void Estimate_Reject() throws InterruptedException
	{
		click("//*[@text='REJECT']");
//		Thread.sleep(2000);
	}
	public void YES() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='YES']");
		click("//*[@text='YES']");
		
	}
	public void Estimate_Acceptbtn() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@text='ACCEPT']");
		click("//*[@text='ACCEPT']");
//		Thread.sleep(4000);
		
	}
	public void Estimate_Rejectbtn() throws InterruptedException
	{
		click("//android.widget.Button[@text='REJECT']");
//		Thread.sleep(4000);
	}
	public void Estimate_Leave() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/statusButton1']");
		click("//*[@resource-id='com.commusoft.v4:id/statusButton1']");
//		Thread.sleep(2000);
	}
	public void Sign_save() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
		click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");//#com.commusoft.v4:id/save  //*[@id='com.commusoft.v4:id/save']
		
	}
	public void Final_Diary() throws InterruptedException
	{
		if((driver.findElement(By.id("com.commusoft.v4:id/statusView"))).isDisplayed())
		{
			System.out.println("Estimate in Left status");
			Thread.sleep(1000);
		}
		click("//*[@content-desc=\"Navigate up\"]");
		Thread.sleep(3000);
	}
	
	public void Verify_Status() throws InterruptedException 
	{
		TwoSec();
		if(driver.findElement(By.xpath("//*[@text='Left site']")).isDisplayed()) 
		{
			System.out.println("Estimate in Left status");
			Thread.sleep(1000);
		}
		
		
	}
	public void Verify_JobConvertionStatus() 
	{
		TwoSec();
		MobileElement Jobstatus = driver.findElement(By.xpath("//*[contains(@text,'This estimate is converted to job')]"));
		Verify_AssertTrue(Jobstatus);
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
