package starter.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.API.TodoistAPI;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PostUpdateProject {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Post update project")
    public void postUpdateProject() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProject.json");
        todoistAPI.postUpdateProject(json);
    }

    @When("Send request post update project")
    public void sendRequestPostUpdateProject() {
        SerenityRest.when().post(TodoistAPI.UPDATE_A_PROJECT);
    }

    @Then("Should return {int} no content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
//Scenario2
    @Given("Post update project empty authorization")
    public void postUpdateProjectEmptyAuthorization() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProject.json");
        todoistAPI.postUpdateProjectEmptyAuthorization(json);
    }

    @And("Return body contain {string}")
    public void returnBodyContain(String message) {
        SerenityRest.then().body(equalTo(message));
    }
//Scenario3
    @Given("Post update project invalid id {int}")
    public void postUpdateProjectInvalidIdId(int id) {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProject.json");
        todoistAPI.postUpdateProjectInvalidID(id,json);
    }
    @When("Send request post update project invalid id")
    public void sendRequestUpdateProjectsInvalidID(){
        SerenityRest.when().post(TodoistAPI.UPDATE_PROJECT_InvalidID);
    }
//Scenario4
    @Given("Post update project empty body request")
    public void postUpdateProjectEmptyBodyRequest() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProjectEmpty.json");
        todoistAPI.postUpdateProject(json);
    }

    @And("Return body contain message {string}")
    public void returnBodyContainMessage(String message) {
        SerenityRest.then().body(equalTo(message));
    }
//Scenario5
    @Given("Post update project only input body name without color and favorite")
    public void postUpdateProjectOnlyInputBodyName() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProjectOnlyName.json");
        todoistAPI.postUpdateProject(json);
    }
//Scenario6
    @Given("Post update project only input body color without name and favorite")
    public void postUpdateProjectOnlyInputBodyColor() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProjectOnlyColor.json");
        todoistAPI.postUpdateProject(json);
    }
//Scenario7
    @Given("Post update project only input body favorite without name and color")
    public void postUpdateProjectOnlyInputBodyFavorite() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProjectOnlyFavorite.json");
        todoistAPI.postUpdateProject(json);
    }
//Scenario8
    @Given("Post update project without input name")
    public void postUpdateProjectWithoutInputName() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProjectWithoutName.json");
        todoistAPI.postUpdateProject(json);
    }
//Scenario9
    @Given("Post update project without input color")
    public void postUpdateProjectWithoutInputColor() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProjectWithoutColor.json");
        todoistAPI.postUpdateProject(json);
    }
//Scenario10
    @Given("Post update project without input favorite")
    public void postUpdateProjectWithoutInputFavorite() {
        File json = new File(TodoistAPI.JSON_REQUEST_BODY_FILE +"/PostUpdateProjectWithoutFavorite.json");
        todoistAPI.postUpdateProject(json);
    }
}
