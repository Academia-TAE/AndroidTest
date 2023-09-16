package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.util.screens.BaseScreen;

import java.util.List;

public class DragScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Drag-drop-screen']/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement dragDropScreenTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'drop-')]")
    private List<AndroidElement> dropElements;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'drag-')]/android.widget.ImageView")
    private List<AndroidElement> dragElements;

    public DragScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public boolean verifyVisibility() {
        AndroidElement[] elementos = {dragDropScreenTitle};

        // Verificar la visibilidad de todos los elementos en el arreglo
        for (AndroidElement elemento : elementos) {
            if (!elemento.isDisplayed()) {
                return false; // Si un elemento no está visible, retorna false
            }
        }

        for (AndroidElement dragElement : dragElements) {
            if (!dragElement.isDisplayed()) {
                return false; // Si un elemento no está visible, retorna false
            }
        }

        for (AndroidElement dropElement : dropElements) {
            if (!dropElement.isDisplayed()) {
                return false; // Si un elemento no está visible, retorna false
            }
        }

        return true; // Si todos los elementos están visibles, retorna true
    }

}
