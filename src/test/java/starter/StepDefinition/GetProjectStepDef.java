package starter.StepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.API.TodoistAPI;

import java.io.File;

public class GetProjectStepDef {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Set path to {string} with no authorization")
    public void setPathWithNoAuthorization(String url) {
        SerenityRest.given()
                .baseUri(url);
    }

    @When("Send request get project")
    public void sendRequestGetProject() {
        SerenityRest.when().get(TodoistAPI.GET_PROJECT);
    }

    @Then("Should return {int} Unauthorized")
    public void shouldReturnUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }

    @Given("Set path to {string}")
    public void setPathTo(String url) {
        SerenityRest.given()
                .baseUri(url)
                .headers("Authorization", "Bearer d256eb8544ab45ff968db31541e1f058ce0ce5d6");
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Get project json schema validator")
    public void getProjectJsonSchemaValidator() {
        File json = new File(TodoistAPI.JSON_SCHEMA_VALIDATOR_FILE+"/GetProjectJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }

    @When("Send request get project with invalid parameter")
    public void sendRequestGetProjectWithInvalidParameter() {
        SerenityRest.when().post(TodoistAPI.GET_PROJECT_INVALID);
    }

    @Given("Get project with valid id {string}")
    public void getProjectWithValidId(String id) {
        todoistAPI.getProjects(id);
    }

    @Given("Get project with valid id without auth {string}")
    public void getProjectWithValidIdWithoutAuth(String id) {
        todoistAPI.getProjectsWithoutAuth(id);
    }

    @Given("Get project with invalid id {string}")
    public void getProjectWithInvalidId(String id) {
        todoistAPI.getProjects(id);
    }

    @Given("Get project with unexisting id {string}")
    public void getProjectWithUnexistingIdId(String id) {
        todoistAPI.getProjects(id);
    }
}