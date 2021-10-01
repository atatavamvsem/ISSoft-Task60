package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private static WebDriverWait wait;

    By loginInput = By.xpath("//input[@id='passp-field-login']");

    By loginButton = By.xpath("//button[@id='passp:sign-in']");

    By passwordInput = By.xpath("//input[@id='passp-field-passwd']");

    By loginSecondButton = By.xpath("//button[@id='passp:sign-in']");

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    public void sendLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    public void sendPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
    }

    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    public void loginSecondButtonClick() {
        driver.findElement(loginSecondButton).click();
    }
}
