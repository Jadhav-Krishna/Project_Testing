package com.orangehrm.testing.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static void initDrive() {
		String browser = ConfigLoader.getProperty("browser").toLowerCase();
		boolean headless = Boolean.parseBoolean(ConfigLoader.getProperty("headless"));
		switch(browser) {
			case "chrome":
				ChromeOptions copt = new ChromeOptions();
				if (headless) {
					copt.addArguments("--headless=new");
				}
				driver.set(new ChromeDriver(copt));
				break;
			case "firefox":
				FirefoxOptions fopt = new FirefoxOptions();
				if (headless) {
					fopt.addArguments("--headless");
				}
				driver.set(new FirefoxDriver(fopt));
				break;
			default:
				throw new RuntimeException("Browser Not supported: " + browser);
		}
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get().manage().window().maximize();
	}
	
	public static WebDriver getDriver() {
		if (driver.get() == null) {
			initDrive();
		}
		return driver.get();
	}
	
	public static void quitDriver() {
		driver.get().quit();
		driver.remove();
	}
}
