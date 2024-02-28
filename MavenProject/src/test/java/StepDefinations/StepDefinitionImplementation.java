package StepDefinations;

import MainTests.TestComponents.BaseTest;
import PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImplementation extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public SubmissionPage submissionPage;
    @Given("I landed on ecommerce page")
    public void I_landed_on_ecommerce_page() throws IOException {
        landingPage =launchApplication();
    }

    @Given("^I logged in with username (.+) and password (.+)$")
    public void I_logged_in_with_username_and_password(String username, String password){
        productCatalogue = landingPage.loginCreds(username, password);
    }

    @When("^i add the product (.+) to Cart$")
    public void i_add_prod_to_cart(String productName) throws InterruptedException {
        List<WebElement> elements = productCatalogue.getList();
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_and_submit(String productName){
        CartPage cartPage = productCatalogue.gotoCart();

        Boolean match = cartPage.elementsOnCart(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.checkOut();

        checkoutPage.setCountry("Ind");
        submissionPage = checkoutPage.enterCountry();
    }

    @Then("Verify {string} message is displayed on confirmation page.")
    public void Verify_message_in_confirmation_page(String string){
        String finalMessage = submissionPage.messageValidation();
        Assert.assertTrue(finalMessage.equalsIgnoreCase(string));
        driver.close();
    }

}
