package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjectModel.LogInPage;
import pageObjectModel.OutgoingWireTransferPage;
import utility.Hooks;

public class OutgoingWireTransfer {

    WebDriver driver= Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    OutgoingWireTransferPage transfer = new OutgoingWireTransferPage(driver);

    @Given("Customer has test data for {string}")
    public void customer_has_test_data_for(String string) {

    }

    @When("User initiates an outgoing wire transfer")
    public void user_initiates_an_outgoing_wire_transfer() {
        logIn.openHomePage();
        logIn.with("demo-user","Demo-Access1");
        transfer.OutgoingWireTransfer();

    }
    @Then("Customer should be successfully outgoing wire transfer")
    public void customer_should_be_successfully_outgoing_wire_transfer() {

    }

}
