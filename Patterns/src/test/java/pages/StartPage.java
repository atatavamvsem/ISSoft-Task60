package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {
    private static WebDriver driver;

    private static final By ENTER_BUTTON = By.xpath("//a[contains(@class,'HeadBanner-Button-Enter')]");

    public StartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage enterButtonClick() {
        driver.findElement(ENTER_BUTTON).click();
        return new LoginPage(driver);
    }
}
