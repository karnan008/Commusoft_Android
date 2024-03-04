package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import MainPack.Wrapper;

public class VerifyCompletedJobAndInvoice extends Wrapper{
	
	public VerifyCompletedJobAndInvoice(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	public void SearchJob() 
	{
		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		jobnumber = System.getProperty("jobnumber");
		//		typeForWeb("//input[@type='search']", customernumber);
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.clear();
		num.sendKeys(jobnumber);

		WebThreeSec();
		num.sendKeys(Keys.ENTER);
	}
	public void SearchJobDemo() 
	{
		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.sendKeys("7760");

		WebThreeSec();
		num.sendKeys(Keys.ENTER);
	}
	public void Select_Job() 
	{
		ExplicitWait_ElementToBeClickable2("//a[text()='"+jobnumber+"']");
		Webclick("//a[text()='"+jobnumber+"']");
	}
	
	public void SelectJobDemo() 
	{
		ExplicitWait_ElementToBeClickable2("//a[text()='7760']");
		Webclick("//a[text()='7760']");
	}
	public void VerifyJobstatus() 
	{
		ExplicitWait_PresenceOfEle2("//strong[text()='This job is complete']");
		AssertTrueWeb("//strong[text()='This job is complete']");
	}
	public void Verify_NotCompletedStatus() 
	{

		WebThreeSec();
//		SoftAssert softAssert = new SoftAssert();
//		
//		softAssert.assertFalse(driverWeb.getPageSource().contains("This job is complete"));
//		System.out.println("Soft Assert - Job completion status is not visible in this page");
		
		Assert.assertFalse(driverWeb.getPageSource().contains("This job is complete"));
		System.out.println("Job completion status is not visible in this page");
		
//		AlertMessage("Commusoft - Job completion status is not appeared, because its not completed from mobile");
//		AcceptAlert();

		
	}
	
	public void VerifyInvoice() 
	{
		ExplicitWait_PresenceOfEle2("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/span[1]/div/section/div/div/div[1]/div/div/div/div[1]/p/strong");
		AssertTrueWeb("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/span[1]/div/section/div/div/div[1]/div/div/div/div[1]/p/strong");
	}
	
	public void Invoice_Tab() 
	{
		WebThreeSec();
		ExplicitWait_PresenceOfEle2("//span[text()='Invoices']");
		Webclick("//span[text()='Invoices']");
	}
	public void Verify_Invoice_Final_Status() //td[text()='Final']
	{
		ExplicitWait_PresenceOfEle2("//td[text()='Final']");
		AssertTrueWeb("//td[text()='Final']");
	}
	public void Verify_Invoice_Payment_Status() //td[text()='Final']
	{
		ExplicitWait_PresenceOfEle2("//td[text()='Payment charge']");
		AssertTrueWeb("//td[text()='Payment charge']");
	}
	public void Verify_Invoice_PrefinalStatus() //td[text()='Prefinal']
	{
		ExplicitWait_PresenceOfEle2("//td[text()='Prefinal']");
		AssertTrueWeb("//td[text()='Prefinal']");
	}
	
	public void View() 
	{
		WebOneSec();
		ScrollWeb("(//a[@has-permission='Diary,readaccess'])[3]");
		ExplicitWait_PresenceOfEle2("(//a[@has-permission='Diary,readaccess'])[3]");
		Webclick("(//a[@has-permission='Diary,readaccess'])[3]");
	}
	public void FeedBack() 
	{
		WebOneSec();
		ExplicitWait_PresenceOfEle2("//div[text()='Feedback']");
		Webclick("//div[text()='Feedback']");
		
	}
	
	public void Verify_ArriveAnswer(String arriveanswer) 
	{
		WebThreeSec();
		String ActualArriveAnswer = driverWeb.findElement(By.xpath("//*[@id='page-panel-main']/div[3]/div[1]/div[2]/div/div/section[1]/ng-include/div[1]/div/ul/li[1]/div[2]/p")).getText();
		Assert.assertEquals(arriveanswer, ActualArriveAnswer);
	}
	
	public void Verify_LeaveAnswer(String leaveanswer) 
	{
		WebOneSec();
		ScrollWeb("//h4[text()='Leave site']");
		String ActualLeaveAnswer = driverWeb.findElement(By.xpath("//*[@id='page-panel-main']/div[3]/div[1]/div[2]/div/div/section[2]/ng-include/div[1]/div/ul/li[1]/div[2]/p")).getText();
		Assert.assertEquals(leaveanswer, ActualLeaveAnswer);
		
	}
	public void FeedBackClose() 
	{
		ExplicitWait_PresenceOfEle2("//a[text()='Close']");
		Webclick("//a[text()='Close']");
	}

	public void WebOfficeTaskMenu() 
	{
		ExplicitWait_PresenceOfEle2("//a[@title='Office tasks']");
		Webclick("//a[@title='Office tasks']");
	}
	
	public void SearchTask() 
	{
		ExplicitWait_PresenceOfEle2("(//input[@type='search'])[2]");
		randomAlphabetic = System.getProperty("randomAlphabetic");
		typeForWeb("(//input[@type='search'])[2]", randomAlphabetic);
		

	}
	
	public void MarkAsCompleted() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//div[@tooltip='Mark as complete']");
		Webclick("//div[@tooltip='Mark as complete']");
	}
	
	
	
	
	
	
}
