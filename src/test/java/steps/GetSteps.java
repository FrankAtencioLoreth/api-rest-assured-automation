package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.RestAssuredExt;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetSteps {

    @When("I get all books in endpoint {string}")
    public void i_get_all_books_in_endpoint(String url) {
        RestAssuredExt.response = RestAssuredExt.get(url, RestAssuredExt.token);
    }

    @When("I Get a specific book in the endpoint {string}")
    public void i_get_a_specific_book_in_the_endpoint(String url, DataTable table) {
        var data = table.asLists();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("id", data.get(1).get(0));
        RestAssuredExt.response = RestAssuredExt.get(url, RestAssuredExt.token, pathParams);
    }

    @Then("I see the unique autor name as {string}")
    public void i_see_the_unique_autor_name_as(String author) {
        assertThat(RestAssuredExt.response.getBody().jsonPath().get("author"), containsString(author));
    }
}
