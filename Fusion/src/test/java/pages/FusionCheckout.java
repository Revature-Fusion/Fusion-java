package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FusionCheckout {

    public FusionCheckout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fname")
    private WebElement fname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "adr")
    private WebElement adr;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zip")
    private WebElement zip;

    @FindBy(xpath = "/html/body/div[1]/div/input[1]")
    private WebElement checkoutBtn;

    // Cart element to remove item goes here.
    @FindBy(xpath = "/html/body/div[2]/div/p[5]/span")
    private WebElement removeBtn;

    public void enterName() {
        fname.click();
        fname.sendKeys("Java Selenium");
    }
    public void enterEmail() {
        email.click();
        email.sendKeys("java@selenium.com");
    }
    public void enterAddress() {
        adr.click();
        adr.sendKeys("100 Java Way");
    }
    public void enterCity() {
        city.click();
        city.sendKeys("Cucumber City");
    }
    public void enterZip() {
        zip.click();
        zip.sendKeys("10010");
    }
    public void clickCheckout() {
        checkoutBtn.click();
    }

    public void clickRemoveItem() {
        removeBtn.click();
    }
}
