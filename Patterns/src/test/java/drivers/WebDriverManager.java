package drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
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
                MutableCapabilities sauceOptions = new MutableCapabilities();
                sauceOptions.setCapability("username", System.getenv("oauth-atatavamvsembudet-576db"));
                sauceOptions.setCapability("access_key", System.getenv("ebed9b92-77f3-4d04-bbbe-af8a796e239a"));
                sauceOptions.setCapability("name", "Yandex tests");
                sauceOptions.setCapability("platform", "Windows 10");
                sauceOptions.setCapability("browserVersion", "latest");

                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("sauce:options", sauceOptions);
                URL url = new URL("https://oauth-atatavamvsembudet-576db:ebed9b92-77f3-4d04-bbbe-af8a796e239a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

                driver = new RemoteWebDriver(url, options);
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