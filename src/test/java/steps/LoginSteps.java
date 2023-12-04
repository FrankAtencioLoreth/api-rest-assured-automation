package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.core.Is;
import utils.RestAssuredExt;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {

    @Given("I perform authenticate operation for {string}")
    public void i_perform_authenticate_operation_for(String url, DataTable table) {
        var data = table.asLists();
        Map<String, String> body = new HashMap<>();
        body.put("email", data.get(1).get(0));
        body.put("password", data.get(1).get(1));

        RestAssuredExt.response = RestAssuredExt.authenticate(url, body);

        if(RestAssuredExt.response!=null) {
            RestAssuredExt.token = RestAssuredExt.response.getBody().jsonPath().getString("access_token");
        }
    }

    @Then("I see the status code is {int}")
    public void i_see_the_status_code_is(int statusCode) {
        assertThat(RestAssuredExt.response.getStatusCode(), Is.is(statusCode));
    }
}
