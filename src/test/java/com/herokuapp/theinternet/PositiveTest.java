package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PositiveTest {
    public void loginTest(){

        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedURL = "http://the-internet.herokuapp.com/secure";
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

        String actualMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String expectedMessage = "You logged into a secure area!";

       // Assert.assertTrue(actualMessage.equals(expectedMessage));
        driver.quit();
    }
}
