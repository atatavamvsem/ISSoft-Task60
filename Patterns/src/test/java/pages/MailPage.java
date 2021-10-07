package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {
    private static final By SWITCH_TO_LIGHT_VERSION = By.xpath("//a[contains(text(),'Light version')]");

    private static final By USER_ACCOUNT = By.xpath("//a[contains(@class,'user-account_left-name')]/span[@class='user-account__name']");

    private static final By LOGOUT_BUTTON = By.xpath("//a[contains(@class,'b-header__link_exit')]");

    public MailPage() {
        super();
    }

    public YandexPage logoutUser() {
        new WebDriverWait(super.driver, 30).until(ExpectedConditions.elementToBeClickable(SWITCH_TO_LIGHT_VERSION)).click();
        super.driver.findElement(LOGOUT_BUTTON).click();

        return new YandexPage();
    }

    public String getAccountName(){
        return getTextElement(USER_ACCOUNT);
    }
}
