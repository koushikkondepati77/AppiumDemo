package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends AndroidBaseTest {

    @Test
    public void swipeGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");

        WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));

        swipeAction(firstImage,"left");



        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
    }
}
