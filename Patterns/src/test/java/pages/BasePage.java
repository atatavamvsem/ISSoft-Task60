package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    protected boolean isElementDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    protected String getTextElement(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
    }
}
