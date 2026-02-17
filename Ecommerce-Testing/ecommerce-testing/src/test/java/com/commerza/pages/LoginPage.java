package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By emailField = By.id("user-login-email");
    private By passwordField = By.id("user-login-password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By forgotPasswordLink = By.xpath("//a[contains(text(),'Forgot')]");
    private By signupLink = By.xpath("//a[contains(text(),'Sign')]");

    private By errorMessage = By.xpath(
    	    "//div[contains(@class,'alert') and string-length(text()) > 0]"
    	);


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
    
    // SAFE error reader (won’t crash test if element not found)
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    
    // Proper HTML5 validation handling (works reliably)
    public boolean isEmailValidationErrorDisplayed() {
        WebElement email = driver.findElement(emailField);
        String validationMessage = email.getAttribute("validationMessage");
        return validationMessage != null && !validationMessage.trim().isEmpty();
    }

    public boolean isPasswordValidationErrorDisplayed() {
        WebElement password = driver.findElement(passwordField);
        String validationMessage = password.getAttribute("validationMessage");
        return validationMessage != null && !validationMessage.trim().isEmpty();
    }
    
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}

