package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSlider extends IOSBaseTest{

   @Test
   public void IOSSliderTest(){
       //we need TestApp 3.app file
       WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementtypeSlider[`label == 'AppElem'`]"));
       slider.sendKeys("1%");
       System.out.println(slider.getAttribute("value"));
       Assert.assertEquals(slider.getAttribute("value"),"100%");
    }


}
