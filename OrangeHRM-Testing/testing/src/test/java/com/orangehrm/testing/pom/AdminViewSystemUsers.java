package com.orangehrm.testing.pom;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.testing.utils.ConfigLoader;
import com.orangehrm.testing.utils.DriverManager;

public class AdminViewSystemUsers {
	private WebDriver driver;
	private WebDriverWait wait;
	By adminusermanagementHeader = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
	By userTable = By.cssSelector("div.oxd-table-body.oxd-card-table-body");
	By userCard = By.cssSelector("div.card-center");
	By recordsCount = By.cssSelector("div.orangehrm-paper-container span.oxd-text.oxd-text--span");
	By addRecordButton = By.cssSelector("div.orangehrm-header-container button");
	By addUserForm = By.cssSelector("form.oxd-form");
	By searchFilterInputs = By.cssSelector("div.oxd-table-filter-area form input");
	By searchFilterDropdowns = By.cssSelector("div.oxd-table-filter-area form div.oxd-select-wrapper");
	By searchFilterButtons = By.cssSelector("div.oxd-table-filter-area button");

	public AdminViewSystemUsers() {
		this.driver = DriverManager.getDriver();
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
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
	public boolean clickAddButton() {
		new Actions(driver)
			.moveToElement(driver.findElement(addRecordButton))
			.click()
			.perform();
		if (driver.getCurrentUrl().contains("saveSystemUser")) {
			return true;
		}
		return false;
	}
	public void selectFilterDropdown(String ddtext, String option) {
		List<WebElement> filterDropdowns = driver.findElements(searchFilterDropdowns);
		WebElement elem = null;
		switch(ddtext) {
		case "User Role":
			elem = filterDropdowns.get(0);
			new Actions(driver).moveToElement(filterDropdowns.get(0)).click().perform();
			switch(option) {
			case "Admin":
				new Actions(driver)
					.sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER)
					.perform();
				break;
			case "ESS":
				new Actions(driver)
					.sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER)
					.perform();
				break;
			default:
				throw new RuntimeException("Invalid options");
			}
			break;
		case "Status":
			break;
		default:
			throw new RuntimeException("Invalid dropdown column selected");
		}
		if (elem != null) {
			wait.until(ExpectedConditions.textToBePresentInElement(elem, option));
		}
	}
	public void clickFilterButton(String btntext) {
		List<WebElement> filterButtons = driver.findElements(searchFilterButtons);
		switch(btntext) {
		case "Search":
			new Actions(driver).moveToElement(filterButtons.get(1)).click().perform();
			break;
		case "Reset":
			new Actions(driver).moveToElement(filterButtons.get(0)).click().perform();
			break;
		default:
			throw new RuntimeException("Invalid Button text");
		}
	}
}