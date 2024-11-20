package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropDemo extends BaseTest {

    @Test
    public void dragDropTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 651,
                "endY", 582
        ));

        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();

        Assert.assertEquals(result, "Dropped!");
    }
}
