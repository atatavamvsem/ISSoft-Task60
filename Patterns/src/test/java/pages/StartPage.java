package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {

    By inputButton = By.xpath("//a[contains(@class,'HeadBanner-Button-Enter')]");

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void inputButtonClick() {
        driver.findElement(inputButton).click();
    }
}
