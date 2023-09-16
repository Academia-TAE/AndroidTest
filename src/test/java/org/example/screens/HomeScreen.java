package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.example.util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class HomeScreen extends BaseScreen {

	// AndroidElements corresponding to UI elements
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.ImageView[1]")
	public AndroidElement robotImage;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.TextView[1]")
	public AndroidElement titleTextView;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.ImageView[2]")
	public AndroidElement titleImageView;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.TextView[2]")
	public AndroidElement infoText;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.TextView[3]")
	public AndroidElement appleImage;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.TextView[4]")
	public AndroidElement androidImage;

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']/android.view.ViewGroup/android.widget.TextView[5]")
	public AndroidElement supportView;

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@Override
	public boolean verifyVisibility() {
		AndroidElement[] elementsToCheck = { robotImage, titleTextView, titleImageView, infoText, appleImage, androidImage, supportView };

		// Check if each element is visible
		for (AndroidElement element : elementsToCheck) {
			if (!element.isDisplayed()) {
				return false; // If any element is not visible, return false
			}
		}

		return true; // If all elements are visible, return true
	}
}
