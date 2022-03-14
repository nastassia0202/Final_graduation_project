package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresApiTest {

    @Test
    public void simpleStepByStepApiTest(){
        RestAssured.baseURI = "https://reqres.in/";
        int userID = 2;
        String endpoint = "/api/users/"+userID;
        RequestSpecification httpRequest = given();
        Response response = httpRequest.request(Method.GET,endpoint);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        String body = response.getBody().asString();
        System.out.println(body);
    }

    @Test
    public void simpleShortApiTest(){
        RestAssured.baseURI = "https://reqres.in/";
        int userID = 2;
        String endpoint = "/api/users/"+userID;
        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
