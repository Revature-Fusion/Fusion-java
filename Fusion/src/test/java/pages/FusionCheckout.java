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


    public void enterEmail() {
        email.click();
        email.sendKeys("test32@email.com");
        adr.click();
    }
    public void enterAddress() {
        adr.click();
        adr.sendKeys("100 Java Way");
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

}
