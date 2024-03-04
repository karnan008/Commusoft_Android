package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;

public class VerifyEditedCustomerOnWeb extends Wrapper{
	
	
	public VerifyEditedCustomerOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	public void SearchCustomer()
	{


		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		customernumber = System.getProperty("customernumber");
		//		typeForWeb("//input[@type='search']", customernumber);
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.clear();
		num.sendKeys(customernumber);

		WebThreeSec();
		num.sendKeys(Keys.ENTER);


	}
//	verifyCustomerOnWeb.ClickCustomer();
//	verifyCustomerOnWeb.EnableNewUI();
//	verifyCustomerOnWeb.VerifyCustomerNumber();

	public void Verify_EditedName(String title,String editname, String editsurname) 
	{
		
		ExplicitWait_PresenceOfEle2("(//span[text()='"+title+" "+editname+" "+editsurname+"'])[2]");
		AssertTrueWeb("(//span[text()='"+title+" "+editname+" "+editsurname+"'])[2]");
//		System.err.println("Customer edited name in web: "+"(//span[text()='Mr & Mrs "+editname+" "+editsurname+"'])[2]");
	}
	
	public void Verify_EditedAddress(String editaddress) 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='"+editaddress+" ']");
		AssertTrueWeb("//span[text()='"+editaddress+" ']");
//		System.err.println("Customer edited address in web: "+"//span[text()='"+editaddress+" ']");
	}
	public void Verify_EditedEmail(String editemail) 
	{
		ExplicitWait_PresenceOfEle2("//button[text()='"+editemail+"']");
		AssertTrueWeb("//button[text()='"+editemail+"']");
//		System.err.println("Customer edited email in web: "+"//button[text()='"+editemail+"']");
	}
	
}
