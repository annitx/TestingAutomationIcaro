package com.qaautomation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.qaautomation.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@BugsForm"
)
public class TestRunner {
}

