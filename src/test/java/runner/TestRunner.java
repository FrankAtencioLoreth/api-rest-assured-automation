package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        publish = true,
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cucumber-report/cucumber.xml"}
)
public class TestRunner {
}
