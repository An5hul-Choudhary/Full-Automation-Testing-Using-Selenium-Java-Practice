import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Optional;

public class NetworkSpeed {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.addListener(Network.loadingFailed(),loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });

        devTools.send(Network.emulateNetworkConditions(true,3000, 10000,
                5000, Optional.of(ConnectionType.ETHERNET)));

        long startTime = System.currentTimeMillis();
        driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
        long endTime = System.currentTimeMillis();

        System.out.println("Total Time taken is " + (endTime-startTime));
    }

}
