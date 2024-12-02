package New_ui_Testclass;

import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(PrefinalRerunFailedCase.class)
public class PrefinalRerunFailedCase implements ITestListener {

	private List<ITestResult> failedTestResults = new ArrayList<>();
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.commusoft.co.uk/");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void login() {
        System.out.println("Login");
        WebElement UserID = driver.findElement(By.xpath("//input[@id='logintype_clientid']"));
        WebElement UserName = driver.findElement(By.xpath("//input[@id='logintype_username']"));
        WebElement UserPassword = driver.findElement(By.xpath("//input[@id='logintype_password']"));

        // Enter the credentials and submit the form
        UserID.sendKeys("16410");
        UserName.sendKeys("Saravanan");
        UserPassword.sendKeys("demo123");
        UserPassword.submit();
    }

    @Test(priority = 2)
    public void FailedDiary() {
        System.out.println("Failed Diary");
        driver.findElement(By.xpath("sfwfw")).click();
    }
    
    @Test(priority = 3)
    public void PassDiary() 
    {
    	 System.out.println("Pass Diary");
         driver.findElement(By.xpath("//a[text()='Diary']")).click();
    }
    
    @Test(priority = 4)
    public void FailedSupplier() {
        System.out.println("Failed Supplier");
        driver.findElement(By.xpath("sfwfw")).click();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTestResults.add(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        if (!failedTestResults.isEmpty()) {
            System.out.println("Failed test case running");
            TestNG testNG = new TestNG();
            XmlSuite suite = new XmlSuite();
            XmlTest test = new XmlTest(suite);
            test.setName("Failed Test Retest");

            for (ITestResult failedResult : failedTestResults) {
                Class failedTestClass = failedResult.getTestClass().getRealClass();
                XmlClass xmlClass = new XmlClass(failedTestClass);
                xmlClass.setIncludedMethods(getFailedTestMethods(failedTestClass));
                test.getClasses().add(xmlClass);
            }

            List<XmlSuite> suites = new ArrayList<>();
            suites.add(suite);
            testNG.setXmlSuites(suites);
            testNG.run();
        }
    }

    private List<XmlInclude> getFailedTestMethods(Class failedTestClass) {
        List<XmlInclude> failedMethods = new ArrayList<>();
        for (ITestResult failedResult : failedTestResults) {
            if (failedResult.getTestClass().getRealClass().equals(failedTestClass)) {
                ITestNGMethod method = failedResult.getMethod();
                failedMethods.add(new XmlInclude(method.getMethodName()));
            }
        }
        return failedMethods;
    }
}


