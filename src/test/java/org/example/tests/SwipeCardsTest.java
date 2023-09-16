package org.example.tests;

import junit.framework.Assert;
import org.example.screens.HomeScreen;
import org.example.screens.SwipeScreen;
import org.example.util.tests.BaseMobileTest;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseMobileTest {
    private HomeScreen homeScreen;
    private SwipeScreen swipeScreen;
    @Test
    public void SwipeTest() {
        log.info("SignUpTest");
        homeScreen = loadHomeScreen();
        swipeScreen = homeScreen.goToSwipeScreen();
        swipeScreen.verifyVisibility();
        Assert.assertTrue(swipeScreen.swipeCarousel(3));//Right
        Assert.assertTrue(swipeScreen.swipeCarousel(2));//Left
    }
}
