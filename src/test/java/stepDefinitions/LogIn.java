package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjectModel.LogInPage;
import utility.Hooks;

public class LogIn {

    WebDriver driver= Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);

    @When("Customer logs in")
    public void customer_logs_in() {

        logIn.openHomePage();
        logIn.with("demo-user","Demo-Access1");
    }

}
