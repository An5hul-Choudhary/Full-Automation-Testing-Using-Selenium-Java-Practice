import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class LinksCountOnPage
{

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());

        //Find links count in header
        WebElement headerLinks = driver.findElement(By.tagName("header"));
        System.out.println("links count in header " + headerLinks.findElements(By.tagName("a")).size());

        //Find elements in footer sections
        WebElement footerSection = driver.findElement(By.id("gf-BIG"));
        System.out.println("elements in footer sections " + footerSection.findElements(By.tagName("a")).size());

        //Find count of links in first column of footer section
        WebElement linkInFirst = footerSection.findElement(By.tagName("td"));
        int totalLinkInFirst = linkInFirst.findElements(By.tagName("a")).size();
        System.out.println("count of links in first column of footer section " + totalLinkInFirst);

        for(int i=1;i<totalLinkInFirst;i++) {

            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

            linkInFirst.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);

        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
            while (it.hasNext()){

                System.out.println(driver.switchTo().window(it.next()).getTitle());
            }





    }

}
