import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownsSection {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement dropdownElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdownSelect = new Select(dropdownElement);

        dropdownSelect.selectByIndex(2);
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());
        dropdownSelect.selectByVisibleText("USD");
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());
        dropdownSelect.selectByValue("INR");
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());

    }
}
