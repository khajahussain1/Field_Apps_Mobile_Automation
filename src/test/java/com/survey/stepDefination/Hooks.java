package com.survey.stepDefination;

import com.survey.Utilities.*;
import io.appium.java_client.flutter.commands.WaitParameter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.DriverManager;
import java.util.TreeMap;

import static com.survey.Utilities.AppiumDriverInitialization.getDriver;
import static com.survey.Utilities.MyService.getInstance;

public class Hooks extends Comman_Methods {
    public static TreeMap<String,String> map = null;
    public static Logger logger = Logger.getLogger(Hooks.class);

    @Before
    public static void SetUp(Scenario s)
    {
        logger.info("Test case name : "+s.getName());
    }

    @Before(order =0)
    public void beforeScenarioStart()
    {
        AppiumDriverInitialization.initDriver();
        logger.info("Start of the scenario");
    }

    @Before(order =1)
    public void beforeScenario() throws InterruptedException {
        Comman_Methods.actionInit();
        WaitUtils.webDriverWaitInit();
        Comman_Methods.javascriptInit();
    }

    @After(order =0)
    public void afterScenarioFinished() throws InterruptedException {
        logger.info("_________End of the Scenario ___________");
    }

    @After(order =1)
    public void afterScenario(Scenario scenario) throws InterruptedException {
        if(getDriver()!=null)
        {
            if(scenario.isFailed()){

                String TestCaseName = scenario.getName();
                scenario.log("Current page url is "+getDriver().getCurrentUrl());
                scenario.log(TestCaseName+" is failed "+scenario.isFailed());
                scenario.attach(embedScreenshot(), "image/png", TestCaseName);
                File currentDir = new File(System.getProperty("user.dir")+"/target/Cucumberreports/Screenshots/");
                map = new TreeMap<String, String>();

            }
            logger.info("Test case completed");
        }
        getInstance().flush(0);
        WaitUtils.standedWait(5);
    }

    @AfterStep
    public static void takeScreenshot(Scenario ss){
        GlobalVariables.ScenarioName = ss.getName();
        if(ss.isFailed()){
            MyTestResults.takescreenshot();

        }
        getInstance().flush(0);

    }

}

