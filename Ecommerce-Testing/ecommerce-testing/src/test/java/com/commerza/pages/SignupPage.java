package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    private By fullNameField = By.id("fullname");
    private By emailField = By.id("signup-email");
    private By phoneField = By.id("signup-phone");
    private By passwordField = By.id("signup-password");
    private By confirmPasswordField = By.id("signup-confirm-password");
    private By signupButton = By.cssSelector("button[type='submit']");

    private By successMessage = By.xpath(
            "//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'success') " +
            "or contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'registered')]"
    );

    private By errorMessage = By.xpath(
            "//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'exist') " +
            "or contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'already') " +
            "or contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'invalid')]"
    );

    private By loginLink = By.linkText("Login");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    public void navigateToSignupPage(String baseUrl) {
        driver.get(baseUrl + "signup.html");
    }

    public void enterFullName(String fullName) {
        elementUtils.sendKeys(fullNameField, fullName);
    }

    public void enterEmail(String email) {
        elementUtils.sendKeys(emailField, email);
    }

    public void enterPhone(String phone) {
        elementUtils.sendKeys(phoneField, phone);
    }

    public void enterPassword(String password) {
        elementUtils.sendKeys(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        elementUtils.sendKeys(confirmPasswordField, confirmPassword);
    }

    public void clickSignupButton() {
        elementUtils.click(signupButton);
    }

    public void clickLoginLink() {
        elementUtils.click(loginLink);
    }

    public String getSuccessMessage() {
        return elementUtils.getText(successMessage);
    }

    public String getErrorMessage() {
        return elementUtils.getText(errorMessage);
    }

    public boolean isValidationErrorDisplayed(String fieldName) {

        try {

            switch (fieldName.toLowerCase()) {

                case "fullname":
                    return hasValidationMessage("fullname");

                case "email":
                    return hasValidationMessage("signup-email");

                case "phone":
                    return hasValidationMessage("signup-phone");

                case "password":
                    return hasValidationMessage("signup-password");

                case "confirmpassword":

                    String password = driver.findElement(By.id("signup-password")).getAttribute("value");
                    String confirm = driver.findElement(By.id("signup-confirm-password")).getAttribute("value");

                    if (!password.equals(confirm)) {
                        return true;
                    }

                    return hasValidationMessage("signup-confirm-password");

                default:
                    return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    private boolean hasValidationMessage(String id) {
        String message = driver.findElement(By.id(id)).getAttribute("validationMessage");
        return message != null && !message.trim().isEmpty();
    }
}
