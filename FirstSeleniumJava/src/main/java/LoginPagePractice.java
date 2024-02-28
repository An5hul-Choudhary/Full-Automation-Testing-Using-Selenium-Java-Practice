import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPagePractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        LoginPage(driver,explicitWait);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card /div /div /h4 /a[contains(text(),'Blackberry')]")));

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-footer'] /button"));

        for(int i=0;i<products.size();i++){
           products.get(i).click();
        }
        driver.findElement(By.partialLinkText("Checkout")).click();

    }

    public static void LoginPage(WebDriver driver, WebDriverWait explicitWait){
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        driver.findElement(By.xpath("//select[@class='form-control'] //option[contains(text(), 'Consultant')]")).click();
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }

}
