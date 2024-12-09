package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Job extends Wrapper{

	public Job (AndroidDriver<MobileElement> ldriver)
	{
		this.driver = ldriver;
	}
	public void Add_New_Job() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Add new job']");
		click("//android.widget.TextView[@text='Add new job']");
		//		Thread.sleep(2000);
	}
	public void Click_Des() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerdescriptionValue']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerdescriptionValue']");
		//		Thread.sleep(2000);
	}
	public void Job_Des() throws InterruptedException
	{

		//		ScrollToText(name);
		//		ExplicitWait_ElementToBeClickable("//*[@text='"+name+"']");
		//		click("//*[@text='"+name+"']");
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");

		//		Thread.sleep(2000);
	}
	public void Book_Diary_Job() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/bookdiaryeventView']");
		click("//*[@resource-id='com.commusoft.v4:id/bookdiaryeventView']");
		Thread.sleep(2000);
	}

	public void Click_Tick() throws InterruptedException 
	{
		TwoSec();
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Save']");
		click("//*[@content-desc='Save']");
		Thread.sleep(2000);
	}
	public void Job_Status() throws InterruptedException
	{
		Thread.sleep(3000);
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/diary_status_text']");
		if((driver.findElement(By.id("com.commusoft.v4:id/diary_status_text"))).isDisplayed())
		{
			System.out.println("Job in Left status");
			Thread.sleep(1000);
		}

	}
	public void Job_StatusFromDiary() throws InterruptedException 
	{

		Thread.sleep(3000);
		if((driver.findElement(By.id("com.commusoft.v4:id/leavestatuslayout"))).isDisplayed())
		{
			System.out.println("Job in Left status");
			Thread.sleep(1000);
		}


	}
	public void Payment_Save() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Save']");
		click("//*[@text='Save']");
	}
	public void Sign_save() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
		click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
		//		Thread.sleep(2000);
	}
	public void Job_Leave() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/statusButton1']");
		click("//*[@resource-id='com.commusoft.v4:id/statusButton1']");
		Thread.sleep(2000);
	}

	public void FillInJobReport() 
	{
		TwoSec();
		try 
		{
			if(driver.findElement(By.xpath("//*[@text='Fill in job report']")).isDisplayed())

				ExplicitWait_PresenceOfEle("//*[@text='Fill in job report']");//Fill in job report
			click("//*[@text='Fill in job report']");
		}catch(Exception e) 
		{
			System.out.println("Fill in job report is not displayed");
		}



	}

	public void Job_LeaveFromDiary() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Leave']");
		click("//*[@text='Leave']");
	}
	public void Arrive_Question1(String arriveanswer) 
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.EditText'])[1]");
		type("(//*[@class='android.widget.EditText'])[1]", arriveanswer);


		arrive_Answer = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]")).getText();
		System.setProperty("arrive_Answer", arrive_Answer);
		System.out.println("Arrive answer: "+arrive_Answer);

	}
	public void Arrive_Question() throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/simple_answer']");
		type("//*[@resource-id='com.commusoft.v4:id/simple_answer']", "Answers");
		//		Thread.sleep(2000);
	}
	public void Job_Report() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/filljobreporttext']");
		click("//*[@resource-id='com.commusoft.v4:id/filljobreporttext']");
		//		Thread.sleep(2000);
	}
	public void Leave_Question() throws InterruptedException
	{                              
		ExplicitWait_PresenceOfEle("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
		type("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText", "Answers for Leave Questions");

	}

	public void LeaveQuestion2(String leaveanswer) 
	{

		try 
		{


			ExplicitWait_PresenceOfEle("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
			type("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText", leaveanswer);

			leave_Answer = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")).getText();
			System.setProperty("leave_Answer", leave_Answer);
			System.out.println("Leave answer: "+leave_Answer);
		}catch(Exception e)

		{

			ExplicitWait_PresenceOfEle("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]");
			type("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]", leaveanswer);

			leave_Answer = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]")).getText();
			System.setProperty("leave_Answer", leave_Answer);
			System.out.println("Leave answer: "+leave_Answer);
		}
	}
	public void Complete_Continue() throws InterruptedException
	{
		OneSec();                                     
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/isjobcompletedbox']");
		click("//*[@resource-id='com.commusoft.v4:id/isjobcompletedbox']");//com.commusoft.v4:id/isjobcompletedbox
		OneSec();
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/continueView']");
		click("//*[@resource-id='com.commusoft.v4:id/continueView']");

	}

	public void No_Complete() 
	{
		ThreeSec();                                     
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/isjobnotcompletedbox']");
		click("//*[@resource-id='com.commusoft.v4:id/isjobnotcompletedbox']");//com.commusoft.v4:id/isjobcompletedbox
		ThreeSec();
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/continueView']");
		click("//*[@resource-id='com.commusoft.v4:id/continueView']");
	}

	public void Final_Invoice() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Raise final invoice']");
		click("//android.widget.TextView[@text='Raise final invoice']");
		//		Thread.sleep(5000);
	}
	public void Invoice_Description() throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
		type("//*[@resource-id='com.commusoft.v4:id/descriptionValue']", "Invoice Description");//com.commusoft.v4:id/descriptionValue
		//		Thread.sleep(2000);
	}
	public void Invoice_Category() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicecategoryValue']");
		click("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicecategoryValue']");
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
		//		Thread.sleep(2000);
	}
	public void Invoice_Next() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Next']");
		click("//android.widget.TextView[@text='Next']");
		//		Thread.sleep(2000);
	}
	public void Breakdown_Value(String value) throws InterruptedException
	{
		ThreeSec();
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/subtotalValue']");
		type("//*[@resource-id='com.commusoft.v4:id/subtotalValue']", value);

	}


	public void Invoice_Saves() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Save']");
		click("//android.widget.TextView[@text='Save']");
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Save invoice']");
		click("//android.widget.TextView[@text='Save invoice']");
		//		Thread.sleep(2000);
	}
	public void Payment() throws InterruptedException
	{
		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Add payment']");
		click("//android.widget.TextView[@text='Add payment']");
		//		Thread.sleep(4000);
	}

	public void SelectOtherOptionAndMethod_Value() throws InterruptedException
	{
		//		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnermethodValue']");
		//		click("//*[@resource-id='com.commusoft.v4:id/spinnermethodValue']");
		//		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Cash']");
		//		
		//		click("//android.widget.TextView[@text='Cash']");
		//		Thread.sleep(2000);


		ExplicitWait_ElementToBeClickable("//*[@text='Other']"); 
		click("//*[@text='Other']");

		ExplicitWait_ElementToBeClickable("(//*[@content-desc='Trailing icon'])[2]");
		click("(//*[@content-desc='Trailing icon'])[2]");

		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Cash']");
		click("//android.widget.TextView[@text='Cash']");
	}
	public void Nominal_Value() throws InterruptedException
	{
		//		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnernominalaccountvalue']");
		//		click("//*[@resource-id='com.commusoft.v4:id/spinnernominalaccountvalue']");
		//		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Cash']");
		//		click("//android.widget.TextView[@text='Cash']");
		//		Thread.sleep(2000);
		Thread.sleep(1000);
		ExplicitWait_ElementToBeClickable("(//*[@content-desc='Trailing icon'])[3]"); 
		click("(//*[@content-desc='Trailing icon'])[3]");

		ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Cash']");
		click("//android.widget.TextView[@text='Cash']");
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

	public void Store_JobNumber() 
	{

		jobnumber = driver.findElement(By.xpath("//*[@text='Job Number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']")).getText();
		System.out.println("Job Number Is: "+jobnumber);

	}

	public void Search_JobNumber() 
	{


		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");

		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", jobnumber);
		TwoSec();


	}

	public void Click_Job(String sur) 
	{
		TwoSec();
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/descriptionValue']/following-sibling::*[@text='"+sur+"']");
		click("//*[@resource-id='com.commusoft.v4:id/descriptionValue']/following-sibling::*[@text='"+sur+"']");
	}
	public void PassJobNumber(String jobnum) 
	{



		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/search_src_text']");

		type("//*[@resource-id='com.commusoft.v4:id/search_src_text']", jobnum);
		TwoSec();



	}
	public void Click_Next() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Next']");
		click("//*[@text='Next']");
	}

	public void Click_Finish() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Finish']");
		click("//*[@text='Finish']");
	}

	public void ExceptionHandling_For_DataNotLoad_InInvoiceScreen() throws InterruptedException 
	{
		TwoSec();
		ExplicitWait_ElementToBeClickable("//*[contains(@text,'Sub total')]");
		try 
		{
			if(driver.findElement(By.xpath("//*[contains(@text,'Sub total')]")).isDisplayed()) 
			{
				System.out.println("Data is visible in invoice screen");
			}
		}catch(Exception e) //Back
		{
			ExplicitWait_ElementToBeClickable("//*[@text='Back']");
			click("//*[@text='Back']");
			ExplicitWait_ElementToBeClickable("//*[@text='Back']");
			click("//*[@text='Back']");//YES
			ExplicitWait_ElementToBeClickable("//*[@text='YES']");
			click("//*[@text='YES']");
			ExplicitWait_ElementToBeClickable("//*[contains(@resource-id,'com.commusoft.v4:id')]");
			click("//*[contains(@resource-id,'com.commusoft.v4:id')]");
			ExplicitWait_ElementToBeClickable("//*[@text='Raise final invoice']");
			click("//*[@text='Raise final invoice']");//Raise final invoice
			ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/descriptionValue']");
			type("//*[@resource-id='com.commusoft.v4:id/descriptionValue']", "Invoice Description");
			ScrollDown24("Invoice category�*");
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicecategoryValue']");
			click("//*[@resource-id='com.commusoft.v4:id/spinnerinvoicecategoryValue']");
			ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
			click("(//*[@resource-id='android:id/text1'])[2]");
			ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Next']");
			click("//android.widget.TextView[@text='Next']");
		}
	}


	public void DoNothing() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Do nothing']");
		click("//*[@text='Do nothing']");
	}

	public void FreeOfCharge() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Free of charge job']");
		click("//*[@text='Free of charge job']");
	}

	public void FreeOfCharge_Reason() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Spinner']");
		click("//*[@class='android.widget.Spinner']");
		ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
	}
	public void DiaryHistory() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
		click("//*[@text='Diary history']");
	}
	public void SelectDiaryHistory() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Left']");
		click("//*[@text='Left']");
	}

	public void Verify_ArriveQuestions(String arriveanswer) throws InterruptedException 
	{
		TwoSec();
		ScrollDown24(arriveanswer);
		//		ExplicitWait_ElementToBeClickable("//*[@text='VIEW ARRIVE QUESTIONS']");
		//		click("//*[@text='VIEW ARRIVE QUESTIONS']");
		ExplicitWait_PresenceOfEle("//*[@text='Arrive questions']");
		System.getProperty("arrive_Answer", arrive_Answer);
		Assert.assertEquals(arrive_Answer,arriveanswer );
	}

	public void Close() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Close']");
		click("//*[@text='Close']");
	}
	public void ViewDiaryHistory_Back() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.ImageView'])[5]");
		click("(//*[@class='android.widget.ImageView'])[5]");
	}

	public void DiaryHistoryBack() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.ImageView'])");
		click("(//*[@class='android.widget.ImageView'])");
	}

	public void Verify_LeaveQuestions(String leaveanswer) throws InterruptedException 
	{
		TwoSec();
		ScrollDown24(leaveanswer);
		//		ExplicitWait_ElementToBeClickable("//*[@text='VIEW LEAVE QUESTIONS']");
		//		click("//*[@text='VIEW LEAVE QUESTIONS']");
		ExplicitWait_PresenceOfEle("//*[@text='Leave questions']");
		System.getProperty("leave_Answer", leave_Answer);
		Assert.assertEquals(leave_Answer, leaveanswer );
	}
	//	Close
	public void CloseDiaryHistory() 
	{
		ExplicitWait_ElementToBeClickable("//*[@content-desc='Cancel']");
		click("//*[@content-desc='Cancel']");
	}
	
	
//	
}
