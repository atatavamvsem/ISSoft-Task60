package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPage extends BasePage {

    public By newLoginItem = By.xpath("//div[@class='desk-notif-card__login-new-items']");

    public YandexPage(WebDriver driver) {
        super(driver);
    }
}
