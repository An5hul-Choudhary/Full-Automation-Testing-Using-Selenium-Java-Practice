import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;

public class CdpCommandsTest {

    public static void main(String[] args) throws InterruptedException {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();


        Map deviceMetrices = new HashMap();
        deviceMetrices.put("width",600);
        deviceMetrices.put("height",1000);
        deviceMetrices.put("deviceScaleFactor",60);
        deviceMetrices.put("mobile",true);
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrices);


        driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Library")).click();

    }
}
