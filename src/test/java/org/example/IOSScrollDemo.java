package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSScrollDemo extends IOSBaseTest{

   @Test
   public void IOSScrollTest() throws InterruptedException {

       WebElement WebViewEle = driver.findElement(AppiumBy.accessibilityId("Web View"));
       scrollToText(WebViewEle);
       WebViewEle.click();

       Thread.sleep(2000);

       driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name = 'UIKitCatalog']")).click();

       driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
       driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
       driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
       driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");
       String number = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
       Assert.assertEquals(number,"105");

   }


}
