import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AutoSuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class = 'ui-menu-item'] a"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("INDIA")) {
                option.click();
                break;
            }
        }

        int checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        System.out.println("Total checkboxes on the page are: " + checkboxes);
        Assert.assertEquals(checkboxes, 6);
        System.out.println("Hello");


//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//
//        driver.findElement(By.id("checkBoxOption1")).click();
//        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
//
//        driver.findElement(By.id("checkBoxOption1")).click();
//        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
//
//        int count = driver.findElements(By.cssSelector("input[type='checkbox']")).size();


        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_view_date1']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();


        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("Calendar 2 is disabled");
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }


    }

}
