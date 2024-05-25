import Pages.LoginPage;
import config.Config;
import org.testng.annotations.Test;

public class CorrectLogin extends BaseTest {

    @Test
    public void correctLoginTest() {
        new LoginPage(BaseTest.driver)
                .typeEmail(new Config().getApplicationUser())
                .typePassword(new Config().getApplicationPassword())
                .submitLogin()
                .assertWelcomeElementIsShow();
    }
}
