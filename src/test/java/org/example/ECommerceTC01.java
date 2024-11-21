package org.example;


import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ECommerceTC01 extends AndroidBaseTest {

    //filling the form and validating the error msg
    @Test
    public void FillForm() throws InterruptedException {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("koushik");
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);

    }

    //in appium to handle toasts we have a tag name -> android.widget.Toast and this tag have a mandataory attribute -> "name"

    @Test
    public void FillFormErrorValidation() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("");
        driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMsg = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMsg, "Please enter your name");
        Thread.sleep(2000);
    }
}
