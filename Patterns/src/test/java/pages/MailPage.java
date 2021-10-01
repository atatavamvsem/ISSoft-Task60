package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {
    private static WebDriverWait wait;

    By switchToLightVersion = By.xpath("//a[contains(text(),'Light version')]");

    public By userAccount = By.xpath("//a[contains(@class,'user-account_left-name')]/span[@class='user-account__name']");

    By logoutButton = By.xpath("//a[contains(@class,'b-header__link_exit')]");

    public MailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    public void switchToLightVersionClick() {
        wait.until(ExpectedConditions.elementToBeClickable(switchToLightVersion)).click();
    }

    public void logoutButtonClick() {
        driver.findElement(logoutButton).click();
    }
}
