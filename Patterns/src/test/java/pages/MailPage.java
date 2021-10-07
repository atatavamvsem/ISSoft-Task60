package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Light version')]")
    private static WebElement switchToLightVersion;

    @FindBy(xpath = "//a[contains(@class,'user-account_left-name')]/span[@class='user-account__name']")
    private static WebElement userAccount;

    @FindBy(xpath = "//a[contains(@class,'b-header__link_exit')]")
    private static WebElement logoutButton;

    public MailPage() {
        super();
        PageFactory.initElements(super.driver, this);
    }

    public String getAccountName() {
        return getTextElement(userAccount);
    }

    public YandexPage logoutUser() {
        new WebDriverWait(super.driver, 30).until(ExpectedConditions.elementToBeClickable(switchToLightVersion)).click();
        logoutButton.click();

        return new YandexPage();
    }
}
