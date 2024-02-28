package PageObjects;

import AbstractComponents.AbstractssComponentss;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends AbstractssComponentss {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(tagName = "h3")
    List<WebElement> cartItems;

    public boolean elementsOnCart(String productName){
        Boolean match = cartItems.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }
    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    WebElement checkoutbtn;

    public CheckoutPage checkOut(){
        checkoutbtn.click();
        return new CheckoutPage(driver);
    }
}
