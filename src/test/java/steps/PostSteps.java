package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.core.Is;
import utils.RestAssuredExt;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostSteps {

    @When("I register a book in endpoint {string}")
    public void i_register_a_book_in_endpoint(String url, DataTable table) {
        var data = table.asLists();
        System.out.println(data);
        Map<String, String> body = new HashMap<>();
        //body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        RestAssuredExt.response = RestAssuredExt.post(url, RestAssuredExt.token, body);
    }

    @Then("I see the status code for book post is {int}")
    public void i_see_the_status_code_for_book_post_is(int statusCode) {
        assertThat(RestAssuredExt.response.getStatusCode(), Is.is(statusCode));
    }

    @Then("I see the autor name as {string}")
    public void i_see_the_author_name_as(String author) {
        assertThat(RestAssuredExt.response.getBody().jsonPath().get("author"), hasItem(author));
    }
}
