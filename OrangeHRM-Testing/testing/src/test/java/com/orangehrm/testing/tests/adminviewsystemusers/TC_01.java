package com.orangehrm.testing.tests.adminviewsystemusers;

import org.testng.annotations.Test;

import com.orangehrm.testing.hooks.StartupTeardownhook;
import com.orangehrm.testing.utils.ConfigLoader;

public class TC_01 extends StartupTeardownhook {
	@Test
	public void initialize() {
		String loginURL = ConfigLoader.getProperty("auth_login_url");
		System.out.println("URL: " + loginURL);
	}
}