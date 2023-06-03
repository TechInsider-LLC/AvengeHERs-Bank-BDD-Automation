package stepDefinitions;



import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectModel.LogInPage;
import utility.TestRunner;
import utility.ScenarioData;

import static org.testng.Assert.assertEquals;

public class LogIn {

    WebDriver driver= TestRunner.getDriver();
    LogInPage logIn = new LogInPage(driver);



    @When("Customer logs in")
    public void customer_logs_in() throws InterruptedException {


        logIn.openHomePage();
        Thread.sleep(2000);
        logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
    }

    @Then("Customer should be successfully logged in")
    public void customer_should_be_successfully_logged_in() throws InterruptedException {
        String expected = "Log Out";
        Thread.sleep(2000);
        String actual = driver.findElement(By.cssSelector(".controls__logout")).getText();
        assertEquals(expected, actual);
    }

}
