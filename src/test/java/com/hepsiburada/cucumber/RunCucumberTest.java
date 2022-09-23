package com.hepsiburada.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/hepsiburada/stepdefinitions"},
        features = "src/main/resources/features",
        plugin = {"pretty", "summary"})
public class RunCucumberTest {
}
