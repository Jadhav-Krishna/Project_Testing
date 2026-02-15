package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private final By emailField = By.id("user-login-email");
    private By passwordField = By.id("user-login-password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By forgotPasswordLink = By.linkText("Forgot Password?");
    private By errorMessage = By.cssSelector("#customAlert");
    private By emailValidationError = By.cssSelector("#user-login-email:invalid");
    private By passwordValidationError = By.cssSelector("#user-login-password:invalid");
    private By signupLink = By.linkText("Sign Up");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public void navigateToLoginPage(String baseUrl) {
        driver.get(baseUrl + "login.html");
    }
    
    public void enterEmail(String email) {
        elementUtils.sendKeys(emailField, email);
    }
    
    public void enterPassword(String password) {
        elementUtils.sendKeys(passwordField, password);
    }
    
    public void clickLoginButton() {
        elementUtils.click(loginButton);
    }
    
    public void clickForgotPasswordLink() {
        elementUtils.click(forgotPasswordLink);
    }
    
    public void clickSignupLink() {
        elementUtils.click(signupLink);
    }
    
    public String getErrorMessage() {
        return elementUtils.getText(errorMessage);
    }
    
    public boolean isEmailValidationErrorDisplayed() {
        return elementUtils.isDisplayed(emailValidationError);
    }
    
    public boolean isPasswordValidationErrorDisplayed() {
        return elementUtils.isDisplayed(passwordValidationError);
    }
    
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
