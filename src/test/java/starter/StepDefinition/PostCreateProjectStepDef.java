package starter.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.API.TodoistAPI;
import starter.ResponseBody.TodoistResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateProjectStepDef {

    @Steps
    TodoistAPI todoistAPI;

    @When("Send request post create new project")
    public void sendRequestPostCreateNewProject() {
        SerenityRest.when().post(TodoistAPI.POST_CREATE_PROJECT);
    }

    @Given("Post create new project")
    public void postCreateNewProject() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE+"/CreateProjectValidBody.json");
        todoistAPI.setPostCreateProject(json);
    }

    @And("Body response should contain {string} and {int}")
    public void bodyResponseShouldContain(String name, int color) {
        SerenityRest.then()
                .body(TodoistResponse.NAME, equalTo(name))
                .body(TodoistResponse.COLOR, equalTo(color));
    }

    @And("Post create new project json schema validator")
    public void postCreateNewProjectJsonSchemaValidator() {
        File json = new File(TodoistAPI.JSON_SCHEMA_VALIDATOR_FILE+"/PostCreateProjectJsonSchemaValidator.json");
        todoistAPI.setPostCreateProject(json);
    }

    @Given("Post create new invalid project")
    public void postCreateNewInvalidProject() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE+"/CreateProjectInvalidBody.json");
        todoistAPI.setPostCreateProject(json);
    }

    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }

    @Given("Post create new project without body")
    public void postCreateNewWithoutBodyProject() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE+"/CreateProjectWithoutBody.json");
        todoistAPI.setPostCreateProject(json);
    }

    @When("Send request post create new project invalid param")
    public void sendRequestPostCreateNewProjectInvalidParam() {
        SerenityRest.when().post(TodoistAPI.POST_CREATE_PROJECT_INVALID);
    }

    @Given("Post create new project without auth")
    public void postCreateNewProjectWithoutAuth() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE+"/CreateProjectValidBody.json");
        todoistAPI.setPostCreateProjectUnauthorized(json);
    }
}
