package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.FusionCheckout;

import java.util.concurrent.TimeUnit;

@CucumberOptions(features = {"src/test/resources"}, glue = {"steps"}, plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml",
        "html:target/cucumber-reports" },
        monochrome = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    public static FusionCheckout fusionCheckout;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/David/Revature/chromedriver");

        driver = new ChromeDriver();
        fusionCheckout = new FusionCheckout(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {driver.quit();}

}
