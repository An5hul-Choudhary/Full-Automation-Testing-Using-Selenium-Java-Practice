import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesChapter {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        WebElement frameIs = driver.findElement(By.cssSelector(".demo-frame"));

        // To check how many frames are present
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //driver.switchTo().frame(0);    -> we can use either by index or by webElement
        driver.switchTo().frame(frameIs);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions act = new Actions(driver);
        act.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();


    }

}
