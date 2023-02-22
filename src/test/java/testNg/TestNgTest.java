package testNg;

import com.hillel.components.BecomeCoachFormComponent;
import com.hillel.core.data.DataProviderMethods;
import com.hillel.listeners.RetryListener;
import com.hillel.pages.CoachesPage;
import com.hillel.pages.HomePage;
import org.testng.annotations.Test;

import static com.hillel.util.WaitUtils.*;

public class TestNgTest extends BaseTest {

    @Test(priority = 1)
    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
    }

    @Test(dataProvider = "data", dataProviderClass = DataProviderMethods.class, retryAnalyzer = RetryListener.class)
    public void setBecomeCoachForm(String name, String lastName,
                                   String country, String phoneNumber,
                                   String email, String cityCode,
                                   String companyName, String jobPosition,
                                   String linkedInUrl) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.getElAboutSchoolDropDown().click();
        waitUntilElementIsClickable(driver, homePage.getElCoachesCta());
        homePage.getElCoachesCta().click();

        CoachesPage coachesPage = new CoachesPage(driver);
        coachesPage.getElBecomeCoachCta().click();

        BecomeCoachFormComponent becomeCoachFormComponent = new BecomeCoachFormComponent(driver);
        waitUntilElementIsVisible(driver, becomeCoachFormComponent.getElComponent());
        becomeCoachFormComponent.setName(name);
        becomeCoachFormComponent.setLastName(lastName);

        becomeCoachFormComponent.getElPhoneCodeDropDown().click();
        becomeCoachFormComponent.setCountryPhoneCode(country);

        becomeCoachFormComponent.setPhoneNumber(phoneNumber);
        becomeCoachFormComponent.setEmail(email);

        becomeCoachFormComponent.getElCityDropDown().click();
        becomeCoachFormComponent.setCity(cityCode);

        becomeCoachFormComponent.setCompany(companyName);
        becomeCoachFormComponent.setJobPosition(jobPosition);
        becomeCoachFormComponent.setLinkedInUrl(linkedInUrl);
    }
}
