package com.orangehrm.testing.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.testing.utils.ConfigLoader;
import com.orangehrm.testing.utils.DriverManager;

public class AuthLogin {
	private WebDriver driver;
	By usernameField = By.cssSelector("form input[name='username']");
	By passwordField = By.cssSelector("form input[name='password']");
	By submitButton = By.cssSelector("form button[type='submit']");

	public AuthLogin() {
		this.driver = DriverManager.getDriver();
	}
	
	public void navigateToAuthlogin() {
		String loginPagePath = "/web/index.php/auth/login";
		driver.get(ConfigLoader.getProperty("base_url") + loginPagePath);
	}
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickSubmitButton();
	}
}
