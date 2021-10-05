package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPage extends BasePage {

    @FindBy(xpath = "//div[@class='desk-notif-card__login-new-items']")
    private static WebElement newLoginItem;

    public YandexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginItemDisplayed() {
        return isElementDisplayed(newLoginItem);
    }
}
