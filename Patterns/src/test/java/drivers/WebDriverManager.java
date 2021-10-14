package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public void delDriver() {
        driver.quit();
        driver = null;
    }
}