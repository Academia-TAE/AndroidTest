package org.example.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.example.util.screens.BaseScreen;
import org.openqa.selenium.By;

import java.util.List;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Swipe-screen']/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement swipeScreenTitle;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Swipe-screen']/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement swipeScreenTextView;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])")
    private List<AndroidElement> carouselCards;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Carousel']/android.view.ViewGroup/android.view.ViewGroup")
    private List<AndroidElement> carouselPoints;

    public SwipeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public boolean verifyVisibility() {
        AndroidElement[] elementos = {swipeScreenTitle, swipeScreenTextView};
        for (AndroidElement elemento : elementos) {
            if (!elemento.isDisplayed()) {
                return false; // Si un elemento no está visible, retorna false
            }
        }

        for (AndroidElement carouselElement : carouselCards) {
            if (!carouselElement.isDisplayed()) {
                return false; // Si un elemento no está visible, retorna false
            }
        }

        for (AndroidElement carouselElement : carouselPoints) {
            if (!carouselElement.isDisplayed()) {
                return false; // Si un elemento no está visible, retorna false
            }
        }

        return true; // Si todos los elementos están visibles, retorna true
    }
    public boolean swipeCarousel(int n) {
        click(carouselPoints.get(n));
        carouselCards=driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='Carousel']/android.view.ViewGroup/android.view.ViewGroup"));
        if(carouselCards.size()<n){
            return false;
        }
        if(carouselPoints.get(n).getSize().equals(carouselPoints.get(n+1).getSize())){
            return false;
        }
        return true;
    }
}
