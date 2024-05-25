import Pages.LoginPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class CorrectRegistrationTests extends BaseTest {

    @Test
    public void incorrectRegistration() {
        String randomMail = UUID.randomUUID().toString().substring(0, 10) + "@test.com";

        new LoginPage(BaseTest.driver)
                .clickRegister()
                .typeEmail(randomMail)
                .typePassword("Sratatata!123")
                .typeConfirmPassword("Sratatata!123")
                .submitLoginWithSuccess()
                .assertWelcomeElementIsShow();
        }
}
