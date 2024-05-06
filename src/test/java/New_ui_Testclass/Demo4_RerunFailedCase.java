package New_ui_Testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(Demo4_RerunFailedCase.class)
public class Demo4_RerunFailedCase implements ITestListener {

    private List<ITestResult> failedTestResults = new ArrayList<>();
    private WebDriver driver;
    private int maxRetryCount = 1;
    private Map<String, Integer> retryCounts = new HashMap<>();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
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
    public void PassDiary() {
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
            for (ITestResult failedResult : failedTestResults) {
                String methodName = failedResult.getMethod().getMethodName();
                if (!retryCounts.containsKey(methodName)) {
                    retryCounts.put(methodName, 1);
                } else {
                    retryCounts.put(methodName, retryCounts.get(methodName) + 1);
                }
                if (retryCounts.get(methodName) <= maxRetryCount) {
                    System.out.println("Failed test case " + methodName + " running (Retry Attempt: " + retryCounts.get(methodName) + ")");
                    retryFailedTestCase(failedResult);
                }
            }
        }
    }

    private void retryFailedTestCase(ITestResult failedResult) {
        int retryCount = retryCounts.get(failedResult.getMethod().getMethodName());
        System.out.println("Retrying " + failedResult.getMethod().getMethodName() + " (Retry Attempt: " + retryCount + ")");
        TestNG retryTestNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        XmlTest test = new XmlTest(suite);
        test.setName("Failed Test Retest (Retry Attempt: " + retryCount + ")");

        Class failedTestClass = failedResult.getTestClass().getRealClass();
        XmlClass xmlClass = new XmlClass(failedTestClass);
        xmlClass.setIncludedMethods(getFailedTestMethods(failedTestClass));
        test.getClasses().add(xmlClass);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        retryTestNG.setXmlSuites(suites);
        retryTestNG.run();
    }

    private List<XmlInclude> getFailedTestMethods(Class failedTestClass) {
        List<XmlInclude> failedMethods = new ArrayList<>();
        String methodName = failedTestClass.getMethods()[0].getName();
        failedMethods.add(new XmlInclude(methodName));
        return failedMethods;
    }
    
    
    
    
    
    
    
    
}
