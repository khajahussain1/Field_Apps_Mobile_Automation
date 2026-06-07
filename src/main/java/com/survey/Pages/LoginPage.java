package com.survey.Pages;

import com.survey.Utilities.Comman_Methods;
import com.survey.Utilities.MyTestResults;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yaml.snakeyaml.internal.Logger;

public class LoginPage extends Comman_Methods {
    AppiumDriver driver;

MyTestResults myTestResults = new MyTestResults();
//public Logger logger = Logger.getLogger(LoginPage.class);

//page objects
@FindBy(xpath = "abc")
WebElement survey;

//constructor
    public LoginPage(AppiumDriver driver)
    {

        this.driver=driver;
        PageFactory.initElements(driver, null);
    }


    public void login_to_the_survey_application_with_valid_credentials(){

    }
}
