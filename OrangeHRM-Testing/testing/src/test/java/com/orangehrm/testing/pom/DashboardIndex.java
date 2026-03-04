package com.orangehrm.testing.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.testing.utils.DriverManager;

public class DashboardIndex {
	private WebDriver driver;
	By dashboardHeading = By.cssSelector("h6.oxd-text");
	
	public DashboardIndex() {
		this.driver = DriverManager.getDriver();
	}
	
	public boolean isDashboardVisible() {
		return driver.findElement(dashboardHeading).isDisplayed();
	}
}
