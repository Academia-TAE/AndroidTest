package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.util.screens.BaseScreen;

public class FormsScreen extends BaseScreen {

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
        AndroidElement[] elementos = {inputField, textResultTextView, switchElement, dropdownEditText, activeButtonTextView, inactiveButtonTextView};

        for (AndroidElement elemento : elementos) {
            if (!elemento.isDisplayed()) {
                return false; // Si un elemento no está visible, retorna false
            }
        }

        return true; // Si todos los elementos están visibles, retorna true
    }


}
