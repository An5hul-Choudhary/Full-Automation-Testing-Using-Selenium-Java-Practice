import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Optional;

public class NetworkMocking {
    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        DevTools devTools= driver.getDevTools();
        devTools.createSession();

        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), requestPaused -> {

            if(requestPaused.getRequest().getUrl().contains("shetty")){
               String mockedUrl = requestPaused.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println(mockedUrl);

                devTools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.of(mockedUrl), Optional.ofNullable(requestPaused.getRequest().getMethod()),
                        requestPaused.getRequest().getPostData(),requestPaused.getResponseHeaders()));
            }
            else {
                devTools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.of(requestPaused.getRequest().getUrl()), Optional.ofNullable(requestPaused.getRequest().getMethod()),
                        requestPaused.getRequest().getPostData(),requestPaused.getResponseHeaders()));
            }
            driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
            driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(driver.findElement(By.cssSelector("p")).getText());

        });
    }
}
