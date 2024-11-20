package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MisceallanousAppiumActivities extends BaseTest{



    @Test
    public void WifiSettingsName() throws URISyntaxException, MalformedURLException, InterruptedException {

        //locators -> Xpath, css, accessibilityID, id, className, androidUIAutomator
        //tagName[@attribute='value'] -> common syntax for Xpath
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.setClipboardText("koushi wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElement(By.id("android:id/button1")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));



    }
}
