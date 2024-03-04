package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;

public class Settings extends Wrapper{

	public Settings(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}



	//	Logout();
	//	Owner_Login();
	public void Log_Out() 
	{
		Logout();
	}
	public void OwnerLogin() 
	{
		Owner_Login();
	}

	public void Profile() 
	{
		ExplicitWait_PresenceOfEle2("//img[@id='usrpicofcorner']");
		Webclick("//img[@id='usrpicofcorner']");
	}


	public void Setting() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//img[@id='usrpicofcorner']");
		Webclick("//img[@id='usrpicofcorner']");
		ExplicitWait_PresenceOfEle2("//a[text()='Settings']");
		Webclick("//a[text()='Settings']");
	}
	public void Estimates() 
	{
		ExplicitWait_PresenceOfEle2("(//span[text()='Estimates'])[1]");
		Webclick("(//span[text()='Estimates'])[1]");
	}
	public void Estimate_survey_template() 
	{
		ExplicitWait_PresenceOfEle2("//div[text()=' Estimate survey template ']/following::a[text()='View'][1]");
		Webclick("//div[text()=' Estimate survey template ']/following::a[text()='View'][1]");
	}
	public void No_leave_template() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='noLeave']");
		Webclick("//input[@id='noLeave']");
	}
	public void Yes_leave_template() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='yesLeave']");
		Webclick("//input[@id='yesLeave']");
	}



	//	Logout();
	//	Officestaff_Login();

	public void OfficestaffLogin() 
	{
		Officestaff_Login();
	}

	public void job() 
	{
		ExplicitWait_PresenceOfEle2("(//span[text()='Jobs'])[1]");
		Webclick("(//span[text()='Jobs'])[1]");
	}

	public void job_arrive_question_template() 
	{
		WebTwoSec();
		ScrollWeb("//div[text()=' Job arrive question template ']/following::a[text()='View'][1]");
		ExplicitWait_PresenceOfEle2("//div[text()=' Job arrive question template ']/following::a[text()='View'][1]");
		Webclick("//div[text()=' Job arrive question template ']/following::a[text()='View'][1]");
	}

	public void yes_ArriveQuestion()
	{
		ExplicitWait_PresenceOfEle2("//input[@id='yes_setup_Arrive']");
		Webclick("//input[@id='yes_setup_Arrive']");
	}
	public void Back_Setting()
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("(//a[text()='Settings'])[2] ");
		Webclick("(//a[text()='Settings'])[2] ");
	}
	//	job();
	public void job_report_template()   
	{
		WebTwoSec();
		ScrollWeb("//div[text()=' Job report template ']/following::a[text()='View'][1]");
		ExplicitWait_PresenceOfEle2("//div[text()=' Job report template ']/following::a[text()='View'][1]");
		Webclick("//div[text()=' Job report template ']/following::a[text()='View'][1]");
	}
	public void yes_LeaveQuestion() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='yesLeave']");
		Webclick("//input[@id='yesLeave']");
	}
	//	Back_Setting();
	//	job();
	public void job_arrive_signature_setting()   
	{
		WebTwoSec();
		ScrollWeb("//div[text()=' Job arrive signature setting ']/following::a[text()='View'][1]");
		ExplicitWait_PresenceOfEle2("//div[text()=' Job arrive signature setting ']/following::a[text()='View'][1]");
		Webclick("//div[text()=' Job arrive signature setting ']/following::a[text()='View'][1]");
	}
	public void yes_ArriveSignature() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='yes_arrive_message']");
		Webclick("//input[@id='yes_arrive_message']");
	}

	public void ArriveSignatureMessage() //textarea[@id='leavesignaturemessage_value']
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//textarea[@id='arrivesignaturemessage_value']");
		typeForWeb("//textarea[@id='arrivesignaturemessage_value']", "Arrive signature");
	}
	public void LeaveSignatureMessage() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//textarea[@id='leavesignaturemessage_value']");
		typeForWeb("//textarea[@id='leavesignaturemessage_value']", "Leave signature");
	}
	//	Back_Setting();
	//	job();
	public void job_report_signature_setting()   
	{
		WebTwoSec();
		ScrollWeb("//div[text()=' Job report signature setting ']/following::a[text()='View'][1]");
		ExplicitWait_PresenceOfEle2("//div[text()=' Job report signature setting ']/following::a[text()='View'][1]");
		Webclick("//div[text()=' Job report signature setting ']/following::a[text()='View'][1]");
	}
	public void yes_LeaveSignature() //input[@id='no_leave_message']
	{
		ExplicitWait_PresenceOfEle2("//input[@id='yes_leave_message']");
		Webclick("//input[@id='yes_leave_message']");
	}


	public void no_ArriveQuestion() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='no_setup_Arrive']");
		Webclick("//input[@id='no_setup_Arrive']");
	}

	public void no_LeaveQuestion() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='noLeave']");
		Webclick("//input[@id='noLeave']");
	}

	public void no_ArriveSignature() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='no_arrive_message']");
		Webclick("//input[@id='no_arrive_message']");
	}
	public void no_LeaveSignature() 
	{
		ExplicitWait_PresenceOfEle2("//input[@id='no_leave_message']");
		Webclick("//input[@id='no_leave_message']");
	}

	public void Save_SignatureSetup() throws InterruptedException 
	{
		ExplicitWait_PresenceOfEle2("(//span[text()='Save'])[1]");
		Webclick("(//span[text()='Save'])[1]");
		Thread.sleep(2000);
	}

	//---------------------> Add prefinal invoice to job <--------------------

	public void JobDescriptionTemplate() 
	{
		ExplicitWait_ElementToBeClickable2("//div[text()=' Job description templates ']/following::a[1]");
		Webclick("//div[text()=' Job description templates ']/following::a[1]");

	}
	public void Search_JobTemplateOnSettings(String automationNewQuestionTemplate) 
	{
		ExplicitWait_PresenceOfEle2("//input[@placeholder='Search']");
		typeForWeb("//input[@placeholder='Search']", automationNewQuestionTemplate);
	}
	public void Configure() 
	{
		WebThreeSec();
		ExplicitWait_ElementToBeClickable2("//button[text()=' Configure ']");
//		Webclick("//button[text()=' Configure ']");
		
		try 
		{
			Webclick("//button[text()=' Configure ']");
			if(driverWeb.findElement(By.xpath("//span[text()='Automatically invoice']")).isDisplayed())
				System.out.println("");
		}catch(Exception e) 
		{
			Webclick("//button[text()=' Configure ']");
		}
	}
	public void Click_AutomaticallyInvoice() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='Automatically invoice']");
		Webclick("//span[text()='Automatically invoice']");
	}
	public void AddInvoiceRule() 
	{
		ExplicitWait_ElementToBeClickable2("//button[text()='Add invoice rule ']");
		Webclick("//button[text()='Add invoice rule ']");
	}
	public void Select_CustomerType() 
	{
		WebOneSec();
		ExplicitWait_PresenceOfEle2("//select[@formcontrolname='customerType']");

		SelectByVisibileText("//select[@formcontrolname='customerType']", "Private Customer");
	}
	public void Select_Rule() 
	{
		ExplicitWait_PresenceOfEle2("//select[@formcontrolname='rule']");

		SelectByVisibileText("//select[@formcontrolname='rule']", "Pre-final invoice");
	}
	public void description(String PrefinalTest) 
	{
		ExplicitWait_PresenceOfEle2("//input[@formcontrolname='description']");
		typeForWeb("//input[@formcontrolname='description']", PrefinalTest);
	}
	public void InvoiceBreakdown() 
	{
		ExplicitWait_PresenceOfEle2("//select[@formcontrolname='invoiceBreakdown']");

		SelectByVisibileText("//select[@formcontrolname='invoiceBreakdown']", "No breakdown");
	}
	public void InvoiceCategory() 
	{
		ScrollWeb("//label[text()='Default nominal code']");
		ExplicitWait_PresenceOfEle2("//select[@formcontrolname='invoiceCategory']");

		SelectByIndex("//select[@formcontrolname='invoiceCategory']", 1);
	}
	public void UserGroup() 
	{
		ExplicitWait_PresenceOfEle2("//select[@formcontrolname='userGroup']");

		SelectByIndex("//select[@formcontrolname='userGroup']", 1);
	}

	public void Email() 
	{
		ExplicitWait_PresenceOfEle2("//select[@formcontrolname='email']");

		SelectByVisibileText("//select[@formcontrolname='email']", "Don’t email");
	}
	
	public void DefaultNominalValue() 
	{
		ExplicitWait_ElementToBeClickable2("//a[@class='select2-choice select2-default']");
		Webclick("//a[@class='select2-choice select2-default']");
		ExplicitWait_ElementToBeClickable2("//ul[@class='select2-results']/li[1]");
		Webclick("//ul[@class='select2-results']/li[1]");
	}
	public void PrefinalInvoiceSave() 
	{
		ExplicitWait_ElementToBeClickable2("(//span[text()='Save'])[2]");
		Webclick("(//span[text()='Save'])[2]");
	}
	
	public void PricingItems() 
	{
		WebOneSec();
		ExplicitWait_ElementToBeClickable2("//span[text()='Pricing items']");
		Webclick("//span[text()='Pricing items']");
	}
	
	public void Type_PriceItem(String automationpricingitem) 
	{
		ExplicitWait_ElementToBeClickable2("//td[contains(@class,'overflow')]");
		WebDoubleClick("//td[contains(@class,'overflow')]");
		WebThreeSec();
//		ExplicitWait_PresenceOfEle2("//li[text()='Please enter 2 more characters']/preceding::input[@class='select2-input'][1]");
//		Webclick("//li[text()='Please enter 2 more characters']/preceding::input[@class='select2-input'][1]");
//		typeForWeb("//li[text()='Please enter 2 more characters']/preceding::input[@class='select2-input'][1]", "Automation Pricing Item");
//		ExplicitWait_ElementToBeClickable2("//div[@class='select2-result-label']");
//		Webclick("//div[@class='select2-result-label']");
		
		Webclick("//*[@id='select2-drop']/div/input");
		typeForWeb("//*[@id='select2-drop']/div/input", automationpricingitem);
		ExplicitWait_ElementToBeClickable2("//div[@class='select2-result-label']");
		Webclick("//div[@class='select2-result-label']");
	}
	
	public void NumberOfMinutesIncluded() 
	{
		ExplicitWait_ElementToBeClickable2("//td[@class='required current highlight']");
		WebDoubleClick("//td[@class='required current highlight']");
		WebOneSec();
		Webclick("//textarea[@class='handsontableInput']");
		ExplicitWait_PresenceOfEle2("//textarea[@class='handsontableInput']");
		typeForWeb("//textarea[@class='handsontableInput']", "2");
	}
//	PrefinalInvoiceSave
	public void CloseTemplate() 
	{
		WebOneSec();
		ExplicitWait_ElementToBeClickable2("//strong[text()='×']");
		Webclick("//strong[text()='×']");
	}
	
	public void DeletePricingItem() 
	{
		ExplicitWait_ElementToBeClickable2("(//span[text()='Actions'])[1]/following::a[text()='Delete'][1]");
		Webclick("(//span[text()='Actions'])[1]/following::a[text()='Delete'][1]");
	}
	public void Yes() 
	{
		ExplicitWait_ElementToBeClickable2("//a[text()='Yes']");
		Webclick("//a[text()='Yes']");
	}
//	PrefinalInvoiceSave
	public void DeleteRule() 
	{
		WebThreeSec();
		
		ExplicitWait_ElementToBeClickable2("/html/body/cs-full-screen-modal/div/div[2]/section/app-job-description-fs-layout/div/div[2]/div/div/div/app-job-description-automatic-invoice/div/section/div[2]/app-settings-table/div/div/div[1]/div[2]/table/tbody/tr/td[4]/button[2]");
		WebElement element = driverWeb.findElement(By.xpath("/html/body/cs-full-screen-modal/div/div[2]/section/app-job-description-fs-layout/div/div[2]/div/div/div/app-job-description-automatic-invoice/div/section/div[2]/app-settings-table/div/div/div[1]/div[2]/table/tbody/tr/td[4]/button[2]"));
		((JavascriptExecutor) driverWeb).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	public void TypeDelete() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("/html/body/cs-confirmation-modal/div[2]/div[2]/div/div/div[1]/div/input");
		typeForWeb("/html/body/cs-confirmation-modal/div[2]/div[2]/div/div/div[1]/div/input", "Delete");
	}
	public void DeleteConfirm() 
	{
		WebOneSec();
		ExplicitWait_ElementToBeClickable2("//button[text()='delete']");
		Webclick("//button[text()='delete']");
	}
	
}
