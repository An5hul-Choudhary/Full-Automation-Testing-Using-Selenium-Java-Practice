package AbstractComponents;

import PageObjects.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AbstractssComponentss {

    public WebDriver driver;

    public AbstractssComponentss(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForElement(By findBy){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

     public void waitForElementToDisappear(WebElement disappear) throws InterruptedException {
        Thread.sleep(1000);
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//         wait.until(ExpectedConditions.invisibilityOf(disappear));
     }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartSubmit;

    public CartPage gotoCart(){
        cartSubmit.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }



}
