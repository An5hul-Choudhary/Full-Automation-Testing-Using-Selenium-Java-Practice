import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesAssignment {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Outer frames on the page
        int totalFramesOnOuter = driver.findElements(By.tagName("frame")).size();
        System.out.println("Outer frames on the page is " + totalFramesOnOuter);  // frame_top and frame_bottom

        //frame-top -> outer frame
        WebElement outerFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(outerFrame);

        //Nested frames count inside the outerframe
        int totalFramesInInner = driver.findElements(By.tagName("frame")).size();
        System.out.println("Nested frames count inside the outerframe is " + totalFramesInInner);  // frame_top and frame_bottom

        // middleframe is nested inside outerframe
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(middleFrame);

        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().defaultContent();


    }

}
