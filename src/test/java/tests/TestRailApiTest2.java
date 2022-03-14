package tests;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.UserBuilder;
import org.apache.http.HttpStatus;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EndPoints;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest2 extends BaseApiTest {

    @Test
    public void getUser(){
        UserBuilder userBuilder = UserBuilder.builder()
                .name("Alex Lisov")
                .email("lisovskijsanya0@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();
        given()
                .when()
                .get(EndPoints.GET_ALLUSERS)
                .then().log().body()
                .body("get(0).name",is(userBuilder.getName()))
                .body("get(0).email", equalTo(userBuilder.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUser2(){
        int userID = 1;
        UserBuilder expectedUserBuilder = UserBuilder.builder()
                .name("Alex Lisov")
                .email("lisovskijsanya0@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();
       UserBuilder actualUserBuilder = given()
                 .pathParam("id",userID)
                 .get(EndPoints.GET_USER)
                 .then()
                 .log().body()
                 .assertThat()
                 .statusCode(HttpStatus.SC_OK)
                 .extract()
                 .as((Type) UserBuilder.class);
        Assert.assertEquals(actualUserBuilder, expectedUserBuilder);
    }

    @Test
    public void getUser1(){
        int userID = 1;
        Gson gson = new Gson();
        UserBuilder expectedUserBuilder = UserBuilder.builder()
                .name("Alex Lisov")
                .email("lisovskijsanya0@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();
        Response response = given()
                .pathParam("id",userID)
                .get(EndPoints.GET_USER);
        UserBuilder actualUserBuilder = gson.fromJson(response.getBody().asString(), UserBuilder.class);
        Assert.assertEquals(actualUserBuilder, expectedUserBuilder);
    }

    @Test
    public void getUsers(){
        int userID = 1;
        Gson gson = new Gson();
        UserBuilder expectedUserBuilder = UserBuilder.builder()
                .name("Alex Lisov")
                .email("lisovskijsanya0@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();
        Response response = given()
                .get(EndPoints.GET_ALLUSERS);
        UserBuilder[] actualUserBuilder = gson.fromJson(response.getBody().asString(), UserBuilder[].class);
        Assert.assertEquals(actualUserBuilder[0], expectedUserBuilder);
    }

    @Test
    public void getUsers1(){
        int userID = 1;
        Gson gson = new Gson();
        UserBuilder expectedUserBuilder = UserBuilder.builder()
                .name("Alex Lisov")
                .email("lisovskijsanya0@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();
        Response response = given()
                .get(EndPoints.GET_ALLUSERS);

        Type listType = new TypeToken<ArrayList<UserBuilder>>(){}.getType();
        List<UserBuilder> actualUserBuilderList = gson.fromJson(response.getBody().asString(), listType);
        Assert.assertEquals(actualUserBuilderList.get(0), expectedUserBuilder);
    }

}
