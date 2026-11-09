package com.survey.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = {"src/test/resources/Survey_features/"}, glue = {"com.survey.stepDefination"},
        plugin = {"pretty", "html:target/Cucumber_Reports/cucumber-htmlReports", "json:target/cucumber-reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun = false, monochrome = true,
         tags = ("@Survey_smoke_test"))

public class SurveyTestRunner extends AbstractTestNGCucumberTests {

//@DataProvider(parallel = false)
//public Object[][] scenarios(){
//    return super.scenarios();
//
//    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Scenario Execution started");
    }

    @AfterClass(alwaysRun=true)
    public void afterClass()
    {
        System.out.println("Scenario Execution is completed");
    }
}
