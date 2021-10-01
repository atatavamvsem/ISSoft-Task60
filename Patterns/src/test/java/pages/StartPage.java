package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'HeadBanner-Button-Enter')]")
    WebElement inputButton;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void inputButtonClick() {
        inputButton.click();
    }
}
