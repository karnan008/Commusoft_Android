package MainPack;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass_Pixel6A extends Wrapper{
	

	
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
	public String Surname="Saravanan";
	public String EditName="EditForAutomation";
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
	
	AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
	
	@BeforeTest
	public void setup()
	{
//		appiumService = AppiumDriverLocalService.buildDefaultService();
//		appiumService.start();
//        appiumServiceUrl = appiumService.getUrl().toString();
//        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
		try {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.VERSION, "13");
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Star_Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6a");
		//caps.setCapability(MobileCapabilityType.UDID, "ZF62248MWJ"); 
		caps.setCapability(MobileCapabilityType.UDID, "24211JEGR05407");
		//caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Commusoft");
		caps.setCapability("clearDeviceLogsOnStart", true);
		caps.setCapability("appPackage", "com.commusoft.v4");
		caps.setCapability("appActivity", "com.commusoft.v4.Setup.Activities.SplashScreen");
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		//URL url = new URL("http://127.0.0.1:4723/wd/hub");
		//driver = new AppiumDriver<MobileElement>(url,caps);
		
		
		
		}catch(Exception exp) {
			System.out.println("Cause is: "+ exp.getCause());
			System.out.println("Message is :"+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
//	@BeforeSuite
//	public void initial() throws IOException
//	{
//		
//		ExtentSparkReporter extent = new ExtentSparkReporter(new File("./Reports/Live_SmokeTest_Result " +System.currentTimeMillis()+  ".html"));
//		report = new ExtentReports();
//		report.attachReporter(extent);
//		logger = report.createTest("Commusoft_Android");
//	}
	
	
	
	
	
	//some specific elements
	
	@FindBy(xpath="//android.widget.TextView[@text='Book event']")
	public WebElement Book_Event;
	
//	
//	
//	
//	@AfterMethod
//	public void teardown(ITestResult result) throws IOException
//	{
//		if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			logger.log(Status.PASS, "Method Been Executed Sucessfully:-" +result.getName());
//			System.out.println( "Method Been Executed Sucessfully:-" +result.getName());
//		}else 
//			if(ITestResult.FAILURE==result.getStatus())
//		{
//				logger.log(Status.FAIL, "Method Been Failed:-" +result.getName());
//		//		logger.log(Status.FAIL,logger.addScreenCaptureFromPath(Screenshot.capture(driver))+result.getName());
//				logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver)).build());
//				System.out.println( "Method Been Failed:-" +result.getName());
//			//	logger.log(Status.FAIL,logger.addScreenCaptureFromPath( capture(driver)) +"  Method Name:- " + result.getName());
//		}else
//		{
//			logger.log(Status.SKIP, "Method been Skiped");
//		}
//		report.flush();
//	}
	
//	@AfterMethod
//	public void TD(ITestResult result) throws IOException
//	{
//		if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			logger.log(Status.PASS, result.getName()+" - Passed Successfully");
//			System.out.println( result.getName()+" - Passed Successfully");
//			
//
//		}else if(ITestResult.FAILURE==result.getStatus())//ITestResult.FAILURE==result.getStatus()
//		{
//			logger.log(Status.FAIL,result.getName()+" - Failed");
//			logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver)).build());
//			System.err.println(result.getName()+" - Failed");
//			
//
//		}else
//		{
//			logger.log(Status.SKIP, "Method been Skiped");
//			logger.skip(result.getThrowable());
//			
//		}
//
//	}
	
	
	@AfterSuite
	public void teardown()
	{
		FiveSec();
//		driver.quit();
	}



}
