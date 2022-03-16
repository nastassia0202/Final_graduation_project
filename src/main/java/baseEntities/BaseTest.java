package baseEntities;

import com.google.gson.Gson;
import core.ApiService;
import core.DriverService;

import io.restassured.response.Response;
import model.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static constant.EndPointsApi.*;
import static io.restassured.RestAssured.given;


public class BaseTest {

    public User validUser;


    @BeforeClass
    public void setUp() {
        int userID = 1;
        Gson gson = new Gson();
        DriverService.initDriver();
        ApiService.initApi();
        Response response = given()
                .pathParam("id",userID)
                .get(GET_USER);
        validUser = gson.fromJson(response.getBody().asString(), User.class);

    }


    @AfterClass
    public void tearDown() {
        DriverService.close();
    }
}
