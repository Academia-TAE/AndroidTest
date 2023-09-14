package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.example.util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class LoginScreen extends BaseScreen {

	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-LOGIN']/android.view.ViewGroup")
	private AndroidElement signInButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
	private AndroidElement emailTextBox;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-password']")
	private AndroidElement passwordTextBox;


	public void fillInLoginData(String email, String password) {
		sendKeys(emailTextBox, email);
		sendKeys(passwordTextBox, password);
		click(signInButton);
	}

	@Override
	public void alertControl() {
		// TODO Auto-generated method stub
	}
}
