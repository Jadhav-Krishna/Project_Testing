package com.orangehrm.testing.pom;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.testing.utils.ConfigLoader;
import com.orangehrm.testing.utils.DriverManager;

public class AdminViewSystemUsers {
	private WebDriver driver;
	By adminusermanagementHeader = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
	By userTable = By.cssSelector("div.oxd-table-body.oxd-card-table-body");
	By userCard = By.cssSelector("div.card-center");
	By recordsCount = By.cssSelector("div.orangehrm-paper-container span.oxd-text.oxd-text--span");

	public AdminViewSystemUsers() {
		this.driver = DriverManager.getDriver();
	}
	public void navigateToAdminview() {
		String adminviewURL = "/web/index.php/admin/viewSystemUsers";
		driver.get(ConfigLoader.getProperty("base_url") + adminviewURL);
	}
	public boolean isAdminHeaderVisible() {
		return driver.findElement(adminusermanagementHeader).isDisplayed();
	}
	public int getRecordsCount() {
		String text = driver.findElement(recordsCount).getText();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher match = pattern.matcher(text);
		if (match.find()) {
			return Integer.parseInt(match.group());
		}
		return -1;
	}
	public List<WebElement> getUserCards() {
		WebElement table = driver.findElement(userTable);
		return table.findElements(userCard);
	}
}
