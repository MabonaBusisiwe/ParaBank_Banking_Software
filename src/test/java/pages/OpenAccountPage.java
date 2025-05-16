package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {

    WebDriver driver;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Login method
    public void login(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    // Navigate to Open New Account page
    public void navigateToOpenAccountPage() {
        driver.findElement(By.linkText("Open New Account")).click();
    }

    // Select account type from dropdown
    public void selectAccountType(String accountType) {
        WebElement accountTypeDropdown = driver.findElement(By.id("type"));
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType);
    }

    // Select an existing account from dropdown (default to first option)
    public void selectExistingAccount() {
        WebElement existingAccountDropdown = driver.findElement(By.id("fromAccountId"));
        Select select = new Select(existingAccountDropdown);
        select.selectByIndex(0); // Select the first account
    }

    // Click the Open New Account button
    public void clickOpenNewAccountButton() {
        driver.findElement(By.cssSelector("input[value='Open New Account']")).click();
    }

    // Get confirmation message or new account ID
    public String getConfirmationMessage() {
        WebElement confirmation = driver.findElement(By.id("newAccountId"));
        return confirmation.getText();
    }


}
