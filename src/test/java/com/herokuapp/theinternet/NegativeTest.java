package com.herokuapp.theinternet;

import base.Base;
import com.herokuapp.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NegativeTest extends Base {

    public void loginTest() {

        locateURL("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        sendKey(By.id("username"),"tommith");
        sendKey(By.id("password"),"SuperSecretPassword!");
         clickOnElement(By.xpath("//button[@type='submit']"));
        String expectedURL = "http://the-internet.herokuapp.com/login";
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String actualMessage = getText(By.xpath("//div[@id='flash']"));
        String expectedMessage = "Your username is invalid!";
        Assert.assertFalse(actualMessage.equals(expectedMessage));
        driver.quit();
    }
}