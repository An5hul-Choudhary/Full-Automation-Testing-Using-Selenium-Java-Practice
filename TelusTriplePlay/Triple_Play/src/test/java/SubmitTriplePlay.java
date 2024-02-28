import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitTriplePlay {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://telus1030.netcracker.com:4000/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'file-item__Label-sc-1ufz9bh-2 iqLDeh')][normalize-space()='create-Abbotsford-address-without-connectivity-tbapi.test.js']")));
        driver.findElement(By.xpath("//div[contains(@class,'file-item__Label-sc-1ufz9bh-2 iqLDeh')][normalize-space()='create-Abbotsford-address-without-connectivity-tbapi.test.js']")).click();


        String userName = "csr";
        String passWord = "netcracker";

        driver.switchTo().window("http://telus1030.netcracker.com:6810/");

        driver.findElement(By.id("btnExistsCustomer")).click();
        driver.findElement(By.id("IDToken1")).sendKeys(userName);
        driver.findElement(By.id("IDToken2")).sendKeys(passWord);
        driver.findElement(By.cssSelector("[value=' Log In ']")).click();
        driver.findElement(By.id("linkCheckAddress")).click();

    }

}
