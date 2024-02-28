package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Scanner;

public class Locators {

    public static void main(String[] args) throws InterruptedException {


                Scanner input = new Scanner(System.in);
                System.out.println("Enter the Server name in small (e.g. telus1030) ");
                String serverName = input.nextLine();
//
                WebDriverManager.edgedriver().setup();

                WebDriver driver1 = new EdgeDriver();
                driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

                // OPENING MAJESTIC AND CREATING THE ADDRESS
                driver1.get("http://" + serverName + ":4000");

                WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
                String xpathExpression = "//div[contains(@class,'file-item__Label-sc-1ufz9bh-2') and text()='create-Abbotsford-address-with-connectivity-tbapi.test.js']";

                try {
                    // Scroll to the element before clicking
                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
                    ((JavascriptExecutor) driver1).executeScript("arguments[0].scrollIntoView(true);", element);

                    // Wait for the element to become clickable and then click it
                    element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
                    element.click();
                } catch (org.openqa.selenium.TimeoutException e) {
                    System.out.println("The element was not clickable within the specified time.");
                    // Handle the exception accordingly, e.g., log the error, take a screenshot, or retry the action.
                }




        //  OPENING CSR PORTAL AND ENTERING THE ADDRESS
////           WebDriver driver = new ChromeDriver();
////         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        driver.get("http://"+ serverName +":6810/web/guest/home");
////        System.out.println("Title: " + driver.getTitle());
////        driver.findElement(By.cssSelector("div[id='btnExistsCustomer'] div[class='wiz-feature _calendar _small _check-availability js-btn-recolor']")).click();
////        driver.findElement(By.name("IDToken1")).sendKeys("csr");
////        driver.findElement(By.name("IDToken2")).sendKeys("netcracker");
////        driver.findElement(By.name("Login.Submit")).click();
//
///*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        System.out.println("Title : "+ driver.getCurrentUrl());
        System.out.println("Url : "+ driver.getCurrentUrl());

        driver.findElement(By.id("inputUsername")).sendKeys("Anshul");
        driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ansh");
        driver.findElement((By.cssSelector("input[placeholder='Email']"))).sendKeys("Ansh@msn.com");
        driver.findElement((By.cssSelector("input[placeholder='Email']:nth-child(3)"))).clear();
        driver.findElement(By.xpath("//input[@type = 'text'][2]")).sendKeys("Ansh@gmail.com");
        //driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9999999999");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8888888888");
        driver.findElement(By.className("reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.className("infoMsg")).getText());
        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Ansh");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] p")).getText());
        Assert.assertEquals((driver.findElement(By.cssSelector("div[class='login-container'] p")).getText()), "You are successfully logged in.");
        driver.close();





        // RelativeXpath //nav/div[2]/ul/li[7]/a
        //driver.get("https://rahulshettyacademy.com/");
        // Parent to child -> driver.findElement(By.xpath("//nav/div[2]/ul/li[7]/a")).click();
        // Parent to child to childs sibling -> driver.findElement(By.xpath("//nav/div[2]/ul/li[7]/a/following-sibling::li[1]")).click();
        // Parent to child and then child to parent -> driver.findElement(By.xpath("//nav/div[2]/ul/li[7]/a/parent::li/parent::ul/li[7]/a")).click();



    }

}
