package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SessionStorage {
    private JavascriptExecutor js;

    public SessionStorage(WebDriver webDriver) {
        this.js = (JavascriptExecutor) webDriver;
    }

    public void removeItemFromSessionStorage(String item) {
        js.executeScript(String.format(
                "window.sessionStorage.removeItem('%s');", item));
    }

    public boolean isItemPresentInSessionStorage(String item) {
        return !(js.executeScript(String.format(
                "return window.sessionStorage.getItem('%s');", item)) == null);
    }

    public String getItemFromSessionStorage(String key) {
        return (String) js.executeScript(String.format(
                "return window.sessionStorage.getItem('%s');", key));
    }

    public String getKeyFromSessionStorage(int key) {
        return (String) js.executeScript(String.format(
                "return window.sessionStorage.key('%s');", key));
    }

    public Long getLocalStorageLength() {
        return (Long) js.executeScript("return window.sessionStorage.length;");
    }

    public void setItemInSessionStorage(String item, String value) {
        js.executeScript(String.format(
                "window.sessionStorage.setItem('%s','%s');", item, value));
    }

    public void clearSessionStorage() {
        js.executeScript("window.sessionStorage.clear();");
    }
}
