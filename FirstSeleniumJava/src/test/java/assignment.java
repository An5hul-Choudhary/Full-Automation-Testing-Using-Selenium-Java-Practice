import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignment {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']" )).sendKeys("Ansh");
        driver.findElement(By.name("email")).sendKeys("Ansh@mail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("ShivAnsh");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.xpath("(//select[@id='exampleFormControlSelect1'])[1]")).click();
        driver.findElement(By.xpath("(//select[@id='exampleFormControlSelect1'])[1]")).click();
        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.name("bday")).sendKeys("30-60-1999");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        String actual = driver.findElement(By.cssSelector(".alert-success")).getText().trim();
        System.out.println(actual);
        Assert.assertEquals(actual, "Success! The Form has been submitted successfully!.");

    }
}
