package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSSwipeDemo extends IOSBaseTest{

    @Test
    public void IOSSwipeTest(){

        //just Like package name in android, we use bundleId to identify the app in ios
        //working on in-built ios photos app to perform swipe action

        Map<String,String> params = new HashMap<>();
        params.put("bundleId","com.apple.mobileslideshow");

        driver.executeScript("mobile: launchApp", params);

        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'All photos'`]")).click();
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allPhotos.size());
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'All photos'`]")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();

        for(int i = 0;i<allPhotos.size();i++){
            Map<String,Object> params1 = new HashMap<String,Object>();
            params1.put("direction", "left");
            driver.executeScript("mobile: swipe", params1);
        }

        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();






    }
}
