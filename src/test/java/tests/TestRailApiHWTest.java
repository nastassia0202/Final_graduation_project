package tests;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.CaseBuilder;
import models.MilestoneBuilder;
import models.ProjectBuilder;
import models.SectionBuilder;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EndPoints;

import static io.restassured.RestAssured.given;

public class TestRailApiHWTest {
    int projectID;
    int sectionID;
    int milestoneID;
    int caseID;

    @Test
    public void addProject(){
        ProjectBuilder project = ProjectBuilder.builder()
                .name("FIFOsu")
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_PROJECT)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectID);
    }

    @Test
    public void addMilestone(){
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .name("Milestone1")
                .description("Mymilestone")
                .build();
        milestoneID = given()
                .pathParam("project_id",projectID)
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_MILESTONE)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test
    public void addSection(){
        SectionBuilder section = SectionBuilder.builder()
                .name("Section1")
                .description("Mysection")
                .build();

        sectionID = given()
                .pathParam("project_id",projectID)
                .body(section, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_SECTION)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test
    public void addСase(){
        CaseBuilder caseBuilder = CaseBuilder.builder()
                .checkbox(true)
                .title("Case1")
                .description("Mycase")
                .date("hi")
                .build();

        caseID = given()
                .pathParam("section_id",sectionID)
                .body(caseBuilder, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_CASE)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "addProject")
    public void updateProject(){
        String endpoint = "/index.php?/api/v2/update_project/{project_id}";

        ProjectBuilder projectupd = ProjectBuilder.builder()
                .name("FIFOsu_upd")
                .build();

        Response response =  given()
                .pathParam("project_id",projectID)
                .body(projectupd, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_CASE)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),projectupd.getName());
    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone(){
        String endpoint = "/index.php?/api/v2/update_project/{project_id}";

        ProjectBuilder projectupd = ProjectBuilder.builder()
                .name("FIFOsu_upd")
                .build();

        Response response =  given()
                .pathParam("project_id",projectID)
                .body(projectupd, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_CASE)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),projectupd.getName());
    }

    @Test(dependsOnMethods = "addSection")
    public void updateSection(){
        ProjectBuilder projectupd = ProjectBuilder.builder()
                .name("FIFOsu_upd")
                .build();

        Response response =  given()
                .pathParam("project_id",projectID)
                .body(projectupd, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_CASE)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),projectupd.getName());
    }

    @Test(dependsOnMethods = "addСase")
    public void updateСase(){
        ProjectBuilder projectupd = ProjectBuilder.builder()
                .name("FIFOsu_upd")
                .build();

        Response response =  given()
                .pathParam("section_id",sectionID)
                .body(projectupd, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_CASE)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),projectupd.getName());
    }

    @Test(dependsOnMethods = "updateProject")
    public void deleteProject(){
        given()
                .pathParam("project_id", projectID)
                .when()
                .post(EndPoints.DELETE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone(){
        given()
                .pathParam("milestone_id", milestoneID)
                .when()
                .post(EndPoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "updateSection")
    public void deleteSection(){
        given()
                .pathParam("section_id", sectionID)
                .when()
                .post(EndPoints.DELETE_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "updateСase")
    public void deleteСase(){
        given()
                .pathParam("case_id",caseID)
                .when()
                .post(EndPoints.DELETE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
