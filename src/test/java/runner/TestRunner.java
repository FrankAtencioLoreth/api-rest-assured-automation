import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"src.test.java.steps"},
        tags = "@TC_AUTH_01",
        publish = true
)
public class TestRunner {
}
