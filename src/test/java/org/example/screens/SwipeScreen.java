package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
        AndroidElement[] elementsToCheck = { swipeScreenTitle, swipeScreenTextView };

        // Check if each element is visible
        for (AndroidElement element : elementsToCheck) {
            if (!element.isDisplayed()) {
                return false; // If any element is not visible, return false
            }
        }

        // Check if all carousel cards are visible
        for (AndroidElement carouselElement : carouselCards) {
            if (!carouselElement.isDisplayed()) {
                return false; // If any card is not visible, return false
            }
        }

        // Check if all carousel points are visible
        for (AndroidElement carouselElement : carouselPoints) {
            if (!carouselElement.isDisplayed()) {
                return false; // If any point is not visible, return false
            }
        }

        return true; // If all elements are visible, return true
    }

    public boolean swipeCarousel(int n) {
        click(carouselPoints.get(n)); // Click on the specified carousel point
        carouselCards = driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='Carousel']/android.view.ViewGroup/android.view.ViewGroup"));

        // Check if there are enough cards in the carousel
        if (carouselCards.size() < n) {
            return false;
        }

        // Check if the size of the selected point is different from the next point's size
        if (carouselPoints.get(n).getSize().equals(carouselPoints.get(n + 1).getSize())) {
            return false;
        }

        return true; // If the swipe was successful, return true
    }
}
