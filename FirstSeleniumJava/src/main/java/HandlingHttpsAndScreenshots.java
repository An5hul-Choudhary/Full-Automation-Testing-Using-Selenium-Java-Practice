import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class HandlingHttpsAndScreenshots {

    public static void main(String[] args) throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:port");
        options.setCapability("proxy", proxy);

       /*
       FirefoxOptions options1 = new FirefoxOptions();
        options1.setAcceptInsecureCerts(true);f

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1= new FirefoxDriver();

        driver1.get("https://expired.badssl.com/");
        System.out.println(driver1.getTitle());

        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\anch0721\\Desktop\\Selenium Screeshots\\Screenshot.png"));

    }

}
