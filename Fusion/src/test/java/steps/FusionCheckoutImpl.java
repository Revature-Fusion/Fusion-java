package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.FusionCheckout;
import runner.TestNGRunner;

public class FusionCheckoutImpl {

    public static WebDriver driver = TestNGRunner.driver;
    public static FusionCheckout fusionCheckout = TestNGRunner.fusionCheckout;

    @Given("The User is on the Checkout Page")
    public void the_user_is_on_the_checkout_page() {
        driver.get("file:///Users/David/Revature/Projects/P3/Fusion-frontend/checkout.html");
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

    // Remove Product from Cart Functionality
//    @Given("The User is on the Checkout Page")
//    public void the_user_is_on_the_checkout_page() {
//        driver.get("file:///Users/David/Revature/Projects/P3/Fusion-frontend/checkout.html");
//    }
    @When("The User clicks on Remove Item")
    public void the_user_clicks_on_remove_item() {
        fusionCheckout.clickRemoveItem();
    }
    @Then("The Item Quantity should be reflected inside the Cart")
    public void the_item_quantity_should_be_reflected_inside_the_cart() {
        Assert.assertEquals(driver.getTitle(), "Fusion - Checkout - Cart");
    }
}
