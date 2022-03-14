package tests;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class TestRailApiTest1 extends BaseApiTest {
    int projectID;

    @Test
    public void getAllProjects(){

        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject1(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                        .name("FIFO")
                        .projectAnnouncement("This is the description for the project")
                                .showAnnouncement(true)
                                        .build();


        given()
                .body(String.format("{\n" +
                        "  \"name\" : \"%s\",\n" +
                        "  \"announcement\" : \"%s\",\n" +
                        "  \"show_announcement\": %b,\n" +
                        "  \"suite_mode\" : %d\n" +
                        "}",
                        project.getName(),
                        project.getProjectAnnouncement(),
                        project.isShowAnnouncement(),
                        3))
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void addProject2(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("FIFOs")
                .showAnnouncement(false)
                .build();
        Map<String,Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name",project.getName());
        jsonAsMap.put("showAnnouncement", project.isShowAnnouncement());
        given()
         .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("FIFOsu")
                .build();

        given()
         .body(project, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject4(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("FIFOsu")
                .build();

        projectID = given()
         .body(project, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectID);
    }
@Test(dependsOnMethods = "addProject4")
    public void updateProject(){
        String endpoint = "/index.php?/api/v2/update_project/{project_id}";

        ProjectBuilder projectupd = ProjectBuilder.builder()
                .name("FIFOsu_upd")
                .build();

       Response response =  given()
                .pathParam("project_id",projectID)
                .body(projectupd, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .extract().response();

       Assert.assertEquals(response.getBody().jsonPath().get("name"),projectupd.getName());
    }

    @Test(dependsOnMethods = "updateProject")
    public void deleteProject(){
        String endpoint = "index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

}
