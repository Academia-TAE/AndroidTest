package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.util.screens.BaseScreen;

import java.util.List;

public class DragScreen extends BaseScreen {

    // AndroidElement corresponding to the drag-drop screen title
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Drag-drop-screen']/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement dragDropScreenTitle;

    // List of AndroidElements for drop elements
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'drop-')]")
    private List<AndroidElement> dropElements;

    // List of AndroidElements for drag elements
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'drag-')]/android.widget.ImageView")
    private List<AndroidElement> dragElements;

    public DragScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public boolean verifyVisibility() {
        AndroidElement[] elementsToCheck = { dragDropScreenTitle };

        // Check if the drag-drop screen title is visible
        for (AndroidElement element : elementsToCheck) {
            if (!element.isDisplayed()) {
                return false; // If the title is not visible, return false
            }
        }

        // Check if all drag elements are visible
        for (AndroidElement dragElement : dragElements) {
            if (!dragElement.isDisplayed()) {
                return false; // If any drag element is not visible, return false
            }
        }

        // Check if all drop elements are visible
        for (AndroidElement dropElement : dropElements) {
            if (!dropElement.isDisplayed()) {
                return false; // If any drop element is not visible, return false
            }
        }

        return true; // If all elements are visible, return true
    }

}
