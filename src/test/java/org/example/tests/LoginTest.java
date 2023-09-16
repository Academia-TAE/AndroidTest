package org.example.tests;

import junit.framework.Assert;
import org.example.screens.HomeScreen;
import org.example.screens.LoginScreen;
import org.example.util.tests.BaseMobileTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseMobileTest {
    private HomeScreen homeScreen;
    private LoginScreen loginScreen;
    @Test
    public void SignTest() {
        log.info("LoginTest");
        homeScreen = loadHomeScreen();
        loginScreen = homeScreen.goToLoginScreen();
        loginScreen.fillInLoginData("jesus@gmail.corp","Trasla7474");
        Assert.assertEquals("Success",loginScreen.verifySuccessLogin());
    }
}
