package com.survey.stepDefination;

import com.survey.MobileDrivers.AppiumDriverManager;
import com.survey.Utilities.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

import static com.survey.Utilities.MyService.getInstance;

public class Hooks {
//    public static TreeMap<String,String> map = null;
//    public static Logger logger = Logger.getLogger(Hooks.class);
//
//    @Before
//    public static void SetUp(Scenario s)
//    {
//        logger.info("Test case name : "+s.getName());
//    }

    @Before(order =0)
    public void beforeScenarioStart() throws MalformedURLException {
        AppiumDriverManager.InitializeDriver();
//        AppiumDriver driver = AppiumDriverManager.InitializeDriver();
//        AppiumDriverManager.setDriver(driver);
    }

//    @Before(order =1)
//    public void beforeScenario() throws InterruptedException {
////        Comman_Methods.actionInit();
////        WaitUtils.webDriverWaitInit();
////        Comman_Methods.javascriptInit();
//    }

//    @After(order =0)
//    public void afterScenarioFinished() throws InterruptedException {
//        logger.info("_________End of the Scenario ___________");
//    }

    /*@After(order =1)
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
    }*/

    @After
    public static void afterScenario(Scenario ss){
        GlobalVariables.ScenarioName = ss.getName();
        if(ss.isFailed()){
            MyTestResults.takescreenshot();

        }
        getInstance().flush(0);
        AppiumDriverManager.quitDriver();

    }

}

