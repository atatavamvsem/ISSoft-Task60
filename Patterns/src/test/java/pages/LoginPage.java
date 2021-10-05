package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private static final By LOGIN_INPUT = By.xpath("//input[@id='passp-field-login']");

    private static final By LOGIN_BUTTON = By.xpath("//button[@id='passp:sign-in']");

    private static final By PASSWORD_INPUT = By.xpath("//input[@id='passp-field-passwd']");

    private static final By LOGIN_SECOND_BUTTON = By.xpath("//button[@id='passp:sign-in']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    //I split the logic for the login because we might need separate methods
    //But I'm not sure about this :)
    public MailPage loginUser(String login, String password){
        sendLogin(login);
        sendPassword(password);

        return new MailPage(driver);
    }

    private void sendLogin(String login){
        driver.findElement(LOGIN_INPUT).sendKeys(login);
        driver.findElement(LOGIN_BUTTON).click();
    }

    private void sendPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_INPUT)).sendKeys(password);
        driver.findElement(LOGIN_SECOND_BUTTON).click();
    }
}
