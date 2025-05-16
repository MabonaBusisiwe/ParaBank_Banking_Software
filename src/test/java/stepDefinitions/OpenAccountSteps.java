package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OpenAccountPage;
import utilities.BaseClass;

public class OpenAccountSteps extends BaseClass {

    OpenAccountPage openAccountPage;

    @When("User navigates to Open New Account page")
    public void user_navigates_to_open_new_account_page() {
        openAccountPage = new OpenAccountPage(driver);
        openAccountPage.navigateToOpenAccountPage();
    }

    @When("User selects account type {string} and existing account")
    public void user_selects_account_type_and_existing_account(String accountType) {
        openAccountPage.selectAccountType(accountType);
        openAccountPage.selectExistingAccount();
    }

    @When("User clicks the open new account button")
    public void user_clicks_the_open_new_account_button() {
        openAccountPage.clickOpenNewAccountButton();
    }

    @Then("A new account should be created and displayed")
    public void a_new_account_should_be_created_and_displayed() {
        String newAccountId = openAccountPage.getConfirmationMessage();
        Assert.assertTrue("New account ID is not displayed!", newAccountId.matches("\\d+"));
        System.out.println("New Account ID: " + newAccountId);
    }
}
