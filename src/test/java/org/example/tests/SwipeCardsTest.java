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
        log.info("SwipeTest"); // Logging a test description
        homeScreen = loadHomeScreen(); // Load the HomeScreen
        swipeScreen = homeScreen.goToSwipeScreen(); // Navigate to the SwipeScreen
        swipeScreen.verifyVisibility(); // Verify that SwipeScreen is visible
        Assert.assertTrue(swipeScreen.swipeCarousel(3)); // Swipe right and assert
        Assert.assertTrue(swipeScreen.swipeCarousel(2)); // Swipe left and assert
    }
}
