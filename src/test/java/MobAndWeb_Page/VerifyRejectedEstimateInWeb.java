package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;

public class VerifyRejectedEstimateInWeb extends Wrapper{

	public VerifyRejectedEstimateInWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}



	//	verifyAcceptEstimateOnWeb.SearchEstimate();
	//	verifyAcceptEstimateOnWeb.Select_Estimate();   

	public void verify_RejectStatus() throws InterruptedException 
	{
//		WebTwoSec();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driverWeb;
		WebElement reject = driverWeb.findElement(By.xpath("//i[text()='Rejected']"));
		js.executeScript("arguments[0].scrollIntoView()", reject);

		ExplicitWait_PresenceOfEle2("//i[text()='Rejected']");
		AssertTrueWeb("//i[text()='Rejected']");
	}
	public void verify_AbortedStatus() throws InterruptedException 
	{
//		WebTwoSec();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driverWeb;
		WebElement abort = driverWeb.findElement(By.xpath("//i[text()='aborted']"));
		js.executeScript("arguments[0].scrollIntoView()", abort);
		ExplicitWait_PresenceOfEle2("//i[text()='aborted']");
		AssertTrueWeb("//i[text()='aborted']");
	}


}
