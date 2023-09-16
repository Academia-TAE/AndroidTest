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

	private AndroidElement repeatPasswordEditText;
	private AndroidElement signUpButton;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
	private AndroidElement confirmation;

	@Override
	public boolean verifyVisibility() {
		AndroidElement[] elementos = {signUpViewButton, loginFormButton, biometricButtonTextView, emailTextBox, passwordTextBox};
		for (AndroidElement elemento : elementos) {
			if (!elemento.isDisplayed()) {
				return false; // Si un elemento no está visible, retorna false
			}
		}
		return true; // Si todos los elementos están visibles, retorna true
	}

	public String verifySuccessSignUp(){
		CustomWait wait = new CustomWait();
		wait.waitAndroidElementVisibility(driver,confirmation,5);
		return confirmation.getText();
	}

	public String verifySuccessLogin(){
		CustomWait wait = new CustomWait();
		wait.waitAndroidElementVisibility(driver,confirmation,5);
		return confirmation.getText();
	}

	public void changeToSignUp(){
		click(signUpViewButton);
		try{
			getSignUpElements();
		}catch (Exception e){};
	}

	public void fillInLoginData(String email, String password) {
		sendKeys(emailTextBox, email);
		sendKeys(passwordTextBox, password);
		click(loginFormButton);
	}

	public void signUpData(String email, String password) {
		sendKeys(emailTextBox, email);
		sendKeys(passwordTextBox, password);
		sendKeys(repeatPasswordEditText, password);
		click(signUpButton);
	}

	public void getSignUpElements(){
		repeatPasswordEditText=getRepeatPassword();
		signUpButton=getSignUpButton();
	}

	public AndroidElement findElementByXPath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public AndroidElement getRepeatPassword() {
		return findElementByXPath("//android.widget.EditText[@content-desc='input-repeat-password']");
	}

	public AndroidElement getSignUpButton() {
		return findElementByXPath("//android.view.ViewGroup[@content-desc='button-SIGN UP']//android.widget.TextView");
	}

}
