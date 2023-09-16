package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.example.util.CustomWait;
import org.example.util.screens.BaseScreen;
import org.openqa.selenium.By;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class LoginScreen extends BaseScreen {

	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// AndroidElements corresponding to UI elements
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-sign-up-container']/android.view.ViewGroup/android.widget.TextView")
	private AndroidElement signUpViewButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-LOGIN']/android.view.ViewGroup")
	private AndroidElement loginFormButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-biometric']/android.view.ViewGroup/android.widget.TextView")
	private AndroidElement biometricButtonTextView;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
	private AndroidElement emailTextBox;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-password']")
	private AndroidElement passwordTextBox;

	// Other elements used in the class
	private AndroidElement repeatPasswordEditText;
	private AndroidElement signUpButton;

	// Confirmation element
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
	private AndroidElement confirmation;

	@Override
	public boolean verifyVisibility() {
		AndroidElement[] elementsToCheck = { signUpViewButton, loginFormButton, biometricButtonTextView, emailTextBox, passwordTextBox };

		// Check if each element is visible
		for (AndroidElement element : elementsToCheck) {
			if (!element.isDisplayed()) {
				return false; // If any element is not visible, return false
			}
		}

		return true; // If all elements are visible, return true
	}

	// Methods to verify success messages
	public String verifySuccessSignUp() {
		CustomWait wait = new CustomWait();
		wait.waitAndroidElementVisibility(driver, confirmation, 5);
		return confirmation.getText();
	}

	public String verifySuccessLogin() {
		CustomWait wait = new CustomWait();
		wait.waitAndroidElementVisibility(driver, confirmation, 5);
		return confirmation.getText();
	}

	// Method to switch to sign-up view
	public void changeToSignUp() {
		click(signUpViewButton);
		try {
			getSignUpElements();
		} catch (Exception e) { }
	}

	// Method to fill in login data and perform login
	public void fillInLoginData(String email, String password) {
		sendKeys(emailTextBox, email);
		sendKeys(passwordTextBox, password);
		click(loginFormButton);
	}

	// Method to fill in sign-up data and perform sign-up
	public void signUpData(String email, String password) {
		sendKeys(emailTextBox, email);
		sendKeys(passwordTextBox, password);
		sendKeys(repeatPasswordEditText, password);
		click(signUpButton);
	}

	// Helper method to get additional sign-up elements
	public void getSignUpElements() {
		repeatPasswordEditText = getRepeatPassword();
		signUpButton = getSignUpButton();
	}

	// Helper method to find an element by XPath
	public AndroidElement findElementByXPath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	// Methods to get specific elements
	public AndroidElement getRepeatPassword() {
		return findElementByXPath("//android.widget.EditText[@content-desc='input-repeat-password']");
	}

	public AndroidElement getSignUpButton() {
		return findElementByXPath("//android.view.ViewGroup[@content-desc='button-SIGN UP']//android.widget.TextView");
	}
}
