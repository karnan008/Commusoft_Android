package MainPack;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.ActivityCapture;
import Utility.ExcelReader;
import Utility.MobEventListener;
import Utility.Screenshot;
import Utility.WebEventListener;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommusoftDevBaseClass extends Wrapper{
	
	
	
	

	

	public String simpleName;
	public String Running_UserName;
	
	public ExtentReports report;
	public  ExtentTest logger;
	public static WebEventListener webEventListener;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static MobEventListener mobEventListener;
	
	
	public  String CustomerName = "Kari Athi";
	public  String TitleCustomerName = "Mr Kari Athi";
	public  String FirstName = "Kari";
	public  String LastName = "Athi";
	public  String WorkAddressLastName="For Automation";
	public  String Title = "Mr & Mrs";//Mr & Mrs
	public  String EstimateDescription = "Estimate template_Nametag";
	public  String Breakdown = "No Breakdown";
	public  String JobDescription = "COUCH";
	public String WAName = "Karikalan";
	public String WorkAddressName="Work Adress";
	public String Name="S";
	public String Surname="And Mobile Automation";//
	public String WebContact="WebContact";
	public String EditName="EditMobileAutomation";//
	public String EditLandline="15246789";
	public String EditMob="789456123";
	public String EditEmail="ssaravanan@commusoft.com";
	public String EditAddress1="Edit Address line 1";
	public String NoteTitle="Title For Note";
	public String Note="Notes Description";
	public String NoteForPhoneCall="Note For Phone Call";
	public String SubjectForEmail="Subject For Email";
	public String MessageForSMS="Message For SMS";
	public String PhotoFileName="Photo";
	public String VideoFileName="Video";
	public String AudioFileName="Audio";
	public String EditWorkAddressName="EditWorkAddress";
	public String EditWorkAddressEmail="EditWorkaddress@gmail.com";
	public String AssetName="System boiler";
	public String UserName="Saravanan S";//  Saravanan S
	public String Estimate="Estimate";
	public String TypeCertificate="property survey";
	public String Preinvoice="Preinvoice";
	public String Invoice="Invoice";
	public String PartName="NewPart3012";
	public String PassCustomerNumber="2821";
	public String PassEstimateNumber="5356";
	public String PassJobNumber="5280";
	public String PassjobNumber="5356";
	public String V4URL="https://app.commusoft.co.uk/";
	public String PickUpPartName="PartForPickup";
	public String WebName="Web";
	public String WebAddress="WebAddress";
	public String WebEmail="ssaravanan@commusoft.com";
	public String WebWoraddressName="WebWorkAddress";
	public String WebWorkAddressEmail="WebWorkaddress@gmail.com";
	public String CustomerContact="MobContact";
	public String CustomerEmail="ssaravanan@commusoft.com";
	public String Address="Address1";
	public String EditWebCustomerName="EditWebAutomation";
	public String WebEmailSub="WebEmailSub";
	public String AllFieldsCertificate="All fields (Added Normal List Screen)";
	public String AutomationCertificate="Automation";
	public String ComposeEmail="ComposeEmail";
	public String CertificateInput="Certificate";
	public String EditCertificateInput="Edit Certificate";
	public String AutomationNewQuestionTemplate="AutomationNewQuestionTemplate";
	public String PrefinalTest="PrefinalTest";
	public String AutomationOldQuestionTemplate="AutomationOldQuestionTemplate";
	public String Finalinvoice="Final invoice";
	public String InvoiceDes="InvoiceDescription";
	public String Subtotal100="100";
	public String Vat20="20.00";
	public String Others="Others";
	public String ArriveAnswer="Answer for arrive question";
	public String LeaveAnswer="Answers for Leave Questions";
	public String OfficeStaffRole="@Office";
	public String AutomationPricingItem="Automation Pricing Item";
	
	
	AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    
	
	@BeforeTest(alwaysRun = true)
	public void setup()
	{

		try {
			
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.VERSION, "9");//VERSION
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Star_Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		//caps.setCapability(MobileCapabilityType.UDID, "ZF62248MWJ"); 
		caps.setCapability(MobileCapabilityType.UDID, "jrd6hmy5mzhihihu");//jrd6hmy5mzhihihu  192.168.100.93:5555
		//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability("automationName", "UiAutomator2");//UiAutomator2  espresso
		caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft dev");//APPLICATION_NAME
		caps.setCapability("clearDeviceLogsOnStart", true);
		caps.setCapability("appPackage", "com.commusoft.v4.dev");
		//-----> Live pointed 
		
//		caps.setCapability("appPackage", "com.commusoft.v4.couchdb"); //-------> Stage build
//		caps.setCapability("appPackage", "com.commusoft.v4.dev");//--------> Dev build
		caps.setCapability("appActivity", "com.commusoft.v4.dev.Setup.Activities.SplashScreen");// appActivity  com.commusoft.v4.Setup.Activities.SplashScreen
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);// http://0.0.0.0:4723/wd/hub
		
		udid = driver.getCapabilities().getCapability("udid").toString();
		System.out.println("Mobile UDID is: "+udid);
		
		
		}catch(Exception exp) {
			System.out.println("Cause is: "+ exp.getCause());
			System.out.println("Message is :"+exp.getMessage());
			exp.printStackTrace();
		}
	}
	@BeforeTest
	
	public void ConnectWeb() throws InterruptedException, IOException 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless=new");// Chrome browser doesn't open, it will run on the background
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} ); // It will hide 'Chrome browser is being controlled by automated test software'
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driverWeb=new ChromeDriver();
		
		webEventListener = new WebEventListener();
	    eventFiringWebDriver = new EventFiringWebDriver(driverWeb);
	    eventFiringWebDriver.register(webEventListener);
	    driverWeb=eventFiringWebDriver;
	    
		
		
		driverWeb.manage().window().maximize();
		
		
	    ExcelReader excelReader = new ExcelReader(driverWeb);
	  
        
        if(simpleName.contains("Commusoft_WebAndMobile") &&  Running_UserName.contains("ssara")) 
        {
        	excelReader.OfficeStaff();
        }else if(simpleName.contains("BasicSmoke_MobAndWeb") &&  Running_UserName.contains("ssara")) 
        {
        	excelReader.Owner();
        	
        }
        
        
		
	}
	
	
	@BeforeSuite
	public void initial() throws IOException
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/V4SmokeTest " +System.currentTimeMillis()+  ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		logger = report.createTest("Commusoft V4 App Report");
	}
		
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, "Method Been Executed Sucessfully:-" +result.getName());
			System.out.println( "Method Been Executed Sucessfully:-" +result.getName());
		}else 
			if(ITestResult.FAILURE==result.getStatus())
		{
				logger.log(Status.FAIL, "Method Been Failed:-" +result.getName());
				logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driverWeb)).build());
				logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver)).build());
				
				System.out.println( "Method Been Failed:-" +result.getName());
		}else
		{
			logger.log(Status.SKIP, "Method been Skiped");
		}
		report.flush();
	}
	
	
	
	@AfterSuite
	public void teardown()
	{
		FiveSec();
//		driver.quit();
//		chromeDriver.quit();
		
	}
	@AfterSuite
	public void tearDownWeb() 
	{
		WebThreeSec();
//		driverWeb.quit();
	}




	
	
}
