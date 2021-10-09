import drivers.WebDriverManager;
import org.junit.jupiter.api.*;

import pages.LoginPage;
import pages.MailPage;
import pages.StartPage;
import pages.YandexPage;

public class YandexTest {
    private StartPage startPage;
    private LoginPage loginPage;
    private MailPage mailPage;
    private YandexPage yandexPage;

    @Test
    public void loginTest() {
        startPage = new StartPage();

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        Assertions.assertEquals(mailPage.getAccountName(),
                ResourceProperties.getCredProperty("login"), "Login failed");
    }

    @Test
    public void logoutTest() {
        startPage = new StartPage();

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        yandexPage = mailPage.logoutUser();

        Assertions.assertTrue(yandexPage.isLoginItemDisplayed(), "Logout failed");
    }

    @AfterEach
    public void closeUp() {
        WebDriverManager.getInstance().delDriver();
    }
}