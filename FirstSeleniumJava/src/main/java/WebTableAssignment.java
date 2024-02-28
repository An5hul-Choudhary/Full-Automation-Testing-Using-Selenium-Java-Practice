import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableAssignment {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scroll(0,500)");

        System.out.println("Rows = " +  driver.findElements(By.cssSelector("div[class='left-align'] tr")).size());
        System.out.println("Columns = " + driver.findElements(By.cssSelector("div[class='left-align'] th")).size());

        System.out.println(driver.findElement(By.cssSelector("div[class='left-align'] tr:nth-child(3)")).getText());

        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("uni");
        List<WebElement> drop = driver.findElements(By.cssSelector(".ui-menu-item"));

        for(int i=0;i< drop.size();i++){
            if(drop.get(i).getText().contains("United States")){
                drop.get(i).click();
            }
        }


    }

}
