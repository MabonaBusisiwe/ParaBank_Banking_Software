package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.cssSelector("input.button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isAtAccountOverview() {
        return driver.getTitle().contains("ParaBank | Accounts Overview");
    }

    public boolean isErrorDisplayed() {
        try {
            WebElement errorMsg = driver.findElement(By.xpath("//p[@class='error']"));
            return errorMsg.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void clickLogout() {
        driver.findElement(By.linkText("Log Out")).click();
    }

}
