package MobAndWeb_Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
public class EstimateAccept extends Wrapper{

	public EstimateAccept(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}

	public void Diary() 
	{
		
		TwoSec();
		try 
		{
			
			ExplicitWait_ElementToBeClickable("//*[@text='Diary']");
			click("//*[@text='Diary']");
			
		}catch(Exception e) 
		{
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();
			ExplicitWait_ElementToBeClickable("//*[@text='Diary']");
			click("//*[@text='Diary']");
		}
	}
	
	public void Searchtest() throws AWTException  
	{
		ThreeSec();
		click("//*[@text='Search']");
		ThreeSec();
		click("(//*[@class='android.view.View'])[7]");
		ThreeSec();
//		MobileElement num = driver.findElement(By.xpath("(//*[@class='android.view.View'])[7]"));
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].value='4658'",num);
		
//		Robot rbt=new Robot();
//		rbt.keyPress(KeyEvent.VK_S);
//		rbt.keyRelease(KeyEvent.VK_S);
		
		   try {
	            Robot robot = new Robot();
	            
	            accountnumweb = System.getProperty("accountnumweb");
	            String inputString = accountnumweb;
	            
	            char[] characters = inputString.toCharArray();
	            
	            for (char c : characters) {
	                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
	                if (KeyEvent.CHAR_UNDEFINED == keyCode) {
	                    // Handle undefined key codes
	                } else {
	                    robot.keyPress(keyCode);
	                    robot.keyRelease(keyCode);
	                }
	            }
	            
//	            robot.dispose();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
		
		
		
		
	}

	public void Fabicon() throws InterruptedException 
	{
		OneSec(); 
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/iv_today_events']");
		clickpoint(943, 1896);
	}

	public void Click_Estimate() throws InterruptedException 
	{
//		ThreeSec(); commented on 10/02/2025
		ExplicitWait_PresenceOfEle("//*[@text='Create estimate event']");
		clickpoint(956, 1376);
	}

	public void starttime() 
	{
//		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/starttimeIconview']");
//		click("//*[@resource-id='com.commusoft.v4:id/starttimeIconview']");
	}

	public void SelectStartTime() throws InterruptedException 
	{
//		ExplicitWait_PresenceOfEle("//*[@text='CANCEL']");
//		clickpoint(275, 1189);//OK
////		ThreeSec();
//		click("//*[@text='OK']");
	}
	public void EndTime() 
	{
//		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/end_time']");
//		click("//*[@resource-id='com.commusoft.v4:id/end_time']");
	}

	public void SelectEndTime() throws InterruptedException 
	{
//		ExplicitWait_PresenceOfEle("//*[@text='CANCEL']");
//		clickpoint(275, 1189);
////		ThreeSec();
//		clickpoint(788, 1192);
////		ThreeSec();
//		click("//*[@text='OK']");
	}

	public void SearchCustomer() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		customernumber = System.getProperty("customernumber");
		//		typeForWeb("//input[@type='search']", customernumber);
		MobileElement num = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/searchText']"));

		num.sendKeys(customernumber);

		ThreeSec();
		click("//*[@resource-id='com.commusoft.v4:id/searchButtonView']");


	}
	public void PassCustomer() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		
		MobileElement num = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/searchText']"));

		num.sendKeys("4889");

		ThreeSec();
		click("//*[@resource-id='com.commusoft.v4:id/searchButtonView']");


	}

	public void SelectCustomer() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/listviews']");
		click("//*[@resource-id='com.commusoft.v4:id/listviews']");
	}

	public void EstimateDescription() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/templatespinnerView']");
		click("//*[@resource-id='com.commusoft.v4:id/templatespinnerView']");
		ExplicitWait_PresenceOfEle("(//*[@resource-id='android:id/text1'])[2]");
		click("(//*[@resource-id='android:id/text1'])[2]");
//		FiveSec();
//		EventDes = driver.findElement(By.xpath("(//*[@resource-id='android:id/text1'])[last()]")).getText();
//
//		System.out.println("Event Description Name: "+EventDes);

	}

	public void SaveEstimate() 
	{
		ThreeSec();
		click("//*[@resource-id='com.commusoft.v4:id/save']");
	}

	public void EstimateTravel() throws InterruptedException, IOException 
	{
//		ExplicitWait_PresenceOfEle("(//*[@text='"+EventDes+"'])[1]");
//		click("(//*[@text='"+EventDes+"'])[1]");



		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/status_color']");
		do {

//			ThreeSec();
			List<MobileElement> estcolor = driver.findElements(By.xpath("//*[@resource-id='com.commusoft.v4:id/status_color']"));


			for ( MobileElement ColorOfEstimates : estcolor) {


//				String EstimatesList = ColorOfEstimates.getText();
//				System.err.println("Estimate Lists: "+EstimatesList);



				org.openqa.selenium.Point point = ColorOfEstimates.getCenter();

				int centerx = point.getX();
				int centerY = point.getY();

				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				BufferedImage image = ImageIO.read(scrFile);
				int clr=  image.getRGB(centerx,centerY); 
				int  red   = (clr & 0x00ff0000) >> 16;
				int  green = (clr & 0x0000ff00) >> 8;
				int  blue  =  clr & 0x000000ff;

				Red = Integer.toString(red);
				Green = Integer.toString(green);
				Blue = Integer.toString(blue);

//				System.out.println("Red Color value = "+ Red);
//				System.out.println("Green Color value = "+ Green);
//				System.out.println("Blue Color value = "+ Blue);

				if(Red.equals("218")&&Green.equals("210")&&Blue.equals("203")) //Red.equals("218")&&Green.equals("210")&&Blue.equals("203")
				{
					
					ColorOfEstimates.click();
					break;
					
				}

				
			}

			if(Red.equals("218")&&Green.equals("210")&&Blue.equals("203")) //Red.equals("218")&&Green.equals("210")&&Blue.equals("203")
			{
				System.err.println("");

			}else 
			{
				scrolltothedown(500, 1626, 500, 1230); 
				

			}

			
		} while (!(Red.equals("218")&&Green.equals("210")&&Blue.equals("203")));


		
	
	}
	

	public void Diary_Accept() throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@text='Accept']");
		click("//*[@text='Accept']");//click accept
		//		Thread.sleep(2000);
	}
	public void Diary_Travel() throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@text='Travel']");
		click("//*[@text='Travel']");//click trvel com.commusoft.v4:id/statusButton1
		//		Thread.sleep(2000);
	}

	public void Diary_Arrive() throws InterruptedException
	{
		ExplicitWait_PresenceOfEle("//*[@text='Arrive']");
		click("//*[@text='Arrive']");//click arrive
		//		Thread.sleep(2000);
	}

	public void StoreEstimateNumber() 
	{

		ExplicitWait_PresenceOfEle("//*[@text='Estimate number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']");
		estimatenumber = driver.findElement(By.xpath("//*[@text='Estimate number']/following-sibling::*[@resource-id='com.commusoft.v4:id/jobnumber']")).getText();
		System.setProperty("estimatenumber", estimatenumber);

		System.out.println("Estimate Number Is: "+estimatenumber);
	}


	public void SearchEstimateByNumber() throws AWTException, InterruptedException 
	{
//		FiveSec();
//
//		ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[7]");
//		click("(//*[@class='android.view.View'])[7]");
//		TwoSec();
//
//		Robot robot = new Robot();
//
//		estimatenumber = System.getProperty("estimatenumber");
//		String inputString = estimatenumber;
//
//		char[] characters = inputString.toCharArray();
//
//		for (char c : characters) {
//			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
//			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
//				// Handle undefined key codes
//			} else {
//				robot.keyPress(keyCode);
//				robot.keyRelease(keyCode);
//			}
//		}
//
//		        
//
//		click("(//*[@class='android.widget.ImageView'])[1]"); 
		
		ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
		estimatenumber = System.getProperty("estimatenumber");
		MobileElement num = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
		num.sendKeys(estimatenumber);
		Thread.sleep(2000);
		TouchAction touchAction = new TouchAction(driver);
		MobileElement element = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[1]"));
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
	
	
	}
	public void SelectEstimate() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='Estimates']/following-sibling::*[@class='android.view.View'])[1]");
		click("(//*[@text='Estimates']/following-sibling::*[@class='android.view.View'])[1]");
	}
	public void Click_Choc_MenuButton() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
		click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
	}
	
	public void Diary_History() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
		click("//*[@text='Diary history']");
	}
	
	public void Estimate_Select() 
	{
//		ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.LinearLayout'])[7]");
//		click("(//*[@class='android.widget.LinearLayout'])[7]");

		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/eventdateView']");
		click("//*[@resource-id='com.commusoft.v4:id/eventdateView']");
	}
	
	public void GOTOEVENT() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='GO TO EVENT']");
		click("//*[@text='GO TO EVENT']");
	}
	
//	estimate2.Diary_Accept();
//	estimate2.StoreEstimateNumber();
//	estimate2.Diary_Travel();
//	estimate2.Diary_Arrive();
//	estimate.Diary_FillinEstimate();
//	estimate.FillinEstimate_Price();
//	estimate.Price_NoBreakdown();
//	estimate.Price_NoBreakdownselect(Breakdown);
//	estimate.Breakdown_value("100");
//	estimate.save();
//	estimate.Invoice_Schedule();
//	estimate.save();
//	estimate.AcceptReject();
//	estimate.Estimate_Checkbox();
//	estimate.Estimate_Accept();
//	estimate.YES();
//	
//	ScrollDown24("ACCEPT");
//	Thread.sleep(4000);
//	signature(361, 1743, 718, 1686);//Added By Saravanan
//	estimate.Estimate_Acceptbtn();
//	estimate.Estimate_Leave();
//
//	ThreeSec();
//	signature(234, 1255, 658, 1246);//simulator 
//
//	estimate.Sign_save();
//	ThreeSec();
//	signature(266, 916, 731, 900);//simulator
//	estimate.Sign_save();
//	estimate.Verify_Status();
//    estimate.Verify_JobConvertionStatus();
//	Click_NavigateUp_BackButton();
//	Click_MenuClosed_BackButton();
	
	
	
	
	
	
	
	
	
	public void Click_FabIcon() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");//com.commusoft.v4:id/fab_expand_menu_button
	    click("//*[@resource-id='com.commusoft.v4:id/fab_expand_menu_button']");
	}
	
	public void Click_Book_DiaryEvent() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Book diary event']");
		click("//*[@text='Book diary event']");
	}
	public void BookEvent() throws InterruptedException 
	{
		ThreeSec();
		clickpoint(237, 1899);//Select slot
		clickpoint(237, 1899);
		ExplicitWait_ElementToBeClickable("//*[@text='Book event']");
		click("//*[@text='Book event']");
		
		
	}
//	estimate2.starttime();
//	estimate2.SelectStartTime();
//	estimate2.EndTime();
//	estimate2.SelectEndTime();
	
	public void OfficeTask() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Office task']");
		click("//*[@text='Office task']");
	}
	public void TypeAndSelectUsername() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/officetaskValue']");
		click("//*[@resource-id='com.commusoft.v4:id/officetaskValue']");
		type("//*[@resource-id='com.commusoft.v4:id/officetaskValue']", "@Office");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.BACK_SPACE).build().perform();
		ThreeSec();
		ExplicitWait_ElementToBeClickable("//*[@text='@OfficeStaff']");
		click("//*[@text='@OfficeStaff']");
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/officetaskValue']");
		String username = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/officetaskValue']")).getText();
		System.out.println("User name: "+username);
		
		
		
		randomAlphabetic = RandomStringUtils.randomAlphabetic(5);
		
		System.setProperty("randomAlphabetic", randomAlphabetic);
		
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/officetaskValue']");
		MobileElement findElement = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/officetaskValue']"));
		actions.sendKeys(findElement, " #"+ randomAlphabetic).build().perform();
		username = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/officetaskValue']")).getText();
		System.out.println("User name and random alphabets: "+username);
		System.out.println("Random alphabets: "+randomAlphabetic);
		
	}
	
	
	public void Verify_CompletedStatusOnMobile() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Completed office tasks']");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Completed office tasks']")).isDisplayed());
	}
	

	

}
