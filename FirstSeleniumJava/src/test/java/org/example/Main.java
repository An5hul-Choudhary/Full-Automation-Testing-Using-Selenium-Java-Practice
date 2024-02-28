package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        // Invoking Browser

//        System.setProperty("webdriver.chrome.driver","C:\\SeleniumUsingJava\\chromedriver-win64\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://chat.openai.com/");
//        driver.getTitle();

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://chat.openai.com/");

        // Get and print the title of the web page
        String pageTitle = driver.getTitle();
        String pageUrl = driver.getCurrentUrl();
        System.out.println("Page Title: " + pageTitle);
        System.out.println("Page URL: " + pageUrl);
        driver.close();




    }
}