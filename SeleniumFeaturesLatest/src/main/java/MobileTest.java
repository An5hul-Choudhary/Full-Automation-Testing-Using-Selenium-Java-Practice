import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Optional;

public class MobileTest {
    public static void main(String[] args) throws InterruptedException {

        EdgeDriver driver = new EdgeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setDeviceMetricsOverride(600,1000,50, true,Optional.empty(),Optional.empty(),
                Optional.empty(),Optional.empty(),Optional.empty(),
                Optional.empty(),Optional.empty(),Optional.empty()));

        driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Library")).click();

    }

}
