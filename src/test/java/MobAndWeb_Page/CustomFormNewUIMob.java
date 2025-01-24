package MobAndWeb_Page;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CustomFormNewUIMob extends Wrapper{

	public CustomFormNewUIMob(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver = sdriver;
	}

	public void EnableNewCustomForms() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Labs']");		


		String assetYesOrNo = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView")).getText();

		if(assetYesOrNo.equals("No"))
			click("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView");
		else
			System.out.println("Already the custom form enabled");


	}

	public void Select_Form(String type) 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='"+type+"']");
		click("//*[@text='"+type+"']");
	}

	public void Click_Next() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Next']");
		click("//*[@text='Next']");
	}

	public void Next_InputType(String certificateinput) //Next
	{

		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.TextView'])[last()]");
		String NextORFinish = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[last()]")).getText();



		while(NextORFinish.equals("Next"))// (//*[contains(@resource-id,'com.commusoft.v4:id')])[6]
		{  

			click("//*[@text='Next']");

			NextORFinish = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[last()]")).getText();

			try 
			{
				MobileElement displayed = driver.findElement(By.xpath("(//*[contains(@text,'put')])[1]"));
				boolean input = displayed.isDisplayed();
				System.out.println("Input Field is displayed: "+input);
				type("(//*[@text='Type here'])[1]", certificateinput);
			}catch(Exception e) 
			{

			}	

		}



	}

	public void BackForDraft() 
	{
		ExplicitWait_ElementToBeClickable("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ImageView");
		MobileElement backButton = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ImageView"));


		while(backButton.isDisplayed()) 
		{
			click("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ImageView");

			String pageSource = driver.getPageSource();
			System.out.println(pageSource);

			if(pageSource.contains("Save draft and close")) 
			{
				OneSec();
				click("//*[@text='Save draft and close']");
				break;
			}else
			{
				System.out.println("Save Draft and close is not displayed");
			}

			backButton = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ImageView"));

		}


	}

	public void WaitForCertificate() 
	{
		ExplicitWait_ElementToBeClickable("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View");
	}
	public void Verify_DeletedCustomForm() //*[@text='There are currently no assets saved against this property, click to add one']
	{
		ExplicitWait_PresenceOfEle("(//*[@class='android.widget.TextView'])[1]");
		MobileElement Expected = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]"));

		Verify_AssertTrue(Expected);

	}

	public void Click_FirstCertificate() 
	{
		ExplicitWait_ElementToBeClickable("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View");
		click("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View");
	}

	public void Clone() 
	{
		ExplicitWait_ElementToBeClickable("//*[@text='Clone']");
		click("//*[@text='Clone']");
	}

	public void Verify_ClonedCertificate() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Certificates']");
		MobileElement clonedCertificate = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View"));
		MobileElement addedCertificate = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View"));
		
		OneSec();
		Verify_AssertTrue(clonedCertificate);
		Verify_AssertTrue(addedCertificate);
	}

	public void Close_NotSync_BottomSheet() 
	{
		ThreeSec();

		String pageSource = driver.getPageSource();
		if(pageSource.contains("Close")) 
		{
			click("//android.widget.TextView[@text='Close']");
		}else 
		{
			System.out.println("Bottom sheet not opened");
		}

	}

	public void Verify_CertificateNumber() 
	{
		ExplicitWait_PresenceOfEle("(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/*)[1]");
		String certificateGetNumber = driver.findElement(By.xpath("(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/*)[1]")).getText();
		System.out.println("Certificate Number In New UI is: "+certificateGetNumber);

	}
}
