package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;

public class EditCustomerInWebAndVerifyInMob extends Wrapper{
	
	
	public EditCustomerInWebAndVerifyInMob(WebDriver sdriver) 
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
	public void SearchCustomerDemo() 
	{
		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.clear();
		num.sendKeys("3789");

		WebThreeSec();
		num.sendKeys(Keys.ENTER);
	}
	public void SearchNum() 
	{
		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.sendKeys("3068");
		WebThreeSec();
		num.sendKeys(Keys.ENTER);
	}
	public void editButton() 
	{
		ExplicitWait_VisibilityOfEle2("(//a[text()='Edit'])[1]");
		Webclick("(//a[text()='Edit'])[1]");
	}
	public void editName(String webname) 
	{
		ExplicitWait_PresenceOfEle2("//input[@formcontrolname='name']");
		WebElement editname = driverWeb.findElement(By.xpath("//input[@formcontrolname='name']"));
		editname.clear();
		editname.sendKeys(webname);
	}
	public void editAddress(String webaddress) 
	{
		ExplicitWait_PresenceOfEle2("//input[@formcontrolname='addressline1']");
		WebElement editname = driverWeb.findElement(By.xpath("//input[@formcontrolname='addressline1']"));
		editname.clear();
		editname.sendKeys(webaddress);
	}
	
	public void editEmail(String webemail) 
	{
		ExplicitWait_PresenceOfEle2("//input[@formcontrolname='email']");
		WebElement editname = driverWeb.findElement(By.xpath("//input[@formcontrolname='email']"));
		editname.clear();
		editname.sendKeys(webemail);
	}
	
	public void ScrollToSave() 
	{
		TwoSec();
		ScrollWeb("(//span[text()='Save'])[2]");
	}
	public void SaveChanges() 
	{
		ExplicitWait_PresenceOfEle2("(//span[text()='Save'])[2]");
		Webclick("(//span[text()='Save'])[2]");
	}
	
	public void VerifyWebName(String title,String webname, String  editsurname) 
	{
		ExplicitWait_PresenceOfEle2("(//span[text()='"+title+" "+webname+" "+editsurname+"'])[2]");
		AssertTrueWeb("(//span[text()='"+title+" "+webname+" "+editsurname+"'])[2]");
		System.out.println("Web name verified After editing");
	}
	public void VerifyWebAddress(String webaddress) 
	{

		ExplicitWait_PresenceOfEle2("//span[text()='"+webaddress+" ']");
		AssertTrueWeb("//span[text()='"+webaddress+" ']");
		System.out.println("Web address verified After editing");
	

	}

	public void VerifyWebEmail(String webemail) 
	{

		ExplicitWait_PresenceOfEle2("//button[text()='"+webemail+"']");
		AssertTrueWeb("//button[text()='"+webemail+"']");
		System.out.println("Web email verified After editing");
	
	}
}
