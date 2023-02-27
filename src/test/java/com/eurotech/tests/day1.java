package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //1.yol
        // desiredCapabilities.setCapability("platformName","Android");

        //2.yol
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        //set Application' package name
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");


        //set Application Activity name
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        //2+3=5

        MobileElement digit2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement digit3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement plus = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));
        MobileElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        MobileElement mul = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));

        digit2.click();
        plus.click();
        digit3.click();
        equal.click();

        MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));

        String actualResult = result.getText();
        Assert.assertEquals("5", actualResult);

        Thread.sleep(2000);

        driver.closeApp();


        // 5*8=40


        getDigit(5).click();
        mul.click();
        getDigit(8).click();
        equal.click();
        actualResult=result.getText();
        Assert.assertEquals("40",actualResult);

    }

    public MobileElement getDigit(int digit) {
        return driver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));

    }

}
