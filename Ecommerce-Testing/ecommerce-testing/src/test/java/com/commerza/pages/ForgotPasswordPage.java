package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    private By emailField = By.xpath("//input[@type='email']");
    private By sendResetLinkButton = By.xpath("//button[contains(text(),'Reset') or contains(text(),'Send')]");

    // Dynamic alert locator (works for both success & error)
    private By alertMessage = By.id("customAlert");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    public void enterEmail(String email) {
        elementUtils.sendKeys(emailField, email);
    }

    public void clickSendResetLink() {
        elementUtils.click(sendResetLinkButton);
    }

    public String getConfirmationMessage() {
        try {
            Thread.sleep(1500); // wait for SPA alert render
            return driver.findElement(alertMessage).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public String getErrorMessage() {
        try {
            Thread.sleep(1500);
            return driver.findElement(alertMessage).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isConfirmationMessageDisplayed() {
        try {
            Thread.sleep(1500);
            return driver.findElement(alertMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
