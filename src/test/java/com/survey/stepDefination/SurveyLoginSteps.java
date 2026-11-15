package com.survey.stepDefination;

import com.survey.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.survey.MobileDrivers.AppiumDriverManager.getDriver;


public class SurveyLoginSteps {

        private LoginPage loginPage;

        @Given("the mobile app is launched")
        public void mobileAppIsLaunched() {
            loginPage = new LoginPage(getDriver());
        }

        @When("I enter username {string}")
        public void enterUsername(String username) throws InterruptedException {
            loginPage.enterUsername(username);
        }


        @When("I enter password {string}")
        public void enterPassword(String password) throws InterruptedException {
            loginPage.enterPassword(password);
        }

        @When("I submit the login form")
        public void submitLoginForm() throws InterruptedException {
            loginPage.submit();
        }

        /*@Then("the home screen should be displayed")
        public void homeScreenShouldBeDisplayed() {
            assertTrue(context.getLoginPage().isHomeDisplayed(),
                    "Expected home screen was not displayed.");
        }

        @Then("the username field should be displayed")
        public void usernameFieldShouldBeDisplayed() {
            assertTrue(context.getLoginPage().isUsernameDisplayed());
        }

        @Then("the password field should be displayed")
        public void passwordFieldShouldBeDisplayed() {
            assertTrue(context.getLoginPage().isPasswordDisplayed());
        }*/
    //}


    /*//IOSLoginPage IOS_loginPage = new IOSLoginPage(getDriver());
    LoginPages Android_loginPage = new LoginPages(getDriver());

    @Given("login to the android application with valid credentials")
        public void login_to_the_Android_application_with_valid_credentials() throws InterruptedException {
        Android_loginPage.login_to_the_Android_application_with_valid_credentials();

    }

    @Given("login to the ios application with valid credentials")
    public void login_to_the_Survey_application_with_valid_credentials() throws InterruptedException {
        Android_loginPage.login_to_the_IOS_application_with_valid_credentials();

    }*/
}
