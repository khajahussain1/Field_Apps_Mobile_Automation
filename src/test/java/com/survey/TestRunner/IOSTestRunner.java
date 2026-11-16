package com.survey.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/Survey_features/"}, glue = {"com.survey.stepDefination", "Hooks"},
        plugin = {"pretty", "html:target/Cucumber_Reports/cucumber-htmlReports", "json:target/cucumber-reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun = false, monochrome = false,
         tags = "@ios")

public class IOSTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
