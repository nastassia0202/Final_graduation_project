package tests.api;

import api.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;


import static api.EndPoints.*;
import static io.restassured.RestAssured.given;

public class PositiveTest extends BaseApiTest {

    int id = 4;
    @Test
    public void simpleApiTest(){
        given()
                .when()
                .get(GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void addProject3(){
        User user = User.builder()
                .login("FIFA")
                .password("offal")
                .build();

        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(ADD_USER)
                .then().log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void updateProject(){


        User user = User.builder()
                .login("FIFOsu_upd")
                .password("tytytyyty")
                .build();

        Response response =  given()
                .pathParam("id",id)
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(UPDATE_USER)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),user.getLogin());
    }

    @Test
    public void deleteProject(){
        given()
                .pathParam("id", "3")
                .when()
                .post(DELETE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
