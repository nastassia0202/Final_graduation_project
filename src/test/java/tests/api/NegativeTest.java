package tests.api;

import api.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static api.EndPoints.GET_USER;
import static io.restassured.RestAssured.given;

public class NegativeTest extends BaseApiTest {

    @Test
    public void simpleApiTest(){
        int id = 1;
        given()
                .pathParam("id",id)
                .when()
                .get(GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }


}
