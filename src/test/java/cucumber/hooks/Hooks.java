package cucumber.hooks;

import cucumber.steps.BaseUiSteps;
import io.cucumber.java.AfterAll;

public class Hooks extends BaseUiSteps {

    @AfterAll(order = Integer.MAX_VALUE)
    public static void afterAll() {
        driver.quit();
    }
}
