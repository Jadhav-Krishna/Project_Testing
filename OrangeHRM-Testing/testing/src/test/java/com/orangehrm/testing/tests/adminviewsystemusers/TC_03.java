package com.orangehrm.testing.tests.adminviewsystemusers;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.orangehrm.testing.hooks.StartupTeardownhook;
import com.orangehrm.testing.pom.AdminViewSystemUsers;
import com.orangehrm.testing.pom.AuthLogin;
import com.orangehrm.testing.pom.DashboardIndex;
import com.orangehrm.testing.utils.ConfigLoader;

public class TC_03 extends StartupTeardownhook{
	private AuthLogin loginPage = new AuthLogin();
	private DashboardIndex dashboardPage = new DashboardIndex();
	private AdminViewSystemUsers adminPage = new AdminViewSystemUsers();

	@Test(priority = 1)
	public void loginWithValidCredentials() {
		String username = ConfigLoader.getProperty("auth_username");
		String password = ConfigLoader.getProperty("auth_password");
		loginPage.navigateToAuthlogin();
		loginPage.login(username, password);
		assertTrue(dashboardPage.isDashboardVisible(), "Dashboard not visible, login failed");
	}

	@Test(priority = 2)
	public void isOnAdminPage() {
		adminPage.navigateToAdminview();
		assertTrue(adminPage.isAdminHeaderVisible(), "Admin page header not visible");
	}

	@Test(priority = 3)
	public void selectDropdownAndSearch() {
		adminPage.selectFilterDropdown("User Role", "Admin");
		adminPage.clickFilterButton("Search");
	}
}
