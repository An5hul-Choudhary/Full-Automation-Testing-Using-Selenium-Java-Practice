import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;


public class FluentWaiting<W extends SearchContext> {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();


//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();


        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply( WebDriver driver){
                if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
                    return  driver.findElement(By.cssSelector("[id='finish'] h4"));
                }
                else{
                    return null;
                }
            }

        });

        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());


    }

}
