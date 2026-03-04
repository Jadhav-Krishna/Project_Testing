package com.orangehrm.testing.hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.testing.utils.DriverManger;

public class StartupTeardownhook {
	@BeforeMethod
	public void startUp() {
		DriverManger.initDrive();
	}
	
	@AfterMethod
	public void tearDown() {
		DriverManger.quitDriver();
	}
}
