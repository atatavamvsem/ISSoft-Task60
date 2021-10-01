package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {
    private static WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'Light version')]")
    WebElement switchToLightVersion;

    @FindBy(xpath = "//a[contains(@class,'user-account_left-name')]/span[@class='user-account__name']")
    public
    WebElement userAccount;

    @FindBy(xpath = "//a[contains(@class,'b-header__link_exit')]")
    WebElement logoutButton;

    public MailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void switchToLightVersionClick() {
        wait.until(ExpectedConditions.elementToBeClickable(switchToLightVersion)).click();
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }
}
