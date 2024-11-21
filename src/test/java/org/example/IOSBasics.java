package org.example;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest{

    @Test
    public void IOSBasicsTest(){
        //Xpath, classname, IOS, iosClasschain, IOSPredicateString, accessibilityId, id
        //xpath is very slow in IOS compared to android
        //xpath - xml language
        //iosClassChain is 80% looks like xpath syntax and also faster than xpath

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();



        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"));

        String message = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name BEGINSWITH[c] 'A message'")).getText();
        System.out.println(message);

        //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'"));
        //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();



        }

}
