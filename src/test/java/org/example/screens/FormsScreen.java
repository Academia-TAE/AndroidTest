package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.util.screens.BaseScreen;

public class FormsScreen extends BaseScreen {

    // AndroidElements corresponding to UI elements
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='text-input']")
    private AndroidElement inputField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='input-text-result']")
    private AndroidElement textResultTextView;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc='switch']")
    private AndroidElement switchElement;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Dropdown']/android.view.ViewGroup/android.widget.EditText")
    private AndroidElement dropdownEditText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-Active']/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement activeButtonTextView;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-Inactive']/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement inactiveButtonTextView;

    public FormsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public boolean verifyVisibility() {
        AndroidElement[] elementsToCheck = { inputField, textResultTextView, switchElement, dropdownEditText, activeButtonTextView, inactiveButtonTextView };

        // Check if each element is visible
        for (AndroidElement element : elementsToCheck) {
            if (!element.isDisplayed()) {
                return false; // If any element is not visible, return false
            }
        }

        return true; // If all elements are visible, return true
    }
}
