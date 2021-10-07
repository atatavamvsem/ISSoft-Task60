package pages;

import drivers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;

    public BasePage() {
        this.driver = WebDriverManager.getInstance().getDriver();
    }

    protected boolean isElementDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    protected String getTextElement(By element) {
        return new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element)).getText();
    }
}
