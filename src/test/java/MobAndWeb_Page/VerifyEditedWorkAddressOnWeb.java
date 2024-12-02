package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;

public class VerifyEditedWorkAddressOnWeb extends Wrapper{
	
	public VerifyEditedWorkAddressOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	public void SearchworkAddress()
	{


		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		workaddressnumber = System.getProperty("customernumber");
		//		typeForWeb("//input[@type='search']", customernumber);
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.clear();
		num.sendKeys(workaddressnumber);

		WebThreeSec();
		num.sendKeys(Keys.ENTER);


	}
	
	public void VerifyWorkAddressNumber() 
	{
		ExplicitWait_PresenceOfEle2("(//ul[@class='details list-style']/li)[2]");
		String Num = driverWeb.findElement(By.xpath("(//ul[@class='details list-style']/li)[2]")).getText();
		AssertEquals(Num, workaddressnumber);
//		System.err.println("Customer Id Is: "+customernumber);
	}
	

}
