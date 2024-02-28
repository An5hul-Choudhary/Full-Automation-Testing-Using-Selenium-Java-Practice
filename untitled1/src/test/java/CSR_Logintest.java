import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.Scanner;


public class CSR_Logintest {

    @Test
    public void TriplePlay() throws InterruptedException {
        // Server Access

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the server number only e.g 1030 : ");
//        String server = scanner.nextLine();
//        System.out.println("Please provide the address: ");
//        String address = scanner.nextLine();
        String address = "9168725377413269573";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String ServerName = "http://telus" + "1053" + ".netcracker.com:6810";
        driver.get(ServerName);
        //driver.manage().window().setSize(new Dimension(1440,900));
        driver.manage().window().maximize();

        // CSR Login
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@id='btnExistsCustomer']//div[@class='wiz-feature _calendar _small _check-availability js-btn-recolor']")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#IDToken1")).sendKeys("csr");
        driver.findElement(By.cssSelector("#IDToken2")).sendKeys("netcracker");
        driver.findElement(By.cssSelector("input[value=' Log In ']")).click();

        // Address Check
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#linkCheckAddress")));
        driver.findElement(By.cssSelector("#linkCheckAddress")).click();

        // Address creation is not automated -> Need to work on this later

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#street-address-tab")));
        driver.findElement(By.cssSelector("#address")).sendKeys(address);

        // Wait for the dynamic dropdown to appear
        By dropdownOptionLocator = By.xpath("//ul[@id='ui-id-2']/li/a");
        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(dropdownOptionLocator));

        // Click on the desired option
        dropdownOption.click();

        driver.findElement(By.cssSelector("#checkAddressBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.color-green.button-med.js-fill-address-proceed")));
        driver.findElement(By.cssSelector(".button.color-green.button-med.js-fill-address-proceed")).click();

        // Customer Creation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstName']")));
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Ansh");

        // Generating Random String for lastname
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomLastName = new StringBuilder();
        Random random = new Random();

        // Generate a random length for the lastname (e.g., between 5 and 10 characters)
        int lastNameLength = random.nextInt(6) + 5;

        // Generate the random lastname
        for (int i = 0; i < lastNameLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomLastName.append(characters.charAt(randomIndex));
        }

        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(randomLastName);
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(randomLastName + "@mail.com");
        driver.findElement(By.xpath("//button[@class='button color-green button-width-tds js-create-btn']")).click();


        // Find and click the month dropdown to open the options
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-month-button")));
        WebElement monthDropdown = driver.findElement(By.id("select-month-button"));
        monthDropdown.click();

        // Wait for the dropdown options to appear
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='select-month-menu']//li[text()='Jan']")));
        driver.findElement(By.xpath("//ul[@id='select-month-menu']//li[text()='Jun']")).click();

        WebElement dayDropdown = driver.findElement(By.id("select-day-button"));
        dayDropdown.click();
        driver.findElement(By.xpath("//ul[@id='select-day-menu']//li[text()='30']")).click();

        WebElement yearDropdown = driver.findElement(By.id("select-year-button"));
        yearDropdown.click();
        driver.findElement(By.xpath("//ul[@id='select-year-menu']//li[text()='1999']")).click();

        WebElement provinceDropdown = driver.findElement(By.id("select-province-button"));
        provinceDropdown.click();
        driver.findElement(By.xpath("//ul[@id='select-province-menu']//li[text()='BC']")).click();

        driver.findElement(By.xpath("//button[@class='button color-green button-width-tds mobile-full-width jsContinueCreditApproval']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#healthCareCard")));
        driver.findElement(By.cssSelector("#healthCareCard")).click();
        driver.findElement(By.xpath("//input[@id='health_care_card']")).sendKeys("9999999999");
        driver.findElement(By.xpath("//span[@class='wiz-checkbox__label _font-sm wiz-checkbox__label_wrap']")).click();
        driver.findElement(By.xpath("//button[@class='button color-green button-width-tds mobile-full-width jsValidateCreditCheckInfo']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button color-green button-med jsCreditCheckNextButton']")));
        driver.findElement(By.xpath("//button[@class='button color-green button-med jsCreditCheckNextButton']")).click();


        //Select Page
        Thread.sleep(18000);

        //Selecting Internet
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//app-top-product)[1]")));
        driver.findElement(By.xpath("(//app-top-product)[1]")).click();
        Thread.sleep(1000);

        //Selecting TV
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//app-top-product)[2]")));
        driver.findElement(By.xpath("(//app-top-product)[2]")).click();
        Thread.sleep(1000);

        //Selecting HP
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//app-top-product)[3]")));
        driver.findElement(By.xpath("(//app-top-product)[3]")).click();

        // Scrolling down
        Thread.sleep(7000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h2[contains(text(),'Pick from these')]")));

        //Selecting the commitments
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='list__item']//span[contains(text(),'Save $20/mo on Internet for 24 months')]")));
        driver.findElement(By.xpath("//li[@class='list__item']//span[contains(text(),'Save $20/mo on Internet for 24 months')]")).click();

        //Selecting Internet 1G
        Thread.sleep(40000);
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h2[normalize-space()='Choose your Internet']")));
        Thread.sleep(22000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-offering__name' and contains(text(),'PureFibre Internet Gigabit')]")));
        driver.findElement(By.xpath("//div[@class='product-offering__name' and contains(text(),'PureFibre Internet Gigabit')]")).click();

        //Selecting TV
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//div[@class='product-offering-category'])[3]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='product-offering-category'])[3]")));
        driver.findElement(By.xpath("(//div[@class='product-offering-category'])[3]")).click();
        Thread.sleep(5000);

        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//div[@class='product-offering-vertical'])[1]")));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='product-offering-vertical'])[1]")));
        driver.findElement(By.xpath("(//div[@class='product-offering-vertical'])[1]")).click();


        //Selecting HP
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//app-product-offering-verical)[3]")));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//app-product-offering-verical)[3]")));
        driver.findElement(By.xpath("(//app-product-offering-verical)[3]")).click();
        Thread.sleep(5000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button _wider _next']")));
        driver.findElement(By.cssSelector(".button._wider._next")).click();
        Thread.sleep(10000);

        //Customize page HSIA
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button _wider _next']")));
        driver.findElement(By.xpath("//button[@class='button _wider _next']")).click();
        Thread.sleep(10000);

        //Customize page TV
        jse.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='conCateName']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='next']")));
        driver.findElement(By.xpath("//button[@id='next']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='proceed'])[2]")));
        driver.findElement(By.xpath("(//button[@id='proceed'])[2]")).click();
        Thread.sleep(10000);

        //Customize page HP
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//div[@class='wiz-feature__caption'][normalize-space()='No'])[1]")));
        driver.findElement(By.xpath("(//div[@class='wiz-feature__caption'][normalize-space()='No'])[1]")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='wiz-feature__caption'][normalize-space()='No'])[2]")));
        driver.findElement(By.xpath("(//div[@class='wiz-feature__caption'][normalize-space()='No'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='next']")));
        driver.findElement(By.xpath("//button[@id='next']")).click();
        Thread.sleep(10000);

        //HSIA Equipment page
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#next")));
        driver.findElement(By.cssSelector("#next")).click();
        Thread.sleep(5000);

        //TV Equipment page
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[contains(text(),'How many TVs')]")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@id='tv-quantity-button']"))));
        driver.findElement(By.xpath("//span[@id='tv-quantity-button']")).click();
        driver.findElement(By.xpath("//li[@id='ui-id-5']")).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#next")));
        driver.findElement(By.cssSelector("#next")).click();
        Thread.sleep(5000);

        //Add On equipment page
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button color-green quote-email js-delivery-method']")));
        driver.findElement(By.cssSelector("#next")).click();


        //Appointment page
        Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select-appointment__description-date-text' and contains(text(),'PureFibre Internet Gigabit')]")));
        jse.executeScript("window.scrollBy(0,3000)");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='calendar__body-td js-day ']")));
        driver.findElement(By.xpath("//div[@class='calendar__body-td js-day ']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'1 PM - 3 PM')]")));
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'1 PM - 3 PM')]")));
        driver.findElement(By.xpath("//div[contains(text(),'1 PM - 3 PM')]")).click();
        driver.findElement(By.cssSelector("#next")).click();


        //Contact Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#phoneNumber")));
        driver.findElement(By.cssSelector("#phoneNumber")).sendKeys("9999999999");
        driver.findElement(By.cssSelector("#next")).click();

        // Pick a date page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Please choose when to activate services:')]")));
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(), 'Please choose when to activate services:')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label/span[contains(text(), 'Appointment')]")));
        driver.findElement(By.xpath("//label/span[contains(text(), 'Appointment')]")).click();
        driver.findElement(By.cssSelector("#next")).click();

        // Review order
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#termsConditnsLbl")));
        jse.executeScript("window.scrollBy(0,3000)");
        driver.findElement(By.id("termsConditnsIcon")).click();
        driver.findElement(By.cssSelector("#next")).click();

        //Checkout TSS page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-value='no']")));
        jse.executeScript("window.scrollBy(0, 1000)");
        driver.findElement(By.xpath("//div[@data-value='no']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#next")).click();

        //Shipping Information page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[@for='last-name'])[2]")));
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//label[@for='last-name'])[2]")));
        driver.findElement(By.xpath("//input[@id='delivery-notes']")).sendKeys("Shipment");
        driver.findElement(By.xpath("//button[@id='shippingSaveContactButton']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#next")));
        driver.findElement(By.cssSelector("#next")).click();

        //Checkout Billing information page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='wiz-checkbox__icon'])[2]")));
        jse.executeScript("window.scrollBy(0, 600)");
        driver.findElement(By.xpath("(//i[@class='wiz-checkbox__icon'])[2]")).click();
        driver.findElement(By.cssSelector("#shippingSaveContactButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='link js-edit-link']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button color-green button-width-tds jsValidateAddress']")));
        jse.executeScript("window.scrollBy(0, 400)");
        driver.findElement(By.xpath("//button[@class='button color-green button-width-tds jsValidateAddress']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#next")));
        driver.findElement(By.cssSelector("#next")).click();

        // Order submitted
        Thread.sleep(20000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-result__header-title']")));
        System.out.println(driver.findElement(By.xpath("//div[@class='order-result__header-title']")).getText());
        driver.close();


    }


}
