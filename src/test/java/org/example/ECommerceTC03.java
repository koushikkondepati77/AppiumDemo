package org.example;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ECommerceTC03 extends AndroidBaseTest {

   //Testcase dynamically selecting product by scanning list based on text
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
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

        List<WebElement> productPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        int productCount =productPrices.size();
        Double sum = 0.0;
        for(int i=0;i<productCount;i++){
            String amountString = productPrices.get(i).getText();
            //$160.97
            sum += getFormattedAmount(amountString);



        }

        String totalAmountString = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double totalAmount = getFormattedAmount(totalAmountString);

        Assert.assertEquals(sum,totalAmount);

        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        WebElement termsElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
//        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//                ImmutableMap.of("elementId",((RemoteWebElement) termsElement).getId()),
//                "duration","2000");

        longPressAction(termsElement);
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();



        


    }


}
