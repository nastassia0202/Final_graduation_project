package tests.api;

import api.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static api.EndPoints.GET_DRESS;
import static api.EndPoints.GET_USER;
import static io.restassured.RestAssured.given;

public class AFEApiTest extends BaseApiTest {

    @Test
    public void getUserByInvalidId(){
        int id = 4;
        given()
                .pathParam("id",id)
                .when()
                .get(GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }

    @Test
    public void getDressByInvalidId(){
        int id = 4;
        given()
                .pathParam("id",id)
                .when()
                .get(GET_DRESS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }
}
