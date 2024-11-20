package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MisceallanousAppiumActions extends BaseTest{

    //App Package and App Activity
    //adb shell dumpsys window | grep -E 'mCurrentFocus'  -MAC
    //adb shell dumpsys window | findstr mCurrentFocus - Windows
    //mCurrentFocus=Window{72be09f u0 io.appium.android.apis/io.appium.android.apis.ApiDemos}

    @Test
    public void WifiSettingsName() throws URISyntaxException, MalformedURLException, InterruptedException {

        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
        ));

        //locators -> Xpath, css, accessibilityID, id, className, androidUIAutomator
        //tagName[@attribute='value'] -> common syntax for Xpath
        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
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
