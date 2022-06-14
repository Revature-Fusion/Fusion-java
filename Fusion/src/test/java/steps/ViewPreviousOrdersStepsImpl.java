package steps;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import pages.LoginAndPreviousOrdersMain;
//import runner.TestNGRunner;
import cucumber.api.java.en.And;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.FusionCheckout;
import pages.LoginAndPreviousOrdersMain;
import pages.SessionStorage;
import runner.TestNGRunner;

public class ViewPreviousOrdersStepsImpl {

    public static WebDriver driver = TestNGRunner.driver;
    public static LoginAndPreviousOrdersMain loginMain = TestNGRunner.loginMain;

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get("file:///Users/David/Revature/Projects/P3/Fusion-frontend/login.html");
        WebElement username = loginMain.usernameField();
        WebElement password = loginMain.passwordField();
        WebElement loginButton = loginMain.loginButton();

        username.sendKeys("testusername15");
        password.sendKeys("testpassword15");
        loginButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("The User clicks on view orders page")
    public void user_clicks_on_view_orders_page() {
        loginMain.viewOrdersButton().click();
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
