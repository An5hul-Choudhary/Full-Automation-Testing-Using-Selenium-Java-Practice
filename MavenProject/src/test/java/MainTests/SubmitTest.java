package MainTests;

import AbstractComponents.AbstractssComponentss;
import MainTests.TestComponents.BaseTest;
import PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

abstract class SubmitTest extends BaseTest {

    @Test(dataProvider = "getData")

    public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

//        String productName = "ZARA COAT 3";
//        String username = "clt3rodp8v@superblohey.com";
//        String password = "Aa@123456";

        ProductCatalogue productCatalogue = landingPage.loginCreds(input.get("username"), input.get("password"));

        List<WebElement> elements = productCatalogue.getList();

        productCatalogue.addProductToCart(input.get("productName"));
        CartPage cartPage = productCatalogue.gotoCart();

        Boolean match = cartPage.elementsOnCart(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.checkOut();

        checkoutPage.setCountry("Ind");
        SubmissionPage submissionPage = checkoutPage.enterCountry();

        String finalMessage = submissionPage.messageValidation();
        Assert.assertTrue(finalMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }


    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap((System.getProperty("user.dir") + "//src//test//java//MainTests//data//PurchaseOrder.json"));
        return  new Object[][] {{data.get(0)},{data.get(1)} };


          /*
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "clt3rodp8v@superblohey.com");
        map.put("password", "Aa@123456");
        map.put("productName", "ZARA COAT 3" );

        HashMap<String, String> map1 = new HashMap<>();
        map.put("username", "goltidikne@gufum.com");
        map.put("password", "Iamking@000");
        map.put("productName", "ADIDAS ORIGINAL" );

        return new Object[][] {{map}, {map1}};
         */
    }

}
