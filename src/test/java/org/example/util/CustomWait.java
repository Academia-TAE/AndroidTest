package org.example.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
	// Durations in seconds for wait methods.
	public static final long MIN_WAIT_SECONDS = 1;
	public static final long SHORT_WAIT_SECONDS = 5;
	public static final long NORMAL_WAIT_SECONDS = 15;
	public static final long MEDIUM_WAIT_SECONDS = 40;
	public static final long LARGE_WAIT_SECONDS = 60;
	private static final int SECONDS_CONVERSION = 1000;

	/**
	 * Waits for an Android element to become visible.
	 *
	 * @param driver   The AndroidDriver instance.
	 * @param element  The AndroidElement to wait for.
	 * @param waitTime The maximum time to wait in seconds.
	 */
	public static void waitAndroidElementVisibility(AndroidDriver<AndroidElement> driver, AndroidElement element, long waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Waits for an Android element to become invisible.
	 *
	 * @param driver   The AndroidDriver instance.
	 * @param element  The AndroidElement to wait for.
	 * @param waitTime The maximum time to wait in seconds.
	 */
	public static void waitAndroidElementInvisibility(AndroidDriver<AndroidElement> driver, AndroidElement element, long waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Waits for an Android element to become clickable.
	 *
	 * @param driver   The AndroidDriver instance.
	 * @param element  The AndroidElement to wait for.
	 * @param waitTime The maximum time to wait in seconds.
	 */
	public static void waitAndroidElementToBeClickable(AndroidDriver<AndroidElement> driver, AndroidElement element, long waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Waits for the specified number of seconds.
	 *
	 * @param seconds The number of seconds to wait.
	 */
	public static void waitInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * SECONDS_CONVERSION);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
