package pageObjectModel;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.TransferBetweenAccounts;
import utility.Hooks;
import utility.ScenarioData;



import static org.junit.Assert.assertEquals;

public class TransferBetweenAccountsPage {

    WebDriver driver = Hooks.getDriver();
    LogInPage logIn = new LogInPage(Hooks.getDriver());
    TransferBetweenAccounts transfer = new TransferBetweenAccounts(driver);



    @When("User transfers between accounts")
    public void user_transfers_money() throws InterruptedException {

        logIn.openHomePage();
        Thread.sleep(2000);
         logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(2000);
        transfer.TransferBetweenAccounts();

    }



    @Then("User have to transfer successfully")
    public void user_have_to_transfer_successfully() {
        String expected = "Back to transfers.";
        String actual = driver.findElement(By.cssSelector(".text_color-main_color")).getText();
        assertEquals(expected, actual);

    }
}




