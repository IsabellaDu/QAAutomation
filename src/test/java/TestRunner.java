import com.hillel.core.driver.WebDriverFactory;
import com.hillel.pages.QAAutomationCoursePage;
import org.openqa.selenium.WebDriver;

import static com.hillel.core.CommonPageMethods.*;


public class TestRunner {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver();

        QAAutomationCoursePage qaCoursePage = new QAAutomationCoursePage(driver);
        qaCoursePage.open();

        System.out.println(qaCoursePage.getCourseTitle());
        System.out.println(qaCoursePage.getCourseRate());

        isClickable(driver, qaCoursePage.getElConsultationCta());
        //clickAfterEnsureElementIsClickable(driver, qaCoursePage.getElConsultationCta());
        //clickToBtnAndCheckElementIsNotVisible(driver, qaCoursePage.getElHillelLogoCta(), qaCoursePage.getElCourseTitlePath());

        driver.quit();

    }
}
