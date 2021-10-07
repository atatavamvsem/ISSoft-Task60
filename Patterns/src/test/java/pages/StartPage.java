package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class,'HeadBanner-Button-Enter')]")
    private static WebElement enterButton;

    public StartPage() {
        super();
        super.driver.get("https://mail.yandex.com/");
        PageFactory.initElements(super.driver, this);
    }

    public LoginPage enterButtonClick() {
        enterButton.click();

        return new LoginPage();
    }
}
