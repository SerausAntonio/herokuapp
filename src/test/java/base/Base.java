package base;

import com.herokuapp.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public Base(){
        driver = DriverFactory.initializeDriver();

    }

    public void locateURL(String url){
        driver.get(url);

    }

    public void sendKey(By by, String inputTxt){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        wait.until((ExpectedConditions.elementToBeClickable(by))).sendKeys(inputTxt);

    }
    public void clickOnElement(By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        wait.until((ExpectedConditions.elementToBeClickable(by))).click();

    }

    public String getText(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );

       String text = wait.until((ExpectedConditions.elementToBeClickable(by))).getText();

       return text;
    }


}
