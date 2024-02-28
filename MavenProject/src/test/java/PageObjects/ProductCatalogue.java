package PageObjects;

import AbstractComponents.AbstractssComponentss;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductCatalogue extends AbstractssComponentss {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = ".mb-3")
    List<WebElement> elements;

    @FindBy(css = ".ng-animating")
            WebElement disappearElement;



    By products1 = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");


    public List<WebElement> getList(){
        waitForElement(products1);
        return elements;
    }

    public WebElement getProductByName(String productName){
        WebElement prod = getList().stream().filter(a->
                a.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    By toastContainer = By.cssSelector("#toast-container");


    public void addProductToCart(String productName) throws InterruptedException {
        WebElement produ = getProductByName(productName);
        produ.findElement(addToCart).click();
        waitForElement(toastContainer);
        waitForElementToDisappear(disappearElement);

    }


}
