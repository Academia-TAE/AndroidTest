package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.example.util.screens.BaseScreen;


import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class HomeScreen extends BaseScreen {

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}



	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Login']")
	private AndroidElement loginButton;


	public LoginScreen goToLoginScreen() {
		alertControl();
		click(loginButton);
		return new LoginScreen(driver);
	}

	@Override
	public void alertControl() {

	}
}
