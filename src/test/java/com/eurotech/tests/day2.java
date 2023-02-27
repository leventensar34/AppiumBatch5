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

public class day2 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void amazon() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        desiredCapabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");

        desiredCapabilities.setCapability("appActivity", "com.amazon.windowshop.home.HomeLauncherActivity");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        //Task
        //--> Open the Amazon app
        //-->Click skip sign in button
        //-->Search "Apple Watch"
        //-->Click "Apple Watch Series 7"
        //-->Verify that Results have existed

        Thread.sleep(2000);
        MobileElement skipSignBtn = driver.findElement(By.xpath("//*[@text='Skip sign in']"));
        skipSignBtn.click();

        MobileElement dontChangeBtn = driver.findElement(By.xpath("//*[@text='Don't Change']"));
        Thread.sleep(2000);
        dontChangeBtn.click();

        Thread.sleep(1000);
        MobileElement searchBox = driver.findElement(By.xpath("//*[@text='Search Amazon']"));
        Thread.sleep(2000);
        searchBox.click();
        searchBox.sendKeys("Apple Watch");

        MobileElement watch7 = driver.findElement(By.xpath("//*[@text='apple watch series 7']"));
        watch7.click();
        Thread.sleep(2000);

        MobileElement watch7Result = driver.findElement(By.xpath("//*[@text='Apple Watch Series 7 (GPS, 45MM) - Blue Aluminum Case with Abyss Blue Sport Band (Renewed Premium)']"));
        Thread.sleep(2000);
        Assert.assertTrue(watch7Result.getText().contains("Apple Watch Series 7"));

        //UI Automation
        //*[text='Skip sign in']

        //Mobil Testing
        //*[@text='Skip sign in']


        Thread.sleep(3000);
        driver.closeApp();

    }


}
