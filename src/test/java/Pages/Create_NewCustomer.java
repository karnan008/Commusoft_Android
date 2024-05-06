package Pages;

import MainPack.WrapperClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Create_NewCustomer extends WrapperClass{
	
	public Create_NewCustomer(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver=sdriver;
	}
	public void ClickMenu() throws InterruptedException 
	{
		ThreeSec();
		Click2("//*[@class='android.widget.ImageButton']");
	}
	
	public void Click_NewPrivateCustomer() throws InterruptedException 
	{
		ThreeSec();
		Click2("//*[@text='New Private customer']");
		
	}
	
	public void Enter_Surname() throws InterruptedException 
	{
		ThreeSec();
		Type2("(//*[@text='Tap To Enter�'])[2]", Surname);
	}
	
	public void Enter_Addressline1() 
	{
		ThreeSec();
		Type2("(//*[@text='Tap To Enter�'])[5]", Addressline1);
	}
	
	public void Click_Tick() 
	{
		ThreeSec();
		Click2("//*[@content-desc='Save']");
	}
	public void Click_Backbutton() 
	{
		ThreeSec();
		Click2("//*[@class='android.widget.ImageButton']");
	}
	//Again Click the menu button.

	public void Click_Search() 
	{
		ThreeSec();
		Click2("//*[@content-desc='Search']");
	}
	public void Enter_Customer() throws InterruptedException 
	{
		ThreeSec();
		Type2("//*[@text='Search�']", Surname);
		HitEnter();
	}
	
}
