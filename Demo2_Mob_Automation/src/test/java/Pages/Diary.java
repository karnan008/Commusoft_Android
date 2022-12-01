package Pages;


import MainPack.Wrapper;
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
		click("//*[@text='Accept']");//click accept
		Thread.sleep(2000);
	}
	public void Diary_Travel() throws InterruptedException
	{
		Thread.sleep(3000);
		click("//*[@text='Travel']");//click trvel com.commusoft.v4:id/statusButton1
		Thread.sleep(2000);
	}
	public void Diary_Arrive() throws InterruptedException
	{
		Thread.sleep(3000);
		click("//*[@text='Arrive']");//click arrive
		Thread.sleep(2000);
	}
	
	
	
	
	
	

}
