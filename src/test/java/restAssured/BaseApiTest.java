package restAssured;

import com.hillel.util.ConfigProvider;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    public static void initialize() {
        RestAssured.baseURI = ConfigProvider.getBASE_API_URL();
        RestAssured.basePath = ConfigProvider.getBASE_API_PATH();
    }
}
