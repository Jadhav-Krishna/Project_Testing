package com.commerza.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/authentication",
        glue = {"com.commerza.stepdefinitions.authentication", "com.commerza.hooks"},
        tags = "@Authentication",
        plugin = {
                "pretty",
                "html:test-output/reports/authentication/cucumber-report.html",
                "json:test-output/reports/authentication/cucumber.json"
        },
        monochrome = true,
        dryRun = false
)
public class Authentication extends AbstractTestNGCucumberTests {
}
