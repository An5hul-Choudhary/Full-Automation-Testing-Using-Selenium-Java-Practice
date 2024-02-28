import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.tracing.model.TraceConfig;

import java.lang.ref.SoftReference;
import java.time.Duration;

public class UsingMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String passwordIs = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//input[@id= 'inputUsername']")).sendKeys("Ansh");
        driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(passwordIs);
        driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
        driver.findElement(By.className("submit")).click();
        Thread.sleep(1000);

        System.out.println( driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
        System.out.println("Congratulations: " + driver.findElement(By.cssSelector("div[class='login-container'] p")).getText());
        driver.close();

    }

    public static String getPassword(WebDriver driver ) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("reset-pwd-btn")).click();
        String message = driver.findElement(By.className("infoMsg")).getText();
        String[] messageArray = message.split("'");
        String password = messageArray[1];
        return password;

    }

}
