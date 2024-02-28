import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandless {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        //System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0].trim();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);

    }

}
