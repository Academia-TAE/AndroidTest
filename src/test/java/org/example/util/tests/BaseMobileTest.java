package org.example.util.tests;

import org.example.screens.HomeScreen;
import org.example.util.ConfigCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.log4testng.Logger;

public abstract class BaseMobileTest {

    protected HomeScreen homeScreen;
    protected static AndroidDriver<AndroidElement> driver;
    protected Logger log = Logger.getLogger(BaseMobileTest.class);

    protected void setUpStartApp() {
        homeScreen = new HomeScreen(getDriver());
    }

    @BeforeTest(alwaysRun = true)
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        setUpStartApp();
    }

    @AfterTest(alwaysRun = true)
    public void mobileApplicationEnd() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    protected HomeScreen loadHomeScreen() {
        return homeScreen;
    }
}
