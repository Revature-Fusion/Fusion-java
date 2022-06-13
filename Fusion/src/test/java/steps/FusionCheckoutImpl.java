package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.FusionCheckout;
import pages.SessionStorage;
import runner.TestNGRunner;


public class FusionCheckoutImpl {

    public static WebDriver driver = TestNGRunner.driver;
    public static FusionCheckout fusionCheckout = TestNGRunner.fusionCheckout;

    public SessionStorage sessionStorage = new SessionStorage(driver);

    @Given("The User is on the Checkout Page")
    public void the_user_is_on_the_checkout_page() {
        driver.get("file:///Users/David/Revature/Projects/P3/Fusion-frontend/checkout.html");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("The User types in First Name")
    public void the_user_types_in_first_name() {
        fusionCheckout.enterfName();
    }
    @When("The User types in Last Name")
    public void the_user_types_in_last_name() {
        fusionCheckout.enterlName();
    }
    @When("The User types in Email")
    public void the_user_types_in_email() {
        fusionCheckout.enterEmail();
    }
    @When("The User types in Address")
    public void the_user_types_in_address() {
        fusionCheckout.enterAddress();
    }
    @When("The User types in City")
    public void the_user_types_in_city() {
        fusionCheckout.enterCity();
    }
    @When("The User types in Postal Code")
    public void the_user_types_in_zip() {
        fusionCheckout.enterpCode();
    }
    @When("The User types in Country")
    public void the_user_types_in_country() { fusionCheckout.enterCountry(); }
    @Then("The User can click Checkout")
    public void the_user_can_click_checkout() {
        fusionCheckout.clickCheckout();
    }

    @Given("^The User is logged in$")
    public void the_User_is_logged_in() {
        sessionStorage.setItemInSessionStorage("user", "JSON.stringify({uId: 10, email: \"test9@email.com\", firstName: \"test9fname\", lastName: \"test9lname\"})");
        driver.navigate().refresh();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^The User clicks checkout$")
    public void the_User_clicks_checkout() {
       fusionCheckout.clickCheckout();
    }

    @Then("^The User successfully checks out$")
    public void the_User_successfully_checks_out() throws Throwable {
        Assert.assertEquals(driver.switchTo().alert().getText(), "Successfully Checked out!");
    }
}
