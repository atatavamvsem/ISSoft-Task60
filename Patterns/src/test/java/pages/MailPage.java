package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Light version')]")
    WebElement switchToLightVersion;

    @FindBy(xpath = "//a[contains(@class,'user-account_left-name')]/span[@class='user-account__name']")
    public
    WebElement userAccount;

    @FindBy(xpath = "//a[contains(@class,'b-header__link_exit')]")
    WebElement logoutButton;

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToLightVersionClick() {
        switchToLightVersion.click();
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }
}
