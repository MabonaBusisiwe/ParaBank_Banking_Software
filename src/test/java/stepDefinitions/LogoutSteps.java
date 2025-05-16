package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.BaseClass;

public class LogoutSteps extends BaseClass {

    @When("User clicks the logout link")
    public void user_clicks_the_logout_link() {
        driver.findElement(By.linkText("Log Out")).click(); // or use openAccountPage.clickLogoutLink() if abstracted
    }

    @Then("User should be redirected to the login page")
    public void user_should_be_redirected_to_the_login_page() {
        String loginPageTitle = driver.getTitle();
        Assert.assertTrue("User is not redirected to login page", loginPageTitle.contains("ParaBank"));
    }
}
