package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Search {
    public  WebDriver driver;
    @BeforeTest
    public void setup(){
       System.setProperty("web-driver.chrome.driver","C:\\Users\\ipatel\\IdeaProjects\\GoogleSearchPage_mavenJava\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }
    @Test 
    public void teststeps() {

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

        if (actualTitle.contentEquals(expectedTitle))
        {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.close();
    }

}

