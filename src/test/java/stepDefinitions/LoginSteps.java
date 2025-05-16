package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.TransferPage;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    TransferPage transferPage;

    // Utility to initialize browser
    public void initializeDriver(String url) {
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    // Utility to close browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ========= Valid Login =========
    @Given("User is on the ParaBank login page")
    public void user_is_on_login_page() {
        initializeDriver("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("User enters valid username and password")
    public void enter_valid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");
        loginPage.enterPassword("demo");
    }

    @And("clicks the login button")
    public void click_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the account overview page")
    public void verify_login_success() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("overview.htm"));
        closeBrowser();
    }

    // ========= Invalid Login =========
    @When("User enters invalid username and password")
    public void enter_invalid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrong");
        loginPage.enterPassword("wrong");
    }

    @Then("User should see an error message")
    public void verify_login_error() {
        Assert.assertTrue("Expected error message not displayed", loginPage.isErrorDisplayed());
        closeBrowser();
    }


    // ========= Transfer Funds =========
    @Given("User is logged in to ParaBank")
    public void user_is_logged_in() {
        initializeDriver("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");
        loginPage.enterPassword("demo");
        loginPage.clickLogin();
    }

    @When("User navigates to Transfer Funds page")
    public void navigate_to_transfer_funds() {
        driver.findElement(By.linkText("Transfer Funds")).click();
        transferPage = new TransferPage(driver);
    }

    @And("enters transfer amount and selects accounts")
    public void enter_transfer_details() {
        transferPage.enterAmount("100");
        transferPage.selectFromAccount("13344");
        transferPage.selectToAccount("13344");
    }

    @And("clicks the transfer button")
    public void click_transfer_button() {
        transferPage.clickTransfer();
    }

    @Then("User should see a transfer confirmation message")
    public void verify_transfer_confirmation() {
        Assert.assertTrue("Transfer confirmation not displayed", transferPage.isTransferConfirmed());
        closeBrowser();
    }

    @When("User clicks the logout link")
    public void click_logout() {
        loginPage.clickLogout();
    }

    @Then("User should be redirected to the login page")
    public void verify_redirect_to_login_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on login page after logout", currentUrl.contains("index.htm"));
        closeBrowser();
    }

}
