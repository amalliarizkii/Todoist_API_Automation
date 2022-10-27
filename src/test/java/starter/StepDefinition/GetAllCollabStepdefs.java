package starter.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.API.TodoistAPI;

public class GetAllCollabStepdefs {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Set to url unauthorized {string}")
    public void setToUrlUnauthorized(String url) {
        SerenityRest.given()
                .baseUri(url);
    }

    @When("Send request get all collaborators")
    public void sendRequestGetAllCollaborators() {
        SerenityRest.when().get();
    }

    @Then("Then Should return {int} Unauthorized")
    public void thenShouldReturnUnauthorized(int Unauthorized) {
        SerenityRest.then().statusCode(Unauthorized);
    }

    @Given("Set to url authorized {string}")
    public void setToUrlAuthorized(String url) {
        SerenityRest.given()
                .baseUri(url)
                .headers("Authorization", "Bearer d256eb8544ab45ff968db31541e1f058ce0ce5d6");
    }
}
