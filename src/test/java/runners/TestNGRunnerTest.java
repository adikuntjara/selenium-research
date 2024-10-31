package runners;
import steps.Login;
import org.testng.annotations.Test;

public class TestNGRunnerTest {

    @Test
    public void loginTest() {
        System.out.println("Running TestNG test");
        Login loginTest = new Login();
        loginTest.loginTestCase();
    }
}
