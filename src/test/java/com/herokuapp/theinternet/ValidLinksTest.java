package com.herokuapp.theinternet;

import com.herokuapp.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ValidLinksTest {

    WebDriver driver = new DriverFactory().initializeDriver();

@BeforeMethod
public void setUp(){
    driver.get("http://the-internet.herokuapp.com/login");
    driver.manage().window().maximize();


}

    @Test
    public void validateAllLinksTest(){

        String expectedURL = "http://the-internet.herokuapp.com/login";
        driver.findElement(By.id("username")).sendKeys("tommith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
     //   Assert.assertTrue(driver.getCurrentUrl().equals(expectedURL));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link: links){
            String url = link.getAttribute("href");
            System.out.println(url);
            verifyLink(url);

        }
        driver.quit();
    }

    public static void verifyLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();


            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }

}
