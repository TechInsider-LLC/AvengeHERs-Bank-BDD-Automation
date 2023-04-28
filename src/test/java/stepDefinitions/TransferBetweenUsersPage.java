package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferBetweenUsersPage {

    WebDriver driver;

    @FindBy(css=".header .aside-bar__menu-toggle")
    WebElement Menu;

    @FindBy(partialLinkText ="TRANSFERS")
    WebElement Transfer;

    @FindBy(partialLinkText="Transfer Between Users")
    WebElement TransferBetweenUsers;

    @FindBy(css=".ng-placeholder")
    WebElement DebitForm;

    @FindBy(css="#a7a3573d7782")
    WebElement Card;

    @FindBy(css="#username")
    WebElement UserName;

    @FindBy(css="#account")
    WebElement Account;

    @FindBy(css="native-input amount ng-pristine ng-invalid with-currency ng-touched")
    WebElement Amount;

    @FindBy(css="def-btn-success main_color")
    WebElement Continue;




}
