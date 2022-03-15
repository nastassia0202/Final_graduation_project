package tests.api;

import api.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static api.EndPoints.GET_ALL_USERS;
import static io.restassured.RestAssured.given;

public class PositiveTest extends BaseApiTest {
    @Test
    public void simpleApiTest(){
        given()
                .when()
                .get(GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
