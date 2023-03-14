package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PatchMethodTests extends BaseApiTest {
    @Test
    public void updateUsersInfo() {
        Response response = RestAssured
                .given()
                .body(Map.of(
                        "name", "morpheus",
                        "job", "zion resident"))
                .contentType(ContentType.JSON)
                .when()
                .patch("/users/2");
        response
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo("morpheus"));
        response
                .prettyPrint();
    }
}
