package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.Wrapper;

public class VerifyWorkaddressOnWeb extends Wrapper{
	
	public VerifyWorkaddressOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	
	public void SearchWorkAddress() 
	{
		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		workaddressnumber = System.getProperty("workaddressnumber");
		//		typeForWeb("//input[@type='search']", customernumber);
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.clear();
		num.sendKeys(workaddressnumber);

		WebThreeSec();
		num.sendKeys(Keys.ENTER);
	}
	
	public void Click_WorkAddress() 
	{
		ExplicitWait_PresenceOfEle2("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/section/div[2]/div[2]/section[1]/table/tbody/tr/td[1]/span/a");
		Webclick("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/section/div[2]/div[2]/section[1]/table/tbody/tr/td[1]/span/a");
	}
//	verifyCustomerOnWeb.EnableNewUI();
	
	public void VerifyCustomerNumber() 
	{
		ExplicitWait_PresenceOfEle2("(//ul[@class='details list-style']/li)[2]");
		String Num = driverWeb.findElement(By.xpath("(//ul[@class='details list-style']/li)[2]")).getText();
		AssertEquals(Num, workaddressnumber);
//		System.err.println("Customer Id Is: "+customernumber);
	}
	

}
