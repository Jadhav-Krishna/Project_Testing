package com.orangehrm.testing.hooks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orangehrm.testing.utils.DriverManager;

public class StartupTeardownhook {
	@BeforeClass
	public void startUp() {
		DriverManager.getDriver();
	}
	
	@AfterClass
	public void tearDown() {
		DriverManager.quitDriver();
	}
}
