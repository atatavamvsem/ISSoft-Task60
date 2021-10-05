package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private static final By SWITCH_TO_LIGHT_VERSION = By.xpath("//a[contains(text(),'Light version')]");

    private static final By USER_ACCOUNT = By.xpath("//a[contains(@class,'user-account_left-name')]/span[@class='user-account__name']");

    private static final By LOGOUT_BUTTON = By.xpath("//a[contains(@class,'b-header__link_exit')]");

    public MailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public YandexPage logoutUser() {
        wait.until(ExpectedConditions.elementToBeClickable(SWITCH_TO_LIGHT_VERSION)).click();
        driver.findElement(LOGOUT_BUTTON).click();
        return new YandexPage(driver);
    }

    public String getAccountName(){
        return getTextElement(USER_ACCOUNT);
    }
}
