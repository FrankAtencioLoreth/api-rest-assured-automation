package steps;

import io.cucumber.java.Before;
import utils.RestAssuredExt;

public class Hooks {

    @Before
    public void setup() {
        RestAssuredExt restAssuredExt = new RestAssuredExt();
    }
}
