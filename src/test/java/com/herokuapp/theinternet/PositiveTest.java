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
public class PositiveTest extends Base {

    public void loginTest(){
        locateURL("http://the-internet.herokuapp.com/login");

        sendKey(By.id("username"),   "tomsmith");
        sendKey(By.id("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@type='submit']"));
        String expectedURL = "http://the-internet.herokuapp.com/secure";
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        String actualMessage = getText(By.xpath("//div[@id='flash']"));
        String expectedMessage = "You logged into a secure area!";

        Assert.assertFalse(actualMessage.equals(expectedMessage));
        driver.quit();

    }
}
