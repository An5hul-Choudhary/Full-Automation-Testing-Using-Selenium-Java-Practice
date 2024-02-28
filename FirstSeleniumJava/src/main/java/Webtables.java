import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Webtables {

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();




        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");

        List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filterList = list.stream().filter(veggies -> veggies.getText().contains("Rice")).collect(Collectors.toList());

        List<WebElement> searchedlist = driver.findElements(By.xpath("//tr/td[1]"));

        if(searchedlist.size() == filterList.size()){
            System.out.println("Size is same");
        }


    }

}
