package org.example.util.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.touch.offset.PointOption;


import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import static java.lang.String.format;


import org.example.screens.*;
import org.example.util.CustomWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public abstract class BaseScreen {

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Webview']")
    public AndroidElement webwiewButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Login']")
    public AndroidElement loginButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Forms']")
    public AndroidElement formsButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Swipe']")
    public AndroidElement swipeButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Drag']")
    public AndroidElement dragButton;
    protected final AndroidDriver<AndroidElement> driver;

    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public WebviewScreen goToWebScreen() {
        click(webwiewButton);
        return new WebviewScreen(driver);
    }

    public LoginScreen goToLoginScreen() {
        click(loginButton);
        return new LoginScreen(driver);
    }

    public FormsScreen goToFormsScreen() {
        click(formsButton);
        return new FormsScreen(driver);
    }

    public SwipeScreen goToSwipeScreen() {
        click(swipeButton);
        return new SwipeScreen(driver);
    }

    public DragScreen goToDragScreen() {
        click(dragButton);
        return new DragScreen(driver);
    }

    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }
    public abstract boolean verifyVisibility();
}
