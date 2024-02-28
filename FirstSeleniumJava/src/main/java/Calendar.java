import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Calendar {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();


        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scroll(0,1500)");

//        jsExecutor.executeScript("arguments[0].value = arguments[1]",
//                driver.findElement(By.cssSelector("#form-field-travel_comp_date")),
//                "2023-12-05");
        driver.findElement(By.id("form-field-travel_comp_date")).click();

        //Month
        while(!driver.findElement(By.cssSelector(".cur-month")).getText().equals("December")){
            driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
        }
        List<WebElement> day = driver.findElements(By.cssSelector(".flatpickr-day"));

        for(int i=0;i<day.size();i++){
            if(day.get(i).getText().equals("5")){
                day.get(i).click();
                break;
            }
        }
    }

}
