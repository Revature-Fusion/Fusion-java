package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FusionCheckout {

    public FusionCheckout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fName")
    private WebElement fName;

    @FindBy(id = "lName")
    private WebElement lName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "adr")
    private WebElement adr;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "pCode")
    private WebElement pCode;

    @FindBy(id = "ctr")
    private WebElement ctr;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/form/input[1]")
    private WebElement checkoutBtn;

    // Cart element to remove item goes here.
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/p")
    private WebElement removeBtn;

    public void enterfName() {
        fName.click();
        fName.sendKeys("Java");
    }
    public void enterlName() {
        lName.click();
        lName.sendKeys("Selenium");
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
    public void enterpCode() {
        pCode.click();
        pCode.sendKeys("10010");
    }
    public void enterCountry() {
        ctr.click();
        ctr.sendKeys("Canada");
    }
    public void clickCheckout() {
        checkoutBtn.click();
    }

    public void clickRemoveItem() {
        removeBtn.click();
    }
}
