package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {
    private static WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'HeadBanner-Button-Enter')]")
    private static WebElement enterButton;

    public StartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterButtonClick() {
        enterButton.click();

        return new LoginPage(driver);
    }
}
