import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginCredentials {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr535213");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AhatUte");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        driver.close();

    }
}
