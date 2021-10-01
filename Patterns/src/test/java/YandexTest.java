import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MailPage;
import pages.StartPage;
import pages.YandexPage;

public class YandexTest {
    private WebDriver driver;

    private StartPage startPage;
    private LoginPage loginPage;
    private MailPage mailPage;
    private YandexPage yandexPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
    }

    @Test
    public void loginTest() {
        startPage = new StartPage(driver);

        startPage.inputButtonClick();

        loginPage = new LoginPage(driver);

        loginPage.sendLogin(ResourcesProperties.getCredProperty("login"));
        loginPage.loginButtonClick();

        loginPage.sendPassword(ResourcesProperties.getCredProperty("password"));
        loginPage.loginSecondButtonClick();

        mailPage = new MailPage(driver);

        Assertions.assertEquals(mailPage.getTextElement(mailPage.userAccount),
                ResourcesProperties.getCredProperty("login"), "Login failed");
    }

    @Test
    public void logoutTest() {
        startPage = new StartPage(driver);

        startPage.inputButtonClick();

        loginPage = new LoginPage(driver);

        loginPage.sendLogin(ResourcesProperties.getCredProperty("login"));
        loginPage.loginButtonClick();

        loginPage.sendPassword(ResourcesProperties.getCredProperty("password"));
        loginPage.loginSecondButtonClick();

        mailPage = new MailPage(driver);

        mailPage.switchToLightVersionClick();
        mailPage.logoutButtonClick();

        yandexPage = new YandexPage(driver);

        Assertions.assertTrue(yandexPage.checkIfElementDisplayed(yandexPage.newLoginItem), "Logout failed");
    }

    @AfterEach
    public void closeUp() {
        driver.quit();
    }
}