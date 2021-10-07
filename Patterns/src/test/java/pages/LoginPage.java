package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='passp-field-login']")
    private static WebElement loginInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private static WebElement loginButton;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private static WebElement passwordInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private static WebElement loginSecondButton;

    public LoginPage() {
        super();
        PageFactory.initElements(super.driver, this);
    }

    public MailPage loginUser(String login, String password){
        loginInput.sendKeys(login);
        loginButton.click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
        loginSecondButton.click();

        return new MailPage();
    }
}
