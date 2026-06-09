package com.survey.stepDefination;

import com.survey.Pages.LoginPage;
import io.cucumber.java.en.Given;

import static com.survey.Utilities.AppiumDriverInitialization.getDriver;


public class SurveyLoginSteps {

    LoginPage loginPage = new LoginPage(getDriver());

    @Given("login to the survey application with valid credentials")
        public void login_to_the_survey_application_with_valid_credentials(){
            loginPage.login_to_the_survey_application_with_valid_credentials();

    }
}
