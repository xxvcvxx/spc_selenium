import Pages.LoginPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class FailureRegistrationTests_UnmatchedPasse extends BaseTest {
    @Test
    public void failureRegistration_WrongPasswordWithoutUppercase()
    {
        String randomMail = UUID.randomUUID().toString().substring(0, 10) + "@test.com";

        new LoginPage(BaseTest.driver)
                .clickRegister()
                .typeEmail(randomMail)
                .typePassword("Abc123!")
                .typeConfirmPassword("AAbc123!")
                .submitLoginWithFailure()
                .submitLoginWithFailure()
                .assertUnPass();
    }
}
