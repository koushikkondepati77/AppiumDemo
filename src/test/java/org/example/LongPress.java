package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends AndroidBaseTest {

    @Test
    public void LongPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc = \"Expandable Lists\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
//        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
//                        "duration" ,2000)
//        );
        longPressAction(ele);
        Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());

        Thread.sleep(2000);

    }
}
