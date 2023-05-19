package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectModel.LogInPage;
import pageObjectModel.UpdateFirstNamePage;
import utility.Hooks;
import utility.ScenarioData;

import static org.junit.Assert.assertEquals;

public class UpdateFirstName {
    WebDriver driver = Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);

    UpdateFirstNamePage name = new UpdateFirstNamePage(driver);


    @When("Customer changes First Name")
    public void customer_changes_first_name() throws InterruptedException {
        logIn.openHomePage();
        logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(3000);
        name.UpdateFirstNamePage();

    }
    @Then("First Name should be updated successfully")
    public void first_name_should_be_updated_successfully() {
        String expected = "Full Name Jack Doe";
        String actual = driver.findElement(By.xpath("//*[contains(text(), \"Full Name \")]")).getText();
        assertEquals(expected, actual);


    }

}
