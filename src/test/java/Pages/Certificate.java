package Pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import MainPack.Wrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Certificate extends Wrapper{
	
	public Certificate(AndroidDriver<MobileElement>sdriver) 
	{
		this.driver=sdriver;
	}
	
	public Certificate(WebDriver ssdriver) 
	{
		this.driverWeb=ssdriver;
	}

	public void Click_Certificate() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Certificates']");
		click("//*[@text='Certificates']");
	}
	
	public void Click_Fab() 
	{
		
		
		try 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']"); 
			click("//*[@resource-id='com.commusoft.v4:id/addFloatingButton']");
		}catch(Exception e) 
		{
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/add']"); //*[@resource-id='com.commusoft.v4:id/addFloatingButton']
			click("//*[@resource-id='com.commusoft.v4:id/add']");
		}
	}
	
	public void Search_Certificate(String typecertificate) //com.commusoft.v4:id/searchText
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/searchText']");
		type("//*[@resource-id='com.commusoft.v4:id/searchText']", typecertificate);//All fields (Added Normal List Screen)
	}
	
	public void Select_Certificate() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/listTextSystemSettings']");
		click("//*[@resource-id='com.commusoft.v4:id/listTextSystemSettings']");
	}
	//===========================
	public void Next_InputType(String certificateinput) //Next
	{

		ExplicitWait_PresenceOfEle("(//*[contains(@resource-id,'com.commusoft.v4:id/toolbar')])[4]");
		String NextORFinish = driver.findElement(By.xpath("(//*[contains(@resource-id,'com.commusoft.v4:id/toolbar')])[4]")).getText();
        
		
		
		while(NextORFinish.equals("Next"))// (//*[contains(@resource-id,'com.commusoft.v4:id')])[6]
		{  
			
			click("//*[@text='Next']");
			
			NextORFinish = driver.findElement(By.xpath("(//*[contains(@resource-id,'com.commusoft.v4:id/toolbar')])[4]")).getText();
			
			try 
			{
				MobileElement displayed = driver.findElement(By.xpath("//*[ends-with(@text,'put')]"));
				boolean input = displayed.isDisplayed();
				System.out.println("Input Field is displayed: "+input);
				type("//*[@text='Tap To Enter�']", certificateinput);
			}catch(Exception e) 
			{
				
			}	
			
		}
		
		
	
	}
	
	public void Click_Finish() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Finish']");
		click("//*[@text='Finish']");//Finish
	}
	
	
	
	public void verify_CertificateNumber() 
	{
		ExplicitWait_PresenceOfEle("//*[@resource-id='com.commusoft.v4:id/cert_number']");
		MobileElement certificate_Number = driver.findElement(By.xpath("//*[@resource-id='com.commusoft.v4:id/cert_number']"));
	    Verify_AssertTrue(certificate_Number);
	}
	
	// Leave diray event
	
	public void Click_TAKEPHOTO() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='TAKE PHOTO']");
		click("//*[@text='TAKE PHOTO']");
	}
	public void Click_TAKEPHOTO2() 
	{
		
		ExplicitWait_ElementToBeClickable("(//*[@text='TAKE PHOTO'])[2]");
		click("(//*[@text='TAKE PHOTO'])[2]");
	}
	public void Click_TAKEPHOTO3() 
	{
		ExplicitWait_ElementToBeClickable("(//*[@text='TAKE PHOTO'])[3]");
		click("(//*[@text='TAKE PHOTO'])[3]");
	}
	//Click_Next
	//Click_Next
//	attached_Files.Click_TakePhoto();
	
//	assets.Select_TakePhoto_From_AlertPrompt();
//	assets.Click_CenterButton_InCamera();
//	assets.Click_Tick();
//	attached_Files.Click_TakePhoto();
//	attached_Files.Click_ChooseFromCameraRoll();
	public void Select_Pic() //                               com.google.android.documentsui:id/icon_mime_lg                       
	{
		
	    try 
	    {
	    	ExplicitWait_ElementToBeClickable("(//*[@resource-id='com.google.android.documentsui:id/icon_mime_lg'])[1]");
			click("(//*[@resource-id='com.google.android.documentsui:id/icon_mime_lg'])[1]");
			
	    }catch(Exception e) 
	    {
	    	ExplicitWait_ElementToBeClickable("//*[@class='android.widget.FrameLayout']");
	    	click("//*[@class='android.widget.FrameLayout']");
	    }
	
	}
	//Click_Next
	//Click_Next
	//Click_Next
	//Click_Next
//	attached_Files.Click_TakePhoto();
//	assets.Select_TakePhoto_From_AlertPrompt();
//	assets.Click_CenterButton_InCamera();
//	assets.Click_Tick();
//	attached_Files.Click_TakePhoto();
//	attached_Files.Click_ChooseFromCameraRoll();
//	Select_Pic
//	attached_Files.Click_TakePhoto();
//	attached_Files.Click_ChooseFromCameraRoll();
//	Select_Pic
	//Click_Next
//	attached_Files.Click_TakePhoto();
//	assets.Select_TakePhoto_From_AlertPrompt();
//	assets.Click_CenterButton_InCamera();
//	assets.Click_Tick();
//	attached_Files.Click_TakePhoto();
//	attached_Files.Click_ChooseFromCameraRoll();
//	Select_Pic
	//Click_Next
	
	
	
	
	
	
	public void web_Certificate() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Certificates']");
		Webclick("//span[text()='Certificates']");
	}
	
	public void verify_WebCertificate() 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle2("//span[@cs-design-smartable-cell='job_certificates' and @data-column='Name']");
		AssertTrueWeb("//span[@cs-design-smartable-cell='job_certificates' and @data-column='Name']");
	}


	public void Click_CompletedCertificate() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Completed']");
		click("//*[@text='Completed']");
	}
	
	public void Email() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Email']");
		click("//*[@text='Email']");
	}
	
	public void To() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/to']");
		click("//*[@resource-id='com.commusoft.v4:id/to']");
	}
	
	public void CheckBox() 
	{
		ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/user_checkbox']");
		click("//*[@resource-id='com.commusoft.v4:id/user_checkbox']");
	}
	
	
//	job2.Sign_save();
	
//	job2.Sign_save();
	
	//3 sec
	
	public void Verify_CertificateOnGmailApp(String certificate) 
	{
		TwoSec();
		ExplicitWait_PresenceOfEle("(//*[contains(@text,'"+certificate+"')])[1]");
		MobileElement customform = driver.findElement(By.xpath("(//*[contains(@text,'"+certificate+"')])[1]"));
	    Verify_AssertTrue(customform);
	}
	
	
	public void CertificateFabIcon_Web() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExplicitWait_ElementToBeClickable2("//span[@class='preview-file-link actions-toggle ng-scope ss-plus']");
		Webclick("//span[@class='preview-file-link actions-toggle ng-scope ss-plus']");
		
//		ExplicitWait_ElementToBeClickable2("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/span[1]/div/section/div/div/section/section/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[9]/ng-include/span");
//		Webclick("/html/body/div[3]/ng-container/div/section/div[2]/div/ng-container/div[2]/span[1]/div/section/div/div/section/section/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[9]/ng-include/span");
		
	
	}
	
	public void EditForm() 
	{
		ExplicitWait_ElementToBeClickable2("//span[text()='Edit form']");
		Webclick("//span[text()='Edit form']");
	}
	
	public void SaveAndContinue(String editcertificateinput) 
	{


		WebOneSec();
		ExplicitWait_ElementToBeClickable2("//div[@class='cert-page']/span[1]");
		Webclick("//div[@class='cert-page']/span[1]");
		ExplicitWait_ElementToBeClickable2("//button[@class='btn btn-primary']");
		String SaveAndContinue = driverWeb.findElement(By.xpath("//button[@class='btn btn-primary']")).getText();
        
		System.out.println("Button Text: "+SaveAndContinue);
		
		while(SaveAndContinue.equals("Save and continue"))
		{  
			WebOneSec();
			Webclick("//button[@class='btn btn-primary']");
			
			SaveAndContinue = driverWeb.findElement(By.xpath("//button[@class='btn btn-primary']")).getText();
			
			try 
			{
				ExplicitWait_PresenceOfEle2("//label[contains(text(),'nput ')]");
				WebElement displayed = driverWeb.findElement(By.xpath("//label[contains(text(),'nput ')]"));
				boolean input = displayed.isDisplayed();
				System.out.println("Input Field is displayed: "+input);
				WebOneSec();
				driverWeb.findElement(By.xpath("//label[text()='Input ']/following::input[1]")).click();
				driverWeb.findElement(By.xpath("//label[text()='Input ']/following::input[1]")).clear();
				WebOneSec();
				typeForWeb("//label[text()='Input ']/following::input[1]", editcertificateinput);
			}catch(Exception e) 
			{
				
			}
			
		}
		
		
	
	
	}
	
	public void SaveAndComplete() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//button[text()='Save and complete ']");
		Webclick("//button[text()='Save and complete ']");
		
	}
	
	
//	estimateAccept.Click_Choc_MenuButton();
	
	public void Diary_Details() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Details']");
		click("//*[@text='Details']");
	}
//	estimateAccept.Click_Choc_MenuButton();
//	certificate.Click_Certificate();
//	certificate.Click_CompletedCertificate();
	
	public void ViewOrPrint() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='View/print']");
		click("//*[@text='View/print']");
	}
	
	public void DrivePDFViewer() 
	{
		
		try 
		{
			ExplicitWait_ElementToBeClickable("//*[contains(@text,'PDF')]");
			click("//*[contains(@text,'PDF')]");
		}catch(Exception e) 
		{
			System.out.println("PDF doc is not visible");
		}
	}
	
	public void Verify_ModifiedInputInPDF(String editcertificateinput)// /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout
	{
		ThreeSec();
		ExplicitWait_PresenceOfEle("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout");
		
	    String pageSource = driver.getPageSource();
//	    System.out.println(pageSource);
	    if(pageSource.contains(editcertificateinput)) 
	    {
	    	System.out.println("Case pass");
	    }
	    Assert.assertTrue(pageSource.contains(editcertificateinput));
	    System.out.println("Assert verification is passed");
	}
	
	public void PDF_Back() 
	{
		ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageButton']");
		click("//*[@class='android.widget.ImageButton']");
	}
	
	
	
	
}
