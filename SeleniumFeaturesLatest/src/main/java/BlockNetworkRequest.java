import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Optional;

public class BlockNetworkRequest {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

        driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("a[role='button']")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector("button[class='add-to-cart btn btn-default']")).click();
        System.out.println(driver.findElement(By.cssSelector(".sp")).getText());



    }
}
