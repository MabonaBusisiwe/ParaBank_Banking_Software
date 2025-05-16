package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferPage {
    WebDriver driver;

    By amountField = By.id("amount");
    By fromAccountDropdown = By.id("fromAccountId");
    By toAccountDropdown = By.id("toAccountId");
    By transferButton = By.cssSelector("input.button");
    By confirmationMessage = By.xpath("//h1[contains(text(),'Transfer Complete')]");

    public TransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAmount(String amount) {
        driver.findElement(amountField).sendKeys(amount);
    }

    public void selectFromAccount(String account) {
        new Select(driver.findElement(fromAccountDropdown)).selectByVisibleText(account);
    }

    public void selectToAccount(String account) {
        new Select(driver.findElement(toAccountDropdown)).selectByVisibleText(account);
    }

    public void clickTransfer() {
        driver.findElement(transferButton).click();
    }

    public boolean isTransferConfirmed() {
        return driver.getPageSource().contains("Transfer Complete!");
    }
}
