package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAndPreviousOrdersMain {

    WebDriver driver;

    public LoginAndPreviousOrdersMain(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement usernameField(){
        return driver.findElement(By.id("username"));
    }

    public WebElement passwordField(){
        return driver.findElement(By.id("password"));
    }

    public WebElement loginButton(){
        return driver.findElement(By.id("login"));
    }

    public WebElement refreshButton(){
        return driver.findElement(By.id("refresh"));
    }

}
