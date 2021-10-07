package pages;

import org.openqa.selenium.By;

public class YandexPage extends BasePage {
    private static final By NEW_LOGIN_ITEM = By.xpath("//div[@class='desk-notif-card__login-new-items']");

    public YandexPage() {
        super();
    }

    public boolean isLoginItemDisplayed() {
        return isElementDisplayed(NEW_LOGIN_ITEM);
    }
}
