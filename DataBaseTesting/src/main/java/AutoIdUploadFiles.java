import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class AutoIdUploadFiles {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.edge.driver","C:\\SeleniumUsingJava\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_jpg");
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(3000);

        Runtime.getRuntime().exec("C:\\SeleniumUsingJava\\fileupload.exe");

    }
}

