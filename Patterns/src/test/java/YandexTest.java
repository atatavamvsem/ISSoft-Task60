import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
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


    @Test
    @DisplayName("Yandex User login test")
    @Story("Login test")
    @Description("Correct login")
    @TmsLink("test-1")
    public void loginTest() {
        startPage = new StartPage();

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        Assertions.assertEquals(mailPage.getAccountName(),
                ResourceProperties.getCredProperty("login"), "Login failed");
    }

    @Test
    @DisplayName("Yandex User logout test")
    @Story("Logout test")
    @Description("Correct logout")
    @TmsLink("test-2")
    public void logoutTest() {
        startPage = new StartPage();

        loginPage = startPage.enterButtonClick();

        mailPage = loginPage.loginUser(ResourceProperties.getCredProperty("login"), ResourceProperties.getCredProperty("password"));

        yandexPage = mailPage.logoutUser();

        Assertions.assertTrue(yandexPage.isLoginItemDisplayed(), "Logout failed");
    }
}