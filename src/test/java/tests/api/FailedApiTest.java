package tests.api;

import api.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static api.EndPoints.GET_USER;
import static io.restassured.RestAssured.given;

public class FailedApiTest extends BaseApiTest {

    @Test
    public void getValidStatusCodeByInvalidId(){
        int id = 4;
        given()
                .pathParam("id",id)
                .when()
                .get(GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getInvalidStatusCodeByValidId(){
        int id = 5;
        given()
                .pathParam("id",id)
                .when()
                .get(GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

    }
}
