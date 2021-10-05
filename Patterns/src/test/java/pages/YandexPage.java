package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPage extends BasePage {
    private static WebDriver driver;

    private static final By NEW_LOGIN_ITEM = By.xpath("//div[@class='desk-notif-card__login-new-items']");

    public YandexPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isLoginItemDisplayed() {
        return isElementDisplayed(NEW_LOGIN_ITEM);
    }
}
