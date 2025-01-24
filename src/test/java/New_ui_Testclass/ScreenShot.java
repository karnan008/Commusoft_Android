package New_ui_Testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenShot {
	
	public static void main(String[] args) throws IOException {
		
		
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        // Load your local HTML file
       
        driver.get("file:///C:/Users/saravanan/Downloads/V4SmokeTest%201722920289371.html");
        driver.manage().window().fullscreen();
        // Wait for the page to fully load
        try {
            Thread.sleep(2000);  // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Capture the full page screenshot using AShot
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        // Save the screenshot to a file
        ImageIO.write(screenshot.getImage(), "PNG", new File("full_page_screenshot.png"));

        // Close the browser
//        driver.quit();
		
		
	}

}
