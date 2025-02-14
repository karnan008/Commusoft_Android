package MobAndWeb_Page;

import MainPack.Wrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NewUIElements extends Wrapper{
	
	public NewUIElements(AndroidDriver<MobileElement> sdriver) 
	{
		this.driver = sdriver;
	}
	
	public void BackArrowButton() 
	{
		ThreeSec();
		ExplicitWait_ElementToBeClickable("(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ImageView)[1]");
		click("(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.ImageView)[1]");
	}

}
