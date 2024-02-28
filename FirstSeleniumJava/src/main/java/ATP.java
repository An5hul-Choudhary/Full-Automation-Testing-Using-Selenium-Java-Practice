import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;
import java.util.SortedMap;

public class ATP {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        Scanner input = new Scanner(System.in);

//        System.out.println("Enter username:");
//        String userName = input.nextLine();
//        System.out.println("Enter password");
//        String passWord = input.nextLine();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get("http://atp-telus-standalone.openshift.sdntest.netcracker.com:8082/project/a03d5c5c-0ad9-4496-a71e-89f2f69f4cf7/dashboard");
        driver.findElement(By.xpath("//atp-single-header/atp-aside-navigation[1]/ux-scroll[1]/div[1]/div[1]/div[1]/a[2]/*[1]")).click();

    }
}
