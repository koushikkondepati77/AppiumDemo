package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {

    public AndroidDriver driver;

    @BeforeClass
    public void Configureappium() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("koushiPixel3a");
        options.setApp("C:\\Users\\koush\\IdeaProjects\\AppiumQuickDemo\\src\\test\\java\\resourses\\ApiDemos-debug.apk");

        //from java 20 and above version "URL class" is deprecated, so to avoid any errors we have to use URI("**").toURL()
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
