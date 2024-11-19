package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppiumBasics extends BaseTest{

    @Test
    public void WifiSettingsName() throws URISyntaxException, MalformedURLException {



        //locators -> xpath, css, accessibilityID,
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        


    }
}
