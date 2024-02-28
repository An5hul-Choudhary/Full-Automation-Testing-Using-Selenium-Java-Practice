import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddingItemsIntoCartEcommerceApp {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise");


        String[] input = {"Mango", "Raspberry", "Walnuts", "Brocolli"};
        addItems(driver, input);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
    }

    public  static void addItems(WebDriver driver, String[] input) throws InterruptedException {

        List<WebElement> Veggies = driver.findElements(By.cssSelector("h4[class='product-name']"));
        int j = 0;
        for (int i = 0; i < Veggies.size(); i++) {
            String[] nameIs = Veggies.get(i).getText().split("-");
            String formattedName = nameIs[0].trim();
            List itemsNeededList = Arrays.asList(input);
            if (itemsNeededList.contains(formattedName)) {

                j++;

                //click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == input.length) {
                    break;
                }
            }
        }
    }
}
