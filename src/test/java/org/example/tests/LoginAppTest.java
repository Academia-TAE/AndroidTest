package org.example.tests;

import org.example.screens.HomeScreen;
import org.example.screens.LoginScreen;
import org.example.util.tests.BaseMobileTest;
import org.testng.annotations.Test;
import org.springframework.context.annotation.Description;



public class LoginAppTest extends BaseMobileTest {

    /**
     * Verify something.
     */
    @Description(value = "test of something ID:0001")
    @Test
    public void testOfSomething() {
        log.info("testOfSomething");
        HomeScreen dashBoard = loadHomeScreen();
        LoginScreen login = dashBoard.goToLoginScreen();
        login.fillInLoginData("email", "password");
    }

}
