package MobAndWeb_Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class VerifyCustomerOnWeb extends Wrapper{

	public VerifyCustomerOnWeb(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}

//	public VerifyCustomerOnWeb(AndroidDriver<MobileElement> lsdrie) 
//	{
//		this.driver=lsdrie;
//	}


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

	public void ClickCustomer() 
	{
		ExplicitWait_PresenceOfEle2("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/section/div[2]/div[2]/section[1]/table/tbody/tr/td[1]/span/a");
		Webclick("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/section/div[2]/div[2]/section[1]/table/tbody/tr/td[1]/span/a");
	

	
	}
	
	public void FailClickCustomer() 
	{

		Webclick("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/section/div[2]/div[2]/section[1]/table/tbody/tr/td[1]/span/a");
		

	
	
	}

	public void EnableNewUI() 
	{
		try {
			ExplicitWait_PresenceOfEle2("//div[starts-with(text(),'Try out')]");
			WebElement toggleButton = driverWeb.findElement(By.xpath("//div[@class='btn-switch']"));


			if(driverWeb.findElement(By.xpath("//div[@class='btn-switch']")).equals(toggleButton)) 
			{
				Webclick("//div[@class='btn-switch']");
				System.out.println("Now its enabled");
			}}catch(Exception e) 
		{
				System.out.println("Already New UI is enabled");
		}



	}

	public void VerifyCustomerNumber() 
	{
		ExplicitWait_PresenceOfEle2("(//ul[@class='details list-style']/li)[2]");
		String Num = driverWeb.findElement(By.xpath("(//ul[@class='details list-style']/li)[2]")).getText();
		AssertEquals(Num, customernumber);
//		System.err.println("Customer Id Is: "+customernumber);
	}

	public void VerifyName(String title, String name,String surname) 
	{
		ExplicitWait_PresenceOfEle2("(//span[text()='"+title+" "+name+" "+surname+"'])[2]");
		AssertTrueWeb("(//span[text()='"+title+" "+name+" "+surname+"'])[2]");
//		System.err.println("Customer Name Is: "+"(//span[text()='"+title+" "+name+" "+surname+"'])[2]");
	}




















	public void Test2()
	{

		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		customernumber = System.getProperty("customernumber");
		driverWeb.findElement(By.xpath("//input[@type='search']")).clear();
		TwoSec();
		typeForWeb("//input[@type='search']", customernumber);

	}

//-----------------------------> Retry Click and Type <-----------------------------
	
	
	public void Demo_SearchCustomer()
	{


		ExplicitWait_PresenceOfEle2("//input[@type='search']");
		WebElement num = driverWeb.findElement(By.xpath("//input[@type='search']"));
		num.clear();
		num.sendKeys("3774");
      
		WebThreeSec();
		num.sendKeys(Keys.ENTER);


	}
	
	
}
