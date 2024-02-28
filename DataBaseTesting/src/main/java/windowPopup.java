import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class windowPopup {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","C:\\SeleniumUsingJava\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("http://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();

    }
}
