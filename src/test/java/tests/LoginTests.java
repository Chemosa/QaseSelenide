package tests;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void successLogin() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
    }
}
