package runners;
import steps.Login;
import org.testng.annotations.Test;

public class TestNGRunnerTest {

    @Test(priority = 1)
    public void loginTest() {
        System.out.println("Login Success");
        Login loginTest = new Login();
        loginTest.loginSuccess();
    }

    @Test(priority = 2)
    public void loginFailed() {
        System.out.println("Login Failed");
        Login loginTest = new Login();
        loginTest.loginFailed();
    }
}
