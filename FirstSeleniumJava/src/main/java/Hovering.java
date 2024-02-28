import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Hovering {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions act = new Actions(driver);
        WebElement hover = driver.findElement(By.cssSelector("#js-link-box-en"));
        act.moveToElement(hover).contextClick().build().perform();
        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
        act.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("APIs").doubleClick().build().perform();


    }
}
