package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectModel.CardFundingTransferPage;
import pageObjectModel.LogInPage;
import pageObjectModel.OutgoingWireTransferPage;
import utility.Hooks;
import utility.ScenarioData;

import static org.testng.Assert.assertEquals;

public class CardFundingTransfer {

    WebDriver driver = Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    CardFundingTransferPage transfer = new CardFundingTransferPage(driver);

    @When("Customer initiates a transfer from one card to another")
    public void customer_initiates_a_transfer_from_one_card_to_another() throws InterruptedException {

        logIn.openHomePage();
        logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(3000);
        transfer.CardFundingTransferPage();


    }
    @Then("Customer should be successfully Card Funding Transfer")
    public void customer_should_be_successfully_card_funding_transfer() throws InterruptedException {
        String expected = "Back to transfers";
        Thread.sleep(3000);
        String actual = driver.findElement(By.cssSelector(".text_color-main_color")).getText();
        assertEquals(expected, actual);

    }

}
