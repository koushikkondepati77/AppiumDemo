package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assingment01 extends BaseTest{

    @Test
    public void clickAndScrollTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

        driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons2ultra")).click();

        boolean isAlertOn = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")).isDisplayed();

        Assert.assertTrue(isAlertOn);

        scrollToEnd();

        Thread.sleep(2000);

        driver.findElement(AppiumBy.id("android:id/button1")).click();

    }

    @Test
    public void clickInTheList() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

        driver.findElement(AppiumBy.id("io.appium.android.apis:id/select_button")).click();

        //locating 4th child when there is no unique locator
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[2]")).click();
        Thread.sleep(1000);
        String message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text, 'You selected: 0 , Command one']")).getText();

        Assert.assertEquals(message, "You selected: 0 , Command one");
    }

    @Test
    public void singleRadioClick() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        WebElement StreetView = driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView[@text,'Street view'])[4]"));
        StreetView.click();
        Thread.sleep(2000);
        boolean isStreetViewChecked = StreetView.isEnabled();
        Assert.assertTrue(isStreetViewChecked);
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }
}
