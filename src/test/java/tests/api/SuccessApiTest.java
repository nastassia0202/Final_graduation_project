package tests.api;

import api.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import model.User;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Randomization;


import static api.EndPoints.*;
import static io.restassured.RestAssured.given;

public class SuccessApiTest extends BaseApiTest {
    Randomization randomization = new Randomization();
    int id = 19;

    @Test
    public void getAllUsers() {
        given()
                .when()
                .get(GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addUser() {
        User user = User.builder()
                .login(randomization.randomString(5))
                .password(randomization.randomString(5))
                .build();

        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(ADD_USER)
                .then().log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test(dependsOnMethods = "addUser")
    public void updateUserById() {
        User user = User.builder()
                .login(randomization.randomString(5))
                .password(randomization.randomString(5))
                .build();

        Response response = given()
                .pathParam("id", id)
                .body(user, ObjectMapperType.GSON)
                .when()
                .put(UPDATE_USER)
                .then()
                .log().body()
                .extract().response();


    }

    @Test(dependsOnMethods = "updateUserById")
    public void deleteUserById() {
        given()
                .pathParam("id", id)
                .when()
                .delete(DELETE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}