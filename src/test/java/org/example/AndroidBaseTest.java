package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AndroidBaseTest {

    public AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("koushiPixel3a");
        //options.setChromedriverExecutable("C:\\Users\\koush\\Downloads\\chromedriver_win32");
        //options.setApp("C:\\Users\\koush\\IdeaProjects\\AppiumQuickDemo\\src\\test\\java\\resourses\\ApiDemos-debug.apk");
        options.setApp("C:\\Users\\koush\\IdeaProjects\\AppiumQuickDemo\\src\\test\\java\\resourses\\General-Store.apk");

        //from java 20 and above version "URL class" is deprecated, so to avoid any errors we have to use URI("**").toURL()
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);


    }

    public void longPressAction(WebElement ele){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
                        "duration" ,2000)
        );
    }

    public void scrollToEnd(){
        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        }while(canScrollMore);
    }

    public void swipeAction(WebElement ele,String direction){
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
