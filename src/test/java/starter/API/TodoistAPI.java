package starter.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class TodoistAPI {

    public static String URL = "https://api.todoist.com";
    public static String AUTH = "d256eb8544ab45ff968db31541e1f058ce0ce5d6";
    public static String GET_PROJECT = URL+"/rest/v1/projects/{id}";
    public static String GET_PROJECT_INVALID = URL+"/rest/v1/projects=/=/";
    public static String POST_CREATE_PROJECT = URL+"/rest/v1/projects";
    public static String POST_CREATE_PROJECT_INVALID = URL+"/rest/v1=/=/=/projects";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY_FILE = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA_VALIDATOR_FILE = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String DELETE_PROJECT = "https://api.todoist.com/rest/v1/{id}";
    public static String GET_ALL_PROJECTS = URL+"/rest/v1/{path}";
    public static String UPDATE_A_PROJECT = URL+"/rest/v1/projects/2299947157";
    public static String UPDATE_PROJECT_InvalidID = URL+"/rest/v1/projects/{id}";


    @Step("Post Create Project Authorization")
    public void setPostCreateProject(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization", "Bearer d256eb8544ab45ff968db31541e1f058ce0ce5d6");
    }

    @Step("Post Create Project Unauthorized")
    public void setPostCreateProjectUnauthorized(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get all projects")
    public void getAllProjects(String path) {
        SerenityRest.given().headers("Authorization","Bearer "+AUTH)
                .pathParam("path", path);
    }

    @Step("Get all projects without Authorization")
    public void getAllProjectsWithoutAuthorization(String path) {
        SerenityRest.given().pathParam("path", path);
    }

    @Step("Get all projects invalid path int")
    public void getAllProjectsInvalidPathInteger(int path) {
        SerenityRest.given().headers("Authorization","Bearer "+AUTH)
            .pathParam("path", path);
    }

    @Step("Post update project")
    public void postUpdateProject(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer "+AUTH);
    }

    @Step("Post update project empty Authorization")
    public void postUpdateProjectEmptyAuthorization(File json){

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get projects")
    public void getProjects(String id){
        SerenityRest.given()
                .headers("Authorization", "Bearer d256eb8544ab45ff968db31541e1f058ce0ce5d6")
                .pathParam("id", id);
    }

    @Step("Get projects without auth")
    public void getProjectsWithoutAuth(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post update project invalid id")
    public void postUpdateProjectInvalidID(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer "+AUTH);
    }

    @Step("Delete project with valid id")
    public void deleteProjectValidID(String id) {
      SerenityRest.given()
              .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

    @Step("Delete project without authorized")
    public void deleteProjectUnauthorized(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delete project not register id")
    public void deleteProjectNotRegisterId(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

    @Step("Delete project with minimum digit id")
    public void deleteProjectMinimumId(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

    @Step("Delete project with invalid id")
    public void deleteProjectInvalidId(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }
    @Step("Delete project with special char id")
    public void deleteProjectSpecialChar(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer "+AUTH)
                .pathParam("id", id);
    }

}
