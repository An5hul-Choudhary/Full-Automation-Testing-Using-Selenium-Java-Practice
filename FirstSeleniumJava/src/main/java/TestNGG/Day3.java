package TestNGG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

    @Parameters({"URL"})
    @Test
       public void webLoginCarLoan(String urlName) {
        System.out.println("WebLoginCar");
        System.out.println(urlName);
    }

    @Test(groups = "Smoke")
    public void mobileCarLoan(){
        System.out.println("MobileLoginCar");
    }

    @Test(dependsOnMethods = "webLoginCarLoan")
    public void LoginAPIcarLoan(){
        System.out.println("ApiLoginHome");
    }

    @BeforeSuite(groups = "Smoke")
    public void beforeSuite(){
        System.out.println("I am beforeSuite");
    }

    @BeforeMethod
    @Parameters({"testURL"})
    public void beforeMethod(String testLevelURL){
        System.out.println("I am beforeMethod");
        System.out.println(testLevelURL);

    }


    @Test(groups = "Smoke")
    public void mobileFireAlarm(){
        System.out.println("MobileFireAlarm");
    }
}
