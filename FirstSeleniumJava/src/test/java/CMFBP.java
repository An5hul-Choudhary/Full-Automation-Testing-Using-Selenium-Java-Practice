import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CMFBP {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("http://telus1167.netcracker.com:6910/ncobject.jsp?id=9165077045140320620");
        driver.findElement(By.cssSelector("#user")).sendKeys("sysadm");
        driver.findElement(By.cssSelector("#pass")).sendKeys("netcracker");
        Thread.sleep(3000);
        driver.findElement(By.tagName("a")).click();

    }
}
