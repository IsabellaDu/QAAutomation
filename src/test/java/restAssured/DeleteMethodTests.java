package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class DeleteMethodTests extends BaseApiTest {
    @Test
    public void deleteUser() {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/users/2");
        response
                .then()
                .statusCode(204);
    }
}
