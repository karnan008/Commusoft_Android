package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import MainPack.Wrapper;

public class Invoice_Web extends Wrapper{
	
	public Invoice_Web(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	
	public void Click_InvoiceTab() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='Invoices']");
		Webclick("//span[text()='Invoices']");
		
	}
	public void Click_AddNewInvoice() 
	{
		ExplicitWait_ElementToBeClickable2("//a[@has-permission='Customerinvoicing,writeaccess']");
		Webclick("//a[@has-permission='Customerinvoicing,writeaccess']");
	}

	public void Select_InvoiceType(String invoiceType) 
	{
		ExplicitWait_PresenceOfEle2("//label[text()='Invoice type']/following::select[1]");
	    WebElement invoicetype = driverWeb.findElement(By.xpath("//label[text()='Invoice type']/following::select[1]"));
	    Select select = new Select(invoicetype);
	    select.selectByVisibleText(invoiceType);//Additional invoice, Interim invoice, Pre-final invoice, Final invoice
		
	}
	public void Enter_InvoiceDes() throws InterruptedException 
	{
		ExplicitWait_PresenceOfEle2("//label[text()='Description']/following::input[1]");
		Thread.sleep(1000);
		Webclick("//a[text()='Copy from job']");
	}
	public void Select_InvoiceCategory() 
	{
		ExplicitWait_PresenceOfEle2("//select[@formcontrolname='invoiceCategoryId']");
		WebTwoSec();
		WebElement invoicecategory = driverWeb.findElement(By.xpath("//select[@formcontrolname='invoiceCategoryId']"));
		Select select = new Select(invoicecategory);
		select.selectByIndex(1);//Ranjit Category, Aravind Category, RA category
	}
	public void Select_NoBreakDown() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='No breakdown']/preceding::input[@type='radio']");
		Webclick("//span[text()='No breakdown']/preceding::input[@type='radio']");
	}
	public void Enter_SubTotal(String subtotal) 
	{
		ScrollWeb("//label[text()='Sub total']");
		ExplicitWait_PresenceOfEle2("//label[text()='Sub total']/following::input[1]");
		WebClear("//label[text()='Sub total']/following::input[1]");
		typeForWeb("//label[text()='Sub total']/following::input[1]", subtotal);
//		TwoSec();
//		 subtotalvalue = driver.findElement(By.xpath("//label[text()='Sub total']/following::input[1]")).getText();
//		System.err.println("Subtotal Value Is: "+subtotalvalue);
	}
	public void Select_Vat(String vat) //20.00, 5.00, 0.00, 15.00
	{
		ExplicitWait_ElementToBeClickable2("//label[text()='VAT']/following::a[1]");
		Webclick("//label[text()='VAT']/following::a[1]");
		ExplicitWait_ElementToBeClickable2("//div[text()='"+vat+"']");
		Webclick("//div[text()='"+vat+"']");
	}
	public void Select_NominalCode(String others) 
	{
		ExplicitWait_ElementToBeClickable2("//label[text()='Nominal code']/following::a[1]");
		Webclick("//label[text()='Nominal code']/following::a[1]");//Sales
		ExplicitWait_ElementToBeClickable2("//div[text()='"+others+"']");//Sales
		Webclick("//div[text()='"+others+"']");
	}
	public void SaveInvoice() 
	{
		ScrollWeb("//span[text()='Save invoice']");
		ExplicitWait_ElementToBeClickable2("//span[text()='Save invoice']");
		Webclick("//span[text()='Save invoice']");
	}
}
