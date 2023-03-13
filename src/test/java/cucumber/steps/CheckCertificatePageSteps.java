package cucumber.steps;

import com.hillel.pages.CheckCertificatePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class CheckCertificatePageSteps extends BaseUiSteps {
    CheckCertificatePage checkCertificatePage = new CheckCertificatePage(driver);

    @Given("User wrote certificate number: {} down")
    public void writeCertificateNumberDown(String number) {
        checkCertificatePage.open();
        checkCertificatePage.setNumberOfCertificate(number);
    }

    @Then("User clicked on the button and checks message by certificate number")
    public void checkMessageIsDisplayed() {
        checkCertificatePage.getElCheckCertificateCta().click();
        waitUntilElementIsVisible(driver, checkCertificatePage.getElCertificateMessage());
        Assertions.assertEquals("Сертифікат не знайдено",
                checkCertificatePage.getElCertificateMessage().getText(),
                "expected message does not match actual message");
    }
}
