package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.example.util.CustomWait;
import org.example.util.screens.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class WebviewScreen extends BaseScreen {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.Button")
    public AndroidElement alertAd;
    public AndroidElement burgerMenu;
    public AndroidElement findButton;
    public AndroidElement bigBot;
    public AndroidElement principalText;
    public AndroidElement getStartedButton;
    public AndroidElement webdriverioButton;
    public AndroidElement viewOnGitHubButton;
    public AndroidElement watchOnYouTubeTextView;
    public AndroidElement floatBot;

    public WebviewScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public boolean verifyVisibility() {
        CustomWait customWait = new CustomWait();
        customWait.waitAndroidElementToBeClickable(driver, alertAd, customWait.NORMAL_WAIT_SECONDS);
        alertAd.click();
        getElements();
        AndroidElement[] elementos = {alertAd,burgerMenu, findButton, bigBot, principalText, getStartedButton, webdriverioButton, viewOnGitHubButton, watchOnYouTubeTextView, floatBot};
        for (AndroidElement elemento : elementos) {
            try{
                if (!elemento.isDisplayed()) {
                    return false; // Si un elemento no está visible, retorna false
                }
            }catch (Exception e){};
        }

        return true; // Si todos los elementos están visibles, retorna true
    }

    private void getElements() {
        burgerMenu=getBurgerMenu();
        findButton=getFindButton();
        bigBot=getBigBot();
        principalText=getPrincipalText();
        getStartedButton=getGetStartedButton();
        webdriverioButton=getWebdriverioButton();
        viewOnGitHubButton=getViewOnGitHubButton();
        watchOnYouTubeTextView=getWatchOnYouTubeTextView();
        floatBot=getFloatBot();

    }
    public AndroidElement findElementByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public AndroidElement getBurgerMenu() {
        return findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.Button");
    }

    public AndroidElement getFindButton() {
        return findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button");
    }

    public AndroidElement getBigBot() {
        return findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]");
    }

    public AndroidElement getPrincipalText() {
        return findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView");
    }

    public AndroidElement getGetStartedButton() {
        return findElementByXPath("//android.view.View[@content-desc='Get Started']");
    }

    public AndroidElement getWebdriverioButton() {
        return findElementByXPath("//android.view.View[@content-desc='Why WebdriverIO?']");
    }

    public AndroidElement getViewOnGitHubButton() {
        return findElementByXPath("//android.view.View[@content-desc='View on GitHub']");
    }

    public AndroidElement getWatchOnYouTubeTextView() {
        return findElementByXPath("//android.view.View[@content-desc='Watch on YouTube']/android.widget.TextView");
    }

    public AndroidElement getFloatBot() {
        return findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.Image");
    }


}
