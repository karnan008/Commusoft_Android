package Demo_Mob_Pac;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestClass_MobWeb extends BaseClass_MobWeb{
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		BaseClass_MobWeb BC=new BaseClass_MobWeb();
		
		AndroidDriver<MobileElement>driver=BC.CAP();

//		driver.get("https://www.orange.jo/en/services/pages/my-orange-application.aspx");
//		driver.findElement(By.xpath("//a[@onclick='OPenMobileMenu()']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//a[@class='Menupointer'])[1]")).click();//Click eShop
		
		
		
	}

}
