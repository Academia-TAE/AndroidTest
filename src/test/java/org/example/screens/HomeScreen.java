package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.example.util.screens.BaseScreen;


import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class HomeScreen extends BaseScreen {

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
		AndroidElement[] elementos = {robotImage, titleTextView, titleImageView, infoText, appleImage, androidImage, supportView};

		for (AndroidElement elemento : elementos) {
			if (!elemento.isDisplayed()) {
				return false; // Si un elemento no está visible, retorna false
			}
		}

		return true; // Si todos los elementos están visibles, retorna true
	}
}
