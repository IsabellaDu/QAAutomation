package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumber/features",
        plugin = {"pretty"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
