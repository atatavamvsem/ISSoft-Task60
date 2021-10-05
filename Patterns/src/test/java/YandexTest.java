import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MailPage;
import pages.StartPage;
import pages.YandexPage;

public class YandexTest {
    private static WebDriver driver;

    private StartPage startPage;
    private LoginPage loginPage;
    private MailPage mailPage;
    private YandexPage yandexPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverManager.getInstance();
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
    }

    @Test
    public void loginTest() {
        startPage = new StartPage(driver);

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        Assertions.assertEquals(mailPage.getAccountName(),
                ResourceProperties.getCredProperty("login"), "Login failed");
    }

    @Test
    public void logoutTest() {
        startPage = new StartPage(driver);

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        yandexPage = mailPage.logoutUser();

        Assertions.assertTrue(yandexPage.isLoginItemDisplayed(), "Logout failed");
    }

    @AfterEach
    public void closeUp() {
        driver.quit();
        WebDriverManager.delDriver();
    }
}