package com.survey.Pages;

import com.survey.FielReader.JsonReader;
import com.survey.Utilities.AppiumDriverManager;
import com.survey.Utilities.Comman_Methods;
import com.survey.Utilities.MyTestResults;
import com.survey.Utilities.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import java.util.Map;

import static com.survey.Utilities.AppiumDriverManager.getDriver;


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

// Android page objects
@FindBy(id = "android:id/text1")
WebElement Country_drop_down;

@FindBy(id = "com.androidsample.generalstore:id/nameField")
WebElement your_Name_text_box;

@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
WebElement lets_go_button;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")
    WebElement product_AddCart_button;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    WebElement appbar_btn_cart_button;

    @FindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
    WebElement product_checkbox;

    @FindBy(id = "com.androidsample.generalstore:id/btnProceed")
    WebElement proceed_button;




//constructor
    public LoginPage(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
//    public static void scrollDown(IOSDriver driver) {
public static void scrollDown() {
        getDriver().executeScript("mobile: scroll",
                Map.of("direction", "down"));
    }
    String username="standard_user";
    String password="secret_sauce";
    public void login_to_the_survey_application_with_valid_credentials() throws InterruptedException {
//        String username = JsonReader.readJsonvalue("validUsers", "username");
//        logger.info("validUsers"+username);

        if(isDisplayed_dropdown_menu(Country_drop_down))
        {
            Comman_Methods.click_dropdown_Domain(Country_drop_down);
            Comman_Methods.selectCountry("India");
            Comman_Methods.enter_text(your_Name_text_box, "Khaja Hussain");
            Comman_Methods.click_button(lets_go_button);
            Comman_Methods.click_button(product_AddCart_button);
            Comman_Methods.click_button(appbar_btn_cart_button);
            Comman_Methods.click_button(product_checkbox);
            Comman_Methods.click_button(proceed_button);
        }
        //Comman_Methods.click_drop_down(survey);
//        scrollDown();
//        Comman_Methods.enter_text(userName_text_box, username);
//        Comman_Methods.enter_text(password_text_box, password);
//        Comman_Methods.click_button(login_button);


    }


}
