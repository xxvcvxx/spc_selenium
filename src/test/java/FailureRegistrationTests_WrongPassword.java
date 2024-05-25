import Pages.LoginPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class FailureRegistrationTests_WrongPassword extends BaseTest {


    @Test
    public void failureRegistration_WrongPassword()
    {
        String randomMail = UUID.randomUUID().toString().substring(0, 10) + "@test.com";

        new LoginPage(BaseTest.driver)
                .clickRegister()
                .typeEmail(randomMail)
                .typePassword("abc")
                .typeConfirmPassword("abc")
                .submitLoginWithFailure()
                .assertIncorrectPasswordOnListToShort();
    }

    @Test
    public void failureRegistration_WrongPasswordWithoutSpecial()
    {
        String randomMail = UUID.randomUUID().toString().substring(0, 10) + "@test.com";

        new LoginPage(BaseTest.driver)
                .clickRegister()
                .typeEmail(randomMail)
                .typePassword("Abc123")
                .typeConfirmPassword("Abc123")
                .submitLoginWithFailure()
                .assertIncorrectPasswordOnListWithoutSpecial();
    }
    @Test
    public void failureRegistration_WrongPasswordWithoutUppercase()
    {
        String randomMail = UUID.randomUUID().toString().substring(0, 10) + "@test.com";

        new LoginPage(BaseTest.driver)
                .clickRegister()
                .typeEmail(randomMail)
                .typePassword("abc123!")
                .typeConfirmPassword("abc123!")
                .submitLoginWithFailure()
                .assertIncorrectPasswordOnListWithoutUppercase();
    }
}
