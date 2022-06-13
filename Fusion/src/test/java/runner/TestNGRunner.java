package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginAndPreviousOrdersMain;

@CucumberOptions(features = {"src/test/resources/view-orders.feature"}, glue={"steps"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static LoginAndPreviousOrdersMain loginMain;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        loginMain = new LoginAndPreviousOrdersMain(driver);
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }

}
