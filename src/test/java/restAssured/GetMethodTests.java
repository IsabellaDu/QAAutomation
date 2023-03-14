package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetMethodTests extends BaseApiTest {
    @Test
    public void getListOfUsers() {
        Response response = RestAssured
                .given()
                .when()
                .get("/users?page=2");
        response
                .then()
                .statusCode(200);
    }

    @Test
    public void getSingleUser() {
        Response response = RestAssured
                .given()
                .when()
                .get("/users/3");
        response
                .then()
                .statusCode(200);
    }

    @Test
    public void getSingleUserNotFound() {
        Response response = RestAssured
                .given()
                .when()
                .get("/users/23");
        response
                .then()
                .statusCode(404);
    }

    @Test
    public void getListResource() {
        Response response = RestAssured
                .given()
                .when()
                .get("/unknown");
        response
                .then()
                .statusCode(200);
//        response
//                .prettyPrint();
    }

    @Test
    public void getSingleResourceNotFound() {
        Response response = RestAssured
                .given()
                .when()
                .get("/unknown/23");
        response
                .then()
                .statusCode(404);
    }

    @Test
    public void getDelayedResponse() {
        Response response = RestAssured
                .given()
                .when()
                .get("/users?delay=3");
        response
                .then()
                .statusCode(200);
    }
}
