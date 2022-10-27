package starter.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.API.TodoistAPI;

import static org.hamcrest.Matchers.equalTo;

public class DeleteStepdefs {

    @Steps
    TodoistAPI todoistAPI;

    //DeleteMethod_001
    @Given("Delete a project with valid id {string}")
    public void deleteAProjectWithValidId(String id) {
        todoistAPI.deleteProjectValidID(id);
    }

    @When("Send request delete a project")
    public void sendRequestDeleteAProject() {
        SerenityRest.when().delete(TodoistAPI.DELETE_PROJECT);
    }

    @Then("Should return {int} No content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    //DeleteMethod_002
    @Given("Delete project valid id {string} without authorized")
    public void deleteProjectValidIdWithoutAuthorized(String id) {
        todoistAPI.deleteProjectUnauthorized(id);
    }

    @And("Response body should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then().body(equalTo(message));
    }

    //DeleteMethod_003
    @Given("Delete project not register id {string}")
    public void deleteProjectNotRegisterId(String id) {
        todoistAPI.deleteProjectNotRegisterId(id);
    }

    @Then("Should return {int} Not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    //DeleteMethod_004
    @Given("Delete project with minimum digit id {string}")
    public void deleteProjectWithMinimumDigitId(String id) {
        todoistAPI.deleteProjectMinimumId(id);
    }

    //DeleteMethod_005
    @Given("Delete project with invalid id {string}")
    public void deleteProjectWithInvalidId(String id) {
        todoistAPI.deleteProjectInvalidId(id);
    }

    @Then("Should return {int} Bad request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //DeleteMethod_006
    @Given("Delete project with special char id {string}")
    public void deleteProjectWithSpecialCharId(String id) {
        todoistAPI.deleteProjectSpecialChar(id);
    }

}

