package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

//java-client1.2.1版本用appiumDriver 2.2.0用AndroidDriver，以上版本会出错
public class CalculatorTest {
	
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "Coolpad8675-0x03a2b1f1");
//        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.id("com.android.calculator2:id/digit1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit5")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit9")).click();
        driver.findElement(By.id("com.android.calculator2:id/del")).click();
        driver.findElement(By.id("com.android.calculator2:id/plus")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit6")).click();
        driver.findElement(By.id("com.android.calculator2:id/equal")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/display")).getText();
        System.out.println(result);

        driver.quit();
    }

}