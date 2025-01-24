package MobAndWeb_Page;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class RemoveEngineerEvents extends Wrapper{

	public RemoveEngineerEvents(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver = sdriver;
	}

	public String emptyPage;


	public void RemoveEvent() throws InterruptedException 
	{

		do {

			//Click all back button
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();

			//Home screen 
			ExplicitWait_ElementToBeClickable("//*[@text='Home']");
			click("//*[@text='Home']"); 

			//Search tab
			ExplicitWait_ElementToBeClickable("//*[@text='Search']");
			click("//*[@text='Search']"); 

			//Search customer
			ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
			clear("//*[@class='android.widget.EditText']");
			customernumber = System.getProperty("customernumber");
			MobileElement num = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
			num.sendKeys(customernumber);
			ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[1]");
			click("(//*[@class='android.widget.ImageView'])[1]");

			//Select customer
			ThreeSec();
			ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[4]");
			click("(//*[@class='android.view.View'])[4]");

			//Menu
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
			click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");

			//Ongoing click
			ExplicitWait_PresenceOfEle("//*[@text='On going work']");
			click("//*[@text='On going work']");
			//			TwoSec();
			OneSec();
			emptyPage = driver.getPageSource();
			//			System.out.println(emptyPage);


			while(emptyPage.contains("Estimate No:") || emptyPage.contains("Job No:")) {

				ExplicitWait_PresenceOfEle("(//*[contains(@text,'No:')])[1]");
				click("(//*[contains(@text,'No:')])[1]");

				ExplicitWait_ElementToBeClickable("//*[contains(@text,'umber')]");
				String pageSource = driver.getPageSource();

				if(pageSource.contains("Abort job")) {

					//Menu
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					//Diary hoistory
					ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
					click("//*[@text='Diary history']");


					ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
					//					OneSec();
					pageSource = driver.getPageSource();
					if(pageSource.contains("There is no diary history"))
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}
					else{

						ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
						List<MobileElement> elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

						for (int i = 0; i < elements.size(); i++) {
							// Re-fetch the list to avoid stale elements after any action

							System.out.println("How many cards are appeared? "+elements.size());
							elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

							try {
								MobileElement ListOfElements = elements.get(i);
								ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
								String attribute = ListOfElements.getAttribute("class");


								ListOfElements.click();

								ExplicitWait_PresenceOfEle("//*[@text='View diary event']");
								pageSource = driver.getPageSource();
								if (pageSource.contains("Diary time tracking")) {

									click("//*[@text='View diary event']");


								} else {
									ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
									click("//*[@text='Edit']");

									// Click Delete
									ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.Button'])[2]");
									click("(//*[@class='android.widget.Button'])[2]");

									// Click confirm Delete
									ExplicitWait_ElementToBeClickable("//*[@text='Delete']");
									click("//*[@text='Delete']");
									TwoSec();
									Swipe(452, 298, 446, 94);


									i--;

								}
							}catch(Exception e) 
							{
								ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
								click("//*[@text='Diary history']");
							}
						}
						//========================================================================
					}

					OneSec();
					pageSource = driver.getPageSource();

					if(pageSource.contains("Diary history")) 
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}else 
					{
						System.out.println("");
					}

					ExplicitWait_ElementToBeClickable("//*[@text='Abort job']");
					click("//*[@text='Abort job']");
					ExplicitWait_ElementToBeClickable("//*[@text='Tap To Select. . .']");
					click("//*[@text='Tap To Select. . .']");
					ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
					click("(//*[@resource-id='android:id/text1'])[2]");
					ThreeSec();
					ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					//Click back button in job screen
					ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageButton']");
					click("//*[@class='android.widget.ImageButton']");
				}
				else if(pageSource.contains("Tap on the green bar for further actions"))	{

					//Menu
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					//Diary hoistory
					ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
					click("//*[@text='Diary history']");


					ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
					pageSource = driver.getPageSource();

					if(pageSource.contains("There is no diary history"))
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}
					else{

						ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
						List<MobileElement> elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

						for (int i = 0; i < elements.size(); i++) {
							// Re-fetch the list to avoid stale elements after any action

							System.out.println("How many cards are appeared? "+elements.size());
							elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

							try {
								MobileElement ListOfElements = elements.get(i);
								ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
								String attribute = ListOfElements.getAttribute("class");


								ListOfElements.click();

								ExplicitWait_PresenceOfEle("//*[@text='View diary event']");
								pageSource = driver.getPageSource();
								if (pageSource.contains("Diary time tracking")) {

									click("//*[@text='View diary event']");


								} else {
									ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
									click("//*[@text='Edit']");

									// Click Delete
									ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.Button'])[2]");
									click("(//*[@class='android.widget.Button'])[2]");

									// Click confirm Delete
									ExplicitWait_ElementToBeClickable("//*[@text='Delete']");
									click("//*[@text='Delete']");
									TwoSec();
									Swipe(452, 298, 446, 94);


									i--;

								}
							}catch(Exception e) 
							{
								ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
								click("//*[@text='Diary history']");
							}
						}
						//========================================================================
					}

					ExplicitWait_PresenceOfEle("//*[contains(@text,'Tap on the green bar for further actions')]");
					click("//*[contains(@text,'Tap on the green bar for further actions')]");
					ExplicitWait_ElementToBeClickable("//*[@text='Free of charge job']");
					click("//*[@text='Free of charge job']");
					ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Spinner']");
					click("//*[@class='android.widget.Spinner']");
					ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
					click("(//*[@resource-id='android:id/text1'])[2]");
					ThreeSec();
					ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					//Click back button in job screen
					click("//*[@class='android.widget.ImageButton']");
				}
				else if(pageSource.contains("Estimate description")) 
				{
					//Menu
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					//Diary hoistory
					ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
					click("//*[@text='Diary history']");


					ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
					pageSource = driver.getPageSource();

					if(pageSource.contains("There is no diary history")) 
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}
					else
					{

						ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
						List<MobileElement> elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

						for (int i = 0; i < elements.size(); i++) {
							// Re-fetch the list to avoid stale elements after any action

							System.out.println("How many cards are appeared? "+elements.size());
							elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

							try {
								MobileElement ListOfElements = elements.get(i);
								ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
								String attribute = ListOfElements.getAttribute("class");


								ListOfElements.click();

								ExplicitWait_PresenceOfEle("//*[@text='View diary event']");
								pageSource = driver.getPageSource();
								if (pageSource.contains("Diary time tracking")) {

									click("//*[@text='View diary event']");


								} else {
									ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
									click("//*[@text='Edit']");

									// Click Delete
									ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.Button'])[2]");
									click("(//*[@class='android.widget.Button'])[2]");

									// Click confirm Delete
									ExplicitWait_ElementToBeClickable("//*[@text='Delete']");
									click("//*[@text='Delete']");
									TwoSec();
									Swipe(452, 298, 446, 94);


									i--;

								}
							}catch(Exception e) 
							{
								ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
								click("//*[@text='Diary history']");
							}
						}
						//========================================================================
					}
					FiveSec();
					OneSec();
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");//menu
					ExplicitWait_ElementToBeClickable("(//*[@text='Estimate'])[2]");
					click("(//*[@text='Estimate'])[2]");//estimate click in bottom sheet
					ExplicitWait_ElementToBeClickable("//*[@text='Price']"); 
					click("//*[@text='Price']");//price
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinner_pricingbreakdown']");
					click("//*[@resource-id='com.commusoft.v4:id/spinner_pricingbreakdown']");//Full breakdown dropdown click
					ExplicitWait_ElementToBeClickable("//android.widget.CheckedTextView[@text='No Breakdown']");
					click("//android.widget.CheckedTextView[@text='No Breakdown']");//Select no breakdown
					type("#com.commusoft.v4:id/totalValue", "100");// Type amount
					ExplicitWait_ElementToBeClickable("//*[@content-desc='Save'] ");
					click("//*[@content-desc='Save'] ");//Click save button
					ExplicitWait_ElementToBeClickable("//*[@text='Invoice Schedule']");
					click("//*[@text='Invoice Schedule']");//Invoice schedule
					ExplicitWait_ElementToBeClickable("//*[@content-desc='Save'] ");
					click("//*[@content-desc='Save'] ");//Click save button
					ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Accept/Reject']");
					click("//android.widget.TextView[@text='Accept/Reject']");//Click accept/reject button
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/estimateOptionCheckboxView']");
					click("//*[@resource-id='com.commusoft.v4:id/estimateOptionCheckboxView']");//Estimate checkbox
					ExplicitWait_ElementToBeClickable("//*[@text='ACCEPT']");
					click("//*[@text='ACCEPT']");//Click accept
					ExplicitWait_ElementToBeClickable("//*[@text='YES']");
					click("//*[@text='YES']");//Click Yes
					ScrollDown24("ACCEPT");
					Estimatesignature(361, 1743, 718, 1686);
					ExplicitWait_ElementToBeClickable("//*[@text='ACCEPT']");
					click("//*[@text='ACCEPT']");// Click accept

				}


				//				TwoSec();
				OneSec();
				emptyPage = driver.getPageSource();
				//				System.out.println(emptyPage);
			}

			//Menu
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
			click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
			ExplicitWait_PresenceOfEle("//*[@text='On going work']");
			click("//*[@text='On going work']");
			OneSec();
			emptyPage = driver.getPageSource();
			//			System.out.println(emptyPage);

		}while(emptyPage.contains("Estimate No:") || emptyPage.contains("Job No:")) ;







	}


	public void Demo() throws InterruptedException 
	{

		do {

			//Click all back button
			Click_NavigateUp_BackButton();
			Click_MenuClosed_BackButton();

			//Home screen 
			ExplicitWait_ElementToBeClickable("//*[@text='Home']");
			click("//*[@text='Home']"); 

			//Search tab
			ExplicitWait_ElementToBeClickable("//*[@text='Search']");
			click("//*[@text='Search']"); 

			//Search customer
			ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");
			clear("//*[@class='android.widget.EditText']");
			//			customernumber = System.getProperty("customernumber");
			//			MobileElement num = driver.findElement(By.xpath("//*[@class='android.widget.EditText']"));
			//			num.sendKeys(customernumber);
			//			ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[1]");
			//			click("(//*[@class='android.widget.ImageView'])[1]");

			//======================================
			//Pass Customer
			ExplicitWait_PresenceOfEle("//*[@class='android.widget.EditText']");			
			type("//*[@class='android.widget.EditText']", "4743");
			Thread.sleep(2000);
			ExplicitWait_PresenceOfEle("(//*[@class='android.widget.ImageView'])[1]");
			click("(//*[@class='android.widget.ImageView'])[1]");

			//======================================

			//Select customer
			ThreeSec();
			ExplicitWait_PresenceOfEle("(//*[@class='android.view.View'])[4]");
			click("(//*[@class='android.view.View'])[4]");

			//Menu
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
			click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");

			//Ongoing click
			ExplicitWait_PresenceOfEle("//*[@text='On going work']");
			click("//*[@text='On going work']");
			//			TwoSec();
			OneSec();
			emptyPage = driver.getPageSource();
			//			System.out.println(emptyPage);


			while(emptyPage.contains("Estimate No:") || emptyPage.contains("Job No:")) {

				ExplicitWait_PresenceOfEle("(//*[contains(@text,'No:')])[1]");
				click("(//*[contains(@text,'No:')])[1]");

				ExplicitWait_ElementToBeClickable("//*[contains(@text,'umber')]");
				String pageSource = driver.getPageSource();

				if(pageSource.contains("Abort job")) {

					//Menu
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					//Diary hoistory
					ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
					click("//*[@text='Diary history']");


					ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
					//					OneSec();
					pageSource = driver.getPageSource();
					if(pageSource.contains("There is no diary history"))
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}
					else{

						ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
						List<MobileElement> elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

						for (int i = 0; i < elements.size(); i++) {
							// Re-fetch the list to avoid stale elements after any action

							System.out.println("How many cards are appeared? "+elements.size());
							elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

							try {
								MobileElement ListOfElements = elements.get(i);
								ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
								String attribute = ListOfElements.getAttribute("class");


								ListOfElements.click();

								ExplicitWait_PresenceOfEle("//*[@text='View diary event']");
								pageSource = driver.getPageSource();
								if (pageSource.contains("Diary time tracking")) {

									click("//*[@text='View diary event']");


								} else {
									ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
									click("//*[@text='Edit']");

									// Click Delete
									ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.Button'])[2]");
									click("(//*[@class='android.widget.Button'])[2]");

									// Click confirm Delete
									ExplicitWait_ElementToBeClickable("//*[@text='Delete']");
									click("//*[@text='Delete']");
									TwoSec();
									Swipe(452, 298, 446, 94);


									i--;

								}
							}catch(Exception e) 
							{
								ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
								click("//*[@text='Diary history']");
							}
						}
						//========================================================================
					}

					OneSec();
					pageSource = driver.getPageSource();

					if(pageSource.contains("Diary history")) 
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}else 
					{
						System.out.println("");
					}

					ExplicitWait_ElementToBeClickable("//*[@text='Abort job']");
					click("//*[@text='Abort job']");
					ExplicitWait_ElementToBeClickable("//*[@text='Tap To Select. . .']");
					click("//*[@text='Tap To Select. . .']");
					ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
					click("(//*[@resource-id='android:id/text1'])[2]");
					ThreeSec();
					ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					//Click back button in job screen
					ExplicitWait_ElementToBeClickable("//*[@class='android.widget.ImageButton']");
					click("//*[@class='android.widget.ImageButton']");
				}
				else if(pageSource.contains("Tap on the green bar for further actions"))	{

					//Menu
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					//Diary hoistory
					ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
					click("//*[@text='Diary history']");


					ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
					pageSource = driver.getPageSource();

					if(pageSource.contains("There is no diary history"))
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}
					else{

						ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
						List<MobileElement> elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

						for (int i = 0; i < elements.size(); i++) {
							// Re-fetch the list to avoid stale elements after any action

							System.out.println("How many cards are appeared? "+elements.size());
							elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

							try {
								MobileElement ListOfElements = elements.get(i);
								ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
								String attribute = ListOfElements.getAttribute("class");


								ListOfElements.click();

								ExplicitWait_PresenceOfEle("//*[@text='View diary event']");
								pageSource = driver.getPageSource();
								if (pageSource.contains("Diary time tracking")) {

									click("//*[@text='View diary event']");


								} else {
									ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
									click("//*[@text='Edit']");

									// Click Delete
									ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.Button'])[2]");
									click("(//*[@class='android.widget.Button'])[2]");

									// Click confirm Delete
									ExplicitWait_ElementToBeClickable("//*[@text='Delete']");
									click("//*[@text='Delete']");
									TwoSec();
									Swipe(452, 298, 446, 94);


									i--;

								}
							}catch(Exception e) 
							{
								ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
								click("//*[@text='Diary history']");
							}
						}
						//========================================================================
					}

					ExplicitWait_PresenceOfEle("//*[contains(@text,'Tap on the green bar for further actions')]");
					click("//*[contains(@text,'Tap on the green bar for further actions')]");
					ExplicitWait_ElementToBeClickable("//*[@text='Free of charge job']");
					click("//*[@text='Free of charge job']");
					ExplicitWait_ElementToBeClickable("//*[@class='android.widget.Spinner']");
					click("//*[@class='android.widget.Spinner']");
					ExplicitWait_ElementToBeClickable("(//*[@resource-id='android:id/text1'])[2]");
					click("(//*[@resource-id='android:id/text1'])[2]");
					ThreeSec();
					ExplicitWait_ElementToBeClickable("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					click("//android.widget.Button[@resource-id='com.commusoft.v4:id/save']");
					//Click back button in job screen
					click("//*[@class='android.widget.ImageButton']");
				}
				else if(pageSource.contains("Estimate description")) 
				{
					//Menu
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					//Diary hoistory
					ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
					click("//*[@text='Diary history']");


					ExplicitWait_ElementToBeClickable("//*[@text='Diary history']");
					pageSource = driver.getPageSource();

					if(pageSource.contains("There is no diary history")) 
					{
						ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
						click("//*[@text='Diary history']");
					}
					else
					{

						ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
						List<MobileElement> elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

						for (int i = 0; i < elements.size(); i++) {
							// Re-fetch the list to avoid stale elements after any action

							System.out.println("How many cards are appeared? "+elements.size());
							elements = driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));

							try {
								MobileElement ListOfElements = elements.get(i);
								ExplicitWait_PresenceOfEle("//*[contains(@text,'am')]");
								String attribute = ListOfElements.getAttribute("class");


								ListOfElements.click();

								ExplicitWait_PresenceOfEle("//*[@text='View diary event']");
								pageSource = driver.getPageSource();
								if (pageSource.contains("Diary time tracking")) {

									click("//*[@text='View diary event']");


								} else {
									ExplicitWait_ElementToBeClickable("//*[@text='Edit']");
									click("//*[@text='Edit']");

									// Click Delete
									ExplicitWait_ElementToBeClickable("(//*[@class='android.widget.Button'])[2]");
									click("(//*[@class='android.widget.Button'])[2]");

									// Click confirm Delete
									ExplicitWait_ElementToBeClickable("//*[@text='Delete']");
									click("//*[@text='Delete']");
									TwoSec();
									Swipe(452, 298, 446, 94);


									i--;

								}
							}catch(Exception e) 
							{
								ExplicitWait_PresenceOfEle("//*[@text='Diary history']");
								click("//*[@text='Diary history']");
							}
						}
						//========================================================================
					}
					FiveSec();
					OneSec();
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
					click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");//menu
					ExplicitWait_ElementToBeClickable("(//*[@text='Estimate'])[2]");
					click("(//*[@text='Estimate'])[2]");//estimate click in bottom sheet
					ExplicitWait_ElementToBeClickable("//*[@text='Price']"); 
					click("//*[@text='Price']");//price
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/spinner_pricingbreakdown']");
					click("//*[@resource-id='com.commusoft.v4:id/spinner_pricingbreakdown']");//Full breakdown dropdown click
					ExplicitWait_ElementToBeClickable("//android.widget.CheckedTextView[@text='No Breakdown']");
					click("//android.widget.CheckedTextView[@text='No Breakdown']");//Select no breakdown
					type("#com.commusoft.v4:id/totalValue", "100");// Type amount
					ExplicitWait_ElementToBeClickable("//*[@content-desc='Save'] ");
					click("//*[@content-desc='Save'] ");//Click save button
					ExplicitWait_ElementToBeClickable("//*[@text='Invoice Schedule']");
					click("//*[@text='Invoice Schedule']");//Invoice schedule
					ExplicitWait_ElementToBeClickable("//*[@content-desc='Save'] ");
					click("//*[@content-desc='Save'] ");//Click save button
					ExplicitWait_ElementToBeClickable("//android.widget.TextView[@text='Accept/Reject']");
					click("//android.widget.TextView[@text='Accept/Reject']");//Click accept/reject button
					ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/estimateOptionCheckboxView']");
					click("//*[@resource-id='com.commusoft.v4:id/estimateOptionCheckboxView']");//Estimate checkbox
					ExplicitWait_ElementToBeClickable("//*[@text='ACCEPT']");
					click("//*[@text='ACCEPT']");//Click accept
					ExplicitWait_ElementToBeClickable("//*[@text='YES']");
					click("//*[@text='YES']");//Click Yes
					ScrollDown24("ACCEPT");
					Estimatesignature(361, 1743, 718, 1686);
					ExplicitWait_ElementToBeClickable("//*[@text='ACCEPT']");
					click("//*[@text='ACCEPT']");// Click accept

				}


				//				TwoSec();
				OneSec();
				emptyPage = driver.getPageSource();
				//				System.out.println(emptyPage);
			}

			//Menu
			ExplicitWait_ElementToBeClickable("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
			click("//*[@resource-id='com.commusoft.v4:id/design_bottom_shee']");
			ExplicitWait_PresenceOfEle("//*[@text='On going work']");
			click("//*[@text='On going work']");
			OneSec();
			emptyPage = driver.getPageSource();
			//			System.out.println(emptyPage);

		}while(emptyPage.contains("Estimate No:") || emptyPage.contains("Job No:")) ;







	}


	public void CloseTheAppWhenItWasCrashed() 
	{
		ExplicitWait_PresenceOfEle("//*[@text='Wait']");
		click("//*[@text='OK']");
	}


}
