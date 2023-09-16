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
         log.info("SignUpTest");
         homeScreen = loadHomeScreen();
         loginScreen = homeScreen.goToLoginScreen();
         loginScreen.changeToSignUp();
         loginScreen.getSignUpElements();
         loginScreen.signUpData("jesus@gmail.corp","Trasla7474");
        Assert.assertEquals("Signed Up!",loginScreen.verifySuccessSignUp());
     }
}
