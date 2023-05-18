package utility;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;



@CucumberOptions(
        features = {"src/test/java/features"},
        tags = "@regression",
        glue = {"stepDefinitions", "utility"},
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser){
        Hooks.browser.set(browser);
    }

}
