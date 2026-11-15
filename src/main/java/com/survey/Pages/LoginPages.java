/*
package com.survey.Pages;

import com.survey.Utilities.Comman_Methods;
import com.survey.Utilities.MyTestResults;
import com.survey.Utilities.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Map;

import static com.survey.Utilities.AppiumDriverManager.getDriver;
import static com.survey.Utilities.Comman_Methods.isDisplayed_dropdown_menu;


public class LoginPages {
    public WaitUtils waitUtils;
    //protected final AppiumDriver driver;

MyTestResults myTestResults = new MyTestResults();
public Logger logger = Logger.getLogger(LoginPages.class);

//IOS page objects
@iOSXCUITFindBy(id = "test-Username")
private WebElement userName_text_box;

@iOSXCUITFindBy(id = "test-Password")
private WebElement password_text_box;

@iOSXCUITFindBy(id = "test-LOGIN")
private WebElement login_button;

// Android page objects
@AndroidFindBy(id = "android:id/text1")
private WebElement Country_drop_down;

@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
private WebElement your_Name_text_box;

@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
private WebElement lets_go_button;

@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]")
private WebElement product_AddCart_button;

@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
private WebElement appbar_btn_cart_button;

@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
private WebElement product_checkbox;

@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
private WebElement proceed_button;




//constructor
    public LoginPages(AppiumDriver driver)
    {
        //this.driver=driver;
        //driver= AppiumDriverManager.getDriver();
//        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(15)), this);
    }

//    String username="standard_user";
//    String password="secret_sauce";
    public void login_to_the_IOS_application_with_valid_credentials() throws InterruptedException {
        //scrollDown();
        //System.out.println("driver : "+ driver);
        System.out.println("getDriver "+ getDriver());
        Comman_Methods.enter_text(userName_text_box, "standard_user");
        Comman_Methods.enter_text(password_text_box, "secret_sauce");
        Comman_Methods.click_button(login_button);
    }
//    public static void scrollDown(IOSDriver driver) {
public static void scrollDown() {
        getDriver().executeScript("mobile: scroll",
                Map.of("direction", "down"));
    }

    public void login_to_the_Android_application_with_valid_credentials() throws InterruptedException {
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



    }

}
*/
