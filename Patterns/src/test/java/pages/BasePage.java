package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected String getTextElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
    }
}
