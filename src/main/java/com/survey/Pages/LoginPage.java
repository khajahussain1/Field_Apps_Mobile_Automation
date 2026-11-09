package com.survey.Pages;

import com.survey.FielReader.JsonReader;
import com.survey.Utilities.Comman_Methods;
import com.survey.Utilities.MyTestResults;
import com.survey.Utilities.WaitUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class LoginPage extends Comman_Methods {
    public WaitUtils waitUtils;
    AppiumDriver driver;

MyTestResults myTestResults = new MyTestResults();
public Logger logger = Logger.getLogger(LoginPage.class);

//page objects
@FindBy(id = "test-Username")
WebElement userName_text_box;

@FindBy(id = "test-Password")
WebElement password_text_box;

@FindBy(id = "test-LOGIN")
WebElement login_button;

//constructor
    public LoginPage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void login_to_the_survey_application_with_valid_credentials() throws InterruptedException {
//        String username = JsonReader.readJsonvalue("validUsers", "username");
//        logger.info("validUsers"+username);
        //Comman_Methods.click_drop_down(survey);
        Comman_Methods.enter_text(userName_text_box, "standard_user");
        Comman_Methods.enter_text(password_text_box, "secret_sauce");
        Comman_Methods.click_button(login_button);

    }
}
