import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import pages.MailPage;
import pages.StartPage;
import pages.YandexPage;

@Feature("Yandex tests")
@ExtendWith(AttachmentExtension.class)
public class YandexTest {
    private StartPage startPage;
    private LoginPage loginPage;
    private MailPage mailPage;
    private YandexPage yandexPage;


    @DisplayName("Human-readable test name")
    @Story("Login test")
    @Description("Some detailed test description")
    @Test
    public void loginTest() {
        startPage = new StartPage();

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        Assertions.assertEquals(mailPage.getAccountName(),
                ResourceProperties.getCredProperty("login"), "Login failed");
    }

    @Test
    @Story("Logout test")
    @DisplayName("Human-readable test name")
    @Description("Some detailed test description")
    public void logoutTest() {
        startPage = new StartPage();

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        yandexPage = mailPage.logoutUser();

        Assertions.assertTrue(yandexPage.isLoginItemDisplayed(), "Logout failed");
    }
}