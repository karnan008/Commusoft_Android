package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;

public class CustomerWeb extends Wrapper{
	
	public CustomerWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	public void Private_Customer() 
	{
		ExplicitWait_PresenceOfEle2("//*[text()='New Private Customer']");
		Webclick("//*[text()='New Private Customer']");
	}
	
	public void Customer_title()throws InterruptedException
	{
		ExplicitWait_PresenceOfEle2("(//span[@class='select2-chosen'])[2]");
		Webclick("(//span[@class='select2-chosen'])[2]"); 
		ExplicitWait_PresenceOfEle2("(//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"])[2]");
		Webclick("(//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"])[2]");
	}
	public void Customer_Name(String webname)
	{
		WebTwoSec();
		typeForWeb("(//input[@class=\"form-control ng-untouched ng-pristine ng-valid\"])[1]", webname);
		
	}
	public void Customer_SurName(String websurname)
	{
		WebTwoSec();
		typeForWeb("(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]", websurname);
	}
	public void Customer_Mobile(String mob)
	{
		typeForWeb("(//input[@class=\"phone-number-input ng-untouched ng-pristine ng-valid\"])[2]", mob);
	}
	public void Customer_email(String customeremail)
	{
		typeForWeb("(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[1]", customeremail);
	}
	public void Customer_AddressLine1(String address)
	{
		typeForWeb("//input[@formcontrolname='addressline1']", address);
	}
	public void Customer_Save() throws InterruptedException
	{
		ScrollWeb("//button[@type='submit']");
		ExplicitWait_PresenceOfEle2("//button[@type='submit']");
		Webclick("//button[@type='submit']");
	}
	
	public void StoreAccountNumber() 
	{
		ExplicitWait_PresenceOfEle2("(//ul[@class='details list-style']/li[2])[1]");
		customernumber = driverWeb.findElement(By.xpath("(//ul[@class='details list-style']/li[2])[1]")).getText();
		System.setProperty("customernumber", customernumber);
	    System.out.println("Account Number Is: "+customernumber);//accountnumweb
	
	
	}
	
	public void StoreCustomerName(String webname, String websurname) 
	{
		WebThreeSec();
		ExplicitWait_PresenceOfEle2("(//span[text()='Mrs "+webname+" "+websurname+"'])[2]");
		webcustomer = driverWeb.findElement(By.xpath("(//span[text()='Mrs "+webname+" "+websurname+"'])[2]")).getText();
		System.setProperty("webcustomer", webcustomer);
		System.out.println("Web Customer Name: "+webcustomer);
	}
	
	public void StoreEmail(String customeremail) 
	{
		webemail = driverWeb.findElement(By.xpath("//button[text()='"+customeremail+"']")).getText();
		System.setProperty("webemail", webemail);
		System.out.println("Web Email Is: "+webemail);
	}
	
	//---------------------------------------------
	
	public void EditWebCustomer(String editwebcustomername) 
	{
		ExplicitWait_PresenceOfEle2("(//*[text()='Edit'])[1]");
		Webclick("(//*[text()='Edit'])[1]");
		ExplicitWait_PresenceOfEle2("//input[@formcontrolname='name']");
		Webclick("//input[@formcontrolname='name']");
		ExplicitWait_PresenceOfEle2("//input[@formcontrolname='name']");
		WebClear("//input[@formcontrolname='name']");
		typeForWeb("//input[@formcontrolname='name']", editwebcustomername);
	}
	
//------------------------------------> Demo Type And Click <------------------------------------------	
	
	
	public void Demo_Private_Customer() 
	{
		demoClickWeb("//*[text()='New Private Customer']");
	}
	
	public void Demo_Customer_title()throws InterruptedException
	{
		demoClickWeb("(//span[@class='select2-chosen'])[2]"); 
		demoClickWeb("(//li[@class='select2-results-dept-0 select2-result select2-result-selectable'])[2]");
	}
	public void Demo_Customer_Name(String webname)
	{
		
		demoTypeWeb("(//input[@class=\"form-control ng-untouched ng-pristine ng-valid\"])[1]", webname);
		
	}
	public void Demo_Customer_SurName(String websurname)
	{
		
		demoTypeWeb("(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]", websurname);
	}
	public void Demo_Customer_Mobile(String mob)
	{
		demoTypeWeb("(//input[@class=\"phone-number-input ng-untouched ng-pristine ng-valid\"])[2]", mob);
	}
	public void Demo_Customer_email(String customeremail)
	{
		demoTypeWeb("(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[1]", customeremail);
	}
	public void Demo_Customer_AddressLine1(String address)
	{
		demoTypeWeb("//input[@formcontrolname='addressline1']", address);
	}
	
	
	public void Demo_StoreAccountNumber() 
	{
		ExplicitWait_PresenceOfEle2("(//ul[@class='details list-style']/li[2])[1]");
		customernumber = driverWeb.findElement(By.xpath("(//ul[@class='details list-style']/li[2])[1]")).getText();
		System.setProperty("customernumber", customernumber);
	    System.out.println("Account Number Is: "+customernumber);//accountnumweb
	
	
	}
	
	public void Demo_StoreCustomerName(String webname, String websurname) 
	{
		WebThreeSec();
		ExplicitWait_PresenceOfEle2("(//span[text()='Mrs "+webname+" "+websurname+"'])[2]");
		webcustomer = driverWeb.findElement(By.xpath("(//span[text()='Mrs "+webname+" "+websurname+"'])[2]")).getText();
		System.setProperty("webcustomer", webcustomer);
		System.out.println("Web Customer Name: "+webcustomer);
	}
	
	public void Demo_StoreEmail(String customeremail) 
	{
		webemail = driverWeb.findElement(By.xpath("//button[text()='"+customeremail+"']")).getText();
		System.setProperty("webemail", webemail);
		System.out.println("Web Email Is: "+webemail);
	}
	
	
}
