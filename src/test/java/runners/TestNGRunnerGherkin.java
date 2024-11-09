package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature file(s)
        glue = {"steps"},                         // Package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"} // To generate reports
)
public class TestNGRunnerGherkin extends AbstractTestNGCucumberTests {
}
