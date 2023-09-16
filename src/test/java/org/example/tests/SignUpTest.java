package org.example.tests;

import junit.framework.Assert;
import org.example.screens.HomeScreen;
import org.example.screens.LoginScreen;
import org.example.screens.WebviewScreen;
import org.example.util.tests.BaseMobileTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseMobileTest {
    private HomeScreen homeScreen;
    private LoginScreen loginScreen;

    @Test
    public void SignTest() {
        log.info("SignUpTest"); // Logging a test description
        homeScreen = loadHomeScreen(); // Load the HomeScreen
        loginScreen = homeScreen.goToLoginScreen(); // Navigate to the LoginScreen
        loginScreen.changeToSignUp(); // Switch to the Sign-Up mode
        loginScreen.getSignUpElements(); // Get the Sign-Up elements
        loginScreen.signUpData("jesus@gmail.corp", "Trasla7474"); // Enter Sign-Up data
        Assert.assertEquals("Signed Up!", loginScreen.verifySuccessSignUp()); // Verify successful Sign-Up
    }
}
