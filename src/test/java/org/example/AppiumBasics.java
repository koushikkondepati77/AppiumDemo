package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppiumBasics extends AndroidBaseTest{

    @Test
    public void WifiSettingsName() throws URISyntaxException, MalformedURLException {

        //locators -> Xpath, css, accessibilityID, id, className, androidUIAutomator
        //tagName[@attribute='value'] -> common syntax for Xpath
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("koushi wifi");
        driver.findElement(By.id("android:id/button1")).click();



    }
}
