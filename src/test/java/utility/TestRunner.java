package utility;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        tags = "@smoke",
        glue = {"stepDefinitions", "utility"},
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
)
public class TestRunner {

}
