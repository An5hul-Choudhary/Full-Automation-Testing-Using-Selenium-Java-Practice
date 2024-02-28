import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ScrollingInBrowser {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scroll(0,500)");
        jsExec.executeScript("document.querySelector('.tableFixHead').scrollTop=50");

        List<WebElement> col = driver.findElements(By.cssSelector("#product td:nth-child(4)"));
        int sum=0;
        for (int i=0;i< col.size();i++) {
            sum = sum +Integer.parseInt(col.get(i).getText());
        }

        System.out.println(sum);

        if(sum == Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ")[3])){
            System.out.println("Sum is matching");
        }
        else{
            System.out.println("Something is fishy");
        }
    }
}
