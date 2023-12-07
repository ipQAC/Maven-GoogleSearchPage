package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static <WebDriver> void main (String[] args) throws InterruptedException {
        // System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        System.out.println("Page Title is " + driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement keyword = driver.findElement(By.name("q"));

        keyword.sendKeys("Selenium");

        keyword.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //driver.findElement(By.cssSelector(".DKV0Md")).click();
        driver.findElement(By.cssSelector("#rso > div:nth-child(3) > div > div > div.kb0PBd.cvP2Ce.jGGQ5e > div > div > span > a > h3")).click();

        System.out.println("User redirected to " + driver.getCurrentUrl());

        String expectedTitle = "Selenium";
        String actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)) {

            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.close();
    }
}

