package starter.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.API.TodoistAPI;
import static org.hamcrest.Matchers.equalTo;

public class GetAllProjectsStepDef {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Get all projects with valid path {string}")
    public void getAllProjectsWithAllValidValue(String path) {
        todoistAPI.getAllProjects(path);
    }

    @When("Send request get all projects")
    public void sendRequestGetAllProjects() {
        SerenityRest.when().get(TodoistAPI.GET_ALL_PROJECTS);
    }

//Scenario2
    @Given("Get all projects with valid path {string} empty authorization")
    public void getAllProjectsEmptyAuthorization(String path) {
       todoistAPI.getAllProjectsWithoutAuthorization(path);
    }

    @And("Body contain {string}")
    public void bodyContain(String message) {
        SerenityRest.then().body(equalTo(message));
    }
//Scenario3
    @Given("Get all projects invalid path {string} with special character")
    public void getAllProjectsInvalidWithSpecialCharacter(String path) {
        todoistAPI.getAllProjects(path);
    }

    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
//Scenario4
    @Given("Get all projects invalid path {string} with character")
    public void getAllProjectsInvalidWithCharacter(String path) {
        todoistAPI.getAllProjects(path);
    }
    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Given("Get all projects invalid path {int} with value integer")
    public void getAllProjectsInvalidPathWithValueInteger(int path) {
        todoistAPI.getAllProjectsInvalidPathInteger(path);
    }
}
