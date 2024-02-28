import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.openqa.selenium.devtools.v85.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v85.network.model.ErrorReason;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetworkRequestFailure {

    public static void main(String[] args) {


        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Optional<List<RequestPattern>> patterns;
        patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),
                Optional.empty(), Optional.empty())));
        devTools.send(Fetch.enable(patterns,Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request -> {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });

        driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();

    }
}
