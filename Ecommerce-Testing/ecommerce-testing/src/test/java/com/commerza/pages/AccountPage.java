package com.commerza.pages;

import com.commerza.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    
    private WebDriver driver;
    private ElementUtils elementUtils;
    
    private By accountDashboard = By.cssSelector(".container");
    private By profileInfo = By.cssSelector("input#accountProfileName");
    private By profileEmail = By.id("accountProfileEmail");
    private By accountMenu = By.cssSelector(".card");
    private By editProfileButton = By.cssSelector("button[onclick*='edit']");
    private By firstNameField = By.id("accountProfileName");
    private By phoneField = By.id("phone");
    private By saveChangesButton = By.cssSelector("button[type='submit']");
    private By successMessage = By.id("customAlert");
    private By changePasswordLink = By.xpath("//*[contains(text(),'Change Password')]");
    private By currentPasswordField = By.id("current-password");
    private By newPasswordField = By.id("new-password");
    private By confirmNewPasswordField = By.id("confirm-password");
    private By updatePasswordButton = By.cssSelector("#updatePasswordForm button[type='submit']");
    private By logoutButton = By.xpath("//*[contains(text(),'Logout')]");

    
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    public void navigateToAccountPage(String baseUrl) {
        driver.get(baseUrl + "account.html");
    }
    
    public boolean isAccountDashboardDisplayed() {
        return elementUtils.isDisplayed(accountDashboard);
    }
    
    public boolean isProfileInfoDisplayed() {
        return elementUtils.isDisplayed(profileInfo);
    }
    
    public boolean isAccountMenuDisplayed() {
        return elementUtils.isDisplayed(accountMenu);
    }
    
    public void clickEditProfile() {
        elementUtils.click(editProfileButton);
    }
    
    public void updateFirstName(String firstName) {
        elementUtils.sendKeys(firstNameField, firstName);
    }
    
    public void updatePhoneNumber(String phone) {
        elementUtils.sendKeys(phoneField, phone);
    }
    
    public void clickSaveChanges() {
        elementUtils.click(saveChangesButton);
    }
    
    public String getSuccessMessage() {
        return elementUtils.getText(successMessage);
    }
    
    public void clickChangePassword() {
        elementUtils.click(changePasswordLink);
    }
    
    public void enterCurrentPassword(String password) {
        elementUtils.sendKeys(currentPasswordField, password);
    }
    
    public void enterNewPassword(String password) {
        elementUtils.sendKeys(newPasswordField, password);
    }
    
    public void enterConfirmNewPassword(String password) {
        elementUtils.sendKeys(confirmNewPasswordField, password);
    }
    
    public void clickUpdatePassword() {
        elementUtils.click(updatePasswordButton);
    }
    
    public void clickLogout() {
        elementUtils.click(logoutButton);
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
