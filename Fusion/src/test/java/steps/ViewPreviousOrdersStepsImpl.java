package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginAndPreviousOrdersMain;
import runner.TestNGRunner;

public class ViewPreviousOrdersStepsImpl {

    public static WebDriver driver = TestNGRunner.driver;
    public static LoginAndPreviousOrdersMain loginMain = TestNGRunner.loginMain;

    @Given("User is logged in and on view orders page")
    public void user_is_logged_in_and_on_view_orders_page() {
        driver.get("file:///C:\\Users\\visio\\OneDrive\\Documents\\Temp\\Fusion-frontend");
        WebElement username = loginMain.usernameField();
        WebElement password = loginMain.passwordField();
        WebElement loginButton = loginMain.loginButton();

        username.sendKeys("Jsmith22");
        password.sendKeys("password");
        loginButton.click();
    }

    @When("User clicks on refresh table")
    public void user_clicks_on_refresh_table() throws InterruptedException {
        Thread.sleep(1000);
        WebElement refreshButton = loginMain.refreshButton();
        refreshButton.click();
    }

    @Then("The previous orders table is displayed")
    public void the_previous_orders_table_is_displayed() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.id("orderTable"));
        Assert.assertNotNull(element);
    }

}
