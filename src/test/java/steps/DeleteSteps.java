package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import utils.RestAssuredExt;

import java.util.HashMap;
import java.util.Map;

public class DeleteSteps {

    @When("I delete a book in endpoint {string}")
    public void i_delete_a_book_in_endpoint(String url, DataTable table) {
        var data = table.asLists();
        Map<String, String> pathParams = new HashMap<>();

        pathParams.put("id", data.get(1).get(0));

        RestAssuredExt.response = RestAssuredExt.delete(url, RestAssuredExt.token, pathParams);
    }
}
