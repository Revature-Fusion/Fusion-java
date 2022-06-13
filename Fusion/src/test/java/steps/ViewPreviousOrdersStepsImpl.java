package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginMain;
import runner.TestNGRunner;

public class ViewPreviousOrdersStepsImpl {

    public static WebDriver driver = null;
    public static LoginMain loginMain = TestNGRunner.loginMain;

    @Given("User is logged in and on view orders page")
    public void user_is_logged_in_and_on_view_orders_page() {

    }

    @When("User clicks on refresh table")
    public void user_clicks_on_refresh_table() {

    }

    @Then("The previous orders table is displayed")
    public void the_previous_orders_table_is_displayed() {

    }

    @When("User clicks on specific product image")
    public void user_clicks_on_specific_product_image() {

    }

    @Then("The user is sent to specific product's page")
    public void the_user_is_sent_to_specific_product_s_page() {

    }

}
