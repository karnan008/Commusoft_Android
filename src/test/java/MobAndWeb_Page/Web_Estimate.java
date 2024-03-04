package MobAndWeb_Page;



import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import MainPack.Wrapper;

public class Web_Estimate extends Wrapper{

	public Web_Estimate(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}


	public void AddNewEstimate() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='Add new estimate']");
		Webclick("//span[text()='Add new estimate']");
	}

	public void Select_EstimateTemplate() 
	{
		ExplicitWait_PresenceOfEle2("//select[@name='estimate[templateid]']");
		WebElement temp = driverWeb.findElement(By.xpath("//select[@name='estimate[templateid]']"));
		Select sl=new Select(temp);
		sl.selectByIndex(2);
	}

	//	ScrollWeb("//span[text()='Add estimate']");

	public void Select_EstimateTemplate2() 
	{
		ExplicitWait_PresenceOfEle2("//select[@name='estimate[templateid]']");
		WebElement temp = driverWeb.findElement(By.xpath("//select[@name='estimate[templateid]']"));
		Select sl=new Select(temp);
		sl.selectByVisibleText("Automation Estimate");
	}

	public void SelectDiaryEvent() 
	{
		ExplicitWait_PresenceOfEle2("//label[@class='checkbox']");
		Webclick("//label[@class='checkbox']");
	}

	public void Save_Estimate() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Add estimate']");
		Webclick("//span[text()='Add estimate']");
	}

	public void Today() 
	{



		ExplicitWait_PresenceOfEle2("//a[text()='Diary']");
		Webclick("//a[text()='Diary']");

		WebFiveSec();

		ExplicitWait_PresenceOfEle2("(//a[contains(@ng-click,'changeDate')])[2]");
//		WebElement today = driverWeb.findElement(By.xpath("(//a[contains(@ng-click,'changeDate')])[2]"));
//		Actions actn=new Actions(driverWeb);
//		actn.click(today).build().perform();

		Webclick("(//a[contains(@ng-click,'changeDate')])[2]");

		//		JavascriptExecutor js=(JavascriptExecutor)driverWeb;
		//		js.executeScript("arguments[0].click()", today);

	}

	public void SelectUser() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Users']");
		Webclick("//span[text()='Users']");

		WebTwoSec();
		
		String selectallusertooltip = driverWeb.findElement(By.xpath("//input[@tooltip-placement='right']")).getAttribute("tooltip");
		System.out.println("selectalluser tooltip value is: "+selectallusertooltip);//input[@tooltip='Deselect All Users']

		if(selectallusertooltip.equals("Select All Users")) {
			System.out.println("Select all user check box is already unchecked");
			Webclick("//input[@tooltip-placement='right']");
//			WebTwoSec();
			Webclick("//input[@tooltip-placement='right']");

		}else
			Webclick("//input[@tooltip-placement='right']");



		ExplicitWait_PresenceOfEle2("//input[@placeholder='Search for user']");
		Webclick("//input[@placeholder='Search for user']");
		WebElement searchuser = driverWeb.findElement(By.xpath("//input[@placeholder='Search for user']"));
		username=System.getProperty("username");
		searchuser.sendKeys(username);

		WebThreeSec();

		boolean selected = driverWeb.findElement(By.xpath("//span[@class='no-avatar ss-user ng-scope']/preceding::input[@type='checkbox'][1]")).isSelected();
		String selectedString=String.valueOf(selected);

		System.out.println("Engineer check box is selected: "+selectedString);


		if(selectedString.equals("true"))
			System.out.println("Engineer check box is already checked");
		else
			Webclick("//span[@class='no-avatar ss-user ng-scope']/preceding::input[@type='checkbox'][1]"); //kandh samy


		ExplicitWait_PresenceOfEle2("//input[@placeholder='Search for user']");
		WebClear("//input[@placeholder='Search for user']");
		typeForWeb("//input[@placeholder='Search for user']", "kandh samy");

		WebFiveSec();
		
		boolean Kselected = driverWeb.findElement(By.xpath("(//input[@type='checkbox'][1])[3]")).isSelected();
		String kselectedString=String.valueOf(Kselected);

		System.out.println("kandha check box is selected: "+kselectedString);


		if(kselectedString.equals("true"))

			Webclick("(//input[@type='checkbox'][1])[3]");
		else
			System.out.println("kandha check box is already unchecked");



//		WebTwoSec();
		Webclick("//button[@class='btn btn-primary primary-button ng-scope']");



	}

	public void Select_Slot() 
	{
		WebThreeSec();

		ExplicitWait_PresenceOfEle2("//h3[text()='Diary']");


		try 
		{

			boolean slot = driverWeb.findElement(By.xpath("(//div[@class='cs-event-inner  cs-event-position'])[1]")).isDisplayed();
//			System.out.println("Slot is selected: "+slot);
			boolean n=true;

			if(slot=n) 
			{



				do 
				{
					Webclick("(//a[contains(@ng-click,'changeDate')])[3]");
//					System.out.println("Inside do");
//					WebOneSec();
					driverWeb.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					slot = driverWeb.findElement(By.xpath("(//div[@class='cs-event-inner  cs-event-position'])[1]")).isDisplayed();
//					System.err.println("Slot is selected: "+slot);
					n=true;

				}while(slot=n);
//				System.out.println("Outside do");
				ExplicitWait_PresenceOfEle2("(//td[@class='fc-widget-content'])[3]");//Change
				Webclick("(//td[@class='fc-widget-content'])[3]");//Change

			}else 
			{
				System.out.println("");
			}

		}catch(Exception e) 
		{
//			WebThreeSec();
			WebOneSec();
			ExplicitWait_PresenceOfEle2("(//td[@class='fc-widget-content'])[3]");//Change
			Webclick("(//td[@class='fc-widget-content'])[3]");//Change
		}


	}
	public void SelectSlotInMonthlyView() 
	{
	
		
		Webclick("//button[text()='Monthly']");
		Webclick("(//td[contains(@class,'fc-today ')])[2]");
		WebThreeSec();
		WebElement userSelect = driverWeb.findElement(By.xpath("//select[@ng-options='user.name for user in users']"));
	    Select select = new Select(userSelect);
	    
	    
	    username=System.getProperty("username");
	    select.selectByVisibleText(username);
		
	}

	public void Select_Slot3() 
	{
		WebThreeSec();

		ExplicitWait_PresenceOfEle2("//h3[text()='Diary']");


		try 
		{
			boolean slot = driverWeb.findElement(By.xpath("(//div[@class='cs-event-inner  cs-event-position'])[1]")).isDisplayed();
			System.out.println("Slot is selected: "+slot);
			boolean n=true;

			if(slot=n) 
			{

				do 
				{
					Webclick("(//a[contains(@ng-click,'changeDate')])[3]");
					System.out.println("Inside do");
					WebThreeSec();
					slot = driverWeb.findElement(By.xpath("(//div[@class='cs-event-inner  cs-event-position'])[1]")).isDisplayed();
					System.err.println("Slot is selected: "+slot);
					n=true;

				}while(slot=n);
				System.out.println("Outside do");
				WebThreeSec();
				ExplicitWait_PresenceOfEle2("(//td[@class='fc-widget-content'])[5]");//Change
				Webclick("(//td[@class='fc-widget-content'])[5]");//Change

			}else 
			{
				System.out.println("");
			}

		}catch(Exception e) 
		{
			WebThreeSec();
			ExplicitWait_PresenceOfEle2("(//td[@class='fc-widget-content'])[5]");//Change
			Webclick("(//td[@class='fc-widget-content'])[5]");//Change
		}


	}

	public void Save_Diary() 
	{
		WebThreeSec();
		ExplicitWait_PresenceOfEle2("(//span[text()='Save'])[2]");
		Webclick("(//span[text()='Save'])[2]");

	}

	public void StoreEstimateNumber() 
	{
		ExplicitWait_PresenceOfEle2("//span[@ng-if='estimateId']");
		estimatenumber = driverWeb.findElement(By.xpath("//span[@ng-if='estimateId']")).getText();
		System.setProperty("estimatenumber", estimatenumber);
		System.out.println("Web Estimate Number is: "+estimatenumber);


	}



}
