package org.example.tests;

import junit.framework.Assert;
import org.example.screens.*;
import org.example.util.tests.BaseMobileTest;
import org.testng.annotations.Test;

public class NavigationBarTest extends BaseMobileTest {
    private HomeScreen homeScreen;
    private WebviewScreen webviewScreen;
    private LoginScreen loginScreen;
    private SwipeScreen swipeScreen;
    private DragScreen dragScreen;
    private FormsScreen formsScreen;

    @Test
    public void HomeTest() {
        log.info("HomeTest"); // Logging a test description
        homeScreen = loadHomeScreen(); // Load the HomeScreen
        Assert.assertTrue(homeScreen.verifyVisibility()); // Verify HomeScreen visibility
    }

    @Test(dependsOnMethods = "HomeTest")
    public void WebViewTest() {
        log.info("WebViewTest"); // Logging a test description
        webviewScreen = homeScreen.goToWebScreen(); // Navigate to the WebviewScreen
        Assert.assertTrue(webviewScreen.verifyVisibility()); // Verify WebviewScreen visibility
    }

    @Test(dependsOnMethods = "WebViewTest")
    public void LoginTest() {
        log.info("LoginTest"); // Logging a test description
        loginScreen = webviewScreen.goToLoginScreen(); // Navigate to the LoginScreen
        Assert.assertTrue(loginScreen.verifyVisibility()); // Verify LoginScreen visibility
        // Assuming the test is successful, but you can add more assertions here
    }

    @Test(dependsOnMethods = "LoginTest")
    public void FormsTest() {
        log.info("FormsTest"); // Logging a test description
        formsScreen = loginScreen.goToFormsScreen(); // Navigate to the FormsScreen
        Assert.assertTrue(formsScreen.verifyVisibility()); // Verify FormsScreen visibility
    }

    @Test(dependsOnMethods = "FormsTest")
    public void SwipeTest() {
        log.info("SwipeTest"); // Logging a test description
        swipeScreen = formsScreen.goToSwipeScreen(); // Navigate to the SwipeScreen
        Assert.assertTrue(swipeScreen.verifyVisibility()); // Verify SwipeScreen visibility
    }

    @Test(dependsOnMethods = "SwipeTest")
    public void DragTest() {
        log.info("DragTest"); // Logging a test description
        dragScreen = swipeScreen.goToDragScreen(); // Navigate to the DragScreen
        Assert.assertTrue(dragScreen.verifyVisibility()); // Verify DragScreen visibility
    }
}
