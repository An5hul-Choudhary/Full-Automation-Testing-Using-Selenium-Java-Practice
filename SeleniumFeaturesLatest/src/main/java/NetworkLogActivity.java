import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Optional;

public class NetworkLogActivity {
    public static void main(String[] args) {


        EdgeDriver driver = new EdgeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent ->{

            Request request =  requestWillBeSent.getRequest();
            System.out.println(request.getUrl());

        });

        devTools.addListener(Network.responseReceived(), responseReceived -> {

            Response res= responseReceived.getResponse();
            System.out.println(res.getUrl());
            System.out.println(res.getStatus());

        });

        driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@routerlink='/library']")).click();


    }

}
