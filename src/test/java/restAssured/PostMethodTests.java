package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PostMethodTests extends BaseApiTest {

    @Test
    public void createUser() {
        Response response = RestAssured
                .given()
                .body(Map.of(
                        "name", "morpheus",
                        "job", "leader"))
                .contentType(ContentType.JSON)
                .post("/users");
        response
                .then()
                .statusCode(201);
    }

    @Test
    public void checkRegisterIsSuccessful() {
        Response response = RestAssured
                .given()
                .body(Map.of(
                        "email", "eve.holt@reqres.in",
                        "password", "pistol"))
                .contentType(ContentType.JSON)
                .post("/register");
        response
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(4));
    }

    @Test
    public void checkRegisterIsUnsuccessful() {
        Response response = RestAssured
                .given()
                .body(Map.of(
                        "email", "sydney@fife"
                ))
                .contentType(ContentType.JSON)
                .post("/register");
        response
                .then()
                .statusCode(400)
                .body("error", Matchers.equalTo("Missing password"));
    }

    @Test
    public void checkLoginIsSuccessful() {
        Response response = RestAssured
                .given()
                .body(Map.of(
                        "email", "eve.holt@reqres.in",
                        "password", "cityslicka"
                ))
                .contentType(ContentType.JSON)
                .post("/login");
        response
                .then()
                .statusCode(200)
                .body("token", Matchers.equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void checkLoginIsUnsuccessful() {
        Response response = RestAssured
                .given()
                .body(Map.of(
                        "email", "peter@klaven"
                ))
                .contentType(ContentType.JSON)
                .post("/login");
        response
                .then()
                .statusCode(400)
                .body("error", Matchers.equalTo("Missing password"));
    }


}
