package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(xpath = "//input[@id='passp-field-login']")
    private static WebElement loginInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private static WebElement loginButton;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private static WebElement passwordInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private static WebElement loginSecondButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public MailPage loginUser(String login, String password){
        loginInput.sendKeys(login);
        loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
        loginSecondButton.click();

        return new MailPage(driver);
    }
}
