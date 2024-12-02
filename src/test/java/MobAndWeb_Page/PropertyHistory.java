package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PropertyHistory extends Wrapper{
	
	public PropertyHistory(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}

	
	public void History() 					
	{
		ExplicitWait_ElementToBeClickable("//*[@text='History']");
		click("//*[@text='History']");
	}
	
	public void PropertyHistory() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Property history']");
		click("//*[@text='Property history']");
	}
	
	public void Verify_Estimate_Accepted_Status() 
	{
		
		estimatenumber = System.getProperty("estimatenumber");
		ExplicitWait_PresenceOfEle("//*[contains(@text,'"+estimatenumber+"')]/preceding-sibling::*[@text='Accepted']");
		boolean acceptedStatus= driver.findElement(By.xpath("//*[contains(@text,'"+estimatenumber+"')]/preceding-sibling::*[@text='Accepted']")).isDisplayed();
		Assert.assertTrue(acceptedStatus);
		
	}
	
	public void Verify_Estimate_Rejected_Status() 
	{
		
		estimatenumber = System.getProperty("estimatenumber");		
		ExplicitWait_PresenceOfEle("//*[contains(@text,'"+estimatenumber+"')]/preceding-sibling::*[@text='Rejected']");
		boolean rejectedStatus= driver.findElement(By.xpath("//*[contains(@text,'"+estimatenumber+"')]/preceding-sibling::*[@text='Rejected']")).isDisplayed();
		Assert.assertTrue(rejectedStatus);
		
	}
	
	public void Verify_Job_Invoiced_Status() 
	{
		
		jobnumber = System.getProperty("jobnumber");		
		ExplicitWait_PresenceOfEle("//*[contains(@text,'"+jobnumber+"')]/preceding-sibling::*[@text='Invoiced']");
		boolean invoicedStatus= driver.findElement(By.xpath("//*[contains(@text,'"+jobnumber+"')]/preceding-sibling::*[@text='Invoiced']")).isDisplayed();
		Assert.assertTrue(invoicedStatus);
		
	}
	
	public void Verify_Job_FreeOfCharge_Status() 
	{
		
		jobnumber = System.getProperty("jobnumber");		
		ExplicitWait_PresenceOfEle("//*[contains(@text,'"+jobnumber+"')]/preceding-sibling::*[@text='Free of charge']");
		boolean freeOfChargeStatus= driver.findElement(By.xpath("//*[contains(@text,'"+jobnumber+"')]/preceding-sibling::*[@text='Free of charge']")).isDisplayed();
		Assert.assertTrue(freeOfChargeStatus);
		
	}
	
	public void Click_Job_PropertHistoryList() 
	{
		jobnumber = System.getProperty("jobnumber");		
		ExplicitWait_PresenceOfEle("//*[contains(@text,'"+jobnumber+"')]");
		click("//*[contains(@text,'"+jobnumber+"')]");
	}
	
	public void Select_Job_PropertyHistory() 
	{
		ExplicitWait_PresenceOfEle("(//*[contains(@text,'Job number')])[1]");
		click("(//*[contains(@text,'Job number')])[1]");
	}
	
	public void Back_PropertyHistory() 
	{
		click("//*[@text='Property history']");
	}
	
	public void Job_Back_PropertHistory() 
	{
		click("//*[@text='Job']");
	}
	
	public void CustomerInformation_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Customer information']");
		boolean customerInformation = driver.findElement(By.xpath("//*[@text='Customer information']")).isDisplayed();
		Assert.assertTrue(customerInformation);
	}
	
	public void JobDetails_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Job details']");
		boolean jobdetails = driver.findElement(By.xpath("//*[@text='Job details']")).isDisplayed();
		Assert.assertTrue(jobdetails);
	}
	
	public void OtherJobDetails_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Other job details']");
		boolean otherJobDetails = driver.findElement(By.xpath("//*[@text='Other job details']")).isDisplayed();
		Assert.assertTrue(otherJobDetails);
	}
	
	public void AppointmentHistory_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Appointment history']");
		boolean appointmenthistory = driver.findElement(By.xpath("//*[@text='Appointment history']")).isDisplayed();
		Assert.assertTrue(appointmenthistory );
	}
	public void InstalledParts_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Installed parts']");
		boolean installedParts = driver.findElement(By.xpath("//*[@text='Installed parts']")).isDisplayed();
		Assert.assertTrue(installedParts );
	}
	
	public void Invoices_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Invoices']");
		boolean invoices = driver.findElement(By.xpath("//*[@text='Invoices']")).isDisplayed();
		Assert.assertTrue(invoices );
	}
	
	public void Attachments_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Attachments']");
		boolean attachments = driver.findElement(By.xpath("//*[@text='Attachments']")).isDisplayed();
		Assert.assertTrue(attachments);
	}
	
	public void Certificates_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Certificates']");
		boolean certificates = driver.findElement(By.xpath("//*[@text='Certificates']")).isDisplayed();
		Assert.assertTrue(certificates);
	}
	
	public void AdditionalWorks_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Additional works']");
		boolean additionalWorks = driver.findElement(By.xpath("//*[@text='Additional works']")).isDisplayed();
		Assert.assertTrue(additionalWorks);
	}
	public void PurchaseOrders_Section() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Purchase orders']");
		boolean purchaseOrders = driver.findElement(By.xpath("//*[@text='Purchase orders']")).isDisplayed();
		Assert.assertTrue(purchaseOrders);
	}
}
