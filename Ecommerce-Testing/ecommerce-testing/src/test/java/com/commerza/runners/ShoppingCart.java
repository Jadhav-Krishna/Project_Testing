package com.commerza.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/shopping-cart",
        glue = {
                "com.commerza.stepdefinitions.shopping-cart",
                "com.commerza.stepdefinitions.team1",
                "com.commerza.hooks"
        },
        tags = "@ShoppingCart",
        plugin = {
                "pretty",
                "html:test-output/reports/shopping-cart/cucumber-report.html",
                "json:test-output/reports/shopping-cart/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        dryRun = false
)
public class ShoppingCart extends AbstractTestNGCucumberTests {
}
