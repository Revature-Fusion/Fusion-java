package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginAndPreviousOrdersMain;
import steps.ViewPreviousOrdersStepsImpl;

@CucumberOptions(features = {"src/test/resources/view-orders.feature"}, glue={"steps"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static LoginAndPreviousOrdersMain loginMain;

//    public static ViewPreviousOrdersStepsImpl viewPreviousOrdersSteps;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\visio\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        loginMain = new LoginAndPreviousOrdersMain(driver);
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }

}
