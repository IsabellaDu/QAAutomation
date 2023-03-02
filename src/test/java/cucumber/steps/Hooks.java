package cucumber.steps;

import io.cucumber.java.AfterAll;

public class Hooks extends BaseUiSteps {

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
