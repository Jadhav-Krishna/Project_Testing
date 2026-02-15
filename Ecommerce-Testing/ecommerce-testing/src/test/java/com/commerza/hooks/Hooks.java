package com.commerza.hooks;

import com.commerza.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(DriverManager::quitDriver));
    }

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting Scenario: " + scenario.getName());
        DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null && scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (Exception ignored) {
            }
        }
        System.out.println("Completed Scenario: " + scenario.getName());
    }

    @SuppressWarnings("unused")
    private void resetBrowserStorage(WebDriver driver) {
        if (driver instanceof JavascriptExecutor jsExecutor) {
            try {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl != null && currentUrl.startsWith("http")) {
                    jsExecutor.executeScript("window.sessionStorage.clear(); window.localStorage.clear();");
                }
            } catch (Exception ignored) {
            }
        }
    }
}
