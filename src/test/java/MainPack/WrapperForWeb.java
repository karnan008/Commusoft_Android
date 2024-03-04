package MainPack;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.RerunTestCase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WrapperForWeb {
	public  WebDriver driverWeb;
	
	
	
//	public void ConnectWeb() 
//	{
//		WebDriverManager.chromedriver().setup();
//		 driver2=new ChromeDriver();
//		driver2.manage().window().maximize();
//		
////		FiveSec();
//		driver2.get("https://app.commusoft.co.uk/");
//		driver2.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
////		FiveSec();
//	}
//	public void LoginInWeb() 
//	{
////		TenSec();
////		EightSec();
//		ConnectWeb();
//		ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
//		clickForWeb("//input[@id='logintype_clientid']");
////		TwoSec();
//		typeForWeb("//input[@id='logintype_clientid']", "16410");
//		ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
//		typeForWeb("//input[@id='logintype_username']", "Saravanan");
//		ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
//		typeForWeb("//input[@id='logintype_password']", "demo123");
//		ExplicitWait_ElementToBeClickable2("//span[text()='Log in']");
//		clickForWeb("//span[text()='Log in']");
//	}
	
	public void Webclick(String option)
	{
		
		//----------------------------> NORMAL CLICK <--------------------------------
//		{
//			if(option.contains("$"))
//			{
//				option = option.replace("$", "");
//				driverWeb.findElement(By.name(option)).click();
//
//			}
//			else if(option.contains("#"))
//			{
//				option = option.replace("#", "");
//				driverWeb.findElement(By.id(option)).click(); 
//			}
//			else if(option.contains("~"))
//			{
//				option = option.replace("~", "");
//				driverWeb.findElement(By.className(option)).click();
//			}
//			else
//			{
//				//option = option.replace("//", "");
//				driverWeb.findElement(By.xpath(option)).click();
//			}
//		}
		
		//------------------------------------------> RETRY CLICK BY USING WHILE LOOP <--------------------------
		 
//        String elementLocator =option;
//
//        retryClick(driverWeb, elementLocator, 3, 1000);
        
		
		//------------------------------------------> RETRY CLICK BY USING DO-WHILE LOOP <---------------------
        int attempt = 1;
        String message = null;

        do {
        	
        	
            try {
                WebElement button = driverWeb.findElement(By.xpath(option));
                try {
                Thread.sleep(1000);
                }catch(Exception e) 
                {
                	
                }
                button.click();
                
            } catch (Exception e) {
            	System.out.println("Click Catch");
                System.out.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
//                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
                message = e.getMessage();

                
                attempt++;
            }
            
        } while (message !=null && message.contains("no such element"));
	}
	// Retry click function
    private static WebElement retryClick(WebDriver driver, String xpath, int maxAttempts, long intervalMillis) {
        int attempts = 0;
        WebElement element = null;

        while (attempts < maxAttempts) {
            try {
                // Find the element
                element = driver.findElement(By.xpath(xpath));

                // Click the element
                element.click();

                // If the click is successful, break out of the loop
                break;
            } catch (Exception e) {
                // Print any exception (for debugging purposes)
            	 System.err.println("Attempt " + attempts + ": Exception caught - " + e.getMessage());

                // Increment the attempts counter
                attempts++;
                // Wait for the specified interval before retrying
                try {
                    Thread.sleep(intervalMillis);
                } catch (InterruptedException ignored) {
                }
            }
        }

        return element;
    }
	

	
	public void typeForWeb(String xpath, String value)
	{
		
		//----------------------------> NORMAL TYPE <--------------------------------
//		{
//			if(xpath.contains("$"))
//			{
//				xpath = xpath.replace("$", "");
//				driverWeb.findElement(By.name(xpath)).sendKeys(value);
//
//			}
//			else if(xpath.contains("#"))
//			{
//				xpath = xpath.replace("#", "");
//				driverWeb.findElement(By.id(xpath)).sendKeys(value); 
//			}
//			else if(xpath.contains("~"))
//			{
//				xpath = xpath.replace("~", "");
//				driverWeb.findElement(By.className(xpath)).sendKeys(value);
//			}
//			else
//			{
//				driverWeb.findElement(By.xpath(xpath)).sendKeys(value);
//			}
//		}
		
		//------------------------------------------> RETRY TYPE BY USING WHILE LOOP <--------------------------
//        String elementLocator =xpath;
//
//        retryType(driverWeb, elementLocator, 3, 1000, value);
        
      //------------------------------------------> RETRY TYPE BY USING DO-WHILE LOOP <---------------------
        int attempt = 1;
        String message = null;

        do {
        	
            try {
                WebElement enter = driverWeb.findElement(By.xpath(xpath));
                try {
                Thread.sleep(1000);
                }catch(Exception e) 
                {
                	
                }
                enter.sendKeys(value);
                
            } catch (Exception e) {
                System.out.println("Type Catch");
                System.err.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
//                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
                message = e.getMessage();

                
                attempt++;
            }
            
        } while (message !=null && message.contains("no such element"));
	}
	
    private static WebElement retryType(WebDriver driver, String xpath, int maxAttempts, long intervalMillis,String sendKeys) {
        int attempts = 0;
        WebElement element = null;

        while (attempts < maxAttempts) {
            try {
                // Find the element
                element = driver.findElement(By.xpath(xpath));

                // Click the element
                element.sendKeys(sendKeys);

                // If the click is successful, break out of the loop
                break;
            } catch (Exception e) {
                // Print any exception (for debugging purposes)
            	System.err.println("Attempt " + attempts + ": Exception caught - " + e.getMessage());

                // Increment the attempts counter
                attempts++;
                // Wait for the specified interval before retrying
                try {
                    Thread.sleep(intervalMillis);
                } catch (InterruptedException ignored) {
                }
            }
        }

        return element;
    }
	public void WebClear(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				driverWeb.findElement(By.name(xpath)).clear();

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				driverWeb.findElement(By.id(xpath)).clear(); 
			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				driverWeb.findElement(By.className(xpath)).clear();
			}
			else
			{
				driverWeb.findElement(By.xpath(xpath)).clear();
			}
		}
	}
	
	public void Webtypeenter(String xpath)
	{
		{
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				driverWeb.findElement(By.name(xpath)).sendKeys(Keys.ENTER);

			}
			else if(xpath.contains("#"))
			{
				xpath = xpath.replace("#", "");
				driverWeb.findElement(By.id(xpath)).sendKeys(Keys.ENTER); 

			}
			else if(xpath.contains("~"))
			{
				xpath = xpath.replace("~", "");
				driverWeb.findElement(By.className(xpath)).sendKeys(Keys.ENTER);

			}
			else
			{
				//xpath = xpath.replace("//", "");
				driverWeb.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
			}
		}
	}
	
	public void ExplicitWait_PresenceOfEle2(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driverWeb, 40);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public void ExplicitWait_VisibilityOfEle2(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driverWeb, 40);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

	}

	public void ExplicitWait_ElementToBeClickable2(String xpath) 
	{
		WebDriverWait wait=new WebDriverWait(driverWeb, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
//	public void Enter() 
//	{
//		try {
//			Robot robot = new Robot();
//			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//			robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
//			robot.delay(5000);
//			
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public void AssertEquals(String actual, String expected) 
	{
		Assert.assertEquals(actual, expected);
		
	}
	
	public void WebOneSec() 
	{

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driverWeb.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	public void WebTwoSec() 
	{

//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driverWeb.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	public void WebThreeSec() 
	{

//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driverWeb.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	public void WebFiveSec() 
	{

//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driverWeb.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	public void AssertTrueWeb(String xpath) 
	{
		WebElement ele=driverWeb.findElement(By.xpath(xpath));
		Assert.assertTrue(ele.isDisplayed());
	}
	
	public void ScrollWeb(String xpath) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driverWeb;
		WebElement findElement = driverWeb.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].scrollIntoView(true);", findElement);
		
	}
	
	public void selectdropdown(String xpath, String value)
	{
		if(xpath.contains("#"))
		{
			xpath = xpath.replace("#", "");
			Select sc = new Select(driverWeb.findElement(By.id(xpath)));
			sc.selectByVisibleText(value);
		}else
			if(xpath.contains("$"))
			{
				xpath = xpath.replace("$", "");
				Select sc = new Select(driverWeb.findElement(By.name(xpath)));
				sc.selectByVisibleText(value);
			}else
			{
				Select fcc = new Select(driverWeb.findElement(By.xpath(xpath)));
				fcc.selectByVisibleText(value);
			}
		
	}
	
	public void Assertion(String ER , String AR, String R)
	{
		Assert.assertEquals(AR, ER,R);
	}
	
	public void WebActionClick(String xpath) 
	{
		Actions actions = new Actions(driverWeb);
		WebElement findElement = driverWeb.findElement(By.xpath(xpath));
		actions.moveToElement(findElement).click(findElement).build().perform();
	}
	
	public void WebJavaScriptClick(String xpath) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driverWeb;
		WebElement findElement = driverWeb.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].click()",findElement);
	}

	public void Refresh() 
	{
		driverWeb.navigate().refresh();
	}
	
	public void Owner_Login()
	{
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
		Webclick("//input[@id='logintype_clientid']");
		typeForWeb("//input[@id='logintype_clientid']", "16410");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
		typeForWeb("//input[@id='logintype_username']", "Saravanan");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
		typeForWeb("//input[@id='logintype_password']", "demo123");
		ExplicitWait_ElementToBeClickable2("//span[text()='Log in']");
		Webclick("//span[text()='Log in']");
		
	
	}
	public void Logout() 
	{
		WebThreeSec();
		ExplicitWait_PresenceOfEle2("//img[@id='usrpicofcorner']");
		Webclick("//img[@id='usrpicofcorner']");
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//a[text()='Logout']");
		Webclick("//a[text()='Logout']");
	}
	public void Officestaff_Login()
	{
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
		Webclick("//input[@id='logintype_clientid']");
		typeForWeb("//input[@id='logintype_clientid']", "16410");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
		typeForWeb("//input[@id='logintype_username']", "Officestaff");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
		typeForWeb("//input[@id='logintype_password']", "demo123");
		ExplicitWait_ElementToBeClickable2("//span[text()='Log in']");
		Webclick("//span[text()='Log in']");
		
	
	}
	
	public void AlertMessage(String notCompletedAlertMessage) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driverWeb;
        js.executeScript("alert('"+notCompletedAlertMessage+"');");
	}
	public void AcceptAlert() 
	{
		WebFiveSec();
		Alert alert = driverWeb.switchTo().alert();
		alert.accept();
		
	}
	public void DismissAlert() 
	{
		WebFiveSec();
		Alert alert = driverWeb.switchTo().alert();
		alert.dismiss();
		
	}
	public void SelectByVisibileText(String webelementxpath,String text) 
	{
		WebElement ele = driverWeb.findElement(By.xpath(webelementxpath));
		Select select = new Select(ele);
		
		select.selectByVisibleText(text);
	}
	public void SelectByIndex(String webelementxpath, int index) 
	{
		WebElement ele = driverWeb.findElement(By.xpath(webelementxpath));
		Select select = new Select(ele);
		
		select.selectByIndex(index);
	}
	
	public void WebDoubleClick(String xpath) //span[text()='Pricing items']
	{
		Actions actions = new Actions(driverWeb);
		WebElement ele = driverWeb.findElement(By.xpath(xpath));
		actions.doubleClick(ele).build().perform();
	}
	
	public void PageRefresh() 
	{
		driverWeb.navigate().refresh();
	}
	
	//---------------------------------------------------------------------
	public int i;
	 public void demoClick2(String xpath)
	    {
		 
		 
		 int maxRetries = 3;

	        for (int i = 1; i <= maxRetries; i++) {
	            try {
	               
	                WebElement element = driverWeb.findElement(By.xpath(xpath));
	                element.click();
	                
	                // If the above steps succeed, break out of the loop
	                break;
	            } catch (Exception e) {
	                System.out.println("Attempt " + i + " failed. Retrying...");
	                e.printStackTrace();
	                
	                // You might want to add a delay between retries
	                // Thread.sleep(1000);
	            }
	        }
		 
	    }
	 
	 public void demoClickWeb(String xpath) 
	 {
	        int attempt = 1;
	        String message = null;

	        do {
	        	
	        	System.out.println("Do");
	            try {
	                WebElement button = driverWeb.findElement(By.xpath(xpath));
	                Thread.sleep(1000);
	                button.click();
	                
	            } catch (Exception e) {
	                
	                System.out.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
//	                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
	                message = e.getMessage();

	                
	                attempt++;
	            }
	            
	        } while (message !=null && message.contains("no such element"));
//	        (message !=null && message.contains("no such element")) || (message !=null && message.contains("element click intercepted"))
	        
	        
	 }
	 
	 public void demoClickWeb_JavaScript(String xpath) 
	 {
	        int attempt = 1;
	        String message = null;

	        do {
	        	
	            try {
	                WebElement button = driverWeb.findElement(By.xpath(xpath));
	                ExplicitWait_PresenceOfEle2(xpath);
	                button.click();
	                
	            } catch (Exception e) {
	                
	                System.err.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
//	                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
	                message = e.getMessage();

	                
	                attempt++;
	            }
	            
	        } while (message !=null && message.contains("no such element"));
//	        (message !=null && message.contains("no such element")) || (message !=null && message.contains("element click intercepted"))
	        
	        
	 }
	 
	 
	 
	 public void demoTypeWeb(String xpath,String sendKeys) 
	 {
	        int attempt = 1;
	        String message = null;

	        do {
	        	
	            try {
	                WebElement enter = driverWeb.findElement(By.xpath(xpath));
//	                button.click();
	                enter.sendKeys(sendKeys);
	                
	            } catch (Exception e) {
	                
	                System.err.println("Attempt " + attempt + ": Exception caught - " + e.getMessage());
//	                System.out.println("ATTEMPT "+attempt+ " FAILED. RETRYING....");
	                message = e.getMessage();

	                
	                attempt++;
	            }
	            
	        } while (message !=null && message.contains("no such element"));
//	        element click intercepted
	        
	        
	 }
	 
	
}
