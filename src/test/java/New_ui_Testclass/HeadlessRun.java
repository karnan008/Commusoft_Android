package New_ui_Testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessRun {
	@org.testng.annotations.Test
	
	public void Test() throws InterruptedException 
	{
		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--headless=new");
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver testDriver = new ChromeDriver();
		testDriver.get("https://app.commusoft.co.uk/");
		testDriver.manage().window().maximize();
		Thread.sleep(5000);
		String text = testDriver.findElement(By.xpath("//div[text()='Log in']")).getText();
		System.out.println(text);
		
		testDriver.findElement(By.xpath("//input[@id='logintype_clientid']")).click();
		testDriver.findElement(By.xpath("//input[@id='logintype_clientid']")).sendKeys("16410");
		System.out.println("Case pass");
//		testDriver.quit();
		
		
	}

}
