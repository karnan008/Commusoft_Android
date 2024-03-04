package MainPack;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TabletBaseClassForWebAndMobile extends Wrapper{
	

	

	
	public ExtentReports report;
	public  ExtentTest logger;
	
	public  String CustomerName = "Kari Athi";
	public  String TitleCustomerName = "Mr Kari Athi";
	public  String FirstName = "Kari";
	public  String LastName = "Athi";
	public  String WorkAddressLastName="For Automation";
	public  String Title = "Mr & Mrs";
	public  String EstimateDescription = "Estimate template_Nametag";
	public  String Breakdown = "No Breakdown";
	public  String JobDescription = "COUCH";
	public String WAName = "Karikalan";
	public String WorkAddressName="Work Adress";
	public String Name="S";
	public String Surname="Saravanan";//
	public String EditName="EditMobileAutomation";//
	public String EditLandline="15246789";
	public String EditMob="789456123";
	public String EditEmail="editssaravanan@commusoft.com";
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
	public String WebName="WebAutomation";
	public String WebAddress="WebAddress";
	public String WebEmail="ssaravanan@commusoft.com";
	public String WebWoraddressName="WebWorkAddress";
	public String WebWorkAddressEmail="WebWorkaddress@gmail.com";
	public String CustomerContact="MobContact";
	public String CustomerEmail="customer@commusoft.com";
	public String Address="Address1";
	public String EditWebCustomerName="EditWebAutomation";
	public String WebEmailSub="WebEmailSub";
	
	
	AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    
    
//  (12 Am=183,323)
 // (1 AM=171,564)
//  (2 AM=240,732)
//  (3 AM=177,875)
//  (4 AM=180,1090)
//  (5 AM=231,1239)
//  (6 AM=196,1420)
//  (7 AM=262,1616)
//  (8 AM=214,1793)
//  (9 AM=268,1964)
//  (10AM=315,2106)
    
	
	@BeforeTest(alwaysRun = true)
	public void setup()
	{

		try {
			
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.VERSION, "13");
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Star_Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy tab S6 Lite");
		//caps.setCapability(MobileCapabilityType.UDID, "ZF62248MWJ"); 
		caps.setCapability(MobileCapabilityType.UDID, "192.168.100.150:8080");//jrd6hmy5mzhihihu  192.168.100.93:5555
		//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability("automationName", "UiAutomator2");//UiAutomator2  espresso
		caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft");
		caps.setCapability("clearDeviceLogsOnStart", true);
		caps.setCapability("appPackage", "com.commusoft.v4"); //-----> Live pointed 
		
//		caps.setCapability("appPackage", "com.commusoft.v4.couchdb"); //-------> Stage build
//		caps.setCapability("appPackage", "com.commusoft.v4.dev");//--------> Dev build
		caps.setCapability("appActivity", "com.commusoft.v4.Setup.Activities.SplashScreen");// appActivity  com.commusoft.v4.Setup.Activities.SplashScreen
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		
		
		
		}catch(Exception exp) {
			System.out.println("Cause is: "+ exp.getCause());
			System.out.println("Message is :"+exp.getMessage());
			exp.printStackTrace();
		}
	}
	@BeforeTest
	
	public void ConnectWeb() 
	{
		WebDriverManager.chromedriver().setup();
		driverWeb=new ChromeDriver();
		driverWeb.manage().window().maximize();
		
		driverWeb.get("https://app.commusoft.co.uk/");
		
//		Owner/Manager Role:
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
		Webclick("//input[@id='logintype_clientid']");
		typeForWeb("//input[@id='logintype_clientid']", "16410");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
		typeForWeb("//input[@id='logintype_username']", "Saravanan");
		ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
		typeForWeb("//input[@id='logintype_password']", "demo123");
		ExplicitWait_ElementToBeClickable2("//span[text()='Log in']");
		Webclick("//span[text()='Log in']");
		
		
//		Office Staff Role:
//		ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
//		Webclick("//input[@id='logintype_clientid']");
//		typeForWeb("//input[@id='logintype_clientid']", "16410");
//		ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
//		typeForWeb("//input[@id='logintype_username']", "OfficeStaff");
//		ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
//		typeForWeb("//input[@id='logintype_password']", "demo123");
//		ExplicitWait_ElementToBeClickable2("//span[text()='Log in']");
//		Webclick("//span[text()='Log in']");
//		
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
		//		logger.log(Status.FAIL,logger.addScreenCaptureFromPath(Screenshot.capture(driver))+result.getName());
//				logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver)).build());
				System.out.println( "Method Been Failed:-" +result.getName());
			//	logger.log(Status.FAIL,logger.addScreenCaptureFromPath( capture(driver)) +"  Method Name:- " + result.getName());
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
		ThreeSec();
//		driverWeb.quit();
	}





}
