package com.survey.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Survey_features/"}, glue = {"com.survey.stepDefination"},
        plugin = {"pretty", "html:target/Cucumber_Reports/cucumber-htmlReports", "json:target/cucumber-reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun = false, monochrome = true,
         tags = ("@survey_smoke_test"))

public class SurveyTestRunner extends AbstractTestNGCucumberTests {


}
