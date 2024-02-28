import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownLooping {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement dropdownElement = driver.findElement(By.id("divpaxinfo"));
        dropdownElement.click();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.id("spanAudlt")).getText());
        for(int i=1;i<5;i++){

            driver.findElement(By.id("hrefIncAdt")).click();

        }
        System.out.println(driver.findElement(By.id("spanAudlt")).getText());

        //<div id="divpaxinfo" class="paxinfo" xpath="1">1 Adult</div>
        //<span class="pax-add pax-enabled" id="hrefIncAdt" xpath="1">+</span>


    }
}
