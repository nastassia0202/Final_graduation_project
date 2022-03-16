package core;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;

import static constant.Urls.API_URL;
import static io.restassured.RestAssured.given;

public class ApiService {

    public static void initApi(){
        RestAssured.baseURI = API_URL;
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }




}
