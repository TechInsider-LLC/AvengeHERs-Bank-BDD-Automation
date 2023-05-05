package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.LogInPage;
import utility.Hooks;
import utility.ScenarioData;

public class WireTransfer {

    LogInPage login = new LogInPage(Hooks.getDriver());


    @When("Customer wire transfers money")
    public void customer_wire_transfers_money() throws InterruptedException {
        login.openHomePage();
        login.with(ScenarioData.get("username"), ScenarioData.get("password"));
        System.out.println(ScenarioData.get("amount"));
    }
    @Then("Wire transfer should success")
    public void wire_transfer_should_success() {

    }
}
