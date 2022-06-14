package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
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

    @When("The User types in Email")
    public void the_user_types_in_email() {
//        sessionStorage.setItemInSessionStorage("user", "test32@email.com");
        fusionCheckout.enterEmail();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("The User can click Checkout")
    public void the_user_can_click_checkout() {
        fusionCheckout.clickCheckout();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^The User is logged in$")
    public void the_User_is_logged_in() {
        sessionStorage.setItemInSessionStorage("user", "{\"uId\":10,\"email\":\"test9@email.com\",\"firstName\":\"test9fname\",\"lastName\":\"test9lname\"}");
        driver.navigate().refresh();
//        ((JavascriptExecutor)driver).executeScript("checkoutCart();");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And ("^There are items in the cart$")
    public void there_are_items_in_the_cart() {
        sessionStorage.setItemInSessionStorage("cart", "[{\"productId\":44,\"name\":\"HDMI Cable Dual Package\",\"desc\":\"A package of two HDMI cables\",\"price\":12,\"stock\":100,\"quantity\":2},{\"productId\":45,\"name\":\"Cat Ear Headphones\",\"desc\":\"Headphones with cat ears\",\"price\":60,\"stock\":100,\"quantity\":3}]");
        driver.navigate().refresh();
    }

    @When("^The User clicks checkout$")
    public void the_User_clicks_checkout() {
       fusionCheckout.clickCheckout();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^The User successfully checks out$")
    public void the_User_successfully_checks_out() {
        Assert.assertEquals(driver.switchTo().alert().getText(), "Successfully Checked out!");
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
