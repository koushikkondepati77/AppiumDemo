package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void ScrollGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //direct method by googles UiScrollable object (simple and straightForward)
        //when u want to scroll till that element
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        //WebElement ele = driver.findElement(AppiumBy.accessibilityId("WebView"));
        // when no prior element is known, and just want to scroll to end
        scrollToEnd();







    }

}
