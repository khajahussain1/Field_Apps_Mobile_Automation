package com.survey.Pages;

import com.survey.MobileDrivers.AppiumDriverManager;
import com.survey.Utilities.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.survey.MobileDrivers.AppiumDriverManager.getDriver;


public class LoginPage {

    private AppiumDriver driver;

    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(accessibility = "test-Username")
    private WebElement usernameInput;

    @AndroidFindBy(accessibility = "test-Password")
    @iOSXCUITFindBy(accessibility = "test-Password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "test-LOGIN")
    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    @iOSXCUITFindBy(xpath = "homeTitle")
    private WebElement homeTitle;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(15)), this);
    }

    public void enterUsername(String username) throws InterruptedException {
        WaitUtils.VisibilityOfElement(usernameInput);
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) throws InterruptedException {
        WaitUtils.VisibilityOfElement(usernameInput);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() throws InterruptedException {
        WaitUtils.waitForElementClickable(loginButton);
        loginButton.click();
    }

    /*public boolean isHomeDisplayed() {
        try {
            return waitFor(homeTitle).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean isUsernameDisplayed() {
        return waitFor(usernameInput).isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        return waitFor(passwordInput).isDisplayed();
    }*/

//    private WebElement waitFor(WebElement element) {
//        return new WebDriverWait(getDriver(), Duration.ofSeconds(15))
//                .until(ExpectedConditions.visibilityOf(element));
//    }
}
