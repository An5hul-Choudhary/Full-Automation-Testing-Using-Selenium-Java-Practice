import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UrlChecking
{
    public static void main(String[] args) throws IOException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        SoftAssert a = new SoftAssert();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");


        List<WebElement> list = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(int i=0;i<list.size();i++){
            String url = list.get(i).getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            // Hard assertion -> execution will stop
            //Assert.assertTrue(responseCode<400, "The link with text "+ list.get(i).getText() + " is broken with code "+ responseCode);

            // Soft assertion -> execution will not stop
            a.assertTrue(responseCode<400, "The link with text "+ list.get(i).getText() + " is broken with code "+ responseCode);

//            System.out.println(responseCode);
//            if(responseCode>400){
//                System.out.println("Broken link is : " + url );
//                Assert.assertTrue(false);
//            }

        }
        a.assertAll();

        /*

        String url = driver.findElement(By.cssSelector("a[href*='soap']")).getAttribute("href");

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);


         */


    }


}
