package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class WebDriverManager {
    private static WebDriverManager instance;
    private WebDriver driver;

    private WebDriverManager() {
    }

    public static WebDriverManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    public void delDriver() {
        driver.quit();
        driver = null;
    }
}