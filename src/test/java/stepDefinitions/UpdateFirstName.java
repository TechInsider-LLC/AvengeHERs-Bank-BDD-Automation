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
        logIn.with(ScenarioData.get("username"),ScenarioData.get("password"));
        Thread.sleep(3000);
        name.updateFirstName();

    }
    @Then("First Name should be updated successfully")
    public void first_name_should_be_updated_successfully() throws InterruptedException {
        String expected = "Max Doe";
        driver.navigate().refresh();
        String actual = driver.findElement(By.xpath("//*[contains(text(), \"Full Name \")]/following-sibling::span")).getText();
        Thread.sleep(2000);
        assertEquals(expected, actual);
    }

    @When("Customer changes back First Name")
    public void customer_changes_back_first_name() throws InterruptedException {

        name.changeBackFirstName();

    }

    @Then("First name Should be changed back successful")
    public void first_name_should_be_changed_back_successful() throws InterruptedException {
        String expected = "John Doe";
        String actual = driver.findElement(By.xpath("//*[contains(text(), \"Full Name \")]/following-sibling::span")).getText();
        Thread.sleep(2000);
        assertEquals(expected, actual);

    }
}
