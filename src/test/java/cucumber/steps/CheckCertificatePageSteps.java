package cucumber.steps;

import com.hillel.pages.CheckCertificatePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class CheckCertificatePageSteps extends BaseUiSteps {
    CheckCertificatePage checkCertificatePage = new CheckCertificatePage(driver);

    @Given("User wrote certificate number: {} down")
    @Test(priority = 1)
    public void writeCertificateNumberDown(String number) {
        checkCertificatePage.open();
        checkCertificatePage.setNumberOfCertificate(number);
    }

    @Then("User clicked on the button and checks message by certificate number")
    @Test(dependsOnMethods = {"writeCertificateNumberDown"})
    public void checkMessageIsDisplayed() {
        checkCertificatePage.getElCheckCertificateCta().click();
        waitUntilElementIsVisible(driver, checkCertificatePage.getElCertificateMessage());
        Assertions.assertEquals("Сертифікат не знайдено",
                checkCertificatePage.getElCertificateMessage().getText(),
                "expected message does not match actual message");
    }
}
