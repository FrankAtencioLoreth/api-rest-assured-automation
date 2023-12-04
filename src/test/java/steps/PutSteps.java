package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.core.Is;
import utils.RestAssuredExt;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class PutSteps {

    @When("I update a book in endpoint {string}")
    public void i_update_a_book_in_endpoint(String url, DataTable table) {
        var data = table.asLists();
        Map<String, String> body = new HashMap<>();
        Map<String, String> pathParams = new HashMap<>();

        pathParams.put("id", data.get(1).get(0));

        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        RestAssuredExt.response = RestAssuredExt.put(url, RestAssuredExt.token, pathParams, body);
    }

    @Then("I see the title is {string}")
    public void i_see_the_title_is(String title) {
        assertThat(RestAssuredExt.response.getBody().jsonPath().get("title"), Is.is(title));
    }
}
