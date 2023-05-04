package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferBetweenUsersPage {

    WebDriver driver;
    @FindBy(css =".aside__label main_color transfer")
    WebElement Transfers;

    @FindBy(partialLinkText="Transfer Between Users")
    WebElement TransferBetweenUsers;

    @FindBy(css=".ng-value-container")
    WebElement DebitForm;

    @FindBy(css="#ab3747425952")
    WebElement Card;

    @FindBy(css="#username")
    WebElement UserName;

    @FindBy(css="#account")
    WebElement Account;

    @FindBy(css="native-input amount ng-pristine ng-invalid with-currency ng-touched")
    WebElement Amount;

    @FindBy(css="def-btn-success main_color")
    WebElement Continue;

    @FindBy(css="def-btn-success main_color")
    WebElement Confirm;

    public TransferBetweenUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void TransferBetweenUsers(){
        Transfers.click();
        TransferBetweenUsers.click();
        DebitForm.click();
        Card.click();
        UserName.sendKeys("jsmith");
        Account.sendKeys("EBQ24123487654");
        Amount.sendKeys("1000");
        Continue.click();
        Confirm.click();
    }
}
