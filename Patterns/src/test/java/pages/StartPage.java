package pages;

import org.openqa.selenium.By;

public class StartPage extends BasePage {
    private static final By ENTER_BUTTON = By.xpath("//a[contains(@class,'HeadBanner-Button-Enter')]");

    public StartPage() {
        super.driver.get("https://mail.yandex.com/");
    }

    public LoginPage enterButtonClick() {
        super.driver.findElement(ENTER_BUTTON).click();

        return new LoginPage();
    }
}
