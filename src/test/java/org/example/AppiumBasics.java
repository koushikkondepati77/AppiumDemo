package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppiumBasics {

    @Test
    public void AppiumTest() throws URISyntaxException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("koushikPixel3a");
        options.setApp("C:\\Users\\koush\\IdeaProjects\\AppiumQuickDemo\\src\\test\\java\\resourses\\ApiDemos-debug.apk");

        //from java 20 and above version "URL class" is deprecated, so to avoid any errors we have to use URI("**").toURL()
        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.quit();
    }
}
