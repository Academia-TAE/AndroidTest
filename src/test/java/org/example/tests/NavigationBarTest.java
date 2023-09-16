package org.example.tests;

import junit.framework.Assert;
import org.example.screens.*;
import org.example.util.tests.BaseMobileTest;
import org.testng.annotations.Test;

public class NavigationBarTest extends BaseMobileTest {
    private  HomeScreen homeScreen;
    private WebviewScreen webviewScreen;
    private LoginScreen loginScreen;
    private SwipeScreen swipeScreen;
    private DragScreen dragScreen;
    private FormsScreen formsScreen;

    @Test
    public void HomeTest() {
        log.info("testOfVisibility");
        homeScreen = loadHomeScreen();
        Assert.assertTrue(homeScreen.verifyVisibility());
    }

    @Test(dependsOnMethods = "HomeTest")
    public void WebViewTest() {
        webviewScreen = homeScreen.goToWebScreen();
        Assert.assertTrue(webviewScreen.verifyVisibility());
    }

    @Test(dependsOnMethods = "WebViewTest")
    public void LoginTest() {
        loginScreen=webviewScreen.goToLoginScreen();
        Assert.assertTrue(loginScreen.verifyVisibility()); // Supongamos que la prueba es exitosa
    }

    @Test(dependsOnMethods = "LoginTest")
    public void FormsTest() {
        formsScreen=loginScreen.goToFormsScreen();
        Assert.assertTrue(formsScreen.verifyVisibility());
    }

    @Test(dependsOnMethods = "FormsTest")
    public void SwipeTest() {
        swipeScreen= formsScreen.goToSwipeScreen();
        Assert.assertTrue(swipeScreen.verifyVisibility());
    }

    @Test(dependsOnMethods = "SwipeTest")
    public void DragTest() {
        dragScreen=swipeScreen.goToDragScreen();
        Assert.assertTrue(dragScreen.verifyVisibility());
    }
}
