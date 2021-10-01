package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public boolean checkIfElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public String getTextElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
    }
}
