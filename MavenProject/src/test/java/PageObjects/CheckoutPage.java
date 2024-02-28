package PageObjects;

import AbstractComponents.AbstractssComponentss;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractssComponentss {

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement country;

    By waitOn = By.cssSelector(".ta-results");

    public void setCountry(String countryName){
        country.sendKeys(countryName);
        waitForElement(waitOn);
    }

    @FindBy (css = "button span")
    List<WebElement> searchCountry;

    @FindBy (xpath = "//a[contains(text(),'Place Order')]")
    WebElement placeOrder;

    public SubmissionPage enterCountry(){
        searchCountry.stream().filter(ele -> ele.getText().equalsIgnoreCase("india")).findFirst().get().click();
        placeOrder.click();
        return new SubmissionPage(driver);
    }
}
