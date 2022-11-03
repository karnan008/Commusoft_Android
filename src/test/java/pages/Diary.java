package pages;

import action.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Diary extends Wrapper{
	
	public Diary(AndroidDriver<MobileElement> ldriver)
	{
		this.driver = ldriver;
	}
	public void Stat_Time(String time) throws InterruptedException
	{
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/start_time", time);
	}
	public void End_Time(String time) throws InterruptedException
	{
		Thread.sleep(2000);
		type("#com.commusoft.v4:id/end_time", time);
	}
	public void Diary_Accept() throws InterruptedException
	{
		Thread.sleep(3000);
		click("#com.commusoft.v4:id/statusButton1");//click accept
		Thread.sleep(2000);
	}
	public void Diary_Travel() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Travel']");//click trvel
		Thread.sleep(2000);
	}
	public void Diary_Arrive() throws InterruptedException
	{
		click("//android.widget.TextView[@text='Arrive']");//click arrive
		Thread.sleep(2000);
	}
	
	
	
	
	
	

}
