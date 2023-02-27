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

public class Homework_Task {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");

        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        MobileElement digit5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement mul = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
        MobileElement digit8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
        MobileElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));

        digit5.click();
        mul.click();
        digit8.click();
        equal.click();

        MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));

        String actualResult= result.getText();

        Assert.assertEquals("40",actualResult);

        Thread.sleep(2000);
        driver.closeApp();

        //Task 91-74=17


    }
}
