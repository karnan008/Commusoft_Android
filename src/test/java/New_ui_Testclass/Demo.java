package New_ui_Testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import MainPack.BaseClassForWebAndMobile;
import Utility.ExcelReader;
import Utility.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public  WebDriver driverWeb;

	@Test
	public void test () 
	{


		ChromeOptions chromeOptions = new ChromeOptions();
		//	chromeOptions.addArguments("--headless=new");// Chrome browser doesn't open, it will run on the background
		//	chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} ); // It will hide 'Chrome browser is being controlled by automated test software'
		//	chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driverWeb=new ChromeDriver(chromeOptions);




		driverWeb.manage().window().maximize();


		System.out.println("TEST PASS");



	}

}
