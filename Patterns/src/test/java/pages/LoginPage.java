package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private static WebDriverWait wait;

    By loginInput = By.xpath("//input[@id='passp-field-login']");

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    WebElement loginSecondButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void sendLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    public void sendPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public void loginSecondButtonClick() {
        loginSecondButton.click();
    }
}
