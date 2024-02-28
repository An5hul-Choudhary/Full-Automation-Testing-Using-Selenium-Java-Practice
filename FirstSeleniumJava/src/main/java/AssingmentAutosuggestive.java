import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;

public class AssingmentAutosuggestive {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("uni");
        int i=1;
        while(i<8) {
            driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);

            i++;
        }
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        driver.findElement(By.cssSelector("#autocomplete")).click();
    }

}
